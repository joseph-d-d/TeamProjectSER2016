public class Position {
	private boolean isWall = false;
	private boolean isBlank = false;
	private boolean isPellet = false;
	
	public Position(boolean isWall, boolean isBlank, boolean isPellet){
		this.isWall = isWall;
		this.isBlank = isBlank;
		this.isPellet = isPellet;
	}

	/**
	 * @return the isWall
	 */
	public boolean isWall(){
		return isWall;
	}
	
	public boolean isBlank(){
		return isBlank;
	}
	
	public boolean isPellet(){
		return isPellet;
	}
	
	public void removePellet(){
		isBlank = true;
		isPellet = false;
	}
}
