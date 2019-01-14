package lab5;

import java.util.Arrays;

public class ReverseGenericDemo {
	//generic reversal algorithm
	public static <T> void reverseAny(T[] data) {
		int min = 0;
		int max = data.length - 1;
		while (min < max) { 			
			T temp = data[min];
			data[min++] = data[max]; 	
			data[max--] = temp; 		
		}
	}
	public static void main(String[] args)
	{
		//integers
		Integer[] nums = new Integer[20];
		for (int x = 0; x < nums.length; x++) {
			nums[x] = x * 5;
		}
		System.out.println(Arrays.toString(nums));
		ReverseGenericDemo.reverseAny(nums);
		System.out.println(Arrays.toString(nums));
		
		
		//strings
		String[] words = new String[5];
		words[0] = "I";
		words[1] = "Like";
		words[2] = "To";
		words[3] = "Eat";
		words[4] = "Pie";
		System.out.println(Arrays.toString(words));
		ReverseGenericDemo.reverseAny(words);
		System.out.println(Arrays.toString(words));
		
		
		//songs
		Song[] playlist = new Song[5];
		playlist[0] = new Song("All I Want for Christmas is You", "Mariah Carey");
		playlist[1] = new Song("Undone - Sweater Song", "Weezer");
		playlist[2] = new Song("Peaches", "The Presidents of the United States of America");
		playlist[3] = new Song("Ain't No Rest for the Wicked", "Cage the Elephant");
		playlist[4] = new Song("Pork And Beans", "Weezer");
		for(int x = 0; x < playlist.length; x++)
		{
			System.out.println(x+1 + ": " + playlist[x].toString());
		}
		ReverseGenericDemo.reverseAny(playlist);
		for(int x = 0; x < playlist.length; x++)
		{
			System.out.println(x+1 + ": " + playlist[x].toString());
		}
	}
	
}
