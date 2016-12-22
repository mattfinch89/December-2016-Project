import java.io.IOException;

public class Connect4Menu {

	// Declare all images of the Super Tic-Tac-Toe menu
	static Image background, onePlayer, onePlayerText;

	// Initialize all images of the Super Tic-Tac-Toe menu
	Connect4Menu() throws IOException {
			 background = new Image("TTTBackground.png", 0, 0);
			 onePlayer = new Image("PlayButton_1.png", "PlayButton_2.png", 140, 200);
			 onePlayerText = new Image("One_Player.png", 140, 200);
		}

}
