package com.example
import com.example.trie.Trie

class CrosswordSolver() {
  val (linesIt1,linesIt2) = scala.io.Source.fromResource("american-english").getLines.duplicate

  val trie = Trie.apply()
  linesIt1.foreach{
    trie.append(_)
  }

  // TODO: The dictionary contains single letter placeholders, for example the letter T. Here we filter them, but also
  // TODO: filter words like I or a. Then we should probably fix the dictionary, and remove the filter.
  val dictionary = linesIt2.map(x=>x.toLowerCase).toSet.filter(x=>x.length>1)

  /**
    * Finds all the words from a given starting row and column position
    * @param crossword - The Crossword that we wish to solve.
    * @param row - The starting row position Int for all the found words
    * @param col - The starting column position Int for all the found words
    * @return - a List of String each of which is a found word
    */

  def findWords(crossword: Crossword, row: Int, col: Int): List[String]={

    def findWords(prefix: String, position: crossword.Position, words: List[String]): List[String] ={
      val temp = (prefix+position.charAt)

      // TODO: create a method in the trie to lookup the prefix
      if (trie.findByPrefix(temp).length < 1){
        //println(s"prefix not found $temp")
        words
      }

      else {
        dictionary.contains(temp) match {
          case true => {
            //println(s"found word: $temp")
            //println(s"${position.legalNeighbors}")
            temp::position.legalNeighbors.flatMap(x => findWords(temp, x, words))
          }

          case false => {
            //println(s"word not found: $temp")
            position.legalNeighbors.flatMap(x => findWords(temp, x, words))
          }
        }
      }

    }
    val position = crossword.Position.apply(row,col)
    findWords(new String,position,List.empty)
  }

  /**
    * Finds all the words from a given crossword
    * @param crossword - the crossword we wish to find all words
    * @return - a List of String each of which is a found word
    */

  def findAllWords(crossword: Crossword)={
    for{row <- 0 until crossword.varargs.length
        col <- 0 until crossword.varargs(row).length
    } yield findWords(crossword,row,col)
  }
}
