package org.example.java.functionalinterface;

import java.util.function.Predicate;

/**
 * @see java.util.function.Predicate
 */
public class PredicateExample
{
  static Predicate<Integer> predicateDivisibleBy2 = (i) -> i % 2 == 0;
  static Predicate<Integer> predicateDivisibleBy5 = (i) -> i % 5 == 0;

  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    Predicate<Integer> predicate = (i) ->
      {
        return i % 2 == 0;
      };

    boolean predicateResult = predicate.test(2);
    System.out.println(predicateResult);

    /*
     * Single line statement
     */
    Predicate<Integer> predicateSingleLine = (i) -> i%2 == 0;

    boolean predicateSingleLineResult = predicateSingleLine.test(2);
    System.out.println(predicateSingleLineResult);


    /**
     * Operators (with Sample Use Cases)
     */
    predicateAnd();
    predicateOr();
    predicateNegate();
  }

  public static void predicateAnd()
  {
    System.out.println("\n===predicateAnd===");

    boolean predicateResult   = predicateDivisibleBy2.and(predicateDivisibleBy5).test(10);  // Predicate chaining
    boolean predicateResult2  = predicateDivisibleBy2.and(predicateDivisibleBy5).test(8);   // Predicate chaining
    System.out.println("Predicate AND (Divisible by 2 and 5) : " + predicateResult);
    System.out.println("Predicate AND (Divisible by 2 and 5) : " + predicateResult2);
  }

  public static void predicateOr()
  {
    System.out.println("\n===predicateOr===");

    boolean predicateResult   = predicateDivisibleBy2.or(predicateDivisibleBy5).test(10);  // Predicate chaining
    boolean predicateResult2  = predicateDivisibleBy2.or(predicateDivisibleBy5).test(8);   // Predicate chaining
    System.out.println("Predicate OR (Divisible by 2 and 5) : " + predicateResult);
    System.out.println("Predicate OR (Divisible by 2 and 5) : " + predicateResult2);
  }

  public static void predicateNegate()
  {
    System.out.println("\n===predicateNegate===");

    boolean predicateResult   = predicateDivisibleBy2.or(predicateDivisibleBy5).negate().test(10);  // Predicate chaining
    boolean predicateResult2  = predicateDivisibleBy2.or(predicateDivisibleBy5).negate().test(8);   // Predicate chaining
    System.out.println("Predicate NEGATE (Divisible by 2 and 5) : " + predicateResult);
    System.out.println("Predicate NEGATE (Divisible by 2 and 5) : " + predicateResult2);
  }
}
