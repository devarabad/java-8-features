package org.example.java.datetime;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class ComparingTimeDurationExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    LocalTime localTimeFrom = LocalTime.of(8, 30);
    LocalTime localTimeTo   = LocalTime.of(9, 20);

    /*
     * between() - Obtains a Duration representing the duration between two temporal objects
     *           - same with LocalDate.until()
     */
    Duration durationBetween  = Duration.between(localTimeFrom, localTimeTo);
    long noOfMinsBetween      = durationBetween.toMinutes();
    System.out.println("Minutes between " + localTimeFrom + " and " + localTimeTo + " : " + noOfMinsBetween);

    /*
     * same with between() - LocalTime.until()
     */
    long durationUntil = localTimeFrom.until(localTimeTo, ChronoUnit.MINUTES);
    System.out.println("Minutes until " + localTimeTo + " : " + durationUntil);

    /*
     * of() - Obtains a Period representing a number of years, months and days
     *      - @see other arguments
     */
    Duration durationOf         = Duration.of(45, ChronoUnit.MINUTES);
    Duration durationOfDays     = Duration.ofDays(1);
    Duration durationOfHours    = Duration.ofHours(3);
    Duration durationOfMinutes  = Duration.ofMinutes(1);
    Duration durationOfSeconds  = Duration.ofSeconds(1);

    System.out.println("Duration.of().toMillis()          : " + durationOf.toMillis());
    System.out.println("Duration.ofDays().toHours()       : " + durationOfDays.toHours());
    System.out.println("Duration.ofHours().toMinutes()    : " + durationOfHours.toMinutes());
    System.out.println("Duration.ofMinutes().getSeconds() : " + durationOfMinutes.getSeconds());
    System.out.println("Duration.ofSeconds().getNano()    : " + durationOfSeconds.toNanos());
  }
}
