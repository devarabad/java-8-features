package org.example.java.functionalinterface;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * @see java.util.function.BinaryOperator
 */
public class BinaryOperatorExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    BinaryOperator<Integer> binaryOperator = (numA, numB) ->
      {
        return numA * numB;
      };

    Integer result = binaryOperator.apply(5, 3);
    System.out.println(result);


    /**
     * Sample Use Cases
     */
    Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
    BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comparator);
    System.out.println("Result of maxBy is " + maxBy.apply(3, 12));

    BinaryOperator<Integer> minBy = BinaryOperator.minBy(comparator);
    System.out.println("Result of minBy is " + minBy.apply(3, 12));
  }
}
