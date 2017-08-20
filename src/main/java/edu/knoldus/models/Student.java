package edu.knoldus.models;

public class Student {
    int rollNo;
    String name;
    String[] subject;
    double[] marks;

    public Student(int rollNo, String name, String[] subject, double[] marks){
        this.rollNo = rollNo;
        this.name = name;
        this.subject = subject;
        this.marks = marks;
    }

    public int getRollNo(){
        return this.rollNo;
    }

    public String getName(){
        return this.name;
    }

    public String[] getSubject(){
        return this.subject;
    }

    public double[] getMarks(){
        return this.marks;
    }

    public void displayName(){
        System.out.println(this.name);
    }
}