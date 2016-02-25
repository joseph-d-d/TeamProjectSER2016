import java.awt.event.KeyEvent;

public class Pacman extends GameObject {
	
	private int lives = 3;

	public Pacman(int x, int y, Input input, Board gameBoard) {
		super(x, y, input, gameBoard);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(){
		if(input.getIsKeyPressed() == true){
			if(input.getCurrentKey().getKeyCode() == KeyEvent.VK_A){
				System.out.println("Move pacman left");
				xCoord -= 1;
			}
			if(input.getCurrentKey().getKeyCode() == KeyEvent.VK_D){
				System.out.println("Move pacman right");
				xCoord += 1;
			}
			if(input.getCurrentKey().getKeyCode() == KeyEvent.VK_W){
				System.out.println("Move pacman up");
				yCoord -= 1;
			}
			if(input.getCurrentKey().getKeyCode() == KeyEvent.VK_S){
				System.out.println("Move pacman down");
				yCoord += 1;
			}
			
			
		}
	}
	
	private void loseLife(){
		lives--;
		if(lives == 0){
			death();
		}
	}
	
	private void death(){
		isActive = false;
	}
	
	public void draw(){
		
	}
}
