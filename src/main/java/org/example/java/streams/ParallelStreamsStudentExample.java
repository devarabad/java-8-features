package org.example.java.streams;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamsStudentExample
{
  static List<Student> studentList = StudentDatabase.getAllStudents();

  public static List<String> sequentialPrintStudentActivities()
  {
    long startTime = System.currentTimeMillis();

    List<String> studentActivities =
      studentList
        .stream()
        .map(Student::getActivities)
        .flatMap(List::stream)
        .distinct()
        .sorted()
        .collect(Collectors.toList());

    long endTime = System.currentTimeMillis();

    System.out.println("Duration to execute the pipeline in sequential : " + (endTime-startTime) + "ms");

    return studentActivities;
  }

  public static List<String> parallelPrintStudentActivities()
  {
    long startTime = System.currentTimeMillis();

    List<String> studentActivities =
      studentList
        .stream()
        .parallel()
        .map(Student::getActivities)
        .flatMap(List::stream)
        .distinct()
        .sorted()
        .collect(Collectors.toList());

    long endTime = System.currentTimeMillis();

    System.out.println("Duration to execute the pipeline in parallel : " + (endTime-startTime) + "ms");

    return studentActivities;
  }

  public static void main(String[] args)
  {
    sequentialPrintStudentActivities();
    parallelPrintStudentActivities();
  }
}
