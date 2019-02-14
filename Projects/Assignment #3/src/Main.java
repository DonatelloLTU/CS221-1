/**
 * Main class for user input to find the kth smallest element in an array
 */
import java.util.Random;
import java.util.Scanner;

public class Main extends kSmall{

	private static Scanner sc;

	public static void main(String[] args) {
		
		System.out.println("\t Welcome to the Kth smallest element finder!");
		System.out.println("\t_____________________________________________\n");

		int ans;
		do
		{
			sc = new Scanner(System.in);
			System.out.println("How big of an array would you like? ");
			int SIZE = sc.nextInt();
			
			System.out.println("Randomly generated array:");
			
			int[] arr;
			arr = new int[SIZE];
			Random rand = new Random();
			
			for(int i = 0; i < SIZE; i++)
			{
				arr[i] = rand.nextInt(100);
				System.out.println("#" + (i + 1) + " " + arr[i]);
			}
			
			
			sc = new Scanner(System.in);
			System.out.println("\nWhat smallest element would you like to find?" + "(1 - " + arr.length  + ")");
			int k = sc.nextInt();
			
			if(k <= arr.length && k > 0)
			{
				System.out.println("\nThe " + k + "th smallest Element: " + kthSmall(arr,k));
			}
			else
			{
				System.out.println("Invalid number has been entered");
			}
			
			sc = new Scanner(System.in);
			System.out.println("\nWould you like to find another?(Yes - 1, No - 2)");
			ans = sc.nextInt();
		}while(ans == 1);
		
		System.out.println("\nCome back soon!");
	}//EOM
}//EOF
