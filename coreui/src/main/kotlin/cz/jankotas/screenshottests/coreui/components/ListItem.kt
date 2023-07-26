package cz.jankotas.screenshottests.coreui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import cz.jankotas.screenshottests.coreui.ComponentPreview
import cz.jankotas.screenshottests.coreui.PreviewBox
import cz.jankotas.screenshottests.coreui.model.ListItemModel

@Composable
fun ListItem(
    model: ListItemModel,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            imageVector = model.icon,
            contentDescription = model.text,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = model.text,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Composable
@ComponentPreview
fun ListItemPreview() {
    PreviewBox {
        ListItem(ListItemModel(icon = Icons.Default.Done, text = "Sample text"))
    }
}
