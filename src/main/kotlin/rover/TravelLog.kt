package main.kotlin.rover

import main.kotlin.rover.Position

class TravelLog (position: Position) {
    val log = mutableListOf((listOf(position.x, position.y)))
}