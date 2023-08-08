/*Alec Howard
 * ID: 1555155
 * Lab7.java
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Lab7 {

	public static int evaluatePostfix(String expr) {
		StackArrayListBased<Integer> stack = new StackArrayListBased<Integer>(); // initializes new stack
																					// StackArrayListBased which
																					// implements Interface's methods
		Scanner scnr2 = new Scanner(expr);
		while (scnr2.hasNext()) {

			if (scnr2.hasNextInt()) {
				stack.push(scnr2.nextInt()); // handles operands
			} else {
				String temp2 = scnr2.next();
				int nTwo = stack.pop();// must be popped first so evaluations are correct
				int nOne = stack.pop();// serves like temps for the operands

				if (temp2.equals("*")) { // multiplication case
					Integer result = (nOne * nTwo);// evaluates the two temps
					stack.push(result);// inserts the result
				} // end if1
				if (temp2.equals("/")) {// division case
					Integer result = (nOne / nTwo);
					stack.push(result);
				} // end if2
				if (temp2.equals("+")) {
					Integer result = (nOne + nTwo);
					stack.push(result);

				} // end if3
				if (temp2.equals("-")) {
					Integer result = (nOne - nTwo);
					stack.push(result);
				} // end if4
			} // end else
		} // end while
		scnr2.close();
		return (stack.pop());// returns the resulting stack

	}//end evaluatePostfix

	public static void main(String[] args) {

		try {// start of error catch for incorrect file name
			Scanner scnr = new Scanner(System.in);
			System.out.println("Please input the file name:");// takes user input and reads file
			String fName = scnr.nextLine();
			Scanner mFile = new Scanner(new File(fName));
			System.out.println(mFile);
			/*while (mFile.hasNextLine()) {
				String temp = mFile.nextLine();// temporary string to hold the line that is read

				System.out.println(temp + " = " + evaluatePostfix(temp));// prints line and its result
			}*/
		} // end try
		catch (IOException e) {// end of error catch
			System.err.println("IOException: input file " + System.in + " not found!");
		} // end catch

	}// end main

}// end Lab7