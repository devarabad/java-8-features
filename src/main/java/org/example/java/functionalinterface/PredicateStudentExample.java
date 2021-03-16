package org.example.java.functionalinterface;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.List;
import java.util.function.Predicate;

public class PredicateStudentExample
{
  static List<Student> studentList              = StudentDatabase.getAllStudents();
  static Predicate<Student> filterByGradeLevel  = (student) -> student.getGradeLevel() >= 3;
  static Predicate<Student> filterByGpa         = (student) -> student.getGpa() >= 3.9;

  public static void main(String[] args)
  {
    filterStudentsByGradeLevel();
    filterStudentsByGpa();
    filterStudents();
  }

  public static void filterStudentsByGradeLevel()
  {
    System.out.println("\n===filterStudentsByGradeLevel===");

    studentList.forEach((student) ->
      {
        if (filterByGradeLevel.test(student))
          System.out.println(student);
      });
  }

  public static void filterStudentsByGpa()
  {
    System.out.println("\n===filterStudentsByGpa===");

    studentList.forEach((student) ->
      {
        if (filterByGpa.test(student))
          System.out.println(student);
      });
  }

  public static void filterStudents()
  {
    System.out.println("\n===filterStudents===");

    // AND
    System.out.println("// AND");
    studentList.forEach((student) ->
      {
        if (filterByGradeLevel.and(filterByGpa).test(student))
          System.out.println(student);
      });

    // OR
    System.out.println("// OR");
    studentList.forEach((student) ->
    {
      if (filterByGradeLevel.or(filterByGpa).test(student))
        System.out.println(student);
    });

    // NEGATE
    System.out.println("// OR");
    studentList.forEach((student) ->
    {
      if (filterByGradeLevel.or(filterByGpa).negate().test(student))
        System.out.println(student);
      else
        System.out.println(student);
    });
  }
}
