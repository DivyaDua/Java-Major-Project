package edu.knoldus.services;

import edu.knoldus.models.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public interface StudentComparisons extends StudentsScoreCalculation{

    static String checkIfStudentsAreEligible(List<Student> studentsList) {
        if (studentsList.stream().allMatch(StudentsScoreCalculation::isEligible)) {
            return "All Students are eligible for advanced level";
        } else if (studentsList.stream().anyMatch(StudentsScoreCalculation::isEligible)) {
            return "Some Students are eligible for advanced level";
        } else {
            return "None of the Students are eligible for advanced level";
        }
    }

    static Student highestPercentage(List<Student> studentsList){
        return studentsList.stream().max(Comparator.comparing(StudentsScoreCalculation::calculatePercentage)).get();
    }

    static Student lowestPercentage(List<Student> studentsList){
        return studentsList.stream().min(Comparator.comparing(StudentsScoreCalculation::calculatePercentage)).get();
    }

    static long countStudents(List<Student> studentsList){
        return studentsList.stream().count();
    }

    static Stream<Student> sortByName(List<Student> studentsList){
        return studentsList.stream().sorted(Comparator.comparing(Student::getName));
    }

    static Stream<Student> passedStudents(List<Student> studentsList){
        return studentsList.stream().filter(student -> StudentsScoreCalculation.calculatePercentage(student) > 30);
    }

}
