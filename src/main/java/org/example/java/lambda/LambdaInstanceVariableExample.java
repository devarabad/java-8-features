package org.example.java.lambda;

import java.util.function.Supplier;

public class LambdaInstanceVariableExample
{
  public String hello = "hello!";

  public void reassignInstanceVariable()
  {
    /**
     * No restrictions on Instance Variables
     */
    Supplier<String> consumer = () ->
      {
        hello = "HELLO!";                           // re-assign new value to Instance Variable
        return hello;
      };

    System.out.println(consumer.get());
  }

  public String getHello()
  {
    return hello;
  }

  public static void main(String[] args)
  {
    LambdaInstanceVariableExample lambdaInstanceVariableExample = new LambdaInstanceVariableExample();
    System.out.println(lambdaInstanceVariableExample.getHello());
    lambdaInstanceVariableExample.reassignInstanceVariable();
    System.out.println(lambdaInstanceVariableExample.getHello());
  }
}
