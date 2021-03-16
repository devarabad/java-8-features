package org.example.java.functionalinterface;

import java.util.function.Function;

/**
 * @see java.util.function.Function
 */
public class FunctionExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    Function<String, String> function = (name) ->
      {
        return name.toUpperCase();
      };

    String result = function.apply("java8");
    System.out.println(result);


    /**
     * Sample Use Cases
     */
    Function<String, String> toUpper  = (value) -> value.toUpperCase();
    String toUpperResult              = toUpper.apply("hello");
    System.out.println(toUpperResult);

    Function<String, String> concat   = (value) -> value.concat("world!");
    String concatResult               = concat.apply("hello");
    System.out.println(concatResult);

    // Chaining
    String toUpperAndConcatResult = toUpper.andThen(concat).apply("hello");
    System.out.println(toUpperAndConcatResult);

    // Compose
    String composeResult = toUpper.compose(concat).apply("hello");
    System.out.println(composeResult);
  }
}
