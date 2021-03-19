package org.example.java.streams.numeric;

import java.util.stream.IntStream;

public class NumericStreamsMapToLongExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    IntStream
      .rangeClosed(1, 3)
      .mapToLong(i -> i)              // in:IntStream -> out:LongStream
      .forEach(System.out::println);
  }
}
