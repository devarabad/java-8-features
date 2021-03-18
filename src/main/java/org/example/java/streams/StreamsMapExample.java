package org.example.java.streams;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsMapExample
{
  static List<Student> studentList = StudentDatabase.getAllStudents();

  public static void main(String[] args)
  {
    /**
     * Basic Usage
     *  - Convert(transform) one type to another
     */
    List<String> studentNames =
      studentList
        .stream()                         // List<Student>    -> Stream<Student>
        .map(Student::getName)            // Stream<Student>  -> Stream<String>   : Student (Obj) as an input -> returns Name (String)
        .map(String::toUpperCase)         // Stream<String>   -> Stream<String>   : Name (String) as an input -> returns toUpperCase Name (String)
        .collect(Collectors.toList());    // Stream<String>   -> List<String>

    System.out.println(studentNames);
  }
}

