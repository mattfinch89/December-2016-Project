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
	boolean gameover = true; 
	
	boolean [][] used = new boolean [8][7]; //determines if tile is used or not
	boolean[][] colour = new boolean[8][7]; //whose turn it is / colour of piece
	int rowPlaced = 0;
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
			
		for(int i = 1; i < 8; i++)
		{
			for(int j = 1; j < 7; j++)
			{
				if (used[i][j])
				{
					int xCoord = (i - 1) * 100 + 5;
					int yCoord = 705 - (j * 100);
					
					Piece previous = new Piece(xCoord, yCoord, this.colour[i][j]);
					previous.draw(g); //draws all previous moves
				}
			}
		}
		if (gameover)
		{
			for (int i = 1; i < 7 && gameover; i++)
			{
				int xCoord = (columnNum - 1) * 100 + 5;
				int yCoord = 705 - (i * 100);	
				Piece p = new Piece(xCoord, yCoord, this.colour[columnNum][i]);
				try 
				{
					p.loadImages();
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (used[columnNum][i])
				{	
					rowPlaced = i;
					p.draw(g);
				}
			}
			
			if (round % 2 == 0)//true = player 1 turn
				colour[columnNum][rowPlaced] = true;
			else
				colour[columnNum][rowPlaced] = false; // false = player 2 turn
			
			if (round == 42)
				gameover = false;
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (gameover)
		{
			int xCoord = e.getX();
			int yCoord = e.getY();
			columnNum = 0;
			cp.turn(xCoord);
			columnNum = cp.columnNum;
			
			boolean z = true;
			
			for (int i = 1; i < 7 && z && gameover;i++)
			{
				if (!used[columnNum][i] && yCoord > 100)
				{
					used[columnNum][i] = true; 
					round++;
					z = false;
				}
			}
		}
	}
	
	public void run() throws IOException
	{
		cp.isWinner(this.colour, this.used);
		
		if (cp.winner == 1) //player 1 wins
		{
			System.out.println("Winner");
		}
		else if (cp.winner == 2) //player 2 wins
		{
			
		}
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









