package akkihi.KAuditoryAttention

import akkihi.KAuditoryAttention.ui.Manager
import kotlinx.browser.window
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.renderComposable

fun main() {
    window.onload = {
        renderComposable("root") {
            Div {
                Manager.Draw()
            }
        }
    }
}