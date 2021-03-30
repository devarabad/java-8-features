package org.example.java.datetime;

import java.time.Duration;
import java.time.Instant;

public class InstantExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    Instant instant = Instant.now();
    System.out.println(instant);

    // Jan 1, 1970 -> Epoch -> 86400 seconds
    System.out.println("getEpochSecond() : " + instant.getEpochSecond());

    // start of Epoch = 1970-01-01T00:00:00Z
    Instant instantOf = Instant.ofEpochSecond(0);
    System.out.println(instantOf);

    // Using Duration
    Instant instantTo         = Instant.now();
    Duration durationInstant  = Duration.between(instant, instantTo);
    long nanoSecondBetween    = durationInstant.getNano();

    System.out.println("Difference : " + nanoSecondBetween);
  }
}
