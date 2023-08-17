package akkihi.KAuditoryAttention.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import org.jetbrains.compose.web.dom.Table
import org.jetbrains.compose.web.dom.Td
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Tr

@Composable
fun ArrayDisplay(
    array: Array<Array<MutableState<Int>>>
) {
    Table {
        array.forEach { row ->
            Tr {
                row.forEach { element ->
                    Td {
                        Text("${element.value}")
                    }
                }
            }
        }
    }
}