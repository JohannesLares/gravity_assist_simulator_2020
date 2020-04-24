package fi.johanneslares.luolastogeneraattori.map;
import java.lang.Math;

/**
 * Class for creating leafs
 * @author Johannes Lares
 *
 */
public class Leaf {
	private int min_size;
	private int min_room_size;
	public int x, y, width, height;
	public int roomW, roomH, roomX, roomY;
	public Room room;
	public Leaf left;
	public Leaf right;
	
	public Leaf(int x, int y, int width, int height, int min_size, int min_room_size) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.min_size = min_size;
		this.min_room_size = min_room_size;
	}
	
	/**
	 * Split leaf in two child leafs, if width and height of new child is bigger than min_size 
	 * @return if leaf has been split
	 */
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
			left = new Leaf(x,y,width,split, min_size, min_room_size);
			right = new Leaf(x,y+split, width, height-split, min_size, min_room_size);
		} else {
			left = new Leaf(x,y,split,height, min_size, min_room_size);
			right = new Leaf(x+split,y,width-split,height, min_size, min_room_size);
		}
		
		return true;
	}
	
	/**
	 * Create room into leaf. I f leaf has child leafs, create room to child leafs.
	 */
	public void createRoom() {
		if (left != null || right != null) {
			if (left != null) {
				left.createRoom();
			}
			if (right != null) {
				right.createRoom();
			}
		} else {
			int rangeW = width-min_room_size + 1;
			int rangeH = height-min_room_size+1;
			roomW = (int)(Math.random() * rangeW)+min_room_size;
			roomH = (int)(Math.random() * rangeH)+min_room_size;
			roomX = (int)(Math.random() * (width-roomW));
			roomY = (int)(Math.random() * (height-roomH));
			room = new Room(roomW, roomH, roomX, roomY);
			room.setMapPosition(roomX + x, roomY + y);
			//System.out.println("Roompos: " + room.getMapX() + ", " + room.getMapY() + " Room dimensions: " + room.getWidth() + ", " + room.getHeight());
		}
	}
	
	/**
	 * Get leafs room 
	 * @return Room
	 */
	public Room getRoom() {
		if (room != null) {
			return room;
		} else {
			Room leftRoom = null;
			Room rightRoom = null;
			if (left != null) {
				leftRoom = left.getRoom();
			}
			if (right != null) {
				rightRoom = right.getRoom();
			}
			if (leftRoom == null && rightRoom == null) {
				return null;
			} else if (leftRoom == null) {
				return rightRoom;
			} else if (rightRoom == null) {
				return leftRoom;
			} else {
				return rightRoom;
			}
		}
	}
	
	
	/**
	 * Return room data as debuggable string
	 */
	public String toString() {
		return this.x + " " + this.y + " | " + this.width + " " + this.height + " | " + roomW + " " + roomH + " | " + roomX + " " + roomY;
	}
}
