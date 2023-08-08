import java.util.Iterator;

/*
   Implementation of the Set ADT that uses a ListReferenceBased private variable to store data
*/
public class SetClass<E> implements SetInterface<E> {

	private ListReferenceBased<E> L;

	/*
	 * Provide code for the following methods:
	 * -----------------------------------------------------------------------------
	 * -- Constructors: a default constructor, a constructor that takes a single
	 * argument of type E and initializing the set to contain that object, and a
	 * copy constructor.
	 */
	public SetClass() { // Default Constructor
		L = new ListReferenceBased<E>();
	}

	public SetClass(E elt) {
		L.append(elt);
	}

	public SetClass(SetClass<E> lst2) { // copy constructor
		L = new ListReferenceBased<E>(lst2.L);

	}

	/*
	 * Methods: - setSize: a method that returns the number of elements in the set
	 * as an int value, - print: a method that prints out the contents of the set, -
	 * insert: a method that takes an element of type E and inserts it into the set,
	 * - arrayInsert: a method that takes an array of elements of type E and inserts
	 * them into the set, - union: a method that takes a Set as an argument and
	 * returns a new Set that is the union of the current set and the argument, -
	 * intersection: a method that takes a Set as an argument and returns a new Set
	 * that is the intersection of the current set and the argument, - difference: a
	 * method that takes a Set as an argument and returns a new Set that is the
	 * difference of the current set and the argument, - in: a method that takes an
	 * element of type E and returns a boolean value depending on whether the given
	 * E is contained in the current set or not.
	 * -----------------------------------------------------------------------------
	 * --
	 */
	/**
	 * This method implements the iterator required by the Iterable interface, with
	 * SetInterface inherits from. It enables the list to be iterable, which allows
	 * the use of enhanced for loops.
	 *
	 * @param none
	 * @return an iterator
	 */
	public Iterator<E> iterator() {
		return (L.iterator());
	}

	@Override
	public SetClass<E> union(SetInterface<E> S) { // union of two sets, keeping duplicates out
		SetClass<E> UnionList = new SetClass<E>();
		for (E x : S) {
			UnionList.L.append(x);
		}
		for (E x : this) {
			if (this.in(x) == false) {
				UnionList.L.append(x);
			}
		}
		return UnionList;
	}

	@Override
	public SetClass<E> intersection(SetInterface<E> S) { // creates set containing intersecting numbers
		// TODO Auto-generated method stub
		SetClass<E> IntersectionList = new SetClass<E>();

		for (E x : S) {
			if (this.in(x) == true) {
				IntersectionList.L.append(x);
			}
		}

		return IntersectionList;
	}

	@Override
	public SetClass<E> difference(SetInterface<E> S) { // Creates new set containing Numbers that were not the same in
														// the two sets
		SetClass<E> DifferenceList = new SetClass<E>();

		for (E x : S) {
			if (this.in(x) == false) {
				DifferenceList.L.append(x);
			}
		}

		for (E x : this) {
			if (S.in(x) == false) {
				DifferenceList.L.append(x);
			}
		}

		return DifferenceList;
	}

	@Override
	public int setSize() { // returns size

		return L.size();
	}

	@Override
	public void print() { // prints list to console
		L.display();
	}

	@Override
	public void insert(E elt) { // inserts element into set

		if (L.contains(elt) == -1) {
			L.append(elt);
		}

	}

	@Override
	public void arrayInsert(E[] arr) { // inserts array of elements into set
		for (E item : arr)
			L.append(item);

	}

	@Override
	public boolean in(E elt) { // Returns a boolean if element is in set
		if (L.contains(elt) > 0) {
			return true;
		} else {
			return false;
		}

	}

}