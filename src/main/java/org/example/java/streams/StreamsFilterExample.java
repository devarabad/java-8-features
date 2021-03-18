package org.example.java.streams;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsFilterExample
{
  static List<Student> studentList = StudentDatabase.getAllStudents();

  public static void main(String[] args)
  {
    /**
     * Basic Usage
     *  - Filters the elements in the stream
     */
    List<Student> filteredStudentsByGender        =
      studentList
        .stream()                                                   // in:List<Student>   -> out:Stream<Student>
        .filter((student) -> student.getGender().equals("female"))  // in:Stream<Student> -> out:Stream<Student>  : returns filtered elements by Gender
        .collect(Collectors.toList());                              // in:Stream<Student> -> out:List<Student>

    List<Student> filteredStudentsByGenderAndGpa  =
      studentList
        .stream()                                                   // in:List<Student>   -> out:Stream<Student>
        .filter((student) -> student.getGender().equals("female"))  // in:Stream<Student> -> out:Stream<Student>  : returns filtered elements by Gender
        .filter((student) -> student.getGpa() >= 3.9)               // in:Stream<Student> -> out:Stream<Student>  : returns filtered elements by Gpa
        .collect(Collectors.toList());                              // in:Stream<Student> -> out:List<Student>

    System.out.println("\n=== Students filtered by Gender (female) ===");
    filteredStudentsByGender.forEach(System.out::println);

    System.out.println("\n=== Students filtered by Gender (female) and GPA (>= 3.9) ===");
    filteredStudentsByGenderAndGpa.forEach(System.out::println);
  }
}
