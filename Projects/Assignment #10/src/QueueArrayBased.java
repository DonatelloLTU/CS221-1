import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Arrays;

/**
 * Class that implements the Queue interface and the Comparable interface with generics. 
 * Class also has insertion sort, merge sort, quick sort, and radix sort methods. 
 * @author Mikael Hinton
 *
 * @param <E>
 */
@SuppressWarnings("rawtypes")
public class QueueArrayBased<E> implements Queue, Comparable<E> {

	/***************************Variables*************************************/

		// Queue is a generic array
		private E[] items;
		// Number of items in queue
		private int currentSize;
		// Index of first item in queue
		private int front;
		// Index of last item in queue
		private int back;
		// Max size of queue array
		private static int MAX_SIZE = 100;
		
	/*************************************************************************/
		
	/**
	 * Constructor
	 */
	@SuppressWarnings("unchecked")
	public QueueArrayBased()
	{
		items = (E[]) new Object[MAX_SIZE];
		currentSize = 0;
		front = 0;
		back = 0;
	}// End of constructor
	
	/**
	 * Constructor to make the array a certain size
	 */
	@SuppressWarnings("unchecked")
	public QueueArrayBased(int SIZE)
	{
		MAX_SIZE = SIZE;
		items = (E[]) new Object[MAX_SIZE];
		currentSize = 0;
		front = 0;
		back = 0; 
	}// End of constructor
	
	
	/*************************************************************************/
	
	/**
	 * Add method to add item to the queue
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean add(Object arg0) {
		if(currentSize == MAX_SIZE)
		{
			return false;
		}
		else
		{
			items[back] = (E) arg0;
			back = (back + 1) % items.length;
			++currentSize;
			return true;
		}
	}// End of add
	
	/*************************************************************************/

	/**
	 * Inserts the specified element into this queue if it is possible to do so
	 *  immediately without violating capacity restrictions.
	 * @param e
	 * @return True - item is added to queue, False - Capacity is reached
 	 */
	@Override
	public boolean offer(Object e) {
		
		return add(e);
	}// End of offer

	/*************************************************************************/
	
	/**
	 * Retrieves and removes the head of this queue.
	 * @return Head of queue
	 * @throws NoSuchElementException - if this queue is empty
	 */
	@Override
	public E remove() throws NoSuchElementException {
		if(isEmpty())
		{
			throw new NoSuchElementException();
		}
		else
		{
			E removed = items[front];
			front = (front + 1) % MAX_SIZE;
			--currentSize;
			return removed;
		}
	}// End of remove
	
	/*************************************************************************/

	/**
	 * Retrieves and removes the head of this queue, or returns null if this queue
	 *  is empty.
	 * @return Retrieves and removes head of queue, or null is queue is empty
	 */
	@Override
	public E poll() {
		
		return remove();
	}// End of poll
	
	/*************************************************************************/

	/**
	 * Retrieves, but does not remove, the head of this queue.
	 * @return Retrieves head of queue
	 * @throws NoSuchElementException - if this queue is empty
	 */
	@Override
	public E element() throws NoSuchElementException {
		
		if(isEmpty())
		{
			throw new NoSuchElementException();
		}
		else
		{
			return items[front];
		}
	}// End of element
	
	/*************************************************************************/

	/**
	 * Retrieves, but does not remove, the head of this queue, or returns null if 
	 * this queue is empty.
	 * @return Retrieves head of queue or null is queue is empty
	 */
	@Override
	public E peek() {
		
		return element();
	}// End of peek
	
	/*************************************************************************/

	/**
	 * Method that checks to see if the queue is empty or not
	 */
	@Override
	public boolean isEmpty() {

		return currentSize == 0;
	}// End of isEmpty
	
	/*************************************************************************/

	/**
	 * Returns the size of the queue
	 */
	@Override
	public int size() {
		
		return currentSize;
	}// End of size
	
	/*************************************************************************/

	/**
	 * Clears the queue and makes it completely empty
	 */
	@Override
	public void clear() {
		for(int i = 0; i <= currentSize; i++)
		{
			items[i] = null;
		}
		front = 0;
		back = 0;
		currentSize = 0;
	}// End of clear
	
	/*************************************************************************/

	/**
	 * Checks to see if and item is in the queue or not
	 */
	@Override
	public boolean contains(Object arg0) {

		for(int i = 0; i < currentSize; i++)
		{
			if(items[i].equals(arg0))
			{
				return true;
			}
		}
	return false;
	}// End of contains
	
	/*************************************************************************/

	/**
	 * Method that iterates through the queue
	 */
	@Override
	public Iterator<E> iterator() {
		
		return new QueueIterator();
	}// End of iterator
	
	
	/*************************************************************************/

	/**
	 * Class that implements iterator so that the Queue Iterator
	 * can be used
	 * @author Mikael Hinton
	 *
	 */
	private class QueueIterator implements Iterator<E> {

		// Position of the iterator
		private int pos = 0;
		
		/**
		 * Checks to see if another item is after the current item
		 */
		@Override
		public boolean hasNext() {
			if(pos < items.length)
			{
				return true;
			}
			else
			{
				return false;
			}
		}

		/**
		 * If an item is after the current item it will then go to next
		 */
		@Override
		public E next() {
			if(this.hasNext())
			{
				return items[pos++];
			}
			else
			{
				return null;
			}
		}	
	}//EOC
	
