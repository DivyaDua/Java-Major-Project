package edu.knoldus.services;

import edu.knoldus.models.Student;
import java.util.Arrays;
import java.util.List;

public class StudentsMain implements StudentsScoreCalculation, StudentComparisons{

    public static void main(String...args){

        String[] subjects = {"Java", "Scala", "Play", "Akka"};
        double[] marks1 = {55, 75, 88, 62};
        double[] marks2 = {65, 76, 88, 87};
        double[] marks3 = {95, 65, 88, 62};
        double[] marks4 = {30, 25, 25, 27};

        Student student1 = new Student(1, "Divya", subjects, marks1);
        Student student2 = new Student(2, "Neha", subjects, marks2);
        Student student3 = new Student(3, "Shruti", subjects, marks3);
        Student student4 = new Student(4, "Prince", subjects, marks4);

        System.out.println(StudentsScoreCalculation.isEligible(student1));
        System.out.println(StudentsScoreCalculation.calculatePercentage(student1));

        List<Student> studentsList = Arrays.asList(student1, student2, student3, student4);
        System.out.println(StudentComparisons.checkIfStudentsAreEligible(studentsList));

        Student studentWithHighestPercentage = StudentComparisons.highestPercentage(studentsList);
        studentWithHighestPercentage.displayName();

        System.out.println(StudentComparisons.countStudents(studentsList));

        StudentComparisons.sortByName(studentsList).forEach(Student::displayName);

        System.out.println(".....................");
        StudentComparisons.passedStudents(studentsList).forEach(Student::displayName);

        System.out.println(StudentsScoreCalculation.calculatePercentageByReduce(student2));

        DateAndTimeExample dateAndTimeExample = new DateAndTimeExample();
        System.out.println(dateAndTimeExample.ageOfPerson());

        System.out.println(StudentsScoreCalculation.averageMarks(student1));

        System.out.println(StudentComparisons.studentsNamesString(studentsList));

        System.out.println(StudentComparisons.studentsWithSameNames(studentsList));
    }
}

