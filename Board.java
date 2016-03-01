public class Board {
	private int numberOfPellets = 0;
	private Position[][] gameBoard = null;
	
	public Board(){
		gameBoard = new Position[34][30];
		// 0 represents an blank
		// 1 represents a wall
		// 2 represents a pellet
		// 3 represents a power pellet
		// 4 represents a pellet and a fork
		// 5 represents a blank and a fork
		int[][] boardArray = 
			{
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
				{0,1,2,2,2,2,2,2,1,2,2,2,2,2,1,1,2,2,2,2,2,1,2,2,2,2,2,2,1,0},
				{0,1,2,1,1,1,1,2,1,2,1,1,1,2,1,1,2,1,1,1,2,1,2,1,1,1,1,2,1,0},
				{0,1,3,1,0,0,1,2,1,2,1,0,1,2,1,1,2,1,0,1,2,1,2,1,0,0,1,3,1,0},
				{0,1,2,1,1,1,1,2,1,2,1,1,1,2,1,1,2,1,1,1,2,1,2,1,1,1,1,2,1,0},
				{0,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,0},
				{0,1,2,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,2,1,0},
				{0,1,2,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,2,1,0},
				{0,1,2,2,2,2,2,2,1,1,2,2,2,2,1,1,2,2,2,2,1,1,2,2,2,2,2,2,1,0},
				{0,1,1,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,1,1,0},
				{0,0,0,0,0,0,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,0,0,0,0,0,0},
				{0,0,0,0,0,0,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,0,0,0,0,0,0},
				{0,0,0,0,0,0,1,2,1,1,0,0,0,5,0,0,5,0,0,0,1,1,2,1,0,0,0,0,0,0},
				{0,0,0,0,0,0,1,2,1,1,0,1,1,1,0,0,1,1,1,0,1,1,2,1,0,0,0,0,0,0},
				{0,1,1,1,1,1,1,2,1,1,0,1,0,0,0,0,0,0,1,0,1,1,2,1,1,1,1,1,1,0},
				{0,0,0,0,0,0,0,2,0,0,5,1,0,0,0,0,0,0,1,5,0,0,2,0,0,0,0,0,0,0},
				{0,1,1,1,1,1,1,2,1,1,0,1,0,0,0,0,0,0,1,0,1,1,2,1,1,1,1,1,1,0},
				{0,0,0,0,0,0,1,2,1,1,0,1,0,0,0,0,0,0,1,0,1,1,2,1,0,0,0,0,0,0},
				{0,0,0,0,0,0,1,2,1,1,0,1,1,1,1,1,1,1,1,0,1,1,2,1,0,0,0,0,0,0},
				{0,0,0,0,0,0,1,2,1,1,5,0,0,0,0,0,0,0,0,5,1,1,2,1,0,0,0,0,0,0},
				{0,0,0,0,0,0,1,2,1,1,0,1,1,1,1,1,1,1,1,0,1,1,2,1,0,0,0,0,0,0},
				{0,1,1,1,1,1,1,2,1,1,0,1,1,1,1,1,1,1,1,0,1,1,2,1,1,1,1,1,1,0},
				{0,1,2,2,2,2,2,2,2,2,2,2,2,2,1,1,2,2,2,2,2,2,2,2,2,2,2,2,1,0},
				{0,1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1,0},
				{0,1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1,0},
				{0,1,3,2,2,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,1,2,2,3,1,0},
				{0,1,1,1,2,1,1,2,1,1,2,1,1,1,1,1,1,1,1,2,1,1,2,1,1,2,1,1,1,0},
				{0,1,1,1,2,1,1,2,1,1,2,1,1,1,1,1,1,1,1,2,1,1,2,1,1,2,1,1,1,0},
				{0,1,2,2,2,2,2,2,1,1,2,2,2,2,1,1,2,2,2,2,1,1,2,2,2,2,2,2,1,0},
				{0,1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1,0},
				{0,1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1,0},
				{0,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,0},
				{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0}
			};

		for (int i = 0; i < 34; i++)
		{
			for (int j = 0; j < 30; j++)
			{
				if(boardArray[i][j] == 0){
					gameBoard[i][j] = new Position(false, true, false, false);
				}
				// Draw wall positions for array values of 1
				if (boardArray[i][j] == 1)
				{
					gameBoard[i][j] = new Position(true, false, false, false);
				} // end if
				// Draw pellet positions for array values of 2
				if (boardArray[i][j] == 2)
				{
					gameBoard[i][j] = new Position(false, false, true, false);
					numberOfPellets++;
				}
				// Draw power pellets for array values of 3
				if (boardArray[i][j] == 3)
				{
					gameBoard[i][j] = new Position(false, false, true, false);
					numberOfPellets++;
				}
				// Position is blank and a fork
				if(boardArray[i][j] == 5){
					gameBoard[i][j] = new Position(false, true, false, true);
				}
				 
			} // end inner for loop
		} // end outer for loop
	}
	
	public Position[][] getGameboard(){
		return gameBoard;
	}
	
	public int getNumberOfPellets(){
		return numberOfPellets;
	}
	
	public void reducePelletCount(){
		numberOfPellets--;
	}

}