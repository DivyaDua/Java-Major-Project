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

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ StudentsScoreCalculation.class })
public class StudentComparisonsTest extends Mockito implements StudentComparisons{

    private String[] subjects = {"Java", "Scala", "Play", "Akka"};
    private double[] marks1 = {55, 75, 88, 62};
    private double[] marks2 = {65, 76, 88, 87};
    private double[] marks3 = {95, 90, 90, 90};
    private double[] marks4 = {30, 25, 25, 27};

    private Student student1 = new Student(1, "Divya", subjects, marks1);
    private Student student2 = new Student(1, "Neha", subjects, marks2);
    private Student student3 = new Student(1, "Shruti", subjects, marks3);
    private Student student4 = new Student(1, "Prince", subjects, marks4);

    List<Student> studentsList = Arrays.asList(student1, student2, student3, student4);

    @Test
    public void checkIfStudentsAreEligibleTest(){
        PowerMockito.mockStatic(StudentsScoreCalculation.class);
        PowerMockito.when(StudentsScoreCalculation.isEligible(student1)).thenReturn(true);
        PowerMockito.when(StudentsScoreCalculation.isEligible(student2)).thenReturn(true);
        PowerMockito.when(StudentsScoreCalculation.isEligible(student3)).thenReturn(true);
        PowerMockito.when(StudentsScoreCalculation.isEligible(student4)).thenReturn(true);

        String result = StudentComparisons.checkIfStudentsAreEligible(studentsList);
        assert (result.equals("All Students are eligible for advanced level"));
    }

    @Test
    public void checkIfStudentsAreEligibleTestForAnyMatchCase(){
        PowerMockito.mockStatic(StudentsScoreCalculation.class);
        PowerMockito.when(StudentsScoreCalculation.isEligible(student1)).thenReturn(true);
        PowerMockito.when(StudentsScoreCalculation.isEligible(student2)).thenReturn(false);
        PowerMockito.when(StudentsScoreCalculation.isEligible(student3)).thenReturn(true);
        PowerMockito.when(StudentsScoreCalculation.isEligible(student4)).thenReturn(true);

        String result = StudentComparisons.checkIfStudentsAreEligible(studentsList);
        assert (result.equals("Some Students are eligible for advanced level"));
    }

    @Test
    public void checkIfStudentsAreEligibleTestForNoneMatchCase(){
        PowerMockito.mockStatic(StudentsScoreCalculation.class);
        PowerMockito.when(StudentsScoreCalculation.isEligible(student1)).thenReturn(false);
        PowerMockito.when(StudentsScoreCalculation.isEligible(student2)).thenReturn(false);
        PowerMockito.when(StudentsScoreCalculation.isEligible(student3)).thenReturn(false);
        PowerMockito.when(StudentsScoreCalculation.isEligible(student4)).thenReturn(false);

        String result = StudentComparisons.checkIfStudentsAreEligible(studentsList);
        assert (result.equals("None of the Students are eligible for advanced level"));
    }

    @Test
    public void highestPercentageTest(){
        PowerMockito.mockStatic(StudentsScoreCalculation.class);
        PowerMockito.when(StudentsScoreCalculation.calculatePercentage(student1)).thenReturn(70.0);
        PowerMockito.when(StudentsScoreCalculation.calculatePercentage(student2)).thenReturn(80.0);
        PowerMockito.when(StudentsScoreCalculation.calculatePercentage(student3)).thenReturn(45.0);
        PowerMockito.when(StudentsScoreCalculation.calculatePercentage(student4)).thenReturn(67.0);

        Student result = StudentComparisons.highestPercentage(studentsList);
        assert (result == student2);
    }

    @Test
    public void lowestPercentageTest(){
        PowerMockito.mockStatic(StudentsScoreCalculation.class);
        PowerMockito.when(StudentsScoreCalculation.calculatePercentage(student1)).thenReturn(70.0);
        PowerMockito.when(StudentsScoreCalculation.calculatePercentage(student2)).thenReturn(80.0);
        PowerMockito.when(StudentsScoreCalculation.calculatePercentage(student3)).thenReturn(45.0);
        PowerMockito.when(StudentsScoreCalculation.calculatePercentage(student4)).thenReturn(67.0);

        Student result = StudentComparisons.lowestPercentage(studentsList);
        assert (result == student3);
    }

    @Test
    public void countStudentsTest(){
        long result = StudentComparisons.countStudents(studentsList);
        assertEquals(4, result);
    }

    @Test
    public void sortByNameTest(){
        Student studentMock = mock(Student.class);
       // when(studentMock.student1.getName())
    }

    @Test
    public void passedStudentsTest(){
        PowerMockito.mockStatic(StudentsScoreCalculation.class);
        PowerMockito.when(StudentsScoreCalculation.calculatePercentage(student1)).thenReturn(70.0);
        PowerMockito.when(StudentsScoreCalculation.calculatePercentage(student2)).thenReturn(80.0);
        PowerMockito.when(StudentsScoreCalculation.calculatePercentage(student3)).thenReturn(25.0);
        PowerMockito.when(StudentsScoreCalculation.calculatePercentage(student4)).thenReturn(67.0);

        Stream<Student> studentStream = StudentComparisons.passedStudents(studentsList);
        List<Student> passedStudentsList = Arrays.asList(student1, student2, student4);

        Stream<Student> passedStudentsStream = passedStudentsList.stream();
        assertEquals (studentStream,passedStudentsStream);
    }
}