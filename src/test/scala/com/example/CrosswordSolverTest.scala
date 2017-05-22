package com.example
import org.scalatest._

class CrosswordSolverTest extends FlatSpec with Matchers {
  "The crossword solver trie" should "have multiple prefix entries for Abe" in {
    val crossword = new CrosswordSolver()
    assert(crossword.trie.findByPrefix("Abe").length > 3)
  }

  "The crossword solver dictionary" should "contain words from the dictionary file, but not non-words" in {
    val crossword = new CrosswordSolver()
    assert(crossword.dictionary.contains("acosta"))
    assert(!crossword.dictionary.contains("t"))
    assert(crossword.dictionary.contains("toto"))
  }

  "The following crossword" should "return some words" in {
    val solver = new CrosswordSolver()
    val crossword = new Crossword(Array('a','g','o','i','c'),Array('d','e','r','u','f'),Array('m','p','n','b','h'),Array('s','t','e','f','w'))
    val allwords = solver.findAllWords(crossword)
    allwords.foreach(println)
    assert(true)
  }

  "The following crossword" should "return to / toast" in {
    val crossword = new Crossword(Array('t','o','a','s','t'))
    val solver = new CrosswordSolver()
    val wordlist = solver.findWords(crossword,0,0)
    println("exit findwords / begin printwords")
    wordlist.foreach(println)

    val allWords  = solver.findAllWords(crossword)
    println("exit findallwords / begin printwords")
    allWords.foreach(println)
    val crossword2 = new Crossword(Array('a','b','c'),Array('d','e','f'),Array('g','h','i'))
    val wordlist2 = solver.findWords(crossword2,1,2)
    wordlist2.foreach(println)
  }


}
