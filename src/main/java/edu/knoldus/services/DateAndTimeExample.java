package edu.knoldus.services;

import java.time.*;

class DateAndTimeExample {

    String ageOfPerson(){
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = LocalDate.of(1996,1,25);

        Period period = Period.between(birthDate, currentDate);
        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();
        return "Your age is " + years + " years, " + months + " months & " + days + " days!";
    }



}

