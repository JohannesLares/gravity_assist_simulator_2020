/**
 * Starting positions for angled path.
 */
package fi.johanneslares.luolastogeneraattori.map;

public class AngledPathPositions {
	
	private int startX;
	private int startY;
	private int startXcoordY;
	private int startYcoordX;
	private String type;
	
	/**
	 * Constructor
	 * @param startX start path from this X position
	 * @param startY start path from this Y position
	 * @param sXcY   startX Y coordinate
	 * @param sYcX	 startY X coordinate
	 */
	public AngledPathPositions(int startX, int startY, int sXcY, int sYcX, String t) {
		this.startX = startX;
		this.startY = startY;
		this.startXcoordY = sXcY;
		this.startYcoordX = sYcX;
		this.type = t;
	}
	
	public int getStartX() { return this.startX; }
	public int getStartY() { return this.startY; }
	public int getStartXcoordY() { return this.startXcoordY; }
	public int getStartYcoordX() { return this.startYcoordX; }
	public String getType() { return this.type; }
}
