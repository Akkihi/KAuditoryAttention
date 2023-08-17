package akkihi.KAuditoryAttention

import akkihi.KAuditoryAttention.utils.nextGaussian
import androidx.compose.runtime.mutableStateOf
import kotlin.random.Random

class GameLevel(
    val size: Int
) {
    val grid = Array(size) {
        Array(size) {
            mutableStateOf(0)
        }
    }
    private var playerX: Int = 0
    private var playerY: Int = 0
    init {
        playerX = generateCenteredCoordinate(size)
        playerY = generateCenteredCoordinate(size)
        grid[playerX][playerY].value = 1
    }

    fun movePlayerStraight(): Direction {
        grid[playerX][playerY].value = 0

        val directions = listOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1))
        val validDirections = directions.filter { isValidMove(playerX + it.first, playerY + it.second) }
        val (deltaX, deltaY) = validDirections.random()

        playerX = (playerX + deltaX).coerceIn(0, size - 1)
        playerY = (playerY + deltaY).coerceIn(0, size - 1)

        val direction = when {
            deltaX == -1 -> Direction.Up
            deltaX == 1 -> Direction.Down
            deltaY == -1 -> Direction.Left
            deltaY == 1 -> Direction.Right
            else -> Direction.Zero
        }
        grid[playerX][playerY].value = 1
        return direction
    }

    private fun isValidMove(x: Int, y: Int): Boolean {
        return x in 0 until size && y in 0 until size && grid[x][y].value == 0
    }

    fun printLevel() {
        for (i in 0 until size) {
            for (j in 0 until size) {
                print("${grid[i][j].value} ")
            }
            println()
        }
    }

    private fun generateCenteredCoordinate(size: Int): Int {
        val center = size / 2
        val spread = size * 0.4
        return (center + Random.nextGaussian() * spread).toInt().coerceIn(0, size - 1)
    }
}