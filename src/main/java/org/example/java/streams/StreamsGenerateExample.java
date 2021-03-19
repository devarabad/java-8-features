package org.example.java.streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamsGenerateExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     *
     * Note:
     *  - Be wary when doing for each on infinite streams as it may cause infinite consumes
     */
    Supplier<Integer> integerSupplier = new Random()::nextInt;

    Stream
      .generate(integerSupplier)
      .limit(7)
      .forEach(System.out::println);  // This will iterate infinitely when limit is disabled
  }
}
