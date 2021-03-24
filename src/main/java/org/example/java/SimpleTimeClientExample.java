package org.example.java;

public class SimpleTimeClientExample
{
  public static void main(String[] args)
  {
    TimeClient myTimeClient = new SimpleTimeClient();
    System.out.println("Current time: " + myTimeClient.toString());
    System.out.println("Time in California: " + myTimeClient.getZonedDateTime("Blah blah").toString());
  }
}
