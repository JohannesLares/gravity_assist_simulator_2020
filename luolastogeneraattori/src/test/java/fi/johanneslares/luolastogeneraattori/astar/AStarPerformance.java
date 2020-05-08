package fi.johanneslares.luolastogeneraattori.astar;

import static org.junit.Assert.*;
import org.junit.Test;

import fi.johanneslares.luolastogeneraattori.map.Tile;
import fi.johanneslares.luolastogeneraattori.map.TileType;

public class AStarPerformance {
	
	@Test
	public void smallSingleRoomTest() {
		Tile[][] map = new Tile[100][100];
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				map[i][j] = new Tile(TileType.ROOM, i, j);
			}
		}
		map[0][0].setType(TileType.START_POSITION);
		map[99][99].setType(TileType.END_POSITION);
		long start = System.nanoTime();
		Astar a = new Astar(map, map[0][0], map[99][99]);
		Tile[][] map2 = a.runAstar();
		long end = System.nanoTime();
		System.out.println("Astar single room 100x100 (ns): " + (end-start));
	}
	
	@Test
	public void mediumSingleRoomTest() {
		Tile[][] map = new Tile[1000][1000];
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				map[i][j] = new Tile(TileType.ROOM, i, j);
			}
		}
		map[0][0].setType(TileType.START_POSITION);
		map[999][999].setType(TileType.END_POSITION);
		long start = System.nanoTime();
		Astar a = new Astar(map, map[0][0], map[999][999]);
		Tile[][] map2 = a.runAstar();
		long end = System.nanoTime();
		System.out.println("Astar single room 1000x1000 (ns): " + (end-start));
	}
	
	@Test
	public void largeSingleRoomTest() {
		System.out.println("Running large single room test. This might take a while");
		Tile[][] map = new Tile[10000][10000];
		for (int i = 0; i < 10000; i++) {
			for (int j = 0; j < 10000; j++) {
				map[i][j] = new Tile(TileType.ROOM, i, j);
			}
		}
		map[0][0].setType(TileType.START_POSITION);
		map[9999][9999].setType(TileType.END_POSITION);
		long start = System.nanoTime();
		Astar a = new Astar(map, map[0][0], map[9999][9999]);
		Tile[][] map2 = a.runAstar();
		long end = System.nanoTime();
		System.out.println("Astar single room 10000x10000 (ns): " + (end-start));
	}
}
