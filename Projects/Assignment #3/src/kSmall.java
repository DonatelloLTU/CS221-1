/**
 * Takes in an array of integers and returns the kth smallest element
 * @author Mikael Hinton
 *
 */

public class kSmall {

	static int counter = 0;		// Counter to find out which array is most efficient
	
	/**
	 * Takes in the parameters for an array and the kth smallest and
	 * 		returns it to sort
	 * @param arr
	 * @param k
	 * @return
	 */
	public static int kthSmall(int[] arr, int k)
	{	
		int start = 0;
		int end = arr.length -1;
		return kthSmall(arr, start, end, k);
	}
	
//	***********************************************************************************************************************************
	
	/**
	 * Quick sorts and gets the kth smallest element
	 * @param arr
	 * @param start
	 * @param end
	 * @param k
	 * @return last
	 */
	private static int kthSmall(int[] arr, int start, int end, int k)
	{
		
		try
		{
			counter++;
			/*
			 * returns the number if it is the kth smallest and the only element in the array
			 */
			if(start == end)
			{
				return arr[start];
			}
			
			int pivot = partition(arr, start, end);		// gets the pivot index from partition method
			int length = (pivot - start + 1);		// finds the length of the array
			
			/*
			 * returns the kth smallest when the length and k are the same
			 */
			if(k == length)
			{
				return arr[pivot];
			}// end if
			
			/*
			 * returns back into the sort and makes the pivot 1 less each time
			 */
			else if(k < length)
			{
				return kthSmall(arr, start, (pivot - 1), k);
			}// end else if
			
			/*
			 * returns back into the sort and makes the pivot 1 more and k 1 less
			 */
			else
			{
				return kthSmall(arr, (pivot + 1), end, (k - length));
			}// end else
		}
		catch(ArrayIndexOutOfBoundsException exc)
		{
			return 0;
		}
	}// end sort
	
//	***********************************************************************************************************************************
	
	/**
	 * Finds the pivot of the array
	 * @param arr
	 * @param first
	 * @param last
	 * @return last
	 */
	private static int partition(int[] arr, int first, int last)
	{
		int pivot = (first);					// Pivot begins at start of array
		int pivot_element = arr[pivot];			// element that is being pivoted

		/**
		 * While the first index is less the last index in the array
		 */
		while(first < last)
			
		{
			/*
			 * while the arrays first index is less than the pivot element and the first
			 * 		index is less than the last
			 */
			while( arr[first] < pivot_element && first < last)
			{
				first++;					// Moves the index to the next
			}
			
			/**
			 * while the arrays last index is greater than the pivot element and last index
			 * 		is greater than or equal to 0 
			 */
			while(arr[last] > pivot_element && last >= 0)
			{
				last--;						// Moves the index back one
			}
			
			/*
			 * if arrays first index and last index are equal
			 */
			if(arr[first] == arr[last])
			{
				first++;					// Makes the index 1 so that it will get the correct element
			}
			/*
			 * if first index is greater than the last index
			 */
			else if(first < last)
			{
				int tmp = arr[first]; 		// temp gets the first index in the arr 
				arr[first] = arr[last];		// first index gets the last index in the arr
				arr[last] = tmp;			// lst index gets the tmp
			}
		}
	return last;
	} // end pivot
}// EOF


	