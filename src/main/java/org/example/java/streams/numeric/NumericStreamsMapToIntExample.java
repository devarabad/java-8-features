package org.example.java.streams.numeric;

import java.util.Arrays;
import java.util.List;

public class NumericStreamsMapToIntExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    List<Integer> integerList = Arrays.asList(1, 2, 3);

    integerList
      .stream()                       // in:List<Integer>   -> out:Stream<Integer>
      .mapToInt(Integer::intValue)    // in:Stream<Integer> -> out: IntStream       : Integer (Wrapper) -> returns int (Primitive)
      .forEach(System.out::println);
  }
}