/**
 * Testing to all methods in Palindrome.java class
 * @author Mikael Hinton
 *
 */
public class PalindromeTesting {

	/**
	 * Main method for test class
	 * @param args
	 */
	public static void main(String[] args) 
	{
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("|        Testing Palindrome.java class             |");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		testingPalindrome();
		
	}
	
	/**
	 * TESTING PALINDROME CLASS
	 */
	public static void testingPalindrome()
	{
		System.out.println("\t++++++++++++++++++++++++++++++++++++");
		System.out.println("\t|         Testing Palindrome       |");
		System.out.println("\t++++++++++++++++++++++++++++++++++++");
		
		System.out.println("String is a Palindrome:");
		String str = new String();
		str = "abcba";
		System.out.println("Input: " + str);
		System.out.println("Expected: true");
		System.out.print("Actual:   ");
		Palindrome pal = new Palindrome(str);
		System.out.println(pal.isPalindrome());
		
		System.out.println("\nString is NOT a Palindrome:");
		String str1 = new String();
		str1 = "abcbaa";
		System.out.println("Input: " + str1);
		System.out.println("Expected: false");
		System.out.print("Actual:   ");
		Palindrome pal1 = new Palindrome(str1);
		System.out.println(pal1.isPalindrome());
		
		System.out.println("\nUPPERCASE String is a Palindrome(converts to lowercase):");
		String str2 = new String();
		str2 = "ABCBA";
		System.out.println("Input: " + str2);
		System.out.println("Expected: true");
		System.out.print("Actual:   ");
		Palindrome pal2 = new Palindrome(str2);
		System.out.println(pal2.isPalindrome());
		
		System.out.println("\nUPPERCASE & LOWERCASE String is a Palindrome(converts to lowercase):");
		String str10 = new String();
		str10 = "AbCbA";
		System.out.println("Input: " + str10);
		System.out.println("Expected: true");
		System.out.print("Actual:   ");
		Palindrome pal10 = new Palindrome(str10);
		System.out.println(pal10.isPalindrome());
		
		
		System.out.println("\nSPECIALCHARACTER String is NOT a Palindrome:");
		String str3 = new String();
		str3 = "$a#dd$$ddd";
		System.out.println("Input: " + str3);
		System.out.println("Expected: false");
		System.out.print("Actual:   ");
		Palindrome pal3 = new Palindrome(str3);
		System.out.println(pal3.isPalindrome());
		
		System.out.println("\nUPPERCASE & SPECIALCHARACTER String is NOT a Palindrome:");
		String str4 = new String();
		str4 = "#A$B$C$B#B$A";
		System.out.println("Input: " + str4);
		System.out.println("Expected: false");
		System.out.print("Actual:   ");
		Palindrome pal4 = new Palindrome(str4);
		System.out.println(pal4.isPalindrome());
		
		System.out.println("\nSPECIALCHARACTER String is a Palindrome:");
		String str5 = new String();
		str5 = "a$b@c%b)a";
		System.out.println("Input: " + str5);
		System.out.println("Expected: true");
		System.out.print("Actual:   ");
		Palindrome pal5 = new Palindrome(str5);
		System.out.println(pal5.isPalindrome());
	}
	

}