import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece{

	public Queen(String colo, Coordinate s) {
		super(colo, s);
		
	}


	public ArrayList<Coordinate> getLegalList() {
		ArrayList<Coordinate> lis = new ArrayList<>();
		lis.addAll(backRight());
		lis.addAll(backLeft());
		lis.addAll(frontRight());
		lis.addAll(frontLeft());
		lis.addAll(right());
		lis.addAll(left());
		lis.addAll(back());
		lis.addAll(foreward());
		return lis;

	}
	private List<Coordinate> backRight() {
		//Coordinate [] lis = new Coordinate[8];
		List<Coordinate> lis = new ArrayList<>();
		//int next = 0;
		Coordinate z = super.getCoordinate();
		int x = z.getX().charAt(0); //is char orgininaly
		int y = z.getY();
		x++;
		y--;
		while(Board.onBoard(x, y)) {
			if(Board.getInstance().getSquare(new Coordinate(x,y)).getOccPiece() != null) {
				if(Board.getInstance().getSquare(new Coordinate(x,y)).getOccPiece().getColor().equals(super.getColor())){
					break;
				}
				
				lis.add(new Coordinate(x,y));
				break;
				
				
			
			}
			
			lis.add(new Coordinate(x,y));
			//next++;
			x++;
			y--;
		
		}
		return lis;
	}
	
	private List<Coordinate> backLeft() {
		List<Coordinate> lis = new ArrayList<>();
		//int next = 0;
		Coordinate z = super.getCoordinate();
		int x = z.getX().charAt(0); //is char orgininaly
		int y = z.getY();
		x--;
		y--;
		while(Board.onBoard(x, y)) {
			if(Board.getInstance().getSquare(new Coordinate(x,y)).getOccPiece() != null) {
				if(Board.getInstance().getSquare(new Coordinate(x,y)).getOccPiece().getColor().equals(super.getColor())){
					break;
				}
				
				lis.add(new Coordinate(x,y));
				break;
			
			}
			
			lis.add(new Coordinate(x,y));
			
			x--;
			y--;
		
		}
		return lis;
	}
	
	private List<Coordinate> frontRight() {
		List<Coordinate> lis = new ArrayList<>();
		//int next = 0;
		Coordinate z = super.getCoordinate();
		int x = z.getX().charAt(0); //is char orgininaly
		int y = z.getY();
		x++;
		y++;
		while(Board.onBoard(x, y)) {
			if(Board.getInstance().getSquare(new Coordinate(x,y)).getOccPiece() != null) {
				if(Board.getInstance().getSquare(new Coordinate(x,y)).getOccPiece().getColor().equals(super.getColor())){
					break;
				}
				
				lis.add(new Coordinate(x,y));
				break;
			
			}
			
			lis.add(new Coordinate(x,y));
			
			x++;
			y++;
		
		}
		return lis;
	}
	
	private List<Coordinate> frontLeft() {
		List<Coordinate> lis = new ArrayList<>();
		//int next = 0;
		Coordinate z = super.getCoordinate();
		int x = z.getX().charAt(0); //is char orgininaly
		int y = z.getY();
		x--;
		y++;
		while(Board.onBoard(x, y)) {
			if(Board.getInstance().getSquare(new Coordinate(x, y)).getOccPiece() != null) {
				if(Board.getInstance().getSquare(new Coordinate (x, y)).getOccPiece().getColor().equals(super.getColor())){
					break;
				}
				
				lis.add(new Coordinate(x,y));
				break;
			
			}
			
			lis.add(new Coordinate(x,y));
		
		
			
			x--;
			y++;
		}
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

	
	public String getBlackImageName() {
		return "BlackQueen.png";
	}


	
	public String getWhiteImageName() {
		return "WhiteQueen.png";
	}



}
