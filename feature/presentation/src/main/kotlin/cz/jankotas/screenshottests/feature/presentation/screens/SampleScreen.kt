package cz.jankotas.screenshottests.feature.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import cz.jankotas.screenshottests.coreui.PreviewBox
import cz.jankotas.screenshottests.coreui.R
import cz.jankotas.screenshottests.coreui.ScreenPreview
import cz.jankotas.screenshottests.coreui.components.AppBar
import cz.jankotas.screenshottests.coreui.components.SampleButton

@Composable
fun SampleScreen(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        AppBar(title = stringResource(id = R.string.feature_title_text))
        Text(
            modifier = Modifier.padding(20.dp, 16.dp)
                .weight(1f),
            text = stringResource(R.string.feature_about_text),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodyMedium,
        )
        SampleButton(
            modifier = Modifier.padding(20.dp, 16.dp, 20.dp, 20.dp),
            text = stringResource(R.string.feature_button_text),
            onClick = {
                Toast.makeText(context, "Hey there!", Toast.LENGTH_SHORT).show()
            },
        )
    }
}

@Composable
@ScreenPreview
fun SampleScreenPreview() {
    PreviewBox {
        SampleScreen()
    }
}
