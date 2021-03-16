package org.example.java.methodreference;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.function.Consumer;

public class ConsumerMethodReferenceExample
{
  public static void main(String[] args)
  {
    /*
     * className::methodName
     */
    Consumer<Student> c1 = System.out::println;
    StudentDatabase.getAllStudents().forEach(c1);

    /*
     * className::instance-methodName
     */
    Consumer<Student> c2 = Student::printListOfActivities;
    StudentDatabase.getAllStudents().forEach(c2);
  }
}
