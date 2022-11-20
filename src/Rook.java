import java.util.ArrayList;

public class Rook extends Piece{

	private boolean hasMoved;
	public Rook(String colo, Coordinate s) {
		super(colo,s);
		hasMoved = false;
	}

	
	public ArrayList<Coordinate> getLegalList() {
		ArrayList<Coordinate> lis = new ArrayList<>();
		lis.addAll(right());
		lis.addAll(left());
		lis.addAll(back());
		lis.addAll(foreward());
		return lis;

	}
	
	private ArrayList<Coordinate> back() {
		ArrayList<Coordinate> lis = new ArrayList<>();
		
		Coordinate z = super.getCoordinate();
		int x = z.getX().charAt(0); //is char orgininaly
		int y = z.getY();
		y--;
		while(Board.onBoard(x, y)) {
			if(Board.getInstance().getSquare(new Coordinate(Character.toString((char)x), y)).getOccPiece() != null) {
				if(Board.getInstance().getSquare(new Coordinate(Character.toString((char)x), y)).getOccPiece().getColor().equals(super.getColor())){
					break;
				}
				
				lis.add(new Coordinate(Character.toString((char)x), y));
				break;
			
			}
			
			lis.add(new Coordinate(Character.toString((char)x), y));
			
			y--;
		}
		return lis;
		
	}
	
	private ArrayList<Coordinate> foreward() {
		ArrayList<Coordinate> lis = new ArrayList<>();
		
		Coordinate z = super.getCoordinate();
		int x = z.getX().charAt(0); //is char orgininaly
		int y = z.getY();
		y++;
		while(Board.onBoard(x, y)) {
			if(Board.getInstance().getSquare(new Coordinate(Character.toString((char)x), y)).getOccPiece() != null) {
				if(Board.getInstance().getSquare(new Coordinate(Character.toString((char)x), y)).getOccPiece().getColor().equals(super.getColor())){
					break;
				}
				
				lis.add(new Coordinate(Character.toString((char)x), y));
				break;
			
			}
			
			lis.add(new Coordinate(Character.toString((char)x), y));
			
			y++;
		}
		return lis;
		
	}

	private ArrayList<Coordinate> left() {
	
		ArrayList<Coordinate> lis = new ArrayList<>();
		
		Coordinate z = super.getCoordinate();
		int x = z.getX().charAt(0); //is char orgininaly
		int y = z.getY();
		x--;
		while(Board.onBoard(x, y)) {
			if(Board.getInstance().getSquare(new Coordinate(Character.toString((char)x), y)).getOccPiece() != null) {
				if(Board.getInstance().getSquare(new Coordinate(Character.toString((char)x), y)).getOccPiece().getColor().equals(super.getColor())){
					break;
				}
				
				lis.add(new Coordinate(Character.toString((char)x), y));
				break;
			
			}
			
			lis.add(new Coordinate(Character.toString((char)x), y));
			
			x--;
		}
		return lis;
		
	}

	

	private ArrayList<Coordinate> right() {
		
		ArrayList<Coordinate> lis = new ArrayList<>();
		
		Coordinate z = super.getCoordinate();
		int x = z.getX().charAt(0); //is char orgininaly
		int y = z.getY();
		x++;
		while(Board.onBoard(x, y)) {
			if(Board.getInstance().getSquare(new Coordinate(Character.toString((char)x), y)).getOccPiece() != null) {
				if(Board.getInstance().getSquare(new Coordinate(Character.toString((char)x), y)).getOccPiece().getColor().equals(super.getColor())){
					break;
				}
				
				lis.add(new Coordinate(Character.toString((char)x), y));
				break;
			
			}
			
			lis.add(new Coordinate(Character.toString((char)x), y));
			
			x++;
		}
		return lis;
	
}

	public boolean hasMoved() {
		return hasMoved;
	}


	
	public String getBlackImageName() {
		return "BlackRook.png";
	}


	
	public String getWhiteImageName() {
		return "WhiteRook.png";
	}

	
	public void setcoordinate(Coordinate c) {
		super.setCoordinate(c);
		hasMoved = !hasMoved;
	}


	
	
}
