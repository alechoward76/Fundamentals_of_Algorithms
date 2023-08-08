/*
   Interface to specify the behavior/operations of the Set ADT 
*/

public interface SetInterface<E> extends Iterable<E> {

	/*
	 * Provide signature/headers for the following methods:
	 * 
	 * - setSize: a method that returns the number of elements in the set as an int
	 * value, - print: a method that prints out the contents of the set, - insert: a
	 * method that takes an element of type E and inserts it into the set, -
	 * arrayInsert: a method that takes an array of elements of type E and inserts
	 * them into the set, - union: a method that takes a Set as an argument and
	 * returns a new Set that is the union of the current set and the argument
	 * (provided below), - intersection: a method that takes a Set as an argument
	 * and returns a new Set that is the intersection of the current set and the
	 * argument, - difference: a method that takes a Set as an argument and returns
	 * a new Set that is the difference of the current set and the argument, - in: a
	 * method that takes an element of type E and returns a boolean value depending
	 * on whether the given E is contained in the current set or not.
	 * 
	 */

	public SetInterface<E> union(SetInterface<E> S);

	public SetInterface<E> intersection(SetInterface<E> S);

	public SetInterface<E> difference(SetInterface<E> S);

	/*
	 * returns the number of elements in the set as an int value
	 */
	public int setSize();

	/*
	 * takes an element of type E and inserts it into the set
	 */

	// prints out the contents of the set
	public void print();

	/*
	 * takes an element of type E and inserts it into the set
	 */
	public void insert(E elt);

	/*
	 * takes an array of elements of type E and inserts them into the set
	 */
	public void arrayInsert(E[] arr);

	// Returns boolean if set contains item
	public boolean in(E elt);

}