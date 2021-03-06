import java.awt.*;
import javax.swing.*;

public class Game extends Canvas {
	public static void main(String[] args) {
		boolean exitGame = false;
		Input input = new Input();
		Game gameWindow = new Game(); // This is the panel for drawing
		gameWindow.addKeyListener(input);
		Board gameBoard = new Board();
		JFrame frame = new JFrame("Pacman");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Renderer renderer = new  Renderer(frame, gameWindow);
		Pacman pacman = new Pacman(2, 2, Color.YELLOW, input, gameBoard, true);
		Ghost[] ghosts = new Ghost[4];
		ghosts[0] = new Ghost(17, 15, Color.PINK, input, gameBoard, true, Behavior.AGGRESSIVE);
		ghosts[1] = new Ghost(16, 15, Color.ORANGE, input, gameBoard, true, Behavior.RANDOM);
		ghosts[2] = new Ghost(14, 15, Color.GREEN, input, gameBoard, true, Behavior.FOLLOW_LEFT);
		ghosts[3] = new Ghost(15, 15, Color.RED, input, gameBoard, true, Behavior.FOLLOW_RIGHT);

		//Game loop
		while (!exitGame) {
			renderer.render(gameBoard, pacman, ghosts);
			
			for(Ghost ghost : ghosts){
				ghost.update();
			}
			pacman.update();
			input.update();
			Thread.yield();
		}
		
	} // end main
} // end class
