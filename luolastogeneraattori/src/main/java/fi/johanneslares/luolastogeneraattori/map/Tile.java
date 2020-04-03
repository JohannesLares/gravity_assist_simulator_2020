/**
 * Tile is part of cave. See TileType for types of tiles
 */

package fi.johanneslares.luolastogeneraattori.map;

public class Tile {
	
	private TileType type;
	private String color = "";
	
	/**
	 * Create tile with specific type
	 * @param type Type of this tile
	 */
	public Tile(TileType type) {
		this.type = type;
	}
	
	/**
	 * Create tile with type EMPTY
	 */
	public Tile() {
		this.type = TileType.EMPTY;
	}
	
	/**
	 * 
	 * @return tiletype
	 */
	public TileType getType() {
		return type;
	}
	
	/**
	 * 
	 * @param type Tiletype
	 */
	public void setType(TileType type) {
		this.type = type;
	}
	
	/**
	 * @return tile type character
	 */
	public String toString() {
		return this.type.getMark();
	}
	
	public String getColor() { return this.color; }
	public void setColor(String c) {
		this.color = c;
	}
}
