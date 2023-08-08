/*Alec Howard
 * SID: 1555155
 * CS-2000-L2
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Lab4 {
	static ArrayList<Double> list;

	public class MinMaxObj { // creates object inner class
		private double min;
		private int minPos;
		private double max;
		private int maxPos;

		MinMaxObj() {

		}

	}

	public static MinMaxObj findMinMaxObj(ArrayList<Double> list, int idx, MinMaxObj obj) {// method includes the
																							// arrayList, index, and
																							// myObj with the min and
																							// max
		// beginning of recursive funct.
		if (idx == list.size()) { // base case for recursive funct
			
			return obj;
		}

		else if (list.get(idx) > obj.max) {// if the new value is greater than curr max; set its value and index as new
											// max
			obj.max = list.get(idx);
			obj.maxPos = idx;
		}

		else if (list.get(idx) < obj.min) { // if val is less than curr min; sets its value and idx as min
			
			obj.min = list.get(idx);
			obj.minPos = idx;
		}

		obj = findMinMaxObj(list, idx + 1, obj);
		return obj;
	}

	public static void main(String args[]) {
		// static ArrayList<Float> transactions;
		try {// start of error catch
			Scanner scnr = new Scanner(System.in);
			System.out.println("Enter File Name: ");// takes user input and reads file
			String fName = scnr.nextLine();
			scnr = new Scanner(new File(fName));
			list = new ArrayList<Double>();
			int i;
			while (scnr.hasNextLine()) {
				String str1[] = scnr.nextLine().split(" "); // parses the text file at spaces to separate values
				for (i = 0; i < str1.length; i++) {
					list.add(Double.parseDouble(str1[i])); // adds parsed doubles to arrayList
				}
			}
			Lab4 copy = new Lab4();
			MinMaxObj obj2 = copy.new MinMaxObj();// makes min/max obj
			obj2 = findMinMaxObj(list, 0, obj2);

			int count = 0;
			System.out.println("The List Contains: ");
			for (Double j : list) { // prints items from list
				System.out.print(j + ", ");
				count++; // counts # of items in list
			}
			System.out.println("");
			System.out.println("There are " + count + " items in the list");
			System.out.println("Min: " + obj2.min + " at index position: " + obj2.minPos);
			System.out.println("Max: " + obj2.max + " at index position: " + obj2.maxPos);

			scnr.close();

		}

		catch (IOException e) {
			System.err.println("IOException: input file " + System.in + " not found!");
		}

	} // end main **********************************************

} // end Template Class ************************************
