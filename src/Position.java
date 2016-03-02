public class Position {
	private boolean isWall = false;
	private boolean isBlank = false;
	private boolean isPellet = false;
	private boolean isPowerPellet = false;
	private Ghost occupiedBy = null;
	
	public Position(boolean isWall, boolean isBlank, boolean isPellet, boolean isPowerPellet){
		this.isWall = isWall;
		this.isBlank = isBlank;
		this.isPellet = isPellet;
		this.isPowerPellet = isPowerPellet;
		
	}

	/**
	 * Checks if the position is a wall.
	 * @return isWall
	 */
	public boolean isWall(){
		return isWall;
	}
	
	/**
	 * Checks if the position is a blank.
	 * @return isBlank
	 */
	public boolean isBlank(){
		return isBlank;
	}
	
	/**
	 * Checks if the position is a pellet.
	 * @return isPellet
	 */
	public boolean isPellet(){
		return isPellet;
	}
	
	/**
	 * Checks if the position is a power pellet.
	 * @return isPowerPellet
	 */
	public boolean isPowerPellet(){
		return isPowerPellet;
	}
	
	/**
	 * Removes the pellet from this position and makes it blank.
	 */
	public void removePellet(){
		isBlank = true;
		isPellet = false;
		isPowerPellet = false;
	}

	/**
	 * Checks to see if a space is occupied returns true is it is,
	 * false if it is not occupied.
	 * @return Whether the space is currently occupied
	 */
	public boolean getIsOccupiedBy() {
		if(occupiedBy != null){
			return true;
		}
		return false;
	}
	
	/**
	 * Get the ghost occupying this position.
	 * @return occupiedBy the ghost in this position.
	 */
	public Ghost getOccupiedBy() {
		return occupiedBy;
	}
	
	

	/**
	 * Sets the position to be occupied by the object calling it.
	 * @param occupiedBy The object who called they function.
	 */
	public void setOccupiedBy(Ghost occupiedBy) {
		this.occupiedBy = occupiedBy;
	}
}