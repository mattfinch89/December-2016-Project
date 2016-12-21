
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
			if (x > i * 100 && x < (i * 100) + 100) //separates the columns into 7 different sections
			{
				this.column = true;  //tells you the column placed in
				this.columnNum += i + 1; //tells you the column number starting at 1 ending at 7
			}
		}
	}
	
	public void isWinner(int[][] colour, boolean [][] used)
	{
		for (int i = 1; i < colour[1].length; i++) // vertical check
		{
			boolean firstVert = colour[i][1] == colour[i][2] && colour[i][2] == colour[i][3] 
					&& colour[i][3] == colour[i][4];
			boolean secondVert = colour[i][2] == colour[i][3] 
					&& colour[i][3] == colour[i][4] && colour[i][4] == colour[i][5];
			boolean thirdVert = colour[i][3] == colour[i][4] && colour[i][4] == colour[i][5] 
					&& colour[i][5] == colour[i][6];
			if (firstVert || secondVert || thirdVert)
			{
				if (colour[i][4] == 1) 
				{
					winner = 1;
				}
				else if (colour[i][4] == 2)
				{
					winner = 2;
				}
			}
		}
		
		for (int i = 1; i < colour[2].length; i++) // Horizontal check
		{
			boolean firstHor = colour[1][i] == colour[2][i] && colour[2][i] == colour[3][i] 
					&& colour[3][i] == colour[4][i];
			boolean secondHor = colour[2][i] == colour[3][i] 
					&& colour[3][i] == colour[4][i] && colour[4][i] == colour[5][i];
			boolean thirdHor = colour[3][i] == colour[4][i] && colour[4][i] == colour[5][i] 
					&& colour[5][i] == colour[6][i];
			boolean fourthHor = colour[4][i] == colour[5][i] && colour[5][i] == colour[6][i] 
					&& colour[6][i] == colour[7][i];
			if (firstHor || secondHor || thirdHor || fourthHor)
			{
				if (colour[4][i] == 1) 
				{
					winner = 1;
				}
				else if (colour[4][i] == 2)
				{
					winner = 2;
				}
			}
		}
		
		for (int i = 1; i < 5; i++) //diagonal up to the right
			for (int j = 1; j < 4; j++)
			{
				boolean diagonal = colour[i][j] == colour[i + 1][j + 1] 
						&& colour[i + 1][j + 1] == colour[i + 2][j + 2]
						&& colour[i + 2][j + 2] == colour[i + 3][j + 3]; 
				if (colour[i][j] == 1 && diagonal)
				{
					winner = 1;
				}
				else if (colour[i][j] == 2 && diagonal)
				{
					winner = 2;
				}
				
			}
		
		for (int i = 7; i > 3; i--) // diagonal up to the left 
			for (int j = 1; j < 4; j++)
			{
				boolean diagonal = colour[i][j] == colour[i - 1][j + 1] 
						&& colour[i - 1][j + 1] == colour[i - 2][j + 2]
						&& colour[i - 2][j + 2] == colour[i - 3][j + 3]; 
				if (colour[i][j] == 1 && diagonal)
				{
					winner = 1;
				}
				else if (colour[i][j] == 2 && diagonal)
				{
					winner = 2;
				}
				
			}
	}
}









