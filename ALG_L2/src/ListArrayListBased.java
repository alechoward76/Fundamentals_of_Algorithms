
/**
 * Alec Howard
 * 1555155
 * Section: Wednesday
 * Array-based implementation of the ADT list.
 * 
 */
import java.util.ArrayList;
import java.util.Iterator;

public class ListArrayListBased<E> implements ListInterface<E>, Iterable<E> {

	/** contained ArrayList object */

	private ArrayList<E> items;

	/** default Constructor */
	// TO COMPLETE
	public ListArrayListBased() {
		items = new ArrayList<E>();

	}

	/**
	 * constructor with the first item: constructs a list with the specified item as
	 * single element of this list
	 * 
	 * @param item first element of the list
	 */
	// TO COMPLETE
	public ListArrayListBased(E num1) {
		items = new ArrayList<E>();
		items.add(0, num1);
	}

	/**
	 * copy constructor: create a duplicate of the specified list
	 * 
	 * @param list to be copied
	 */
	// TO COMPLETE
	public ListArrayListBased(ListArrayListBased<E> arr) {
		items = new ArrayList<E>();
		for (E x : arr) {
			items.add(x);// enhanced for loop creats copy of list
		}

	}

	/**
	 * Tests if this list has no elements.
	 * 
	 * @return <code>true</code> if this list has no elements; <code>false</code>
	 *         otherwise.
	 */
	public boolean isEmpty() {
		return items.isEmpty();
	} // end isEmpty

	/**
	 * Returns the number of elements in this list.
	 * 
	 * @return the number of elements in this list.
	 */
	public int size() {
		return items.size();
	} // end size

	/**
	 * Remove all the elements in this list.
	 */
	public void removeAll() {
		items.clear();
	} // end removeAll

	/**
	 * Inserts the specified element at the specified position in this list. Shifts
	 * the element currently at that position (if any) and any subsequent elements
	 * to the right (adds one to their indices).
	 * 
	 * @param index index at which the specified element is to be inserted.
	 * @param item  element to be inserted.
	 * @throws IndexOutOfBoundsException - if index is out of range (index < 0 ||
	 *                                   index > size()).
	 */
	public void add(int index, E item) throws ListIndexOutOfBoundsException {
		if (index >= 1 && index <= items.size() + 1) {
			items.add(index - 1, item);
		} else { // index out of range
			throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on add");
		} // end if
	} // end add

	/**
	 * appends the specified element to the end of this list.
	 * 
	 * @param elt element to be added at the end of the list
	 */
	// TO COMPLETE
	public void append(E elt) {
		// TODO Auto-generated method stub
		add(size() + 1, elt);// appends argument to end of list
	}

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index index of element to return.
	 * @return the element at the specified position in this list.
	 * @throws IndexOutOfBoundsException - if index is out of range (index < 0 ||
	 *                                   index > size()).
	 */
	public E get(int index) throws ListIndexOutOfBoundsException {
		if (index >= 1 && index <= items.size()) {
			return items.get(index - 1);
		} else { // index out of range
			throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on get");
		} // end if
	} // end get

	/**
	 * Removes the element at the specified position in this list. Shifts any
	 * subsequent elements to the left (subtracts one from their indices).
	 * 
	 * @param index the index of the element to remove
	 * @throws IndexOutOfBoundsException - if index is out of range (index < 0 ||
	 *                                   index > size()).
	 */
	public void remove(int index) throws ListIndexOutOfBoundsException {
		if (index >= 1 && index <= items.size()) {
			// delete item by shifting all items at
			// positions > index toward the beginning of the list
			// (no shift if index == size)
			items.remove(index - 1);
		} else { // index out of range
			throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on remove");
		} // end if
	} // end remove

	/**
	 * delete delete the the specified element in this list if exists. Shifts any
	 * subsequent elements to the left (subtracts one from their indices).
	 * 
	 * @param elt the element, if it exists, to delete
	 */
	// TO COMPLETE

	public void delete(E elt) {
		// TODO Auto-generated method stub
		int count;
		for (count = 0; count < size(); count++) {

			if (elt == get(count + 1)) { // checks if item @count is == argument
				remove(count);// if so it is removed from list
			}

		}

	}

	/**
	 * contains Looks for the index of the specified element in this list. If the
	 * element is not present, the method returns <code>-1</code>
	 * 
	 * @param elt the element which index is looked for.
	 * @return either the index of the location in the list where the argument is
	 *         present or <code>-1</code> if the argument is not contained in the
	 *         list.
	 */
	// TO COMPLETE

	public int contains(E elt) {
		// TODO Auto-generated method stub
		int count;

		if (items.contains(elt)) { // checks if item @count is == argument
			return 1;// returns positive if is
		} else {
			return -1;// negative if not
		}

	}

	/**
	 * display Prints all the elements in this list on the console in sequence
	 */

	// TO COMPLETE
	public void display() {
		// TODO Auto-generated method stub
		for (int i = 0; i < size(); i++) {
			System.out.print(get(i + 1) + " ");// prints out entire list
		}
		System.out.println();
	}

	/** method to make the class iterable */

	public Iterator<E> iterator() {
		return items.iterator();
	}

} // end ListArrayListBased