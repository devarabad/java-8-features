package org.example.java.streams;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsStudentExample
{
  public static void main(String[] args)
  {
    // List all students' name and activities
    Map<String, List<String>> studentMapNameAndActivities =
      StudentDatabase.getAllStudents()
        .stream()
        .collect(Collectors.toMap(Student::getName, Student::getActivities));

    System.out.println(studentMapNameAndActivities);


    // List students where grade level is >= 3
    Predicate<Student> gradeLevelFilter = (student) -> student.getGradeLevel() >= 3;

    Map<String, Integer> studentFilterByGradeLevel =
      StudentDatabase.getAllStudents()
        .stream()
        .filter(gradeLevelFilter)
        .collect(Collectors.toMap(Student::getName, Student::getGradeLevel));

    System.out.println(studentFilterByGradeLevel);


    // List students where grade level is >= 3 and gpa >= 3.9
    Predicate<Student> gpaFilter = (student) -> student.getGpa() >= 3.9;

    Map<String, Integer> studentFilterByGradeLevelAndGpa =
      StudentDatabase.getAllStudents()
        .stream()
        .filter(gradeLevelFilter)
        .filter(gpaFilter)
        .collect(Collectors.toMap(Student::getName, Student::getGradeLevel));

    System.out.println(studentFilterByGradeLevelAndGpa);


    // Using parallel stream
    Map<String, Integer> parallelStreamOpMap =
      StudentDatabase.getAllStudents()
        .parallelStream()
        .filter(gradeLevelFilter)
        .filter(gpaFilter)
        .collect(Collectors.toMap(Student::getName, Student::getGradeLevel));

    System.out.println(parallelStreamOpMap);
  }
}
