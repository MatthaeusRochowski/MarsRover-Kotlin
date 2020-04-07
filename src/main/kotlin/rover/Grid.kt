package main.kotlin.rover



class Grid {

    // obstacles
    val obs = 99

    val grid = listOf(
        listOf(0, 1, 2, 3, 4, obs, 6, 7, 8, 9),
        listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9),
        listOf(obs, 1, 2, 3, 4, obs, 6, 7, 8, 9),
        listOf(0, 1, obs, 3, 4, 5, 6, 7, 8, 9),
        listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9),
        listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, obs),
        listOf(obs, 1, 2, 3, 4, 5, 6, 7, 8, 9),
        listOf(0, 1, 2, 3, 4, 5, 6, obs, 8, 9),
        listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9),
        listOf(0, 1, 2, obs, 4, 5, 6, 7, 8, 9)
    )
}