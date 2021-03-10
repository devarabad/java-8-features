package org.example.java.functionalinterface;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.List;
import java.util.function.Consumer;

/**
 * @see java.util.function.Consumer
 */
public class ConsumerExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    Consumer<String> consumer = (input) ->
      {
        System.out.println(input.toUpperCase());
      };

    consumer.accept("java8");


    /**
     * Sample Use Cases
     */
    Consumer<String> sayHelloWorld  = (name) -> System.out.println("Hello World " + name);
    sayHelloWorld.accept("John");

    Consumer<String> sayGreetings   = (name) -> System.out.println("Greetings " + name + "!");
    Consumer<String> askHowAreYou   = (name) -> System.out.println("How are you " + name + "?");
    sayGreetings.andThen(askHowAreYou).accept("Sarah");
  }
}
