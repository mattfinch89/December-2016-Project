import java.io.IOException;

public class MiniBoard extends Board {

	static Image[][] background = new Image[3][3];
	Piece[][] piece = new Piece[3][3];
	static int column = 0, row = 0;

	MiniBoard(int col, int row) throws IOException {

		background[row][col] = new Image("MiniPanel.png", 25 * (column + 1) + 200 * column,
				19 * (this.row + 1) + 200 * this.row);

		for (int c = 0; c < 3; c++) {
			for (int r = 0; r < 3; r++) {
				piece[c][r] = new Piece("-.png", background[row][col].x + 67 * c, background[row][col].y + 67 * r);
			}
		}

		column++;

		if (column == 3) {
			this.row++;
			column = 0;
		}

	}

	public boolean isValidMove(int x, int y) {
		// TODO Auto-generated method stub

//		setMiniColumn(x, y);
//		setMiniRow(x, y);

		if (piece[getMiniColumn(x,y)][getMiniRow(x,y)].getPieceID() == 0)
			return true;
		else 
			return false;
	}

	private int getMiniRow(int x, int y) {
		// TODO Auto-generated method stub
		int col = HumanPlayer.getMainColumn(x), row = HumanPlayer.getMainRow(y);
		return (y - background[col][row].y) / 67;

	}

	private int getMiniColumn(int x, int y) {
		// TODO Auto-generated method stub
		int col = HumanPlayer.getMainColumn(x), row = HumanPlayer.getMainRow(y);
		return (x - background[col][row].x) / 67;

	}

	public void move(int x, int y, int playerID) throws IOException {
		// TODO Auto-generated method stub

		if (isValidMove(x, y)) {
			SuperTicTacToe.play++;
			HumanPlayer.setMainColumn(x);
			HumanPlayer.setMainRow(y);
			setMiniColumn(x,y);
			setMiniRow(x,y);
			if (playerID == 1) {
				piece[SuperTicTacToe.miniColumn][SuperTicTacToe.miniRow].setImage(SuperTicTacToe.p1.imgName);
				piece[SuperTicTacToe.miniColumn][SuperTicTacToe.miniRow].setPieceID(1);
			} else {
				piece[SuperTicTacToe.miniColumn][SuperTicTacToe.miniRow].setImage(SuperTicTacToe.p2.imgName);
				piece[SuperTicTacToe.miniColumn][SuperTicTacToe.miniRow].setPieceID(2);

			}
		}

		
	}

	public void setMiniColumn(int x, int y) {
		int col = HumanPlayer.getMainColumn(x), row = HumanPlayer.getMainRow(y);
		SuperTicTacToe.miniColumn = (x - background[col][row].x) / 67;

	}

	public void setMiniRow(int x, int y) {
		int col = HumanPlayer.getMainColumn(x), row = HumanPlayer.getMainRow(y);
		SuperTicTacToe.miniRow = (y - background[col][row].y) / 67;

	}

}
