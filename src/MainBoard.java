import java.io.IOException;

public class MainBoard implements Board {

	// Declare the background image and sub boards
	static Image background;
	static MiniBoard[][] miniBoard;

	MainBoard() throws IOException {
		
		// Initialize the background image and sub boards
		background = new Image("MainBoard.png", 0, 0);
		miniBoard = new MiniBoard[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				miniBoard[i][j] = new MiniBoard(i, j);
			}
		}
	}

	@Override
	public boolean isValidMove(int x, int y) {
		// TODO Auto-generated method stub

		// If the main column has been assigned -1, or the main square clicked is the same position on the 
		// large grid as the small square was on the small grid on the previous turn, or if the main square 
		// on the large grid corresponding to the small square position on the small grid of the previous turn 
		// has already been won, and the board clicked has not been won, it is a valid move
		if (((SuperTicTacToe.mainColumn == -1) || (x == SuperTicTacToe.miniColumn && y == SuperTicTacToe.miniRow)
				|| MainBoard.miniBoard[SuperTicTacToe.miniRow][SuperTicTacToe.miniColumn].getWinner() != 0)
				&& MainBoard.miniBoard[y][x].getWinner() == 0) {
			return true;
		} else {
			return false;
		}
	}


	@Override
	public int getColumn(int x, int y) {
		// TODO Auto-generated method stub
		
		// Return the column of the square that was clicked (0, 1, or 2)  
		return x / 233;
	}
	
	@Override
	public int getRow(int x, int y) {
		// TODO Auto-generated method stub
		
		// Return the row of the square that was clicked (0, 1, or 2)  
		return y / 233;
	}


	@Override
	public void setColumn(int x, int y) {
		// TODO Auto-generated method stub
		
		// Set the mainColumn value to the column of the square that was clicked (0, 1, or 2)
		SuperTicTacToe.mainColumn = x / 233;
	}

	@Override
	public void setRow(int x, int y) {
		// TODO Auto-generated method stub
		
		// Set the mainRow value to the column of the square that was clicked (0, 1, or 2)
		SuperTicTacToe.mainRow = y / 233;
	}
}
