package project04;

public class ArrayStack<E> implements Stack<E> {
		/** integer to hold the desired size of arraystack */
	public static final int CAPACITY = 10;
		/** declaring a generic array named data */
	private E[] data;
		/** variable to hold index of the top of the stack */
	private int top = -1;
		/** constructor to make the array the desired length */
	public ArrayStack()
	{
		data = (E[]) new Object[CAPACITY];		//book did it this way, not sure how to fix error
	}
		/** method to tell the array length
		 * @return number of elements in array */
	public int size()
	{
		return (top + 1);
	}
		/** method to test if array is empty
		 * @return true or false depending on emptiness */
	public boolean isEmpty()
	{
		if(top == -1)
			return true;
		else
			return false;
		
	}
		/** method to push an element on the top of the stack
		 * @param e element to be pushed onto the stack */
	public void push(E e) throws IllegalStateException
	{
		if(size() == data.length) throw new IllegalStateException("Stack is full");
		data[++top] = e;
	}
		/** method to return topmost element of stack
		 * @return topmost element in stack */
	public E top()
	{
		if(isEmpty())
			return null;
		else
			return data[top];
	}
		/** method to pop off the topmost element
		 * @return element that has been popped off */
	public E pop()
	{
		if(isEmpty())
			return null;
		else
		{
			E answer = data[top];
			data[top] = null;
			top--;
			return answer;
		}
	}
		/** method to return the array stack as a string
		 * @return array in pretty string from */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("(");		
		for(int i = 0; i < data.length; i++)		//for loop to add the elements of the array to the string
		{
			if(data[i] != null)		//if statement to prevent many "null" elements being added unnecessarily
			{
				sb.append(data[i]);
				if(i < data.length - 1 && data[i + 1] != null)		//another if statement to prevent hanging commas at the end of the array
				{
					sb.append(", ");
				}
			}
		}
		sb.append(")");
		return sb.toString();		//returning the final string
	}
}
