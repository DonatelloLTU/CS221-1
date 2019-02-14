/**
 * Class that converts and evaluates the Infix expression to a Postfix Expression
 * @author Mikael Hinton
 *
 */
public class Calculator {

	/***********************************Variables***********************************/

	/*
	 * Expression that is passed in by the user
	 */
	public String InFixStrExp;
	
	/*
	 * Expression that is evaluated by evaluate after convertPostFix is done
	 */
	public String PostFixStrExp;
	
	/***********************************Public Methods***********************************/
	
	/**
	 * Overloaded constructor to pass in the InFix String
	 * @param newInFixStrExp
	 */
	Calculator(String newInFixStrExp)
	{
		InFixStrExp = newInFixStrExp;
	}// End of Calculator
	
	
	/**
	 * Evaluates the converted postfix expression and either adds, multiplying, dividing, mod, and subtracts
	 * @return Evaluated Integer from postFix expression
	 * @throws IllegalStateException
	 */
	public int evaluate() throws IllegalStateException
	{
		/*
		 * Gets the PostFix Expression of the infix expression
		 */
		getPostFix();
		
		/*
		 * Creates now stack
		 */
		StackReferencedBased stack = new StackReferencedBased();

		/*
		 * Parses through String
		 */
		for(int i = 0; i < PostFixStrExp.length(); i++)
		{

			/**
			 * Gives ch the character at each index in the string
			 */
			char ch = PostFixStrExp.charAt(i);
			
			/*
			 * If the character is a digit,
			 * 	pushes the character into the stack
			 * 	and converts it to a digit 
			 */
			if(Character.isDigit(ch))
			{
				stack.push(ch - '0');
			}
			/*
			 * If the character is a +, -, /, *, %
			 * 	it will cary out those functions
			 */
			else
			{
				/*
				 * Gives num1 the first number as a int in the stack
				 */
				int num1 = (Integer)stack.pop();
				/*
				 * Gives num2 the first number as a int in the stack
				 */
				int num2 = (Integer)stack.pop();
				
				/*
				 * The operator is then a the top of the stack
				 * 	and the switch carries out those operations
				 */
				switch(ch)
				{
					/*
					 * Adding
					 */
					case '+': 
						stack.push(num2+num1); 
					break; 
                  
					/*
					 * Subtracting
					 */
					case '-': 
						stack.push(num2- num1); 
					break; 
                  
					/*
					 * Dividing
					 */
					case '/': 
						stack.push(num2/num1); 
					break; 
              
					/*
					 * Multiplying
					 */
					case '*': 
						stack.push(num2*num1); 
					break;
					
					/*
					 * Modulus
					 */
					case '%':
						stack.push(num2/num1); 
					break;
				}
			}
		}
	return (Integer)stack.pop();
	}// End of evaluate
	
	/**
	 * Gets the postfix expression after is has been converted from infix to postfix
	 * @return PostFixStrExp if converted correctly
	 * @throws IllegalStateException
	 */
	public String getPostFix() throws IllegalStateException
	{
		/*
		 * When the convertPostFix returns true then it returns the PostFix
		 * 	String expression
		 */
		if(convertPostFix() == true)
		{
			return PostFixStrExp;
		}
		/*
		 * When convertPostFix returns false it will throw 
		 * 	an IllegalStateException 
		 */
		else
		{
			throw new IllegalStateException("Could not convert to PostFix");
		}
		
	}// End of getPostFix
	
	/***********************************Private Methods***********************************/
	
	/**
	 * Converts the user input infix expression to postfix expression 
	 * @return true - When String expression is converted correctly
	 * 		   false - When String expression is not converted correctly 
	 */
	private boolean convertPostFix()
	{
		/*
		 * Creates a empty string
		 */
		PostFixStrExp = new String("");
		
		/*
		 * Creates a new stack of Objects
		 */
		StackReferencedBased stack = new StackReferencedBased();
		
		/*
		 * Parse through the string
		 */
		for(int i = 0; i < InFixStrExp.length(); ++i)
		{
			char ch = InFixStrExp.charAt(i);
			
			/*
			 * Character in the stack is a letter or a digit
			 */
			if(Character.isLetterOrDigit(ch))
			{
				PostFixStrExp += ch;
			}
			/*
			 * Character in the stack is a (
			 */
			else if(ch == '(')	
			{
				stack.push(ch);
			}
			/*
			 * Character in the stack is a )
			 */
			else if(ch == ')')
			{
				/*
				 * While the stack is not a ( while peeking
				 */
				while((char)stack.peek() != '(')
				{
					/*
					 * If the stack is not empty
					 */
					if(!stack.isEmpty())
					{
						PostFixStrExp += stack.pop();
					}
				}
			stack.pop();
			}
			else
			{	
				/*
				 * While the current characters precedence is less than or
				 * equal to the next then it keeps popping
				 */
				while((char)Precedence(ch) <= Precedence((char)stack.peek()))
				{
					/*
					 * Stack is not empty
					 */
					if(!stack.isEmpty())
					{
						PostFixStrExp += stack.pop();
					}
				}
			stack.push(ch);
			}		
		}
		
		/*
		 * When the stack is not empty after it has parsed through the string
		 */
		while(!stack.isEmpty())
		{
			/*
			 * When stack peeks and sees a ( or stack is empty
			 */
			if((char)stack.peek() == '(' || stack.isEmpty())
			{
				return false;
			}
		}
	return true;
	}// End of convertPostFix
	
	/**
	 * Returns the precedence of a operator
	 * 	The higher the returned value the higher the precedence
	 * @param ch
	 * @return
	 */
	private int Precedence(char ch)
	{
		if(ch == '+' || ch == '-')
		{
			return 1;
		}
		else if(ch == '*' || ch == '/' || ch =='%')
		{
			return 2;
		}
		else
		{
			return -1;
		}
	}// End of Precedence
}// EOF
