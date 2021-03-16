package org.example.java.functionalinterface;

import java.util.function.UnaryOperator;

/**
 * @see java.util.function.UnaryOperator
 */
public class UnaryOperatorExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    UnaryOperator<String> unaryOperator = (s) ->
      {
        return s.concat("Default");
      };

    String result = unaryOperator.apply("java8");
    System.out.println(result);
  }
}
