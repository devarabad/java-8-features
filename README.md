Java 8 Features
====================

## Introduction
### Imperative vs Declarative Programming

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

Eg.
```
Function<String, String> someString = (name) -> name.toUpperCase().concat("default");
           |        |                        |
         input    output               lambda expression
```

### Usages
  - mainly used to implement Functional Interfaces

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
  * Consumer    - BiConsumer
  * Predicate   - BiPredicate
  * Function    - BiFunction, UnaryOperator, BinaryOperator
  * Supplier    -

> **<!>** All new functional interfaces are available at `java.util.function` package

<br><br>

## Streams

