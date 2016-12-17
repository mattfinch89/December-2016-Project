import java.io.IOException;

public class Piece extends Image {

	private byte pieceID = 0;
	
	Piece(String n, int imageX, int imageY) throws IOException {
		super(n, imageX, imageY);
		// TODO Auto-generated constructor stub
	}

	public void setPieceID(int i) {
		this.pieceID = (byte) i;
	}

	public int getPieceID() {
		// TODO Auto-generated method stub
		return this.pieceID;
	}
	
}
