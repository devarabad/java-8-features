package org.example.java.streams;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsDebuggingExample
{
  public static void main(String[] args)
  {
    /**
     * Debug Stream Operations using .peek()
     */
    Predicate<Student> gradeLevelFilter = (student) -> student.getGradeLevel() >= 3;
    Predicate<Student> gpaFilter        = (student) -> student.getGpa() >= 3.9;

    Map<String, Integer> studentFilterByGradeLevelAndGpa =
      StudentDatabase.getAllStudents()
        .stream()
        .peek(student ->
          {
            System.out.println("[peek .stream()]                  : " + student);
          })
        .filter(gradeLevelFilter)
        .peek(student ->
          {
            System.out.println("[peek .filter(gradeLevelFilter)]  : " + student);
          })
        .filter(gpaFilter)
        .peek(student ->
          {
            System.out.println("[peek .filter(gpaFilter)]         : " + student);
          })
        .collect(Collectors.toMap(Student::getName, Student::getGradeLevel));

    System.out.println("Result: " + studentFilterByGradeLevelAndGpa);
  }
}
