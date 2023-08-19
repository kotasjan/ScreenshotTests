package cz.jankotas.screenshottests.coreui

import androidx.compose.runtime.Composable
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.android.ide.common.rendering.api.SessionParams
import com.android.resources.NightMode
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

/**
 * Class with common [Paparazzi] settings for screenshot tests.
 *
 * @param config configuration for given test (device, night mode, font scale)
 */
@RunWith(Parameterized::class)
abstract class PaparazziScreenTest(config: TestConfig) {
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
        renderingMode = SessionParams.RenderingMode.NORMAL,
    )

    /**
     * Function to provide custom Parameterized runner to run tests over collection of given
     * attributes. There is one parameter [TestConfig] that specifies configuration for each test.
     *
     * @return collection of arrays which contain theme and font scale
     */
    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{0}")
        fun data(): Collection<Array<Any>> {
            val devices = listOf(Device.PIXEL_6, Device.PIXEL_C)
            val fontScales = listOf(1f, 1.5f)
            val modes = listOf(NightMode.NIGHT, NightMode.NOTNIGHT)

            return devices.flatMap { device ->
                fontScales.flatMap { fontScale ->
                    modes.mapNotNull { mode ->
                        // Filter combination of dark mode and font scale 150% because it is unnecessary
                        if (mode == NightMode.NIGHT && fontScale == 1.5f) {
                            null
                        } else {
                            arrayOf(TestConfig(device, mode, fontScale))
                        }
                    }
                }
            }
        }
    }

    /**
     * Function to run paparazzi screenshot with given composable content using composition provider.
     *
     * @param content composable content of screen preview
     */
    fun screenshotTest(content: @Composable () -> Unit) {
        paparazzi.snapshot {
            content.invoke()
        }
    }
}
