import java.awt.Color;
import java.awt.event.KeyEvent;

public class Pacman extends GameObject {
	
	private int lives = 3;

	public Pacman(int x, int y, Color color, Input input, Board gameBoard) {
		super(x, y, color, input, gameBoard);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(){
		if(input.getIsKeyPressed() == true){
			if(input.getCurrentKey().getKeyCode() == KeyEvent.VK_A){
				if(gameBoard.getGameboard()[yCoord][xCoord-1].isWall() == false){
					xCoord -= 1;
					System.out.println("Move pacman left");
				}
			}
			if(input.getCurrentKey().getKeyCode() == KeyEvent.VK_D){
				if(gameBoard.getGameboard()[yCoord][xCoord+1].isWall() == false){
					xCoord += 1;
					System.out.println("Move pacman right");
				}
			}
			if(input.getCurrentKey().getKeyCode() == KeyEvent.VK_W){
				if(gameBoard.getGameboard()[yCoord-1][xCoord].isWall() == false){
					yCoord -= 1;
					System.out.println("Move pacman up");
				}
			}
			if(input.getCurrentKey().getKeyCode() == KeyEvent.VK_S){
				if(gameBoard.getGameboard()[yCoord+1][xCoord].isWall() == false){
					yCoord += 1;
					System.out.println("Move pacman down");
				}
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
	
}
