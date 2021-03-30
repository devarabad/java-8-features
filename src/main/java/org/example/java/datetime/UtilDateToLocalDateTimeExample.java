package org.example.java.datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class UtilDateToLocalDateTimeExample
{
  public static void main(String[] args)
  {
    /*
     * java.util.Date to LocalDateTime
     */
    Date utilDate                 = new Date();
    LocalDateTime frUtilDateToLdt = utilDate
                                    .toInstant()
                                    .atZone(ZoneId.systemDefault())
                                    .toLocalDateTime();

    System.out.println("From java.util.Date : " + utilDate);
    System.out.println("To LocalDateTime    : " + frUtilDateToLdt);

    /*
     * LocalDateTime to java.util.Date
     */
    LocalDateTime localDateTime = LocalDateTime.now();
    Date frLdtToUtilDate        = Date.from(localDateTime
                                              .atZone(ZoneId.systemDefault())
                                              .toInstant());

    System.out.println("From LocalDateTime  : " + localDateTime);
    System.out.println("To java.util.Date   : " + frLdtToUtilDate);
  }
}
