package org.example.java.streams.numeric;

import java.util.stream.IntStream;

public class NumericStreamsMapToDoubleExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    IntStream
      .rangeClosed(1, 3)
      .mapToDouble(i -> i)              // in:IntStream -> out:DoubleStream
      .forEach(System.out::println);
  }
}
