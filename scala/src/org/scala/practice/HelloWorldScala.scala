package org.scala.practice

import scala.collection.mutable.ArrayBuffer

object HelloWorldScala {
  def main(args: Array[String]) {
    
    // val ==> immutable
    val intArray = Array(2,3,4);
    
    var intArrayBuffer = ArrayBuffer(3,3,5);
    
    intArrayBuffer++=ArrayBuffer(6,7,8); 
    
    intArrayBuffer+= 34;
    
    intArray.foreach { x => println(x) }
    
    var intArray2 = new Array[Int](8);
    
    println({
      val x = 1;
      x+3;
    })

    var lambdaExp1 = (x: Int, y: Int) => { x + y };
    println(lambdaExp1(2,5))
    
    for(n <- intArray)
      println(n)
    
    intArray.filter { x => x >= 3 }  
      
    
    for(n <- intArray)
      println(n)
      
   val sampleMap = Map(1 -> "Amol", 2 -> "Rahul");
       
  }
  
  def func1(s:String):String = {
    println(s)
      s;
  }
  
  
  
}