package org.example.java.optional;

import java.util.Optional;

public class OptionalPresentExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    /*
     * isPresent
     *  - validates if Optional value is present -- returns boolean
     */
    Optional<String> stringOptionalIsPresent = Optional.ofNullable("Hello");
    System.out.println("isPresent: " + stringOptionalIsPresent.isPresent());

    /*
     * ifPresent
     *  - If a value is present, invoke the specified consumer with the value, otherwise do nothing
     */
    // with value present -- execute consumer
    Optional<String> stringOptionalIfPresent = Optional.ofNullable("Hello");
    stringOptionalIfPresent.ifPresent(strValue -> System.out.println(strValue + "! The consumer has been executed"));

    // with value is not present -- do nothing
    Optional<String> stringOptionalIfNotPresent = Optional.ofNullable(null);
    stringOptionalIfNotPresent.ifPresent(strValue -> System.out.println("This part is not executed"));
  }
}
