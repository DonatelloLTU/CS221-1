/**
 * 
 * @author Mikael Hinton
 * Exception Class
 */
public class CourseException extends Exception {


	public CourseException(String error)
	{
		System.out.println("The following error has happened: " + error);	
	}
	
	private static final long serialVersionUID = 1L;
}
