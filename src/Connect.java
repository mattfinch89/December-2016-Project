import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Connect implements MouseListener, KeyListener, MouseMotionListener {
	int round = 0;
	int width;
	int height;
	boolean gameover = true;

	int columnHover = 0;
	int xCoord;
	int yCoord;

	boolean[][] hover = new boolean[8][7];
	int hoverColumn = 0;
	int placeHolder = 0;
	boolean hoverColour;
	boolean columnSwitch;
	boolean[][] used = new boolean[8][7]; // determines if tile is used or not
											// [column][row]
	int[][] colour = new int[8][7]; // whose turn it is / colour of
									// Connect4_Piece [column][row]
	int rowPlaced = 0;
	int columnNum = 0;
	int hoverX;

	ConnectPlayer cp = new ConnectPlayer();
	// Computer ai = new Computer();
	BufferedImage boardImg, redConnect4_Piece, blueConnect4_Piece;

	public Connect() throws IOException {
		URL fileURL = getClass().getResource("Connect4Board.png");
		boardImg = ImageIO.read(fileURL);

		for (int i = 0; i < 8; i++) // set all arrays to false and 0
			for (int j = 0; j < 7; j++) {
				used[i][j] = false;
				colour[i][j] = 0;
			}
	}

	public void paintComponent(Graphics g) {
		g.drawImage(boardImg, 0, 0, null);
		// g.drawString("*Press 'Backspace' to Redo Previous Move*", 10, 15);
		for (int i = 1; i < 8; i++)// draws all previous Connect4_Pieces
		{
			for (int j = 1; j < 7; j++) {
				if (used[i][j]) {
					int x = (i - 1) * 100 + 5; // placed perfectly in tiles with
												// that equations
					int y = 705 - (j * 100);
					Connect4_Piece previous = new Connect4_Piece(x, y, this.colour[i][j], false);
					previous.draw(g);
				}
			}
		}
		boolean end = true;
		for (int i = 1; i < 7 && end && gameover; i++) { // hover "for" loop to
															// draw the
															// transparent
															// Connect4_Piece
			int x = (hoverColumn - 1) * 100 + 5;
			int y = 705 - (i * 100);
			Connect4_Piece placement = new Connect4_Piece(x, y, colour[hoverColumn][i], hoverColour);
			if (!used[hoverColumn][i]) { // will draw all Connect4_Pieces in the
											// column placed
				placement.draw(g);
				end = false;
			}
		}
		for (int i = 1; i < 7 && gameover; i++) {// for loop to place each
													// Connect4_Piece in the
													// specific column and row
			int x = (columnNum - 1) * 100 + 5; // so it draws the current move
			int y = 705 - (i * 100);
			Connect4_Piece p = new Connect4_Piece(x, y, this.colour[columnNum][i], false);
			try {
				p.loadImages();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (used[columnNum][i]) { // will draw all Connect4_Pieces in the
										// column placed
				p.draw(g);
				rowPlaced = i;
			}
		}

		if (gameover) // changes the colour of the tile/switches turns
		{
			if (round % 2 == 0) // player 1 turn - red
			{
				colour[columnNum][rowPlaced] = 1;
				hoverColour = true;
			} else {
				hoverColour = false;
				colour[columnNum][rowPlaced] = 2; // player 2 turn - blue
			}

			if (round == 42) // if the gameboard is full - gameover
				gameover = false;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		cp.turn(xCoord); // refer to ConnectPlayer Class
		columnNum = cp.columnNum; // refer to ConnectPlayer class
		boolean end = true; // just a placeholder to ensure the for loop stops
							// when it hits the first empty spot
		for (int i = 1; i < 7 && end && gameover; i++) {
			if (!used[columnNum][i] && yCoord > 100) // will check for the first
														// row without a
														// Connect4_Piece
			{
				round++;
				used[columnNum][i] = true; // create a new Connect4_Piece in
											// that slot
				end = false; // so it doesn't keep checking and make all the
								// above tiles true
			}
		}
	}

	public void run() throws IOException {
		cp.isWinner(this.colour, this.used);
		if (cp.winner == 1) // player 2 wins
		{
			System.out.println("Winner");
			gameover = false;
		} else if (cp.winner == 2) // player 1 wins
		{
			System.out.println("Winner");
			gameover = false;
		}

		for (int i = 0; i < 7; i++) { // transparent Connect4_Piece hover
										// function
			int x = xCoord / 100; // turns the x coordinate into the column
									// number
			if (x == i) // finds the column it's in
			{
				hoverColumn = i + 1;
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

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
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		
	}	

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) { // for the mouse hover
		// TODO Auto-generated method stub
		this.xCoord = e.getX();
		this.yCoord = e.getY();
		// this.currentX = e.getX();
	}
}