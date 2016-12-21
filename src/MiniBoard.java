import java.io.IOException;

public class MiniBoard extends Board {

	static Image[][] background = new Image[3][3];
	Image thisSquare, bigWinner;
	Piece[][] piece = new Piece[3][3];
	static int column = 0, row = 0;
	boolean isWinner = false;
	int winnerID;

	MiniBoard(int col, int row) throws IOException {

		background[row][col] = new Image("MiniPanel.png", 25 * (column + 1) + 200 * column,
				19 * (this.row + 1) + 200 * this.row);

		for (int c = 0; c < 3; c++) {
			for (int r = 0; r < 3; r++) {
				piece[c][r] = new Piece("-.png", background[row][col].x + 67 * c, background[row][col].y + 67 * r);
			}
		}

		thisSquare = new Image("-.png", 25 * (column + 1) + 200 * column, 19 * (this.row + 1) + 200 * this.row);
		bigWinner = new Image("-.png", 25 * (column + 1) + 200 * column, 19 * (this.row + 1) + 200 * this.row);

		column++;

		if (column == 3) {
			this.row++;
			column = 0;
		}

	}

	public boolean isValidMove(int x, int y) {
		// TODO Auto-generated method stub

		if (SuperTicTacToe.mainColumn == -1 || piece[getMiniColumn(x, y)][getMiniRow(x, y)].getPieceID() == 0)
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
			setMiniColumn(x, y);
			setMiniRow(x, y);

			if (playerID == 1) {
				piece[SuperTicTacToe.miniColumn][SuperTicTacToe.miniRow].setImage(SuperTicTacToe.p1.imgName);
				piece[SuperTicTacToe.miniColumn][SuperTicTacToe.miniRow].setPieceID(1);
			} else {
				piece[SuperTicTacToe.miniColumn][SuperTicTacToe.miniRow].setImage(SuperTicTacToe.p2.imgName);
				piece[SuperTicTacToe.miniColumn][SuperTicTacToe.miniRow].setPieceID(2);
			}

			MainBoard.miniBoard[SuperTicTacToe.miniRow][SuperTicTacToe.miniColumn].thisSquare
					.setImage("ThisSquare.png");

			winner();

			if (winnerID != 0) {
				SuperTicTacToe.mainColumn = -1;
				if (winnerID == 1)
					bigWinner.setImage("xWin.png");
				else
					bigWinner.setImage("oWin.png");
			}

			if (MainBoard.miniBoard[SuperTicTacToe.miniRow][SuperTicTacToe.miniColumn].winnerID != 0) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						MainBoard.miniBoard[i][j].thisSquare.setImage("ThisSquare.png");
					}
				}

			} else {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						MainBoard.miniBoard[i][j].thisSquare.setImage("-.png");
					}
				}
				MainBoard.miniBoard[SuperTicTacToe.miniRow][SuperTicTacToe.miniColumn].thisSquare
						.setImage("ThisSquare.png");
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

	public void winner() {

		int winner = 0;
		boolean stop = true;
		for (int i = 0; i < 3 && stop; i++) {
			if (piece[i][0].getPieceID() == piece[i][1].getPieceID()
					&& piece[i][0].getPieceID() == piece[i][2].getPieceID() && piece[i][2].getPieceID() != 0) {
				winner = piece[i][0].getPieceID();
			} else if (piece[0][i].getPieceID() == piece[1][i].getPieceID()
					&& piece[0][i].getPieceID() == piece[2][i].getPieceID() && piece[2][i].getPieceID() != 0) {
				winner = piece[0][i].getPieceID();
				stop = false;
			} else if (piece[0][0].getPieceID() == piece[1][1].getPieceID()
					&& piece[1][1].getPieceID() == piece[2][2].getPieceID() && piece[2][2].getPieceID() != 0) {
				winner = piece[0][0].getPieceID();
				stop = false;
			} else if (piece[0][2].getPieceID() == piece[1][1].getPieceID()
					&& piece[1][1].getPieceID() == piece[2][0].getPieceID() && piece[2][0].getPieceID() != 0) {
				winner = piece[0][2].getPieceID();
				stop = false;
			}
		}

		winnerID = winner;

	}

	public void reset() throws IOException {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				piece[i][j].resetPiece();
			}
		}
		thisSquare.setImage("-.png");
	}

}
