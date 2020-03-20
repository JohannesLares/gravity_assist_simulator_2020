/**
 * Cavegenerator main app
 * @author Johannes Lares
 * @version 0.1
 */

package ui;

import java.util.*;
import map.*;

public class Main {

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
		network = new Network(height, width);
		network.getMap();
	}

}
