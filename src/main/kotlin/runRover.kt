package main.kotlin

import main.kotlin.functions.moveRover

val heribert = Rover("Heribert")
val grid = Grid()

fun main() {
    grid
    moveRover(heribert, "llffffffffffffffflffffffffffffffffffabc")
    println("Heribert stopped in position x = ${heribert.currentPosition.x}, y = ${heribert.currentPosition.y} pointing to direction ${heribert.direction}")
    println("Heribert`s travelLog: ${heribert.travelLog}")
}