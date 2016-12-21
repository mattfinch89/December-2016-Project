import java.io.IOException;

public class TicTacToeMenu {
	
	static Image background, onePlayer, onePlayerText, twoPlayer, twoPlayerText;
	
	TicTacToeMenu() throws IOException {
		 background = new Image("TTTBackground.png", 0, 0);
		 onePlayer = new Image("PlayButton_1.png", "PlayButton_2.png", 140, 200);
		 onePlayerText = new Image("One_Player.png", 140, 200);
		 twoPlayer = new Image("PlayButton_1.png", "PlayButton_2.png", 140, 350);
		 twoPlayerText = new Image("Two_Player.png", 140, 350);
	}
}
