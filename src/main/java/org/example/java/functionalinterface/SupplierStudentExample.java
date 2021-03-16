package org.example.java.functionalinterface;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierStudentExample
{
  public static void main(String[] args)
  {
    Student student = createStudent();
    System.out.println("Student is : " + student);

    List<Student> studentList = listStudents();
    System.out.println("Students are : " + studentList);
  }

  public static Student createStudent()
  {
    Supplier<Student> studentSupplier = () ->
      {
        return new Student("Adam", 5, 4.9, "male", Arrays.asList("chess", "tennis", "basketball"));
      };

    return studentSupplier.get();
  }

  public static List<Student> listStudents()
  {
    Supplier<List<Student>> listSupplier = () -> StudentDatabase.getAllStudents();
    return listSupplier.get();
  }
}
