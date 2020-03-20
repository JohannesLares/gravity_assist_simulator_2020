/**
 * This is the map handler. This creates the cave.
 * The cave is two dimensional array of tiles
 */

package map;

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
	
	/**
	 * Right now only for debugging purposes. Not working
	 */
	public void getMap() {
		System.out.println(map.toString());
	}
}
