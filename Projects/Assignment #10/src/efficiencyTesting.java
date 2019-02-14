import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;

/**
 * Testing the efficiency of the different sorting methods
 * 	InsertionSort
 * 	QuickSort
 * 	MergeSort
 * 	RadixSort
 * 
 * @author Mikael Hinton
 */
public class efficiencyTesting {

	/**
	 * Main method that calls the methods that call the different sorting methods
	 * 	and then calculate the time taken for each sort
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException
	{	
		System.out.println("EVERYTHING PRINTED TO output.txt in project folder!");
		System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		System.out.println("Author: Mikael Hinton");
		items20000();
		items40000();
		items60000();
		items80000();
		items100000();
	}//EOM
	
	/**
	 * Testing all the sorting methods with 20,000 items in the queue
	 */
	public static void items20000()
	{
		System.out.println();
		System.out.println("******************************************************");
		System.out.println("                      20,000 Items                       ");
		System.out.println("******************************************************");

		Random rn = new Random();
		
		int size = 20000;
		
		@SuppressWarnings("rawtypes")
		QueueArrayBased queue = new QueueArrayBased(size);
		
		for(int i = 0; i < size; i++)
		{
			Integer rNum = rn.nextInt(99000) + 1;
			queue.add(rNum);
		}
	
		insertionSortHelper(queue);
		System.out.println();
		quickSortHelper(queue);
		System.out.println();
		mergeSortHelper(queue);
		System.out.println();
		radixSortHelper(queue);
	}// End of items20000
	
	/**
	 * Testing all sorting methods with 40,000 items the queue
	 */
	public static void items40000()
	{
		System.out.println();
		System.out.println("******************************************************");
		System.out.println("                      40,000 Items                       ");
		System.out.println("******************************************************");

		Random rn = new Random();
		
		int size = 40000;
		
		@SuppressWarnings("rawtypes")
		QueueArrayBased queue = new QueueArrayBased(size);
	
		for(int i = 0; i < size; i++)
		{
			Integer rNum = rn.nextInt(99000) + 1;
			queue.add(rNum);
		}
	
		insertionSortHelper(queue);
		System.out.println();
		quickSortHelper(queue);
		System.out.println();
		mergeSortHelper(queue);
		System.out.println();
		radixSortHelper(queue);
	}// End of items40000
	
	/**
	 * Testing all sorting methods with 60,000 items in the queue
	 */
	public static void items60000()
	{
		System.out.println();
		System.out.println("******************************************************");
		System.out.println("                      60,000 Items                       ");
		System.out.println("******************************************************");

		Random rn = new Random();
		
		int size = 60000;
		
		@SuppressWarnings("rawtypes")
		QueueArrayBased queue = new QueueArrayBased(size);
		
		for(int i = 0; i < size; i++)
		{
			Integer rNum = rn.nextInt(99000) + 1;
			queue.add(rNum);
		}
	
		insertionSortHelper(queue);
		System.out.println();
		quickSortHelper(queue);
		System.out.println();
		mergeSortHelper(queue);
		System.out.println();
		radixSortHelper(queue);
	}// End of items60000
	
	/**
	 * Testing all sorting methods with 80,000 items in the queue
	 */
	public static void items80000()
	{
		System.out.println();
		System.out.println("******************************************************");
		System.out.println("                      80,000 Items                       ");
		System.out.println("******************************************************");

		Random rn = new Random();
		
		int size = 80000;
		
		@SuppressWarnings("rawtypes")
		QueueArrayBased queue = new QueueArrayBased(size);
		
		
		for(int i = 0; i < size; i++)
		{
			Integer rNum = rn.nextInt(99000) + 1;
			queue.add(rNum);
		}
	
		insertionSortHelper(queue);
		System.out.println();
		quickSortHelper(queue);
		System.out.println();
		mergeSortHelper(queue);
		System.out.println();
		radixSortHelper(queue);
	}// End of items80000
	
	/**
	 * Testing all sorting methods with 100,000 items in the queue
	 */
	public static void items100000()
	{
		System.out.println();
		System.out.println("******************************************************");
		System.out.println("                      100,000 Items                       ");
		System.out.println("******************************************************");

		Random rn = new Random();
		
		int size = 100000;
		
		@SuppressWarnings("rawtypes")
		QueueArrayBased queue = new QueueArrayBased(size);
		
		
		for(int i = 0; i < size; i++)
		{
			Integer rNum = rn.nextInt(99000) + 1;
			queue.add(rNum);
		}
	
		insertionSortHelper(queue);
		System.out.println();
		quickSortHelper(queue);
		System.out.println();
		mergeSortHelper(queue);
		System.out.println();
		radixSortHelper(queue);
	}// End of items100000
	
	
	/**
	 * Helper method that calls the quickSort and also calculates the time
	 * in nano seconds
	 * @param newQueue
	 */
	@SuppressWarnings("rawtypes")
	public static void quickSortHelper(QueueArrayBased newQueue)
	{
		long elapsedTime  = 0;
		long startTime= System.nanoTime();
		newQueue.quickSort();
		long stopTime = System.nanoTime();
		elapsedTime = stopTime - startTime;
		
		System.out.println("QuickSort");
		System.out.println("Nano Seconds: ");
		System.out.println(elapsedTime);
	}// End of quickSortHelper
	
	/**
	 * Helper method that calls the insertionSort and also calculates the time
	 * in nano seconds
	 * @param newQueue
	 */
	@SuppressWarnings("rawtypes")
	public static void insertionSortHelper(QueueArrayBased newQueue)
	{
		long elapsedTime  = 0;
		long startTime= System.nanoTime();
		newQueue.insertionSort();
		long stopTime = System.nanoTime();
		elapsedTime = stopTime - startTime;
		
		System.out.println("InsertionSort");
		System.out.println("Nano Seconds: ");
		System.out.println(elapsedTime);
	}// End of insertionSortHelper
	
	/**
	 * Helper method that calls the mergeSort and also calculates the time
	 * in nano seconds
	 * @param newQueue
	 */
	@SuppressWarnings("rawtypes")
	public static void mergeSortHelper(QueueArrayBased newQueue)
	{
		long elapsedTime  = 0;
		long startTime= System.nanoTime();
		newQueue.mergeSort();
		long stopTime = System.nanoTime();
		elapsedTime = stopTime - startTime;
		
		System.out.println("MergeSort");
		System.out.println("Nano Seconds: ");
		System.out.println(elapsedTime);
	}// End of mergeSortHelper
	
	/**
	 * Helper method that calls the radixSort and also calculates the time
	 * in nano seconds
	 * @param newQueue
	 */
	@SuppressWarnings("rawtypes")
	public static void radixSortHelper(QueueArrayBased newQueue)
	{
		long elapsedTime  = 0;
		long startTime= System.nanoTime();
		newQueue.radixSort();
		long stopTime = System.nanoTime();
		elapsedTime = stopTime - startTime;
		
		System.out.println("RadixSort");
		System.out.println("Nano Seconds: ");
		System.out.println(elapsedTime);
	}// End of radixSortHelper
}// EOC
