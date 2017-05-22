package com.example
import com.example.trie.Trie

class CrosswordSolver(crossword: Crossword) {
  val (linesIt1,linesIt2) = scala.io.Source.fromResource("american-english").getLines.duplicate

  val trie = Trie.apply()
  linesIt1.foreach{
    trie.append(_)
  }

  // WARN: The dictionary contains single letter placeholders, for example the letter T. Here we filter them, but also
  // filter words like I or a.
  val dictionary = linesIt2.map(x=>x.toLowerCase).toSet.filter(x=>x.length>1)

  val crosswd = crossword

  /**
    * Finds all the words from a given starting position
    * @param position - The starting position for all the found words
    * @return - a List of String each of which is a found word
    */

  def findwords(position: crosswd.Position): List[String]={

    def findwords(prefix: String, position: crosswd.Position, words: List[String]): List[String] ={
      val temp = (prefix+position.charAt)

      // TODO: create a method in the trie to lookup the prefix
      if (trie.findByPrefix(temp).length < 1){
        println(s"prefix not found $temp")
        words
      }

      else {
        dictionary.contains(temp) match {
          case true => {
            println(s"found word: $temp")
            println(s"${position.legalNeighbors}")
            temp::position.legalNeighbors.flatMap(x => findwords(temp, x, words))
          }

          case false => {
            println(s"word not found: $temp")
            position.legalNeighbors.flatMap(x => findwords(temp, x, words))
          }
        }
      }

    }
    findwords(new String,position,List.empty)
  }
}

