
public interface Board {

	// Checks if the move is valid
	boolean isValidMove(int x, int y);
	
	// Returns the row value of the selected square
	int getRow(int x, int y);
	
	// Returns the column value of the selected square
	int getColumn(int x, int y);
	
	// Assigns the column value to that of the selected square
	void setColumn(int x, int y);
	
	// Assigns the row value to that of the selected square
	void setRow(int x, int y);
}
