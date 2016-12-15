import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Connect implements Grid, MouseListener {
	
	int rounds = 0;
	int width;
	int height;
	int [][] column = new int[6][5];
	boolean [] tile = new boolean [6];

	
	public Connect()
	{
		for (int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 5; j++)
			column[i][j] = 0;
		}
	}
	
	public void onPlacedX(int column){ //coordinates of move
		boolean emptySpace = true;
		for (int i = 0; i <= 5 && emptySpace; i++)
		{
			if (this.column[column][i] == 0 && emptySpace)
			{
				this.column[column][i] = 1;
				emptySpace = false; 
			}
		}
		rounds++;
	}
	public void onPlacedO(int column){ //coordinates of move
		boolean emptySpace = true;
		for (int i = 0; i <= 5 && emptySpace; i++)
		{
			if (this.column[column][i] == 0)
			{
				this.column[column][i] = 2;
				emptySpace = false;
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int xCoord = e.getX();
		if (xCoord < 100)
		{
			tile[0] = true;
		}
		for (int i = 1; i <= 6; i++)
		{
			if (xCoord > i * 100 && xCoord < (i * 100) + 100)
			{
				tile[i] = true;
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
