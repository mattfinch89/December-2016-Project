import java.io.IOException;

public class HumanPlayer extends Player {

	HumanPlayer(int id) {
		// Call the super constructor
		super(id);
	}

	@Override
	public void move(int x, int y) throws IOException {

		// If its a valid move in terms of the square selected on the main board, call the mini board move method 
		if (SuperTicTacToe.mainBoard.isValidMove(SuperTicTacToe.mainBoard.getColumn(x,y), SuperTicTacToe.mainBoard.getRow(x,y))) {
			MainBoard.miniBoard[SuperTicTacToe.mainBoard.getRow(x,y)][SuperTicTacToe.mainBoard.getColumn(x,y)].move(x, y, this.playerID);
			
		}

	}



	

}
