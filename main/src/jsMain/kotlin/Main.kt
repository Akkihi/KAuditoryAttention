package akkihi.KAuditoryAttention

import akkihi.KAuditoryAttention.ui.Manager
import androidx.compose.runtime.mutableStateOf
import kotlinx.browser.window
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.renderComposable

fun main() {
    val scope = CoroutineScope(Dispatchers.Default)
    window.onload = {
        renderComposable("root") {
            Div {
                Manager.Draw()
            }
        }
    }
}