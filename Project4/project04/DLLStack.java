package project04;

public class DLLStack<E> implements Stack<E> {
		/** instance of doublylinkedlist class to demonstrate the stack */
	private DoublyLinkedList<E> list = new DoublyLinkedList<E>();
	
		/** method to return the size of the stack
		 * @return integer size of the stack */
	public int size()
	{
		return list.size();
	}
		/** method to return whether the stack is empty or not
		 * @return true of false based on emptiness */
	public boolean isEmpty()
	{
		return list.isEmpty();
	}
		/** method to push an element to the top of the stack
		 * @param e generic element to be pushed on the top */
	public void push(E e)
	{
		list.addLast(e);
	}
		/** method to return the topmost element of the stack
		 * @return topmost element in stack */
	public E top()
	{
		return list.last();
	}
		/** method to pop the topmost element and return it
		 * @return element that was removed */
	public E pop()
	{
		E e = list.last();
		list.removeLast();
		return e;
	}
		/** method to call the DLL toString method to return the stack as string
		 * @return stack in string form */
	public String toString()
	{
		return list.toString();
	}
		/** method using a stack to test if an input string is a palindrome
		 * @param input String being tested if it is a palindrome
		 * @return an answer as to whether the input was a palindrome */
	public String testPalindrome(String input)
	{
		DLLStack<Character> palindromeTest = new DLLStack<>();		//creating an instance of this class so i can use the stack to test
		
		String input1 = input.replaceAll("\\s", "");		//making a new string but without the spaces to prevent false negatives
		
		for(int i = 0; i < input1.length(); i++)		//for loop to push the string into a stack one character at a time
		{
			palindromeTest.push(input1.charAt(i));
		}
		
		String reverse = "";		//currently empty string to hold the reversed input
		
		for(int i = (palindromeTest.size() - 1); i >= 0; i--)		//for loop to pop 1 character at a time and add the characters in reverse order
		{
			reverse = reverse + palindromeTest.pop();
		}
		
		if(input1.equals(reverse))		//if statement that checks equality of strings and returns an answer
		{
			String answer = "The input string, '" + input + "' is a palindrome";
			return answer;
		}
		else
		{
			String answer = "The input string, '" + input + "' is not a palindrome";
			return answer;
		}
	}
}
