package org.example.java.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class LocalDateTimeExample
{
  public static void main(String[] args)
  {
    /*
     * now() - Obtains the current date-time from the system clock in the default time-zone
     */
    LocalDateTime localDateTime = LocalDateTime.now();
    System.out.println("localDateTime now() : " + localDateTime);

    /*
     * of() - Obtains an instance of LocalDateTime from year, month, day, hour, minute, second and nanosecond
     *      - @see other arguments
     */
    LocalDateTime localDateTimeOf     = LocalDateTime.of(2021, 04, 05, 0, 15, 30, 978);
    LocalDateTime localDateTimeOfLDLT = LocalDateTime.of(LocalDate.now(), LocalTime.now());
    System.out.println("localDateTime of(yyyy,MM,dd,hh,mm,ss,ns)  : " + localDateTimeOf);
    System.out.println("localDateTime of(LocalDate,LocalTime)     : " + localDateTimeOfLDLT);

    /*
     * Getting the date and time values from LocalDateTime instance
     */
    int year            = localDateTime.getYear();
    int monthValue      = localDateTime.getMonthValue();
    int dayOfMonth      = localDateTime.getDayOfMonth();
    int dayOfYear       = localDateTime.getDayOfYear();
    int dayOfWeekValue  = localDateTime.get(ChronoField.DAY_OF_WEEK);
    int hour            = localDateTime.getHour();
    int minute          = localDateTime.getMinute();
    int second          = localDateTime.getSecond();
    int nanoSecond      = localDateTime.getNano();
    int clockHourOfDay  = localDateTime.get(ChronoField.CLOCK_HOUR_OF_DAY);

    System.out.println("Year                      : " + year);
    System.out.println("Month                     : " + monthValue);
    System.out.println("Day of Month              : " + dayOfMonth);
    System.out.println("Day of Year               : " + dayOfYear);
    System.out.println("Day of Week               : " + dayOfWeekValue);
    System.out.println("Month DisplayName         : " + localDateTime.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault()));
    System.out.println("Day of Week Display Name  : " + localDateTime.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault()));
    System.out.println("Hour                      : " + hour);
    System.out.println("Minute                    : " + minute);
    System.out.println("Second                    : " + second);
    System.out.println("Nano Second               : " + nanoSecond);
    System.out.println("Clock Hour of Day         : " + clockHourOfDay);

    /*
     * Modifying date and time values from LocalDateTime instance
     *
     * Note:
     *   - LocalDateTime is immutable, so it will not change the actual instance created initially
     */
    LocalDateTime newLocalDtPlusDays              = localDateTime.plusDays(2);
    LocalDateTime newLocalDtPlusMos               = localDateTime.plusMonths(2);
    LocalDateTime newLocalDtMinusYrs              = localDateTime.minusYears(1);
    LocalDateTime newLocalDtWithChronoFieldDate   = localDateTime.with(ChronoField.YEAR, 2022);
    LocalDateTime newLocalDtWithTemporalAdjusters = localDateTime.with(TemporalAdjusters.lastDayOfMonth());
    LocalDateTime newLocalDtMinusDate             = localDateTime.minus(3, ChronoUnit.DAYS);
    LocalDateTime newLocalDtMinusHours            = localDateTime.minusHours(2);
    LocalDateTime newLocalDtPlusMins              = localDateTime.plusMinutes(45);
    LocalDateTime newLocalDtMinusTime             = localDateTime.minus(3, ChronoUnit.HOURS);
    LocalDateTime newLocalDtWith                  = localDateTime.with(LocalTime.MIDNIGHT);
    LocalDateTime newLocalDtWithHour              = localDateTime.withHour(3);
    LocalDateTime newLocalDtWithChronoFieldTime   = localDateTime.with(ChronoField.HOUR_OF_DAY, 22);

    System.out.println("localDateTime Actual Instance         : " + localDateTime);
    System.out.println("localDateTime + days                  : " + newLocalDtPlusDays);
    System.out.println("localDateTime + months                : " + newLocalDtPlusMos);
    System.out.println("localDateTime - years                 : " + newLocalDtMinusYrs);
    System.out.println("localDateTime with ChronoField (YEAR) : " + newLocalDtWithChronoFieldDate);
    System.out.println("localDateTime with Temporal Adjusters : " + newLocalDtWithTemporalAdjusters);
    System.out.println("localDateTime - ChronoUnit.DAYS       : " + newLocalDtMinusDate);
    System.out.println("localDateTime - hours                 : " + newLocalDtMinusHours);
    System.out.println("localDateTime + mins                  : " + newLocalDtPlusMins);
    System.out.println("localDateTime - ChronoUnit            : " + newLocalDtMinusTime);
    System.out.println("localDateTime with MIDNIGHT           : " + newLocalDtWith);
    System.out.println("localDateTime with HOUR               : " + newLocalDtWithHour);
    System.out.println("localDateTime with ChronoField        : " + newLocalDtWithChronoFieldTime);

    /*
     * Convert LocalDate to LocalDateTime - atTime()
     */
    LocalDate localDate                         = LocalDate.now();
    LocalDateTime frLocalDateToLDT               = localDate.atTime(LocalTime.now());
    LocalDateTime frLocalDateToLDTWithHrMinSecNs = localDate.atTime(23, 55, 30, 978);

    System.out.println("localDate                         : " + localDate);
    System.out.println("localDateTime atTime(LocalTime)   : " + frLocalDateToLDT);
    System.out.println("localDateTime atTime(hh,mm,ss,ns) : " + frLocalDateToLDTWithHrMinSecNs);

    /*
     * Convert LocalTime to LocalDateTime - atDate()
     */
    LocalTime localTime = LocalTime.now();
    LocalDateTime frLocalTimeToLDT = localTime.atDate(LocalDate.now());
    System.out.println("localTime                         : " + localDate);
    System.out.println("localDateTime atDate(LocalDate)   : " + frLocalTimeToLDT);

    /*
     * Convert LocalDateTime to LocalDate - toLocalDate()
     * Convert LocalDateTime to LocalTime - toLocalTime()
     */
    LocalDate toLocalDate = localDateTime.toLocalDate();
    LocalTime toLocalTime = localDateTime.toLocalTime();
    System.out.println("localDateTime toLocalDate() : " + toLocalDate);
    System.out.println("localDateTime toLocalTime() : " + toLocalTime);
  }
}
