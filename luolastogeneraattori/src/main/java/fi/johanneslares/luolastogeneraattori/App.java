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
		int width = Integer.parseInt(scanner.nextLine());
		System.out.println("Syötä luolaston korkeus");
		int height = Integer.parseInt(scanner.nextLine());
		run(height, width);
		network.printMap();
	}
	
	/**
	 * Create the cave method
	 * @param height
	 * @param width
	 */
	public static void run(int height, int width) {
		int min_size = 30;
		int min_room_size = 10;
		int max_leaf_size = 50;
		long start = System.currentTimeMillis();
		network = new Network(height, width);
		//network.getMap();
		List<Leaf> leafs = new ArrayList<Leaf>();
		Leaf root = new Leaf(0,0,width, height, min_size, min_room_size);
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
		
		network.createPaths();
		long end = System.currentTimeMillis();
		System.out.println("Aikaa: " + (end-start));
	}

}
