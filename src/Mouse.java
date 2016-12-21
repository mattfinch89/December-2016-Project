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
			// Super Tic-Tac-Toe Button
			if (pointOnImage(MainMenu.button1, e.getX(), e.getY())) {
				MainPanel.gameState = 2;
			}
			break;
		case 2:
			if (pointOnImage(TicTacToeMenu.onePlayer, e.getX(), e.getY())) {
				MainPanel.gameState = 3;
			} else if (pointOnImage(TicTacToeMenu.twoPlayer, e.getX(), e.getY())) {
				MainPanel.gameState = 4;
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

		switch (MainPanel.gameState) {
		case 2:
			TicTacToeMenu.onePlayer.hoverCheck(e.getX(), e.getY());
			TicTacToeMenu.twoPlayer.hoverCheck(e.getX(), e.getY());
			break;

		}
	}

	static boolean pointOnImage(Image image, int x, int y) {

		if (x >= image.x && x <= image.x + image.img.getWidth() && y >= image.y
				&& y <= image.y + image.img.getHeight()) {
			return true;
		} else {
			return false;
		}

	}

}
