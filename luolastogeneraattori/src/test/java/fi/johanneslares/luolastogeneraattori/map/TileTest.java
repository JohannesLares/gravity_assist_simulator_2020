package fi.johanneslares.luolastogeneraattori.map;

import static org.junit.Assert.*;

import org.junit.Test;

public class TileTest {
	
	Tile tile;
	
	@Test
	public void TileTypeReturnedCorrectly() {
		tile = new Tile();
		if(tile.getType() != TileType.EMPTY) fail("Tile generated with wrong TileType");
		tile.setType(TileType.PATH);
		if(tile.getType() != TileType.PATH) fail("Tile not returning correct tiletype");
		if(tile.toString() != "#") fail("Wrong ASCII character returned for tiletype PATH");
	}

	@Test
	public void TileGeneratedWithCustomTileType() {
		tile = new Tile(TileType.VERTICAL_WALL);
		if(tile.getType() != TileType.VERTICAL_WALL) fail("Tile generated with wrong tiletype");
	}
}
