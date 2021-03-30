package org.example.java.optional;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.Optional;

public class OptionalMapExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     *  - same concept in streams map()
     */
    Optional<Student> optionalStudent = Optional.ofNullable(StudentDatabase.getOptionalStudent().get());

    optionalStudent
      .filter(student -> student.getGpa() >= 3.5)
      .map(Student::getName)                        // returns Optional<String>
      .ifPresent(name -> System.out.println(name));
  }
}
