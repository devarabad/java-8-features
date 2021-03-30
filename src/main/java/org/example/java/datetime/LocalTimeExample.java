package org.example.java.datetime;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalTimeExample
{
  public static void main(String[] args)
  {
    /*
     * now() - Obtains the current time from the system clock in the default time-zone
     */
    LocalTime localTime = LocalTime.now();
    System.out.println("localTime now() : " + localTime);

    /*
     * of() - Obtains an instance of LocalTime from an hour, minute and second
     *      - @see other arguments
     */
    LocalTime localTimeOf       = LocalTime.of(23,33);
    LocalTime localTimeWithSec  = LocalTime.of(23,33, 33);
    LocalTime localTimeWithNano = LocalTime.of(23,33, 33, 999888777);
    System.out.println("localTime of(hh,mm)       : " + localTimeOf);
    System.out.println("localTime of(hh,mm,ss)    : " + localTimeWithSec);
    System.out.println("localTime of(hh,mm,ss,ns) : " + localTimeWithNano);

    /*
     * toSecondOfDay() - Extracts the time as seconds of day, from 0 to 24 * 60 * 60 - 1
     */
    int localTimeToSecondOfDay = localTime.toSecondOfDay();
    System.out.println("localTime toSecondOfDay : " + localTimeToSecondOfDay);

    /*
     * until() - Calculates the amount of time until another time in terms of the specified unit
     *         - same with Duration.between()
     */
    long durationUntil = localTime.until(localTimeOf, ChronoUnit.MINUTES);
    System.out.println("Minutes until " + localTime + " : " + durationUntil);

    /*
     * Getting the time values from LocalTime instance
     */
    int hour            = localTime.getHour();
    int minute          = localTime.getMinute();
    int second          = localTime.getSecond();
    int nanoSecond      = localTime.getNano();
    int clockHourOfDay  = localTime.get(ChronoField.CLOCK_HOUR_OF_DAY);

    System.out.println("Hour              : " + hour);
    System.out.println("Minute            : " + minute);
    System.out.println("Second            : " + second);
    System.out.println("Nano Second       : " + nanoSecond);
    System.out.println("Clock Hour of Day : " + clockHourOfDay);

    /*
     * Modifying time values from LocalTime instance
     *
     * Note:
     *   - LocalTime is immutable, so it will not change the actual instance created initially
     */
    LocalTime newLocalTimeMinusHours      = localTime.minusHours(2);
    LocalTime newLocalTimePlusMins        = localTime.plusMinutes(45);
    LocalTime newLocalTimeMinus           = localTime.minus(3, ChronoUnit.HOURS);
    LocalTime newLocalTimeWith            = localTime.with(LocalTime.MIDNIGHT);
    LocalTime newLocalTimeWithHour        = localTime.withHour(3);
    LocalTime newLocalTimeWithChronoField = localTime.with(ChronoField.HOUR_OF_DAY, 22);

    System.out.println("localTime Actual Instance   : " + localTime);
    System.out.println("localTime - hours           : " + newLocalTimeMinusHours);
    System.out.println("localTime + mins            : " + newLocalTimePlusMins);
    System.out.println("localTime - ChronoUnit      : " + newLocalTimeMinus);
    System.out.println("localTime with MIDNIGHT     : " + newLocalTimeWith);
    System.out.println("localTime with HOUR         : " + newLocalTimeWithHour);
    System.out.println("localTime with ChronoField  : " + newLocalTimeWithChronoField);

    /*
     * Additional Support Methods
     */
    boolean isBeforeLocalTime = localTime.isBefore(localTimeOf);
    boolean isAfterLocalTime  = localTime.isAfter(localTimeOf);

    System.out.println(localTime + " isBefore " + localTimeOf + " : " + isBeforeLocalTime);
    System.out.println(localTime + " isAfter  " + localTimeOf + " : " + isAfterLocalTime);

    // Since this is a LocalTime instance and not a LocalDate, it returns false as ChronoUnit.DAYS is not supported by LocalTime
    boolean isSupportedChronoUnitDays  = localTime.isSupported(ChronoUnit.DAYS);
    boolean isSupportedChronoUnitMins  = localTime.isSupported(ChronoUnit.MINUTES);

    System.out.println("localTime isSupported ChronoUnit.DAYS     : " + isSupportedChronoUnitDays); // returns false
    System.out.println("localTime isSupported ChronoUnit.MINUTES  : " + isSupportedChronoUnitMins); // returns true
  }
}
