/**
 * Alec Howard SID:1555155 
 * Double hash class
 */
public class DoubleHash<E> {
	// status contain 1 if an item is present, 0 if not
	private int[] status;
	// stores the elements of type KeyValuePair<E>
	private KeyValuePair<E>[] hTable;

	// constructor
	public DoubleHash(int lengthOfTable) {
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
	public int hash1(String str) {
		return Math.abs(str.hashCode()) % status.length;
	}

	/**
	 * hashing function # 2 TO BE COMPLETED must return a hash value for string str
	 * representing step size for double hash
	 * 
	 * @param str
	 * @return int: hashed value of string str
	 */
	public int hash2(String str) {
		return Math.abs(31 - (str.hashCode() % 31)); // prime number hashing
	}

	/**
	 * TO BE COMPLETED method to add an item of type KeyValuePair<E>
	 * 
	 * @param kv of type KeyValuePair<E>
	 * @return int: number of collisions due to addition of kv
	 */
	public int add(KeyValuePair<E> kv) {
		int c = 0;// collisions

		int h2 = hash2(kv.getKey());
		int h = hash1(kv.getKey());

		while (status[h] != 0) {
			h = (h + h2) % hTable.length;

			c++;
		}
		status[h] = 1; // status to full
		hTable[h] = kv; // inserts keyval

		return c;// return collisions
	}

	/**
	 * TO BE COMPLETED method to retrieve an item from the hashtable given the key
	 * to look for
	 * 
	 * @param String: key
	 * @return KeyValuePair<E>: item
	 */
	public KeyValuePair<E> retrieve(String key) { 
		KeyValuePair<E> item = hTable[hash1(key) % hTable.length];
		return item;
	}
}
