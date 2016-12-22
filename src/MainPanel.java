import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import sun.audio.*;
import javax.swing.*;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;

public class MainPanel extends JPanel implements KeyListener, MouseMotionListener, MouseListener {

	// Determines which panel to run
	static int gameState = 1;

	// Declaring and instantiating objects for the game
	Mouse mouse = new Mouse();
	PauseMenu pauseMenu = new PauseMenu();
	static SuperTicTacToe ticTacToe;
	static Connect connect4;

	MainPanel() throws IOException {

		// Instantiates objects that require throws IOException
		MainMenu mainMenu = new MainMenu();
		TicTacToeMenu ticTacToeMenu = new TicTacToeMenu();
		ticTacToe = new SuperTicTacToe();
		connect4 = new Connect();
	}

	@Override
	public void paintComponent(Graphics g) {

		// Draw the game
		switch (gameState) {

		// Draw the Main Menu
		case 1:
			g.drawImage(MainMenu.background.img, MainMenu.background.x, MainMenu.background.y, null);
			g.drawImage(MainMenu.button1.img, MainMenu.button1.x, MainMenu.button1.y, null);
			g.drawImage(MainMenu.button2.img, MainMenu.button2.x, MainMenu.button2.y, null);
			break;

		// Draw the Super Tic-Tac-Toe Menu
		case 2:
			g.drawImage(TicTacToeMenu.background.img, TicTacToeMenu.background.x, TicTacToeMenu.background.y, null);
			g.drawImage(TicTacToeMenu.onePlayer.img, TicTacToeMenu.onePlayer.x, TicTacToeMenu.onePlayer.y, null);
			g.drawImage(TicTacToeMenu.onePlayerText.img, TicTacToeMenu.onePlayer.x, TicTacToeMenu.onePlayer.y, null);
			g.drawImage(TicTacToeMenu.twoPlayer.img, TicTacToeMenu.twoPlayer.x, TicTacToeMenu.twoPlayer.y, null);
			g.drawImage(TicTacToeMenu.twoPlayerText.img, TicTacToeMenu.twoPlayer.x, TicTacToeMenu.twoPlayer.y, null);
			break;
<<<<<<< HEAD
		case 3: //the connect four state
		break;
=======

		// Draw the Super Tic-Tac-Toe game and the pause menu
		case 5:
		case 4:
		case 3:
			g.drawImage(MainBoard.background.img, MainBoard.background.x, MainBoard.background.y, null);

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					g.drawImage(MainBoard.miniBoard[i][j].background[i][j].img,
							MainBoard.miniBoard[i][j].background[i][j].x, MainBoard.miniBoard[i][j].background[i][j].y,
							null);
					g.drawImage(MainBoard.miniBoard[j][i].thisSquare.img, MainBoard.miniBoard[j][i].thisSquare.x,
							MainBoard.miniBoard[j][i].thisSquare.y, null);
				}
			}

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					for (int c = 0; c < 3; c++) {
						for (int r = 0; r < 3; r++) {
							g.drawImage(MainBoard.miniBoard[i][j].piece[c][r].img,
									MainBoard.miniBoard[i][j].piece[c][r].x, MainBoard.miniBoard[i][j].piece[c][r].y,
									null);
						}
					}
				}
			}

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					g.drawImage(MainBoard.miniBoard[i][j].bigWinner.img, MainBoard.miniBoard[i][j].bigWinner.x,
							MainBoard.miniBoard[i][j].bigWinner.y, null);
				}
			}

			if (gameState == 5) {
				g.drawImage(pauseMenu.background.img, pauseMenu.background.x, pauseMenu.background.y, null);
				g.drawImage(pauseMenu.backButton.img, pauseMenu.backButton.x, pauseMenu.backButton.y, null);
			}
			break;
		case 6:
			connect4.paintComponent(g);
			break;
>>>>>>> 766e0944c3e4454cdc6094aee49b30f4ca3e7cf9
		}

	}

	// Run the game
	public void run() throws InterruptedException, IOException {
		switch (gameState) {
		case 6: 
			connect4.run();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

		// If a Super Tic-Tac-Toe game is being run or paused, call its
		// keyReleased method
		switch (MainPanel.gameState) {
		case 5:
		case 4:
			ticTacToe.keyReleased(e);
			break;

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		switch (gameState) {
		case 6: 
			connect4.mouseClicked(e);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		mouse.mouseMoved(e);

	}

	public Clip loadClip(String filename) {
		Clip clip = null;

		try {
			AudioFileFormat audioIn = AudioSystem.getAudioFileFormat(getClass().getResource("Dora Theme Song.mp3"));
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return clip;
	}

	public void playClip(Clip clip) {
		stopClip(clip);
		clip.start();

	}

	private void stopClip(Clip clip) {
		// TODO Auto-generated method stub
		if (clip.isRunning()) {
			clip.stop();
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

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		// Call the mouse "mousePressed" method
		mouse.mousePressed(e);

	}

}
