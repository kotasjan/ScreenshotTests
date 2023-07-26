package cz.jankotas.screenshottests.feature.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
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
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SampleScreen(
    modifier: Modifier = Modifier,
) {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = SheetState(
            skipPartiallyExpanded = true,
        ),
    )

    BottomSheetScaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        sheetPeekHeight = 0.dp,
        sheetContent = {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(stringResource(id = R.string.feature_bottom_sheet_title_text))
                Spacer(modifier = Modifier.height(16.dp))
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    items(50) { index ->
                        ListItem(
                            ListItemModel(
                                Icons.Filled.Done,
                                stringResource(id = R.string.feature_list_item_text, index + 1),
                            ),
                        )
                    }
                }
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
        ) {
            AppBar(title = stringResource(id = R.string.feature_title_text))
            Text(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f),
                text = stringResource(R.string.feature_about_text),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyMedium,
            )
            SampleButton(
                modifier = Modifier.padding(16.dp),
                text = stringResource(R.string.feature_button_open_button_sheet_text),
                onClick = {
                    scope.launch { scaffoldState.bottomSheetState.expand() }
                },
            )
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
