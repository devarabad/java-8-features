package org.example.java.methodreference;

import java.util.Arrays;
import java.util.function.Function;

public class MethodReferenceExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     * Using Method Reference
     */
    Function<String, String> toUpperCaseMethodReference = String::toUpperCase;
    System.out.println(toUpperCaseMethodReference.apply("java8"));

    /**
     * Using Lambda
     */
    Function<String, String> toUpperCaseLambda = (s) -> s.toUpperCase();
    System.out.println(toUpperCaseLambda.apply("java8"));

    /**
     * Sample Use Cases
     */
    // className::methodName
    String[] stringArray = { "Barbara", "James", "Mary", "John", "Patricia", "Robert", "Michael", "Linda" };
    Arrays.sort(stringArray, String::compareToIgnoreCase);
    System.out.println(Arrays.toString(stringArray));

    // className::static-methodName
    Function<String, Double> fDouble = Double::valueOf;
    System.out.println(fDouble.apply("3.141516"));
  }
}
