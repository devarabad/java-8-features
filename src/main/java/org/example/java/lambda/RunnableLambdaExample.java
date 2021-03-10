package org.example.java.lambda;

public class RunnableLambdaExample
{
  public static void main(String[] args)
  {
    /**
     * Typical Java
     */
    Runnable runnable = new Runnable()
    {
      @Override
      public void run()
      {
        System.out.println("Inside Runnable");
      }
    };

    new Thread(runnable).start();


    /**
     * Java 8 Lambda
     * @see java.lang.Runnable
     */
    Runnable runnableLambda = () ->
    {
      System.out.println("Inside Runnable (Lambda)");
    };

    new Thread(runnableLambda).start();

    /*
     * Lambda - Single line statement
     */
    Runnable runnableLambdaSingleLine = () -> System.out.println("Inside Runnable (Lambda - SingleLine)");

    new Thread(runnableLambdaSingleLine).start();

    /*
     * Lambda - No variable assignment
     */
    new Thread(() -> System.out.println("Inside Runnable (Lambda - No Variable Assignment)")).start();
  }
}
