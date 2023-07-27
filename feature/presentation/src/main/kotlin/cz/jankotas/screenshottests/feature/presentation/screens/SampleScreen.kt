package cz.jankotas.screenshottests.feature.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import cz.jankotas.screenshottests.coreui.PreviewBox
import cz.jankotas.screenshottests.coreui.R
import cz.jankotas.screenshottests.coreui.ScreenPreview
import cz.jankotas.screenshottests.coreui.components.AppBar
import cz.jankotas.screenshottests.coreui.components.ListItem
import cz.jankotas.screenshottests.coreui.components.SampleButton
import cz.jankotas.screenshottests.coreui.model.ListItemModel

@Composable
fun SampleScreen(
    onActionButtonClick: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            AppBar(title = stringResource(id = R.string.feature_title_text))
        },
        floatingActionButton = {
            SampleButton(
                text = stringResource(R.string.feature_button_open_showkase_text),
                onClick = onActionButtonClick,
            )
        },
        floatingActionButtonPosition = FabPosition.Center,
        containerColor = MaterialTheme.colorScheme.background,
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            item {
                Text(
                    modifier = Modifier
                        .padding(16.dp),
                    text = stringResource(R.string.feature_about_text),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
            items(5) { index ->
                ListItem(
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                    model = ListItemModel(
                        Icons.Filled.Done,
                        stringResource(id = R.string.feature_list_item_text, index + 1),
                    ),
                )
            }
        }
    }
}

@Composable
@ScreenPreview
fun SampleScreenPreview() {
    PreviewBox {
        SampleScreen()
    }
}
