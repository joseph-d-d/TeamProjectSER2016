
public abstract class GameObject {
	protected int xCoord;
	protected int yCoord;
	protected Input input;
	protected boolean isActive;
	protected Board gameBoard;
	
	protected GameObject(int x, int y, Input input, Board gameBoard){
		this.xCoord = x;
		this.yCoord = y;
		this.input = input;
		this.gameBoard = gameBoard;
	}

	/**
	 * @return the xCoord
	 */
	protected int getXCoord() {
		return xCoord;
	}

	/**
	 * @param xCoord the xCoord to set
	 */
	protected void setXCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	/**
	 * @return the yCoord
	 */
	protected int getYCoord() {
		return yCoord;
	}

	/**
	 * @param yCoord the yCoord to set
	 */
	protected void setYCoord(int yCoord) {
		this.yCoord = yCoord;
	}

	/**
	 * @return the input
	 */
	protected Input getInput() {
		return input;
	}

	/**
	 * @param input the input to set
	 */
	protected void setInput(Input input) {
		this.input = input;
	}

	/**
	 * @return the isActive
	 */
	protected boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	protected void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the gameBoard
	 */
	protected Board getGameBoard() {
		return gameBoard;
	}
	
	protected abstract void update();

}
