package fi.johanneslares.luolastogeneraattori.astar;

import static org.junit.Assert.*;
import org.junit.Test;

import fi.johanneslares.luolastogeneraattori.map.Tile;
import fi.johanneslares.luolastogeneraattori.map.TileType;

public class AStarTest {
	
	@Test
	public void testAstarRoom() {
		Tile[][] map = new Tile[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				map[i][j] = new Tile(TileType.ROOM, i, j);
			}
		}
		map[3][3].setType(TileType.START_POSITION);
		map[3][8].setType(TileType.END_POSITION);
		Astar a = new Astar(map, map[3][3], map[3][8]);
		Tile[][] map2 = a.runAstar();
		assertEquals(map2[3][4].getType(), TileType.ASTAR_PATH);
		assertEquals(map2[3][5].getType(), TileType.ASTAR_PATH);
		assertEquals(map2[3][6].getType(), TileType.ASTAR_PATH);
		assertEquals(map2[3][7].getType(), TileType.ASTAR_PATH);
	}
	
	@Test
	public void testAstarNoRoute() {
		Tile[][] map = new Tile[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				map[i][j] = new Tile(TileType.EMPTY, i, j);
			}
		}
		map[5][3].setType(TileType.START_POSITION);
		map[8][8].setType(TileType.END_POSITION);
		Astar a = new Astar(map, map[3][3], map[3][8]);
		Tile[][] map2 = a.runAstar();
		assertNull(map2);
	}
	
	@Test
	public void aStarEndSmallerStart() {
		Tile[][] map = new Tile[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				map[i][j] = new Tile(TileType.ROOM, i, j);
			}
		}
		map[8][3].setType(TileType.START_POSITION);
		map[3][3].setType(TileType.END_POSITION);
		Astar a = new Astar(map, map[8][3], map[3][3]);
		Tile[][] map2 = a.runAstar();
		assertEquals(map2[7][3].getType(), TileType.ASTAR_PATH);
		assertEquals(map2[6][3].getType(), TileType.ASTAR_PATH);
		assertEquals(map2[5][3].getType(), TileType.ASTAR_PATH);
		assertEquals(map2[4][3].getType(), TileType.ASTAR_PATH);
		assertEquals(map2[3][3].getType(), TileType.END_POSITION);
	}
}