import java.io.IOException;

public class Piece extends Image {

	private byte pieceID = 0;
	
	Piece(String n, int imageX, int imageY) throws IOException {
		super(n, imageX, imageY);
		// TODO Auto-generated constructor stub
	}

	public void setPieceID(int i) throws IOException {
		this.pieceID = (byte) i;
	}
	
	public void resetPiece() throws IOException {
		setImage("-.png");
		this.pieceID = 0;
		System.out.println(7);
	}

	public int getPieceID() {
		// TODO Auto-generated method stub
		return this.pieceID;
	}
	
	
}
