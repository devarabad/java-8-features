package org.example.java.constructorreference;

import java.util.Date;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferenceExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    Function<String, Integer> constructorReference = Integer::new;
    System.out.println(constructorReference.apply("1"));


    /**
     * Sample Use Cases
     */
    Supplier<Date> supplier = Date::new;
    System.out.println(supplier.get());

    Function<String, Boolean> function = Boolean::new;
    System.out.println(function.apply("TRUE"));
    System.out.println(function.apply("true"));
    System.out.println(function.apply("FALSE"));
    System.out.println(function.apply("FalsE"));
  }
}
