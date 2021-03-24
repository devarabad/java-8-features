package org.example.java.optional;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.Optional;

public class OptionalFilterExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     *  - same concept in streams filter()
     */
    Optional<Student> optionalStudent = Optional.ofNullable(StudentDatabase.getOptionalStudent().get());

    optionalStudent
      .filter(student -> student.getGpa() >= 3.5)         // Filters the optional value
      .ifPresent(student -> System.out.println(student));
  }
}
