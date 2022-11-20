import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{
	private boolean firstMove;
	private boolean movedTwo;
	public Pawn(String colo, Coordinate s) {
		super(colo, s);
		firstMove = true;
		movedTwo = false;
	}


	
	public List<Coordinate> getLegalList() {
		//ArrayList<Coordinate> lis = new ArrayList<>();
		
		if(getColor().equals("white")) {
			return whiteMoves();
		}
		
		return blackMoves();
		
		
		
		
	}
	
	private List<Coordinate> whiteMoves(){
		List<Coordinate> lis = new ArrayList<>();
		Coordinate z = super.getCoordinate();
		int x = (int) z.getXChar(); //is char orgininaly
		int y = z.getY();
		
		
		Coordinate c = new Coordinate(x, y + 1);
		if(Board.onBoard(c)) {
			if(Board.getInstance().getSquare(c).getOccPiece() == null) {
			lis.add(c);
			}
		}
		
		c = new Coordinate(x, y + 2);
		if(Board.onBoard(c)) {
			if(Board.getInstance().getSquare(c).getOccPiece() == null && firstMove) {
				lis.add(c);
			}
		}
		
		c = new Coordinate(x + 1, y + 1);
		if(Board.onBoard(c)) {
			Piece p = Board.getInstance().getSquare(c).getOccPiece();
		
			if( p!= null && !p.getColor().equals(this.getColor())) {
			lis.add(c);
			}
		
		}
		c = new Coordinate(x - 1, y + 1);
		if(Board.onBoard(c)) {
			Piece p = Board.getInstance().getSquare(c).getOccPiece();
			if(p!= null && !p.getColor().equals(this.getColor())) {
				lis.add(c);
			}
		}
		return lis;
	}
	
	
	
	private List<Coordinate> blackMoves(){
		List<Coordinate> lis = new ArrayList<>();
		Coordinate z = super.getCoordinate();
		int x = (int) z.getXChar(); //is char orgininaly
		int y = z.getY();
		
		
		Coordinate c = new Coordinate(x, y - 1);
		if(Board.onBoard(c)) {
			if(Board.getInstance().getSquare(c).getOccPiece() == null) {
			lis.add(c);
			}
		}
		
		c = new Coordinate(x, y - 2);
		if(Board.onBoard(c)) {
			if(Board.getInstance().getSquare(c).getOccPiece() == null && firstMove) {
				lis.add(c);
			}
		}
		
		c = new Coordinate(x + 1, y - 1);
		if(Board.onBoard(c)) {
			Piece p = Board.getInstance().getSquare(c).getOccPiece();
		
			if( p!= null && !p.getColor().equals(this.getColor())) {
			lis.add(c);
			}
		
		}
		c = new Coordinate(x - 1, y - 1);
		if(Board.onBoard(c)) {
			Piece p = Board.getInstance().getSquare(c).getOccPiece();
			if(p!= null && !p.getColor().equals(this.getColor())) {
				lis.add(c);
			}
		}
		return lis;
	}
	
	
	public void setCoordinate(Coordinate c) {
		super.setCoordinate(c);
		firstMove = false;
		takeYouselfOffAndPromote( );
	}
	
	
	private void takeYouselfOffAndPromote( )
	{
		boolean promote = false;
		Coordinate c = super.getCoordinate();
		if( "white".equals(this.getColor( ) ) )
		{
			if( c.getY() == 8 )
			{
				promote = true;
			}
		}
		else
		{
			if( c.getY() == 1 )
			{
				promote = true;
			}
		}
		if( !promote )
		{
			return;
		}
		
		
		Board.getInstance().promotePawn( this.getColor(), c);
		
		
	}
	



	
	public String getBlackImageName() {
		return "BlackPawn.png";
	}



	
	public String getWhiteImageName() {
		return "WhitePawn.png";
	}




}
