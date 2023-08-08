/**
 * CS 2003 - Lab 1
 * Code to create a bank account and make transactions based on amounts read in from an input file
 * TODO: fix all bugs in the code including those causing compilation errors and runtime logical problems
 *
 * @Alec Howard
 */

import java.util.*;
import java.io.File;
import java.io.IOException;


public class lab1a {  //Corrected Class Name
    static ArrayList<Float> transactions; /** stores the data retrived from the file */
    static long startTime, endTime; /** variable used to compute the run-time */
    static BankAcc account; // NOTE: use of interface for declaring a variable
    /** Reads numbers from the provided input filename and stores them in an ArrayList */
    static private void readFile(String inpFileName) {
	  try {
	    File inputFile = new File(inpFileName);
	    Scanner input = new Scanner(inputFile);
	    transactions = new ArrayList<Float>();
	    Float element,max;
	    int maxPos,count=0;
	    // reads elements from a file and stores them in an ArrayList 
	    while (input.hasNextFloat()){
	    	element = input.nextFloat();
	    	count++;
	    	transactions.add(element);
	    }	
	    input.close();
	    // print on the terminal each amount transacted
	    System.out.printf("There are %d transactions in the input file:\n",count);
	    short cnt=1;
	    for (Float value: transactions){
		  System.out.printf("Transaction %d) ",cnt++);
		  if(value<0)
			  account.withdraw(Math.abs(value));
		  else
			  account.deposit(value);
	    }    
	    // find the maximum absolute transaction amount
	    // (uses a random index to start the search)
	    Random generator = new Random();
	    int index = generator.nextInt(count);
	    max = Math.abs(transactions.get(index));  //Corrected the command for absolute value
	    maxPos =index;  
	    for(int i=0;i<count;i++){
		  Float value = transactions.get((index+i)%count);
		  if(max < value){//find the true largest transaction
		    max = value;
		    maxPos=(index+i+1)%count;//fix maxPos to represent the true position of the max transaction
		  }
	    }
	    //output results
	    System.out.println("\nThe maximum transaction amount is "+max+", the "+maxPos+"th transaction.\n");
	    // new account created, amount deposited, transfer performed
	    BankAccount account2 = new BankAccount("swissBankAcc");
	    account2.deposit(1000000.01f);
	    account2.transfer(1000.0f,account);
	  } 
	  catch (IOException e) {
	    System.err.println("IOException: input file "+inpFileName+" not found!");
	  }	
    } //end readFile()
    
    /** main method: reads from input file, performs transactions, computes run time */
    public static void main(String args[]) {
    	startTime = System.currentTimeMillis();
    	account= new BankAccount("piggyBank"); // new Bank Account created
    	readFile("lab1a.txt");
    	endTime = System.currentTimeMillis();    
    	System.out.println("\nTotal time taken: " + (endTime - startTime) + " milliseconds");
    } //end main
}