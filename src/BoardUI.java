import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
//import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
//import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class BoardUI extends JPanel 
{
	SquareUI[][] squares = new SquareUI[8][8];
	private JPanel battleField;
	private int borderWidth = 30;

	private static BoardUI INSTANCE = new BoardUI();

	public static BoardUI getInstance() 
	{
		return INSTANCE;
	}

	private BoardUI()
	{
		battleField = new JPanel(new GridLayout(8, 8, 0, 0));
		Color current = SquareUI.WHITE;
		for (int i = 0; i < 8; i++) 
		{
			for (int j = 0; j < 8; j++) 
			{
				squares[i][j] = new SquareUI(current, i, j);
				if (SquareUI.WHITE.equals(current)) 
				{
					current = SquareUI.BLACK;
				} else {
					current = SquareUI.WHITE;
				}
				battleField.add(squares[i][j]);
			}
			if (SquareUI.WHITE.equals(current))
			{
				current = SquareUI.BLACK;
			} else {
				current = SquareUI.WHITE;
			}

		}
		int size = (SquareUI.SIDE_SIZE * 8) + (borderWidth * 2);
		Dimension d = new Dimension(size, size);
		this.setPreferredSize(d);
		this.setMinimumSize(d);
		this.setMaximumSize(d);

		this.setLayout(null);
		this.add(battleField);
		// battleField.setBorder( BorderFactory.createLineBorder( Color.BLACK ) );
		battleField.setBounds(borderWidth, borderWidth, SquareUI.SIDE_SIZE * 8, SquareUI.SIDE_SIZE * 8);
		addPieces();

	}

	public SquareUI getSquareUI(Coordinate coord) 
	{
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (squares[i][j].getCoordConverted().equals(coord)) {
					return squares[i][j];
				}
			}
		}
		return null;
	}

	public void removeAllSelections() 
	{
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (squares[i][j].getComponentCount() > 0) {
					Component c = squares[i][j].getComponent(0);
					((JComponent) c).setBorder(null);
				}
			}
		}
	}

	public PieceUI getSelectedPieceUI() 
	{
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (squares[i][j].getComponentCount() > 0) {
					Component c = squares[i][j].getComponent(0);
					JComponent jcomp = (JComponent) c;
					if (jcomp.getBorder() != null) {
						return ((PieceUI) c);
					}
				}
			}
		}
		return null;
	}

	public void cleanSelectedPieceUI() 
	{
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (squares[i][j].getComponentCount() > 0) {
					Component c = squares[i][j].getComponent(0);
					JComponent jcomp = (JComponent) c;
					if (jcomp.getBorder() != null) {
						squares[i][j].remove(0);
						return;
					}
				}
			}
		}
	}

	private void addPieces() 
	{
		Board board = Board.getInstance();
		Piece piece = board.getSquare(new Coordinate("a", 1)).getOccPiece();
		squares[7][0].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("b", 1)).getOccPiece();
		squares[7][1].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("c", 1)).getOccPiece();
		squares[7][2].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("d", 1)).getOccPiece();
		squares[7][3].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("e", 1)).getOccPiece();
		squares[7][4].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("f", 1)).getOccPiece();
		squares[7][5].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("g", 1)).getOccPiece();
		squares[7][6].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("h", 1)).getOccPiece();
		squares[7][7].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("a", 2)).getOccPiece();
		squares[6][0].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("b", 2)).getOccPiece();
		squares[6][1].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("c", 2)).getOccPiece();
		squares[6][2].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("d", 2)).getOccPiece();
		squares[6][3].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("e", 2)).getOccPiece();
		squares[6][4].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("f", 2)).getOccPiece();
		squares[6][5].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("g", 2)).getOccPiece();
		squares[6][6].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("h", 2)).getOccPiece();
		squares[6][7].add(piece.getUIRepresentation());

		piece = board.getSquare(new Coordinate("a", 8)).getOccPiece();
		squares[0][0].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("b", 8)).getOccPiece();
		squares[0][1].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("c", 8)).getOccPiece();
		squares[0][2].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("d", 8)).getOccPiece();
		squares[0][3].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("e", 8)).getOccPiece();
		squares[0][4].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("f", 8)).getOccPiece();
		squares[0][5].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("g", 8)).getOccPiece();
		squares[0][6].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("h", 8)).getOccPiece();
		squares[0][7].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("a", 7)).getOccPiece();
		squares[1][0].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("b", 7)).getOccPiece();
		squares[1][1].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("c", 7)).getOccPiece();
		squares[1][2].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("d", 7)).getOccPiece();
		squares[1][3].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("e", 7)).getOccPiece();
		squares[1][4].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("f", 7)).getOccPiece();
		squares[1][5].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("g", 7)).getOccPiece();
		squares[1][6].add(piece.getUIRepresentation());
		piece = board.getSquare(new Coordinate("h", 7)).getOccPiece();
		squares[1][7].add(piece.getUIRepresentation());
	}

	public void paint(Graphics g) 
	{
		super.paint(g);
		Font f = this.getFont();
		FontMetrics fm = g.getFontMetrics(f);
		int startX = borderWidth;
		int startY = borderWidth + (SquareUI.SIDE_SIZE * 8) + borderWidth / 2;
		String[] leters = { "A", "B", "C", "D", "E", "F", "G", "H" };
		for (int i = 0; i < 8; i++) {

			Rectangle2D r = fm.getStringBounds(leters[i], g);
			int startH = startX + (int) SquareUI.SIDE_SIZE / 2 - (int) r.getWidth() / 2;
			int startV = startY + (int) r.getHeight() / 2;
			g.drawString(leters[i], startH, startV);
			startX = startX + SquareUI.SIDE_SIZE;
		}

		String[] numbers = { "8", "7", "6", "5", "4", "3", "2", "1" };
		startX = borderWidth / 2;
		startY = borderWidth + SquareUI.SIDE_SIZE / 2;
		for (int i = 0; i < 8; i++) {
			Rectangle2D r = fm.getStringBounds(numbers[i], g);
			int startH = startX - (int) r.getWidth() / 2;
			int startV = startY + (int) r.getHeight() / 2;
			g.drawString(numbers[i], startH, startV);
			startY = startY + SquareUI.SIDE_SIZE;
		}
		g.drawRect(borderWidth, borderWidth, SquareUI.SIDE_SIZE * 8, SquareUI.SIDE_SIZE * 8);
	}

	public void promotePawn(String color, Coordinate c) 
	{
		JDialog dialog = new JDialog(SwingUtilities.windowForComponent(this));
		dialog.setTitle("Choose Promotion");

		Rook rook = new Rook(color, c);
		Bishop bishop = new Bishop(color, c);
		Knight knight = new Knight(color, c);
		Queen queen = new Queen(color, c);

		JRadioButton rookButton = new JRadioButton("Rook");
		rookButton.setIcon(rook.getIcon());
		rookButton.setVerticalTextPosition(JRadioButton.BOTTOM);
		rookButton.setHorizontalTextPosition(JRadioButton.CENTER);

		JRadioButton bishopButton = new JRadioButton("Bishop");
		bishopButton.setIcon(bishop.getIcon());
		bishopButton.setVerticalTextPosition(JRadioButton.BOTTOM);
		bishopButton.setHorizontalTextPosition(JRadioButton.CENTER);

		JRadioButton knightButton = new JRadioButton("Knight");
		knightButton.setIcon(knight.getIcon());
		knightButton.setVerticalTextPosition(JRadioButton.BOTTOM);
		knightButton.setHorizontalTextPosition(JRadioButton.CENTER);

		JRadioButton queenButton = new JRadioButton("Queen");
		queenButton.setIcon(queen.getIcon());
		queenButton.setVerticalTextPosition(JRadioButton.BOTTOM);
		queenButton.setHorizontalTextPosition(JRadioButton.CENTER);
		queenButton.setSelected(true);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rookButton);
		bg.add(bishopButton);
		bg.add(knightButton);
		bg.add(queenButton);

		JButton okButton = new JButton("Ok");

		JPanel centerPanel = new JPanel(new FlowLayout());
		centerPanel.add(queenButton);
		centerPanel.add(bishopButton);
		centerPanel.add(rookButton);
		centerPanel.add(knightButton);

		JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.add(okButton);

		dialog.setLayout(new BorderLayout());
		dialog.add(BorderLayout.CENTER, centerPanel);
		dialog.add(BorderLayout.SOUTH, buttonPanel);

		dialog.pack();
		dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

		dialog.setLocationRelativeTo(SwingUtilities.windowForComponent(this));

		okButton.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				dialog.setVisible(false);

				if (rookButton.isSelected()) {
					Board.getInstance().replacePawn(rook);
				} else if (bishopButton.isSelected()) {
					Board.getInstance().replacePawn(bishop);
				} else if (knightButton.isSelected()) {
					Board.getInstance().replacePawn(knight);
				} else if (queenButton.isSelected()) {
					Board.getInstance().replacePawn(queen);
				}

				dialog.dispose();

			}
		});

		dialog.setVisible(true);

	}

	public void checkstaleMate(boolean stale) 
	{
		System.out.println("checkMate");
		String winColor = "black";
		if (!Board.getInstance().isWhiteTurn()) 
		{
			winColor = "white";
		}
		JDialog dialog = new JDialog(SwingUtilities.windowForComponent(this));
		dialog.setLayout(new BorderLayout());
		String winText = " " + winColor + " wins!";
		if (stale) {
			winText = " StaleMate!";
		}

		JLabel label = new JLabel(winText);
		label.setForeground(Color.RED);
		Font f = label.getFont();
		f = new Font(f.getFamily(), Font.BOLD, 20);
		label.setFont(f);

		dialog.add(label, BorderLayout.CENTER);
//		JTextField tField = new JTextField(winText);
//		dialog.add(tField, BorderLayout.CENTER);
		// this.add(dialog);

		dialog.pack();
		dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

		dialog.setLocationRelativeTo(SwingUtilities.windowForComponent(this));
		dialog.setVisible(true);
		this.repaint();
	}

}
