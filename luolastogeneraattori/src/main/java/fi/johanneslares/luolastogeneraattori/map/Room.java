package fi.johanneslares.luolastogeneraattori.map;

/**
 * Room class
 * @author Johannes Lares
 *
 */
public class Room {
	private int width, height, x, y, mapX, mapY;
	private boolean connected = false;
	
	public Room(int width, int height, int x, int y) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}
	
	public int getWidth() { return this.width; }
	public int getHeight() { return this.height; }
	public int getX() { return this.x; }
	public int getY() { return this.y; }
	public int getMapX() { return this.mapX; }
	public int getMapY() { return this.mapY; }
	
	/**
	 * Set map position (based on the main ascii char map)
	 * @param x X coordinate
	 * @param y Y coordinate
	 */
	public void setMapPosition(int x, int y) {
		this.mapX = x;
		this.mapY = y;
	}
	
	public void setConnected(boolean is) {
		this.connected = is;
	}
	
	public boolean getConnected() {
		return this.connected;
	}
}
