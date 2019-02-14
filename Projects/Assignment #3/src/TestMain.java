import java.util.Random;


/**
 * Test class for kSmall to make sure everything works properly
 * @author Mikael Hinton
 *
 */
public class TestMain extends kSmall{
	
	/*
	 * Testing if user inputs something bigger than array
	 */
	public static void biggerThanArray()
	{
		System.out.println("*Testing if K is bigger than array*");
		int[] array = {3, 5, 6, 7, 8, 21, 43, 90, 100, 99};
		System.out.println("Input:     11");
		System.out.println("Exptected: 0");
		System.out.println("Output:    " + kthSmall(array, 11));
	}
	
//	***********************************************************************************************************************************
	
	/*
	 * Testing if user inputs something smaller than array 
	 */
	public static void smallerThanArray()
	{
		System.out.println("\n*Testing if K is smaller than array*");
		int[] array = {3, 5, 6, 7, 8, 21, 43, 90, 100, 99};
		System.out.println("Input:     -1");
		System.out.println("Exptected: 0");
		System.out.println("Output:    " + kthSmall(array, -1));
	}
	
//	***********************************************************************************************************************************

	/*
	 * Testing if user wants smallest element in array
	 */
	public static void smallestInArray()
	{
		System.out.println("\n*Testing smallest K element in array*");
		int[] array = {3, 5, 6, 7, 8, 21, 43, 90, 100, 99};
		System.out.println("Input:     1");
		System.out.println("Exptected: 3");
		System.out.println("Output:    " + kthSmall(array, 1));
	}
	
//	***********************************************************************************************************************************
	
	/*
	 * Testing if user wants largest element in array
	 */
	public static void biggestInArray()
	{
		System.out.println("\n*Testing largest K element in array*");
		int[] array = {3, 5, 6, 7, 8, 21, 43, 90, 100, 99};
		System.out.println("Input:     10");
		System.out.println("Exptected: 100");
		System.out.println("Output:    " + kthSmall(array, 10));
	}
	
//	***********************************************************************************************************************************
	
	/*
	 * Testing if only 1 number in array
	 */
	public static void arrayOf1()
	{
		System.out.println("\n*Testing when the only 1 element in array*");
		int[] array = {3};
		System.out.println("Array:     " + array[0]);
		System.out.println("Input:     1");
		System.out.println("Exptected: 3");
		System.out.println("Output:    " + kthSmall(array, 1));
	}
	
//	***********************************************************************************************************************************
	
	/*
	 * Fully sorted array
	 */
	public static void fullySortedArray()
	{
		long startTime;
		long stopTime; 
		long elapsedTime; 
		
		System.out.println("\n*Testing efficiency for fully sorted array*");
		System.out.println("Finding the 999th smallest element in array");

		int[] array = new int[1000];
		
		for(int i = 0; i < array.length; i++)
		{
			array[i] = i + 1;
		}
				
		startTime = System.nanoTime();
		kthSmall(array, 999);
		stopTime = System.nanoTime();
		elapsedTime = stopTime - startTime;
		System.out.println("Nanoseconds: " + elapsedTime);
		System.out.println("Called " + counter + " times");

	}
	
//	***********************************************************************************************************************************
	
	/*
	 * Nearly sorted array
	 */
	public static void nearlySortedArray()
	{
		long startTime;
		long stopTime; 
		long elapsedTime; 
		
		startTime = System.nanoTime();
		System.out.println("\n*Testing efficiency for nearly sorted array*");
		System.out.println("Finding the 999th smallest element in array");

		int[] array1 = new int[500];
		int[] array2 = new int[500];
 		int[] combined = new int[array1.length + array2.length];		
		
		for(int i = 0; i < array1.length; i++)
		{
			array1[i] = i + 51;
		}
		for(int i = 0; i < array2.length; i++)
		{
			array2[i] = i + 1;
		}
		
		int count = 0;
		for(int i = 0; i < array1.length; i++)
		{
			combined[count] = i;
			count++;
		}
		for(int i = 0; i < array2.length; i++)
		{
			combined[count] = i;
			count++;
		}
		
		startTime = System.nanoTime();
		kthSmall(combined, 9999);
		stopTime = System.nanoTime();
		elapsedTime = stopTime - startTime;
		System.out.println("Nanoseconds: " + elapsedTime);
		System.out.println("Called " + counter + " times");

	}
	
//	***********************************************************************************************************************************
	
	/*
	 * Unsorted array
	 */
	public static void unsortedArray()
	{
		long startTime;
		long stopTime; 
		long elapsedTime; 
		
		System.out.println("\n*Testing efficiency for unsorted array*");
		System.out.println("Finding the 999th smallest element in array");

		int[] array = new int[1000];
		
		Random random = new Random();
		random.nextInt();
		for(int i = 0; i < array.length; i++)
		{
			array[i] = (int)(Math.random() * 100);
		}

		startTime = System.nanoTime();
		kthSmall(array, 999);
		stopTime = System.nanoTime();
		elapsedTime = stopTime - startTime;
		System.out.println("Nanoseconds: " + elapsedTime);
		System.out.println("Called " + counter + " times");
	}
	
//	***********************************************************************************************************************************
	
	/*
	 * MAIN
	 */
	public static void main(String[] args) {
		
		System.out.println("\t TESTING KSMALL");
		System.out.println("\t________________\n");
		
		int[] array = {3, 5, 6, 7, 8, 21, 43, 90, 100, 99};
		
		System.out.print("Array: ");
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println("\nSize: " + array.length);
		System.out.println("\n");
		
		biggerThanArray();
		smallerThanArray();
		smallestInArray();
		biggestInArray();
		arrayOf1();
		
		System.out.println("\n\t TESTING EFFICIENCY");
		System.out.println("\t____________________");
		System.out.println("\n   This array is 1,000 elements long!");
		fullySortedArray();
		nearlySortedArray();
		unsortedArray();	
	}// EOM

}// EOF
