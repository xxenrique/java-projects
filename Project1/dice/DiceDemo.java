package dice;
import java.util.Scanner;
public class DiceDemo {
	
		/** main method to use and manipulate an instance of the Dice class
		 * @param args default for main method */
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);	 //new instance of scanner class
		System.out.println("How many rolls would you like to do?");
		int numRoll = in.nextInt(); 	//getting user input of an integer value
		in.close();
		Dice die = new Dice(numRoll); 	//making an instance of the dice class with the provided input
		System.out.println();
		for(int x = 0; x < numRoll; x++) 	//for loop to simulate a dice roll and update the sum held within the class, then repeat
		{
		die.rollDice();
		die.updateSum(die.getRoll());
		}
			//printing the results yo
		System.out.println("All " + die.getTotalRolls() + " rolls came to a total sum of " + die.getSum() + " with an average of " + die.getAvg() + ",");
		System.out.println("or more precisely, " + die.getAvgD());
	}
}
