import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

public class SquareUI extends JPanel implements MouseListener {
	public static Color BLACK = new Color( 150, 85, 50 );
	public static Color WHITE = new Color( 223, 188, 148 );
	private Color color;
	public static int SIDE_SIZE = 75;
	int xCoord = -1;
	int yCoord = -1;
	
	public static Map<Integer, String> COL_MAP = new HashMap<>( );
	static
	{
		COL_MAP.put( 0, "a" );
		COL_MAP.put( 1, "b" );
		COL_MAP.put( 2, "c" );
		COL_MAP.put( 3, "d" );
		COL_MAP.put( 4, "e" );
		COL_MAP.put( 5, "f" );
		COL_MAP.put( 6, "g" );
		COL_MAP.put( 7, "h" );
	}
	
	public SquareUI( Color color, int xCoord, int yCoord )
	{
		super( );
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.color = color;
		this.setBackground( color );
		
		Dimension d = new Dimension( SIDE_SIZE, SIDE_SIZE );
		
		
		this.setSize( d );
		this.setMinimumSize( d );
		this.setMaximumSize( d );
		this.setLayout( new BorderLayout( ) );
		
		this.addMouseListener( this );
		
	}
	
	public Coordinate getCoordConverted( )
	{
		int row = 8 - xCoord;
		
		String col = COL_MAP.get( yCoord );
		
		return new Coordinate( col, row );
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + xCoord;
		result = prime * result + yCoord;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SquareUI other = (SquareUI) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (xCoord != other.xCoord)
			return false;
		if (yCoord != other.yCoord)
			return false;
		return true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		BoardUI boardUI = BoardUI.getInstance( );
		PieceUI pieceUI  = boardUI.getSelectedPieceUI( );
		if( pieceUI == null )
		{
			return;
		}
		Piece piece = pieceUI.getPiece( );
		Coordinate coord = this.getCoordConverted() ;
		if( !piece.isLegal( coord ) )
		{
			return;
		}
		boardUI.cleanSelectedPieceUI( );
		piece.setCoordinate( coord );
		Board.getInstance().changeTurn();
		pieceUI.setBorder( null );
		this.add( pieceUI );
		boardUI.repaint();
		
		Board.getInstance().isCheckMateOrStaleMate();
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
