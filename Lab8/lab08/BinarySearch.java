package lab08;

/**
 * Lab 08
 * 
 * Modify the gieven recursive binary search algorithm so that it returns the index of the target
 * in the sequence or -1 (if the target is not found).
 * 
 * Create a static instance variable called searches to track the number of times binarySearch is called
 * 
 * In the main method, prompt the user for an array size n, and fill an array with random values between 1 and n.
 * you may use java.util methods Arrays.sort and Arrays.toString to sort and print the array
 * 
 * Use your modified search to test the number of searches required to find the target. 
 * 
 * Try the same test with different input sizes for n. 
 * What is the running time of binarySearch? 
 * Give your answer in a print statement at the end of the program in big-O notation.
 * 
 *
 */
import java.util.Arrays;
import java.util.Scanner;
public class BinarySearch {
	
	  /**
	   * Returns true if the target value is found in the indicated portion of the data array.
	   * This search only considers the array portion from data[low] to data[high] inclusive.
	   */
	private static int searches;
	
	public static int binarySearch(int[] data, int target, int low, int high) {
	    searches ++;
		if (low > high)
	      return -1;                                           // interval empty; no match
	    else {
	      int mid = (low + high) / 2;
	      if (target == data[mid])
	      {
	    	  return mid;  
	      }
	    	                                          
	      else if (target < data[mid])
	        return binarySearch(data, target, low, mid - 1);      // recur left of the middle
	      else
	        return binarySearch(data, target, mid + 1, high);     // recur right of the middle
	    }
	  }
	
	/** You may use the method main here to test and demo the lab... */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("How long would you like the array: ");
		int length = in.nextInt();
		int[] nums = new int[length];
		for(int i = 0; i < nums.length; i++)
		{
			nums[i] = (int)((length + 1) * Math.random());
		}
		
		System.out.println("Enter an integer to target: ");
		int target = in.nextInt();
		System.out.println(Arrays.toString(nums));
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		in.close();
		int test = binarySearch(nums, target, nums[0], nums[length - 1]);
		
		if(test == -1)
		{
			System.out.println("Target " + target + " not found");
		} else
		{
			System.out.println("Target " + target + " found at index " + test);
		}
		System.out.println(searches + " searches required for input size " + length);
		System.out.println("Running time is O(log n)");
	}

}
