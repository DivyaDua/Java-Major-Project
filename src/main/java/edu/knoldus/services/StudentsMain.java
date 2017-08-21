package edu.knoldus.services;

import edu.knoldus.models.Student;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class StudentsMain implements StudentsScoreCalculation, StudentComparisons{

    public static void main(String...args){

        Logger logger = Logger.getLogger(StudentsMain.class.getName());

        String[] subjects = {"Java", "Scala", "Play", "Akka"};
        double[] marks1 = {55, 75, 88, 62};
        double[] marks2 = {65, 76, 88, 87};
        double[] marks3 = {95, 65, 88, 62};
        double[] marks4 = {30, 25, 25, 27};

        Student student1 = new Student(1, "Divya", subjects, marks1);
        Student student2 = new Student(2, "Neha", subjects, marks2);
        Student student3 = new Student(3, "Shruti", subjects, marks3);
        Student student4 = new Student(4, "Prince", subjects, marks4);

        boolean isEligible = StudentsScoreCalculation.isEligible(student1);
        logger.info(".........Checking if a student is eligible or not............"+isEligible);

        double percentage = StudentsScoreCalculation.calculatePercentage(student1);
        logger.info(".........Calculating student percentage............"+percentage);

        List<Student> studentsList = Arrays.asList(student1, student2, student3, student4);
        String result = StudentComparisons.checkIfStudentsAreEligible(studentsList);
        logger.info(".........Checking if all students are eligible or not............"+result);

        String studentWithHighestPercentage = StudentComparisons.highestPercentage(studentsList);
        logger.info(".........Student with highest percentage............" + studentWithHighestPercentage);

        long countOfSubjects = StudentsScoreCalculation.countSubjects(student1);
        logger.info(".........Total Number of subjects............"+countOfSubjects);

        long countOfStudents = StudentComparisons.countStudents(studentsList);
        logger.info(".........Total Number of students............"+countOfStudents);

        Object[] sortedNamesArray = StudentComparisons.sortByName(studentsList).toArray();
        logger.info(".........Sorting students by name............" + sortedNamesArray);

        Object[] passedStudentArray = StudentComparisons.passedStudents(studentsList).toArray();
        logger.info(".........Passed Students............" + passedStudentArray);
        
        double percentageByReduce = StudentsScoreCalculation.calculatePercentageByReduce(student2);
        logger.info(".........Calculating student percentage by reduce............"+ percentageByReduce);

        double average =  StudentsScoreCalculation.averageMarks(student1);
        logger.info(".........Calculating average marks of student............"+average);

        String namesString = StudentComparisons.studentsNamesString(studentsList);
        logger.info(".........Displaying student names string............"+ namesString);

        Map<String, Long> stringLongMap = StudentComparisons.studentsWithSameNames(studentsList);
        logger.info(".........Number of students with same name............"+stringLongMap);

        DateAndTimeExample dateAndTimeExample = new DateAndTimeExample();
        String age = dateAndTimeExample.ageOfPerson();
        logger.info(".........Calculating person age............"+ age);

    }

}


