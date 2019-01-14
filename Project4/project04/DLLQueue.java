package project04;

public class DLLQueue<E> implements Queue<E> {
		/** instance of doublylinkedlist class to demonstrate the queue */
	private DoublyLinkedList<E> list = new DoublyLinkedList<E>();
		/** method to return the size of the queue
		 * @return integer size of queue */
	public int size()
	{
		return list.size();
	}
		/** method to return the state of emptiness
		 * @return true or false depending on emptiness */
	public boolean isEmpty()
	{
		return list.isEmpty();
	}
		/** method to add an element to the end of the queue
		 * @param e element to be added to the queue */
	public void enqueue(E e)
	{
		list.addLast(e);
	}
		/** method to return the first element in line
		 * @return first element in the queue */
	public E first()
	{
		return list.first();
	}
		/** method to remove and return the first element added to the queue
		 * @return element removed from front of queue */
	public E dequeue()
	{
		E e = list.first();
		list.removeFirst();
		return e;
	}
		/** method to return queue in string form
		 * @return string form of queue */
	public String toString()
	{
		return list.toString();
	}
}
