package functions

import Rover

fun turnLeft(rover: Rover): String {
    println("turnLeft was called")

    when (rover.direction) {
        "N" -> rover.direction = "W"
        "W" -> rover.direction = "S"
        "S" -> rover.direction = "O"
        "O" -> rover.direction = "N"
    }
    return rover.direction
}

fun turnRight(rover: Rover): String {
    println("turnRight was called")

    when (rover.direction) {
        "N" -> rover.direction = "O"
        "O" -> rover.direction = "S"
        "S" -> rover.direction = "W"
        "W" -> rover.direction = "N"
    }
    return rover.direction
}

fun moveForward(rover: Rover): MutableMap<String, Int> {
    println("moveForward was called")
    //println("rover position before move ${rover.position}")
    println("rover travelLog before move ${rover.travelLog}")

    when (rover.direction) {
        "N" -> rover.position.merge("y", 1, Int::minus)
        "O" -> rover.position.merge("x", 1, Int::plus)
        "S" -> rover.position.merge("y", 1, Int::plus)
        "W" -> rover.position.merge("x", 1, Int::minus)
    }

    rover.travelLog.add(rover.position)
    //println("rover position after move ${rover.position}")
    println("rover travelLog after move ${rover.travelLog}")
    return rover.position
}

fun moveRover(rover: Rover, moveSequence: String): MutableMap<String, Int> {
    moveSequence.toLowerCase().forEach { move ->
        run {
            when (move) {
                'l' -> turnLeft(rover)
                'r' -> turnRight(rover)
                'f' -> moveForward(rover)
                else -> print("$move is not a valid move, enter 'l', 'r' or 'f' \n" )
            }
        }
    }
    println("rover travelLog ${rover.travelLog}")
    return rover.position
}

