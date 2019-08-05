package assignment5.DateTime;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;

/**
 * 1.     Which class would you use to store your birthday in years, months, days, seconds, and nanoseconds?
 * -> LocalDateTime
 * 2.     Given a random date, how would you find the date of the previous Thursday?
 * -> take current time, add until dayIsThursday is true, then subtract 7 days.
 * 3.     What is the difference between a ZoneId and a ZoneOffset?
 * -> ZoneID yields the various time zones whereas ZoneOffset refers to the absolute offset from GMT/UTC.
 * 4.     How would you convert an Instant to a ZonedDateTime? How would you convert a ZonedDateTime to an Instant?
 * -> Instant to ZoneDateTime using Instant.atZone method together with ZoneId: ZoneDateTime zdt = Instant.now().atZone(ZoneId.systemDefault());
 * -> ZoneDateTime to Instant using ChronoZoneDateTime interface, implemented by ZoneDateTime class = Instant inst = ZoneDateTime.now.toInstant();
 */

public class DateTime {
    private final int year = 2019;
    private final int month = 8;
    private final int day = 5;

    public static Boolean queryFrom(TemporalAccessor date) {
        return ((date.get(ChronoField.DAY_OF_MONTH) == 13) && (date.get(ChronoField.DAY_OF_WEEK) == 5));
    }

    public static void main(String[] args) {
        //5
        final int year = 0;
        Month month1 = Month.AUGUST;
        System.out.printf("For the year %d:%n", year);
        for (Month month : Month.values()) {
            YearMonth ym = YearMonth.of(year, month);
            System.out.printf("%s: %d days%n", month, ym.lengthOfMonth());
        }
        System.out.println();


        //6
        System.out.printf("For the month of %s:%n", month1);
        LocalDate date = Year.now().atMonth(month1).atDay(1).
                with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        Month mi = date.getMonth();
        while (mi == month1) {
            System.out.printf("%s%n", date);
            date = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            mi = date.getMonth();
        }
        System.out.println();


        //7
        System.out.println("Current day is Friday 13?" + queryFrom(date));
    }
}
