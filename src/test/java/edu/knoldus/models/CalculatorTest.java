package edu.knoldus.models;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest implements Calculator{

    @Test
    public void checkIfGreaterThan30Test(){
        boolean result = Calculator.checkIfGreaterThan30(70);
        assertEquals(true, result);
    }


}