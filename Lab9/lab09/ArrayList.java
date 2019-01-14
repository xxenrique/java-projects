/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package lab09;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Realization of a list by means of a dynamic array. This is a simplified version
 * of the java.util.ArrayList class.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */

/**
 * LAB 09:
 * 
 * Update this ArrayList class with the following modifications:
 * 
 * 1. [3 points] The java.util.Collection interface includes a method,
 * contains(o), that returns true if the collection contains any object that
 * equals Object o. Implement such a method in the ArrayList class of Section
 * 7.2 (provided here) Hint: Remember to use the equals method to test equality.
 * 
 * 2. [3 points] The java.util.Collection interface includes a method, clear(),
 * that removes all elements from a collection. Implement such a method in the
 * ArrayList class of Section 7.2 (provided here) Hint: For good measure, set
 * all references to null.
 * 
 * 3. [2 points] Demo the contains() and clear() methods by adding a main method
 * below, and create an ArrayList. Add Integer elements 2, 10, 14, 36, then use
 * the toString method provided to print it. Use your new contains method to
 * check the list for 10 and 11 in another print statement. Clear the ArrayList
 * then use the toString method provided to print it.
 * 
 * 4.[2 points] Create another ArrayList in the main method, this one of type
 * String. Add the word "worst" and "bad" to the front of the list, and the
 * words "better" and "best" at the end. Print the list. Then add the word "meh"
 * in the center. Print the list again. Remove the first two words. Replace the
 * word "meh" with the word "good." Print the list again.
 * 
 */

public class ArrayList<E> implements List<E> {
	// instance variables
	/** Default array capacity. */
	public static final int CAPACITY = 16; // default array capacity

	/** Generic array used for storage of list elements. */
	private E[] data; // generic array used for storage

	/** Current number of elements in the list. */
	private int size = 0; // current number of elements

	// constructors
	/** Creates an array list with default initial capacity. */
	public ArrayList() {
		this(CAPACITY);
	} // constructs list with default capacity

	/** Creates an array list with given initial capacity. */
	@SuppressWarnings({ "unchecked" })
	public ArrayList(int capacity) { // constructs list with given capacity
		data = (E[]) new Object[capacity]; // safe cast; compiler may give warning
	}

	// public methods
	/**
	 * Returns the number of elements in the list.
	 * 
	 * @return number of elements in the list
	 */
	public int size() {
		return size;
	}

