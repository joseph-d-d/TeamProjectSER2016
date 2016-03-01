public class Position {
	private boolean isWall = false;
	private boolean isBlank = false;
	private boolean isPellet = false;
	private boolean isFork = false;
	private GameObject occupiedBy = null;
	
	public Position(boolean isWall, boolean isBlank, boolean isPellet, boolean isFork){
		this.isWall = isWall;
		this.isBlank = isBlank;
		this.isPellet = isPellet;
		this.isFork = isFork;
	}

	/**
	 * @return the isWall
	 */
	public boolean isWall(){
		return isWall;
	}
	
	/**
	 * @return the isFork
	 */
	public boolean isFork(){
		return isFork;
	}
	
	/**
	 * 
	 * @return isBlank
	 */
	public boolean isBlank(){
		return isBlank;
	}
	
	/**
	 * 
	 * @return isPellet
	 */
	public boolean isPellet(){
		return isPellet;
	}
	
	/**
	 * Removes the pellet from this position and makes it blank.
	 */
	public void removePellet(){
		isBlank = true;
		isPellet = false;
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
	
	public GameObject getOccupiedBy() {
		return occupiedBy;
	}
	
	

	/**
	 * Sets the position to be occupied by the object calling it.
	 * @param occupiedBy The object who called they function.
	 */
	public void setOccupiedBy(GameObject occupiedBy) {
		this.occupiedBy = occupiedBy;
	}
}