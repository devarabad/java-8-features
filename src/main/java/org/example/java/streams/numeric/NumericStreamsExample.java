package org.example.java.streams.numeric;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamsExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    int sumOfIntNumbers       = IntStream.rangeClosed(1, 6).sum();
    System.out.println("Sum of n numbers (IntStream): " + sumOfIntNumbers);

    long sumOfLongNumbers     = LongStream.of(1, 2, 3, 4, 5, 6).sum();
    System.out.println("Sum of n numbers (LongStream): " + sumOfLongNumbers);

    double sumOfDoubleNumbers = DoubleStream.of(1, 2, 3, 4, 5, 6).sum();
    System.out.println("Sum of n numbers (DoubleStream): " + sumOfDoubleNumbers);


    /**
     * Comparison to Streams
     */
    List<Integer> integerList     = Arrays.asList(1, 2, 3, 4, 5, 6);
    Integer sumOfIntNumbersStream = integerList
                                      .stream()
                                      .reduce(0, Integer::sum);       // unboxing operation to convert the Integer to int
    System.out.println("Sum of n numbers (Stream): " + sumOfIntNumbersStream);
  }
}
