/**
 * Alec Howard SID:1555155
 *  Linear probing class
 */
public class LinearProbe<E> {
	// status contain 1 if an item is present, 0 if not
	private int[] status;
	// stores the elements of type KeyValuePair<E>
	private KeyValuePair<E>[] hTable;

	// constructor
	public LinearProbe(int lengthOfTable) {
		status = new int[lengthOfTable];
		hTable = new KeyValuePair[lengthOfTable];
	}

	public int[] getStatus() {
		return status;
	}

	public KeyValuePair<E>[] getTable() {
		return hTable;
	}

	/**
	 * hashing function
	 * 
	 * @param str
	 * @return int: hashed value of string str
	 */
	public int hash(String str) {
		return Math.abs(str.hashCode()) % status.length;
	}

	/**
	 * TO BE COMPLETED method to add an item of type KeyValuePair<E>
	 * 
	 * @param kv of type KeyValuePair<E>
	 * @return int: number of collisions due to addition of kv
	 */
	public int add(KeyValuePair<E> kv) {
		int h = 0;
		int n = 0;

		int x = hash(kv.getKey()) % hTable.length;// set variable for the int value of the key's pos
		while (status[x] != 0) { // while the pos is not empty

			h++;// add collision

			n = (n + 1) % hTable.length;// linear probe
			x += n;// probe +n

		}
		status[x] = 1; // status to full
		hTable[x] = kv; // inserts keyVal
		return h;// return # collisions

	}

	/**
	 * TO BE COMPLETED method to retrieve an item from the hashtable given the key
	 * to look for
	 * 
	 * @param String: key
	 * @return KeyValuePair<E>: item
	 */
	public KeyValuePair<E> retrieve(String key) {

		KeyValuePair<E> item = hTable[hash(key) % hTable.length]; // retrieves item in modulo of the hashed key
		return item;
	}
}