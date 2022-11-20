import java.awt.Component;
import java.awt.List;
import java.util.ArrayList;

public class King extends Piece {

	private boolean hasMoved;

	public King(String colo, Coordinate s) {
		super(colo, s);
		hasMoved = false;
	}

	public ArrayList<Coordinate> getLegalList() {
		ArrayList<Coordinate> lis = new ArrayList<>();
		Coordinate z = super.getCoordinate();
		int x = z.getX().charAt(0); // is char orgininaly
		int y = z.getY();

		if (Board.onBoard((x - 1), y)) {
			if (Board.getInstance().getSquare(new Coordinate(Character.toString((char) (x - 1)), y))
					.getOccPiece() == null) {
				lis.add(new Coordinate(Character.toString((char) (x - 1)), (y)));

			}

			else if (!Board.getInstance().getSquare(new Coordinate(Character.toString((char) (x - 1)), y)).getOccPiece()
					.getColor().equals(super.getColor())) {
				lis.add(new Coordinate(Character.toString((char) (x - 1)), y));

			}

		}
		if (Board.onBoard((x - 1), (y - 1))) {
			if (Board.getInstance().getSquare(new Coordinate(Character.toString((char) (x - 1)), (y - 1)))
					.getOccPiece() == null) {
				lis.add(new Coordinate(Character.toString((char) (x - 1)), (y - 1)));

			} else if (!Board.getInstance().getSquare(new Coordinate(Character.toString((char) (x - 1)), (y - 1)))
					.getOccPiece().getColor().equals(super.getColor())) {
				lis.add(new Coordinate(Character.toString((char) (x - 1)), (y - 1)));

			}
		}

		if (Board.onBoard((x + 1), y)) {
			if (Board.getInstance().getSquare(new Coordinate(Character.toString((char) (x + 1)), y))
					.getOccPiece() == null) {
				lis.add(new Coordinate(Character.toString((char) (x + 1)), (y)));

			} else if (!Board.getInstance().getSquare(new Coordinate(Character.toString((char) (x + 1)), y))
					.getOccPiece().getColor().equals(super.getColor())) {
				lis.add(new Coordinate(Character.toString((char) (x + 1)), y));

			}
		}

		if (Board.onBoard((x + 1), (y + 1))) {
			if (Board.getInstance().getSquare(new Coordinate(Character.toString((char) (x + 1)), (y + 1)))
					.getOccPiece() == null) {
				lis.add(new Coordinate(Character.toString((char) (x + 1)), (y + 1)));

			} else if (!Board.getInstance().getSquare(new Coordinate(Character.toString((char) (x + 1)), (y + 1)))
					.getOccPiece().getColor().equals(super.getColor())) {
				lis.add(new Coordinate(Character.toString((char) (x + 1)), (y + 1)));

			}
		}

		if (Board.onBoard(x, (y - 1))) {
			if (Board.getInstance().getSquare(new Coordinate(Character.toString((char) (x)), (y - 1)))
					.getOccPiece() == null) {
				lis.add(new Coordinate(Character.toString((char) (x)), (y - 1)));

			}

			else if (!Board.getInstance().getSquare(new Coordinate(Character.toString((char) (x)), (y - 1)))
					.getOccPiece().getColor().equals(super.getColor())) {
				lis.add(new Coordinate(Character.toString((char) (x)), (y - 1)));

			}

		}

		if (Board.onBoard(x, (y + 1))) {
			if (Board.getInstance().getSquare(new Coordinate(Character.toString((char) (x)), (y + 1)))
					.getOccPiece() == null) {
				lis.add(new Coordinate(Character.toString((char) (x)), (y + 1)));

			}

			else if (!Board.getInstance().getSquare(new Coordinate(Character.toString((char) (x)), (y + 1)))
					.getOccPiece().getColor().equals(super.getColor())) {
				lis.add(new Coordinate(Character.toString((char) (x)), (y + 1)));

			}

		}

		if (Board.onBoard((x - 1), (y + 1))) {
			if (Board.getInstance().getSquare(new Coordinate(Character.toString((char) (x - 1)), (y + 1)))
					.getOccPiece() == null) {
				lis.add(new Coordinate(Character.toString((char) (x - 1)), (y + 1)));

			}

			else if (!Board.getInstance().getSquare(new Coordinate(Character.toString((char) (x - 1)), (y + 1)))
					.getOccPiece().getColor().equals(super.getColor())) {
				lis.add(new Coordinate(Character.toString((char) (x - 1)), (y + 1)));

			}
		}

		if (Board.onBoard((x + 1), (y - 1))) {
			if (Board.getInstance().getSquare(new Coordinate(Character.toString((char) (x + 1)), (y - 1)))
					.getOccPiece() == null) {
				lis.add(new Coordinate(Character.toString((char) (x + 1)), (y - 1)));

			}

			else if (!Board.getInstance().getSquare(new Coordinate(Character.toString((char) (x + 1)), (y - 1)))
					.getOccPiece().getColor().equals(super.getColor())) {
				lis.add(new Coordinate(Character.toString((char) (x + 1)), (y - 1)));

			}

			/*
			 * if(super.getColor().equals("white")){ boolean one =
			 * Board.getInstance().getSquare(new Coordinate("a", 1)).getOccPiece()
			 * instanceof Rook; boolean two = !((Rook) Board.getInstance().getSquare(new
			 * Coordinate("a", 1)).getOccPiece()).hasMoved(); boolean rightt = !((Rook)
			 * Board.getInstance().getSquare(new Coordinate("h",
			 * 1)).getOccPiece()).hasMoved();
			 * 
			 * if((!hasMoved) && one && two) { one = Board.getInstance().getSquare(new
			 * Coordinate("b", 1)).getOccPiece() == null; two =
			 * Board.getInstance().getSquare(new Coordinate("c", 1)).getOccPiece() == null;
			 * boolean three = Board.getInstance().getSquare(new Coordinate("d",
			 * 1)).getOccPiece() == null; if(one && two && three) { lis.add(new
			 * Coordinate("c", 1)); castles.add(new Coordinate("c", 1));
			 * 
			 * }
			 * 
			 * } if((!hasMoved) && one && rightt) { one = Board.getInstance().getSquare(new
			 * Coordinate("g", 1)).getOccPiece() == null; two =
			 * Board.getInstance().getSquare(new Coordinate("f", 1)).getOccPiece() == null;
			 * if(one && two) { lis.add(new Coordinate("g", 1)); castles.add(new
			 * Coordinate("g", 1));
			 * 
			 * }
			 * 
			 * }
			 * 
			 * } else if(super.getColor().equals("black")) { boolean one =
			 * Board.getInstance().getSquare(new Coordinate("a", 8)).getOccPiece()
			 * instanceof Rook; boolean two = !((Rook) Board.getInstance().getSquare(new
			 * Coordinate("a", 8)).getOccPiece()).hasMoved(); boolean rightt = !((Rook)
			 * Board.getInstance().getSquare(new Coordinate("h",
			 * 8)).getOccPiece()).hasMoved(); if((!hasMoved) && one && two) { one =
			 * Board.getInstance().getSquare(new Coordinate("b", 8)).getOccPiece() == null;
			 * two = Board.getInstance().getSquare(new Coordinate("c", 8)).getOccPiece() ==
			 * null; boolean three = Board.getInstance().getSquare(new Coordinate("d",
			 * 1)).getOccPiece() == null; if(one && two && three) {
			 * 
			 * lis.add(new Coordinate("c", 8)); castles.add(new Coordinate("c", 8)); }
			 * 
			 * } if((!hasMoved) && one && rightt) { one = Board.getInstance().getSquare(new
			 * Coordinate("g", 8)).getOccPiece() == null; two =
			 * Board.getInstance().getSquare(new Coordinate("f", 8)).getOccPiece() == null;
			 * if(one && two) { lis.add(new Coordinate("g", 8)); castles.add(new
			 * Coordinate("g", 8)); }
			 * 
			 * }
			 * 
			 * }
			 */

		}

		int leftX = getCoordinate().getX().charAt(0) - 4;
		int rightX = getCoordinate().getX().charAt(0) + 3;
		Coordinate leftCoordinate = new Coordinate(leftX, getCoordinate().getY());
		Coordinate rightCoordinate = new Coordinate(rightX, getCoordinate().getY());
		if (!hasMoved && Board.onBoard(leftCoordinate) && Board.onBoard(rightCoordinate)) {

			Piece left = Board.getInstance().getSquare(leftCoordinate).getOccPiece();
			Piece right = Board.getInstance().getSquare(rightCoordinate).getOccPiece();
			if (left instanceof Rook && !((Rook) left).hasMoved()) {
				int[] arr = { getCoordinate().getX().charAt(0) - 3,

						getCoordinate().getX().charAt(0) - 2, getCoordinate().getX().charAt(0) - 1 };

				Piece[] pieceArr = {
						Board.getInstance().getSquare(new Coordinate(arr[0], getCoordinate().getY())).getOccPiece(),
						Board.getInstance().getSquare(new Coordinate(arr[1], getCoordinate().getY())).getOccPiece(),
						Board.getInstance().getSquare(new Coordinate(arr[2], getCoordinate().getY())).getOccPiece() };
				boolean pos = true;
				for (int i = 0; i < pieceArr.length; i++) {
					if (pieceArr[i] != null) {
						pos = false;
						break;
					}

				}
				if (pos) {
					Coordinate coo = new Coordinate("c", getCoordinate().getY());
					
					lis.add(coo);
				}
			}

			if (right instanceof Rook && !((Rook) right).hasMoved()) {
				int[] arr = { getCoordinate().getX().charAt(0) + 1, getCoordinate().getX().charAt(0) + 2, };

				Piece[] pieceArr = {
						Board.getInstance().getSquare(new Coordinate(arr[0], getCoordinate().getY())).getOccPiece(),
						Board.getInstance().getSquare(new Coordinate(arr[1], getCoordinate().getY())).getOccPiece(), };
				boolean pos = true;
				for (int i = 0; i < pieceArr.length; i++) {
					if (pieceArr[i] != null) {
						pos = false;
						break;
					}

				}
				if (pos) {
					Coordinate coo = new Coordinate("g", getCoordinate().getY());
					
					lis.add(coo);
				}
			}

		}
		return lis;

	}

