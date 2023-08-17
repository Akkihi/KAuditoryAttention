package akkihi.KAuditoryAttention.ui

import akkihi.KAuditoryAttention.Layer
import akkihi.KAuditoryAttention.globalSettings
import akkihi.KAuditoryAttention.utils.Drawer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf

object Manager : Drawer {
    val layer = mutableStateOf<Layer>(Layer.Menu)

    @Composable
    override fun Draw() {
        console.log("Stating app")
        when(layer.value) {
            Layer.Menu -> Menu.also {
                console.log("Menu Layer")
            }
            Layer.Settings -> Settings().also {
                console.log("Settings Layer")
            }
            Layer.Game -> Game(globalSettings.value).also {
                console.log("Game Layer")
            }
        }.Draw()
    }
}