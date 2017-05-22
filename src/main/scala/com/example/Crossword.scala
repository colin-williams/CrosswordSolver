package com.example
class Crossword(charArrs: Array[Char]*) {
  val varargs = charArrs

  case class Position(row: Int, col: Int) {
    def move(dy: Int, dx: Int): Position = new Position(row = row + dy, col = col + dx)

    def northwest = move(-1, -1)

    def north = move(-1, 0)

    def northeast = move(-1, 1)

    def west = move(0, -1)

    def stay = this

    def east = move(0, 1)

    def southwest = move(1, -1)

    def south = move(1, 0)

    def southeast = move(1, 1)

    def neighbors: List[Position] = List(northwest, north, northeast, west, stay, east, southwest, south, southeast)

    def legalNeighbors: List[Position] = neighbors.filter(x => x.isLegal)

    def isLegal: Boolean = varargs.isDefinedAt(row) && varargs(row).isDefinedAt(col)

    def charAt: Char = varargs(row)(col)
  }
}
