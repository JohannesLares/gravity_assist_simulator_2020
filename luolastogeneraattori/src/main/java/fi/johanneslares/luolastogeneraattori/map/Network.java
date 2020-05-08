/**
 * This is the map handler.
 * The cave is two dimensional array of tiles
 * Main point is to keep the map updated, when Leaf generates it.
 */

package fi.johanneslares.luolastogeneraattori.map;

import fi.johanneslares.luolastogeneraattori.astar.Astar;
import fi.johanneslares.luolastogeneraattori.datastructures.*;
import fi.johanneslares.luolastogeneraattori.datastructures.Random;

public class Network {
	
	private Tile map[][];
	private Array<Room> rooms = new Array<Room>();
	private int start_point_x = 0;
	private int end_point_x = 0;
	private int start_point_y = 0;
	private int end_point_y = 0;
	
	/**
	 * 
	 * @param height height of the cave
	 * @param width Width of the cave
	 */
	public Network(int height, int width) {
		map = new Tile[width][height];
		for(int a = 0; a < width; a++) {
			for(int b = 0; b < height; b++) {
				map[a][b] = new Tile(TileType.EMPTY, a, b);
			}
		}
	}
	
	/**
	 * Update map with leaf data. Supports Unix/Linux terminal multicolor.
	 * @param l Leaf
	 */
	public void updateMap(Leaf l) {
		String[] colors = {"\033[0;31m", "\033[0;32m", "\033[0;33m", "\033[0;34m", "\033[0;35m", "\033[0;36m", "\033[0;37m"};
		String c = colors[Random.getRandom(0,7)];
		Room r = l.getRoom();
		//r.setMapPosition(l.x + r.getX(), l.y + r.getY());
		rooms.add(r);
		for (int i = r.getMapX(); i < r.getMapX() + r.getWidth(); i++) {
			for (int j = r.getMapY(); j < r.getMapY()+r.getHeight(); j++) {
				map[i][j] = new Tile(TileType.ROOM, i, j);
			}
		}
	}
	
