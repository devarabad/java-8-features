package org.example.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsLimitExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     *  - limits the "n" number of elements to be processed in the stream
     */
    List<String> namesList  = Arrays.asList("John", "Frederick", "Dave", "Cindy", "Zack", "Anna", "Smith", "Sean");
    List<String> names      = namesList
                                .stream()                       // in:List<String>    -> out:Stream<String>
                                .limit(3)                       //                    -> out:Stream<String> : returns the first two names
                                .collect(Collectors.toList());  // in:Stream<String>  -> out:List<String>

    System.out.println(names);


    /**
     * Sample Use Cases
     */
    List<String> namesWithA = namesList
                                .stream()
                                .filter(name -> name.contains("a"))
                                .sorted()
                                .limit(3)
                                .collect(Collectors.toList());

    System.out.println(namesWithA);
  }
}
