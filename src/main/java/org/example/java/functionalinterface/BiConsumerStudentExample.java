package org.example.java.functionalinterface;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerStudentExample
{
  static List<Student> studentList = StudentDatabase.getAllStudents();

  public static void main(String[] args)
  {
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
