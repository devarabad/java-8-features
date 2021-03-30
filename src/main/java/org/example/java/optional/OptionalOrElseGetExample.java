package org.example.java.optional;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalOrElseGetExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    // String value = "Hello";  // Returns the value if present           -- return "Hello"
    String value = null;        // Returns the other value if not present -- if Optional.empty return Supplier.get()

    Optional<String> stringOptional = Optional.ofNullable(value);
    System.out.println(stringOptional);

    // If supplier.get() == non-null    -> returns "Hi"
    Supplier<String> otherValueSupplierNonNull  = () -> "Hi";
    String returnedValueSupplierNonNull         = stringOptional.orElseGet(otherValueSupplierNonNull);
    System.out.println("Supplier.get()==[non-null] result: " + returnedValueSupplierNonNull);

    // If supplier.get() == null        -> returns null
    Supplier<String> otherValueSupplierNull     = () -> null;
    String returnedValueSupplierNull            = stringOptional.orElseGet(otherValueSupplierNull);
    System.out.println("Supplier.get()==[null] result: " + returnedValueSupplierNull);
  }
}
