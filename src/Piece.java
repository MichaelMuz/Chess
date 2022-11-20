import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
//import javax.swing.JLabel;
//import javax.swing.JPanel;

public abstract class Piece {

	private String color;
	
	private Coordinate spot;
	
	public Piece(String colo, Coordinate s) {
		color = colo;
		spot = s;
	}
		
	
	public boolean isLegal(Coordinate c) {
		List<Coordinate> coor = this.legalListWithoutChecks();
		for( Coordinate cor: coor )
		{
			if( cor.equals( c ) )
			{
				return true;
			}
		}
		

		return false;
	}
	
	
	


	
	public abstract List<Coordinate> getLegalList();
	
	
	public void setCoordinate(Coordinate c) {
		Board.getInstance().getSquare(spot).leave();
		spot = c;
		Board.getInstance().getSquare(spot).occupy(this);
		Board.getInstance().playSound();

	}
	
	public Coordinate getCoordinate() {
		return spot;
	}
		
	public String getColor() {
		
		return color;
		
	}
	

	public static Coordinate[] combine(Coordinate[] a, Coordinate[] b){
	        int length = a.length + b.length;
	        Coordinate[] result = new Coordinate[length];
	        System.arraycopy(a, 0, result, 0, a.length);
	        System.arraycopy(b, 0, result, a.length, b.length);
	        return result;
	    }
	
	
	public ImageIcon getIcon( )
	{
		BufferedImage img = null;
		try 
		{
			String imageName = "black".equals( color ) ? getBlackImageName( ) : getWhiteImageName( );
		    img = ImageIO.read(new File( "images/" + imageName ) );
		} 
		catch( IOException e ) 
		{
			e.printStackTrace( );
			
		}
		ImageIcon icon = new ImageIcon( img );
		return icon;
	}
	
	public PieceUI getUIRepresentation( )
	{

		ImageIcon icon = getIcon( );
		
		PieceUI label = new PieceUI( this, icon );
		label.setOpaque( false );
		return label;
	}
	
	public abstract String getBlackImageName( );
	public abstract String getWhiteImageName( );
	
	public boolean equals( Object obj )
	{
		if( obj == null )
		{
			return false;
		}
		if( !( obj instanceof Piece ) )
		{
			return false;
		}
		if( !this.getClass().equals(obj.getClass() ) )
		{
			return false;
		}
		Piece another = ( Piece )obj;
		
		if( !this.color.equals( another.getColor( ) ) )
		{
			return false;
		}
		
		if( !this.spot.equals( another.getCoordinate( ) ))
		{
			return false;
		}
		
		return true;
	}
	
	public List<Coordinate> legalListWithoutChecks() {
		String colo = "black";
		if(Board.getInstance().isWhiteTurn()) {
			colo = "white";
		}
		List<Coordinate> lis = this.getLegalList();
		for(int i = 0; i < lis.size(); i++) {
			Coordinate original = this.getCoordinate();
			Square s = Board.getInstance().getSquare(lis.get(i));
			Piece p = s.getOccPiece();
			//if(this instanceof King) {
				//if(Math.abs(original.getX().compareTo(lis.get(i).getX())) > 1 ) {
					//continue;
				//}
			//}
			if(p != null) {
				s.leave();
				Board.getInstance().getSquare(spot).leave();
				spot = lis.get(i);
				Board.getInstance().getSquare(spot).occupy(this);
				if(Board.getInstance().kingInCheck(colo)) {
					lis.remove(i);
					i--;
				}
				Board.getInstance().getSquare(spot).leave();
				spot = original;
				Board.getInstance().getSquare(spot).occupy(this);
				s.occupy(p);
				
			}
			else {
				Board.getInstance().getSquare(spot).leave();
				spot = lis.get(i);
				Board.getInstance().getSquare(spot).occupy(this);
				if(Board.getInstance().kingInCheck(colo)) {
					lis.remove(i);
					i--;
				}
				Board.getInstance().getSquare(spot).leave();
				spot = original;
				Board.getInstance().getSquare(spot).occupy(this);
			}
			
			
		}
		return lis;
	}


	
}
