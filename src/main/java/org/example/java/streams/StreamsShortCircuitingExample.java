package org.example.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsShortCircuitingExample
{
  public static void main(String[] args)
  {
    /**
     * Does not have to iterate the whole stream to evaluate the result
     */
    List<String> namesList  = Arrays.asList("John", "Frederick", "Dave", "Cindy", "Zack", "Anna", "Smith", "Sean");

    List<String> shortCircuitingList =
      namesList
        .stream()
        .limit(3)
        .peek(System.out::println)
        .collect(Collectors.toList());
  }
}