	/**
	 * Tests whether the array list is empty.
	 * 
	 * @return true if the array list is empty, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns (but does not remove) the element at index i.
	 * 
	 * @param i the index of the element to return
	 * @return the element at the specified index
	 * @throws IndexOutOfBoundsException if the index is negative or greater than
	 *                                   size()-1
	 */
	public E get(int i) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		return data[i];
	}

	/**
	 * Replaces the element at the specified index, and returns the element
	 * previously stored.
	 * 
	 * @param i the index of the element to replace
	 * @param e the new element to be stored
	 * @return the previously stored element
	 * @throws IndexOutOfBoundsException if the index is negative or greater than
	 *                                   size()-1
	 */
	public E set(int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		E temp = data[i];
		data[i] = e;
		return temp;
	}

	/**
	 * Inserts the given element at the specified index of the list, shifting all
	 * subsequent elements in the list one position further to make room.
	 * 
	 * @param i the index at which the new element should be stored
	 * @param e the new element to be stored
	 * @throws IndexOutOfBoundsException if the index is negative or greater than
	 *                                   size()
	 */
	public void add(int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i, size + 1);
		if (size == data.length) // not enough capacity
			resize(2 * data.length); // so double the current capacity
		for (int k = size - 1; k >= i; k--) // start by shifting rightmost
			data[k + 1] = data[k];
		data[i] = e; // ready to place the new element
		size++;
	}

	/**
	 * Removes and returns the element at the given index, shifting all subsequent
	 * elements in the list one position closer to the front.
	 * 
	 * @param i the index of the element to be removed
	 * @return the element that had be stored at the given index
	 * @throws IndexOutOfBoundsException if the index is negative or greater than
	 *                                   size()
	 */
	public E remove(int i) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		E temp = data[i];
		for (int k = i; k < size - 1; k++) // shift elements to fill hole
			data[k] = data[k + 1];
		data[size - 1] = null; // help garbage collection
		size--;
		return temp;
	}

	// utility methods
	/** Checks whether the given index is in the range [0, n-1]. */
	protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
		if (i < 0 || i >= n)
			throw new IndexOutOfBoundsException("Illegal index: " + i);
	}

	/** Resizes internal array to have given capacity >= size. */
	@SuppressWarnings({ "unchecked" })
	protected void resize(int capacity) {
		E[] temp = (E[]) new Object[capacity]; // safe cast; compiler may give warning
		for (int k = 0; k < size; k++)
			temp[k] = data[k];
		data = temp; // start using the new array
	}

	// ---------------- nested ArrayIterator class ----------------
	/**
	 * A (nonstatic) inner class. Note well that each instance contains an implicit
	 * reference to the containing list, allowing it to access the list's members.
	 */
	private class ArrayIterator implements Iterator<E> {
		/** Index of the next element to report. */
		private int j = 0; // index of the next element to report
		private boolean removable = false; // can remove be called at this time?

		/**
		 * Tests whether the iterator has a next object.
		 * 
		 * @return true if there are further objects, false otherwise
		 */
		public boolean hasNext() {
			return j < size;
		} // size is field of outer instance

		/**
		 * Returns the next object in the iterator.
		 *
		 * @return next object
		 * @throws NoSuchElementException if there are no further elements
		 */
		public E next() throws NoSuchElementException {
			if (j == size)
				throw new NoSuchElementException("No next element");
			removable = true; // this element can subsequently be removed
			return data[j++]; // post-increment j, so it is ready for future call to next
		}

		/**
		 * Removes the element returned by most recent call to next.
		 * 
		 * @throws IllegalStateException if next has not yet been called
		 * @throws IllegalStateException if remove was already called since recent next
		 */
		public void remove() throws IllegalStateException {
			if (!removable)
				throw new IllegalStateException("nothing to remove");
			ArrayList.this.remove(j - 1); // that was the last one returned
			j--; // next element has shifted one cell to the left
			removable = false; // do not allow remove again until next is called
		}
	} // ------------ end of nested ArrayIterator class ------------

	/**
	 * Returns an iterator of the elements stored in the list.
	 * 
	 * @return iterator of the list's elements
	 */
	@Override
	public Iterator<E> iterator() {
		return new ArrayIterator(); // create a new instance of the inner class
	}

	/**
	 * Produces a string representation of the contents of the indexed list. This
	 * exists for debugging purposes only.
	 *
	 * @return textual representation of the array list
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder("(");
		for (int j = 0; j < size; j++) {
			if (j > 0)
				sb.append(", ");
			sb.append(data[j]);
		}
		sb.append(")");
		return sb.toString();
	}
	
	public boolean contains(Object o)
	{
		for(int i = 0; i < size; i++)
		{
			if(data[i].equals(o))
			{
				return true;
			}
		}
		return false;
	
	}
	
	public void clear()
	{
		for(int i = 0; i < size; i++)
		{
			data[i] = null;
		}
		size = 0;
	}

	public static void main(String[] args)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(list.size(), 2);
		list.add(list.size(), 10);
		list.add(list.size(), 14);
		list.add(list.size(), 36);
		
		System.out.println(list.toString());
		
		System.out.println("List contains 10: " + list.contains(10));
		System.out.println("List contains 11: " + list.contains(11));
		
		list.clear();
		
		System.out.println(list.toString());
		
		
		ArrayList<String> list1 = new ArrayList<String>();
		
		list1.add(0, "Bad");
		list1.add(0, "Worst");
		list1.add(list1.size(), "Better");
		list1.add(list1.size(), "Best");
		
		System.out.println(list1.toString());
		
		list1.add((list1.size() / 2), "Meh");
		
		System.out.println(list1.toString());
		
		list1.remove(0);
		list1.remove(0);
		
		System.out.println(list1.toString());
		
		list1.set(0, "Good");
		
		System.out.println(list1.toString());
		
	}





}



