/**
 * Implementation of the ADT stack that use (a) an array, (b) a linked list, (c) an ADT List
 * @author Mikael Hinton
 *
 */
public interface IStack {
	
	public boolean isEmpty();
	// Determine whether the stack is empty.
	// PreCondition: None
	// PostCondition: Returns true if the stack is empty;
	// 		otherwise returns false
	
	public void popAll();
	// Removes all the items from the stack.
	// PreCondition: None
	// PostCondition: Stack is empty.
	
	public void push(Integer newItem) throws StackException;
	//	 Adds an item to the top of a stack
	//	 PreCondition: newItem is the item to be added.
	//	 PostCondition: If insertion is successful, newItem
	//			is on the top of the stack.
	//	 Exception: Some implementations may throw
	//	 StackExcpetion when newItem cannot be places on the stack.
	
	public Integer pop() throws StackException;
	//	 Removes the top of a stack.
	//	 PreCondition: None
	//	 PostCondition: If the stack is not empty, the item
	//			that was added most recently s removed from the
	//			stack and returned.
	//	 Exception: Throws StackException if the stack is empty.
	
	public Integer peek() throws StackException;
	// Retrieves the top of a stack.
	// PreCondition: None
	// PostCondition: If the stack is not empty, the item that was added most recently is returned.
	//		The stack is unchanged.
	// Exception: Throws Stack Exception if the stack is empty
}//End of IStack