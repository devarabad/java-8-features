package org.example.java.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeFormatterExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    LocalDate localDate               = LocalDate.now();
    DateTimeFormatter ldFormatter     = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    String ldText                     = localDate.format(ldFormatter);
    LocalDate parsedLocalDate         = LocalDate.parse(ldText, ldFormatter);

    LocalTime localTime               = LocalTime.now();
    DateTimeFormatter ltFormatter     = DateTimeFormatter.ofPattern("H:mm:ss:n");
    String ltText                     = localTime.format(ltFormatter);
    LocalTime parsedLocalTime         = LocalTime.parse(ltText, ltFormatter);

    LocalDateTime localDateTime       = LocalDateTime.now();
    DateTimeFormatter ldtFormatter    = DateTimeFormatter.ofPattern("yyyy/MM/dd H:mm:ss:n");
    String ldtText                    = localDateTime.format(ldtFormatter);
    LocalDateTime parsedLocalDateTime = LocalDateTime.parse(ldtText, ldtFormatter);

    System.out.println("LocalDate                 : " + localDate);
    System.out.println("LocalDate Text Format     : " + ldText);
    System.out.println("Parsed LocalDate          : " + parsedLocalDate);

    System.out.println("LocalTime                 : " + localTime);
    System.out.println("LocalTime Text Format     : " + ltText);
    System.out.println("Parsed LocalTime          : " + parsedLocalTime);

    System.out.println("LocalDateTime             : " + localDateTime);
    System.out.println("LocalDateTime Text Format : " + ldText);
    System.out.println("Parsed LocalDateTime      : " + parsedLocalDateTime);

    /**
     * Other Use Cases
     */
    ZonedDateTime zonedDateTime     = ZonedDateTime.now();
    System.out.println("\n==========");
    System.out.println("zonedDateTime               : " + zonedDateTime);
    System.out.println("ISO_ZONED_DATE_TIME         : " + zonedDateTime.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
    System.out.println("ISO_DATE_TIME               : " + zonedDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
    System.out.println("ISO_DATE                    : " + zonedDateTime.format(DateTimeFormatter.ISO_DATE));
    System.out.println("ISO_TIME                    : " + zonedDateTime.format(DateTimeFormatter.ISO_TIME));
    System.out.println("ofLocalizedDateTime (FULL)  : " + zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
    System.out.println("ofLocalizedDateTime (LONG)  : " + zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)));
    System.out.println("ofLocalizedDateTime (MEDIUM): " + zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
    System.out.println("ofLocalizedDateTime (SHORT) : " + zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));

    /*
     * Output
     * ==========
     * zonedDateTime               : 2021-03-30T14:00:22.344+08:00[Asia/Manila]
     * ISO_ZONED_DATE_TIME         : 2021-03-30T14:00:22.344+08:00[Asia/Manila]
     * ISO_DATE_TIME               : 2021-03-30T14:00:22.344+08:00[Asia/Manila]
     * ISO_DATE                    : 2021-03-30+08:00
     * ISO_TIME                    : 14:00:22.344+08:00
     * ofLocalizedDateTime (FULL)  : Tuesday, March 30, 2021 2:00:22 PM PST
     * ofLocalizedDateTime (LONG)  : March 30, 2021 2:00:22 PM PST
     * ofLocalizedDateTime (MEDIUM): 03 30, 21 2:00:22 PM
     * ofLocalizedDateTime (SHORT) : 3/30/21 2:00 PM
     */

    System.out.println("\n==========");
    System.out.println("localDateTime       : " + localDateTime);
    System.out.println("ISO_LOCAL_DATE_TIME : " + localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    System.out.println("ISO_LOCAL_DATE_TIME : " + localDateTime.format(DateTimeFormatter.ISO_DATE));
    System.out.println("ISO_LOCAL_DATE_TIME : " + localDateTime.format(DateTimeFormatter.ISO_TIME));

    /*
     * This will throw an error as LocalDateTime does not have any zones
     * Note:
     *  - Please be aware on the kind of format when using the DateFormatter with LocalDate, LocalTime and LocalDateTime
     */
    // System.out.println("ISO_LOCAL_DATE_TIME : " + localDateTime.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));

    /*
     * Output
     * ==========
     * localDateTime       : 2021-03-30T14:00:22.358
     * ISO_LOCAL_DATE_TIME : 2021-03-30T14:00:22.358
     * ISO_LOCAL_DATE_TIME : 2021-03-30
     * ISO_LOCAL_DATE_TIME : 14:00:22.358
     */
  }
}
