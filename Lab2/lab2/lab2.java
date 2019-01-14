package lab2;
import java.util.Scanner;
public class lab2 {
	

	public static void main(String[] args){
		
		int[] nums = new int[5];
		int[] matches = new int[2];
		boolean isMatch = false;
		int matchTally = 0;  //instance variables, 2 arrays, one for input one for when a match is found, bool for later if statement, and tally to hold place in the matches array
		Scanner in = new Scanner(System.in);
		System.out.println("Enter 5 Numbers");
		for(int c = 0; c < nums.length; c++) //for loop inputting user values to int array
		{
			nums[c] = in.nextInt();
		}
		System.out.println("Thanks for the numbers, bro."); //tbh this was to check if it was making it through the for loop when i was having an error, but im keeping it
		in.close(); //closing scanner cause eclipse thinks that it important
		for(int x = 0; x < nums.length; x++) 
		{
			for(int y = 0; y < nums.length; y++) //double for loop to compare the values inside the array
			{
				if(nums[x] == nums[y] && x != y)//checking if they match and aren't at the same index
				{
					isMatch = true;//changing bool to indicate a match
					
					boolean isDupe = false;//bool to be used to check if the number is already in the match array
					for(int z = 0; z< matches.length; z++)//for loop to scan the match array and compare the possible new value
					{
						if(nums[x] == matches[z])
						{
							isDupe = true;
						}
					}
					if(!isDupe)//if there is no duplicate, add to matches array
					{
						matches[matchTally] = nums[x];
						matchTally++;
					}
					
					
				}
			}
		}
		if(isMatch)//if statement to print the matched values, if any
		{
			for(int x = 0; x < matches.length; x++) //for loop to go through the array
			{
				if(matches[x] != 0)
				{
					System.out.print("There are multiple " + matches[x] + "s.");
					System.out.println();
				}
			}
			
		} else
		{
			System.out.println("There are no matches.");
		}
		 	 
		}
		
	}
