/**
 * Different tiletypes and their ascii characters
 */

package fi.johanneslares.luolastogeneraattori.map;

public enum TileType {
	EMPTY (" "),
	HORIZONTAL_WALL ("-"),
	VERTICAL_WALL ("|"),
	ROOM ("."),
	PATH ("#");
	
	private final String mark;
	
	TileType(String mark) {
		this.mark = mark;
	}
	
	public String getMark() {
		return this.mark;
	}
}
