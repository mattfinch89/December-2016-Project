import java.io.IOException;

public class MainMenu  {

	static Image background, button1, button2;

	MainMenu() throws IOException {
		background = new Image("Menu Background.png", 0, 0);
		button1 = new Image("SuperTicTacToe.png", 47, 200);
		button2 = new Image("SuperTicTacToe.png", 396, 200);
	}

	

}
