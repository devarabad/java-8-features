package org.example.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsSkipExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     *  - skips the "n" number of elements from the stream
     */
    List<String> namesList  = Arrays.asList("John", "Frederick", "Dave", "Cindy", "Zack", "Anna", "Smith", "Sean");
    List<String> names      = namesList
                                .stream()                       // in:List<String>    -> out:Stream<String>
                                .skip(2)                        //                    -> out:Stream<String> : returns the names skipping the first 2
                                .collect(Collectors.toList());  // in:Stream<String>  -> out:List<String>

    System.out.println(names);


    /**
     * Sample Use Cases
     */
    List<String> namesWithA = namesList
                                .stream()
                                .filter(name -> name.contains("a"))
                                .sorted()
                                .skip(2)
                                .limit(10)
                                .collect(Collectors.toList());

    System.out.println(namesWithA);
  }
}
