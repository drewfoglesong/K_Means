
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniellewis
 */
public class Student {
    int id;
    int mathScore;
    int satScore;
    int gender;
    int financialSupport;
    
    public int getID(){
        return id;
    }
    
    public void setID(int id){
        this.id = id;
    }
    
    public int getMathScore(){
        return mathScore;
    }
    
    public void setMathScore(int mathScore){
        this.mathScore = mathScore;
    }
    
    public int getSATScore(){
        return satScore;
    }
    
    public void setSATScore(int satScore){
        this.satScore = satScore;
    }
    
    public int getGender(){
        return gender;
    }
    
    public void setGender(int gender){
        this.gender = gender;
    }
    
    public int getFinancialSupport(){
        return financialSupport;
    }
    
    public void setFinancialSupport(int financialSupport){
        this.financialSupport = financialSupport;
    }
    /* This code is used to test that this class works properly on its own
    public static void main(String[] args)
    {
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
    }*/
}
