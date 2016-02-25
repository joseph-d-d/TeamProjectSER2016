import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class Game extends Canvas {
	public static void main(String[] args) {
		boolean exitGame = false;
		Input input = new Input();
		Game gameWindow = new Game(); // This is the panel for drawing
		gameWindow.addKeyListener(input);
		Board gameBoard = new Board();
		JFrame frame = new JFrame("Pacman");
		Pacman pacman = new Pacman(2, 2, Color.YELLOW, input, gameBoard);
		Ghost[] ghosts = new Ghost[4];
		ghosts[0] = new Ghost(13, 15, Color.PINK, input, gameBoard, Behavior.AGGRESSIVE);
		ghosts[1] = new Ghost(14, 16, Color.ORANGE, input, gameBoard, Behavior.RANDOM);
		ghosts[2] = new Ghost(15, 15, Color.BLUE, input, gameBoard, Behavior.FOLLOW_LEFT);
		ghosts[3] = new Ghost(17, 15, Color.RED, input, gameBoard, Behavior.FOLLOW_RIGHT);
		Renderer renderer = new  Renderer(frame, gameWindow);
		
		
		// drawNewMaze(frame, gameWindow);

		while (!exitGame) {
			
			renderer.render(gameBoard, pacman, ghosts);
			pacman.update();
			input.update();
			Thread.yield();
		}

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} // end main

} // end class