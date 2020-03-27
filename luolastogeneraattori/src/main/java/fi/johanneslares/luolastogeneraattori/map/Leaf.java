package fi.johanneslares.luolastogeneraattori.map;
import java.lang.Math;

public class Leaf {
	private int min_size = 10;
	public int x, y, width, height;
	public int roomW, roomH, roomX, roomY;
	public Leaf left;
	public Leaf right;
	
	public Leaf(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public boolean split() {
		if (left != null || right != null) {
			return false;
		}
		boolean splitHorizontally = Math.random() > 0.5;
		if(width > height && width / height >= 1.25) {
			splitHorizontally = false;
		} else if (height > width && height / width >= 1.25) {
			splitHorizontally = true;
		}
		int max_size = (splitHorizontally ? height : width) - min_size;
		if (max_size <= min_size) return false;
		int range = max_size-min_size + 1;
		int split = (int)(Math.random() * range)+min_size;
		
		if(splitHorizontally) {
			left = new Leaf(x,y,width,split);
			right = new Leaf(x,y+split, width, height-split);
		} else {
			left = new Leaf(x,y,split,height);
			right = new Leaf(x+split,y,width-split,height);
		}
		
		return true;
	}
	
	public void createRoom() {
		if (left != null || right != null) {
			if (left != null) {
				left.createRoom();
			}
			if (right != null) {
				right.createRoom();
			}
		} else {
			int min_room_size = 3;
			int rangeW = width-min_room_size + 1;
			int rangeH = height-min_room_size+1;
			roomW = (int)(Math.random() * rangeW)+min_room_size;
			roomH = (int)(Math.random() * rangeH)+min_room_size;
			roomX = (int)(Math.random() * (width-roomW));
			roomY = (int)(Math.random() * (height-roomH));
		}
	}
	
	public String toString() {
		return this.x + " " + this.y + " | " + this.width + " " + this.height + " | " + roomW + " " + roomH + " | " + roomX + " " + roomY;
	}
}
