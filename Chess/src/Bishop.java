import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece{

	public Bishop(String colo, Coordinate s) {
		super(colo,s);
	}
	
	public  String getBlackImageName( )
	{
		return "BlackBishop.png";
	}
	public  String getWhiteImageName( )
	{
		return "WhiteBishop.png";
	}

	public List<Coordinate> getLegalList() {
		List<Coordinate> lis = new ArrayList<>();
		lis.addAll(backRight());
		lis.addAll(backLeft());
		lis.addAll(frontRight());
		lis.addAll(frontLeft());
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


}
