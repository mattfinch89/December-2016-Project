import java.awt.event.MouseEvent;
import java.io.IOException;

public class PauseMenu {

	Image background;
	static Image backButton;
	
	PauseMenu() throws IOException {
		background = new Image("PauseBackground.png", 0, 0);
		backButton = new Image("BackButton.png", 140, 200);
	}

	public static void mousePressed(MouseEvent e) throws IOException {
		// TODO Auto-generated method stub
		if (Mouse.pointOnImage(backButton, e.getX(), e.getY()))
				MainPanel.gameState = 1;
		SuperTicTacToe.resetGame();
			
		
	}
	
}
