/**
 * This is the map handler.
 * The cave is two dimensional array of tiles
 * Main point is to keep the map updated, when Leaf generates it.
 */

package fi.johanneslares.luolastogeneraattori.map;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Network {
	
	Tile map[][];
	List<Room> rooms = new ArrayList<Room>();
	
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
		String[] colors = {"\033[0;31m", "\033[0;32m", "\033[0;33m", "\033[0;34m", "\033[0;35m", "\033[0;36m", "\033[0;37m"};
		String c = colors[ThreadLocalRandom.current().nextInt(0,7)];
		Tile t = new Tile(TileType.ROOM);
		t.setColor("");
		Room r = l.getRoom();
		//r.setMapPosition(l.x + r.getX(), l.y + r.getY());
		rooms.add(r);
		for (int i = r.getMapX(); i < r.getMapX() + r.getWidth(); i++) {
			for (int j = r.getMapY(); j < r.getMapY()+r.getHeight(); j++) {
					map[i][j] = t;
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
				System.out.print(map[i][j].getColor() + map[i][j].toString());
			}
			System.out.println();
		}
	}
	
	public void createPaths() {
		System.out.println(rooms.size());
		for (int i = 0; i < rooms.size(); i++) {
			if (i + 1 == rooms.size()) {
				continue;
			}
			if (rooms.get(i).getMapX() == rooms.get(i+1).getMapX() && rooms.get(i).getMapY() == rooms.get(i+1).getMapY()) {
				rooms.remove(i+1);
				System.out.println("Poistettu");
				continue;
			}
			Room r = overlapAndCreatePath(rooms.get(1), rooms.get(i+1));
			if (r == null) {
				System.out.println("No overlap");
				continue;
			} else {
				System.out.println("Numerot: " + r.getMapX() + " " + r.getWidth() + " " + r.getMapY());
				for (int a = r.getMapY(); a < r.getHeight() + r.getMapY(); a++) {
					map[r.getMapX()][a] = new Tile(TileType.PATH);
				}
			}
			
			System.out.println(rooms.get(i).getMapX() + " " + rooms.get(i).getMapY());
		}
		System.out.println(rooms.size());
	}
	
	private Room overlapAndCreatePath(Room r1, Room r2) {
		if(r2.getMapX() <= r1.getMapX() + r1.getWidth() && r2.getMapX() >= r1.getMapX() && r1.getMapY() + r1.getHeight() < r2.getMapY()) {
			int start = ThreadLocalRandom.current().nextInt(r2.getMapX(),r1.getMapX() + r1.getWidth());
			Room r = new Room(1, r2.getMapY()-(r1.getMapY()+r1.getHeight()), 0,0);
			r.setMapPosition(start, r1.getMapY()+r1.getHeight());
			System.out.println(r1.getMapX() + " " + r1.getHeight() + " " + r1.getMapY() + " " + r1.getWidth() + " |"
					+ " " + r2.getMapX() + " " + r2.getHeight() + " " + r2.getMapY() + " " + r2.getWidth() + " |"
							+ " " + r.getMapX() + " " + r.getHeight() + " " + r.getMapY() + " " + r.getWidth());
			return r;
		}
//		if(r1.getMapX() <= r2.getMapX() + r2.getHeight() && r1.getMapX() >= r2.getMapX()) {
//			return "vertical";
//		}
//		if(r2.getMapY() <= r1.getMapY() + r1.getWidth() && r2.getMapY() >= r1.getMapY()) {
//			return "horizontal";
//		}
//		if(r1.getMapY() <= r2.getMapY() + r2.getWidth() && r1.getMapY() >= r2.getMapY()) {
//			return "horizontal";
//		}
		return null;
	}
	
	public Tile[][] getMap() {
		return this.map;
	}
}
