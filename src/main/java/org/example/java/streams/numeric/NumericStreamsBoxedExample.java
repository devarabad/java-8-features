package org.example.java.streams.numeric;

import java.util.stream.IntStream;

public class NumericStreamsBoxedExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    IntStream
      .rangeClosed(1, 3)              // IntStream : 10 elements
      .boxed()                        // in:int -> out:Integer
      .forEach(i ->
        {
          System.out.println(i + " (" + i.getClass() + ")");
        });
  }
}
