package org.example.java.functionalinterface;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionStudentExample
{
  static List<Student> studentList            = StudentDatabase.getAllStudents();
  static Predicate<Student> isGradeLevelGte3  = (student) -> student.getGradeLevel() >= 3;
  static Predicate<Student> isGpaGte39        = (student) -> student.getGpa() >= 3.9;

  public static void main(String[] args)
  {
    filterStudentsByGradeLevel();
    filterStudentsByGpa();
  }

  public static void filterStudentsByGradeLevel()
  {
    System.out.println("\n===filterStudentsByGradeLevel===");

    BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> biFunction = (students, studentPredicate) ->
    {
      Map<String, Double> studentGradeMap = new HashMap<>();

      students.forEach(student ->
        {
          if (studentPredicate.test(student))
            studentGradeMap.put(student.getName(), student.getGpa());
        });

      return studentGradeMap;
    };

    Map<String, Double> biFunctionResult  = biFunction.apply(studentList, isGradeLevelGte3);
    System.out.println(biFunctionResult);
  }

  public static void filterStudentsByGpa()
  {
    System.out.println("\n===filterStudentsByGpa===");

    BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> biFunction = (students, studentPredicate) ->
    {
      Map<String, Double> studentGradeMap = new HashMap<>();

      students.forEach(student ->
        {
          if (studentPredicate.test(student))
            studentGradeMap.put(student.getName(), student.getGpa());
        });

      return studentGradeMap;
    };

    Map<String, Double> biFunctionResult  = biFunction.apply(studentList, isGpaGte39);
    System.out.println(biFunctionResult);
  }
}
