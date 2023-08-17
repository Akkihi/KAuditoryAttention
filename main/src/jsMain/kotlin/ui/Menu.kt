package akkihi.KAuditoryAttention.ui

import akkihi.KAuditoryAttention.Layer
import akkihi.KAuditoryAttention.utils.Drawer
import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text

object Menu: Drawer {
    @Composable
    override fun Draw() {
        Button(
            attrs = {
                onClick {
                   Manager.layer.value = Layer.Game
                }
            }
        ) {
            Text("Start Game")
        }
    }
}