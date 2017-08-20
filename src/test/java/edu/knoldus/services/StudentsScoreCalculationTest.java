package edu.knoldus.services;

import static org.junit.Assert.*;
import edu.knoldus.models.Calculator;
import edu.knoldus.models.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
/*
import static org.easymock.EasyMock.expect;
import static org.powermock.api.easymock.PowerMock.mockStatic;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Calculator.class })
*/
public class StudentsScoreCalculationTest extends Mockito implements StudentsScoreCalculation{

    private String[] subjectsArray = {"Java", "Scala", "Play", "Akka"};
    private double[] marks1 = {55, 75, 88, 62};
    Student student = new Student(1, "Divya", subjectsArray, marks1);

    @Test
    public void isEligibleTest(){
        Calculator calculator = Mockito.mock(Calculator.class);
        when(calculator.checkIfGreaterThan30(55)).thenReturn(true);
        when(calculator.checkIfGreaterThan30(75)).thenReturn(true);
        when(calculator.checkIfGreaterThan30(85)).thenReturn(true);
        when(calculator.checkIfGreaterThan30(65)).thenReturn(true);

        boolean result = StudentsScoreCalculation.isEligible(student);
        assertTrue (result);
    }

}