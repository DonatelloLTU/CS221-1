/**
 * @author Mikael Hinton
 * Course Class
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Course implements Serializable{

	private static final long serialVersionUID = 1L;
//	Name of the course
	public String courseName;
//	Course registration code
	public String courseCode;
//	Maximum number of 35 students
	final int MAX_STUDENTS = 35;
//	Instructor
	public Instructor instructor;
//	Number of students
	public int numOfStudents;
//	Students registered in the course (an Array)
	Student[] students = new Student[MAX_STUDENTS];
	
//	Constructor that initializes the name, registration code, and maximum number of students
	public Course(String newCourseName, String newCourseCode)
	{
		this.courseName = newCourseName;
		this.courseCode = newCourseCode;
	}
	
//	Setter for Instructor
	public void setInstructor(Instructor newInstructor)
	{
		this.instructor = newInstructor;
	}
	
//	Getter for Instructor
	public Instructor getInstructor()
	{
		return this.instructor;
	}
	
//	Finding student in array list by ID number
	public Student findStudent(String studentID)
	{
		int i;
		boolean f = false;
		for(i = 0; i < numOfStudents; i++)
		{
			if(students[i].IDNumber.equals(studentID))
			{
				f = true;
				break;
			}
		}
		if(f)
		{
			return students[i]; 
		}
		else
		{
			return null;
		}
	}
	
//	Adding a student to the course. 
	public void addStudent(Student student) throws CourseException
	{
		if(numOfStudents >= MAX_STUDENTS)
		{
			throw new CourseException("Course full!");
		}
		else
		{
			for(int i = 0; i < numOfStudents; i++)
			{
				if(students[i].IDNumber.equals(student.IDNumber))
				{
					throw new CourseException("Student already added!");
				}
			}
			students[numOfStudents] = student;
			numOfStudents++;
		}
	}
	
//	Remove a student in the course
	public void removeStudent(Student s) throws CourseException
	{
		for(int i = 0; i < MAX_STUDENTS; i++)
		{
			if(students[i].IDNumber.equals(s.IDNumber))
			{
				int sh = i;
				while(sh < numOfStudents)
				{
					students[sh] = students[sh + 1];
					sh++;
				}
				return;
			}
		}
		throw new CourseException("Student not found");
	}
	
//	Saving the course to a file
	public void saveCourse(String fileName) throws FileNotFoundException, IOException 
	{
		try
		{
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName));
		output.writeObject(this);
		output.close();
		}
		catch(IOException e)
		{
			System.out.println("File" + fileName + " was not found!");
		}
	}
//	Loading the course from a file
	public void loadCourse(String fileName)
	{
		try
		{
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName));
			Course res = (Course)input.readObject();
			
			this.courseCode = res.courseCode;
			this.courseName = res.courseName;
			this.instructor = res.instructor;
			this.students = res.students;
			this.numOfStudents = res.numOfStudents;
			
			input.close();
		}
		catch(Exception e)
		{
			System.out.println("File " + fileName + " was not found!");
		}
		
	}
//	toString Method
	public String toString()
	{
		return "Course Code: " + courseCode + "\tCourse Name: " + courseName + "\tMax Students: " + MAX_STUDENTS;
	}
}
