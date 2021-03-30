package org.example.java.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamsMaxExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     *  - Returns the maximum element of this stream according to the provided Comparator
     */
    List<Integer> integerList             = Arrays.asList(7, 1, 6, 31, 59, 11, 8, 2, 10, 4);

    Optional<Integer> maxInteger          = integerList.stream().max(Comparator.naturalOrder());
    System.out.println("Max value is: " + maxInteger);

    Optional<Integer> maxIntegerReversed  = integerList.stream().max(Comparator.reverseOrder());
    System.out.println("Max value in reversed is: " + maxIntegerReversed);
  }
}
