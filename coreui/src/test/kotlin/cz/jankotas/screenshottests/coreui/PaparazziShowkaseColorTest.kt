package cz.jankotas.screenshottests.coreui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.android.showkase.models.Showkase
import com.airbnb.android.showkase.models.ShowkaseBrowserColor
import org.junit.runners.Parameterized

/**
 * Preview wrapping [ShowkaseBrowserColor] in a box and also displays color's name. It also overrides
 * toString() to set proper naming for screenshot file.
 *
 * @property colorBrowserColor color which was acquired and passed by showkase
 */
class ColorPreview(
    private val colorBrowserColor: ShowkaseBrowserColor,
) : ScreenshotPreview {

    override val content: @Composable () -> Unit = {
        PreviewBox {
            val backgroundColor = colorBrowserColor.color
            val textColor = if (backgroundColor.luminance() < 0.5) {
                Color.White
            } else {
                Color.Black
            }
            Box(
                modifier = Modifier.fillMaxWidth().height(200.dp).background(backgroundColor),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = colorBrowserColor.colorName,
                    fontSize = 18.sp,
                    color = textColor,
                )
            }
        }
    }

    override fun toString(): String =
        "color=${colorBrowserColor.colorGroup}:${colorBrowserColor.colorName}"
}

/**
 * Test class for screenshot testing of all colors that are part the theme and contain showkase annotation
 * (@ShowkaseColor).
 */
class ColorTests(
    colorPreview: ColorPreview,
) : PaparazziShowkaseTest<ColorPreview>(colorPreview) {

    companion object {
        /**
         * Function to provide custom Parameterized runner to run tests over collection of given
         * attributes. In this case there is only one parameter [ColorPreview].
         *
         * @return collection of arrays which contain [ColorPreview]
         */
        @JvmStatic
        @Parameterized.Parameters(name = "{0}")
        fun data(): Collection<Array<Any>> {
            return Showkase.getMetadata().colorList.map { arrayOf(ColorPreview(it)) }
        }
    }
}
