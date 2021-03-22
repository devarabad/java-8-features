package org.example.java.streams;

import java.util.stream.IntStream;

public class ParallelStreamsExample
{
  public static void main(String[] args)
  {
    /**
     * Sequential Stream
     */
    int sumSequential = IntStream.rangeClosed(1, 100000).sum();
    System.out.println("Sum (sequential): " + sumSequential);

    /**
     * Parallel Stream
     */
    int sumParallel   = IntStream.range(1, 100000).parallel().sum();
    System.out.println("Sum (parallel): " + sumSequential);
  }
}
