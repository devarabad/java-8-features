package org.example.java.streams;

import java.util.stream.Stream;

public class StreamsIterateExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     *
     * Note:
     *  - Be wary when doing for each on infinite streams as it may cause infinite consumes
     */
    Stream
      .iterate(1, x -> x*2)
      .limit(10)                        // Used the limit operation so to not iterate infinitely
      .forEach(System.out::println);    // This will iterate infinitely when limit is disabled
  }
}
