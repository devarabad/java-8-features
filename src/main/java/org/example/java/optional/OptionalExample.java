package org.example.java.optional;

import org.example.java.data.Person;

import java.util.Optional;

public class OptionalExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    // Non-null object
    Optional<Person> optional = Optional.ofNullable(new Person("John Doe"));
    System.out.println(optional);

    if (optional.isPresent())
    {
      Optional<String> optionalName = optional.map(Person::getName);  // Optional<String>
      optionalName.ifPresent(System.out::println);
    }

    // Null object
    Optional<Person> optionalNull = Optional.ofNullable(null);
    System.out.println(optionalNull);

    if (optionalNull.isPresent())
      System.out.println("Person is not null");
    else
      System.out.println("Person is null");
  }
}

