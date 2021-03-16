package org.example.java.functionalinterface;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionStudentExample
{
  static Predicate<Student> filterByGradeLevel                        = (student) -> student.getGradeLevel() >= 3;
  static Function<List<Student>, Map<String, Double>> studentFunction = (students) ->
    {
      Map<String, Double> studentGradeMap = new HashMap<>();

      students.forEach(
        student ->
          {
            if (filterByGradeLevel.test(student))
              studentGradeMap.put(student.getName(), student.getGpa());
          });

      return studentGradeMap;
    };

  public static void main(String[] args)
  {
    List<Student> studentList   = StudentDatabase.getAllStudents();
    Map<String, Double> result  = studentFunction.apply(studentList);
    System.out.println(result);
  }
}
