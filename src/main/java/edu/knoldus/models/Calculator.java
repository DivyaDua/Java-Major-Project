package edu.knoldus.models;

import java.util.function.Predicate;

public interface Calculator {

    /*static int add(int num1, int num2){
        return num1 + num2;
    }

    static int subtract(int num1, int num2){
        return num1 - num2;
    }

    static int multiply(int num1, int num2){
        return num1 * num2;
    }

    static double divideBy4(double num) {
        return num / 4;
    }
*/
    static boolean checkIfGreaterThan30(double marks){
        Predicate<Double> predicate = value -> value > 30.0;
        return predicate.test(marks);
    }

}
