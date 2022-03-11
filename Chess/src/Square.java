
public class Square {

	Coordinate coordinate;
	private Piece occPiece;
	
	public Square(Coordinate coo) {
		coordinate = coo;
	}
	
	public void occupy(Piece p) {
		occPiece = p;
	}
	
	public void leave() {
		occPiece = null;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public Piece getOccPiece() {
		return occPiece;
	}
	
	public boolean equals(Object o) {
		Square a = (Square)o;
		if(a.getCoordinate().equals(coordinate)) {
			return true;
		}
		return false;
	}
	
	
	
}
