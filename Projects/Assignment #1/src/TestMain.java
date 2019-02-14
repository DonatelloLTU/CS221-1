/**
 * @author Mikael Hinton
 * Testing all methods
 */


import java.io.FileNotFoundException;
import java.io.IOException;

public class TestMain {

	public static void main(String args[]) throws FileNotFoundException, IOException, CourseException
	{

		Course course1 = new Course("Math", "45644");
		Instructor instructor1 = new Instructor("Gary", "123456");
		Student s1 = new Student("Mikael", "111111");
		Student s2 = new Student("Mikael", "111111");
		Student s3 = new Student("JD", "111112");
		Student s4 = new Student("Ty", "111113");

		System.out.println("\tTESTING REGISTRAR!\n");

		System.out.println("Course 1: " + course1);
		System.out.println("Instructor 1: " + instructor1);
		System.out.println("Student 1: " + s1);
		System.out.println("Student 2: " + s2);
		System.out.println("Student 3: " + s3);
		System.out.println("Student 4: " + s4);
		System.out.println("\n");

		
		System.out.println("Instructor Methods");
		
		System.out.println("Instructors department is " + instructor1.department);
		instructor1.setDepartment("CS");
		System.out.println("Instructors department is " + instructor1.department);
		
		System.out.println(instructor1.toString() + "\n");
		
		System.out.println("Students Methods");
		
		System.out.println("Finding Student: 111112");
		course1.addStudent(s3);
		System.out.println(course1.findStudent("111112"));
		
		System.out.println("The Student's " + s1.toString());
		
		System.out.println("The students grade points are " + s1.getGradePoints() + " and the students credits are " + s1.getCredits());
		s1.setCredits(11);
		s1.setGradePoints(55);
		System.out.println("The students grade points are " + s1.getGradePoints() + " and the students credits are " + s1.getCredits());
		
		System.out.println("The students GPA is " + s1.calculateGPA());
		
		System.out.println("Student1 and Student2 are equal: " + s1.equals(s1, s2));
		System.out.println("Student1 and Student3 are equal: " + s1.equals(s1, s3));
		System.out.println("Student1 and Student4 are equal: " + s1.equals(s1, s4));

		System.out.println("\nCourse Methods");
		
		course1.setInstructor(instructor1);
		System.out.println("The Courses instructor is " + course1.getInstructor().toString());
		try
		{
		course1.addStudent(s2);
		}
		catch(CourseException e) {}
		
		course1.saveCourse("course.data");
		
		System.out.println("Load Method");
		System.out.println("The courses ID is " + course1.courseCode);
		System.out.println("Changing the course1");
		course1 = new Course("CS", "987644");
		System.out.println("The courses ID is " + course1.courseCode);
		System.out.println("Loading course data");
		course1.loadCourse("course.data");
		System.out.println("The courses ID is now " + course1.courseCode);
		
		System.out.println("\nRemoving Student: 1111112");
		course1.removeStudent(s3);
		System.out.println(course1); 

	}
}
