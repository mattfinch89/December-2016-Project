import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Piece {
	
	private int x, y;
	private static BufferedImage redPiece, bluePiece;
	
	private boolean blue;
	public Piece (int x, int y, boolean blue)
	{
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
	}
	
	public void draw(Graphics g)
	{
		if (blue)
			g.drawImage(bluePiece, x, y, null);
		
		else if(!blue)
			g.drawImage(redPiece, x, y, null);
	}
	
	public boolean colour(){
		return blue;
	}
		
}
 