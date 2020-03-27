/**
 * This is the map handler.
 * The cave is two dimensional array of tiles
 * Main point is to keep the map updated, when Leaf generates it.
 */

package fi.johanneslares.luolastogeneraattori.map;

public class Network {
	
	Tile map[][];
	
	/**
	 * 
	 * @param height height of the cave
	 * @param width Width of the cave
	 */
	public Network(int height, int width) {
		map = new Tile[width][height];
	}
	//x + w, y + h
	public void updateMap(Leaf l) {
		for (int i = l.x + l.roomX; i < l.x + l.roomX + l.roomW; i++) {
			for (int j = l.y + l.roomY; j < l.y + l.roomY+l.roomH; j++) {
					map[i][j] = new Tile(TileType.ROOM);
			}
		}
	}
	
	/**
	 * Right now only for debugging purposes. Not working
	 */
	public void printMap() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] == null) map[i][j] = new Tile(TileType.EMPTY);
				System.out.print(map[i][j].toString());
			}
			System.out.println();
		}
	}
	
	public Tile[][] getMap() {
		return this.map;
	}
}
