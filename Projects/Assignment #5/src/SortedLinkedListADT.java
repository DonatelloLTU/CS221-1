/**
 * Interface for a linkedListADT
 * @author Mikael Hinton
 */
public interface SortedLinkedListADT {
	
	public boolean isEmpty();
	public int size();
	public void insert(Integer item);
	public void remove(Integer item);
	public void removeAll();
	public boolean contains(Integer item);
	public Integer[] getAll();
}//EOI
