
public class Board {
	private Position[][] gameBoard = null;
	
	public Board(){
		gameBoard = new Position[32][28];
		for(int i = 0; i < 32; i++){
			for(int j = 0; j < 28; j++){
				if(i == 0){
					gameBoard[i][j] = new Position(true);
				}
				if(i == 1){
					if(j == 13 || j == 0 || j == 27){
						gameBoard[i][j] = new Position(true);
					}
					else{
						gameBoard[i][j] = new Position(false);
					}
				}
				else if(i == 2 || i == 3){
					if(j == 0 || (j >= 2 && j <= 5) || (j >= 7 && j <= 11) || j == 13 || j == 27){
						gameBoard[i][j] = new Position(true);
					}
					else{
						gameBoard[i][j] = new Position(false);
					}
				}
				else{
					gameBoard[i][j] = new Position(true);
				}
				
			}
		}
	}
	
	public Position[][] getGameboard(){
		return gameBoard;
	}

}
