package main.kotlin.functions

import main.kotlin.rover.Grid
import main.kotlin.rover.MoveDirection
import main.kotlin.rover.Rover

fun detectGridBoundary(rover: Rover, moveDirection: MoveDirection): Boolean {

    val grid = Grid().grid

    var onGrid = true
    val position = rover.currentPosition

    when (moveDirection) {
        MoveDirection.moveForward -> {
            when (rover.direction) {
                "N" -> if (position.y - 1 < grid[position.x][0]) onGrid = false
                "O" -> if (position.x + 1 >= grid.size) onGrid = false
                "S" -> if (position.y + 1 >= grid[position.x].size) onGrid = false
                "W" -> if (position.x - 1 < grid[0][position.y]) onGrid = false
            }
        }
        MoveDirection.moveBackward -> {
            when (rover.direction) {
                "N" -> if (position.y + 1 >= grid[position.x].size) onGrid = false
                "O" -> if (position.x - 1 < grid[0][position.y]) onGrid = false
                "S" -> if (position.y - 1 < grid[position.x][0]) onGrid = false
                "W" -> if (position.x + 1 >= grid.size) onGrid = false
            }
        }
    }

    return onGrid
}

fun detectObstacle(rover: Rover, moveDirection: MoveDirection): Boolean {

    val grid = Grid().grid
    val obs = Grid().obs

    val moveForwardOnGrid = detectGridBoundary(rover, MoveDirection.moveForward)
    val moveBackwardOnGrid = detectGridBoundary(rover, MoveDirection.moveBackward)

    var obstacle = false
    val position = rover.currentPosition

    when (moveDirection) {
        MoveDirection.moveForward -> {
            if (moveForwardOnGrid) {
                when (rover.direction) {
                    "N" -> if (grid[position.y - 1][position.x] == obs) obstacle = true
                    "O" -> if (grid[position.y][position.x + 1] == obs) obstacle = true
                    "S" -> if (grid[position.y + 1][position.x] == obs) obstacle = true
                    "W" -> if (grid[position.y][position.x - 1] == obs) obstacle = true
                }
            }
        }
        MoveDirection.moveBackward -> {
            if (moveBackwardOnGrid) {
                when (rover.direction) {
                    "N" -> if (grid[position.y + 1][position.x] == obs) obstacle = true
                    "O" -> if (grid[position.y][position.x - 1] == obs) obstacle = true
                    "S" -> if (grid[position.y - 1][position.x] == obs) obstacle = true
                    "W" -> if (grid[position.y][position.x + 1] == obs) obstacle = true
                }
            }
        }
    }

    return obstacle
}
