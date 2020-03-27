import functions.moveRover

val heribert = Rover("Heribert")

fun main() {
    moveRover(heribert, "llffwrf")
    println("Heribert stopped in position ${heribert.position} pointing to direction ${heribert.direction}")
}