	public void movedAlready() {
		hasMoved = true;
	}

	public String getBlackImageName() {
		return "BlackKing.png";
	}

	public String getWhiteImageName() {
		return "WhiteKing.png";
	}
	@Override
	public void setCoordinate(Coordinate c) {
		//int xVal = (int) c.getXChar();
		//if (Math.abs(xVal - ((int) getCoordinate().getXChar())) > 1) {
		if(Math.abs(c.getX().compareTo(getCoordinate().getX())) > 1 ) {
			
			Coordinate rookNeeds; 
			Coordinate rookAt;
			Coordinate myCoor = super.getCoordinate();
			 
			if(c.getX().equals("c")) { 
				 rookAt = new Coordinate("a", myCoor.getY());
				 rookNeeds = new Coordinate("d", myCoor.getY()); 
			 }
			 
			else {
				rookAt = new Coordinate("h", myCoor.getY()); 
				rookNeeds = new Coordinate("f", myCoor.getY()); 
			}
			 
			 
			 
			 SquareUI thatRookSquareUI = BoardUI.getInstance().getSquareUI(rookAt);
			 Component comp = thatRookSquareUI.getComponent(0);
			 thatRookSquareUI.remove(0);
			 BoardUI.getInstance().getSquareUI(rookNeeds).add(comp);
			 Board.getInstance().getSquare(rookAt).getOccPiece().setCoordinate(rookNeeds);
			 BoardUI.getInstance().repaint();
		}
		super.setCoordinate(c);
	
		/*
		 * if(castles.contains(c)) { Coordinate myCoor = super.getCoordinate();
		 * Coordinate rookNeeds; 
		 * Coordinate rookAt;
		 * 
		 * if(c.getX().equals("c")) { 
		 * rookAt = new Coordinate("a", myCoor.getY());
		 * rookNeeds = new Coordinate("d", myCoor.getY()); 
		 * }
		 * 
		 * else {
		 * rookAt = new Coordinate("h", myCoor.getY()); 
		 * rookNeeds = new
		 * Coordinate("f", myCoor.getY()); }
		 * 
		 * 
		 * Board.getInstance().getSquare(rookAt).getOccPiece().setCoordinate(rookNeeds);
		 * 
		 * }
		 */
		hasMoved = true;
	}

}
