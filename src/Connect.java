
public class Connect implements Grid {
	
	int rounds = 0;
	int width;
	int height;
	int [][] column = new int[6][5];

	
	public Connect()
	{
		for (int i = 0; i <= 6; i++)
		{
			for(int j = 0; j <= 5; j++)
			column[i][j] = 0;
		}
	}
	
	public void onPlacedX(int column){ //coordinates of move
		boolean placeHolder = true;
		for (int i = 0; i <= 5 && placeHolder; i++)
		{
			if (this.column[column][i] == 0)
			{
				this.column[column][i] = 1;
				placeHolder = false; 
			}
		}
		rounds++;
	}
	public void onPlacedO(int column){ //coordinates of move
		boolean placeHolder = true;
		for (int i = 0; i <= 5 && placeHolder; i++)
		{
			if (this.column[column][i] == 0)
			{
				this.column[column][i] = 2;
				placeHolder = false;
			}
				
		}
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
