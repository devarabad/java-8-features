package org.example.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DefaultInterfaceExample
{
  public static void main(String[] args)
  {
    /**
     * Using Default Methods in java.util.List interface
     * @see java.util.List
     */
    /*
     * Prior to Java 8
     */
    List<String> namesPriorJava8 = Arrays.asList("Jean", "Xen", "Maggie", "Andrew", "Steven", "Zack", "Luna");
    Collections.sort(namesPriorJava8);
    System.out.println("Sorted list using Collections.sort() : " + namesPriorJava8);

    /*
     * Java 8
     */
    List<String> namesJava8 = Arrays.asList("Jean", "Xen", "Maggie", "Andrew", "Steven", "Zack", "Luna");
    namesJava8.sort(Comparator.naturalOrder());
    System.out.println("Sorted list using List.sort() : " + namesJava8);
  }
}
