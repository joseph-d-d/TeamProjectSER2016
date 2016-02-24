import java.awt.*;
import javax.swing.*;

public class Game extends JPanel
{
	public static void main(String[] args)
	{
		Game gameWindow = new Game();	// This is the panel for drawing
		JFrame frame = new JFrame("Pacman");
		drawNewMaze(frame, gameWindow);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} // end main
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		// Set background to black
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 420, 525);
		
		// Draw a wall
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 15, 15);
		
		// Draw a pellet
		g.setColor(Color.WHITE);
		g.fillOval(0, 50, 5, 5);
		
		// Draw a power pellet
		g.setColor(Color.RED);
		g.fillOval(0, 100, 10, 10);
	}
	
	public static void drawNewMaze(JFrame frame, JPanel gameWindow)
	{
		frame.getContentPane().add(gameWindow);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(420, 525);
		
		// Find the users screen size and center the window
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int w = frame.getSize().width;
		int h = frame.getSize().height;
		int x = (dim.width - w) / 2;
		int y = (dim.height - h) / 2;
		frame.setLocation(x,y);	
	}
} // end class