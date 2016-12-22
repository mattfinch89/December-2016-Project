import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Connect4_Piece {
	
	private int x, y;
//	private static int round;
	private static BufferedImage redPiece, bluePiece, transRed, transBlue;
	boolean hover;
	private int blue;
	public Connect4_Piece (int x, int y, int blue, boolean hover)
	{
		this.hover = hover; //whether or not it's just the hovered piece
		this.blue = blue; //if it is blue or red
		this.x = x; //X coordinate
		this.y = y; //y coordinate
	}
	
	public void loadImages() throws IOException
	{ // load the images
		URL fileURL = getClass().getResource("redpiece.png");
		redPiece = ImageIO.read(fileURL);
		fileURL = getClass().getResource("bluepiece.png");
		bluePiece = ImageIO.read(fileURL);
		
		fileURL = getClass().getResource("transpiece.png");
		transBlue= ImageIO.read(fileURL);
		
		fileURL = getClass().getResource("transred.png");
		transRed = ImageIO.read(fileURL);
	}
	
	public void draw(Graphics g)
	{ // draw the images based on whose turn
		if (blue == 1)
				g.drawImage(bluePiece, x, y, null);
		else if(blue == 2)
				g.drawImage(redPiece, x, y, null);
		
		else if (blue == 0)
		{
			if (hover)
				g.drawImage(transRed, x, y, null);
			else 
				g.drawImage(transBlue, x, y, null);
		}
	}	
}
 