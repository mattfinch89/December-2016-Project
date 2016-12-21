import java.io.IOException;

public class MiniBoard implements Board {

	// Declare the sub board images
	static Image[][] background = new Image[3][3];

	// Declare the panel indicator (translucent green square
	// indicating the sub board on which the user may make his/her move), and
	// the large winner image (if a sub board is won, it displays the character
	// corresponding to the player that has won)
	Image thisSquare, bigWinner;

	// Declare the pieces on the sub board
	Piece[][] piece = new Piece[3][3];

	// Declare and initialize values used to set x and y values for the above
	// declarations
	static int column = 0, row = 0;

	// Declare and initialize the Winner ID
	int winnerID = 0;

	MiniBoard(int col, int row) throws IOException {

		// Initialize the sub board background images
		background[row][col] = new Image("MiniPanel.png", 25 * (column + 1) + 200 * column,
				19 * (this.row + 1) + 200 * this.row);

		// Initialize all piece images to blank images
		for (int c = 0; c < 3; c++) {
			for (int r = 0; r < 3; r++) {
				piece[c][r] = new Piece("-.png", background[row][col].x + 67 * c, background[row][col].y + 67 * r);
			}
		}

		// Initialize all sub board indicators images to blank images
		thisSquare = new Image("-.png", 25 * (column + 1) + 200 * column, 19 * (this.row + 1) + 200 * this.row);

		// Initialize all sub board winner images to a blank image
		bigWinner = new Image("-.png", 25 * (column + 1) + 200 * column, 19 * (this.row + 1) + 200 * this.row);

		// This is for declaring the x and y values. Increment the column each
		// time, until all three columns of a row have been filled. Then,
		// increment row and reset column, until all rows and columns are
		// assigned. This works because each time another of the 9 sub boards
		// are initialized, a step of this process happens
		column++;
		if (column == 3) {
			this.row++;
			column = 0;
		}

	}

	@Override
	public boolean isValidMove(int x, int y) {
		// TODO Auto-generated method stub

		// If the piece selected is not occupied, it is a valid move
		if (piece[getColumn(x, y)][getRow(x, y)].getPieceID() == 0)
			return true;
		else
			return false;
	}

	@Override
	public int getColumn(int x, int y) {
		// TODO Auto-generated method stub

		// Return the column value of the square of the sub board clicked
		int col = SuperTicTacToe.mainBoard.getColumn(x, y), row = SuperTicTacToe.mainBoard.getRow(x, y);
		return (x - background[col][row].x) / 67;
	}

	@Override
	public int getRow(int x, int y) {
		// TODO Auto-generated method stub

		// Return the row value of the square of the sub board clicked
		int col = SuperTicTacToe.mainBoard.getColumn(x, y), row = SuperTicTacToe.mainBoard.getRow(x, y);
		return (y - background[col][row].y) / 67;

	}

	public void move(int x, int y, int playerID) throws IOException {
		// TODO Auto-generated method stub

		// If it is a valid move: increment the play count, set the main and
		// mini column and row values, and assign either "x" or "o" images to
		// the piece depending on which player has made the move
		if (isValidMove(x, y)) {
			SuperTicTacToe.play++;
			SuperTicTacToe.mainBoard.setColumn(x, y);
			SuperTicTacToe.mainBoard.setRow(x, y);
			setColumn(x, y);
			setRow(x, y);

			if (playerID == 1) {
				piece[SuperTicTacToe.miniColumn][SuperTicTacToe.miniRow].setImage(SuperTicTacToe.p1.imgName);
				piece[SuperTicTacToe.miniColumn][SuperTicTacToe.miniRow].setPieceID(1);
			} else {
				piece[SuperTicTacToe.miniColumn][SuperTicTacToe.miniRow].setImage(SuperTicTacToe.p2.imgName);
				piece[SuperTicTacToe.miniColumn][SuperTicTacToe.miniRow].setPieceID(2);
			}

			// A green translucent square goes over the sub board that the next
			// move must be within
			MainBoard.miniBoard[SuperTicTacToe.miniRow][SuperTicTacToe.miniColumn].thisSquare
					.setImage("ThisSquare.png");

			// If a player has won this sub board, assign a large x or o to the bigWinner image
			if (getWinner() != 0) {
				SuperTicTacToe.mainColumn = -1;
				if (getWinner() == 1)
					bigWinner.setImage("xWin.png");
				else
					bigWinner.setImage("oWin.png");
			}

			// If 
			if (MainBoard.miniBoard[SuperTicTacToe.miniRow][SuperTicTacToe.miniColumn].getWinner() != 0) {
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

	// Returns the winner of this sub board
	public int getWinner() {
		boolean dontStop = true;
		for (int i = 0; i < 3 && dontStop; i++) {
			if (piece[i][0].getPieceID() == piece[i][1].getPieceID()
					&& piece[i][0].getPieceID() == piece[i][2].getPieceID() && piece[i][2].getPieceID() != 0) {
				winnerID = piece[i][0].getPieceID();
				dontStop = false;
			} else if (piece[0][i].getPieceID() == piece[1][i].getPieceID()
					&& piece[0][i].getPieceID() == piece[2][i].getPieceID() && piece[2][i].getPieceID() != 0) {
				winnerID = piece[0][i].getPieceID();
				dontStop = false;
			} else if (piece[0][0].getPieceID() == piece[1][1].getPieceID()
					&& piece[1][1].getPieceID() == piece[2][2].getPieceID() && piece[2][2].getPieceID() != 0) {
				winnerID = piece[0][0].getPieceID();
				dontStop = false;
			} else if (piece[0][2].getPieceID() == piece[1][1].getPieceID()
					&& piece[1][1].getPieceID() == piece[2][0].getPieceID() && piece[2][0].getPieceID() != 0) {
				winnerID = piece[0][2].getPieceID();
				dontStop = false;
			}
		}
		return winnerID;
	}

	public void reset() throws IOException {
		// TODO Auto-generated method stub

		// Resets this sub board
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				piece[i][j].resetPiece();
			}
		}
		winnerID = 0;
		thisSquare.setImage("-.png");
		bigWinner.setImage("-.png");
	}

	@Override
	public void setColumn(int x, int y) {
		// TODO Auto-generated method stub
		
		// Sets the sub board column to the value clicked 
		int col = SuperTicTacToe.mainBoard.getColumn(x, y), row = SuperTicTacToe.mainBoard.getRow(x, y);
		SuperTicTacToe.miniColumn = (x - background[col][row].x) / 67;
	}

	@Override
	public void setRow(int x, int y) {
		// TODO Auto-generated method stub
		
		// Sets the sub board row to the value clicked 
		int col = SuperTicTacToe.mainBoard.getColumn(x, y), row = SuperTicTacToe.mainBoard.getRow(x, y);
		SuperTicTacToe.miniRow = (y - background[col][row].y) / 67;
	}

}
