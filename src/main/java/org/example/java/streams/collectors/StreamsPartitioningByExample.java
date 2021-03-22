package org.example.java.streams.collectors;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsPartitioningByExample
{
  static List<Student> studentList = StudentDatabase.getAllStudents();

  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    Predicate<Student> gpaPredicate = student -> student.getGpa() >= 3.8;

    Map<Boolean, List<Student>> partioningMap =
      studentList
        .stream()
        .collect(Collectors.partitioningBy(gpaPredicate));

    System.out.println("Partioning Map : " + partioningMap);

    /*
     * Two argument
     *  1st arg: Predicate
     *  2nd arg: Downstream
     */
    Map<Boolean, Set<Student>> partioningMapTwoArg =
      studentList
        .stream()
        .collect(Collectors.partitioningBy(
                              gpaPredicate
                              , Collectors.toSet()));

    System.out.println("Partioning Map (2 Arg) : " + partioningMapTwoArg);
  }
}
