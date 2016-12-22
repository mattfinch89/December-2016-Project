import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

public class Mouse implements MouseMotionListener, MouseListener {

	Mouse() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		switch (MainPanel.gameState) {
		case 1:
			// If Super Tic-Tac-Toe Button, go to Super Tic-Tac-Toe menu
			if (pointOnImage(MainMenu.button1, e.getX(), e.getY())) {
				MainPanel.gameState = 2;
			} else if (pointOnImage(MainMenu.button2, e.getX(), e.getY())) {
				MainPanel.gameState = 6;
			}
			break;
		case 2:
			// Super Tic-Tac-Toe Menu, "One Player" and "Two Player" buttons
			if (pointOnImage(TicTacToeMenu.onePlayer, e.getX(), e.getY())) {
				MainPanel.gameState = 4;
				SuperTicTacToe.isComputerPlayer = true;
				SuperTicTacToe.setPlayer2();
			} else if (pointOnImage(TicTacToeMenu.twoPlayer, e.getX(), e.getY())) {
				MainPanel.gameState = 4;
				SuperTicTacToe.setPlayer2();
			}
			break;
		case 3: 
		case 4:
			// Super Tic-Tac-Toe game
			MainPanel.ticTacToe.mousePressed(e);
			break;
		case 5:
			// Call Super Tic-Tac-Toe pause menu "mousePressed" method
			try {
				PauseMenu.mousePressed(e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

		// If the mouse is hovering over a button, change the buttons image to
		// show the user he/she is hovering over that button.
		switch (MainPanel.gameState) {
		case 2:
			TicTacToeMenu.onePlayer.hoverCheck(e.getX(), e.getY());
			TicTacToeMenu.twoPlayer.hoverCheck(e.getX(), e.getY());
			break;
		case 6: 
			MainPanel.connect4.mouseMoved(e);
		}
	}

	static boolean pointOnImage(Image image, int x, int y) {

		// Boolean determines if the point x,y (declared in parameters) is on 
		// the image (also in parameters)
		if (x >= image.x && x <= image.x + image.img.getWidth() && y >= image.y
				&& y <= image.y + image.img.getHeight()) {
			return true;
		} else {
			return false;
		}

	}

}
