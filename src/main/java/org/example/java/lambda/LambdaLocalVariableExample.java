package org.example.java.lambda;

public class LambdaLocalVariableExample
{
  public static void main(String[] args)
  {
    /**
     * Not Allowed to use the same Local Variable
     */
    int i = 0;

    // Consumer<Integer> localVariableInvalid1 = (i) ->           // compile error
    //   {
    //     System.out.println("Value is : " + i);
    //   };

    /**
     * Not Allowed to re-assign a value to a Local Variable
     */
    int x = 0;

    // Consumer<Integer> localVariableInvalid2 = (intValue) ->
    //   {
    //     x = 2;                                                 // compile error
    //   };
  }
}
