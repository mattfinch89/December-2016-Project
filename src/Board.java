
public class Board implements Grid {

	
	
	int width, height;
	
	@Override
	public void setGrid(int w, int h) {
		// TODO Auto-generated method stub
		this.width = w;
		this.height = h;
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

}
