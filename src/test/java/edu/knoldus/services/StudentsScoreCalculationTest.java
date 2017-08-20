package edu.knoldus.services;

import static org.junit.Assert.*;
import edu.knoldus.models.Calculator;
import edu.knoldus.models.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Calculator.class })
public class StudentsScoreCalculationTest extends Mockito implements StudentsScoreCalculation{

    private String[] subjectsArray = {"Java", "Scala", "Play", "Akka"};
    private double[] marks1 = {55, 75, 88, 62};
    private Student student = new Student(1, "Divya", subjectsArray, marks1);
    private Student student1 = new Student();

    @Test
    public void isEligibleTest(){
        PowerMockito.mockStatic(Calculator.class);
        Mockito.when(Calculator.checkIfGreaterThan30(55)).thenReturn(true);
        Mockito.when(Calculator.checkIfGreaterThan30(75)).thenReturn(true);
        Mockito.when(Calculator.checkIfGreaterThan30(88)).thenReturn(true);
        Mockito.when(Calculator.checkIfGreaterThan30(62)).thenReturn(true);

        boolean result = StudentsScoreCalculation.isEligible(student);
        assertEquals(true, result);
    }

    @Test
    public void calculatePercentageTest(){
        double result = StudentsScoreCalculation.calculatePercentage(student);
        assert(result == 70.0);
    }


    @Test
    public void calculatePercentageByReduceTest(){
        double result = StudentsScoreCalculation.calculatePercentageByReduce(student);
        assert(result == 70.0);
    }

    @Test
    public void calculatePercentageByReduceTestForEmptyStudent(){
        double result = StudentsScoreCalculation.calculatePercentageByReduce(student1);
        assert(result == 0.0);
    }

    @Test
    public void countSubjectsTest(){
        long result = StudentsScoreCalculation.countSubjects(student);
        assertEquals(4, result);
    }

    @Test
    public void averageMarksTest(){
        double result = StudentsScoreCalculation.averageMarks(student);
        assert(result == 70.0);
    }
}