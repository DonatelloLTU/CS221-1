/**
 * Testing BigInt for full coverage
 * @author Mikael Hinton
 *
 */
public class TestMain {

/**
 * DEFAULT CONSTRUCTOR TESTS
 */
	public static void defaultConstructor()
	{
		System.out.println("\tTesting Default Constructor");
		System.out.println("\t---------------------------\n");
		System.out.println("*Testing Method*");
		System.out.println("Inputted:       0");
		System.out.println("Expected Output:0");
		BigInt testD = new BigInt();
		System.out.println("Actual Output:  " + testD + "\n");
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
/**
 * CONSTRUCTOR TESTS
 */
	public static void constructor()
	{
//		Testing BigInt Constructor
		System.out.println("\tTesting BigInt Constructor");
		System.out.println("\t--------------------------\n");

//		Testing Method
		System.out.println("*Testing method*");
		System.out.println("Inputted:        753469783456543456776543246463453464");
		System.out.println("Expected Output: 753469783456543456776543246463453464");
		BigInt test = new BigInt("753469783456543456776543246463453464");
		System.out.println("Actual Output:   " + test);	
		
//		Testing to make sure it is a integer
		System.out.println("\n*Testing NumberFormatException*");
		System.out.println("Inputted:        etetert");
		System.out.println("Expected Output: Invalid entery!");
		System.out.print("Actual Output:   ");	
		BigInt test1 = new BigInt("etetert");
		System.out.println(); 
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

/**
 * TOSTRING METHOD TESTS
 */
	public static void toStringM()
	{
		System.out.println("\n\tTesting toString Method");
		System.out.println("\t-----------------------\n");

//		To see method actually work
		System.out.println("*Testing method*");
		System.out.println("Inputted:        753469783456543456776543246463453");
		System.out.println("Expected Output: 753469783456543456776543246463453");
		BigInt test = new BigInt("753469783456543456776543246463453");
		System.out.println("Actual output:   " + test.toString());
//		Leading Zeros
		System.out.println("\n*Testing for leading zeros*");
		System.out.println("Inputted:        000007534697834565 ");
		System.out.println("Expected Output: 7534697834565");
		BigInt test1 = new BigInt("000007534697834565");
		System.out.println("Actual output:   " + test1.toString());
//		Testing 0
		System.out.println("\n*Testing for zero*");
		System.out.println("Inputted:        0");
		System.out.println("Expected Output: 0");
		BigInt test2 = new BigInt("0");
		System.out.println("Actual output:   " + test2.toString());
//		Testing 000000
		System.out.println("\n*Testing for multiple zero's*");
		System.out.println("Inputted:        000000");
		System.out.println("Expected Output: 0");
		BigInt test3 = new BigInt("000000");
		System.out.println("Actual output:   " + test3.toString());	
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
/**
 * MAX METHOD TESTS
 */
	public static void maxMethod()
	{
		System.out.println("\n\tTesting Max Method");
		System.out.println("\t------------------\n");

		
//		Testing with leading zeros
		System.out.println("*Testing with leading zeros*");
		BigInt test = new BigInt("0003312435235");
		BigInt test1 = new BigInt("0003321353111");
		System.out.println("Inputted:        0003312435235");
		System.out.println("Inputted:        0003321353111");
		System.out.println("Expected Output: 3321353111");
		System.out.println("Actual Output:   " + test.max(test1));
		
//		Testing with different size numbers
		System.out.println("\n*Testing with different size numbers*");
		BigInt test2 = new BigInt("3312435");
		BigInt test3 = new BigInt("4566666111");
		System.out.println("Inputted:        3312435");
		System.out.println("Inputted:        4566666111");
		System.out.println("Expected Output: 4566666111");
		System.out.println("Actual Output:   " + test2.max(test3));
		
//		Testing when both are equal
		System.out.println("\n*Testing with same numbers*");
		BigInt test4 = new BigInt("3312234");
		BigInt test5 = new BigInt("3312234");
		System.out.println("Inputted:        3312234");
		System.out.println("Inputted:        3312234"); 
		System.out.println("Expected Output: 3312234");
		System.out.println("Actual Output:   " + test4.max(test5));
	
//		Testing when same size but not same number
		System.out.println("\n*Testing with same size but not same number*");
		BigInt test6 = new BigInt("3312234");
		BigInt test7 = new BigInt("1234556");
		System.out.println("Inputted:        1234556");
		System.out.println("Inputted:        3312234");
		System.out.println("Expected Output: 3312234");
		System.out.println("Actual Output:   " + test6.max(test7));
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
/**
 * MIN METHOD TESTS
 */
	public static void minMethod()
	{
		System.out.println("\n\tTesting Min Method");
		System.out.println("\t------------------\n");

//		Testing with leading zeros
		System.out.println("*Testing with leading zeros*");
		BigInt test = new BigInt("0003312435235");
		BigInt test1 = new BigInt("0003321353111");
		System.out.println("Inputted:        0003312435235");
		System.out.println("Inputted:        0003321353111");
		System.out.println("Expected Output: 3312435235");
		System.out.println("Actual Output:   " + test.min(test1));
		
//		Testing with different size numbers
		System.out.println("\n*Testing with different size numbers*");
		BigInt test2 = new BigInt("3312435");
		BigInt test3 = new BigInt("4566666111");
		System.out.println("Inputted:        3312435");
		System.out.println("Inputted:        3321353111");
		System.out.println("Expected Output: 3312435");
		System.out.println("Actual Output:   " + test2.min(test3));
		
//		Testing when both are equal
		System.out.println("\n*Testing with same numbers*");
		BigInt test4 = new BigInt("3312234");
		BigInt test5 = new BigInt("3312234");
		System.out.println("Inputted:        3312234");
		System.out.println("Inputted:        3312234");
		System.out.println("Expected Output: 3312234");
		System.out.println("Actual Output:   " + test4.min(test5));
		
//		Testing when same size but not same number
		System.out.println("\n*Testing with same size but not same number*");
		BigInt test6 = new BigInt("1234556");
		BigInt test7 = new BigInt("3312234");
		System.out.println("Inputted:        1234556");
		System.out.println("Inputted:        3312234");
		System.out.println("Expected Output: 1234556");
		System.out.println("Actual Output:   " + test7.min(test6));
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
/*	 
 * TESTING ADD METHOD 
 */
	public static void addMethod()
	{
//		Testing method
		System.out.println("\n\tTesting Add Method");
		System.out.println("\t------------------\n");
		System.out.println("Testing Method");
		BigInt test = new BigInt("60");
		BigInt test1 = new BigInt("791");
		System.out.println("Inputted:        60");
		System.out.println("Inputted:        791");
		System.out.println("Expected Output: 851");
		System.out.println("Actual Output:   " + test.add(test1));	
//		Testing VERY large numbers
		System.out.println("\nTestig VERY large number");
		BigInt test2 = new BigInt("5034333123");
		BigInt test3 = new BigInt("7673443278");
		System.out.println("Inputted:        5034333123");
		System.out.println("Inputted:        7673443278");
		System.out.println("Expected Output: 12707776401");
		System.out.println("Actual Output:   " + test2.add(test3));
//		Testing large number
		System.out.println("\nTesting Large Number");
		BigInt test4 = new BigInt("5034332334");
		BigInt test5 = new BigInt("767333234");
		System.out.println("Inputted:        50343323");
		System.out.println("Inputted:        7673333");
		System.out.println("Expected Output: 5801665568");
		System.out.println("Actual Output:   " + test4.add(test5));
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
/*
 * TESTING MULTIPLY METHOD
 */
	public static void multiplyMethod()
	{
		System.out.println("\n\tTesting Multiply Method");
		System.out.println("\t------------------\n");
		System.out.println("Testing Method");
		BigInt test =  new BigInt("63");
		BigInt test1 = new BigInt("43");
		System.out.println("Inputted:        6");
		System.out.println("Inputted:        3");
		System.out.println("Expected Output: 18");
		System.out.println("Actual Output:   " + test.multiply(test1));
	}
		
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	public static void main(String[] args) {

//		Ouputting "Testing BigInt Class"
		System.out.println("\t\tTesting BigInt Class");
		System.out.println("-----------------------------------------------------------\n");
		defaultConstructor();
		constructor();
		toStringM();
		maxMethod();
		minMethod();	
		addMethod();
		multiplyMethod();
	}//EOM
}//EOF
