/**
 * A class that can simulate dice rolls and use methods to find averages using a sum and total number of rolls, all held within
 * @author Henry Williamson
 * Date: 9/17/18
 * 
 */

package dice;

public class Dice {
	
		/**variable to hold the value when rolling the die  */
	private int roll;
		/** variable to hold the sum of all rolls thus far */
	private int rollSum = 0;
		/**  variable to hold the total number of rolls requested */
	private int totalRolls = 0;
		/** variable that holds the value found when averaging and can be used to return it */
	private int rollsAvg;
		/** variable that holds the value found when averaging as a double rather than an int for increased accuracy */
	private double rollsAvgD;
	
		/** constructor to create an instance of this class with a specified number of rolls 
		 * @param inRolls number of rolls desired */
	public Dice(int inRolls)
	{
		totalRolls = inRolls;
	}
	
		/** method that genertaes and returns a random number between 1 and 6 */
	public void rollDice()
	{
		roll = (int)((6 * Math.random()) + 1);
	}
	
		/** method that returns the value of the roll
		 * @return currently stored roll */
	public int getRoll()
	{
		return roll;
	}
	
		/** method to update the sum of all rolls
		 * @param nextRoll value of the next roll added to sum */
	public void updateSum(int nextRoll)
	{
		rollSum += nextRoll;
	}
	
		/** method to return the total number of rolls used for finding the average
		 * @return total number of rolls */
	public int getTotalRolls()
	{
		return totalRolls;
	}
	
		/** returns the sum
		 * @return sum of all rolls thus far */
	public int getSum()
	{
		return rollSum;
	}
	
		/** method used to find the average using the total sum and the total number of rolls input by the user
		 * @return average of rolls integer */
	public int getAvg()
	{
		rollsAvg = (rollSum/totalRolls);
		return rollsAvg;
	}
	
		/** same as above, but both have been changed to doubles to include a decimal value
		 * @return average of rolls double */
	public double getAvgD()
	{
		rollsAvgD = (((double)rollSum)/((double)totalRolls));
		return rollsAvgD;
	}
}
