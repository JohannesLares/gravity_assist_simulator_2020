package fi.johanneslares.luolastogeneraattori.datastructures;

import java.util.stream.IntStream;

/**
 * Alternative datastructure for ArrayList
 * @author Johannes Lares
 *
 * @param <T> Type of list wanted to be created
 */
public class Array<T> {
	
	private int size = 0;
	private static final int DEF_SIZE = 10;
	private Object list[];
	
	public Array() {
		list = new Object[DEF_SIZE];
	}
	
	/**
	 * Add element to list
	 * @param element element to be added
	 */
	public void add(T element) {
		if (size == list.length) {
			grow();
		}
		list[size++] = element;
	}
	
	/**
	 * Get element with specific index
	 * @param i index
	 * @return element
	 */
	@SuppressWarnings("unchecked")
	public T get(int i) {
		if (i >= size || i < 0) {
			throw new IndexOutOfBoundsException();
		}
		return (T)list[i];
	}
	
	/**
	 * Grow the list twice as big as original
	 */
	private void grow() {
		int newSize = list.length*2;
		Object[] tmp = new Object[newSize];
		System.arraycopy(list, 0, tmp, 0, list.length);
		list = tmp;
	}
	
	public int size() {
		return this.size;
	}
	
	public void remove(int index) {
		Object[] tmp = new Object[list.length];
		for (int i = 0; i < list.length-1; i++) {
			if(i >= index) {
				tmp[i] = list[i+1];
			} else {
				tmp[i] = list[i];
			}
		}
		list = tmp;
	}
}
