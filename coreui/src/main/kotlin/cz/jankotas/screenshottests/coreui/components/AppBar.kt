package cz.jankotas.screenshottests.coreui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cz.jankotas.screenshottests.coreui.ComponentPreview
import cz.jankotas.screenshottests.coreui.PreviewBox

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    navigationIcon: @Composable () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        modifier = modifier.fillMaxWidth(),
        title = {
            Text(
                text = title ?: "",
                style = MaterialTheme.typography.titleLarge,
            )
        },
        navigationIcon = navigationIcon,
    )
}

@Composable
@ComponentPreview
fun AppBarPreview() {
    PreviewBox {
        Column {
            AppBar(
                title = "Title",
                navigationIcon = {
                    IconButton(
                        onClick = { },
                        content = {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back",
                            )
                        },
                    )
                },
            )
            AppBar(title = "Title")
        }
    }
}
