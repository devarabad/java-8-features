package org.example.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsReduceExample
{
  public static int performMultiplication(List<Integer> integerList)
  {
    /**
     * Basic Usage
     *  - Used to reduce the contents of a stream to a single value
     *  - This is a **terminal operation**
     *  - It takes two parameters as an input
     *     First parameter   - default or initial value
     *     Second parameter  - BinaryOperator<T>
     */
    return integerList
             .stream()                             // in:List<Integer> -> out:Stream<Integer>
              /*  [1, 3, 5, 7]
               *
               *  a=1   [initial] , b=1 [from stream] -> result is 1*1  = 1
               *  a=1   [result]  , b=3 [from stream] -> result is 1*3  = 3
               *  a=3   [result]  , b=5 [from stream] -> result is 3*5  = 15
               *  a=15  [result]  , b=7 [from stream] -> result is 15*7 = 105
               */
             .reduce(1, (a, b) -> a * b);
  }

  public static Optional<Integer> performMultiplicationWithoutIdentity(List<Integer> integerList)
  {
    return integerList
             .stream()
             .reduce((a, b) -> a * b);
  }

  public static void main(String[] args)
  {
    List<Integer> integerList = Arrays.asList(1, 3, 5, 7);
    System.out.println(performMultiplication(integerList));

    /**
     * If a value is present in this Optional, returns the value,
     * otherwise throws NoSuchElementException.
     */
    Optional<Integer> optionalInteger = performMultiplicationWithoutIdentity(integerList);
    boolean integerPresent            = optionalInteger.isPresent();  // Validate if integerList has values
    Integer optionalIntegerValue      = optionalInteger.get();        // Returns the multiplication result
    System.out.println(integerPresent);
    System.out.println(optionalIntegerValue);

    List<Integer> emptyIntegerList          = new ArrayList<>();
    Optional<Integer> optionalEmptyInteger  = performMultiplicationWithoutIdentity(emptyIntegerList);
    boolean emptyIntegerPresent             = optionalEmptyInteger.isPresent();
    Integer optionalEmptyIntegerValue       = optionalEmptyInteger.get();
    System.out.println(emptyIntegerPresent);
    System.out.println(optionalEmptyIntegerValue);
  }
}
