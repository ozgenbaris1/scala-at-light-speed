package com.rockthejvm

import scala.compiletime.ops.string

object ObjectOrientation extends App {

  // define class
  class Animal {

    // define fields
    val age: Int = 0

    // define methods
    def eat() = println("I'm eating")
  }

  // instantiate an instance
  val anAnimal = new Animal

  // inheritance
  class Cat(name: String) extends Animal // constructor definition

  val aCat = new Cat("Angel")
  // constructor arguments are NOT fields
  // aCat.name raises Error

  // promoting a constructor argument to a field is done by using val keyword

  class Dog(val name: String) extends Animal

  val aDog = new Dog("Lassie")
  aDog.name

  // subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")

  aDeclaredAnimal.eat() // the most derived method will be called at runtime
  // meaning that: if Dog class overrides eat method, then at runtime eat method will be called from dog class

  // abstract class
  // not necessarily all the fields and methods have implementation
  // all fields and methods are by default public, it can be restricted by using private or protected
  // private: only the class has access to private field or private method
  // protected: the class and all its descendings have access to protected field and protected methods
  abstract class WalkingAnimal {
    val hasLegs = true

    def walk(): Unit
  }

  // interface = ultimate abstract type
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit // valid method name
  }

// single-class inheritance, multi-trait "mixing"
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("I am eating you, animal!")

    override def ?!(thought: String): Unit = println(s"I was thinking $thought")

  }

  val aCrocodile = new Crocodile

  // infix notation = object method argument
  // only available for methods with ONE argument
  aCrocodile.eat(adog)
  aCrocodile eat adog

  aCrocodile ?! "What if we could fly"

  // operators in scala are actually methods
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2) // equivalent

  // anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println(
      "I am a dinosaur, so I can eat pretty much anything"
    )
  }
  /*
    What you tell the compiler by writing code snippet above

    class Carnivore_Anonymous_35728 extends Carnivore {
        override def eat(animal: Animal): Unit = println("I am a dinosaur, so I can eat pretty much anything")
    }

    val dinosaur = new Carnivore_Anonymous_35728
   */

  // singleton object
  // the only instance of the MySingleton type
  object MySingleton {
    val mySpecialValue = 129487435

    def mySpecialMethod(): Int = 5327

    def apply(x: Int): Int = x + 1
  }

  MySingleton.mySpecialMethod()

  // equivalent
  MySingleton.apply(65)
  MySingleton(65)

  object Animal { // companion object
    // companions can access each other's private fields or methods
    // singleton animal and instances of animal are different things

    val canLiveIndefinitely = false
  }

  val animalsCanLiveForever =
    Animal.canLiveIndefinitely // "static" fields/methods

  // case classes = lightweight data structures with some boilerplate
  // sensible equals and hash code
  // serialization
  // companion with apply

  case class Person(name: String, age: Int)

  // case classes may be constructed without the new keyword
  val bob = Person("Bob", 54) // equivalent = Person.apply("Bob", 54)

  // exceptions
  try {
    // code that can throw
    val x: String = null
    x.length
  } catch {
    case e: Exception => "some faulty error message"
  } finally {
    // execute code no matter what
  }

  // generics
  abstract class MyList[T] {
    def head: T
    def tail: Mylist[T]
  }

  // using a generic with concrete type
  val aList: List[Int] = List(1, 2, 3) // List.apply(1, 2, 3)
  val first = aList.head
  val rest = aList.tail

  val aStringList = List("hello", "scala")
  val firstString = aStringList.head // string

  val reversedList = aList.reverse // returns a new list

  // Point #1: in Scala, we usually operate with IMMUTABLE values/objects
  // any modification to an object must return another object
  // Benefits:
  // 1. works miracles in multithreaded/distributed env
  // 2. helps making sense of the code

  // Point #2: Scala is closest to the OO ideal

}
