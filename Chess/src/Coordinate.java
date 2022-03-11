
public class Coordinate {
	private String x;
	private int y;
	
	public Coordinate(String xe, int ye) {
		x = xe;
		y = ye;
	}
	
	public Coordinate(char xe, int ye) {
		x = Character.toString(xe);
		y = ye;
	}
	
	public Coordinate(int xe, int ye) {
		x = Character.toString((char)xe);
		y = ye;
	}
	public String getX() {
		return x;
	}
	
	public char getXChar() {
		 return x.charAt(0);
	}
	
	public int getY() {
		return y;
	}
	
	
	
	public boolean equals(Object o) {
		Coordinate c = (Coordinate) o;
		if((x.equals(c.getX())) && y == c.getY()) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return x + y;
	}

}
