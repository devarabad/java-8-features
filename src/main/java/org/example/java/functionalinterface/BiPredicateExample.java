package org.example.java.functionalinterface;

import org.example.java.data.Student;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * @see java.util.function.BiPredicate
 */
public class BiPredicateExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    BiPredicate<Integer, Double> biPredicate = (rate, score) ->
      {
        return rate >= 3 && score >= 70.0;
      };

    boolean biPredicateResult = biPredicate.test(4, 60.9);
    System.out.println(biPredicateResult);

    /*
     * Single line statement
     */
    BiPredicate<Integer, Double> biPredicateSingleLine = (rate, score) -> rate >= 3 && score >= 70.0;

    boolean biPredicateSingleLineResult = biPredicateSingleLine.test(5, 99.9);
    System.out.println(biPredicateSingleLineResult);
  }

}
