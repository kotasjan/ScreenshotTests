package cz.jankotas.screenshottests.coreui

import androidx.compose.runtime.Composable
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.android.ide.common.rendering.api.SessionParams
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

/**
 * Class with common [Paparazzi] settings for screenshot tests.
 *
 * @param theme color configuration for test (light or dark)
 * @param fontScale scaling of displayed font
 */
@RunWith(Parameterized::class)
abstract class PaparazziScreenTest(
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
        renderingMode = SessionParams.RenderingMode.NORMAL,
    )

    /**
     * Function to provide custom Parameterized runner to run tests over collection of given
     * attributes. In this case there are two parameters (theme and fontscale) that specify
     * configuration of each test.
     *
     * @return collection of arrays which contain theme and font scale
     */
    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{0}, {1}")
        fun data(): Collection<Array<Any>> {
            val fontScales = listOf(FontScale.Scale100, FontScale.Scale150)
            val themes = listOf(Theme.Light, Theme.Dark)

            return fontScales.flatMap { fontScale ->
                themes.mapNotNull { theme ->
                    // Filter combination of dark mode and font scale 150% because it is unnecessary
                    if (theme == Theme.Dark && fontScale == FontScale.Scale150) {
                        null
                    } else {
                        arrayOf(theme, fontScale)
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
            compositionProvider(theme = theme, fontScale = fontScale, content = content)
        }
    }
}
