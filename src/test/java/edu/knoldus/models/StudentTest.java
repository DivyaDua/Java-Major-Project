package edu.knoldus.models;

import static org.junit.Assert.*;
import org.junit.Test;

public class StudentTest {

    private String[] subjectsArray = {"Java", "Scala", "Play", "Akka"};
    private double[] marks1 = {55, 75, 88, 62};
    private Student student = new Student(1, "Divya", subjectsArray, marks1);

    @Test
    public void getRollNoTest(){
        int rollNo = student.getRollNo();
        assertEquals(1, rollNo);
    }

    @Test
    public void getNameTest(){
        String name = student.getName();
        assertEquals("Divya", name);
    }

    @Test
    public void getSubjectsTest(){
        String[] subjects = student.getSubject();
        assert (subjectsArray == subjects);
    }
    @Test
    public void getMarksTest(){
        double[] marks = student.getMarks();
        assert (marks1 == marks);
    }

}