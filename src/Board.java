
public abstract class Board implements Grid {
	
	int width, height;
	int[][] space; {
		space = new int[3][3];
		
		for (int col = 0; col < this.width; col++) {
			for (int row = 0; row < this.height; row++) {
				this.space[col][row] = 0;
			}
 		}
	}
	private int winner;
	
	@Override
	public void setGrid(int w, int h) {
		// TODO Auto-generated method stub
	
		this.width = 3;
		this.height = 3;
		
	}

	@Override
	public void setWidth(int w) {
		// TODO Auto-generated method stub
		this.width = w;
	}

	@Override
	public void setHeight(int h) {
		// TODO Auto-generated method stub
		this.height = h;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return this.width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return this.height;
	}
	
	public int getWinner() {
		return this.winner;		
	}
	
	public void setWinner(int w) {
		this.winner = w;
	}

	

}
