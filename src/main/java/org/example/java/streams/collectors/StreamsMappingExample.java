package org.example.java.streams.collectors;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsMappingExample
{
  static List<Student> studentList = StudentDatabase.getAllStudents();

  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    List<String> namesList  = studentList
                                .stream()
                                .collect(Collectors.mapping(Student::getName, Collectors.toList()));
    System.out.println(namesList);

    Set<String> namesSet    = studentList
                                .stream()
                                .collect(Collectors.mapping(Student::getName, Collectors.toSet()));
    System.out.println(namesSet);
  }
}
