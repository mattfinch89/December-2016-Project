import java.awt.image.BufferedImage;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {

	// Declare the BufferedImage, x and y int values, a boolean determining if
	// the mouse is hovering over an image, and the name of the .png of the main
	// BufferedImage and the one assigned when the mouse is hovering over the
	// image
	BufferedImage img;
	int x, y;
	boolean hover;
	String name, hoverName;

	// Declare the image's main image, x, and y values 
	Image(String n, int imageX, int imageY) throws IOException {
		hover = false;
		this.x = imageX;
		this.y = imageY;
		this.name = n;
		setImage(name);
	}
	// Declare the image's main image, hovered image, x, and y values 
	Image(String n, String hn, int imageX, int imageY) throws IOException {
		hover = false;
		this.x = imageX;
		this.y = imageY;
		this.name = n;
		this.hoverName = hn;
		setImage(name);
	}

	// If the mouse is hovering over this image, change the image to the hovered image
	void hoverCheck(int x, int y) {
		if (Mouse.pointOnImage(this, x, y)) {
			this.hover = true;
			try {
				this.setImage(this.hoverName);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (this.hover && !Mouse.pointOnImage(this, x, y)) {
			try {
				this.setImage(this.name);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	// Assign the BufferedImage
	void setImage(String n) throws IOException {
		java.net.URL fileURL = getClass().getResource(n);
		img = ImageIO.read(fileURL);
	}

}
