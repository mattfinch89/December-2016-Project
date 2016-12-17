
public class ConnectPlayer {
	int columnNum = 0;
	boolean column = false;
	boolean row = false;
	int rowNum = 0;
	public void turn (int x)
	{
		this.columnNum = 0;
		this.column = false; 
		for (int i = 0; i <= 6; i++) //determine which column was clicked
		{
			if (x > i * 100 && x < (i * 100) + 100)
			{
				this.column = true;
				this.columnNum += i + 1;
				System.out.println(columnNum);
			}
		}
	}
}
