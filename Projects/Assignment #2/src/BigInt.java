import java.util.*;

/**
 * Java provides a class java.lang.BigInteger that can be used to handle very
 * large integers. Implement a similar class, called BigInt, that can be used
 * to do simple calculations with very large nonnegative integers. Design this
 * class carefully.
 * 
 * @author Mikael Hinton
 *
 */
public class BigInt { 

	/**
	 * A data structure to represent large numbers for example, 
	 * a string or array for the digits in a number.
	 */
	private ArrayList<Integer> BigVal;
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Default Constructor, creates a BigInt of 0
	 */
	public BigInt() 
	{
		BigVal = new ArrayList<Integer>(25);
	}//BigInt  

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	/**
	 * A constructor that uses a string representation of the integer
	 * for initialization. The string may contain leading zeros. Do not
	 * forget that zero is a valid number.
	 * @param val
	 */
	public BigInt(String val)
	{
		try 
		{
			BigVal = new ArrayList<Integer>(25);
			String[] strArr = val.split("");
		
			for(int i = 0; i < strArr.length; i++)
			{
				BigVal.add(Integer.parseInt(strArr[i]));
			}
		}
		catch(NumberFormatException e)
		{
			System.out.print("Invalid entery!");
		}
	}//BigInt
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	/**
	 * A method that returns a BigInt whose value is the maximum of val
	 * and the instance of BigInt that invokes max.
	 * @param val
	 * @return result
	 */
	
