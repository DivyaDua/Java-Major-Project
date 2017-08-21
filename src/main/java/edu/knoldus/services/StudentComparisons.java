package edu.knoldus.services;

import edu.knoldus.models.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
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

    static String highestPercentage(List<Student> studentsList){
        return studentsList.stream().max(Comparator.comparing(StudentsScoreCalculation::calculatePercentage)).map(Student::getName).get();
    }

    static String lowestPercentage(List<Student> studentsList){
        return studentsList.stream().min(Comparator.comparing(StudentsScoreCalculation::calculatePercentage)).map(Student::getName).get();
    }

    static long countStudents(List<Student> studentsList){
        return studentsList.stream().count();
    }

    static Stream<String> sortByName(List<Student> studentsList){
        return studentsList.stream().sorted(Comparator.comparing(Student::getName)).map(Student::getName);
    }

    static Stream<String> passedStudents(List<Student> studentsList){
        return studentsList.stream().filter(student -> StudentsScoreCalculation.calculatePercentage(student) > 30).map(Student::getName);
    }

    static Student firstStudent(List<Student> studentsList){
        Optional<Student> student =  studentsList.stream().distinct().findFirst();
        if(student.isPresent()){
            return student.get();
        }
        else {
            return new Student();
        }
    }

    static Map<String, Long> studentsWithSameNames(List<Student> studentsList){
         return studentsList.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
    }

    static String studentsNamesString(List<Student> studentsList){
        return studentsList.stream().map(Student::getName).collect(Collectors.joining(","));
    }

    static List<Integer> evenRollNoStudents(List<Student> studentsList){
        Map<Boolean, List<Integer>> studentsMap = studentsList.stream().map(Student::getRollNo).collect(Collectors.partitioningBy(n -> n % 2 == 0));
        return studentsMap.get(true);
    }



}
