package project3;

public class InsertionSorter {
	/** Empty constructor to create dn instance of the class */
	public InsertionSorter()
	{
		
	}
	
	/** method to fill an array with random integers up to a certain value
	 * @param nums input array to be filled with random integers
	 * @param upper upper limit for elements of the array */
	public int[] fill(int[] nums, int upper)           //fill array with random values 
	{
		for(int x = 0; x < nums.length; x++)
		{
			nums[x] = (int)((upper + 1) * Math.random());
		}
		return nums;
	}
	
	/**method to sort numeric elements of an array in ascending order 
	 * @param nums input array to be put into ascending order */
	public int[] sortAsc(int[] nums)
	{
		for(int k = 1; k < nums.length; k++)
		{
			int cur = nums[k];
			int j = k;
			while(j > 0 && nums[j-1] > cur)
			{
				nums[j] = nums[j-1];
				j--;
			}
			nums[j] = cur;
		}
		
		return nums;
	}
	
	/**method to sort numeric elements of an array in descending order 
	 * @param nums input array to be put into descending order */
	public int[] sortDes(int[] nums)
	{
		for(int k = 1; k < nums.length; k++)
		{
			int cur = nums[k];
			int j = k;
			while(j > 0 && nums[j-1] < cur)
			{
				nums[j] = nums[j-1];
				j--;
			}
			nums[j] = cur;
		}
		
		return nums;
	}
	/** method to shuffle the elements of the array 
	 * @param nums input array to be put into random order */
	public int[] shuffle(int[] nums)
	{
		for (int i = 0; i < nums.length; i++)
		{
			int randPos = (int)(nums.length * Math.random());
			int temp = nums[i];
			nums[i] = nums[randPos];
			nums[randPos] = temp;
		}
		return nums;
	}
	
}
