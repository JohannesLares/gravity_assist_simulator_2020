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
			Room r = overlapAndCreatePath(rooms.get(i), rooms.get(i+1));
			if (r == null) {
				System.out.println("No Straight route, create angled one");
				AngledPathPositions angledPos = createAngledPath(rooms.get(i), rooms.get(i+1));
				if(angledPos == null) continue;
				for(int a = angledPos.getStartX(); a < angledPos.getStartYcoordX(); a++) {
					if(map[a][angledPos.getStartXcoordY()] == null) {
						map[a][angledPos.getStartXcoordY()] = new Tile(TileType.PATH);
					}
				}
				for(int a = angledPos.getStartXcoordY(); a < angledPos.getStartY(); a++) {
					if(map[angledPos.getStartYcoordX()][a] == null) {
						map[angledPos.getStartYcoordX()][a] = new Tile(TileType.PATH);
					}
				}
				continue;
			} else if (r.getWidth() == 1) {
				System.out.println("Numerot: " + r.getMapX() + " " + r.getWidth() + " " + r.getMapY());
				for (int a = r.getMapY(); a < r.getHeight() + r.getMapY(); a++) {
					if(map[r.getMapX()][a] == null) {
						map[r.getMapX()][a] = new Tile(TileType.PATH);
					}
				}
			} else {
				System.out.println("Vertikaali");
				for (int a = r.getMapX(); a < r.getWidth() + r.getMapX(); a++) {
					if(map[a][r.getMapY()] == null) {
						map[a][r.getMapY()] = new Tile(TileType.PATH);
					}
				}
			}
			
			System.out.println(rooms.get(i).getMapX() + " " + rooms.get(i).getMapY());
		}
		System.out.println(rooms.size());
	}
	
	private AngledPathPositions createAngledPath(Room r1, Room r2) {
		if (r1.getMapY() + r1.getHeight() <= r2.getMapY() + r2.getHeight() && r1.getMapX() + r1.getWidth() <= r2.getMapX() + r2.getWidth()) {
			int x_coord_y = ThreadLocalRandom.current().nextInt(r1.getMapY(), r1.getMapY()+r1.getHeight()-1);
			int x_coord = ThreadLocalRandom.current().nextInt(r1.getMapY(), r1.getMapY()+r1.getHeight());
			int y_coord_x = r2.getMapX();
			int y_coord = ThreadLocalRandom.current().nextInt(r2.getMapY(), r2.getMapY()+r2.getHeight());
			return new AngledPathPositions(x_coord, y_coord, x_coord_y, y_coord_x, "tl");
		}
		if (r2.getMapY() + r2.getHeight() <= r1.getMapY() + r1.getHeight() && r2.getMapX() + r2.getWidth() <= r1.getMapX() + r1.getWidth()) {
			int x_coord_y = ThreadLocalRandom.current().nextInt(r2.getMapY(), r2.getMapY()+r2.getHeight()-1);
			int x_coord = ThreadLocalRandom.current().nextInt(r2.getMapY(), r2.getMapY()+r2.getHeight());
			int y_coord_x = r1.getMapX();
			int y_coord = ThreadLocalRandom.current().nextInt(r1.getMapY(), r1.getMapY()+r1.getHeight());
			return new AngledPathPositions(x_coord, y_coord, x_coord_y, y_coord_x, "bl");
		}
		return null;
	}
	
	private Room overlapAndCreatePath(Room r1, Room r2) {
		if(r2.getMapX() < r1.getMapX() + r1.getWidth() && r2.getMapX() >= r1.getMapX() && r1.getMapY() + r1.getHeight() < r2.getMapY()) {
			int start = ThreadLocalRandom.current().nextInt(r2.getMapX(),r1.getMapX() + r1.getWidth());
			Room r = new Room(1, r2.getMapY()-(r1.getMapY()+r1.getHeight()), 0,0);
			r.setMapPosition(start, r1.getMapY()+r1.getHeight());
			return r;
		}
		if(r1.getMapX() < r2.getMapX() + r2.getWidth() && r1.getMapX() >= r2.getMapX() && r2.getMapY() + r2.getHeight() < r1.getMapY()) {
			int start = ThreadLocalRandom.current().nextInt(r1.getMapX(),r2.getMapX()+r2.getWidth());
			Room r = new Room(1,r1.getMapY()-(r2.getMapY()+r2.getHeight()), 0,0);
			r.setMapPosition(start, r2.getMapY()+r2.getHeight());
			return r;
		}
		if(r2.getMapY() < r1.getMapY() + r1.getHeight() && r2.getMapY() >= r1.getMapY() && r1.getMapX() + r1.getWidth() < r2.getMapX()) {
			int start = ThreadLocalRandom.current().nextInt(r1.getMapY(), r1.getMapY()+r1.getHeight());
			Room r = new Room(r2.getMapX()-(r1.getMapX()+r1.getWidth()),1,0,0);
			r.setMapPosition(r1.getMapX()+r1.getWidth(), start);
			return r;
		}
		if(r1.getMapY() < r2.getMapY() + r2.getHeight() && r1.getMapY() >= r2.getMapY() && r2.getMapX() + r2.getWidth() < r1.getMapX()) {
			int start = ThreadLocalRandom.current().nextInt(r2.getMapY(), r2.getMapY()+r2.getHeight());
			Room r = new Room(r1.getMapX()-(r2.getMapX()+r2.getWidth()),1,0,0);
			r.setMapPosition(r2.getMapX()+r2.getWidth(), start);
			return r;
		}
		return null;
	}
	
	public Tile[][] getMap() {
		return this.map;
	}
}
