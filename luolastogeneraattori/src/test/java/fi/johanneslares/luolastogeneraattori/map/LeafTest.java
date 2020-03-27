package fi.johanneslares.luolastogeneraattori.map;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LeafTest {

	Leaf root;
	List<Leaf> leafs;
	
	@Before
	public void setUp() throws Exception {
		int max_leaf_size = 5;
		leafs = new ArrayList<Leaf>();
		root = new Leaf(0,0,100, 100);
		leafs.add(root);
		boolean did_split = true;
		while (did_split) {
			did_split = false;
			for (int i = 0; i < leafs.size(); i++) {
				Leaf l = leafs.get(i);
				if (l.left == null || l.right == null) {
					if (l.width > max_leaf_size || l.height > max_leaf_size) {
						if(l.split()) {
							leafs.add(l.right);
							leafs.add(l.left);
							did_split = true;
						}
					}
				}
			}
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void noRoomExtendsBeyondLeaf() {
		root.createRoom();
		for (Leaf l : leafs) {
			if (l.roomW + l.roomX > l.width) fail("Room in leaf exceeds leafs' width");
			if (l.roomX < 0) fail("Room in leaf exceeds leafs' width (starts before leaf starts)");
			if (l.roomH + l.roomY > l.height) fail("Room in leaf exceeds leafs' height");
			if (l.roomY < 0) fail ("Room in leaf exceeds leafs' height (starts before leaf starts)");
		}
	}
	
	@Test
	public void roomSizeIsCorrect() {
		root.createRoom();
		for (Leaf l : leafs) {
			if (l.roomW > l.width) fail("Room is wider than the parent leaf");
			if (l.roomH > l.height) fail("Room is taller than the parent leaf");
		}
	}

}
