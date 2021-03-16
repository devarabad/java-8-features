package org.example.java.functionalinterface;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumerExample
{
  Predicate<Student> filterByGradeLevel                   = student -> student.getGradeLevel() >= 3;
  Predicate<Student> filterByGpa                          = student -> student.getGpa() >= 3.9;

  BiConsumer<String, List<String>> printNameAndActivities = (name, activities) -> System.out.println(name + " : " + activities);

  Consumer<Student> printNameAndActivitiesFilterByGradeLevelAndGpa =
    student ->
      {
        if (filterByGradeLevel.and(filterByGpa).test(student))
          printNameAndActivities.accept(student.getName(), student.getActivities());
      };

  public void printNameAndActivities(List<Student> students)
  {
    students.forEach(printNameAndActivitiesFilterByGradeLevelAndGpa);
  }

  public static void main(String[] args)
  {
    List<Student> studentList = StudentDatabase.getAllStudents();
    PredicateAndConsumerExample predicateAndConsumerExample = new PredicateAndConsumerExample();
    predicateAndConsumerExample.printNameAndActivities(studentList);
  }

}
