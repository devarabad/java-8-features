package org.example.java.streams.collectors;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsJoiningExample
{
  static List<Student> studentList = StudentDatabase.getAllStudents();

  public static void main(String[] args)
  {
    /**
     * Basic Usage
     *  - Collector performs the String concatenation on the elements in the stream
     */
    String joining                = studentList
                                      .stream()
                                      .map(Student::getName)
                                      .collect(Collectors.joining());
    System.out.println("Joining: " + joining);

    /*
     * With delimiter
     */
    String joiningWithDelimiter   = studentList
                                      .stream()
                                      .map(Student::getName)
                                      .collect(Collectors.joining("-"));
    System.out.println("Joining with delimiter: " + joiningWithDelimiter);

    /*
     * With prefix & suffix
     */
    String joiningWithPrefixSuffix = studentList
                                      .stream()
                                      .map(Student::getName)
                                      .collect(Collectors.joining("-", "(", ")"));
    System.out.println("Joining with prefix & suffix: " + joiningWithPrefixSuffix);
  }
}
