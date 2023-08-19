package cz.jankotas.screenshottests.coreui

import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.android.ide.common.rendering.api.SessionParams
import com.android.resources.NightMode
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

/**
 * Class with common [Paparazzi] settings for screenshot tests using the showkase library.
 *
 * @param T type of [ScreenshotPreview]
 * @param preview instance of specific [ScreenshotPreview] (component, typography or color)
 * @param config configuration for given test (device, night mode, font scale)
 */
@RunWith(Parameterized::class)
abstract class PaparazziShowkaseTest<T : ScreenshotPreview>(
    private val preview: T,
    config: TestConfig = TestConfig(Device.PIXEL_6, NightMode.NOTNIGHT, 1f),
) {
    /**
     * Paparazzi configuration.
     */
    @get:Rule
    val paparazzi = Paparazzi(
        maxPercentDifference = 0.0,
        showSystemUi = false,
        deviceConfig = when (config.device) {
            Device.PIXEL_6 -> DeviceConfig.PIXEL_6
            Device.PIXEL_C -> DeviceConfig.PIXEL_C
        }.copy(
            nightMode = config.nightMode,
            fontScale = config.fontScale,
        ),
        renderingMode = SessionParams.RenderingMode.SHRINK,
    )

    /**
     * Test to run paparazzi screenshot with given composition configuration.
     */
    @Test
    fun screenshotTest() {
        paparazzi.snapshot {
            preview.content.invoke()
        }
    }
}
