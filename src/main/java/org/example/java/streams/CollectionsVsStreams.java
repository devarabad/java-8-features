package org.example.java.streams;

import java.util.ArrayList;
import java.util.stream.Stream;

public class CollectionsVsStreams
{
  public static void main(String[] args)
  {
    ArrayList<String> names = new ArrayList<>();
    names.add("Frodo");
    names.add("Samwise");
    names.add("Pippin");
    names.add("Merry");

    /**
     * Collections
     */
    // Can add or modify elements
    names.add("Bilbo");
    names.remove(0);

    // Can be accessed in any order
    System.out.println(names.get(3));

    // Collections can be traversed "n" number of times
    // Performs external iteration
    for (String name : names)
    {
      System.out.println(name);
    }

    for (String name : names)
    {
      System.out.println(name);
    }


    /**
     * Streams
     *  - Cannot add or modify the stream
     *  - Can be accessed in sequence only
     */
    Stream<String> nameStream = names.stream();
    nameStream.forEach(System.out::println);
    // Can be traversed only once
    // Performs internal iteration
    nameStream.forEach(System.out::println);    // runtime error
  }
}