	public BigInt max(BigInt val)
	{
		BigInt result = new BigInt();
		
		for (int i = 0; i < val.BigVal.size(); i++)
		{
			if (val.BigVal.get(i) == 0)
			{
				val.BigVal.remove(i); // Should remove leading 0's
				i--;
			}
			else
			{
				break; // After you get to the first non-zero stop
			}
		}
		
		for (int i = 0; i < this.BigVal.size(); i++)
		{
			if (this.BigVal.get(i) == 0)
			{
				this.BigVal.remove(i); // Should remove leading 0's
				i--;
			}
			else
			{
				break;// After you get to the first non-zero stop
			}
		}
		
		if(BigVal.size() > val.BigVal.size())
		{
			result.BigVal = BigVal; // returns max if both numbers are same size
		}
		else
		{
			result.BigVal = val.BigVal; // returns other number if not bigger
		}
		
		if(BigVal.size() == val.BigVal.size()) // if the size of both are the same
		{
			for(int i = 0; i <= BigVal.size(); i++)
			{
				if(BigVal.get(i) > val.BigVal.get(i)) // if 1 number index is bigger than the other
				{
					result.BigVal = BigVal;
					break;
				}
				if(BigVal.get(i) == val.BigVal.get(i)) // if both indexes are the same
				{
					i++;
					break;
				}
			}
		}	
	return result;
	}//max
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	/**
	 * A method that returns a BigInt whose value is the minimum of val and the
	 * instance of BigInt that invokes min.
	 * @param val
	 * @return result
	 */
	public BigInt min(BigInt val)
	{
		BigInt result = new BigInt();
		
		for (int i = 0; i < val.BigVal.size(); i++)
		{
			if (val.BigVal.get(i) == 0)
			{
				val.BigVal.remove(i); // Should remove leading 0's
				i--;
			}
			else
			{
				break; // After you get to the first non-zero stop
			}
		}
		
		for (int i = 0; i < this.BigVal.size(); i++)
		{
			if (this.BigVal.get(i) == 0)
			{
				this.BigVal.remove(i); // Should remove leading 0's
				i--;
			}
			else
			{
				break;// After you get to the first non-zero stop
			}
		}
		if(BigVal.size() > val.BigVal.size())
		{
			result.BigVal = val.BigVal; // returns min if both numbers are same size
		}
		else
		{
			result.BigVal = BigVal; // returns other number if not bigger
		}
		
		if(BigVal.size() == val.BigVal.size()) // if the size of both are the same
		{
			for(int i = 0; i <= BigVal.size(); i++)
			{
				if(BigVal.get(i) > val.BigVal.get(i)) // if 1 number index is bigger than the other
				{
					result.BigVal = val.BigVal;
					break;
				}
				if(BigVal.get(i) == val.BigVal.get(i)) // if both indexes are the same
				{
					i++;
					break;
				}
			}
		}	
	return result;
	}//min
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	/**
	 * Method that takes in an array and returns the array backwards
	 * @param val
	 * @return val
	 */
	private ArrayList<Integer> reverseArr(ArrayList<Integer> val)
	{
		int size = val.size();
		
		for(int i = 0; i < size / 2; i++)
		{
			final int rev = val.get(i);
			val.set(i, val.get(size - i - 1 ));
			val.set(size - i - 1, rev);
		}
		return val;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	/**
	 * A method that returns a BigInt whose value is the sum of val and the
	 * instance of BigInt that invokes add.
	 * @param val
	 * @return sum
	 */
	public BigInt add(BigInt val)
	{
		/*
		 * Reverses the array to LSD
		 */
		reverseArr(val.BigVal);
		reverseArr(BigVal);
	
		BigInt sum = new BigInt(); // makes me instance of BigInt
		
		int smallest = 0; // Smallest number 
		int largest = 0;  
		
		/*
		 * Checks to see which number is larger
		 */
		if(BigVal.size() > val.BigVal.size()) 
		{
			smallest = val.BigVal.size();
			largest = 1;
		}
		else if(BigVal.size() < val.BigVal.size())
		{
			smallest = BigVal.size();
			largest = 0;
		}
		else if(BigVal.size() == val.BigVal.size())
		{
			smallest = BigVal.size();
			largest = -1;
		}
		
		/*
		 * Checks the LSD first and looks through
		 * until it gets to the smallest number
		 */
		
		int carry = 0;
		
       	for(int i = 0; i < smallest; i++) 
       	{     
       		
    		int tmp = BigVal.get(i) + val.BigVal.get(i) + carry;
       		carry = tmp / 10;
           	sum.BigVal.add(i, tmp % 10);
       	}
       	
       	// Copies the value if the numbers are different sizes
       	BigInt copyFrom = new BigInt();
       	      
       	/*
       	 * if largest is 1 then there are more numbers
       	 * if no then the number is done
       	 */
       	if(largest == 1)
       	{
    	 
       		copyFrom.BigVal = BigVal;
       	}
       	if(largest == 0)
		{
       		copyFrom.BigVal = val.BigVal;
		}
       	       	
       	/*
       	 * increments from the smallest to the end of the
       	 * larger number and puts it at the end of the array
       	 */       	
       	int remainingNumbersSize = smallest;
       	
       	for(int i = copyFrom.BigVal.size() - 1; i >= smallest; i--)
       	{
       		int tmp = copyFrom.BigVal.get(i) + carry;
       		carry = 0;
       
       		sum.BigVal.add(remainingNumbersSize, tmp);
    
       		if( tmp > 9)
       		{
       			carry = 0;
       		}
       	  
       	}
       	
       	
       	/*
       	 * If the last number has a carry it puts it onto
       	 * the array at the end
       	 */
       	if(carry == 1)
       	{
       		sum.BigVal.add(smallest, carry);
       	
       	}
       
       	/*
       	 * Takes the sum and reverses it back to MSD to LSD
       	 */
       	reverseArr(sum.BigVal);
       	
       	return sum;
	}//add
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	/**
	 * A method that returns a BigInt whose value is the multiply of val and the
	 * instance of BigInt that invokes multiply.
	 * @param val
	 * @return product
	 */
	public BigInt multiply(BigInt val)
	{	
		BigInt product = new BigInt();
		BigInt tempSum = new BigInt();
   		BigInt sum = new BigInt();
		
		int carry = 0;
		int largest = 0;
		int smallest = 0;
		int add0 = 1;
		/*
		 * Reverses digits to LSD to MSD
		 */
		reverseArr(BigVal);
		reverseArr(val.BigVal);
		
		/*
		 * Getting which every number is bigger
		 */
		if(BigVal.size() < val.BigVal.size()) 
		{
			largest = val.BigVal.size();
			smallest = BigVal.size();
			
		}
		else if(BigVal.size() > val.BigVal.size())
		{
			largest = BigVal.size();
			smallest = val.BigVal.size();
			
		}
		else if(BigVal.size() == val.BigVal.size())
		{
			largest = BigVal.size();
			smallest = val.BigVal.size();
			
		}	
			
			for(int i = 0; i < largest; i++) // loops larger number size
	       	{     
				carry = 0; // carry gets set to zero
				sum = tempSum;
				tempSum.BigVal.clear();
				
	       		for(int j = 0; j < smallest; j++) // loops smaller numbers size
	       		{	
	    	       			
	       			//  tmp = add larger number to smaller number and add carry
	       			int tmp = BigVal.get(j) * val.BigVal.get(i) + carry;
	    	       	// carry get tmp divided by 10
	       			carry = tmp / 10;
	       			// tempSum.BigVal gets the remainder added onto the end of the arraylist
	       			tempSum.BigVal.add(tempSum.BigVal.size(), tmp % 10);
	       			
	       			// if j == smallest number -1 it adds the carry to the end of the arraylist
	       			if(j == smallest - 1)
	       			{
	       			// tempSum.BigVal gets the carry added onto the end of the arraylist
	       			tempSum.BigVal.add(tempSum.BigVal.size(), carry);
	       			}	
	       			product = tempSum;
	        	}// end of nested loop
	       		if(i <= smallest + add0)
	       		{
	       			sum.BigVal.add(0, 0);
	       			add0++;
	       		}
	       	}// end of loop		
			
 	   	reverseArr(product.BigVal);
 	   	return product;
	}//multiply
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	/* 
	 * Returns the string representation of this BigInt. It should not
	 * include leading zeros, but if the number consists of all zeros,
	 * it should return a string with a single zero. 
	 * @see java.lang.Object#toString()
	 * return replace
	 */
	public String toString()
	{
		String str = "";
		
		for(int i = 0; i < BigVal.size(); i++)
		{
			str += BigVal.get(i);
		}
			
		String remString = "";
		for(int i = 0; i < str.length(); i++)
		{
			if(str.charAt(i) == '0')
			{
				remString  = remString + "0";
			}
			else
			{
				break;
			}
		}
		
		String replace = str.replaceFirst(remString, "");
		
		if(replace.isEmpty())
		{
			replace = "0";
		}
		return replace;
	}//toString
}//OEF
