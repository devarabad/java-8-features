package org.example.java.lambda;

import java.util.Comparator;

public class ComparatorLambdaExample
{
  public static void main(String[] args)
  {
    /**
     * Typical Java
     */
    Comparator<Integer> comparator = new Comparator<Integer>()
    {
      @Override
      public int compare(Integer o1, Integer o2)
      {
        return o1.compareTo(o2);  // o1 == o2 returns 0
                                  // o1 >  o2 returns 1
                                  // o1 <  o2 returns -1
      }
    };

    System.out.println("Result of the comparator is: " + comparator.compare(3, 2));


    /**
     * Java 8 Lambda
     * @see java.util.Comparator
     */
    Comparator<Integer> comparatorLambda = (Integer a, Integer b) -> a.compareTo(b);
    System.out.println("Result of the comparator using Lambda is: " + comparator.compare(3, 2));

    /*
     * Lambda - Non Type
     */
    Comparator<Integer> comparatorLambdaNonType = (a, b) -> a.compareTo(b);
    System.out.println("Result of the comparator using Lambda (NonType) is: " + comparatorLambdaNonType.compare(3, 2));
  }
}
