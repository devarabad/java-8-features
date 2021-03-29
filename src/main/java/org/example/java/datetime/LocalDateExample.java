package org.example.java.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.chrono.Era;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class LocalDateExample
{
  public static void main(String[] args)
  {
    /*
     * now() - Obtains the current date from the system clock in the default time-zone
     */
    LocalDate localDate = LocalDate.now();
    System.out.println("localDate now() : " + localDate);

    /*
     * of() - Obtains an instance of LocalDate from a year, month and day
     *      - @see other arguments
     */
    LocalDate localDateOf = LocalDate.of(2021, 3, 29);
    System.out.println("localDate of() : " + localDateOf);

    /*
     * ofYearDay() - Obtains an instance of LocalDate from a year and day-of-year.
     */
    LocalDate localDateOfYearDay  = LocalDate.ofYearDay(2021, 365);
    LocalDate localDateOfYearDay2 = LocalDate.ofYearDay(2021, 2);
    System.out.println("localDate ofYearDay() : " + localDateOfYearDay);
    System.out.println("localDate ofYearDay() : " + localDateOfYearDay2);

    /*
     * Getting LocalDate values
     */
    int year                    = localDate.getYear();
    int monthValue              = localDate.getMonthValue();
    int dayOfMonth              = localDate.getDayOfMonth();
    int dayOfYear               = localDate.getDayOfYear();
    int dayOfWeekValue          = localDate.get(ChronoField.DAY_OF_WEEK);
    DayOfWeek dayOfWeek         = localDate.getDayOfWeek();
    Month month                 = localDate.getMonth();
    Era era                     = localDate.getEra();

    String dayOfWeekDisplayName = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault());
    String monthDisplayName     = month.getDisplayName(TextStyle.FULL, Locale.getDefault());
    String eraDisplayName       = era.getDisplayName(TextStyle.FULL, Locale.getDefault());

    System.out.println("Year                      : " + year);
    System.out.println("Month Value               : " + monthValue);
    System.out.println("Day of Month              : " + dayOfMonth);
    System.out.println("Day of Year               : " + dayOfYear);
    System.out.println("Month DisplayName         : " + monthDisplayName);
    System.out.println("Day Of Week Display Name  : " + dayOfWeekDisplayName);
    System.out.println("Day Of Week using get()   : " + dayOfWeekValue);
    System.out.println("Era Display Name          : " + eraDisplayName);

    /*
     * Modifying LocalDate values
     *
     * Note:
     *   - LocalDate is immutable, so it will not change the actual instance created initially
     */
    LocalDate newLocalDatePlusDays              = localDate.plusDays(2);
    LocalDate newLocalDatePlusMos               = localDate.plusMonths(2);
    LocalDate newLocalDateMinusYrs              = localDate.minusYears(1);
    // Returns a copy of this date with the specified field set to a new value
    LocalDate newLocalDateWithChronoField       = localDate.with(ChronoField.YEAR, 2022);
    LocalDate newLocalDateWithTemporalAdjusters = localDate.with(TemporalAdjusters.lastDayOfMonth());
    LocalDate newLocalDateMinus                 = localDate.minus(3, ChronoUnit.DAYS);

    System.out.println("localDate Actual Instance               : " + localDate);
    System.out.println("localDate + days                        : " + newLocalDatePlusDays);
    System.out.println("localDate + months                      : " + newLocalDatePlusMos);
    System.out.println("localDate - years                       : " + newLocalDateMinusYrs);
    System.out.println("localDate with ChronoField              : " + newLocalDateWithChronoField);
    System.out.println("localDate with ChronoField (DayOfWeek)  : " + newLocalDateWithChronoField.getDayOfWeek());
    System.out.println("localDate with Temporal Adjusters       : " + newLocalDateWithTemporalAdjusters);
    System.out.println("localDate - ChronoUnit                  : " + newLocalDateMinus);

    /*
     * Additional Support Methods
     */
    boolean isLeapYear            = localDate.isLeapYear();
    boolean isEqualLocalDate      = localDate.isEqual(localDateOf);
    boolean isBeforeLocalDate     = localDate.isBefore(localDateOf);
    boolean isAfterLocalDate      = localDate.isAfter(localDateOf);

    System.out.println("localDate isLeapYear()         : " + isLeapYear);
    System.out.println("2022 isLeapYear()              : " + LocalDate.ofYearDay(2024, 1).isLeapYear());
    System.out.println(localDate + " isEqual  " + localDateOf + " : " + isEqualLocalDate);
    System.out.println(localDate + " isBefore " + localDateOf + " : " + isBeforeLocalDate);
    System.out.println(localDate + " isAfter  " + localDateOf + " : " + isAfterLocalDate);

    // Since this is a LocalDate instance and not a LocalTime, it returns false as ChronoUnit.HOURS is not supported by LocalDate
    boolean isSupportedChronoUnitHours  = localDate.isSupported(ChronoUnit.HOURS);
    boolean isSupportedChronoUnitYears  = localDate.isSupported(ChronoUnit.YEARS);

    System.out.println("localDate isSupported ChronoUnit.HOURS : " + isSupportedChronoUnitHours); // returns false
    System.out.println("localDate isSupported ChronoUnit.YEARS : " + isSupportedChronoUnitYears); // returns true
  }
}
