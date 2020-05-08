/**
 * Tile is part of cave. See TileType for types of tiles
 */

package fi.johanneslares.luolastogeneraattori.map;

public class Tile implements Comparable<Tile> {
	
	private TileType type;
	private String color = "";
	private int x;
	private int y;
	private int G_cost;
	private int F_cost;
	private Tile parent;
	private boolean visited;
	
	/**
	 * Create tile with specific type
	 * @param type Type of this tile
	 */
	public Tile(TileType type, int x, int y) {
		this.type = type;
		this.x = x;
		this.y = y;
		this.visited = false;
		this.parent = null;
		this.G_cost = Integer.MAX_VALUE;
		this.F_cost = Integer.MAX_VALUE;
	}
	
	public Tile(TileType type) {
		this.type = type;
		this.visited = false;
		this.parent = null;
		this.G_cost = Integer.MAX_VALUE;
		this.F_cost = Integer.MAX_VALUE;
	}
	
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
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
	
	/*
	 * for A* 
	 * F_cost: local
	 * G_cost: Global
	 */
	public void setGCost(int g) { this.G_cost = g; }
	public void setFCost(int f) { this.F_cost = f; }
	public void setParent(Tile t) { this.parent = t; }
	public void setVisited(boolean v) {
		this.visited = v;
	}
	public int getGCost() { return this.G_cost; }
	public int getFCost() { return this.F_cost; }
	public int getX() { return this.x; }
	public int getY() { return this.y; }
	public Tile getParent() { return this.parent; }
	public boolean getVisited() {
		return this.visited;
	}
	
	public String getPos() {
		return "" + this.x + " " + this.y;
	}

	@Override
	public int compareTo(Tile t) {
		return this.G_cost - t.getGCost();
	}
	
	@Override
	public boolean equals(Object o) {
		Tile t = (Tile) o;
		return t.getX() == x && t.getY() == y;
	}
}
