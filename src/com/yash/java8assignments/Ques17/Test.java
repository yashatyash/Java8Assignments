package com.yash.java8assignments.Ques17;

import com.yash.java8assignments.Ques16.DateOperations;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Locale;

public class Test {

    public static void main(String[] args) throws Exception {
        String dateString = new DateOperations().dateConversion("30 05 2021");
        System.out.println(dateString);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(dateString, formatter);
        System.out.println(date);
        int bdate = date.getDayOfMonth();
        Month bmonth = date.getMonth();
        LocalDate date2 = LocalDate.now();
        int currentDate = date2.getDayOfMonth();
        Month currentMonth = date2.getMonth();
        Year year = Year.of(date2.getYear());
        Long y = ChronoUnit.YEARS.between(date, date2);
        System.out.println(y);
    }
}
