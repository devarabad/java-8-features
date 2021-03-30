package org.example.java.streams;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.List;
import java.util.Optional;

public class StreamsFindAnyExample
{
  static List<Student> studentList = StudentDatabase.getAllStudents();

  public static void main(String[] args)
  {
    /**
     * Basic Usage
     *  - Returns the first encountered element it finds in the stream
     */
    Optional<Student> optionalStudent =
      studentList
        .stream()                                   // in:List<Student>   -> out:Stream<Student>
        .filter(student -> student.getGpa() > 3.9)  // in:Stream<Student> -> out:Stream<Student>  : returns filtered elements by Gpa
        .findAny();

    if (optionalStudent.isPresent())
      System.out.println("Student found : " + optionalStudent.get());
    else
      System.out.println("Student not found");
  }
}
