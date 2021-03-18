package org.example.java.streams;

import org.example.java.data.Student;
import org.example.java.data.StudentDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsReduceExample
{
  static List<Student> studentList = StudentDatabase.getAllStudents();

  public static int performMultiplication(List<Integer> integerList)
  {
    /**
     * Basic Usage
     *  - Used to reduce the contents of a stream to a single value
     *  - This is a **terminal operation**
     *  - It takes two parameters as an input
     *     First parameter   - default or initial value
     *     Second parameter  - BinaryOperator<T> (extends BiFunction<T, T, T>)
     */
    return  integerList
              .stream()                             // in:List<Integer> -> out:Stream<Integer>
              /*  [1, 3, 5, 7]
               *
               *  a=1   [initial] , b=1 [from stream] -> result is 1*1  = 1
               *  a=1   [result]  , b=3 [from stream] -> result is 1*3  = 3
               *  a=3   [result]  , b=5 [from stream] -> result is 3*5  = 15
               *  a=15  [result]  , b=7 [from stream] -> result is 15*7 = 105
               */
              .reduce(1, (a, b) -> a * b);
  }

  public static Optional<Integer> performMultiplicationWithoutIdentity(List<Integer> integerList)
  {
    return  integerList
              .stream()
              .reduce((a, b) -> a * b);
  }

  public static Optional<Student> getStudentWithHighestGpa()
  {
    return  studentList
              .stream()
              .reduce((s1, s2) -> s1.getGpa() > s2.getGpa() ? s1 : s2);
  }

  public static void main(String[] args)
  {
    List<Integer> integerList = Arrays.asList(1, 3, 5, 7);
    System.out.println(performMultiplication(integerList));

    /**
     * If a value is present in this Optional, returns the value,
     * otherwise throws NoSuchElementException.
     */
    Optional<Integer> optionalInteger = performMultiplicationWithoutIdentity(integerList);
    boolean integerPresent            = optionalInteger.isPresent();  // Validate if integerList has values
    Integer optionalIntegerValue      = optionalInteger.get();        // Returns the multiplication result
    System.out.println(integerPresent);
    System.out.println(optionalIntegerValue);

    List<Integer> emptyIntegerList          = new ArrayList<>();
    Optional<Integer> optionalEmptyInteger  = performMultiplicationWithoutIdentity(emptyIntegerList);
    boolean emptyIntegerPresent             = optionalEmptyInteger.isPresent();
    System.out.println(emptyIntegerPresent);
    // Integer optionalEmptyIntegerValue       = optionalEmptyInteger.get();   // throws java.util.NoSuchElementException
    // System.out.println(optionalEmptyIntegerValue);

    Optional<Student> optionalStudent = getStudentWithHighestGpa();
    optionalStudent.ifPresent(System.out::println);


    /**
     * Be wary of the initial/default value as reduce may return different values
     */
    /*
     * Non Empty List
     */
    List<Integer> nonEmptyList  = Arrays.asList(6, 7, 8, 9, 10);
    List<Integer> emptyList     = new ArrayList<>();

    int findMaxValue                          = nonEmptyList.stream().reduce(0, (x,y) -> x > y ? x : y);
    Optional<Integer> findMaxValueOptional    = nonEmptyList.stream().reduce((x,y) -> x > y ? x : y);

    int findMaxValue1                         = emptyList.stream().reduce(0, (x,y) -> x > y ? x : y);
    Optional<Integer> findMaxValueOptional1   = emptyList.stream().reduce((x,y) -> x > y ? x : y);

    System.out.println("== Non Empty List ==");
    System.out.println("Max value is                  : " + findMaxValue);
    System.out.println("Max value is (using Optional) : " + findMaxValueOptional);

    System.out.println("== Empty List ==");
    System.out.println("Max value is                  : " + findMaxValue1);
    System.out.println("Max value is (using Optional) : " + findMaxValueOptional1);
  }
}
