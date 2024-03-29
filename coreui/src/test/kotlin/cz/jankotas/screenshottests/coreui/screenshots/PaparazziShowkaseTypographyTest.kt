package cz.jankotas.screenshottests.coreui.screenshots

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.airbnb.android.showkase.models.Showkase
import com.airbnb.android.showkase.models.ShowkaseBrowserTypography
import com.airbnb.android.showkase.ui.padding4x
import cz.jankotas.screenshottests.coreui.getMetadata
import org.junit.runners.Parameterized
import java.util.Locale

/**
 * Preview wrapping [ShowkaseBrowserTypography], creating content composable to display name of the
 * font style and then use the actual style on this text. It also overrides toString() to
 * set proper naming for screenshot file.
 *
 * @property showkaseBrowserTypography typography which was acquired and passed by showkase
 */
class TypographyPreview(
    private val showkaseBrowserTypography: ShowkaseBrowserTypography,
) : ScreenshotPreview {

    override val content: @Composable () -> Unit = {
        Text(
            text = showkaseBrowserTypography.typographyName.replaceFirstChar {
                it.titlecase(Locale.getDefault())
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding4x),
            style = showkaseBrowserTypography.textStyle,
        )
    }

    override fun toString(): String =
        "typography=${showkaseBrowserTypography.typographyGroup}:${showkaseBrowserTypography.typographyName}"
}

/**
 * Test class for screenshot testing of typography that is part of this module and contains showkase
 * annotation (@ShowkaseTypography).
 */
class TypographyTests(
    typographyPreview: TypographyPreview,
) : PaparazziShowkaseTest<TypographyPreview>(typographyPreview) {

    companion object {
        /**
         * Function to provide custom Parameterized runner to run tests over collection of given
         * attributes. In this case there is only one parameter [TypographyPreview].
         *
         * @return collection of arrays which contain [TypographyPreview]
         */
        @JvmStatic
        @Parameterized.Parameters(name = "{0}")
        fun data(): Collection<Array<Any>> {
            return Showkase.getMetadata().typographyList.map { arrayOf(TypographyPreview(it)) }
        }
    }
}
