package org.example.java.streams.collectors;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsSummingExample
{
  static List<Student> studentList = StudentDatabase.getAllStudents();

  public static void main(String[] args)
  {
    /**
     * Basic Usage
     */
    int sumOfNotebooksInt       = studentList
                                    .stream()
                                    .collect(Collectors.summingInt(Student::getNoteBooks));
    System.out.println(sumOfNotebooksInt);

    long sumOfNotebooksLong     = studentList
                                    .stream()
                                    .collect(Collectors.summingLong(Student::getNoteBooks));
    System.out.println(sumOfNotebooksLong);

    double sumOfNotebooksDouble = studentList
                                    .stream()
                                    .collect(Collectors.summingDouble(Student::getNoteBooks));
    System.out.println(sumOfNotebooksDouble);
  }
}
