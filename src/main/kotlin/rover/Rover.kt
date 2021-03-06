package main.kotlin.rover

val position = Position()

class Rover(roverId: String) {
    //rover name
    val name = roverId

    // rover current position
    var currentPosition = position

    // rover direction
    var direction = "N"

    // travel log
    val travelLog = TravelLog(currentPosition).log

    init {
        println("$roverId is in position x = ${currentPosition.x}, y = ${currentPosition.y} pointing to direction $direction")
    }
}
