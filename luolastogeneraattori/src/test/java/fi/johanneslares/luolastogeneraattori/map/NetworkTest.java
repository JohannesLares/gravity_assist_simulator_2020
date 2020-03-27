package fi.johanneslares.luolastogeneraattori.map;

import static org.junit.Assert.*;

import org.junit.Test;

public class NetworkTest {

	Leaf l;
	
	@Test
	public void mapGeneratedCorrectly() {
		Network n = new Network(10, 10);
		Tile[][] map = n.getMap();
		if(map.length != 10 || map[0].length != 10) fail("Map not generated correctly");
	}

	@Test
	public void mapUpdateWorks() {
		Network n = new Network(10, 10);
		l = new Leaf(2,2,2,2);
		l.roomH = 2;
		l.roomW = 2;
		l.roomX = 0;
		l.roomY = 0;
		n.updateMap(l);
		Tile[][] map = n.getMap();
		if (map[2][2].getType() != TileType.ROOM) fail("Map not updated");
	}
}
