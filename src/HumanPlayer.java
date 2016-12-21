import java.io.IOException;

public class HumanPlayer extends Player {

	HumanPlayer(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(int x, int y) throws IOException {
		// TODO Auto-generated method stub

		if (isValidMove(getMainColumn(x), getMainRow(y))) {
			MainBoard.miniBoard[getMainRow(y)][getMainColumn(x)].move(x, y, this.playerID);
			
		}

	}

	private boolean isValidMove(int x, int y) {
		// TODO Auto-generated method stub

		if (((SuperTicTacToe.mainColumn == -1) || (x == SuperTicTacToe.miniColumn
				&& y == SuperTicTacToe.miniRow) || 
				MainBoard.miniBoard[SuperTicTacToe.miniRow][SuperTicTacToe.miniColumn].winnerID != 0) && 
				MainBoard.miniBoard[y][x].winnerID == 0) {
			return true;
		} else {
			return false;
		}

	}

	public static void setMainColumn(int x) {
		SuperTicTacToe.mainColumn = x / 233;
	}

	public static void setMainRow(int y) {
		SuperTicTacToe.mainRow = y / 233;
	}
	
	public static int getMainColumn(int x) {
		return x / 233;
		
	}

	public static int getMainRow(int y) {
		return y / 233;
	}
	

}
