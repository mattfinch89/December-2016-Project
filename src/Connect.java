import java.awt.Color;
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

public class Connect extends JPanel implements MouseListener, KeyListener, MouseMotionListener 
{
	
	int round = 0;
	int width;
	int height;
	int[] numPieces = new int [7];
	boolean [][] used = new boolean [8][7];
	
	int [] xCoordBlue = new int [43];
	int [] yCoordBlue = new int [43];
	int [] xCoordRed = new int [43];
	int [] yCoordRed = new int [43];
	
	boolean turn;
	int columnNum = 0;
	ConnectPlayer cp = new ConnectPlayer();

	BufferedImage boardImg, redPiece, bluePiece; 
	
	public Connect() throws IOException
	{
		URL fileURL = getClass().getResource("Connect4Board.png");
		boardImg = ImageIO.read(fileURL);
		
		fileURL = getClass().getResource("redpiece.png");
		redPiece = ImageIO.read(fileURL);

		fileURL = getClass().getResource("bluepiece.png");
		bluePiece = ImageIO.read(fileURL);
		for (int i = 0; i < 8; i++)
			for(int j = 0; j < 7; j++)
				used[i][j] = false; 
	}
	
	@Override
	public void paintComponent(Graphics g)
	{	
		g.drawImage(boardImg, 0, 0, null);
		
		boolean y = true; //once the first unused tile is found stop running
		
		for (int i = 0; i < 7 && y; i++)
		{
			if (!used[columnNum][i])
			{
				if(turn)
				{
					xCoordBlue[i] = (columnNum - 1) * 100 + 5;
					yCoordBlue[i] = 705 - (i * 100);
					g.drawImage(bluePiece, xCoordBlue[i], yCoordBlue[i], null); //+4 to y and + 5 to x
					y = false;
				}
				else if(!turn)
				{
					xCoordRed[i] = (columnNum - 1) * 100 + 5;
					yCoordRed[i] = 705 - (i * 100);
					g.drawImage(redPiece, xCoordRed[i], yCoordRed[i], null); //+4 to y and + 5 to x
					y = false;
				}
				
			}
		}
		
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int xCoord = e.getX();
		int yCoord = e.getY();
		columnNum = 0;
		cp.turn(xCoord);
		columnNum = cp.columnNum;
		round++;
		
		if (round % 2 == 0) //false = player 1 turn
			turn = true; 
		else if(round % 2 != 0)
			turn = false; // true = player 2 turn 
		boolean z = true;
		
		for (int i = 0; i < 7 && z;i++)
		{
			if (!used[columnNum][i])
			{
				used[columnNum][i] = true; 
				z = false;
			}
		}
		
		
	}
	
	public void run() throws IOException
	{
		
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
	public void keyPressed(KeyEvent e) {
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
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
