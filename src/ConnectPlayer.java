
public class ConnectPlayer {
	int columnNum = 0;
	boolean column = false;
	boolean row = false;
	int winner = 0; //1 = player 1 win, 2 = player 2 win
	int verticalWin = 0;
	boolean vertical, vertCheck; 
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
			}
		}
	}
	
	public void isWinner(boolean[][] colour, boolean [][] used)
	{
		for (int i = 1; i < colour[1].length; i++) // vertical check
		{
			for (int j = 1; j < colour[2].length; j++)
			{
				System.out.println(verticalWin);
				if (colour[i][j] && used[i][j])
				{
					if (!vertical)
						verticalWin = 0;
					vertical = true;
					verticalWin++;
				}
				else if (!colour[i][j] && used[i][j])
				{
					if (vertical)
						verticalWin = 0;
					vertical = false;
					verticalWin--;
				}	
				if (verticalWin == 4)
					winner = 1;
				if(verticalWin == -4)
					winner = 2;
			}
		}
	}
	
}
