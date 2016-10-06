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
		int iterations = 50;
		int numClusters = Integer.parseInt(myScanner.nextLine());
		List<List<Student>> clusters = new ArrayList<List<Student>>();
		Student[] centroids = new Student[numClusters];
		Student[] students = Student.initializeStudents();
		//Make the clusters
		for(int i = 0; i < numClusters; i++)
		{
			ArrayList<Student> myList = new ArrayList<Student>();
			clusters.add(myList);
		}
		//Pick initial centroids
		for(int i = 0; i < numClusters; i++)
		{
			centroids[i] = students[i];
		}
		//Perform KMeans for desired number of iterations
		for(int i = 0; i < iterations; i++)
		{
			Student.cluster(students, centroids, clusters);
			//Calculate new centroids
			for(int j = 0; j < clusters.size(); j++)
			{
				centroids[j] = Student.getCentroid(clusters.get(j));
			}
		}
		
		//Print results
		for(int i = 0; i < clusters.size(); i++)
		{
			System.out.println("Cluster " + (i + 1) + " Total Items: " + clusters.get(i).size());
			for(int j = 0; j < clusters.get(i).size(); j++)
			{
				System.out.println(clusters.get(i).get(j).toString());
			}
			System.out.println();
		}
		myScanner.close();
	}
	
	private static class Student
	{
		private int mathScore, satScore, gender, financialSupport;
		
		public Student(int mathScore, int satScore, int gender, int financialSupport)
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
				int gender = generator.nextInt(2);
				int financialSupport = generator.nextInt(9500) + 500;
				Student newStudent = new Student(mathScore, satScore, gender, financialSupport);
				students[i] = newStudent;
			}
			return students;
		}
		
		public static double getDistance(Student studentA, Student studentB)
		{
			return Math.sqrt(Math.pow((studentA.mathScore - studentB.mathScore), 2) + Math.pow((studentA.satScore - studentB.satScore), 2) + Math.pow((studentA.gender - studentB.gender), 2) + Math.pow((studentA.financialSupport - studentB.financialSupport), 2));
		}
		
		public static Student getCentroid(List<Student> studentList)
		{
			int mathScoreTotal = 0;
			int satScoreTotal = 0;
			int genderTotal = 0;
			int financialSupportTotal = 0;
			int count = 0;
			for(Student student : studentList)
			{
				mathScoreTotal += student.mathScore;
				satScoreTotal += student.satScore;
				genderTotal += student.gender;
				financialSupportTotal += student.financialSupport;
				count++;
			}
			Student newCentroid = new Student(mathScoreTotal / count, satScoreTotal / count, genderTotal / count, financialSupportTotal / count);
			return newCentroid;
		}
		
		//Perform the clustering on all the students
		public static void cluster(Student[] students, Student[] centroids, List<List<Student>> clusters)
		{
			//Empty all clusters
			for(List<Student> cluster : clusters)
			{
				cluster.clear();
			}
			for(Student aStudent : students)
			{
				int index = 0;
				double minDistance = Integer.MAX_VALUE;
				for(int i = 0; i < clusters.size(); i++)
				{		
					double distance = getDistance(aStudent, centroids[i]);
					if(distance < minDistance)
					{
						index = i;
						minDistance = distance;
					}
						
				}
				clusters.get(index).add(aStudent);
				
			}
		}
		
		public String toString()
		{
			String studentGender = "Male";
			if(gender == 0)
				studentGender = "Female";
			return "Math Score: " + mathScore + " SAT Score: " + satScore + " Gender: " + studentGender + " Financial Support: " + financialSupport;
		}
	}
}
