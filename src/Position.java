import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class Position {
	private boolean isWall = false;
	
	public Position(boolean isWall){
		this.isWall = isWall;
	}

	/**
	 * @return the isWall
	 */
	public boolean isWall() {
		return isWall;
	}
}
