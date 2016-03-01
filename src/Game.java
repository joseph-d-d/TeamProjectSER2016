import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

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
		ghosts[0] = new Ghost(17, 15, Color.PINK, input, gameBoard, 
				Behavior.AGGRESSIVE, Direction.LEFT, true);
		ghosts[1] = new Ghost(16, 15, Color.ORANGE, input, gameBoard, 
				Behavior.RANDOM, Direction.RIGHT, true);
		ghosts[2] = new Ghost(14, 15, Color.GREEN, input, gameBoard, 
				Behavior.FOLLOW_LEFT, Direction.UP, true);
		ghosts[3] = new Ghost(15, 15, Color.RED, input, gameBoard, 
				Behavior.FOLLOW_RIGHT, Direction.UP, true);

		//Game loop
		while (!exitGame) {
			renderer.render(gameBoard, pacman, ghosts);
			pacman.update();
			for(Ghost ghost : ghosts){
				ghost.update();
			}
			if(input.getIsKeyPressed()){
				if(input.getCurrentKey().getKeyCode() == KeyEvent.VK_ESCAPE){
					exitGame = true;
				}
			}
			input.update();
			Thread.yield();
		}
		//Close the game.
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	} // end main
} // end class