//import java.awt.List;
//import java.awt.Menu;
import java.io.File;
import java.util.ArrayList;
//import java.util.stream.Stream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Board 
{
	private static final Board INSTANCE = new Board();
	private boolean whiteTurn;

	public Board()
	{
		a1.occupy(new Rook("white", new Coordinate("a", 1)));
		b1.occupy(new Knight("white", new Coordinate("b", 1)));
		c1.occupy(new Bishop("white", new Coordinate("c", 1)));
		d1.occupy(new Queen("white", new Coordinate("d", 1)));
		e1.occupy(new King("white", new Coordinate("e", 1)));
		f1.occupy(new Bishop("white", new Coordinate("f", 1)));
		g1.occupy(new Knight("white", new Coordinate("g", 1)));
		h1.occupy(new Rook("white", new Coordinate("h", 1)));

		a2.occupy(new Pawn("white", new Coordinate("a", 2)));
		b2.occupy(new Pawn("white", new Coordinate("b", 2)));
		c2.occupy(new Pawn("white", new Coordinate("c", 2)));
		d2.occupy(new Pawn("white", new Coordinate("d", 2)));
		e2.occupy(new Pawn("white", new Coordinate("e", 2)));
		f2.occupy(new Pawn("white", new Coordinate("f", 2)));
		g2.occupy(new Pawn("white", new Coordinate("g", 2)));
		h2.occupy(new Pawn("white", new Coordinate("h", 2)));

		a8.occupy(new Rook("black", new Coordinate("a", 8)));
		b8.occupy(new Knight("black", new Coordinate("b", 8)));
		c8.occupy(new Bishop("black", new Coordinate("c", 8)));
		d8.occupy(new Queen("black", new Coordinate("d", 8)));
		e8.occupy(new King("black", new Coordinate("e", 8)));
		f8.occupy(new Bishop("black", new Coordinate("f", 8)));
		g8.occupy(new Knight("black", new Coordinate("g", 8)));
		h8.occupy(new Rook("black", new Coordinate("h", 8)));

		a7.occupy(new Pawn("black", new Coordinate("a", 7)));
		b7.occupy(new Pawn("black", new Coordinate("b", 7)));
		c7.occupy(new Pawn("black", new Coordinate("c", 7)));
		d7.occupy(new Pawn("black", new Coordinate("d", 7)));
		e7.occupy(new Pawn("black", new Coordinate("e", 7)));
		f7.occupy(new Pawn("black", new Coordinate("f", 7)));
		g7.occupy(new Pawn("black", new Coordinate("g", 7)));
		h7.occupy(new Pawn("black", new Coordinate("h", 7)));

		whiteTurn = true;
	}

	public void isCheckMateOrStaleMate() 
	{

		String friendColor = "black";
		String enemyColor = "white";
		if (whiteTurn) {
			friendColor = "white";
			enemyColor = "black";
		}

		ArrayList<Piece> listt = this.getAllEnemyPieces(enemyColor);
		ArrayList<Coordinate> lis = new ArrayList<>();
		for (int i = 0; i < listt.size(); i++) {
			lis.addAll(listt.get(i).legalListWithoutChecks());
		}

		if (lis.size() == 0) {
			if (Board.getInstance().kingInCheck(friendColor))
			{

				BoardUI.getInstance().checkstaleMate(false);

			} else {

				BoardUI.getInstance().checkstaleMate(true);

			}
		}
	}

	public ArrayList<Coordinate> getAllEnemyMoves(String friendlyColor) 
	{
		ArrayList<Coordinate> lis = new ArrayList<>();
		Piece p;
		for (int i = 0; i < squares.length; i++) {
			p = squares[i].getOccPiece();
			if (p != null && !p.getColor().equals(friendlyColor)) 
			{

				lis.addAll(p.getLegalList());

			}
		}

		return lis;
	}

	public ArrayList<Piece> getAllEnemyPieces(String friendlyColor) 
	{
		ArrayList<Piece> lis = new ArrayList<>();
		Piece p;
		for (int i = 0; i < squares.length; i++) {
			p = squares[i].getOccPiece();
			if (p != null && !p.getColor().equals(friendlyColor)) 
			{

				lis.add(p);

			}
		}

		return lis;
	}

	public boolean isWhiteTurn() 
	{
		return whiteTurn;
	}

	public void changeTurn() 
	{
		whiteTurn = !whiteTurn;
	}

	public static Board getInstance() 
	{
		return INSTANCE;
	}

	public boolean kingInCheck(String color) 
	{

		Coordinate k = getKingCoordinate(color);

		if (k == null) {
			return true;// k = getKingCoordinate(color);
		}
		ArrayList<Coordinate> coor = this.getAllEnemyMoves(color);
		for (int i = 0; i < coor.size(); i++) {

			if (Board.getInstance().getSquare(coor.get(i)).getOccPiece() == null)
			{
				continue;
			}

			if (coor.get(i).equals(k)) {
				return true;
			}

		}

		return false;
	}

	/*
	 * public Square getSquare(Square x){ for(int i = 0;i < squares.length; i++) {
	 * if(x.equals(squares[i])) { return squares[i]; } } return null; }
	 */

	public void promotePawn(String color, Coordinate c) 
	{
		BoardUI.getInstance().promotePawn(color, c);
	}

	public void replacePawn(Piece piece) 
	{
		SquareUI ui = BoardUI.getInstance().getSquareUI(piece.getCoordinate());
		ui.remove(0);
		ui.add(new PieceUI(piece, piece.getIcon()));
		Square square = Board.getInstance().getSquare(piece.getCoordinate());
		square.leave();
		square.occupy(piece);
		BoardUI.getInstance().repaint();
		BoardUI.getInstance().revalidate();
		BoardUI.getInstance().repaint();
	}

	public Coordinate getKingCoordinate(String color) 
	{

		Piece p;
		for (int i = 0; i < squares.length; i++)
		{
			p = squares[i].getOccPiece();
			if (p != null && p.getColor().equals(color) && p instanceof King)
			{

				return p.getCoordinate();
			}
		}
		return null;
	}

	public Square getSquare(Coordinate x) 
	{
		for (int i = 0; i < squares.length; i++) 
		{
			if (x.equals(squares[i].getCoordinate())) 
			{
				return squares[i];
			}
		}
		return null;
	}

	public static boolean onBoard(int x, int y) 
	{
		return (x > 96) && (x < 105) && (y > 0) && (y < 9);
	}

	public static boolean onBoard(char xe, int y) 
	{
		int x = (int) xe;
		return (x > 96) && (x < 105) && (y > 0) && (y < 9);
	}

	public static boolean onBoard(Coordinate z) 
	{
		int x = z.getX().charAt(0);
		int y = z.getY();
		return (x > 96) && (x < 105) && (y > 0) && (y < 9);
	}

	Square a1 = new Square(new Coordinate("a", 1));
	Square a2 = new Square(new Coordinate("a", 2));
	Square a3 = new Square(new Coordinate("a", 3));
	Square a4 = new Square(new Coordinate("a", 4));
	Square a5 = new Square(new Coordinate("a", 5));
	Square a6 = new Square(new Coordinate("a", 6));
	Square a7 = new Square(new Coordinate("a", 7));
	Square a8 = new Square(new Coordinate("a", 8));

	Square b1 = new Square(new Coordinate("b", 1));
	Square b2 = new Square(new Coordinate("b", 2));
	Square b3 = new Square(new Coordinate("b", 3));
	Square b4 = new Square(new Coordinate("b", 4));
	Square b5 = new Square(new Coordinate("b", 5));
	Square b6 = new Square(new Coordinate("b", 6));
	Square b7 = new Square(new Coordinate("b", 7));
	Square b8 = new Square(new Coordinate("b", 8));

	Square c1 = new Square(new Coordinate("c", 1));
	Square c2 = new Square(new Coordinate("c", 2));
	Square c3 = new Square(new Coordinate("c", 3));
	Square c4 = new Square(new Coordinate("c", 4));
	Square c5 = new Square(new Coordinate("c", 5));
	Square c6 = new Square(new Coordinate("c", 6));
	Square c7 = new Square(new Coordinate("c", 7));
	Square c8 = new Square(new Coordinate("c", 8));

	Square d1 = new Square(new Coordinate("d", 1));
	Square d2 = new Square(new Coordinate("d", 2));
	Square d3 = new Square(new Coordinate("d", 3));
	Square d4 = new Square(new Coordinate("d", 4));
	Square d5 = new Square(new Coordinate("d", 5));
	Square d6 = new Square(new Coordinate("d", 6));
	Square d7 = new Square(new Coordinate("d", 7));
	Square d8 = new Square(new Coordinate("d", 8));

	Square e1 = new Square(new Coordinate("e", 1));
	Square e2 = new Square(new Coordinate("e", 2));
	Square e3 = new Square(new Coordinate("e", 3));
	Square e4 = new Square(new Coordinate("e", 4));
	Square e5 = new Square(new Coordinate("e", 5));
	Square e6 = new Square(new Coordinate("e", 6));
	Square e7 = new Square(new Coordinate("e", 7));
	Square e8 = new Square(new Coordinate("e", 8));

	Square f1 = new Square(new Coordinate("f", 1));
	Square f2 = new Square(new Coordinate("f", 2));
	Square f3 = new Square(new Coordinate("f", 3));
	Square f4 = new Square(new Coordinate("f", 4));
	Square f5 = new Square(new Coordinate("f", 5));
	Square f6 = new Square(new Coordinate("f", 6));
	Square f7 = new Square(new Coordinate("f", 7));
	Square f8 = new Square(new Coordinate("f", 8));

	Square g1 = new Square(new Coordinate("g", 1));
	Square g2 = new Square(new Coordinate("g", 2));
	Square g3 = new Square(new Coordinate("g", 3));
	Square g4 = new Square(new Coordinate("g", 4));
	Square g5 = new Square(new Coordinate("g", 5));
	Square g6 = new Square(new Coordinate("g", 6));
	Square g7 = new Square(new Coordinate("g", 7));
	Square g8 = new Square(new Coordinate("g", 8));

	Square h1 = new Square(new Coordinate("h", 1));
	Square h2 = new Square(new Coordinate("h", 2));
	Square h3 = new Square(new Coordinate("h", 3));
	Square h4 = new Square(new Coordinate("h", 4));
	Square h5 = new Square(new Coordinate("h", 5));
	Square h6 = new Square(new Coordinate("h", 6));
	Square h7 = new Square(new Coordinate("h", 7));
	Square h8 = new Square(new Coordinate("h", 8));

	// ArrayList <Square> squares = new ArrayList <Square>();

	Square[] squares = { a1, b1, c1, d1, e1, f1, g1, h1, a2, b2, c2, d2, e2, f2, g2, h2, a3, b3, c3, d3, e3, f3, g3, h3,
			a4, b4, c4, d4, e4, f4, g4, h4, a5, b5, c5, d5, e5, f5, g5, h5, a6, b6, c6, d6, e6, f6, g6, h6, a7, b7, c7,
			d7, e7, f7, g7, h7, a8, b8, c8, d8, e8, f8, g8, h8 };
	/*
	 * public void place(Coordinate c, Piece p) { for(Square a: squares) {
	 * if(a.equals(c)) { a.occupy(p); } } }
	 */
	
	public void playSound(){

	    try{
	        AudioInputStream audio = AudioSystem.getAudioInputStream(new File("ChessSound.wav"));
	        Clip clip = AudioSystem.getClip();
	        clip.open(audio);
	        clip.start();
	    } catch (Exception e){
	        
	        e.printStackTrace();
	    }
	}

}
