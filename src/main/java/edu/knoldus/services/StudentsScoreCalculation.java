package edu.knoldus.services;

import edu.knoldus.models.Calculator;
import edu.knoldus.models.Student;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public interface StudentsScoreCalculation  extends Calculator{


    static boolean isEligible(Student student){
        double[] arrayOfMarks = student.getMarks();
        return Arrays.stream(arrayOfMarks).allMatch(Calculator::checkIfGreaterThan30);
    }

    static double calculatePercentage(Student student){
        double[] arrayOfMarks = student.getMarks();
        DoubleSummaryStatistics statistics = Arrays.stream(arrayOfMarks).mapToObj(Double::new).collect(Collectors.summarizingDouble(a -> a));
        return statistics.getSum()/countSubjects(student);
    }

    static double calculatePercentageByReduce(Student student){
        double[] arrayOfMarks = student.getMarks();
        OptionalDouble sum = Arrays.stream(arrayOfMarks).reduce((x, y) -> x + y);
        if(sum.isPresent()){
            return sum.getAsDouble()/countSubjects(student);
        }
        else{
            return 0.0;
        }
    }

    static double averageMarks(Student student){
        double[] arrayOfMarks = student.getMarks();
        return Arrays.stream(arrayOfMarks).average().orElse(0.0);
    }

    static long countSubjects(Student student){
        String[] arrayOfSubjects = student.getSubject();
        return Arrays.stream(arrayOfSubjects).count();

    }

}
