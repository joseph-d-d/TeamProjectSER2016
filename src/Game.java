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
		Pacman pacman = new Pacman(1, 2, input, gameBoard);
		Renderer renderer = new  Renderer(frame, gameWindow);
		
		
		// drawNewMaze(frame, gameWindow);

		while (!exitGame) {
			
			renderer.render(gameBoard, pacman);
			pacman.update();
			input.update();
			Thread.yield();
		}

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} // end main

} // end class