import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ChessGame {

	
	public static void main(String [] args) {
		//List<Coordinate> a;
		//a = Board.getInstance().getAllEnemyMoves("white");
		//if(a.size() == 0) {
		//	System.out.println("empty");
		//}
		//for(int i = 0; i < a.size(); i++) {
		//	System.out.println(a.get(i));
		//}
		//a = Board.getInstance().getSquare(new Coordinate("c", 1)).getOccPiece().getLegalList();
		//if(a.size() == 0) {
		//	System.out.println("empty");
		//}
		//for(int i = 0; i < a.size(); i++) {
		//	System.out.println(a.get(i));
		//}
		
		SwingUtilities.invokeLater( new Runnable() {
			
			@Override
			public void run() {
				BoardUI boarUI = BoardUI.getInstance( );
				
				JFrame frame = new JFrame( "Chess Game" );
				
				frame.setLayout( new BorderLayout( 0, 0 ) );
				frame.add( BorderLayout.CENTER, boarUI );
				
				frame.pack( );
				frame.setResizable( false );
				frame.addWindowListener( new WindowAdapter() 
				{
					
					public void windowClosing( WindowEvent e )
					{
						System.exit( 0 );
					}
				});
				frame.setVisible( true );
			}
		});
	
	}

}
