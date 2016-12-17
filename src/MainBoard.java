import java.io.IOException;

public class MainBoard extends Board {
static Image background;
static MiniBoard[][] miniBoard;
	MainBoard() throws IOException {
		background = new Image("MainBoard.png", 0, 0);
		miniBoard = new MiniBoard[3][3];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				miniBoard[i][j] = new MiniBoard(i,j);
			}
		}
	}
	
}
