package fi.johanneslares.luolastogeneraattori;
/**
 * Cavegenerator main app
 * @author Johannes Lares
 * @version 0.1
 */

import java.util.*;

import fi.johanneslares.luolastogeneraattori.map.*;

public class App {

	static Scanner scanner = new Scanner(System.in);
	static Network network;
	
	/**
	 * Main method to run the program.
	 * Asks user about width and height of the cave.
	 * @param args Unused
	 * @return nothing
	 */
	
	public static void main(String[] args) {
		
		System.out.println("Tervetuloa luolastogeneen :)");
		System.out.println("Syötä luolaston leveys");
		int width = Integer.parseInt(scanner.next());
		System.out.println("Syötä luolaston korkeus");
		int height = Integer.parseInt(scanner.next());
		long start= System.currentTimeMillis();
		network = new Network(height, width);
		//network.getMap();
		int max_leaf_size = 5;
		List<Leaf> leafs = new ArrayList<Leaf>();
		Leaf root = new Leaf(0,0,width, height);
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
		root.createRoom();
		for (Leaf l : leafs) {
			network.updateMap(l);
			//System.out.println(l.toString());
		}
		long end = System.currentTimeMillis();
		network.printMap();
		System.out.println("Aikaa: " + (end-start));
	}

}