	/*************************************************************************/
	
	/**
	 * InsertionSort for Generic array based queue
	 */
	@SuppressWarnings("unchecked")
	public void insertionSort() {

        E temp;

        for(int i = 1; i < items.length; i++) {
            for(int j = i; (j > 0) && (((Comparable<E>) items[j]).compareTo(items[j-1]) < 0); j--) 
            {
                temp = items[j];
                items[j] = items[j-1];
                items[j-1] = temp;
            }
        }
	}// End of insertionSort
	
	/*************************************************************************/

	/**
	 * QuickSort method that makes sure items are in the array
	 * and then executes the quickSort
	 */
	public void quickSort() 
	{ 
        if (items == null || items.length == 0) 
        {
            return;
        }
        int length = items.length;
        quickSortHelper(0, length - 1);
    }// End of quickSort
 
	/**
	 * Will iterate through and identify a number from the
	 * left side that is greater than the pivot, and it will
	 * also identify a number on the right side that is 
	 * less than the pivot and then at the end it exchanges
	 * those items
	 * @param lowerIndex
	 * @param higherIndex
	 */
    @SuppressWarnings("unchecked")
	private void quickSortHelper(int lowerIndex, int higherIndex) 
    {     
        int i = lowerIndex;
        int j = higherIndex;
        
        E pivot = items[lowerIndex+(higherIndex-lowerIndex)/2];
     
        while (i <= j) 
        {    
            while (((Comparable<E>) items[i]).compareTo(pivot) == -1) 
            {
                i++;
            }
            while (((Comparable<E>) items[j]).compareTo(pivot) == 1) 
            {
                j--;
            }
            if (i <= j) 
            {
                exchange(i, j);
                i++;
                j--;
            }
        }
        if (lowerIndex < j)
        {
            quickSortHelper(lowerIndex, j);
        }
        if (i < higherIndex)
        {
        	quickSortHelper(i, higherIndex);
        }
    }// End of quickSort
    
    /**
     * Private method that exchanges the items in the array
     * @param i
     * @param j
     */
    private void exchange(int i, int j) 
    {
        E temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }// End of exchange
	 
	/*************************************************************************/
    
    /**
     * Merge Sort that does it from bottom - top approach. Sorts from highest to lowest
     */
    public void mergeSort() 
    {
        sort(0, items.length-1);
    }// End of mergeSort
    
    /**
     * SortHelper to help sort the items
     * @param first
     * @param last
     */
    private void sort(int first, int last) 
    {
    	if (last <= first) 
        {
    		return;
       	}
        int middle = first + (last - first) / 2;
        sort(first, middle);
        sort(middle + 1, last);
        mergeHelper(first, middle, last);
    }// End of sort
    
    /**
     * MergeSort Helper that compares the first,middle, and last
     * and then puts the items in the correct order
     * @param first
     * @param middle
     * @param last
     */
    @SuppressWarnings("unchecked")
	private void mergeHelper( int first, int middle, int last) {
    	
    	E[] aux = (E[]) new Object[items.length];

        for (int i = first; i <= last; i++) 
        {
            aux[i] = items[i];
        }

        int	j = middle + 1;
        
        for (int k = first; k <= last; k++) {
            if(first > middle) 
            {
            	items[k]=aux[j++];
            }
            else if(j > last) 
            {
            	items[k]=aux[first++];
            }
            else if(((Comparable<E>) aux[j]).compareTo(aux[first]) == 1) 
            {
            	items[k]=aux[j++];
           	}
            else
            {
            	items[k]=aux[first++];
            }
        }       
    }// End of mergeHelper
   
	/*************************************************************************/

    /**
     * Radix Sort that sorts the array based queue and puts it into the correct order
     */
    @SuppressWarnings("unchecked")
	public void radixSort()
    {
        int i;
        E m = items[0];
        int exp = 1; 
        int n = items.length;
        
        Integer[] b = new Integer[items.length];
        
        for (i = 1; i < n; i++)
        {
            if (((Comparable<E>) items[i]).compareTo(m) > 1)
            {
                m = items[i];
            }
        }
        while((int)m / exp > 0)
        {
            int[] bucket = new int[items.length];
 
            for (i = 0; i < n; i++)
            {
                bucket[((int)items[i] / exp) % 10]++;
            }
            for (i = 1; i < 10; i++)
            {
            	bucket[i] += bucket[i - 1];
            }
        	for (i = n - 1; i >= 0; i--)
        	{
        		b[--bucket[((int)items[i] / exp) % 10]] = (int)items[i];
        	}
    		for (i = 0; i < n; i++)
    		{
    			items[i] = (E)b[i];
    		}
			exp *= 10;        
        }
    }// End of radixSort

	/*************************************************************************/
	
	/**
	 * Rest of methods are implementing by Collections
	 * but are not needed.
	 */
	
	@Override
	public boolean addAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}// End of allAll

	/*************************************************************************/

	@Override
	public boolean containsAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}// End of containsAll	

	/*************************************************************************/
	
// Research
	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}// End of remove

	/*************************************************************************/

// Research
	@Override
	public boolean removeAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}// End of removeAll

	/*************************************************************************/

	@Override
	public boolean retainAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}// End of retainAll

	/*************************************************************************/

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}// End of toArray

	/*************************************************************************/

	@Override
	public Object[] toArray(Object[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}// End of toArra

	@Override
	public int compareTo(E arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}//EOF

