import java.io.IOException;

public abstract class Player {

	int playerID;
	String imgName;
	
	public abstract void move(int x, int y) throws IOException;
	
	Player(int id) {
		
		
		this.playerID = id;
		if (id == 1) {
			imgName = "x.png";
		} else {
			imgName = "o.png";
		}
	}
	


}
