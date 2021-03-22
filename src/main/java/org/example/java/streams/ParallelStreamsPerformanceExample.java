package org.example.java.streams;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreamsPerformanceExample
{
  public static int sumSequentialStream()
  {
    return IntStream.rangeClosed(1, 100000).sum();
  }

  public static int sumParallelStream()
  {
    return IntStream.rangeClosed(1, 100000).parallel().sum();
  }

  public static long checkPerformanceResult(Supplier<Integer> supplier, int numberOfTimes)
  {
    long startTime = System.currentTimeMillis();
    for (int i=0; i < numberOfTimes; i++)
    {
      supplier.get();
    }
    long endTime = System.currentTimeMillis();

    return endTime-startTime;
  }

  public static void main(String[] args)
  {
    System.out.println("Available Processors: " + Runtime.getRuntime().availableProcessors());

    long timeDiffSequential = checkPerformanceResult(ParallelStreamsPerformanceExample::sumSequentialStream, 20);
    System.out.println("Sequential Stream Result  : " + timeDiffSequential);

    long timeDiffParallel   = checkPerformanceResult(ParallelStreamsPerformanceExample::sumParallelStream, 20);
    System.out.println("Parallel Stream Result    : " + timeDiffParallel);
  }
}
