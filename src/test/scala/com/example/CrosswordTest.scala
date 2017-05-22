package com.example
import org.scalatest._

class CrosswordTest extends FlatSpec with Matchers {

 "The following crosswords" should "have legal neighbors" in {
   val crossword = new Crossword(Array('t','o','a','s','t'))
   assert(List('t','o','a') == (crossword.Position(0,1).legalNeighbors.map(x=>x.charAt)))
   val crossword2 = new Crossword(Array('a','b','c'),Array('d','e','f'),Array('g','h','i'))
   assert (List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i') == crossword2.Position(1,1).legalNeighbors.map(x=>x.charAt))
 }
}
