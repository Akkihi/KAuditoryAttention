package akkihi.KAuditoryAttention

import akkihi.KAuditoryAttention.utils.nextGaussian
import androidx.compose.runtime.mutableStateOf
import kotlin.random.Random

class GameLevel(
    val size: Int
) {
    val grid = mutableStateOf(
        Array(size) {
            IntArray(size) { 0 }
        }
    )
    var playerX: Int = 0
    var playerY: Int = 0
    init {
        // Генерируем координаты игрока
        playerX = generateCenteredCoordinate(size)
        playerY = generateCenteredCoordinate(size)
        grid.value[playerX][playerY] = 1
    }

    fun movePlayerRandomly(
        playerX: Int,
        playerY: Int
    ): Pair<Int,Int> {
        // Генерируем случайное направление для следующего хода
        val deltaX = Random.nextInt(-1, 2) // -1, 0, 1
        val deltaY = Random.nextInt(-1, 2) // -1, 0, 1

        // Вычисляем новые координаты с учетом направления
        val newX = (playerX + deltaX).coerceIn(0, size - 1)
        val newY = (playerY + deltaY).coerceIn(0, size - 1)

        return Pair(newX, newY)
    }

    fun movePlayerTo(coords: Pair<Int,Int>) {
        grid.value[playerX][playerY] = 0
        // Обновляем координаты игрока
        playerX = coords.first
        playerY = coords.second
        // Помещаем игрока на новую позицию
        grid.value[playerX][playerY] = 1
    }

    fun printLevel() {
        for (i in 0 until size) {
            for (j in 0 until size) {
                print("${grid.value[i][j]} ")
            }
            println()
        }
    }

    private fun generateCenteredCoordinate(size: Int): Int {
        val center = size / 2
        val spread = size * 0.4 // Коэффициент разброса (меньше - шире разброс)
        return (center + Random.nextGaussian() * spread).toInt().coerceIn(0, size - 1)
    }
}