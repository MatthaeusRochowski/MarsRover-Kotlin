package main.kotlin.functions

import main.kotlin.Grid
import main.kotlin.Rover

fun detectGridBoundary (rover: Rover, grid: Grid): Boolean {

    var onGrid = true
    val position = rover.currentPosition

    when (rover.direction) {
        "N" -> if (position.y - 1 < grid.grid[position.x][0]) onGrid = false
        "O" -> if (position.x + 1 >= grid.grid.size) onGrid = false
        "S" -> if (position.y + 1 > grid.grid[position.x][9]) onGrid = false
        "W" -> if (position.x - 1 < grid.grid[0][position.y]) onGrid = false
    }
    return onGrid
}
