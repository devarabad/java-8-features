package org.example.java.datetime;

import java.time.*;
import java.util.Set;

public class ZonedDateTimeExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    // ZoneDateTime
    ZonedDateTime zonedDateTime = ZonedDateTime.now();
    System.out.println("zonedDateTime : " + zonedDateTime);

    // ZoneOffset
    ZoneOffset zoneOffset = zonedDateTime.getOffset();
    System.out.println(zoneOffset);

    // ZoneId
    ZoneId zoneId = zonedDateTime.getZone();
    System.out.println(zoneId);


    /**
     * Use Cases
     */
    // Retrieve the available zones
    Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
    System.out.println("\n=== Available Zones ===");
    availableZoneIds.stream().sorted().forEach(System.out::println);

    // Get the ZonedDateTime of a specific ZoneId
    ZonedDateTime zonedDateTimeEuLisbon = ZonedDateTime.now(ZoneId.of("Europe/Lisbon"));
    ZonedDateTime zonedDateTimeEuZurich = ZonedDateTime.now(ZoneId.of("Europe/Zurich"));
    System.out.println("Europe/Lisbon : " + zonedDateTimeEuLisbon);
    System.out.println("Europe/Zurich : " + zonedDateTimeEuZurich);

    // Get the ZonedDateTime of a specific ZoneId using the System Clock
    ZonedDateTime zonedDateTimWithClockEuLisbon = ZonedDateTime.now(Clock.system(ZoneId.of("Europe/Lisbon")));
    System.out.println("Europe/Lisbon (using System Clock)  : " + zonedDateTimWithClockEuLisbon);

    // Get the ZonedDateTime of UTC Timezone
    ZonedDateTime zonedDateTimeUTC = ZonedDateTime.now(Clock.systemUTC());
    System.out.println(zoneId + " : " + zonedDateTime);
    System.out.println("UTC Timezone : " + zonedDateTimeUTC);

    // Get the LocalDateTime of a particular timezone
    LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Europe/Zurich"));
    System.out.println("localDateTime with Zone : " + localDateTime);

    // Get the LocalDateTime using Instant
    LocalDateTime localDateTimeOfInstant = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
    System.out.println("localDateTime using Instant : " + localDateTimeOfInstant);

    // Convert from LocalDateTime to ZonedDateTime
    LocalDateTime localDateTimeNow = LocalDateTime.now();
    ZonedDateTime fromLocalDateToZoneDateTime = localDateTimeNow.atZone(ZoneId.systemDefault());
    System.out.println("LocalDateTime (From)  : " + localDateTimeNow);
    System.out.println("ZonedDateTime (To)    : " + fromLocalDateToZoneDateTime);

    // Convert from Instant (since Epoch) to ZonedDateTime
    Instant instantNow                        = Instant.now();
    ZonedDateTime fromInstantToZonedDateTime  = instantNow.atZone(ZoneId.systemDefault());
    System.out.println("Instant (From)        : " + instantNow);
    System.out.println("ZonedDateTime (To)    : " + fromLocalDateToZoneDateTime);

    // Set the ZoneOffset of a LocalDateTime
    OffsetDateTime offsetDateTime = localDateTimeNow.atOffset(ZoneOffset.ofHours(-3));
    System.out.println("offsetDateTime : " + offsetDateTime);
  }
}
