package project3;
import java.util.Scanner;

public class InsertionSortDemo {

	public static void main(String[] args) {
		int[] nums;
		InsertionSorter sorter = new InsertionSorter();
		int x = 0;
		Scanner in = new Scanner(System.in);
		System.out.println("How Long Would You Like to Make the Array?");
		int input = in.nextInt();
		nums = new int[input];
		System.out.print("Enter Upper Limit for Elements: ");
		int upper = in.nextInt();
		System.out.println();
		System.out.println("Filling Array with Elements Between 0 and " + upper);
		System.out.println();
		sorter.fill(nums, upper);
		print(nums);
		
		loop1: while(x == 0)
		{
			System.out.println();;
			System.out.println("1. Sort Ascending");
			System.out.println("2. Sort Descending");
			System.out.println("3. Shuffle");
			System.out.println("4. Quit");
			int switcher = in.nextInt();
			switch(switcher)
			{
				case 1: sorter.sortAsc(nums);
					break;
				case 2: sorter.sortDes(nums);
					break;
				case 3: sorter.shuffle(nums);
					break;
				case 4: print(nums);
					System.out.println("Goodbye");
					break loop1;
			}
			System.out.println();
			print(nums);
			
		}
	}
	
	public static void print(int[] nums)	//method for pretty printing
	{
		System.out.print("[");
		for(int i = 0; i < nums.length; i++)
		{
			if(i > 0 && i < nums.length)
			{
				System.out.print(", ");
			}
			System.out.print(nums[i]);
		}
		System.out.println("]");
	}
}


