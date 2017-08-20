package edu.knoldus.services;

import static org.junit.Assert.*;
import org.junit.Test;

public class DateAndTimeExampleTest {

    @Test
    public void ageOfPersonTest(){
        DateAndTimeExample dateAndTimeExample = new DateAndTimeExample();
        String result = dateAndTimeExample.ageOfPerson();

        assertEquals(result, "Your age is 21 years, 6 months & 26 days!");
    }

}