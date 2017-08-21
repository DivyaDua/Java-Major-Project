package edu.knoldus.services;

import static org.junit.Assert.*;
import edu.knoldus.models.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ StudentsScoreCalculation.class })
public class StudentComparisonsTest extends Mockito implements StudentComparisons{

    private String[] subjects = {"Java", "Scala", "Play", "Akka"};
    private double[] marks1 = {55, 75, 88, 62};
    private double[] marks2 = {65, 76, 88, 87};
    private double[] marks3 = {95, 90, 90, 90};
    private double[] marks4 = {30, 25, 25, 27};
    private double[] marks5 = {30, 55, 25, 86};

    private Student student1 = new Student(1, "Divya", subjects, marks1);
    private Student student2 = new Student(2, "Neha", subjects, marks2);
    private Student student3 = new Student(3, "Shruti", subjects, marks3);
    private Student student4 = new Student(4, "Prince", subjects, marks4);
    private Student student5 = new Student(5, "Prince", subjects, marks5);

    private List<Student> studentsList = Arrays.asList(student1, student2, student3, student4,student5);
    private List<Student> studentList1 = Arrays.asList(student1, student3, student1, student2, student4, student3);

    @Test
    public void checkIfStudentsAreEligibleTest(){
        PowerMockito.mockStatic(StudentsScoreCalculation.class);
        PowerMockito.when(StudentsScoreCalculation.isEligible(student1)).thenReturn(true);
        PowerMockito.when(StudentsScoreCalculation.isEligible(student2)).thenReturn(true);
        PowerMockito.when(StudentsScoreCalculation.isEligible(student3)).thenReturn(true);
        PowerMockito.when(StudentsScoreCalculation.isEligible(student4)).thenReturn(true);
        PowerMockito.when(StudentsScoreCalculation.isEligible(student5)).thenReturn(true);

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
        PowerMockito.when(StudentsScoreCalculation.isEligible(student5)).thenReturn(true);

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
        PowerMockito.when(StudentsScoreCalculation.isEligible(student5)).thenReturn(false);

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
        PowerMockito.when(StudentsScoreCalculation.calculatePercentage(student5)).thenReturn(60.0);

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
        PowerMockito.when(StudentsScoreCalculation.calculatePercentage(student5)).thenReturn(60.0);

        Student result = StudentComparisons.lowestPercentage(studentsList);
        assert (result == student3);
    }

    @Test
    public void countStudentsTest(){
        long result = StudentComparisons.countStudents(studentsList);
        assertEquals(5, result);
    }

    @Test
    public void sortByNameTest(){
        Stream<Student> sortedStream = StudentComparisons.sortByName(studentsList);
        List<Student> sortedStudentList = Arrays.asList(student1, student2, student4, student5, student3);
        Stream<Student> sortedStudentStream = sortedStudentList.stream();
        assertEquals(sortedStream.toArray(), sortedStudentStream.toArray());
    }

    @Test
    public void passedStudentsTest(){
        PowerMockito.mockStatic(StudentsScoreCalculation.class);
        PowerMockito.when(StudentsScoreCalculation.calculatePercentage(student1)).thenReturn(70.0);
        PowerMockito.when(StudentsScoreCalculation.calculatePercentage(student2)).thenReturn(80.0);
        PowerMockito.when(StudentsScoreCalculation.calculatePercentage(student3)).thenReturn(25.0);
        PowerMockito.when(StudentsScoreCalculation.calculatePercentage(student4)).thenReturn(67.0);
        PowerMockito.when(StudentsScoreCalculation.calculatePercentage(student5)).thenReturn(28.0);

        Stream<Student> studentStream = StudentComparisons.passedStudents(studentsList);
        List<Student> passedStudentsList = Arrays.asList(student1, student2, student4);
        Stream<Student> passedStudentsStream = passedStudentsList.stream();

        assertEquals (studentStream.toArray(),passedStudentsStream.toArray());
    }

    @Test
    public void firstStudentTest(){
        Student student = StudentComparisons.firstStudent(studentList1);
        assertEquals(student, student1);
    }

    @Test
    public void firstStudentTestForEmptyStudentList(){
        Student student = StudentComparisons.firstStudent(Arrays.asList());
        Student student5 = new Student();
        assertEquals(student.getRollNo(), student5.getRollNo());
    }

    @Test
    public void studentsNamesStringTest(){
        String result = StudentComparisons.studentsNamesString(studentsList);
        assert(result.equals("Divya,Neha,Shruti,Prince"));
    }

    @Test
    public void evenRollNoStudentsTest(){
        List<Integer> resultList = StudentComparisons.evenRollNoStudents(studentsList);
        List<Integer> actualList = Arrays.asList(2,4);
        assertEquals (actualList, resultList);

    }

    @Test
    public void studentsWithSameNamesTest(){
        Map<String, Long> result = StudentComparisons.studentsWithSameNames(studentsList);
        Map<String, Long> actualResult = new HashMap<>();
        actualResult.put("Prince", 2L);
        actualResult.put("Neha",1L);
        actualResult.put("Divya",1L);
        actualResult.put("Shruti",1L);

        assertEquals(actualResult, result);
    }


}