package org.example.java.optional;

import java.util.Optional;

public class OptionalOfEmptyNullableExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    String value = "Hello";     // Accepts and validates non-null values
    // String value = null;        // Accepts and validates null values

    Optional<String> stringOptional = Optional.ofNullable(value);
    System.out.println(stringOptional);

    boolean isPresent = stringOptional.isPresent();
    System.out.println("isPresent : " + stringOptional.isPresent());

    if (isPresent)
      System.out.println("getValue  : " + stringOptional.get());
    else
      System.out.println("getValue  : empty");
  }
}
