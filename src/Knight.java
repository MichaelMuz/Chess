import java.util.ArrayList;

public class Knight extends Piece{

public Knight(String colo, Coordinate s) {
	super(colo,s);
}


public ArrayList<Coordinate> getLegalList() {
	ArrayList<Coordinate> lis = new ArrayList<>();
	Coordinate z = super.getCoordinate();
	int x = z.getX().charAt(0); //is char orgininaly
	int y = z.getY();
	Coordinate coo1 = new Coordinate(Character.toString((char)(x + 2)), y + 1);
	Coordinate coo2 = new Coordinate(Character.toString((char)(x + 1)), y + 2);
	Coordinate coo3 = new Coordinate(Character.toString((char)(x + 2)), y - 1);
	Coordinate coo4 = new Coordinate(Character.toString((char)(x + 1)), y - 2);
	Coordinate coo5 = new Coordinate(Character.toString((char)(x - 2)), y - 1);
	Coordinate coo6 = new Coordinate(Character.toString((char)(x - 1)), y - 2);
	Coordinate coo7 = new Coordinate(Character.toString((char)(x - 2)), y + 1);
	Coordinate coo8 = new Coordinate(Character.toString((char)(x - 1)), y + 2);
	Coordinate coors[] = {
			coo1, coo2, coo3, coo4, coo5, coo6, coo7, coo8
	};
	for(int i = 0; i < coors.length; i ++) {
		if(Board.onBoard(coors[i]) && Board.getInstance().getSquare(coors[i]).getOccPiece() != null) {
			if(!Board.getInstance().getSquare(coors[i]).getOccPiece().getColor().equals(super.getColor())){
				lis.add(coors[i]);
			}
		}
		
		else if(Board.onBoard(coors[i]) && Board.getInstance().getSquare(coors[i]).getOccPiece() == null){
			lis.add(coors[i]);
		}
	}
	
	return lis;
}



public String getBlackImageName() {
	return "BlackKnight.png";
}



public String getWhiteImageName() {
	return "WhiteKnight.png";
}



}
