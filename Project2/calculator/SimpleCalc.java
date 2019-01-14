package calculator;

import java.util.Scanner;
//errors: Empty operation - "=" still asking for number
public class SimpleCalc {
	static String operation = "+";		//initializing operation as plus t prevent operation checking - line 24
	public static void main(String[] args) {
		int x = 0;		//variable for while loop
		int runs = 0;	//run tally to check if program should ask for operation
		double total = 0;	//variable to keep track of the total
		String input = null;	//variable holding user input as a string initially
		double inputD = 0;	//variable to hold input in double form
		Scanner in = new Scanner(System.in);	//scanners yo
		Scanner in2 = new Scanner(System.in);
		loop1: while(x == 0)		//while loop to keep calc running for an unknown number of runs
		{
			inputD = 0;		//resetting input at the beginning of each iteration
			if(runs > 0)		//only asking for operation after the first run
			{
				System.out.print("Enter Operation (+, -, *, /, or =): ");
				operation = in2.nextLine();
			}
			checkOp(operation);		//method to check if the operation is a valid one, fixing error with inputting nothing when asked for operation
			if(operation.charAt(0) != '=' && !operation.equals("invalid"))		//if statement to only ask for number if necessary
			{
				System.out.print("Enter Number: ");
				input = in.nextLine();
			}
			try
			{
				inputD = Double.parseDouble(input);
			}
			catch(NumberFormatException e)
			{
				System.out.println(input + " is not a valid number.");
			}
			switch(operation)
			{
				case "+": total += inputD;
						break;
				case "-": total -= inputD;
						break;
				case "*": total *= inputD;
						break;
				case "/": total /= inputD;
						break;
				case "=": x = 1;
						break loop1;
				default: System.out.println("Invalid Operation, Try Again.");
						break;
			}
			System.out.println("Total is now: " + total);
			runs++;
		}
		System.out.println("Ending total is: " + total);
	}
	
	public static void checkOp(String inOperation)
	{
		switch(inOperation)
		{
			case "+": break;
			case "-": break;
			case "*": break;
			case "/": break;
			case "=": break;
			default: operation = "invalid";
			break;
		}
	}
}
