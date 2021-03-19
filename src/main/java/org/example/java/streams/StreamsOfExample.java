package org.example.java.streams;

import java.util.stream.Stream;

public class StreamsOfExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    Stream<String> stringStream = Stream.of("Joe", "Peter", "Stewie");
    stringStream.forEach(System.out::println);
  }
}
