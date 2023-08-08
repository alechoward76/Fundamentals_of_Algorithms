
//Alec Howard
//SID: 1555155
import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import BinaryTrees.*;
import java.util.*;

public class LabTreeSort {
	static ArrayList<GraduateStudentGPA> list;

	public static void main(String[] args) {

		try {// start of error catch for incorrect file name
			String fName = "students.in";
			Scanner scnr = new Scanner(new File(fName));

			list = new ArrayList<GraduateStudentGPA>();

			while (scnr.hasNextLine()) {// goes through text file and singles out variables of Graduate &Student Classes

				Integer id = scnr.nextInt();
				String name = scnr.next();
				double gpa = scnr.nextDouble();
				if (!scnr.hasNextLine()) {
					break;
				}

				String ad = scnr.nextLine();

				GraduateStudentGPA student = new GraduateStudentGPA(id, name, gpa, ad);// creates student objects

				list.add(student);// adds student obj to list
			}

			BinarySearchTree<GraduateStudentGPA> tree = new BinarySearchTree<GraduateStudentGPA>();// new binary tree
			for (GraduateStudentGPA student : list) {// for ea element of list; add that element to the binary tree
				tree.insert(student);

			}
			TreeIterator printT = new TreeIterator(tree, 0);// iterates through tree
			printT.printInorder();// print function

		} // end try
		catch (IOException e) {// end of error catch
			System.err.println("IOException: input file " + System.in + " not found!");
		} // end catch

	}// end main

}// end LabTreeSort
