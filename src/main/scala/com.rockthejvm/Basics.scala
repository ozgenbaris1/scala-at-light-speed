package com.rockthejvm

object Basics extends App {

  // define a value
  // values cannot be reassigned
  val meaningOfLife: Int = 42

  // we don't have to mention types when assigning values
  // so, type mentioning is optional
  val aBoolean = false;

  // types:
  // Int, Boolean, Char, Boolean, Double, Float, String

  // Strings and string operations
  val aString = "I love Scala!"

  // composing strings
  val aComposedString = "I" + " " + "love" + " " + "Scala!"

  // interpolation
  val anInterpolatedString = s"The meaning of life is: $meaningOfLife"

  // Experssions = structures that can be reduced to a value
  val anExpression = 2 + 3

  // if experssion
  val ifExpression = if (meaningOfLife > 42) 56 else 999

  // chained if expression
  val chainedIfExpression =
    if (meaningOfLife > 42) 56
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife > 999) 78
    else 0

  // code blocks
  val aCodeBlock = {
    // definitions
    val aLocalValue = 67

    // last expression of a code block is the value of the entire block
    aLocalValue + 3
  }

  // functions
  def myFunction(x: Int, y: String): String = {
    y + " " + x // this single expression is the return of the function
  }

  // functions are recursive in practice
  def factorial(n: Int): Int = if (n <= 1) 1 else n * factorial(n - 1)

  /*
  factorial(5) = 5 * factorial(4) = 5 * 24 = 120
  factorial(4) = 4 * factorial(3) = 4 * 6
  factorial(3) = 3 * factorial(2) = 3 * 2
  factorial(2) = 2 * factorial(1) = 2 * 1
  factorial(1) = 1
   */

  // In scala, we don't use loops or iteration, we use RECURSION!
  // variables or loops are heavily discouraged

  // the Unit type = no meaningful value (= "void" in other languages)
  println("I love Scala!") // System.out.println, printf, print, console.log ...

  def myUnitReturningFunction(): Unit = {
    println("I don't love returning Unit")
  }

  val theUnit = ()
}
