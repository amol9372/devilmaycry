package org.scala.practice

object HelloWorldClass {
  
  def main(args: Array[String]) {
    val employee = new Employee("Amol", 4);
    println(employee);
  }
}

class Employee(val name: String, val empid: Int) {

  private var _age = 0

  // Getter
  def age = _age

  // Setter
  def age_=(value: Int): Unit = _age = value

  def printEmployee(emp: Employee) {
    println(emp);
  }

}