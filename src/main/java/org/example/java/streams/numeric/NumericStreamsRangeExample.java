package org.example.java.streams.numeric;

import java.util.stream.IntStream;

public class NumericStreamsRangeExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    /*
     * range()
     */
    System.out.println("=== range() ===");
    IntStream intStreamRange = IntStream.range(1, 50);
    System.out.println("Count: " + intStreamRange.count());
    IntStream.range(1, 50).forEach((value) -> System.out.print(value + ", "));

    /*
     * rangeClosed()
     */
    System.out.println("\n\n=== rangeClosed() ===");
    IntStream intStreamRangeClosed = IntStream.rangeClosed(1, 50);
    System.out.println("Count: " + intStreamRangeClosed.count());
    IntStream.rangeClosed(1, 50).forEach((value) -> System.out.print(value + ", "));
  }
}
