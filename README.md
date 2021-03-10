Java 8 Features
====================

## Introduction
### Imperative vs Declarative Programming

### Examples
* [ImperativeVsDeclarativeExample1](_src/main/java/org/example/java/ImperativeVsDeclarativeExample1)
* [ImperativeVsDeclarativeExample2](_src/main/java/org/example/java/ImperativeVsDeclarativeExample2)

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

### Usages
  - mainly used to implement Functional Interfaces

### Examples
* [ComparatorLambdaExample](_src/main/java/org/example/java/lambda/ComparatorLambdaExample)
* [RunnableLambdaExample](_src/main/java/org/example/java/lambda/RunnableLambdaExample)

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
* [ConsumerExample](_src/main/java/org/example/java/functionalinterface/ConsumerExample)
  * [BiConsumerExample](_src/main/java/org/example/java/functionalinterface/BiConsumerExample)


<br><br>


## Streams

