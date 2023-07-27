package cz.jankotas.screenshottests.coreui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.android.showkase.annotation.ShowkaseComposable
import cz.jankotas.screenshottests.coreui.PreviewBox

@Composable
fun SampleButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    type: ButtonType,
    textStyle: TextStyle = MaterialTheme.typography.labelLarge,
) {
    when (type) {
        ButtonType.Filled -> {
            Button(
                onClick = onClick,
                modifier = modifier,
                enabled = isEnabled,
                shape = RoundedCornerShape((100.dp)),
            ) {
                Text(
                    text = text,
                    style = textStyle,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.padding(8.dp),
                )
            }
        }

        ButtonType.Outlined -> {
            OutlinedButton(
                onClick = onClick,
                modifier = modifier,
                enabled = isEnabled,
                shape = RoundedCornerShape((100.dp)),
            ) {
                Text(
                    text = text,
                    style = textStyle,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.padding(8.dp),
                )
            }
        }
    }
}

enum class ButtonType {
    Filled,
    Outlined,
}

@Composable
@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun SampleButtonLocalPreview() {
    Column {
        SampleButtonFilledPreview()
        SampleButtonOutlinedPreview()
    }
}

@Composable
@ShowkaseComposable(name = "SampleButton", group = "Controls", styleName = "Filled")
fun SampleButtonFilledPreview() {
    PreviewBox {
        SampleButton(text = "Button Text", type = ButtonType.Filled, onClick = { })
    }
}

@Composable
@ShowkaseComposable(name = "SampleButton", group = "Controls", styleName = "Outlined")
fun SampleButtonOutlinedPreview() {
    PreviewBox {
        SampleButton(text = "Button Text", type = ButtonType.Outlined, onClick = { })
    }
}
