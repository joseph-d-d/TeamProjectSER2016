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
		int positionInPattern = totalGhostMoves - 11;
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
		positionInPattern = positionInPattern % 146;
		boolean up = false;
		boolean left = false;
		boolean right = false;
		boolean down = false;
		// Determine which direction to move in the pattern
		if (((positionInPattern >= 1) && (positionInPattern < 8))
			|| ((positionInPattern >= 13) && (positionInPattern < 20))
			|| ((positionInPattern >= 44) && (positionInPattern < 48))
			|| ((positionInPattern >= 122) && (positionInPattern < 125))
			|| ((positionInPattern >= 127) && (positionInPattern < 130))
			|| ((positionInPattern >= 132) && (positionInPattern < 135))
			| ((positionInPattern >= 140) && (positionInPattern < 146))
				)
		{
			up = true;
		}
		if (((positionInPattern >= 8) && (positionInPattern < 13))
			|| (positionInPattern >= 60) && (positionInPattern < 65)
			|| (positionInPattern >= 87) && (positionInPattern < 89)
			|| (positionInPattern >= 97) && (positionInPattern < 122)
			|| (positionInPattern >= 130) && (positionInPattern < 132)
				)
		
		{
			left = true;
		}
		if (((positionInPattern >= 20) && (positionInPattern < 25))
			|| ((positionInPattern >= 29) && (positionInPattern < 44))
			|| ((positionInPattern >=48) && (positionInPattern < 53))
			|| ((positionInPattern >=79) && (positionInPattern < 84))
			|| ((positionInPattern >=92) && (positionInPattern < 94))
			|| ((positionInPattern >=125) && (positionInPattern < 127))
			|| ((positionInPattern >=135) && (positionInPattern < 140))
				)
		{
			right = true;
		}	
		if (((positionInPattern >= 25) && (positionInPattern < 29))
			|| ((positionInPattern >= 53) && (positionInPattern < 60))
			|| ((positionInPattern >=65) && (positionInPattern < 79))
			|| ((positionInPattern >=84) && (positionInPattern < 87))
			|| ((positionInPattern >=89) && (positionInPattern < 92))
			|| ((positionInPattern >=94) && (positionInPattern < 97))
				)
		{
			down = true;
		}
		// Move in the correct direction
		if (up && (totalGhostMoves < totalPacmanMoves)){
			// Move ghost up
			if(gameBoard.getGameboard()[yCoord-1][xCoord].isWall() == false){
				yCoord-= 1;
			} // end if
		} // end if
		else if (left && (totalGhostMoves < totalPacmanMoves)){
			// move ghost left
			if(gameBoard.getGameboard()[yCoord][xCoord - 1].isWall() == false){
				xCoord-= 1;
			}
		}
		else if (right && (totalGhostMoves < totalPacmanMoves)){
			// move ghost right			
			if(gameBoard.getGameboard()[yCoord][xCoord + 1].isWall() == false){
				xCoord+= 1;
			}
		}
		else if (down && (totalGhostMoves < totalPacmanMoves)){
			// move ghost down
			if(gameBoard.getGameboard()[yCoord + 1][xCoord].isWall() == false){
				yCoord+= 1;
			}
		}
		
			
			
		
	} // end followLeftPattern
	
	/**
	 * Kills the ghost
	 */
	public void death(){
		isActive = false;
	}
}
