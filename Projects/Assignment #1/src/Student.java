/**
 * @author Mikael Hinton
 * Student Class
 */

import java.io.Serializable;

public class Student implements Person, Serializable
{

	private static final long serialVersionUID = 1L;
//	Name of student
	String name;
//	Student ID Number
	String IDNumber;
//	Number of credits
	int credits;
//	Total grade points earned
	int gradePoints;
	
//	Constructor for Student
	public Student(String newName, String newIDNumber)
	{
		this.name = newName;
		this.IDNumber = newIDNumber;
	}
//	Returns the name field
	public String getName()
	{
		return name;
	}
//	returns the ID field
	public String getIDNumber()
	{
		return IDNumber;
	}
//	Determines if the two student objects are equal by IDNumber
	 public boolean equals(Student a, Student b)
	{
		if (a.IDNumber.equals(b.IDNumber))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
//	Setter for credits
	public void setCredits(int newCredits)
	{
		this.credits = newCredits;
	}
//	Getter for credits
	public int getCredits()
	{
		return this.credits;
	}
//	Setter for GradePoints
	public void setGradePoints(int newGradePoints)
	{
		this.gradePoints = newGradePoints;
	}
//	Getter for GradePoints
	public int getGradePoints()
	{
		return this.gradePoints;
	}
//	Calculated GPA
	public double calculateGPA()
	{
		return (double)(this.gradePoints / this.credits);
	}
//	toString method
	public String toString()
	{
		return "ID Number: " + IDNumber + "\tName: " + name;
	}
}
