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

	static int gameState = 1;
	Mouse mouse = new Mouse();

	MainPanel() throws IOException {
		MainMenu m = new MainMenu(); // Instantiates objects
		TicTacToeMenu t = new TicTacToeMenu();
	}

	public void paintComponent(Graphics g) {
		// draw the background

		switch (gameState) {
		case 1:
			g.drawImage(MainMenu.background.img, MainMenu.background.x, MainMenu.background.y, null);
			g.drawImage(MainMenu.button1.img, MainMenu.button1.x, MainMenu.button1.y, null);
			break;
		case 2:
			g.drawImage(TicTacToeMenu.background.img, TicTacToeMenu.background.x, TicTacToeMenu.background.y, null);
			g.drawImage(TicTacToeMenu.onePlayer.img, TicTacToeMenu.onePlayer.x, TicTacToeMenu.onePlayer.y, null);
			g.drawImage(TicTacToeMenu.onePlayerText.img, TicTacToeMenu.onePlayer.x, TicTacToeMenu.onePlayer.y, null);
			g.drawImage(TicTacToeMenu.twoPlayer.img, TicTacToeMenu.twoPlayer.x, TicTacToeMenu.twoPlayer.y, null);
			g.drawImage(TicTacToeMenu.twoPlayerText.img, TicTacToeMenu.twoPlayer.x, TicTacToeMenu.twoPlayer.y, null);
			break;
		case 3: //the connect four state
		break;
		}
	}

	public void run() throws InterruptedException, IOException {
	switch(gameState) {
	case 2: 
		SuperTicTacToe ticTacToe = new SuperTicTacToe();
		ticTacToe.run();
	}
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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

		mouse.mousePressed(e);

	}

}
