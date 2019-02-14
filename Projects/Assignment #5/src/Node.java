/**
 * Node Class
 * @author Mikael Hinton
 *
 */
public class Node {
	
	Integer item;
	Node next;
	
	/*
	 * Constructor
	 */
	protected Node(Integer newItem)
	{
		item = newItem;
		next = null;
	}//End of node
	
	/*
	 * Constructor
	 */
	protected Node(Integer newItem, Node nextNode)
	{
		item = newItem;
		next = nextNode;
	}//End of node
	
	/*
	 * Getter next
	 */
	protected Node getNext()
	{
		return next;
	}//End of getNext
	
	/*
	 * Getter item
	 */
	protected Integer getItem()
	{
		return item;
	}//End of getItem
	
	/*
	 * Setter next
	 */
	protected void setNext(Node nextNode)
	{
		next = nextNode;
	}//End of setNext
	
	/*
	 * Setter item
	 */
	protected void setItem(Integer newItem)
	{
		item = newItem;
	}//End of setItem
}//EOF