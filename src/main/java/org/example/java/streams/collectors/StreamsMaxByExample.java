package org.example.java.streams.collectors;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsMaxByExample
{
  static List<Student> studentList = StudentDatabase.getAllStudents();

  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    // minBy()
    Optional<Student> optionalStudentMinBy =
      studentList
        .stream()
        .collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));

    System.out.println(optionalStudentMinBy);

    // maxBy()
    Optional<Student> optionalStudentMaxBy =
      studentList
        .stream()
        .collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));

    System.out.println(optionalStudentMaxBy);
  }
}
