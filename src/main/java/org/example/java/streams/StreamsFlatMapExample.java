package org.example.java.streams;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsFlatMapExample
{
  static List<Student> studentList = StudentDatabase.getAllStudents();

  public static void main(String[] args)
  {
    /**
     * Basic Usage
     *  - Convert(transform) one type to another
     */
    List<String> studentActivities =
      studentList
        .stream()                       // List<Student>          -> Stream<Student>
        .map(Student::getActivities)    // Stream<Student>        -> Stream<List<String>>   : Student (Obj) as an input -> returns Activities (List<String>)
        .flatMap(List::stream)          // Stream<List<String>>   -> Stream<Stream<String>> : Activities (List<String>) as an input -> returns Activity (Stream<String>)
        .collect(Collectors.toList());  // Stream<Stream<String>> -> List<String>

    System.out.println(studentActivities);
  }
}
