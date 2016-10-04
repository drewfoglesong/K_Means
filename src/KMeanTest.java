
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniellewis
 */
public class KMeanTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Number of groups to create(must be greater than 4)");
        int k = input.nextInt();
        System.out.println("Enter No of Data Items");
        int noOfItems = input.nextInt();
        new KMean(k, noOfItems);
        ArrayList<Student> studentList = new ArrayList<Student>();
        
        Random randomizer = new Random(1234);
        for(int i = 0; i < 300; i++){
            Student student = new Student();
            student.setID(i);
            student.setMathScore(randomizer.nextInt(100)+0);
            student.setSATScore(randomizer.nextInt(800)+200);
            student.setGender(randomizer.nextInt(1)+0);
            student.setFinancialSupport(randomizer.nextInt(10000)+500); 
            studentList.add(student);
        }
        
        for(int i = 0; i < studentList.size(); i++)
        {
            int id = studentList.get(i).getID();
            int mathScore = studentList.get(i).getMathScore();
            int satScore = studentList.get(i).getSATScore();
            int gender = studentList.get(i).getGender();
            int financialSupport = studentList.get(i).getFinancialSupport();
            System.out.println("id: " + id + " Math Score: " + mathScore + " SAT Score: " + satScore + " Gender: " + gender + " Financial Support: " + financialSupport);
        }
    }
}
