package akkihi.KAuditoryAttention.ui

import akkihi.KAuditoryAttention.GameLevel
import akkihi.KAuditoryAttention.utils.ArrayDisplay
import akkihi.KAuditoryAttention.utils.Drawer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

class Game(
    val level: Int
): Drawer {

    @Composable
    override fun Draw() {
        var game = GameLevel(level)
        val grid = game.grid
        val scope = rememberCoroutineScope()
        scope.launch {
            while (true) {
                delay(500)
                game.printLevel()
                game.movePlayerTo(
                    game.movePlayerRandomly(
                        game.playerX,
                        game.playerY
                    )
                )
            }
        }
        Div {
            ArrayDisplay(grid)
        }
        Div {
            Text("Coords: ${game.playerX} ${game.playerY}")
        }
    }
}