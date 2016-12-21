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
	int gamestate = 1;
	int columnHover = 0; 
	int currentX;
	
	boolean [][] used = new boolean [8][7]; //determines if tile is used or not [column][row]
	int[][] colour = new int[8][7]; //whose turn it is / colour of piece [column][row]
	int rowPlaced = 0;
	int columnNum = 0;
	int hoverX;
	
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
		
		for (int i = 0; i < 8; i++) // set all arrays to false and 0
			for(int j = 0; j < 7; j++)
			{
				used[i][j] = false; 
				colour[i][j] = 0;
			}
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		switch (gamestate)
		{
		
		case 1:
			if (gameover)
			{
				g.drawImage(boardImg, 0, 0, null);
			}
			else if (!gameover)
			{
				g.drawImage(boardImg, 0, 0, null);
			}

			for(int i = 1; i < 8; i++)
			{
				for(int j = 1; j < 7; j++)
				{
					if (used[i][j])
					{
						int xCoord = (i - 1) * 100 + 5;
						int yCoord = 705 - (j * 100);
						Piece previous = new Piece(xCoord, yCoord, this.colour[i][j]);
						previous.draw(g); //draws all previous pieces
					}
				}
			}
			
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
						//TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if (used[columnNum][i])
					{ // will draw all pieces in the tile placed
						p.draw(g);
						rowPlaced = i;
					}
				}
				
				if (gameover) // changes the colour of the tile/switches turns
				{
					if (round % 2 == 0)//true = player 1 turn
						colour[columnNum][rowPlaced] = 1;
					else
						colour[columnNum][rowPlaced] = 2; // false = player 2 turn
					
					if (round == 42)
						gameover = false;
				}
				break;
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
			int xCoord = e.getX();
			int yCoord = e.getY();
			columnNum = 0;
			cp.turn(xCoord);
			columnNum = cp.columnNum; //refer to ConnectPlayer class
			
			boolean end = true;
			switch (gamestate)
			{
			case 0:
			case 1:
				for (int i = 1; i < 7 && end && gameover;i++)
				{
					if (!used[columnNum][i] && yCoord > 100) //will check for the first row without a piece
					{	
						round++; 
						used[columnNum][i] = true; //create a new piece in that slot
						System.out.println(round); 
						end = false; //so it doesn't keep checking and make all the above tiles true
					}
				}
			break;
			}
	}
	
	public void run() throws IOException
	{
		switch (gamestate)
		{
		case 1: 
			cp.isWinner(this.colour, this.used);
			
			if (cp.winner == 1) //player 2 wins
			{
				System.out.println("Winner");
				gameover = false;
			}
			else if (cp.winner == 2) //player 1 wins
			{
				System.out.println("Winner");
				gameover = false; 
			}
			
			if (gameover)
			{
				boolean end = true; 
				for (int i = 1; i < 7 && end;i++)
				{
					columnHover = (this.currentX / 100) + 1;
					if (!used[columnHover][i])
					{	
						System.out.println(columnHover);
						used[columnHover][i] = true; 
						end = false;
					}
				}
			}
			break;
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
	public void mouseMoved(MouseEvent e) { //for the mouse hover
		// TODO Auto-generated method stub
		this.currentX = e.getX();
	}
	
}








