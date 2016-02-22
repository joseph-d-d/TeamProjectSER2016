import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Input extends KeyAdapter{
	private KeyEvent currentKeyPressed;
	private boolean isAnyKeyPressed = false;
	

	/**
	 * Is called when any key on the keyboard is pressed.
	 * @param KeyEvent e The KeyEvent caused the function to be called.
	 */
	public void keyPressed(KeyEvent e){
		if(e != null){
			currentKeyPressed = e;
		}
	}
	
	/**
	 * Is a function that had to be overridden
	 * @param KeyEvent e The KeyEvent caused the function to be called.
	 */
	public void keyReleased(KeyEvent e){
	}
	
	/**
	 * Returns the current KeyEvent.
	 * @return The current keyEvent.
	 */
	public KeyEvent getCurrentKey(){
		return currentKeyPressed;
	}
	
	/**
	 * Should be called in the main loop so the
	 * value currentKeyPressed is not sent several
	 * times a frame.
	 */
	public void update(){
		currentKeyPressed = null;
		isAnyKeyPressed = false;
	}
	

    /**
     * Returns the value of is any key pressed?
     * @return isAnKeyPressed is any key pressed.
     */
	public boolean getIsKeyPressed(){
		return isAnyKeyPressed;
	}
}
