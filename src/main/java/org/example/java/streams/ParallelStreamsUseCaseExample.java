package org.example.java.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamsUseCaseExample
{
  public static void main(String[] args)
  {
    /**
     * In this example, the sequential stream is faster than the parallel stream.
     * The parallel stream performs the unboxing from Integer to int (behind the scenes) w/c
     * takes more processing than the sequential operation
     *
     * Note:
     *  - Always perform checks on the performance of sequential and parallel streams.
     */
    System.out.println("=== Example 1 ===");

    SumBoxing sumBoxing = new SumBoxing();
    List<Integer> integerList = IntStream.rangeClosed(1, 10000)
                                  .boxed()
                                  .collect(Collectors.toList());

    sumBoxing.sequentialSum(integerList);
    sumBoxing.parallelSum(integerList);


    /**
     * In this example, the parallel stream is having inconsistent results while in
     * the sequential stream it performs the correct result.
     *
     * Using mutable objects can have different effects when performing in parallel as it does
     *  split the data and performs concurrently and then combine the result afterwards.
     *
     * Do be careful when using parallel streams.
     * Best to use parallel streams in stateless form.
     */
    System.out.println("\n=== Example 2 ===");

    // total is always = 500500
    for (int i=1; i<=5; i++)
    {
      Sum sum = new Sum();

      IntStream
        .rangeClosed(1, 1000)
        .forEach(sum::performSum);    // 1, 2, 3, ..., 1000

      System.out.println("(Mutable Objects) Sum total in sequential stream : " + sum.getTotal());
    }

    for (int i=1; i<=5; i++)
    {
      Sum sum = new Sum();

      IntStream
        .rangeClosed(1, 1000)
        .parallel()
        .forEach(sum::performSum);

      // total is inconsistent
      // 809890
      // 1158165
      // 1454175
      // 1709240
      // 2001798
      System.out.println("(Mutable Objects) Sum total in parallel stream : " + sum.getTotal());
    }
  }
}

class SumBoxing
{
  public int sequentialSum(List<Integer> integerList)
  {
    long startTime = System.currentTimeMillis();

    int sum = integerList
                .stream()
                .reduce(0, (x, y) -> x + y);

    long duration = System.currentTimeMillis() - startTime;
    System.out.println("(Boxed) Duration in sequential stream: " + duration + "ms");

    return sum;
  }

  public int parallelSum(List<Integer> integerList)
  {
    long startTime = System.currentTimeMillis();

    int sum = integerList
                .parallelStream()
                .reduce(0, (x, y) -> x + y);  // Performs the unboxing from Integer to int (behind the scenes)

    long duration = System.currentTimeMillis() - startTime;
    System.out.println("(Boxed) Duration in parallel stream: " + duration + "ms");

    return sum;
  }
}

class Sum
{
  private int total;

  public int getTotal()
  {
    return total;
  }

  public void setTotal(int total)
  {
    this.total = total;
  }

  public void performSum(int input)
  {
    total += input;
  }
}