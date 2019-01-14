/**
 * Lab 10
 * Program Correctness
 * 
 * Finish setting up the preconditions and postconditions for the 
 * yearsDaysToDays unit test. We want to guarantee the user input is 
 * valid, and test output against several vectors to ensure correctness.
 * 
 * This program should take two command line argument, both integers between
 * 0 and 1000. The first arg is a number of years, and the second is a number
 * of days. The program is to return the whole amount of time as a number of days.
 * 
 * This Unit test uses assert, which can be tested at the command line by typing
 * the command line option -ea Ex: java -ea yd2dUnitTest [arg1, arg2]
 * you may need to be in the bin directory to run it. Ex: java -ea lab10/yd2dUnitTest [arg1, arg2]
 * It is also possible to use command line options and arguments inside the IDE.
 * In Eclipse: Run > Run Configurations... Arguments Tab, 
 * Example: Program Arguments (2, 20), VM Arguments (-ea)
 * 
 * 
 */


package lab10;

public class yd2dUnitTest {

	public static double yearsDaysToDays(int givenYears, int givenDays) {

		double totalDays;
		totalDays = (givenYears * 365) + givenDays;
		int leap = givenYears/4;
		totalDays += leap;
		
		// TODO: add 1 day for every 4 years to count leap years

		return totalDays;
	}
	
	public static void ensureRange(int n, int max) throws IllegalArgumentException {
		if ((n < 0) || (n > max)) {
			throw new IllegalArgumentException("Out of Range.");
		}	
	}
	
	public static boolean ensureValue(int y, int d)
	{
		
		if(y > 0 && d > 0 && y < 1000 && d < 1000)
		{
			return true;
		}
		return false;
	
	}

	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("ERROR: Please restart and provide two command line arguments:");
			System.out.println("A positive integer for years, and a positive integer for number of days.");
			return;
		}
		
		// Preconditions: 2 positive integers between 0 and 1000;
		// TODO: Exception handling for years and days
		
		int years = Integer.parseInt(args[0]);
		int days = Integer.parseInt(args[1]);
		if(!ensureValue(years, days))
		{
			throw new IllegalArgumentException("Enter 2 integers such that 0 < y & d < 1000");
		}
		
		double allTheDays = yearsDaysToDays(years, days);
		System.out.println(allTheDays);
		
		
		// Post conditions: Total number of days given days and years combined
		// to enable asserts at the command line, type -ea Ex: java -ea yd2dUnitTest [arg1, arg2]
		// TODO: Run more test vectors ...
		// FIXME: Something appears to be a bug with this yearsDaysToDaysmethod. (fail on assertion 3)
		
		System.out.println("START Unit Test");

		assert (yearsDaysToDays(0, 0) == 0) 	: "Assertion 1 failed";
		assert (yearsDaysToDays(0, 1) == 1) 	: "Assertion 2 failed";
		assert (yearsDaysToDays(1, 0) == 365) 	: "Assertion 3 failed";
		assert (yearsDaysToDays(1, 364) == 729) 	: "Assertion 4 failed";
		assert (yearsDaysToDays(12, 0) == 4383) 	: "Assertion 5 failed";
		assert (yearsDaysToDays(500, 500) == 183125) 	: "Assertion 6 failed";
		assert (yearsDaysToDays(750, 750) == 274687) 	: "Assertion 7 failed";
		assert (yearsDaysToDays(1000, 0) == 365250) : "Assertion 8 failed";
		assert (yearsDaysToDays(999, 999) == 365883) : "Assertion 9 failed";
		assert (yearsDaysToDays(1000, 1000) == 366250) : "Assertion 10 failed";

		System.out.println("STOP Unit Test");
	}
}
