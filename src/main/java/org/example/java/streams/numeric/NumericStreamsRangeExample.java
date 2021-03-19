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
    IntStream intStreamRangeCount = IntStream.range(1, 50);
    System.out.println("Count: " + intStreamRangeCount.count());
    IntStream.range(1, 50).forEach((value) -> System.out.print(value + ", "));

    /*
     * rangeClosed()
     */
    System.out.println("\n\n=== rangeClosed() ===");
    IntStream intStreamRangeClosedCount = IntStream.rangeClosed(1, 50);
    System.out.println("Count: " + intStreamRangeClosedCount.count());
    IntStream.rangeClosed(1, 50).forEach((value) -> System.out.print(value + ", "));
  }
}
