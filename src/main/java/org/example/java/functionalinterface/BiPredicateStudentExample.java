package org.example.java.functionalinterface;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.List;
import java.util.function.BiPredicate;

public class BiPredicateStudentExample
{
  static List<Student> studentList                              = StudentDatabase.getAllStudents();
  static BiPredicate<Integer, Double> filterByGradeLevelAndGpa  = (gradeLevel, gpa) -> gradeLevel >= 3 && gpa >= 3.9;

  public static void main(String[] args)
  {
    filterStudentsByGradeLevelAndGpa();
  }

  public static void filterStudentsByGradeLevelAndGpa()
  {
    System.out.println("\n===filterStudentsByGradeLevelAndGpa===");

    studentList.forEach((student) ->
      {
        if (filterByGradeLevelAndGpa.test(student.getGradeLevel(), student.getGpa()))
          System.out.println(student);
      });
  }
}
