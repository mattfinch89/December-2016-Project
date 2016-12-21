import java.io.IOException;

public abstract class Player {

	// Declare player ID and the string holding the .png corresponding to the player
	int playerID;
	String imgName;
	
	public abstract void move(int x, int y) throws IOException;
	
	// Set the player ID, and assign either x or o depending on the player ID
	Player(int id) {
		this.playerID = id;
		if (id == 1) {
			imgName = "x.png";
		} else {
			imgName = "o.png";
		}
	}
	


}
