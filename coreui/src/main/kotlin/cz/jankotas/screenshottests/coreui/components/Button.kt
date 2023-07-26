package cz.jankotas.screenshottests.coreui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import cz.jankotas.screenshottests.coreui.ComponentPreview
import cz.jankotas.screenshottests.coreui.PreviewBox

@Composable
fun SampleButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    textStyle: TextStyle = MaterialTheme.typography.labelLarge,
) {
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

@Composable
@ComponentPreview
fun SampleButtonPreview() {
    PreviewBox {
        SampleButton(text = "Button Text", onClick = { })
    }
}