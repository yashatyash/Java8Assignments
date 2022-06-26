package com.yash.java8assignments.Ques16;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateOperations {

    public String dateConversion(String date) throws Exception {
        int dd,mm,yyyy;
        String dateString;
        String[] dates = date.split("[ ./-]");
        int[] d = new int[dates.length];
        for (int i =0;i< dates.length;i++)
        {
            d[i]=Integer.parseInt(dates[i]);
        }
        dd=d[0];
        mm=d[1];
        yyyy=d[2];

        if (dd<=31&&mm<=12&&yyyy<=new GregorianCalendar().get(Calendar.YEAR))
        {
            if (Integer.toString(yyyy).length()==4)
                dateString=new SimpleDateFormat("dd/MM/yyyy").format(Date.valueOf(LocalDate.of(yyyy,mm,dd)));
            else
                throw new Exception("Invalid Entry in Year");
        }
        else
            throw new Exception("Invalid Entry");
        return dateString;
    }

    public LocalDate stringToDate(String dateString)
    {
        if (dateString!=null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
            return LocalDate.parse(dateString, formatter);
        }
        else
            return null;
    }
}