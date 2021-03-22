package org.example.java.streams.collectors;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsAveragingExample
{
  static List<Student> studentList = StudentDatabase.getAllStudents();

  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    double avgOfNotebooksInt    = studentList
                                    .stream()
                                    .collect(Collectors.averagingInt(Student::getNoteBooks));
    System.out.println(avgOfNotebooksInt);

    double avgOfNotebooksLong   = studentList
                                    .stream()
                                    .collect(Collectors.averagingLong(Student::getNoteBooks));
    System.out.println(avgOfNotebooksLong);

    double avgOfNotebooksDouble = studentList
                                    .stream()
                                    .collect(Collectors.averagingDouble(Student::getNoteBooks));
    System.out.println(avgOfNotebooksDouble);
  }
}
