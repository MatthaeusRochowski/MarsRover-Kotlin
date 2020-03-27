package main.kotlin

import main.kotlin.functions.moveRover

val heribert = Rover("Heribert")

fun main() {
    moveRover(heribert, "llffwrf")
    println("Heribert stopped in position x = ${heribert.currentPosition.x}, y = ${heribert.currentPosition.y} pointing to direction ${heribert.direction}")
}