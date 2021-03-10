package org.example.java.functionalinterface;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample
{
  static Consumer<Student> consumer1 = (student) -> System.out.println(student);
  static Consumer<Student> consumer2 = (student) -> System.out.print(student.getName());
  static Consumer<Student> consumer3 = (student) -> System.out.println(student.getActivities());
  static Consumer<Student> consumer4 = (student) -> System.out.print("[gradeLevel:" + student.getGradeLevel() + "]");

  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    Consumer<String> consumer = (strInput) -> System.out.println(strInput.toUpperCase());
    consumer.accept("java 8 lambda functions");

    /**
     * Use Cases
     */
    printStudents();
    printNameAndActivities();
    printNameAndActivitiesUsingCondition();
  }

  public static void printStudents()
  {
    System.out.println("\n=== printName ===");
    List<Student> studentList = StudentDatabase.getAllStudents();
    studentList.forEach(consumer1);
  }

  /**
   * Using Consumer Chaining
   */
  public static void printNameAndActivities()
  {
    System.out.println("\n=== printNameAndActivities ===");
    List<Student> studentList = StudentDatabase.getAllStudents();
    studentList.forEach(consumer2.andThen(consumer3));            // Consumer Chaining
  }

  /**
   * Using Condition (Filtering Results)
   *  - Code reusability
   */
  public static void printNameAndActivitiesUsingCondition()
  {
    System.out.println("\n=== printNameAndActivitiesUsingCondition ===");
    List<Student> studentList = StudentDatabase.getAllStudents();
    studentList.forEach((student) ->
      {
        if (student.getGradeLevel() >= 3)
          consumer2.andThen(consumer4).andThen(consumer3).accept(student);
      });
  }
}
