package cz.jankotas.screenshottests.coreui

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(name = "Light preview", showBackground = true)
@Preview(name = "Dark preview", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
annotation class ScreenPreview

/**
 * NOTE: There is currently bug in Showkase when using custom annotations of stacked previews and
 * skipPrivatePreviews at the same time. That's why I split it into two previews instead.
 * More info here: https://github.com/airbnb/Showkase/issues/312
 */
// @Preview(name = "Light preview", showBackground = true)
// @Preview(name = "Dark preview", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
// annotation class ComponentPreview

@Composable
fun PreviewBox(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    ScreenshotTestsTheme {
        Box(
            modifier = modifier.background(MaterialTheme.colorScheme.background),
        ) {
            content()
        }
    }
}
