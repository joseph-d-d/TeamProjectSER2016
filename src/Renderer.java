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
	private Graphics2D g2d = null;
	private BufferStrategy bufferStrategy= null;
	private GraphicsEnvironment ge = null;
	private GraphicsDevice gd = null;
	private GraphicsConfiguration gc = null;
	private BufferedImage bi = null;
	
	public Renderer(JFrame frame, Canvas gameWindow){
		gameWindow.setIgnoreRepaint(true);
		frame.setIgnoreRepaint(true);
		frame.setFocusable(true);
		frame.requestFocusInWindow();
		frame.getContentPane().add(gameWindow);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(1024, 768);
		gameWindow.createBufferStrategy(2);
		bufferStrategy = gameWindow.getBufferStrategy();
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		gd = ge.getDefaultScreenDevice();
		gc = gd.getDefaultConfiguration();
		bi = gc.createCompatibleImage(1024, 768);
		// Find the users screen size and center the window
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int w = frame.getSize().width;
		int h = frame.getSize().height;
		int x = (dim.width - w) / 2;
		int y = (dim.height - h) / 2;
		frame.setLocation(x, y);
	}
	
	public void render(Board gameBoard, Pacman pacman){
		g2d = bi.createGraphics();
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, 1024, 768);
		for(int i = 0; i < gameBoard.getGameboard().length; i++){
			for(int j = 0; j < gameBoard.getGameboard()[i].length; j++){
				if(gameBoard.getGameboard()[i][j].isWall()){
					g2d.setColor(Color.BLUE);
					g2d.fillRect(20*j, 20*i, 20, 20);
				}
				else if(gameBoard.getGameboard()[i][j].isBlank()){
					g2d.setColor(Color.BLACK);
					g2d.fillRect(20*j, 20*i, 20, 20);
				}
				else if(gameBoard.getGameboard()[i][j].isPellet()){
					g2d.setColor(Color.WHITE);
					g2d.fillRect(20*j+10, 20*i+10, 4, 4);
				}
				
			}
		}
		g2d.setColor(Color.YELLOW);
		g2d.fillOval(pacman.xCoord*20, pacman.yCoord*20, 20, 20);
		
		graphics = bufferStrategy.getDrawGraphics();
		graphics.drawImage(bi, 0, 0, null);
		if(!bufferStrategy.contentsLost()){
			bufferStrategy.show();
		}

		if(graphics != null){
			graphics.dispose();
		}
		if(g2d != null){
			g2d.dispose();
		}
	}

}
