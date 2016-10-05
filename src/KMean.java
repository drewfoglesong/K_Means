/*
 * Authors: Drew Foglesong, Daniel Lewis, Matt Taylor, Zach Litteral
 * Date: October 6, 2016
 * K Means Algorithm Implementation in Java
 */
import java.util.*;
public class KMeans
{
	public static void main(String[] args)
	{
		Scanner myScanner = new Scanner(System.in);
		System.out.print("Enter the desired number of clusters: ");
		int numClusters = Integer.parseInt(myScanner.nextLine());
	}
	
	private static class Student
	{
		private int mathScore, satScore, gender, financialSupport;
		
		public Student(int mathSchore, int satScore, int gender, int financialSupport)
		{
			this.mathScore = mathScore;
			this.satScore = satScore;
			this.gender = gender;
			this.financialSupport = financialSupport;
		}
		
		public static Student[] initializeStudents()
		{
			Student[] students = new Student[300];
			Random generator = new Random(123);
			for(int i = 0; i < students.length; i++)
			{
				int mathScore = generator.nextInt(100);
				int satScore = generator.nextInt(600 + 1) + 200;
				int gender = generator.nextInt(1);
				int financialSupport = generator.nextInt(9500) + 500;
				Student newStudent = new Student(mathScore, satScore, gender, financialSupport);
				students[i] = newStudent;
			}
			return students;
		}
		
		public static double distance(Student studentA, Student studentB)
		{
			return Math.sqrt(Math.pow((studentA.mathScore - studentB.mathScore), 2) + Math.pow((studentA.satScore - studentB.satScore), 2) + Math.pow((studentA.gender - studentB.gender), 2) + Math.pow((studentA.financialSupport - studentB.financialSupport), 2));
		}
		
		public static Student getCentroid(ArrayList<Student> studentList)
		{
			
		}
	}
}
