package fi.johanneslares.luolastogeneraattori;
/**
 * Cavegenerator main app
 * @author Johannes Lares
 * @version 0.1
 */

import fi.johanneslares.luolastogeneraattori.datastructures.*;

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
	 * @throws Exception 
	 */
	
	public static void main(String[] args) {
		boolean create_start_and_end = false;
		boolean a_star = false;
		int width = 0;
		int height = 0;
		if(args.length == 4) {
			width = Integer.parseInt(args[0]);
			height = Integer.parseInt(args[1]);
			create_start_and_end = args[2].toLowerCase().equals("y");
			a_star = args[3].toLowerCase().equals("y");
		}else {
			System.out.println("Tervetuloa luolastogeneen :)");
			System.out.println("Syötä luolaston leveys");
			width = Integer.parseInt(scanner.nextLine());
			System.out.println("Syötä luolaston korkeus");
			height = Integer.parseInt(scanner.nextLine());
			System.out.println("Luodaanko lähtöpiste ja maali? (y/N)");
			String answer = scanner.nextLine();
			create_start_and_end = answer.toLowerCase().equals("y");
			System.out.println("Lasketaanko pisteiden välille optimireitti? (y/N)");
			answer = scanner.nextLine();
			a_star = answer.toLowerCase().equals("y");
		}
		if(create_start_and_end) {
			System.out.println("Lähtöpistettä ilmaisee '0' ja maalia '$'");
		}
		run(height, width, create_start_and_end, a_star);
		network.printMap();
	}
	
	/**
	 * Run application
	 * @param height
	 * @param width
	 * @param start_and_end create start and end position
	 * @param a_star run A*
	 */
	public static void run(int height, int width, boolean start_and_end, boolean a_star) {
		int min_size = 30;
		int min_room_size = 10;
		int max_leaf_size = 50;
		long start = System.currentTimeMillis();
		network = new Network(height, width);
		//network.getMap();
		Array<Leaf> leafs = new Array<Leaf>();
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
		for (int i = 0; i < leafs.size(); i++) {
			Leaf l = leafs.get(i);
			network.updateMap(l);
		}
		
		network.createPaths();
		long end = System.currentTimeMillis();
		System.out.println("Aika luolaston luonnissa: " + (end-start));
		if(start_and_end) {
			start = System.currentTimeMillis();
			network.createStartAndEnd();
			end = System.currentTimeMillis();
			System.out.println("Aika lähtö- ja maalipisteen luonnissa: " + (end-start));
		}
		if(a_star) {
			start = System.currentTimeMillis();
			network.createAstar();
			end = System.currentTimeMillis();
			System.out.println("Aika A* " + (end-start));
		}
	}

}
