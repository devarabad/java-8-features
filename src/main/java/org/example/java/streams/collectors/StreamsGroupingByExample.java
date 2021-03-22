package org.example.java.streams.collectors;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsGroupingByExample
{
  static List<Student> studentList = StudentDatabase.getAllStudents();

  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    Map<String, List<Student>> studentsMapGrouping  =
      studentList
        .stream()
        .collect(Collectors.groupingBy(Student::getGender));

    System.out.println("\n=== GroupBy Gender ===");
    studentsMapGrouping.forEach((gender, students) ->
      {
        System.out.println(gender + ": " + students);
      });

    /*
     * Two argument groupBy
     */
    Map<Integer, Map<String, List<Student>>> studentsMapTwoArgGroupBy  =
      studentList
        .stream()
        .collect(Collectors.groupingBy( Student::getGradeLevel
                                        , Collectors.groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE")));

    System.out.println("\n=== GroupBy Grade Level and GPA Category (Two Argument GroupBy) ===");
    studentsMapTwoArgGroupBy.forEach((gradeLevel, studentsMapGpa) ->
    {
      System.out.println("Grade Level: " + gradeLevel);
      studentsMapGpa.forEach((gpaCategory, students) ->
        {
          System.out.println("\t" + gpaCategory + ": " + students);
        });
    });

    /*
     * Three argument groupBy
     */
    LinkedHashMap<String, Set<Student>> studentsMapThreeArgGroupBy  =
      studentList
        .stream()
        .collect(Collectors.groupingBy(Student::getName, LinkedHashMap::new, Collectors.toSet()));

    System.out.println("\n=== GroupBy Name (Three Argument GroupBy) ===");
    studentsMapThreeArgGroupBy.forEach((name, studentSet) ->
      {
        System.out.println(name + ": " + studentSet);
      });


    /**
     * Sample Use Cases
     */
    Map<String, List<Student>> studentsMapGpa  =
      studentList
        .stream()
        .collect(Collectors.groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE"));

    System.out.println("\n=== GroupBy GPA Category ===");
    studentsMapGpa.forEach((gpaCategory, students) ->
      {
        System.out.println(gpaCategory + ": " + students);
      });

    /*
     * Two argument groupBy
     */
    Map<Integer, Integer> studentsMapGradeLevelSumNotebooks =
      studentList
        .stream()
        .collect(Collectors.groupingBy( Student::getGradeLevel
                                        , Collectors.summingInt(Student::getNoteBooks)));

    System.out.println("\n=== GroupBy Grade Level with Sum of Notebooks ===");
    studentsMapGradeLevelSumNotebooks.forEach((gradeLevel, sumOfNotebooks) ->
    {
      System.out.println(gradeLevel + ": " + sumOfNotebooks);
    });

    Map<Integer, Optional<Student>> topGpaStudentGroupByGradeLevel  =
      studentList
        .stream()
        .collect(Collectors.groupingBy(Student::getGradeLevel, Collectors.maxBy(Comparator.comparing(Student::getGpa))));

    System.out.println("\n=== Top Student GPA grouped by Grade Level ===");
    topGpaStudentGroupByGradeLevel.forEach((gradeLevel, student) ->
    {
      System.out.println(gradeLevel + ": " + student);
    });


  }
}
