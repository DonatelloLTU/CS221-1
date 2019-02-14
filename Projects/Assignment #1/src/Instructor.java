/**
 * @author Mikael Hinton
 * Instructor Class
 */

import java.io.Serializable;

public class Instructor implements Person, Serializable
{
	private static final long serialVersionUID = 1L;
//  department the instructor is in
	public String department;
//	Name of instructor
	public String name;
//	Faculty ID number
	public String IDNumber;
	
//	Constructor
	public Instructor(String newName ,String newIDNumber)
	{
		this.name = newName;
		this.IDNumber = newIDNumber;
	}
	//	Set the instructors department
	public void setDepartment(String newDepartment)
	{
		this.department = newDepartment;
	}
//	Getter for the department
	public String getDepartment()
	{
		return department;
	}
//	toString method to print out the ID number, name and department
	public String toString()
	{
		return "ID Number: " + IDNumber + "\tName: " + name;
	}
}
