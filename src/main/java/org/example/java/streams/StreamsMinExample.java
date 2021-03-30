package org.example.java.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamsMinExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     *  - Returns the minimum element of this stream according to the provided Comparator
     */
    List<Integer> integerList             = Arrays.asList(7, 1, 6, 31, 59, 11, 8, 2, 10, 4);

    Optional<Integer> minInteger          = integerList.stream().min(Comparator.naturalOrder());
    System.out.println("Min value is: " + minInteger);

    Optional<Integer> minIntegerReversed  = integerList.stream().min(Comparator.reverseOrder());
    System.out.println("Min value in reversed is: " + minIntegerReversed);
  }
}