	/**
	 * Print map
	 */
	public void printMap() {
		for (int i = 0; i < map[0].length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[j][i] == null) map[j][i] = new Tile(TileType.EMPTY, j, i);
				System.out.print(map[j][i].getColor() + map[j][i].toString());
			}
			System.out.println();
		}
	}
	
	/**
	 * Create paths between the rooms. First try create as many straight paths, and if fails, create with corners.
	 */
	public void createPaths() {
		int s = rooms.size();
		for (int i = 0; i < s; i++) {
			if (i + 1 == rooms.size()) {
				continue;
			}
			if (rooms.get(i).getMapX() == rooms.get(i+1).getMapX() && rooms.get(i).getMapY() == rooms.get(i+1).getMapY()) {
				continue;
			}
			Room r = overlapAndCreatePath(rooms.get(i), rooms.get(i+1));
			if (r == null) {
				AngledPathPositions ap = createAngledPath(rooms.get(i), rooms.get(i+1));
				if(ap == null) continue;
				int sx = ap.getRoom1X();
				int sy = ap.getRoom1Y();
				int ex = ap.getRoom2X();
				int ey = ap.getRoom2Y();
				int xy = sy < ey ? ey:sy;
				int yx = sx < ex ? ex:sx;
				if(sx <= ex) yx = sx;
				if(ex < sx) {
					yx = ex;
					int a = ex;
					ex = sx;
					sx = a;
				}
				if(sy <= ey) xy = sy;
				if (sy > ey) {
					xy = ey;
					int a = ey;
					ey = sy;
					sy = a;
				}
				for (int a = sx; a <= ex; a++) {
					if(xy < map[0].length && a < map.length && (map[a][xy] == null || map[a][xy].getType() == TileType.EMPTY)) {
						map[a][xy] = new Tile(TileType.PATH, a, xy);
					}
				}
				for (int a = sy; a <= ey; a++) {
					if(yx < map.length && a < map[0].length && (map[yx][a] == null || map[yx][a].getType() == TileType.EMPTY)) {
						map[yx][a] = new Tile(TileType.PATH, yx, a);
					}
				}
				continue;
			} else if (r.getWidth() == 1) {
				for (int a = r.getMapY(); a < r.getHeight() + r.getMapY(); a++) {
					if(map[r.getMapX()][a] == null || map[r.getMapX()][a].getType() == TileType.EMPTY) {
						map[r.getMapX()][a] = new Tile(TileType.PATH, r.getMapX(), a);
					}
				}
			} else {
				for (int a = r.getMapX(); a < r.getWidth() + r.getMapX(); a++) {
					if(map[a][r.getMapY()] == null || map[a][r.getMapY()].getType() == TileType.EMPTY) {
						map[a][r.getMapY()] = new Tile(TileType.PATH, a, r.getMapY());
					}
				}
			}
		}
	}
	
	/**
	 * Calculate path with a corner between two rooms
	 * @param r1 Room no. 1
	 * @param r2 Room no. 2
	 * @return AngledPathPositions of the calculated Path
	 */
	private AngledPathPositions createAngledPath(Room r1, Room r2) {
		int r1_x = Random.getRandom(r1.getMapX(), r1.getMapX()+r1.getHeight());
		int r1_y = Random.getRandom(r1.getMapY(), r1.getMapY()+r1.getWidth());
		int r2_x = Random.getRandom(r2.getMapX(), r2.getMapX()+r2.getHeight());
		int r2_y = Random.getRandom(r2.getMapY(), r2.getMapY()+r2.getWidth());
		return new AngledPathPositions(r1_x, r1_y, r2_x, r2_y);
	}
	
	/**
	 * Calculate straight paths between two rooms. 
	 * @param r1 Room 1
	 * @param r2 Room 2
	 * @return path as room.
	 */
	private Room overlapAndCreatePath(Room r1, Room r2) {
		if(r2.getMapX() <= r1.getMapX() + r1.getWidth() && r2.getMapX() >= r1.getMapX() && r1.getMapY() + r1.getHeight() < r2.getMapY()) {
			int a = r1.getMapX()+r1.getWidth() <= r2.getMapX()+r2.getWidth() ? r1.getMapX()+r1.getWidth(): r2.getMapX()+r2.getWidth();
			int start = Random.getRandom(r2.getMapX(),a);
			Room r = new Room(1, r2.getMapY()-(r1.getMapY()+r1.getHeight()), 0,0);
			r.setMapPosition(start, r1.getMapY()+r1.getHeight());
			return r;
		}
		if(r1.getMapX() < r2.getMapX() + r2.getWidth() && r1.getMapX() >= r2.getMapX() && r2.getMapY() + r2.getHeight() < r1.getMapY()) {
			int a = r1.getMapX()+r1.getWidth() <= r2.getMapX()+r2.getWidth() ? r1.getMapX()+r1.getWidth(): r2.getMapX()+r2.getWidth();
			int start = Random.getRandom(r1.getMapX(),a);
			Room r = new Room(1,r1.getMapY()-(r2.getMapY()+r2.getHeight()), 0,0);
			r.setMapPosition(start, r2.getMapY()+r2.getHeight());
			return r;
		}
		if(r2.getMapY() < r1.getMapY() + r1.getHeight() && r2.getMapY() >= r1.getMapY() && r1.getMapX() + r1.getWidth() < r2.getMapX()) {
			int a = r1.getMapY()+r1.getHeight() <= r2.getMapY()+ r2.getHeight() ? r1.getMapY() + r1.getHeight() : r2.getMapY() + r2.getHeight();
			int start = Random.getRandom(r1.getMapY(), a);
			Room r = new Room(r2.getMapX()-(r1.getMapX()+r1.getWidth()),1,0,0);
			r.setMapPosition(r1.getMapX()+r1.getWidth(), start);
			return r;
		}
		if(r1.getMapY() < r2.getMapY() + r2.getHeight() && r1.getMapY() >= r2.getMapY() && r2.getMapX() + r2.getWidth() < r1.getMapX()) {
			int a = r1.getMapY()+r1.getHeight() <= r2.getMapY()+ r2.getHeight() ? r1.getMapY() + r1.getHeight() : r2.getMapY() + r2.getHeight();
			int start = Random.getRandom(r2.getMapY(), a);
			Room r = new Room(r1.getMapX()-(r2.getMapX()+r2.getWidth()),1,0,0);
			r.setMapPosition(r2.getMapX()+r2.getWidth(), start);
			return r;
		}
		return null;
	}
	
	/**
	 * Create start and end positions. Picks two random rooms and creates points on random to these rooms.
	 */
	public void createStartAndEnd() {
		Array<Room> noSame = new Array<Room>();
		for(int i = 0; i < rooms.size(); i++) {
			if (i + 1 == rooms.size()) {
				continue;
			}
			if (rooms.get(i).getMapX() == rooms.get(i+1).getMapX() && rooms.get(i).getMapY() == rooms.get(i+1).getMapY()) {
				continue;
			}
			noSame.add(rooms.get(i));
		}
		if(noSame.isEmpty()) {
			noSame.add(rooms.get(0));
		}
		System.out.println(noSame.size());
		int random1 = Random.getRandom(0, noSame.size()-1, 8257);
		int random2 = Random.getRandom(0, noSame.size()-1);
		if (random1 <= 1) {
			random1 = 0;
			random2 = 0;
		}
		Room start_room = noSame.get(random1);
		Room end_room = noSame.get(random2);
		
		int sx = Random.getRandom(start_room.getMapX(), start_room.getMapX()+start_room.getWidth(), 8257);
		int sy = Random.getRandom(start_room.getMapY(), start_room.getMapY()+start_room.getHeight(), 8257);
		int ex = Random.getRandom(end_room.getMapX(), end_room.getMapX()+end_room.getWidth());
		int ey = Random.getRandom(end_room.getMapY(), end_room.getMapY()+end_room.getHeight());
		start_point_x = sx;
		end_point_x = ex;
		start_point_y = sy;
		end_point_y = ey;
		map[sx][sy] = new Tile(TileType.START_POSITION, sx, sy);
		map[ex][ey] = new Tile(TileType.END_POSITION, ex, ey);
	}
	
	/**
	 * Run A* algorithm
	 */
	public void createAstar() {
		for(int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j].setPos(i, j);
			}
		}
		Astar a_star = new Astar(map, map[start_point_x][start_point_y], map[end_point_x][end_point_y]);
		Tile[][] m = a_star.runAstar();
		if(m == null) {
			System.out.println("Ei löydettyä reittiä");
			return;
		}
		map = m;
	}
	
	/**
	 * Get the Map
	 * @return Map
	 */
	public Tile[][] getMap() {
		return this.map;
	}
}
