package cz.jankotas.screenshottests.coreui

import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.android.ide.common.rendering.api.SessionParams
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

/**
 * Class with common [Paparazzi] settings for screenshot tests using the showkase library.
 *
 * @param T type of [ScreenshotPreview]
 * @param preview instance of specific [ScreenshotPreview] (component, typography or color)
 * @param theme dark or light theme configuration
 * @param fontScale displayed text scaling
 */
@RunWith(Parameterized::class)
abstract class PaparazziShowkaseTest<T : ScreenshotPreview>(
    private val preview: T,
    private val theme: Theme = Theme.Light,
    private val fontScale: FontScale = FontScale.Scale100,
) {
    /**
     * Paparazzi configuration.
     */
    @get:Rule
    val paparazzi = Paparazzi(
        maxPercentDifference = 0.0,
        showSystemUi = false,
        deviceConfig = DeviceConfig.PIXEL_5,
        renderingMode = SessionParams.RenderingMode.SHRINK,
    )

    /**
     * Test to run paparazzi screenshot with given composition configuration.
     */
    @Test
    fun screenshotTest() {
        paparazzi.snapshot {
            compositionProvider(
                theme = theme,
                fontScale = fontScale,
                content = preview.content,
            )
        }
    }
}
