package main.kotlin.functions

import main.kotlin.Position
import main.kotlin.Rover

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

fun moveForward(rover: Rover): Position {
    println("moveForward was called")

    var position = rover.currentPosition
    //println("rover position before move x = ${position.x}, y = ${position.y}")
    val travelLog = rover.travelLog

    when (rover.direction) {
        "N" -> position.y--
        "O" -> position.x++
        "S" -> position.y++
        "W" -> position.x--
    }

    travelLog.add(listOf(position.x, position.y))

    println("moved to position x = ${position.x}, y = ${position.y}")

    return position
}

fun moveRover(rover: Rover, moveSequence: String): Rover {


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

    return rover
}

