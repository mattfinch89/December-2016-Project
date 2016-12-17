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
	int [][] column = new int[6][5];
	int[] numPieces = new int [7];
	boolean turn;
	int columnNum = 0;
	ConnectPlayer cp = new ConnectPlayer();

	BufferedImage boardImg, redPiece, bluePiece, whoseTurn; 
	
	public Connect() throws IOException
	{
		URL fileURL = getClass().getResource("Connect4Board.png");
		boardImg = ImageIO.read(fileURL);
		
		fileURL = getClass().getResource("redpiece.png");
		redPiece = ImageIO.read(fileURL);

		fileURL = getClass().getResource("bluepiece.png");
		bluePiece = ImageIO.read(fileURL);

		for (int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 5; j++)
			column[i][j] = 0;
		}
	}
	
	@Override
	public void paintComponent(Graphics g)
	{	
		g.drawImage(boardImg, 0, 0, null);
		
		if (turn)
		{
			whoseTurn = bluePiece;
		}
		else if (!turn)
		{
			whoseTurn = redPiece;
		}
		
		if (cp.column)
		{
			g.drawImage(whoseTurn, (columnNum - 1) * 100 + 5, 104, null); //+4 to y and + 5 to x
		}
		
		for (int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				if (column[i][j] == 1)
				{
					//draw player 1
				}
				if (column[i][j] == 2)
				{
				//draw player 2
				}
			}
				
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int xCoord = e.getX();
		columnNum = 0;
		cp.turn(xCoord);
		columnNum = cp.columnNum;
		round++;
		
		if (round % 2 == 0) //false = player 1 turn
			turn = false; 
		else if(round % 2 != 0)
			turn = true; // true = player 2 turn 
	
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
