import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

import javax.swing.JPanel;

public class SuperTicTacToe implements KeyListener, MouseMotionListener, MouseListener {

	static int play = 0;
	static int mainColumn = -1, mainRow = -1;
	static int miniColumn = -1, miniRow = -1;

	static Board mainBoard;
	static Player p1, p2;
	static int mainWinner = 0;

	SuperTicTacToe() throws IOException {
		// TODO Auto-generated constructor stub

		mainBoard = new MainBoard();
		p1 = new HumanPlayer(1);

		if (MainPanel.gameState == 3) {
			p2 = new HumanPlayer(2);
		} else {
			p2 = new HumanPlayer(2);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		switch (MainPanel.gameState) {

		default:
			boolean validClick = false;

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (Mouse.pointOnImage(MainBoard.miniBoard[i][j].background[i][j], e.getX(), e.getY())) {
						validClick = true;
					}
				}
			}

			if (validClick) {
				if (play % 2 == 0) {
					try {
						p1.move(e.getX(), e.getY());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					try {
						p2.move(e.getX(), e.getY());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

			if (play > 15) {
				setWinner();
			}

			if (mainWinner != 0) {
				MainPanel.gameState = 5;
			}

			break;
		case 5:

			break;
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

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyChar() == ' ') {
			switch (MainPanel.gameState) {
			case 3:
				MainPanel.gameState = 5;
				break;
			case 5:
				MainPanel.gameState = 3;
			}
		}
	}

	public void setWinner() {
		boolean stop = true;
		for (int i = 0; i < 3 && stop; i++) {
			if (MainBoard.miniBoard[i][0].winnerID == MainBoard.miniBoard[i][1].winnerID
					&& MainBoard.miniBoard[i][0].winnerID == MainBoard.miniBoard[i][2].winnerID
					&& MainBoard.miniBoard[i][2].winnerID != 0) {
				mainWinner = MainBoard.miniBoard[i][0].winnerID;
			} else if (MainBoard.miniBoard[0][i].winnerID == MainBoard.miniBoard[1][i].winnerID
					&& MainBoard.miniBoard[0][i].winnerID == MainBoard.miniBoard[2][i].winnerID
					&& MainBoard.miniBoard[2][i].winnerID != 0) {
				mainWinner = MainBoard.miniBoard[0][i].winnerID;
			} else if (MainBoard.miniBoard[0][0].winnerID == MainBoard.miniBoard[1][1].winnerID
					&& MainBoard.miniBoard[1][1].winnerID == MainBoard.miniBoard[2][2].winnerID
					&& MainBoard.miniBoard[2][2].winnerID != 0) {
				mainWinner = MainBoard.miniBoard[0][0].winnerID;
			} else if (MainBoard.miniBoard[0][2].winnerID == MainBoard.miniBoard[1][1].winnerID
					&& MainBoard.miniBoard[1][1].winnerID == MainBoard.miniBoard[2][0].winnerID
					&& MainBoard.miniBoard[2][0].winnerID != 0) {
				mainWinner = MainBoard.miniBoard[0][2].winnerID;
			}
		}
	}

	public int getWinner() {
		return mainWinner;
	}

	public void run() {

	}

	public static void resetGame() throws IOException {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				MainBoard.miniBoard[i][j].reset();
			}
		}
		play = 0;
		mainColumn = -1;
		mainRow = -1;
		miniColumn = -1;
		miniRow = -1;
	}

}
