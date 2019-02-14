/**
 * Test class to test all of the public methods in PrefixExpressions.java
 * @author Mikael Hinton
 */
public class TestingPrefixExpressions{

	/*
	 * Main method
	 */
	public static void main(String[] args) {

		System.out.println("\t++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("\t|          Testing PrefixExpression.java           |");
		System.out.println("\t++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		System.out.println();
		
		testingIsPrefix();
		System.out.println();
		testingEvaluatePrefix();
	}//EOM

	/*
	 * testingIsPrefix method in PrefixExpressions.java
	 */
	public static void testingIsPrefix()
	{
		System.out.println("\t++++++++++++++++++++++++++++++++++++++++");
		System.out.println("\t|           Testing isPre()            |");
		System.out.println("\t++++++++++++++++++++++++++++++++++++++++");
		
		System.out.println("\n\t****************Adding***************\n");

		String exp1 = "+ab";
		PrefixExpressions exp11 = new PrefixExpressions(exp1);
		System.out.println("Expected: +ab = true");
		System.out.println("Actual:   +ab = " + exp11.isPrefix());
		
		System.out.println();
		
		String exp2 = "ab+";
		PrefixExpressions exp111 = new PrefixExpressions(exp2);
		System.out.println("Expected: ab+ = false");
		System.out.println("Actual:   ab+ = " + exp111.isPrefix());
		
		System.out.println("\n\t****************Subtracting***************\n");

		String exp3 = "-ab";
		PrefixExpressions exp1111 = new PrefixExpressions(exp3);
		System.out.println("Expected: -ab = true");
		System.out.println("Actual:   -ab = " + exp1111.isPrefix());

		System.out.println();
		
		String exp4 = "ab-";
		PrefixExpressions exp11111 = new PrefixExpressions(exp4);
		System.out.println("Expected: ab- = false");
		System.out.println("Actual:   ab- = " + exp11111.isPrefix());
		
		System.out.println("\n\t****************Multplying***************\n");
		
		String exp5 = "ab*";
		PrefixExpressions exp111111 = new PrefixExpressions(exp5);
		System.out.println("Expected: ab* = false");
		System.out.println("Actual:   ab* = " + exp111111.isPrefix());
		
		System.out.println();
		
		String exp6 = "*ab";
		PrefixExpressions exp1111111 = new PrefixExpressions(exp6);
		System.out.println("Expected: *ab = true");
		System.out.println("Actual:   *ab = " + exp1111111.isPrefix());
		
		System.out.println("\n\t***************DIVIDING***************\n");
		
		String exp7 = "/ab";
		PrefixExpressions exp11111111 = new PrefixExpressions(exp7);
		System.out.println("Expected: /ab = true");
		System.out.println("Actual:   /ab = " + exp11111111.isPrefix());
		
		System.out.println();

		String exp8 = "ab/";
		PrefixExpressions exp111111111 = new PrefixExpressions(exp8);
		System.out.println("Expected: ab/ = false");
		System.out.println("Actual:   ab/ = " + exp111111111.isPrefix());
		
		System.out.println("\n\t****************OTHER***************\n");

		String exp9 = "$ab";
		PrefixExpressions exp1111111111 = new PrefixExpressions(exp9);
		System.out.println("Expected: $ab = false");
		System.out.println("Actual:   $ab = " + exp1111111111.isPrefix());
		
		
		
	}//End of testingIsPrefix()
	
	/*
	 * testingEvaluatePrefix method in PrefixExpressions.java
	 */
	public static void testingEvaluatePrefix()
	{
		System.out.println("\t++++++++++++++++++++++++++++++++++++++++");
		System.out.println("\t|        Testing EvaluatePrefix        |");
		System.out.println("\t++++++++++++++++++++++++++++++++++++++++");
		
		System.out.println("\n\t****************Adding***************");
		
		String add = "+ab";
		PrefixExpressions adding = new PrefixExpressions(add);
		System.out.println("\nAdding two numbers together:\n\tExpected:\n\t10 + 11 = 21.0");
		System.out.println("\tActual:\n" + "\t10 + 11 = " + adding.evaluatePrefix());
		
		String add1 = "+mn";
		PrefixExpressions adding1 = new PrefixExpressions(add1);
		System.out.println("\nAdding two numbers together:\n\tExpected:\n\t22 + 23 = 45.0");
		System.out.println("\tActual:\n" + "\t22 + 23 = " + adding1.evaluatePrefix());
		
		String add2 = "+yz";
		PrefixExpressions adding2 = new PrefixExpressions(add2);
		System.out.println("\nAdding two numbers together:\n\tExpected:\n\t34 + 35 = 69.0");
		System.out.println("\tActual:\n" + "\t34 + 35 = " + adding2.evaluatePrefix());
	
		System.out.println("\n\t****************Subtracting***************");
		
		String sub = "-ab";
		PrefixExpressions subtracting = new PrefixExpressions(sub);
		System.out.println("\nSubtracting two numbers together:\n\tExpected:\n\t10 - 11 = -1.0");
		System.out.println("\tActual:\n" + "\t10 - 11 = " + subtracting.evaluatePrefix());
		
		String sub1 = "-cn";
		PrefixExpressions subtracting1 = new PrefixExpressions(sub1);
		System.out.println("\nSubtracting two numbers together:\n\tExpected:\n\t12 - 23 = -11.0");
		System.out.println("\tActual:\n" + "\t12 - 23 = " + subtracting1.evaluatePrefix());
		
		String sub2 = "-az";
		PrefixExpressions subtracting2 = new PrefixExpressions(sub2);
		System.out.println("\nSubtracting two numbers together:\n\tExpected:\n\t10 - 35 = -25.0");
		System.out.println("\tActual:\n" + "\t10 - 35 = " + subtracting2.evaluatePrefix());
		
		System.out.println("\n\t****************Multplying***************");
		
		String mult = "*ab";
		PrefixExpressions multiplying = new PrefixExpressions(mult);
		System.out.println("\nMultiplying two numbers together:\n\tExpected:\n\t10 * 11 = 110.0");
		System.out.println("\tActual:\n" + "\t10 * 11 = " + multiplying.evaluatePrefix());
		
		String mult1 = "*mn";
		PrefixExpressions multiplying1 = new PrefixExpressions(mult1);
		System.out.println("\nMultiplying two numbers together:\n\tExpected:\n\t22 * 23 = 506.0");
		System.out.println("\tActual:\n" + "\t22 * 23 = " + multiplying1.evaluatePrefix());
		
		String mult2 = "*yz";
		PrefixExpressions multiplying2 = new PrefixExpressions(mult2);
		System.out.println("\nMultiplying two numbers together:\n\tExpected:\n\t34 * 35 = 1190.0");
		System.out.println("\tActual:\n" + "\t34 * 35 = " + multiplying2.evaluatePrefix());
		
		System.out.println("\n\t***************DIVIDING***************");

		String div = "/ab";
		PrefixExpressions dividing = new PrefixExpressions(div);
		System.out.println("\nDividing two numbers together:\n\tExpected:\n\t10 / 11 = 0.9090909090909091");
		System.out.println("\tActual:\n" + "\t10 / 11 = " + dividing.evaluatePrefix());
		
		String div1 = "/mb";
		PrefixExpressions dividing1 = new PrefixExpressions(div1);
		System.out.println("\nDividing two numbers together:\n\tExpected:\n\t22 / 11 = 2.0");
		System.out.println("\tActual:\n" + "\t22 / 11 = " + dividing1.evaluatePrefix());
		
		String div2 = "/yc";
		PrefixExpressions dividing2 = new PrefixExpressions(div2);
		System.out.println("\nDividing two numbers together:\n\tExpected:\n\t35 / 12 = 2.8333333333333335");
		System.out.println("\tActual:\n" + "\t35 / 12 = " + dividing2.evaluatePrefix());
		
		System.out.println("\n\t****************OTHER***************");
		
		String rand = "@ab";
		PrefixExpressions random = new PrefixExpressions(rand);
		System.out.println("\nInputting '@ab' which is an invalid expression:\n\tExpected:\n\t-1.0");
		System.out.println("\tActual:\n\t"  + random.evaluatePrefix());	
		
	}//End of testingEvaluatePrefix()
	
	
}//EOF
