package org.example.java.functionalinterface;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.List;
import java.util.function.BiConsumer;

/**
 * @see java.util.function.BiConsumer
 */
public class BiConsumerExample
{
  static List<Student> studentList = StudentDatabase.getAllStudents();

  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    BiConsumer<String, String> biConsumer = (inputA, inputB) ->
      {
        System.out.println("a: " + inputA);
        System.out.println("b: " + inputB);
      };

    biConsumer.accept("java7", "java8");


    /**
     * Use Case
     */
    BiConsumer<Integer, Integer> multiply = (intA, intB) -> System.out.println("Multiplication is: " + (intA * intB));
    multiply.accept(2, 3);

    BiConsumer<Integer, Integer> divide   = (intA, intB) -> System.out.println("Division is: " + (intA * intB));
    divide.accept(6, 1);

    // Chaining
    System.out.println("\n======");
    multiply.andThen(divide).accept(10, 2);

    // Real world use cases
    printNameAndActivities();
  }

  public static void printNameAndActivities()
  {
    System.out.println("\n===printNameAndActivities===");
    BiConsumer<String, List<String>> biConsumer = (name, activities) ->
      {
        System.out.println(name + " : " + activities);
      };

    studentList.forEach((student) ->
      {
        biConsumer.accept(student.getName(), student.getActivities());
      });
  }
}
