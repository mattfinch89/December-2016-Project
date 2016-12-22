import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

import javax.swing.JPanel;

public class SuperTicTacToe implements KeyListener, MouseMotionListener, MouseListener {

	// Keeps track of play count
	static int play = 0;

	// Holds values for the main and sub columns and row from the previous move.
	static int mainColumn = -1, mainRow = -1;
	static int miniColumn = -1, miniRow = -1;

	// Declaring the main tic-tac-toe board
	static Board mainBoard;

	// Declaring the players
	static Player p1, p2;

	// Holds the final winner value
	static int mainWinner = 0;

	// Determines if player 2 is a computer player or not
	static boolean isComputerPlayer = false;

	SuperTicTacToe() throws IOException {
		// TODO Auto-generated constructor stub

		// Initialize mainboard
		mainBoard = new MainBoard();

		// Initialize player 1 to a human player (player 1 is a human player)
		p1 = new HumanPlayer(1);
	}

	public static void setPlayer2() {
		if (isComputerPlayer) {
			// If the user selected "one player", initialize player 2 to a
			// computer player
			p2 = new ComputerPlayer(2);
		} else {
			// If the user selected "two player", initialize player 2 to a human
			// player
			p2 = new HumanPlayer(2);
			System.out.println(3);
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
			// Ensures that the coords of the click exist on one of the sub
			// boards so no error is caused later in argument code
			boolean validClick = false;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (Mouse.pointOnImage(MainBoard.miniBoard[i][j].background[i][j], e.getX(), e.getY())) {
						validClick = true;
					}
				}
			}

			// If it is player 1's turn, call his move method, otherwise call
			// player 2's move method
			if (validClick) {
				if (play % 2 == 0) {
					try {
						p1.move(e.getX(), e.getY());

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (isComputerPlayer) {
						try {
							p2.move((int) (Math.random() * 3), (int) (Math.random() * 3));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
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

			// If more than 15 moves have been made, we can start checking
			// for a winner. This constantly sets the winner to either 0 (no
			// winner),
			// 1 (player 1 = winner), or 2 (player 2 = winner)
			if (play > 15) {
				if (getWinner() != 0) {
					MainPanel.gameState = 5;
				}
				break;
			}

			// If there is a winner, go to the pause menu so the user can
			// return to the main menu

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

		// If the space bar is pressed during a tic-tac-toe game, go to the
		// pause menu,
		// and vice-versa (if it is in pause menu, go to game)
		if (e.getKeyChar() == ' ') {
			switch (MainPanel.gameState) {
			case 4:
				MainPanel.gameState = 5;
				break;
			case 5:
				MainPanel.gameState = 4;
			}
		}
	}

	// Return the winner
	public int getWinner() {
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
		return mainWinner;
	}

	public void run() {
	}

	// Reset the game
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
		mainWinner = 0;
		isComputerPlayer = false;
	}

}
