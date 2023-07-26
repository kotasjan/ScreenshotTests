package cz.jankotas.screenshottests.feature.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import cz.jankotas.screenshottests.coreui.R
import cz.jankotas.screenshottests.feature.presentation.components.SampleButton

@Composable
fun SampleScreen(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        SampleButton(text = stringResource(R.string.feature_button_text), onClick = {
            Toast.makeText(context, "Hey there!", Toast.LENGTH_SHORT).show()
        })
    }
}

@Composable
@Preview
fun SampleScreenPreview() {
}
