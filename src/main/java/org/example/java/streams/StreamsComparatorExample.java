package org.example.java.streams;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsComparatorExample
{
  static List<Student> studentList = StudentDatabase.getAllStudents();

  public static void main(String[] args)
  {
    /**
     * Basic Usage
     *  - Custom sort with Comparator
     */
    List<Student> sortedStudentsByName    =
      studentList
        .stream()                                                 // in:List<Student>   -> out:Stream<Student>
        .sorted(Comparator.comparing(Student::getName))           //                    -> out:Stream<Student>  : returns sorted elements by Name
        .collect(Collectors.toList());                            // in:Stream<Student> -> out:List<Student>

    List<Student> sortedStudentsByGpa     =
      studentList
        .stream()                                                 // in:List<Student>   -> out:Stream<Student>
        .sorted(Comparator.comparing(Student::getGpa))            //                    -> out:Stream<Student>  : returns sorted elements by Gpa
        .collect(Collectors.toList());                            // in:Stream<Student> -> out:List<Student>

    List<Student> sortedStudentsByGpaDesc =
      studentList
        .stream()                                                 // in:List<Student>   -> out:Stream<Student>
        .sorted(Comparator.comparing(Student::getGpa).reversed()) //                    -> out:Stream<Student>  : returns sorted elements by Gpa in reversed order
        .collect(Collectors.toList());                            // in:Stream<Student> -> out:List<Student>

    System.out.println("\n=== Students sorted by Name ===");
    sortedStudentsByName.forEach(System.out::println);

    System.out.println("\n=== Students sorted by GPA ===");
    sortedStudentsByGpa.forEach(System.out::println);

    System.out.println("\n=== Students sorted by GPA DESCENDING ===");
    sortedStudentsByGpaDesc.forEach(System.out::println);
  }
}
