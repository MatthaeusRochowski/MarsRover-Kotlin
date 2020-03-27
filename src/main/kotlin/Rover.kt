package main.kotlin

val position = Position()

class Rover(roverId: String) {
    // rover current position
    var currentPosition = position

    // rover direction
    var direction = "N"

    // travel log

    init {
        println("$roverId is in position x = ${currentPosition.x}, y = ${currentPosition.y} pointing to direction $direction")
    }
}
