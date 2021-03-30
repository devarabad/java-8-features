package org.example.java.streams;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.List;

public class StreamsMapReduceExample
{
  static List<Student> studentList = StudentDatabase.getAllStudents();

  public static void main(String[] args)
  {
    /**
     *  Filter Map Reduce
     */
    Integer noOfNotebooks =
      studentList
        .stream()                                                 // in:List<Student>   -> out:Stream<Student>
        .filter(student -> student.getGradeLevel() >= 3)          // in:Stream<Student> -> out:Stream<Student>  : returns filtered elements by GradeLevel
        .filter(student -> student.getGender().equals("female"))  // in:Stream<Student> -> out:Stream<Student>  : returns filtered elements by Gender
        .map(Student::getNoteBooks)                               // in:Stream<Student> -> out:Stream<Integer>  : Student (Obj) as an input -> returns No of Notebooks (Integer)
        // .reduce(0, (n1,n2) -> n1 + n2)                         // sum of notebooks (lambda form)
        .reduce(0, Integer::sum)                          // sum of notebooks (method reference form - applicable in some types)
        ;

    System.out.println("No of notebooks: " + noOfNotebooks);
  }
}
