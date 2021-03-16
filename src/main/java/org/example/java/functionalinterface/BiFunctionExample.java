package org.example.java.functionalinterface;

import java.util.function.BiFunction;

/**
 * @see java.util.function.BiFunction
 */
public class BiFunctionExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    BiFunction<String, Integer, String> biFunction = (name, age) ->
      {
        return "My name is " + name + " and I'am " + age + " years old.";
      };

    String biFunctionResult = biFunction.apply("John Doe", 30);
    System.out.println(biFunctionResult);


    /**
     * Sample Use Cases
     */
    BiFunction<Integer, Integer, Integer> multiply = (numA, numB) -> numA * numB;
    System.out.println("Multiplication: " + multiply.apply(5, 2));

    BiFunction<Integer, Integer, Integer> add = (numA, numB) -> numA + numB;
    System.out.println("Addition: " + add.apply(5, 2));
  }
}
