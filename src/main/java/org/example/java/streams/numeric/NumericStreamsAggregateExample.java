package org.example.java.streams.numeric;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class NumericStreamsAggregateExample
{
  public static void main(String[] args)
  {
    /**
     * Base Usage
     */
    /*
     * sum()
     */
    int sum = IntStream.rangeClosed(1, 50).sum();
    System.out.println("sum: " + sum);

    /*
     * max()
     */
    OptionalInt max = IntStream.rangeClosed(1, 50).max();
    System.out.println("max: " + max);

    /*
     * min()
     */
    OptionalInt min = IntStream.rangeClosed(1, 50).min();
    System.out.println("min: " + min);

    /*
     * average()
     */
    OptionalDouble average = IntStream.rangeClosed(1, 50).average();
    System.out.println("average: " + average);
  }
}
