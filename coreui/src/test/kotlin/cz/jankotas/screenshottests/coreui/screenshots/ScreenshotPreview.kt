package cz.jankotas.screenshottests.coreui.screenshots

import androidx.compose.runtime.Composable

/**
 * Interface for passing screenshot content of specific preview type to paparazzi test.
 */
interface ScreenshotPreview {
    /**
     * Content to be passed for paparazzi screenshot.
     */
    val content: @Composable () -> Unit
}
