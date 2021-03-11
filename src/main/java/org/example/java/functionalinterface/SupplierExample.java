package org.example.java.functionalinterface;

import java.util.function.Supplier;

/**
 * @see java.util.function.Supplier
 */
public class SupplierExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    Supplier<String> supplier = () ->
      {
        return "Hello World! This is java8";
      };

    String result = supplier.get();
    System.out.println(result);
  }
}
