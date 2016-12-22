import java.awt.event.MouseEvent;
import java.io.IOException;

public class PauseMenu {

	// Declare the background and back button
	Image background;
	static Image backButton;

	PauseMenu() throws IOException {

		// Initialize the background and back button 
		background = new Image("PauseBackground.png", 0, 0);
		backButton = new Image("BackButton.png", 140, 200);
	}

	public static void mousePressed(MouseEvent e) throws IOException {
		// TODO Auto-generated method stub
		
		// If the back button was clicked, go back to the main menu and 
		// reset the Super Tic-Tac-Toe board for the next time it is selected
		if (Mouse.pointOnImage(backButton, e.getX(), e.getY())) {
			MainPanel.gameState = 1;
			SuperTicTacToe.resetGame();
		}

	}

}
