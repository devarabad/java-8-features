package org.example.java.optional;

import org.example.java.data.Bike;
import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.Optional;

public class OptionalFlatMapExample
{
  public static void main(String[] args)
  {
    /**
     * Basic Usage
     *  - same concept in streams flatMap()
     */
    Optional<Student> optionalStudent = Optional.ofNullable(StudentDatabase.getOptionalStudent().get());

    optionalStudent
      .filter(student -> student.getGpa() >= 3.5)
      .flatMap(Student::getBike)                        // returns Optional<Bike>
      .map(Bike::getName)
      .ifPresent(bikeName -> System.out.println(bikeName));
  }
}
