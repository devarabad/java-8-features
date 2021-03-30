package org.example.java.streams;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.List;

public class StreamsMatchExample
{
  static List<Student> studentList = StudentDatabase.getAllStudents();

  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    /*
     * anyMatch
     *  - Returns true if anyone of the element matches the predicate, otherwise false
     */
    boolean anyMatch = studentList.stream().anyMatch(student -> student.getGpa() >= 4.0);
    System.out.println("ANY students with GPA >= 4.0: " + anyMatch);

    /*
     * allMatch
     *  - Returns true if all of the element matches the predicate, otherwise false
     */
    boolean allMatch = studentList.stream().allMatch(student -> student.getGpa() >= 4.0);
    System.out.println("ALL students with GPA >= 4.0: " + allMatch);

    /*
     * noneMatch
     *  - Returns true if none of the element matches the predicate, otherwise false
     */
    boolean noneMatch = studentList.stream().noneMatch(student -> student.getGpa() >= 4.1);
    System.out.println("NONE students with GPA >= 4.1: " + noneMatch);
  }
}
