import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Input extends KeyAdapter{
	private KeyEvent currentKeyPressed;
	private boolean isAnyKeyPressed = false;
	private int totalPacmanMoves = 0;
	private int totalGhostMoves = 0;
	

	/**
	 * Is called when any key on the keyboard is pressed.
	 * @param KeyEvent e The KeyEvent caused the function to be called.
	 */
	public void keyPressed(KeyEvent e){
		if(e != null){
			currentKeyPressed = e;
			isAnyKeyPressed = true;
			totalPacmanMoves++;
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
     * @return isAnyKeyPressed is any key pressed.
     */
	public boolean getIsKeyPressed(){
		if(currentKeyPressed == null){
			isAnyKeyPressed = false;
		}
		return isAnyKeyPressed;
	}

    /**
     * Returns the value of totalPacmanMoves 
     * @return totalPacmanMoves
     */
	public int getTotalPacmanMoves()
	{
		return totalPacmanMoves;
	}
	
    /**
     * Sets the value of totalPacmanMoves
     */
	public void setTotalPacmanMoves(int moves)
	{
		totalPacmanMoves = moves;
	}
	
    /**
     * Returns the value of totalGhostMoves
     * @return totalGhostMoves
     */
	public int getTotalGhostMoves()
	{
		return totalGhostMoves;
	}
	
    /**
     * Sets the value of totalGhostMoves
     */
	public void setTotalGhostMoves(int moves)
	{
		totalGhostMoves = moves;
	}
}
