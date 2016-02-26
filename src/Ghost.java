import java.awt.Color;

public class Ghost extends GameObject {
	private Behavior behavior;
	
	protected Ghost(int x, int y, Color color, Input input, Board gameBoard, Behavior behavior) {
		super(x, y, color, input, gameBoard);
		this.behavior = behavior;
	}
	
	@Override
	/**
	 * Update is run every frame and performs what ever actions need to be
	 * run for ghost like moving.
	 */
	public void update(){
		//removes sets that spot free as it move to a new one
		gameBoard.getGameboard()[yCoord][xCoord].setOccupiedBy(null);
		//Calls the AI behavior for the current ghost
		switch(behavior){
		case AGGRESSIVE:
			aggressiveMovePattern();
			break;
		case RANDOM:
			randomMovePattern();
			break;
		case FOLLOW_RIGHT:
			followRightPattern();
			break;
		case FOLLOW_LEFT:
			followLeftPattern();
			break;
		default:
			System.out.print("Error no behavoir assigned");
			break;
		}
		//occupies a spot so pacman can check for collision
		gameBoard.getGameboard()[yCoord][xCoord].setOccupiedBy(this);
	}
	
	private void calculateNextMove(){
		
	}

	private void randomMovePattern(){
		
	}
	
	private void aggressiveMovePattern(){
		
	}
	
	// This ghost travels a set path on the inner square of the grid
	private void followRightPattern(){
		int totalPacmanMoves = input.getTotalPacmanMoves();
		int totalGhostMoves = input.getTotalGhostMoves();
		int positionInPattern = totalGhostMoves - 11;
		System.out.println("Position in pattern: " + positionInPattern);
		// First 12 moves to get ghost to into his pattern
		if ((totalPacmanMoves > 0) && (totalGhostMoves < totalPacmanMoves) 
				&& totalGhostMoves < 12){
			switch (totalPacmanMoves){
			case 1:
			case 2:
				// Move ghost up
				if(gameBoard.getGameboard()[yCoord-1][xCoord].isWall() == false){
					yCoord-= 1;
				}
				break;
			case 3:
			case 4:
			case 5:
			case 6:
			case 10:
			case 11:
			case 12:
				// Move ghost right
				if(gameBoard.getGameboard()[yCoord][xCoord + 1].isWall() == false){
					xCoord+= 1;
				}
				break;
			case 7:
			case 8:
			case 9:
				// Move ghost down
				if(gameBoard.getGameboard()[yCoord + 1][xCoord].isWall() == false){
					yCoord+= 1;
				}
				break;
			default:
				// Do nothing. Ghost is already in his pattern
				break;			
			} // end switch
			totalGhostMoves++;
			input.setTotalGhostMoves(totalGhostMoves);
		} // end if
		// Ghost is inside the pattern
		else
		{
			//System.out.println("Total ghost moves = " + totalGhostMoves);
			if ((xCoord == 22) && (yCoord >= 7) && (totalGhostMoves < totalPacmanMoves))
			{
				// Move ghost up
				yCoord-= 1;
				totalGhostMoves++;
				input.setTotalGhostMoves(totalGhostMoves);			
			}
			else if ((yCoord == 6) && (xCoord > 7) && (totalGhostMoves < totalPacmanMoves))
			{
				// Move ghost left
				xCoord-= 1;
				totalGhostMoves++;
				input.setTotalGhostMoves(totalGhostMoves);	
			}
			else if ((xCoord == 7) && (yCoord < 26) && (totalGhostMoves < totalPacmanMoves))
			{
				// Move ghost down
				yCoord+= 1;
				totalGhostMoves++;
				input.setTotalGhostMoves(totalGhostMoves);	
			}
			else if((yCoord == 26) && (totalGhostMoves < totalPacmanMoves))
			{
				// Move ghost right
				xCoord+= 1;
				totalGhostMoves++;
				input.setTotalGhostMoves(totalGhostMoves);	
			}
		}
	}
	
	private void followLeftPattern(){
		int totalPacmanMoves = input.getTotalPacmanMoves();
		int totalGhostMoves = input.getTotalGhostMoves();
		// First 12 moves to get ghost to into his pattern
		if ((totalPacmanMoves > 0) && (totalGhostMoves < totalPacmanMoves) 
				&& totalGhostMoves < 12){
			switch (totalPacmanMoves){
			case 1:
			case 2:
				// Move ghost up
				if(gameBoard.getGameboard()[yCoord-1][xCoord].isWall() == false){
					yCoord-= 1;
				}
				break;
			case 3:
			case 4:
			case 5:
			case 6:
			case 10:
			case 11:
			case 12:
				// Move ghost left
				if(gameBoard.getGameboard()[yCoord][xCoord - 1].isWall() == false){
					xCoord-= 1;
				}
				break;
			case 7:
			case 8:
			case 9:
				// Move ghost down
				if(gameBoard.getGameboard()[yCoord + 1][xCoord].isWall() == false){
					yCoord+= 1;
				}
				break;
			default:
				// Do nothing. Ghost is already in his pattern
				break;			
			} // end switch
		} // end if
		
		// Ghost is inside the pattern
		
	}
	
	/**
	 * Kills the ghost
	 */
	public void death(){
		isActive = false;
	}
}
