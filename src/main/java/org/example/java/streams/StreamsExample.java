package org.example.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    List<String> fruits         = Arrays.asList("apple", "mango", "banana", "strawberry", "kiwi", "apple", "kiwi", "pomelo");
    List<String> distinctFruits = fruits.stream().distinct().collect(Collectors.toList());
    System.out.println(distinctFruits);


    /**
     * Sample Use Cases
     */
    // ---
    Predicate<String> containsCharA = (s) ->
      {
        return s.contains("a");
      };

    List<String> fruitNameContainsCharA = fruits.stream().filter(containsCharA).collect(Collectors.toList());
    System.out.println(fruitNameContainsCharA);

    // ---
    Consumer<String> toUpperCase = (input) ->
      {
        System.out.println(input.toUpperCase());
      };

    fruits.stream().distinct().forEach(toUpperCase);
  }
}
