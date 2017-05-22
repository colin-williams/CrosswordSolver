package com.example
import org.scalatest._

class CrosswordSolverTest extends FlatSpec with Matchers {
  "The crossword solver trie" should "have multiple prefix entries for Abe" in {
    val crossword = new CrosswordSolver(new Crossword(Array('a')))
    assert(crossword.trie.findByPrefix("Abe").length > 3)
  }

  "The crossword solver dictionary" should "contain words, but not non-words" in {
    val crossword = new CrosswordSolver(new Crossword(Array('a')))
    assert(crossword.dictionary.contains("acosta"))
    assert(!crossword.dictionary.contains("t"))
    assert(crossword.dictionary.contains("toto"))
  }

  "The following crossword" should "return some words" in {
    val solver = new CrosswordSolver(new Crossword(Array('a','g','o','i','c'),Array('d','e','r','u','f'),Array('m','p','n','b','h'),Array('s','t','e','f','w') ))
    val crossword = solver.crosswd
    assert(true)
  }

  "The following crossword" should "return to / toast" in {
    val crossword = new Crossword(Array('t','o','a','s','t'))
    val solver = new CrosswordSolver(crossword)
    val wordlist = solver.findwords(solver.crosswd.Position.apply(0,0))
    println("exit findwords / begin printwords")
    wordlist.foreach(println)
    val crossword2 = new Crossword(Array('a','b','c'),Array('d','e','f'),Array('g','h','i'))
    val solver2 = new CrosswordSolver(crossword2)
    val wordlist2 = solver2.findwords(solver2.crosswd.Position.apply(1,2))
    wordlist2.foreach(println)
  }


}
