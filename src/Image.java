import java.awt.image.BufferedImage;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {

	BufferedImage img;
	int x, y;
	boolean hover;
	String name, hoverName;

	Image(String n, int imageX, int imageY) throws IOException {
		hover = false;
		this.x = imageX;
		this.y = imageY;
		this.name = n;
		setImage(name);
	}
	
	Image(String n, String hn, int imageX, int imageY) throws IOException {
		hover = false;
		this.x = imageX;
		this.y = imageY;
		this.name = n;
		this.hoverName = hn;
		setImage(name);
	}
	
	void hoverCheck(int x, int y) {
		if (Mouse.pointOnImage(this, x, y)) {
			this.hover = true;
			try {
				this.setImage(this.hoverName);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (this.hover) {
			try {
				this.setImage(this.name);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	void setImage(String n) throws IOException {
		java.net.URL fileURL = getClass().getResource(n);
		img = ImageIO.read(fileURL);
	}

}
