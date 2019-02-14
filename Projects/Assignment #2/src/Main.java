/**
 * Write a program that acts as a interactive calculator capable of handling
 * very large nonnegative integers that uses the BigInt class. This calculator
 * need perform only the operations of addition and multiplication.
 * Each line should be (num1 operator num2) and then produce an answer of
 * 
 * 				num1
 * operator		num2
 * -----------------
 * 				num3
 * 
 * where num1 and num2 are (possibly very large) nonnegative integers,
 * operator is the single character + or *, and num3 is the integer that results
 * from the desired calculation. Be sure your interface is user friendly.
 * @author Mikael  Hinton
 *
 */

import java.util.*;

public class Main {
	
	/*
	 * Scanner to get input from user
	 */
	private static Scanner sc;

	/*
	 * Main Method
	 */
	public static void main(String[] args) {
	
		sc = new Scanner(System.in);//variable for scanning in value
		int ch;//variable for picking add,mult,min,max
		String num1s = "";//Number one inputted string
		String num2s = "";//Number two inputted string
		
			/*
			 * Welcome banner for calculator
			 */
			System.out.println("\n\tWelcome to the BigInt Calculator!");
			System.out.println("\t_________________________________");
			
			/*
			 * User entering the first number
			 */
			System.out.println("\nPlease enter first number: ");
			num1s = sc.nextLine();
		
			/*
			 * User entering second number
			 */
			System.out.println("\nPlease enter second number: ");
			num2s = sc.nextLine();
		
			/*
			 * User picking between add,mult,min,max
			 */
			System.out.println("\nPick what you would like to do:");
			System.out.println("1. Add");
			System.out.println("2. Multiply");
			System.out.println("3. Find Maximum");
			System.out.println("4. Find Minimum");
			System.out.println("\nEnter your choice (1-4)");
			ch = sc.nextInt();
			
			/*
			 * Declaring the 2 strings into BigInts
			 */
			BigInt num1 = new BigInt(num1s);
			BigInt num2 = new BigInt(num2s);
			
			/*
			 * Adding Choice
			 */
			if(ch == 1)
			{			
				System.out.println("\tAddition");
				System.out.println("\t________\n");
				System.out.println("  " + num1s);
			
				System.out.println("+ " + num2s);
				System.out.println("________________");
				System.out.println("  " + num1.add(num2));
			}
			
			/*
			 * Multiplying Choice
			 */
			if(ch == 2)
			{
				System.out.println("\tMultiplication");
				System.out.println("\t______________\n");
				System.out.println("  " + num1s);
			
				System.out.println("x " + num2s);
				System.out.println("________________");
				System.out.println("  " + num1.multiply(num2));
			}
			
			/*
			 * Maximum Choice
			 */
			if(ch == 3)
			{
				System.out.println("\tMaximum");
				System.out.println("\t_______\n");
				System.out.println("Finding max between " + num1s + " and " + num2s);
				System.out.println(num1.max(num2) + " is the bigger number");
			}
			
			/*
			 * Minimum Choice
			 */
			if(ch == 4)
			{
				System.out.println("\tMinimum");
				System.out.println("\t_______");
				System.out.println("Finding min between " + num1s + " and " + num2s);
				System.out.println(num1.min(num2) + " is the smaller number");		
			}
	}//main

}//OEF
