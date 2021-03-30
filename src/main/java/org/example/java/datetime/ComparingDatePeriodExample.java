package org.example.java.datetime;

import java.time.LocalDate;
import java.time.Period;

public class ComparingDatePeriodExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    LocalDate localDateFrom = LocalDate.of(2021, 1, 1);
    LocalDate localDateTo   = LocalDate.of(2021, 1, 31);

    /*
     * between() - Obtains a Period consisting of the number of years, months, and days between two dates
     *           - same with LocalDate.until()
     */
    Period periodBetween  = Period.between(localDateFrom, localDateTo);
    int noOfDaysBetween   = periodBetween.getDays();
    int noOfYearsBetween  = periodBetween.getYears();

    System.out.println("Days between " + localDateFrom + " and " + localDateTo + " : " + noOfDaysBetween);
    System.out.println("Years between " + localDateFrom + " and " + localDateTo + " : " + noOfYearsBetween);

    /*
     * same with between() - LocalDate.until()
     */
    Period periodUntil    = localDateFrom.until(localDateTo);
    int noOfDaysUntil     = periodUntil.getDays();
    int noOfYearsUntil    = periodUntil.getYears();
    System.out.println("Days until " + localDateTo + " : " + noOfDaysUntil);
    System.out.println("Years until " + localDateTo + " : " + noOfYearsUntil);

    /*
     * of() - Obtains a Period representing a number of years, months and days
     *      - @see other arguments
     */
    Period periodOf       = Period.of(2021, 12, 25);
    Period periodOfDays   = Period.ofDays(10);
    Period periodOfYears  = Period.ofYears(20);

    System.out.println("Period.of()           : " + periodOf.getDays());
    System.out.println("Period.ofDays()       : " + periodOfDays.getDays());
    System.out.println("Period.ofYears()      : " + periodOfYears.getYears());
    System.out.println("Period.toTotalMonths  : " + periodOfYears.toTotalMonths()); // returns the total months of the given years
  }
}
