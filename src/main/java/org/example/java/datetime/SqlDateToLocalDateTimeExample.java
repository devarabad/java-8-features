package org.example.java.datetime;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public class SqlDateToLocalDateTimeExample
{
  public static void main(String[] args)
  {
    /*
     * java.sql.Date to LocalDateTime
     */
    Date sqlDate                  = new Date(System.currentTimeMillis());
    LocalDateTime frSqlDateToLdt  = sqlDate
                                      .toLocalDate()
                                      .atTime(LocalTime.now())
                                      .atZone(ZoneId.systemDefault())
                                      .toLocalDateTime();

    System.out.println("From java.sql.Date  : " + sqlDate);
    System.out.println("To LocalDateTime    : " + frSqlDateToLdt);

    /*
     * LocalDateTime to java.sql.Date
     */
    LocalDateTime localDateTime = LocalDateTime.now();
    Date frLdtToSqlDate         = Date.valueOf(localDateTime.toLocalDate());
    System.out.println("From LocalDateTime  : " + localDateTime);
    System.out.println("To java.sql.Date    : " + frLdtToSqlDate);
  }
}
