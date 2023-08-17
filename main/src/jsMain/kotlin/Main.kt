package akkihi.KAuditoryAttention

import androidx.compose.runtime.mutableStateOf
import kotlinx.browser.window
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun main() {
    val scope = CoroutineScope(Dispatchers.Default)
    val mutab = mutableStateOf(0)
    window.addEventListener("load", {
        scope.launch {
            repeat(300) {
                mutab.value += 1
                console.log("console log is ${mutab.value}")
            }
        }
    })
}