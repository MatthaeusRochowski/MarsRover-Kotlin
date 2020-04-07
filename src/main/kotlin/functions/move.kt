package main.kotlin.functions

import main.kotlin.rover.MoveDirection
import main.kotlin.rover.Position
import main.kotlin.rover.Rover

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

    val onGrid = detectGridBoundary(rover, MoveDirection.moveForward)
    val obstacle = detectObstacle(rover, MoveDirection.moveForward)
    var position = rover.currentPosition
    val travelLog = rover.travelLog

    if (onGrid) {
        if (!obstacle) {
            when (rover.direction) {
                "N" -> position.y--
                "O" -> position.x++
                "S" -> position.y++
                "W" -> position.x--
            }
            travelLog.add(listOf(position.x, position.y))
            println("moved to position x = ${position.x}, y = ${position.y}")
        } else {
            println("${rover.name} detected an obstacle. Can´t move!")
        }
    } else {
        println("${rover.name} can´t move outside the grid!")
    }

    return position
}

fun moveBackward(rover: Rover): Position {
    println("moveBackward was called")

    val onGrid = detectGridBoundary(rover, MoveDirection.moveBackward)
    val obstacle = detectObstacle(rover, MoveDirection.moveBackward)
    var position = rover.currentPosition
    val travelLog = rover.travelLog

    if (onGrid) {
        if (!obstacle) {
            when (rover.direction) {
                "N" -> position.y++
                "O" -> position.x--
                "S" -> position.y--
                "W" -> position.x++
            }
            travelLog.add(listOf(position.x, position.y))
            println("moved to position x = ${position.x}, y = ${position.y}")
        }
        else {
            println("${rover.name} detected an obstacle. Can´t move!")
        }
    } else {
        println("${rover.name} can´t move outside the grid")
    }

    return position
}

fun moveRover(rover: Rover, moveSequence: String): Rover {


    moveSequence.toLowerCase().forEach { move ->
        run {
            when (move) {
                'l' -> turnLeft(rover)
                'r' -> turnRight(rover)
                'f' -> moveForward(rover)
                'b' -> moveBackward(rover)
                else -> print("$move is not a valid move, enter 'l', 'r', 'f' or 'b' \n" )
            }
        }
    }

    return rover
}

