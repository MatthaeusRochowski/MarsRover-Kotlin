class Rover(roverId: String) {
    // rover position
    var position = mutableMapOf("x" to 0, "y" to 0)

    // rover direction
    var direction = "N"

    // travel log
    var travelLog = mutableListOf(mutableMapOf("x" to 0, "y" to 0))

    init {
        println("Rover $roverId is in position $position pointing to direction $direction")
    }
}
