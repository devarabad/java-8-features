package org.example.java.functionalinterface;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.List;
import java.util.function.Consumer;

/**
 * @see java.util.function.Consumer
 */
public class ConsumerExample
{
  static List<Student>      studentList             = StudentDatabase.getAllStudents();

  static Consumer<Student>  printStudentDetail      = (student) -> System.out.println(student);
  static Consumer<Student>  printStudentName        = (student) -> System.out.print(student.getName());
  static Consumer<Student>  printStudentActivities  = (student) -> System.out.println(student.getActivities());
  static Consumer<Student>  printStudentGradeLevel  = (student) -> System.out.print("[gradeLevel:" + student.getGradeLevel() + "]");

  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    Consumer<String> consumer = (input) ->
      {
        System.out.println(input.toUpperCase());
      };

    consumer.accept("java8");


    /**
     * Use Case
     */
    // Real world use cases
    printStudents();
    printNameAndActivities();
    printNameAndActivitiesUsingCondition();
  }

  public static void printStudents()
  {
    System.out.println("\n=== printName ===");
    studentList.forEach(printStudentDetail);
  }

  /**
   * Using Consumer Chaining
   */
  public static void printNameAndActivities()
  {
    System.out.println("\n=== printNameAndActivities ===");
    studentList.forEach(printStudentName.andThen(printStudentActivities));  // Consumer Chaining
  }

  /**
   * Using Condition (Filtering Results)
   *  - Code reusability
   */
  public static void printNameAndActivitiesUsingCondition()
  {
    System.out.println("\n=== printNameAndActivitiesUsingCondition ===");
    studentList.forEach((student) ->
      {
        if (student.getGradeLevel() >= 3)
          printStudentName.andThen(printStudentGradeLevel).andThen(printStudentActivities).accept(student);
      });
  }
}
