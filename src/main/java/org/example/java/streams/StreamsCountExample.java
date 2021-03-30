package org.example.java.streams;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.List;

public class StreamsCountExample
{
  static List<Student> studentList = StudentDatabase.getAllStudents();

  public static void main(String[] args)
  {
    /**
     * Basic Usage
     *  - Returns the total no elements in the stream
     */
    long studentActivityCount =
      studentList
        .stream()                       // in:List<Student>         -> out:Stream<Student>
        .map(Student::getActivities)    // in:Stream<Student>       -> out:Stream<List<String>>   : Student (Obj) as an input -> returns Activities (List<String>)
        .flatMap(List::stream)          // in:Stream<List<String>>  -> out:Stream<Stream<String>> : Activities (List<String>) as an input -> returns Activity (Stream<String>)
        .distinct()                     //                          -> out:Stream<String>         : returns unique elements (remove duplicates)
        .count();                       //                          -> out:long

    System.out.println(studentActivityCount);
  }
}
