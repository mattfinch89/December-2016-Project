import java.io.IOException;

public class Piece extends Image {

	// Declare and initialize the piece ID to 0
	private byte pieceID = 0;
	
	// Call the super constructor 
	Piece(String n, int imageX, int imageY) throws IOException {
		super(n, imageX, imageY);
		// TODO Auto-generated constructor stub
	}

	// Assign a value to piece ID
	public void setPieceID(int i) throws IOException {
		this.pieceID = (byte) i;
	}
	
	// Reset the piece by setting the image to a blank image, and the piece ID to 0
	public void resetPiece() throws IOException {
		setImage("-.png");
		this.pieceID = 0;
	}

	// Return the piece ID 
	public int getPieceID() {
		// TODO Auto-generated method stub
		return this.pieceID;
	}
	
	
}
