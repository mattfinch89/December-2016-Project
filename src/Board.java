
public abstract class Board implements Grid {
	
	int width, height;
	int[][] space; 
	int winner;
	
	@Override
	public void setGrid(int w, int h) {
		// TODO Auto-generated method stub
	
		this.width = 3;
		this.height = 3;
		
		this.space = new int[w][h];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				this.space[i][j] = 0;
			}
 		}
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
