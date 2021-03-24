package org.example.java.optional;

import java.util.Optional;

public class OptionalEmptyExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    Optional<String> stringOptional = Optional.empty();   // Returns the Optional.empty object
    System.out.println(stringOptional);

    boolean isPresent = stringOptional.isPresent();
    System.out.println("isPresent : " + stringOptional.isPresent());
  }
}
