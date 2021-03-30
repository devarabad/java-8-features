package org.example.java.streams;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

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
        .stream()                       // in:List<Student>           -> out:Stream<Student>
        .map(Student::getActivities)    // in:Stream<Student>         -> out:Stream<List<String>>   : Student (Obj) as an input -> returns Activities (List<String>)
        .flatMap(List::stream)          // in:Stream<List<String>>    -> out:Stream<Stream<String>> : Activities (List<String>) as an input -> returns Activity (Stream<String>)
        .collect(Collectors.toList());  // in:Stream<Stream<String>>  -> out:List<String>

    System.out.println(studentActivities);
  }
}
