package com.example
import org.scalatest._

class CrosswordSolverTest extends FlatSpec with Matchers {
  "The crossword solver trie" should "have multiple prefix entries for a test prefix" in {
    val crossword = new CrosswordSolver()
    assert(crossword.trie.findByPrefix("Abe").length > 3)
  }

  "The crossword solver dictionary" should "contain words from the dictionary file, but not non-words" in {
    val crossword = new CrosswordSolver()
    assert(crossword.dictionary.contains("acosta"))
    assert(!crossword.dictionary.contains("t"))
    assert(crossword.dictionary.contains("toto"))
  }

  "The provided crossword" should "have more words than characters" in {
    val solver = new CrosswordSolver()
    val crossword = new Crossword(Array('a','g','o','i','c'),Array('d','e','r','u','f'),Array('m','p','n','b','h'),
      Array('s','t','e','f','w'))
    val allwords = solver.findAllWords(crossword)
    //allwords.foreach(println)
    assert(crossword.varargs.flatten.length < allwords.flatten.length)
  }

  "The following crossword" should "return a list of words for the `toast` input" in {
    val crossword = new Crossword(Array('t','o','a','s','t'))
    val solver = new CrosswordSolver()
    val findAtOrigin=solver.findWords(crossword,0,0)
    assert(findAtOrigin == List("to", "tot", "toto", "too", "toot", "toast", "toasts"))
    assert(solver.findAllWords(crossword).flatten.length > findAtOrigin.length)
  }


}
