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
	
	private void followRightPattern(){
		
	}
	
	private void followLeftPattern(){
		
	}
	
	/**
	 * Kills the ghost
	 */
	public void death(){
		isActive = false;
	}
	
}
