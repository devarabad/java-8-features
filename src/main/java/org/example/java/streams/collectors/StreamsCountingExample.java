package org.example.java.streams.collectors;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsCountingExample
{
  static List<Student> studentList = StudentDatabase.getAllStudents();

  public static void main(String[] args)
  {
    /**
     * Basic Usage
     *  - Collector returns the total number of elements as a result
     */
    long count  = studentList
                    .stream()
                    .collect(Collectors.counting());
    System.out.println(count);


    /**
     * Sample Use Cases
     */
    long studentGpaCount  = studentList
                              .stream()
                              .filter(student -> student.getGpa() >= 3.9)
                              .collect(Collectors.counting());
    System.out.println(studentGpaCount);
  }
}
