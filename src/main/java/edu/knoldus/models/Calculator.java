package edu.knoldus.models;

import java.util.function.Predicate;

public interface Calculator {

    static boolean checkIfGreaterThan30(double marks){
        Predicate<Double> predicate = value -> value > 30.0;
        return predicate.test(marks);
    }

}
