package cz.jankotas.screenshottests.coreui

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.unit.Density

/**
 * Font scaling of displayed text.
 *
 * @property value float representation of scaling
 */
enum class FontScale(val value: Float) {
    /**
     * Font scaling set to 100%. This is default scale configuration on Android phones.
     */
    Scale100(1f),

    /**
     * Font scaling set to 150%.
     */
    Scale150(1.5f),

    /**
     * Font scaling set to 200%. This is maximum scale configuration on Android phones.
     */
    Scale200(2f),
    ;

    override fun toString(): String {
        return when (this) {
            Scale100 -> "100pc"
            Scale150 -> "150pc"
            Scale200 -> "200pc"
        }
    }
}

/**
 * Theme to distinguish light and dark mode for screenshot test.
 */
enum class Theme {
    Light,
    Dark,
}

/**
 * Helper function for common settings of [CompositionLocalProvider] which is used in all tests.
 *
 * @param theme theme (light or dark)
 * @param fontScale font size scaling
 * @param content provided content which should be tested
 */
@Composable
internal fun compositionProvider(
    theme: Theme,
    fontScale: FontScale,
    content: @Composable () -> Unit,
) {
    val configuration = if (theme == Theme.Dark) {
        Configuration(LocalConfiguration.current).apply {
            uiMode = Configuration.UI_MODE_NIGHT_YES
        }
    } else {
        LocalConfiguration.current
    }

    CompositionLocalProvider(
        LocalInspectionMode provides true,
        LocalDensity provides Density(
            density = LocalDensity.current.density,
            fontScale = fontScale.value,
        ),
        LocalConfiguration provides configuration,
    ) {
        content.invoke()
    }
}
