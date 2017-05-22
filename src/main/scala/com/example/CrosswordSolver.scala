package com.example
import com.example.trie.Trie

class CrosswordSolver(crossword: Crossword) {
  val (linesIt1,linesIt2) = scala.io.Source.fromResource("american-english").getLines.duplicate

  // TODO: modify the trie so exits on first prefix instead of searching all...
  val trie = Trie.apply()
  linesIt1.foreach{
    trie.append(_)
  }

  // TODO: removing single line strings from dictionary, but should re-add "I,A". This is really an issue with the dictionary.
  val dictionary = linesIt2.map(x=>x.toLowerCase).toSet.filter(x=>x.length>1)

  val crosswd = crossword

  /**
    * Finds all the words from a given starting position
    * @param position - The starting position for all the found words
    * @return - a List of String each of which is a found word
    */

  def findwords(position: crosswd.Position): List[String]={

    def findwords(prefix: String, position: crosswd.Position, words: List[String]): List[String] ={
      val temp = (prefix+position.charAt) //.toString()
      // TODO: modify the trie so exits on first prefix instead of searching all...
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


      /*
      else{
       if(dictionary.contains(temp)) {
         println(s"found word: $temp")
         position.legalNeighbors.flatMap(x=> findwords(prefix,x,words.::(temp)))
       }
       else position.legalNeighbors.flatMap(x=> findwords(prefix,x,words))
      }*/


    }

    findwords(new String,position,List.empty)
  }
    // should I use a function instead?

  /*
  sealed abstract class Move
  case object NW extends Move
  case object N  extends Move
  case object NE extends Move
  case object W  extends Move
  case object *  extends Move
  case object E  extends Move
  case object SW extends Move
  case object S  extends Move
  case object SE extends Move
  */



  //trie.foreach(println(_))
  //println(trie.findByPrefix("abe").length)

}

