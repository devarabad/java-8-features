package org.example.java.optional;

import java.util.Optional;

public class OptionalOrElseExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    // String value = "Hello";  // Returns the value if present           -- return "Hello"
    String value = null;        // Returns the other value if not present -- if Optional.empty return "Hi"

    Optional<String> stringOptional = Optional.ofNullable(value);
    String returnedValue            = stringOptional.orElse("Hi");

    System.out.println(stringOptional);
    System.out.println(returnedValue);
  }
}
