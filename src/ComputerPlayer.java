import java.io.IOException;

public class ComputerPlayer extends Player {

	ComputerPlayer(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(int x, int y) throws IOException {
		// TODO Auto-generated method stub

		int subX = (int) (Math.random() * 3), subY = (int) (Math.random() * 3);

		if (SuperTicTacToe.mainColumn == -1) {
			while (MainBoard.miniBoard[y][x].getWinner() != 0) {
				x = (int) (Math.random() * 3);
				y = (int) (Math.random() * 3);
				
			}
		} else {
			x = SuperTicTacToe.miniColumn;
			y = SuperTicTacToe.miniRow;	
		}
		while (MainBoard.miniBoard[y][x].piece[subX][subY].getPieceID() != 0) {
			subX = (int) (Math.random() * 3);
			subY = (int) (Math.random() * 3);
		}
		
		//System.out.println(x + " " + y + " " + subX + " " + subY);
		MainBoard.miniBoard[y][x].move(subX, subY, this.playerID);
	}
}
