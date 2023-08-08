
/*Alec Howard
 * SID: 1555155
 */
import java.util.ArrayList;
import java.util.Iterator;

public class SortedList<E extends Comparable<? super E>> implements SortedListInterface<E>, Iterable<E> {

	private ArrayList<E> list;

	public SortedList() {
		list = new ArrayList<E>();
	}// end default

	public SortedList(E itm) {
		list = new ArrayList<E>();
		list.add(itm);
	}// end of specified

	public SortedList(SortedList<E> arr) {
		list = new ArrayList<E>();
		for (E x : arr) {
			list.add(x);
		}
	}// end of copy constructor

	public Integer BinarySearch(ArrayList<E> array, int first, int last, E item) {// binary search algorithm

		if (first > last) {
			// System.out.println("invalid index");
			return 0;

		} // end if
		else {
			int mid = (first + last) / 2;

			if (array.get(mid).compareTo(item) == 0) {
				return (mid);

			} // end if
			else if (array.get(mid).compareTo(item) < 0) {
				BinarySearch(array, mid + 1, last, item);

			} // end else if
			else {
				BinarySearch(array, first, mid - 1, item);

			} // end else
			return mid;
		} // end else

	}

	// SortedListInterfaceMethods
	public void sortedAdd(E item) {
		// list.add(item);
		int idx = locateIndex(item);
		list.add(idx, item);

	}

	public void sortedRemove(E item) {
		list.remove(list.remove(item));
	}

	public int locateIndex(E item) {
		return BinarySearch(list, 0, list.size() - 1, item);
	}

	public void display() {
		System.out.println(list);
	}

	// BasicListInterfaceMethods

	public boolean isEmpty() {
		if (list.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public int size() {
		return list.size();
	}

	public void removeAll() {
		list.clear();
		;
	}

	public E get(int index) {
		return list.get(index);
	}

	/** method to make the class iterable */

	public Iterator<E> iterator() {
		return list.iterator();
	}

} // end class