package org.example.java;

import java.util.stream.IntStream;

public class ImperativeVsDeclarativeExample1
{
  public static void main(String[] args)
  {
    /**
     * Imperative Style of Programming - How style of programming
     */
    int sumImp = 0;
    for (int i=0; i<=100; i++)
    {
      sumImp += i;
    }
    System.out.println("Sum using Imperative Approach: " + sumImp);


    /**
     * Declarative Style of Programming - What style of programming
     */
    int sumDec = IntStream.rangeClosed(0, 100).sum();
    System.out.println("Sum using Declarative Approach: " + sumDec);

    // With multi-threading
    int sumDecParallel = IntStream.rangeClosed(0, 100).parallel().sum();
    System.out.println("Sum using Declarative Approach (with Multi Threading): " + sumDecParallel);
  }
}
