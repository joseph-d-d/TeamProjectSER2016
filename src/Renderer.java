import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class Renderer {
	private Graphics graphics = null;
	private Graphics2D graphics2d = null;
	private BufferStrategy bufferStrategy= null;
	private GraphicsEnvironment graphicsEnvironment = null;
	private GraphicsDevice graphicsDevice = null;
	private GraphicsConfiguration graphicsConfiguration = null;
	private BufferedImage bufferedImage = null;
	
	public Renderer(JFrame frame, Canvas gameWindow){
		gameWindow.setIgnoreRepaint(true);
		frame.setIgnoreRepaint(true);
		frame.setFocusable(true);
		frame.requestFocusInWindow();
		frame.getContentPane().add(gameWindow);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(600, 768);
		//Create a double buffer.
		gameWindow.createBufferStrategy(2);
		bufferStrategy = gameWindow.getBufferStrategy();
		
		graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		graphicsDevice = graphicsEnvironment.getDefaultScreenDevice();
		graphicsConfiguration = graphicsDevice.getDefaultConfiguration();
		bufferedImage = graphicsConfiguration.createCompatibleImage(1024, 768);
		
		// Find the users screen size and center the window
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int w = frame.getSize().width;
		int h = frame.getSize().height;
		int x = (dim.width - w) / 2;
		int y = (dim.height - h) / 2;
		frame.setLocation(x, y);
	}
	
	/**
	 * Renders the gameboard, pacman and the ghosts.
	 * @param gameBoard the gameboard.
	 * @param pacman Pacman.
	 * @param ghosts array of Ghosts
	 */
	public void render(Board gameBoard, Pacman pacman, Ghost[] ghosts){
		graphics2d = bufferedImage.createGraphics();
		graphics2d.setColor(Color.BLACK);
		graphics2d.fillRect(0, 0, 1024, 768);
		for(int i = 0; i < gameBoard.getGameboard().length; i++){
			for(int j = 0; j < gameBoard.getGameboard()[i].length; j++){
				if(gameBoard.getGameboard()[i][j].isWall()){
					graphics2d.setColor(Color.BLUE);
					graphics2d.fillRect(20*j, 20*i, 20, 20);
				}
				else if(gameBoard.getGameboard()[i][j].isBlank()){
					graphics2d.setColor(Color.BLACK);
					graphics2d.fillRect(20*j, 20*i, 20, 20);
				}
				else if(gameBoard.getGameboard()[i][j].isPellet()){
					graphics2d.setColor(Color.WHITE);
					graphics2d.fillRect(20*j+10, 20*i+10, 4, 4);
				}
				if(gameBoard.getGameboard()[i][j].isPowerPellet()){
					graphics2d.setColor(Color.RED);
					graphics2d.fillRect(20*j+6, 20*i+6, 10, 10);
				}	
			}
		}
		//Render pacman if he is active.
		if(pacman.getIsActive()){
			graphics2d.setColor(pacman.getColor());
			graphics2d.fillOval(pacman.xCoord*20, pacman.yCoord*20, 20, 20);
		}
		//Render each ghost if they are active.
		for(Ghost ghost : ghosts){
			if(ghost.getIsActive()){
				graphics2d.setColor(ghost.getColor());
				graphics2d.fillRect(ghost.xCoord*20, ghost.yCoord*20+10, 20, 10);
				graphics2d.fillOval(ghost.xCoord*20, ghost.yCoord*20, 20, 20);
			}

		}
		
		graphics2d.setColor(Color.WHITE);
		graphics2d.drawString("Lives Remaining: " + pacman.getLives(), 15, 700);
		
		//Render won or lost depending on win or lose being set in pacman.
		if(pacman.hasPacmanWon()){
			graphics2d.setColor(Color.WHITE);
			graphics2d.drawString("You Have Won!", 500, 700);
		}
		if(pacman.hasPacmanLost()){
			graphics2d.setColor(Color.WHITE);
			graphics2d.drawString("You Have Lost!", 500, 700);
		}
		
		//Show the created image
		graphics = bufferStrategy.getDrawGraphics();
		graphics.drawImage(bufferedImage, 0, 0, null);
		if(!bufferStrategy.contentsLost()){
			bufferStrategy.show();
		}
			
		if(graphics != null){
			graphics.dispose();
		}
		if(graphics2d != null){
			graphics2d.dispose();
		}
	}

}