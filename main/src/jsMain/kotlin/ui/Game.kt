package akkihi.KAuditoryAttention.ui

import akkihi.KAuditoryAttention.Direction
import akkihi.KAuditoryAttention.GameLevel
import akkihi.KAuditoryAttention.utils.ArrayDisplay
import akkihi.KAuditoryAttention.utils.Drawer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.dom.Audio
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.Audio

class Game(
    val level: Int
): Drawer {

    @Composable
    override fun Draw() {
        var game = GameLevel(level)
        val grid = game.grid
        val scope = rememberCoroutineScope()
        val direction = mutableStateOf<Direction>(Direction.Zero)
        val countDirection = mutableStateOf<Int>(0)
        val audio = Audio()
        scope.launch {
            while (true) {
                delay(2000)
                game.printLevel()
                direction.value = game.movePlayerStraight()
                countDirection.value += 1

                when (direction.value) {
                    Direction.Right,
                    Direction.Left,
                    Direction.Up,
                    Direction.Down -> {
                        audio.src = "sounds/female/${direction.value.name.lowercase().plus(".ogg")}"
                        audio.play()
                    }
                    else -> Direction.Zero
                }
            }
        }

        Div {
            ArrayDisplay(grid)
        }

        Div {
            Text("Игрок двигается в ${direction.value.name} кол-во ходов ${countDirection.value}")
        }
    }
}