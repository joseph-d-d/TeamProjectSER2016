import java.awt.Color;
import java.util.Random;

public class Ghost extends GameObject {
	private static int numberOfGhosts = 0;
	private Behavior behavior;
	private Direction direction;
	
	
	protected Ghost(int x, int y, Color color, Input input, Board gameBoard, 
			Behavior behavior, Direction direction, boolean isActive) {
		super(x, y, color, input, gameBoard, isActive);
		this.behavior = behavior;
		this.direction = direction;
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
			System.out.print("Error no behavior assigned");
			break;
		}
		//occupies a spot so pacman can check for collision
		gameBoard.getGameboard()[yCoord][xCoord].setOccupiedBy(this);
	}
	
	private void calculateNextMove(){
		
	}

	private void randomMovePattern(){
		int totalPacmanMoves = input.getTotalPacmanMoves();
		int totalGhostMoves = input.getTotalGhostMoves();
		boolean up = false;
		boolean down = false;
		boolean left = false;
		boolean right = false;
		// Determine which direction ghost should move
		// First five moves should always be the same
		if ((totalPacmanMoves > 0) && (totalGhostMoves < totalPacmanMoves)
				&& (totalGhostMoves < 2))
		{
			left = true;
		}
		else if ((totalPacmanMoves > 2) && (totalGhostMoves < totalPacmanMoves)
				&& (totalGhostMoves < 4))
		{
			up = true;
		}
		else if ((totalPacmanMoves == 5) && (totalGhostMoves < totalPacmanMoves))
		{
			right = true;
		}	
		// If no wall and not a fork, keep moving
		else if (gameBoard.getGameboard()[yCoord][xCoord].isFork() == false)
		{
			switch(direction){
			case UP:
				if (gameBoard.getGameboard()[yCoord-1][xCoord].isWall() == false)
				{
					up = true;
				}
				break;
			case DOWN:
				if (gameBoard.getGameboard()[yCoord + 1][xCoord].isWall() == false)
				{
					down = true;
				}
				break;
			case RIGHT:
				if (gameBoard.getGameboard()[yCoord][xCoord + 1].isWall() == false)
				{
					right = true;
				}
				break;
			case LEFT:
				if (gameBoard.getGameboard()[yCoord][xCoord - 1].isWall() == false)
				{
					left = true;
				}
				break;
			default:
				System.out.print("Error no direction assigned");
				break;
			} // end switch
		} // end if 
		else
		{
			// By default this is a fork
			// Choose a random number between 1 and 4 to determine direction
			Random random = new Random();
			int randomDirection = random.nextInt(4) + 1;
			boolean hasMoved = false;
			while (!hasMoved)
			{
				// Direction is valid if not a wall 
				switch (randomDirection)
				{
				case 1:
				{
					// 1 represents up. Ghost can move up if up is not a wall
					if (gameBoard.getGameboard()[yCoord-1][xCoord].isWall() == false)
					{
						up = true;
						hasMoved = true;
					}
					else 
						randomDirection = 2;
				}
					break;
				case 2:
				{	
					// 2 represents right
					if (gameBoard.getGameboard()[yCoord][xCoord + 1].isWall() == false)
					{
						right = true;
						hasMoved = true;
					}
					else 
						randomDirection = 3;
				}
					break;
				case 3:
				{
					// 3 represents down
					if (gameBoard.getGameboard()[yCoord + 1][xCoord].isWall() == false)
					{
						down = true;
						hasMoved = true;
					}
					else 
						randomDirection = 4;
				}
					break;
				case 4:
				{
					if (gameBoard.getGameboard()[yCoord][xCoord - 1].isWall() == false)
					{
						left = true;
						hasMoved = true;
					}
					else 
						randomDirection = 1;
				}
					break;
				default:
					// This code will never be reached
					break;					
				} // end switch 	
				
			} // end while
		
		} // end else for fork


		// Move in the direction determined
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
	}
	
	private void aggressiveMovePattern(){
		int totalPacmanMoves = input.getTotalPacmanMoves();
		int totalGhostMoves = input.getTotalGhostMoves();
		boolean up = false;
		boolean down = false;
		boolean left = false;
		boolean right = false;
		// Determine which direction ghost should move
		// First five moves should always be the same
		if ((totalPacmanMoves > 0) && (totalGhostMoves < totalPacmanMoves)
				&& (totalGhostMoves < 2))
		{
			left = true;
		}
		else if ((totalPacmanMoves > 2) && (totalGhostMoves < totalPacmanMoves)
				&& (totalGhostMoves < 4))
		{
			up = true;
		}
		else if ((totalPacmanMoves == 5) && (totalGhostMoves < totalPacmanMoves))
		{
			left = true;
		}


		// Move in the direction determined
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
		
	}
	
	// This ghost travels a set path on the inner square of the grid
	private void followRightPattern(){
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
	} // end followRightPattern
	
	private void followLeftPattern(){
		int totalPacmanMoves = input.getTotalPacmanMoves();
		int totalGhostMoves = input.getTotalGhostMoves();
		int positionInPattern = (totalGhostMoves - 11) % 146;
		if (positionInPattern == 0 && totalGhostMoves > 13)
		{
			positionInPattern++;
		}
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
		positionInPattern = positionInPattern % 147;
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
			| ((positionInPattern >= 140) && (positionInPattern < 146)))
		{
			up = true;
		}
		if (((positionInPattern >= 8) && (positionInPattern < 13))
			|| (positionInPattern >= 60) && (positionInPattern < 65)
			|| (positionInPattern >= 87) && (positionInPattern < 89)
			|| (positionInPattern >= 97) && (positionInPattern < 122)
			|| (positionInPattern >= 130) && (positionInPattern < 132))	
		{
			left = true;
		}
		if (((positionInPattern >= 20) && (positionInPattern < 25))
			|| ((positionInPattern >= 29) && (positionInPattern < 44))
			|| ((positionInPattern >=48) && (positionInPattern < 53))
			|| ((positionInPattern >=79) && (positionInPattern < 84))
			|| ((positionInPattern >=92) && (positionInPattern < 94))
			|| ((positionInPattern >=125) && (positionInPattern < 127))
			|| ((positionInPattern >=135) && (positionInPattern < 140)))
		{
			right = true;
		}	
		if (((positionInPattern >= 25) && (positionInPattern < 29))
			|| ((positionInPattern >= 53) && (positionInPattern < 60))
			|| ((positionInPattern >=65) && (positionInPattern < 79))
			|| ((positionInPattern >=84) && (positionInPattern < 87))
			|| ((positionInPattern >=89) && (positionInPattern < 92))
			|| ((positionInPattern >=94) && (positionInPattern < 97)))
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
	public void death() {
		gameBoard.getGameboard()[yCoord][xCoord].setOccupiedBy(null);
		numberOfGhosts--;
		isActive = false;
		
	}
	
	public int getNumberOfGhosts() {
		return numberOfGhosts;
	}
}