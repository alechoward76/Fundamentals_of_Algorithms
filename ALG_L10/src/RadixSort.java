
/**
 * Implementation of Radix Sort with multiple queues
 * 
 * Alec Howard
 * SID: 1555155
 */

import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class RadixSort {

	public static void main(String[] argv) {
		QueueReferenceBased<Integer> Q = null;
		try {
			Q = new QueueReferenceBased<Integer>();
			// Read file radix.dat into a queue Q
			Scanner scan = new Scanner(new File("radix.dat"));
			// Calling RadSort with queue Q and the pass number
			while (scan.hasNextInt())
				Q.enqueue(scan.nextInt());
			scan.close();
		} catch (IOException e) {
			System.err.println("error obtaining the data");
			System.exit(9);
		}
		radixSort(Q);
	}

	public static void radixSort(QueueReferenceBased<Integer> Q) {
		radixSort(Q, 1);
	}

	public static void radixSort(QueueReferenceBased<Integer> Q, int k) {
		System.out.println("~~  sorting column " + k + " ~~");
		final int NUMDIGITS = 5; // maximum number of digits in data
		final int NUMBASE = 10; // decimal numbers, base 10
		// creation of the array
		ArrayList<QueueReferenceBased<Integer>> pockets = new ArrayList<QueueReferenceBased<Integer>>(NUMBASE);
		// instantiation of the array
		for (int i = 0; i < NUMBASE; i++)
			pockets.add(i, new QueueReferenceBased<Integer>());
		// enqueue the appropriate pockets
		/* TO COMPLETE */
		// dequeue the pockets in the appropriate order
		// and print the elements right-aligned

		for (int j = 1; j <= NUMDIGITS; j++) {
			while (!Q.isEmpty()) {

				int item = Q.dequeue();
				int kth = getKthNumber(item, k, NUMBASE);
				QueueReferenceBased<Integer> dest = pockets.get(kth);
				dest.enqueue(item);
				// Dequeues pockets, passes one digit of radix sort, & enqueues items to dest

			}

		} // end for
		/* TO COMPLETE */
		for (int c = 0; c < pockets.size(); c++) {
			while (!pockets.get(c).isEmpty()) {
				Q.enqueue(pockets.get(c).dequeue());
				// puts numbers in each pigeonhole, in order, back to Q
			}
		}
		QueueReferenceBased<Integer> temp2 = null;
		temp2 = new QueueReferenceBased<Integer>();
		while (!Q.isEmpty()) {
			System.out.printf("%5d\n", Q.peek());
			if (!Q.isEmpty()) {
				int temp = Q.peek();
				Q.dequeue();
				temp2.enqueue(temp);

			}
			if (Q.isEmpty()) {
				Q = temp2;
				break;
			}

		}
		// prints out Q, right justified, and then reassigns the values back to Q so the
		// values can be used again

		// Make recursive call if necessary
		/* TO COMPLETE */

		if (k >= 5) {

		} else {
			radixSort(Q, k + 1);
		}

	} // end RadSort

	/**
	 * find the kth digit of a number num writen in base numbase
	 * 
	 * @param num     is the number whose kth digit is being retrieved
	 * @param k       is the position of the digit we want to know (from the right)
	 * @param numbase is the base used to write <code>num</code> (ex base 10).
	 */
	public static int getKthNumber(Integer num, int k, int numbase) {
		return (num / (int) Math.pow(numbase, k - 1)) % numbase;
	}

}// end RadixSort
