package org.example.java.streams.collectors;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsCollectingAndThenExample
{
  static List<Student> studentList = StudentDatabase.getAllStudents();

  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    Map<Integer, Student> studentMap =
      studentList
        .stream()
        .collect( Collectors.groupingBy(
                    Student::getGradeLevel
                    , Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(Student::getGpa))
                        , Optional::get)));

    studentMap.forEach((gradeLevel, student) ->
    {
      System.out.println(gradeLevel + ": " + student);
    });
  }
}
