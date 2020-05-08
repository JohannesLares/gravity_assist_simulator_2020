/**
 * Starting positions for angled path.
 */
package fi.johanneslares.luolastogeneraattori.map;

public class AngledPathPositions {
	
	private int room1_x;
	private int room1_y;
	private int room2_x;
	private int room2_y;
	
	/**
	 * Constructor
	 * @param startX start path from this X position
	 * @param startY start path from this Y position
	 * @param sXcY   startX Y coordinate
	 * @param sYcX	 startY X coordinate
	 */
	public AngledPathPositions(int r1_x, int r1_y, int r2_x, int r2_y) {
		this.room1_x = r1_x;
		this.room1_y = r1_y;
		this.room2_x = r2_x;
		this.room2_y = r2_y;
	}
	
	public int getRoom1X() { return this.room1_x; }
	public int getRoom1Y() { return this.room1_y; }
	public int getRoom2X() { return this.room2_x; }
	public int getRoom2Y() { return this.room2_y; }
}
