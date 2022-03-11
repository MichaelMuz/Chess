import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class PieceUI extends JLabel implements MouseListener {

	private Piece piece;
	public PieceUI( Piece piece, ImageIcon imageIcon )
	{
		super( imageIcon );
		this.piece = piece;
		
		this.addMouseListener( this );
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
		
		PieceUI selectedPieceUI = BoardUI.getInstance().getSelectedPieceUI( );//green border
		Piece myPiece = this.getPiece( );
		//System.out.println(this.getPiece().getCoordinate());
		//if(Board.getInstance().kingInCheck("black")) {
			
			//System.out.println("black in check");
		//}
		//else if(Board.getInstance().kingInCheck("white")) {
		//	System.out.println("white in check");
		//}
		
		boolean bothWhite = myPiece.getColor().equals("white") && Board.getInstance().isWhiteTurn();
		boolean bothBlack = myPiece.getColor().equals("black") && !Board.getInstance().isWhiteTurn();
		
		if( selectedPieceUI == null)
		{
			BoardUI.getInstance().removeAllSelections( );
			if(bothWhite || bothBlack) {
				this.setBorder( BorderFactory.createLineBorder( Color.GREEN ));
			}
			
			return;
		}
		if( selectedPieceUI.equals( this ) )
		{
			this.setBorder( null );
			return;
		}
		
			
		Piece selectedPiece = selectedPieceUI.getPiece();// piece with green border
		// piece on which user clicked
		
		//if(!(bothWhite || bothBlack)) {
			
			
			
		//}
		
		if( selectedPiece.getColor().equals( myPiece.getColor( ) ) )
		{
			BoardUI.getInstance().removeAllSelections();
			this.setBorder(BorderFactory.createLineBorder( Color.GREEN ));
			return;
		}
		
		

		Coordinate myCoordinate = myPiece.getCoordinate( );
		if( !selectedPiece.isLegal( myCoordinate ) )
		{
			return;
		}
		
		SquareUI sqUI = BoardUI.getInstance().getSquareUI( myCoordinate );//SquareUI on which I clicked
		if( sqUI == null )
		{
			return;
		}
		
		Square square = Board.getInstance( ).getSquare( myCoordinate );//Square on which I clicked
		sqUI.remove( 0 );
		sqUI.add( selectedPieceUI );
		
		selectedPiece.setCoordinate( myCoordinate );
		square.occupy( selectedPiece );
		
		
		
		BoardUI.getInstance().removeAllSelections( );
		
		BoardUI.getInstance().repaint();
		
		Board.getInstance().changeTurn();
		
		
		Thread t = new Thread( )
		{
			public void run( )
			{
				SwingUtilities.invokeLater( new Runnable() {
					
					@Override
					public void run() {
						Board.getInstance().isCheckMateOrStaleMate();
						
					}
				});
			}
		};
		t.start();
		
		
		

		
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
	public Piece getPiece() {
		return piece;
	}
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public boolean equals( Object obj )
	{
		if( obj == null )
		{
			return false;
		}
		if( !( obj instanceof PieceUI ) )
		{
			return false;
		}
		
		PieceUI another = ( PieceUI )obj;
		
		if( !this.piece.equals( another.getPiece() ) )
		{
			return false;
		}
		return true;
	}
}
