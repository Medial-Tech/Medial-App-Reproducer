import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign

object Test {
    var text by mutableStateOf(TextFieldValue(""))
        private set

    private const val maxLength = 300

    private fun onTextChange(text: TextFieldValue) {
        if (text.text.length <= maxLength) this.text = text
    }

    @Composable
    fun Content() {
        val length = derivedStateOf { text.text.length }

        TextField(
            value = text,
            onValueChange = ::onTextChange,
            singleLine = false,
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text(
                    text = "${length.value}/$maxLength",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End
                )
            },
            placeholder = { Text(text = "Enter here") },
        )
    }
}