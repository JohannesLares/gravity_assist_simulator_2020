package fi.johanneslares.luolastogeneraattori.astar;

import java.util.PriorityQueue;

import fi.johanneslares.luolastogeneraattori.datastructures.Array;
import fi.johanneslares.luolastogeneraattori.map.*;

/**
 * A* Pathfinding algorithm to find shortest path from start to goal.
 * @author Johannes Lares
 *
 */
public class Astar {
	
	private Tile[][] map;
	private Tile start;
	private Tile end;
	private boolean isPath;
	private boolean[][] visited;
	
	public Astar(Tile[][] mapp, Tile start, Tile end) {
		this.map = mapp;
		this.start = start;
		this.end = end;
		this.isPath = false;
		this.visited = new boolean[map.length][map[0].length];
	}
	
	/**
	 * Get shortest path from start to goal
	 * @return Tile[][] old map with A* path
	 */
	public Tile[][] runAstar() {
		PriorityQueue<Tile> tiles = new PriorityQueue<Tile>();
		start.setGCost((int)distance(start, end));
		start.setFCost(0);
		start.setParent(null);
		tiles.add(start);
		while(!tiles.isEmpty()) {
			if(tiles.isEmpty()) break;
			Tile t = tiles.poll();
			if (t == end) {
				isPath = true;
				break;
			}
			if(visited[t.getX()][t.getY()]) {
				continue;
			}
			Array<Tile> adj = getAdj(t);
			for(int i = 0; i < adj.size(); i++) {
				Tile a = adj.get(i);
				if(a.getFCost() > t.getFCost()+1) {
					a.setParent(t);
					a.setFCost(t.getFCost()+1);
					a.setGCost((int)distance(a,end)+a.getFCost());
					if(a == end) end = a;
				}
				if(!visited[a.getX()][a.getY()]) tiles.add(a);
			}
			visited[t.getX()][t.getY()] = true;
		}
		Tile[][] m = new Tile[map.length][map[0].length];
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[0].length; y++) {
				m[x][y] = map[x][y];
			}
		}
		if (!isPath) return null;
		Tile parent = end.getParent();
		while(parent != start) {
			m[parent.getX()][parent.getY()] = new Tile(TileType.ASTAR_PATH, parent.getX(), parent.getY());
			parent = parent.getParent();
		}
		return m;
	}
	
	/**
	 * Calculate distance between two tiles in a map based on pythagoras theory
	 * @param t1 Tile 1
	 * @param t2 Tile 2
	 * @return double distance
	 */
	private double distance(Tile t1, Tile t2) {
		double p = 0;
		if(t1.getX() == t2.getX()) {
			p = t1.getY() - t2.getY();
		} else if(t1.getY() == t2.getY()) {
			p = t1.getX() - t2.getX();
		} else {
			double a = t1.getX() - t2.getX();
			double b = t1.getY() - t2.getY();
			if(a < 0) a = -a;
			if(b < 0) b = -b;
			double c = a*a + b*b;
			p = Math.sqrt(c);
		}
		
		if(p < 0) return -p;
		return p;
	}
	
	/**
	 * Get adjacent tiles
	 * @return Tile[]
	 */
	private Array<Tile> getAdj(Tile t) {
		Array<Tile> adj = new Array<Tile>();
		int x1 = t.getX();
		int y1 = t.getY();
		int a = x1-1;
		if (x1 > 0 && this.isValid(x1-1, y1)) {
			adj.add(this.map[a][y1]);
		}
		if (x1 < this.map.length-1 && this.isValid(x1+1, y1)) {
			a = x1+1;
			adj.add(this.map[a][y1]);
		}
		if (y1 > 0 && this.isValid(x1, y1-1)) {
			a = y1-1;
			adj.add(this.map[x1][a]);
		}
		if(y1 < this.map[0].length -1 && this.isValid(x1,y1+1)) {
			a = y1+1;
			adj.add(this.map[x1][a]);
		}
		return adj;
	}
	
	/**
	 * If position x, y is valid for A* (not null or empty tile)
	 * @param x2 x coordinate
	 * @param y2 y coordinate
	 * @return boolean valid
	 */
	private boolean isValid(int x2, int y2) {
		if (this.map[x2][y2] == null) return false;
		return this.map[x2][y2].getType() != TileType.EMPTY;
	}
}
