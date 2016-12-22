import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Piece {
	
	private int x, y;
//	private static int round;
	private static BufferedImage redPiece, bluePiece, transRed, transBlue;
	boolean hover;
	private int blue;
	public Piece (int x, int y, int blue, boolean hover)
	{
		this.hover = hover;
		this.blue = blue; 
		this.x = x;
		this.y = y;
	}
	
	public void loadImages() throws IOException
	{
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
	{
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
	
//	public static int rounds()
//	{
//		System.out.println(round);
//		return round;
//	}

//	public boolean colour(){
//		if (round % 2 == 0)
//			return blue;
//		else
//			return !blue;
//	}
//		
}
 