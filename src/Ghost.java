public class Ghost extends GameObject {
	private Behavior behavior;
	
	protected Ghost(int x, int y, Input input, Board gameBoard, Behavior behavior) {
		super(x, y, input, gameBoard);
		this.behavior = behavior;
	}
	
	@Override
	public void update(){
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
	
}
