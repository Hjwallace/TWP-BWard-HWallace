package edu.bsu.cs222;

import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TimeZoneConverter {

    String timeStamp;
    public TimeZoneConverter(String t) {
        this.timeStamp = t;

    }

    public static void main(String[] args) {

        Calendar universalTime = new GregorianCalendar(TimeZone.getTimeZone("Universal"));
        int hour = universalTime.get(18);
        int minute = universalTime.get(30);
        int second = universalTime.get(23);
        int year = universalTime.get(1);

        System.out.printf("Universal time: %d: %d: %d %d\n", hour, minute, second, year);

        Calendar IndianapolisTime = new GregorianCalendar(TimeZone.getTimeZone("America/Indianapolis"));
        IndianapolisTime.setTimeInMillis(universalTime.getTimeInMillis());
        hour = IndianapolisTime.get(18);
        minute = IndianapolisTime.get(30);
        second = IndianapolisTime.get(23);
        year = IndianapolisTime.get(1);

        System.out.printf("Eastern time: %d: %d: %d %d\n", hour, minute, second, year);
    }
}
