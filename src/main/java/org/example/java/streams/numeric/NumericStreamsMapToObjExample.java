package org.example.java.streams.numeric;

import java.util.stream.IntStream;

public class NumericStreamsMapToObjExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    IntStream
      .rangeClosed(1, 3)
      .mapToObj(i ->                  // in:IntStream -> out:Stream<Object> : integer as an input -> returns DoubleObj
          {
            return new Double(i);
          })
      .forEach(i ->
          {
            System.out.println(i + " (" + i.getClass() + ")");
          });
  }
}
