Java 8 Features
====================

## Introduction
### Imperative vs Declarative Programming

### Examples
* [ImperativeVsDeclarativeExample1](src/main/java/org/example/java/ImperativeVsDeclarativeExample1.java)
* [ImperativeVsDeclarativeExample2](src/main/java/org/example/java/ImperativeVsDeclarativeExample2.java)

<br><br>


## Lambda
  - is equivalent to a function (method) without a name
  - referred to as `Anonymous functions`
  - are not tied to any class like a regular method
  - can be assigned to a variable and passed around

### Syntax
```
  ()           ->          {}
  lambda       arrow       lambda
  input                    body
  parameters
```
Sample Representation
```
Function<String, String> someString = (name) -> name.toUpperCase().concat("default");
           |        |                        |
         input    output               lambda expression
```

### Usage
  - mainly used to implement Functional Interfaces

### Local Variables
  - not allowed to use the same local variable name as `lambda parameters` or inside the `lambda body`
  - not allowed to `re-assign` a value to a local variable
```
  /*
   * Not Allowed to use the same Local Variable
   */
  public void someMethod()
  {
    int i = 0;

    Consumer<Integer> consumer = (i) ->         // compile error
      {
        System.out.println("Value is: " + i);
      }
  }

  /*
   * Not Allowed to re-assign a value to a Local Variable
   */
  public void someMethod()
  {
    String hello = "Hello";

    Consumer<String> consumer = (s) ->
      {
        hello = "Re-assign Hello!";             // compile error
      }
  }
```

### Instance Variables
  - no restrictions on `instance` variables
```
  public class Person
  {

  }
```

### Examples
* [ComparatorLambdaExample](src/main/java/org/example/java/lambda/ComparatorLambdaExample.java)
* [RunnableLambdaExample](src/main/java/org/example/java/lambda/RunnableLambdaExample.java)
* [LambdaLocalVariableExample](src/main/java/org/example/java/lambda/LambdaLocalVariableExample.java)
* [LambdaInstanceVariableExample](src/main/java/org/example/java/lambda/LambdaInstanceVariableExample.java)

<br><br>


## Functional Interface
  * also called as Single Abstract Method Interfaces (SAM)
  * is an interface that has exactly one abstract method
  * `@FunctionalInterface` annotation

Some examples of Functional Interface
  * `java.util.Comparator`
  * `java.lang.Runnable`
```
@FunctionalInterface
public interface Comparator<T> {
  int compare(T o1, T o2);
}

@FunctionalInterface
public interface Runnable {
  public abstract void run();
}
```

### Primary Interfaces

> **<!>** All new functional interfaces are available at `java.util.function` package

| Interface      | Extension Interface
|----------------|---------------------
| Consumer       | BiConsumer
| Predicate      | BiPredicate
| Function       | BiFunction, UnaryOperator, BinaryOperator
| Supplier       |

### Examples
* [ConsumerExample](src/main/java/org/example/java/functionalinterface/ConsumerExample.java)
* [ConsumerStudentExample](src/main/java/org/example/java/functionalinterface/ConsumerStudentExample.java)
* [BiConsumerExample](src/main/java/org/example/java/functionalinterface/BiConsumerExample.java)
* [BiConsumerStudentExample](src/main/java/org/example/java/functionalinterface/BiConsumerStudentExample.java)
* [PredicateExample](src/main/java/org/example/java/functionalinterface/PredicateExample.java)
* [PredicateStudentExample](src/main/java/org/example/java/functionalinterface/PredicateStudentExample.java)
* [PredicateAndConsumerExample](src/main/java/org/example/java/functionalinterface/PredicateAndConsumerExample.java)
* [BiPredicateExample](src/main/java/org/example/java/functionalinterface/BiPredicateExample.java)
* [BiPredicateStudentExample](src/main/java/org/example/java/functionalinterface/BiPredicateStudentExample.java)
* [FunctionExample](src/main/java/org/example/java/functionalinterface/FunctionExample.java)
* [FunctionStudentExample](src/main/java/org/example/java/functionalinterface/FunctionStudentExample.java)
* [BiFunctionExample](src/main/java/org/example/java/functionalinterface/BiFunctionExample.java)
* [BiFunctionStudentExample](src/main/java/org/example/java/functionalinterface/BiFunctionStudentExample.java)
* [UnaryOperatorExample](src/main/java/org/example/java/functionalinterface/UnaryOperatorExample.java)
* [BinaryOperatorExample](src/main/java/org/example/java/functionalinterface/BinaryOperatorExample.java)
* [SupplierExample](src/main/java/org/example/java/functionalinterface/SupplierExample.java)
* [SupplierStudentExample](src/main/java/org/example/java/functionalinterface/SupplierStudentExample.java)

<br><br>


## Method Reference
  - simpify the implementation of Functional Interfaces
  - shortcut for writing the Lambda Expressions
  - refer a method in a class

### Syntax
```
  ClassName::instance-methodName
  ClassName::static-methodName
  Instance::methodName
```

### Usage
  - Lambda expressions referring to a method directly.

```
  Using Lambda:
    Function<String, String> toUpperCase = (s) -> s.toUpperCase();

  Using Method Reference:
    Function<String, String> toUpperCase = String::toUpperCase();
```

### Examples
* [MethodReferenceExample](src/main/java/org/example/java/methodreference/MethodReferenceExample.java)
* [ConsumerMethodReferenceExample](src/main/java/org/example/java/methodreference/ConsumerMethodReferenceExample.java)

<br><br>


## Constructor Reference

### Syntax
```
  ClassName::new
```

### Usage
  - class should have empty constructor

```
  Correct:
    Supplier<Student> studentSupplier = Student::new;

  Invalid:
    Student student = Student::new;
```

### Examples
* [ConstructorReferenceExample](src/main/java/org/example/java/constructorreference/ConstructorReferenceExample.java)

<br><br>


## Streams

