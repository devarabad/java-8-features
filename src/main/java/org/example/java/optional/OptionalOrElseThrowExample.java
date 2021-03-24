package org.example.java.optional;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalOrElseThrowExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    // String value = "Hello";  // Returns the value if present                 -- return "Hello"
    String value = null;        // Throws the supplier exception if not present -- if Optional.empty return exceptionSupplier

    Optional<String> stringOptional = Optional.ofNullable(value);
    System.out.println(stringOptional);

    // If supplierException == non-null   -> throws supplierException
    Supplier<RuntimeException> runtimeExceptionSupplier     = () -> new RuntimeException("Error thrown");
    String returnedValueSupplierException                   = stringOptional.orElseThrow(runtimeExceptionSupplier);
    System.out.println("Supplier exception (RuntimeException) result: " + returnedValueSupplierException);

    // If supplierException == null       -> throws NullPointerException
    Supplier<RuntimeException> runtimeExceptionSupplierNull = () -> null;       // if supplierException is null throws a NullPointerException
    String returnedValueSupplierExceptionNull               = stringOptional.orElseThrow(runtimeExceptionSupplierNull);
    System.out.println("Supplier exception (Exception === null) result: " + returnedValueSupplierExceptionNull);
  }
}
