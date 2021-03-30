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
        .stream()                         // in:List<Student>   -> out:Stream<Student>
        .map(Student::getName)            // in:Stream<Student> -> out:Stream<String>   : Student (Obj) as an input -> returns Name (String)
        .map(String::toUpperCase)         // in:Stream<String>  -> out:Stream<String>   : Name (String) as an input -> returns toUpperCase Name (String)
        .collect(Collectors.toList());    // in:Stream<String>  -> out:List<String>

    System.out.println(studentNames);
  }
}

