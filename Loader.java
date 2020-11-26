import java.util.Deque;
import java.util.LinkedList;

/**
 * @author hannaolsson
 *
 * @param <T> The type you want to store A class representing a place to store
 *            objects
 */
public class Loader<T> {

	/**
	 * The objects are saved to a Deque
	 */
	private Deque<T> thingsLoaded;
	/**
	 * the max number of things to store in a instance of Loader
	 */
	private int capacity;
	/**
	 * either first in first out, or last in first out
	 */
	private boolean fifo;

	/**
	 * @param capacity the max nr of things you can store in this instance of Loader
	 * @param fifo     fifo or lifo
	 */
	public Loader(int capacity, boolean fifo) {
		this.thingsLoaded = new LinkedList<T>();
		this.capacity = capacity;
		this.fifo = fifo;

	}

	/**
	 * @return the Deque with the things loaded
	 */
	public Deque<T> getThingsLoaded() {
		return thingsLoaded;
	}

	/**
	 * @param thing the thing to load only loads if there is room in the storage
	 */
	public void load(T thing) {
		if (isRoom()) {

			thingsLoaded.add(thing);
		}

		else
			throw new ArithmeticException("The loader is full");
	}

	/**
	 * Either unloding according to fifo or lifo
	 */
	public void unLoad() {
		if (fifo) {
			thingsLoaded.removeFirst();
		} else {
			thingsLoaded.removeLast();
		}
	}

	/**
	 * @return capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @return how many things are loaded/stored
	 */
	public int sizeOfThingsLoaded() {
		return thingsLoaded.size();
	}

	/**
	 * @return true if the number of stored cars is less then the capacity of the
	 *         Loader
	 */
	public boolean isRoom() {
		if (thingsLoaded.size() < capacity) {
			return true;
		} else
			return false;

	}
	
	public T getLastThing() {
		return thingsLoaded.getLast();
	}

}
