
public class Connect implements Grid {
	
	int rounds = 0;
	int width;
	int height;
	
	public void onPlacedX(int x, int y){ //coordinates of move
		
		rounds++;
	}
	public void onPlacedO(int x, int y){ //coordinates of move
		
		rounds++;
	}
	
	@Override
	public void setGrid(int w, int h) {
		// TODO Auto-generated method stub
		width = w;
		height = h;
	}

	@Override
	public void setWidth(int w) {
		// TODO Auto-generated method stub
		width = w;
	}

	@Override
	public void setHeight(int h) {
		// TODO Auto-generated method stub
		height = h;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}
	
	
}
