package cz.jankotas.screenshottests.coreui

import androidx.compose.runtime.Composable
import com.airbnb.android.showkase.models.Showkase
import com.airbnb.android.showkase.models.ShowkaseBrowserComponent
import org.junit.runners.Parameterized

/**
 * Preview wrapping [ShowkaseBrowserComponent], accessing its content and overriding toString() to
 * set proper naming for screenshot file.
 *
 * @property showkaseBrowserComponent component which was acquired and passed by showkase
 */
class ComponentPreview(
    private val showkaseBrowserComponent: ShowkaseBrowserComponent,
) : ScreenshotPreview {
    override val content: @Composable () -> Unit = showkaseBrowserComponent.component
    override fun toString(): String =
        showkaseBrowserComponent.group + ":" + showkaseBrowserComponent.componentName + ":" + showkaseBrowserComponent.styleName
}

/**
 * Test class for screenshot testing of components that are part of this module and contain showkase
 * annotation (@ShowkaseComposable).
 */
class ComponentTests(
    componentPreview: ComponentPreview,
    theme: Theme,
    fontScale: FontScale,
) : PaparazziShowkaseTest<ComponentPreview>(componentPreview, theme, fontScale) {

    companion object {

        /**
         * Function to provide custom Parameterized runner to run tests over collection of given
         * attributes. There are three parameters of [ComponentPreview], [Theme] and [FontScale].
         *
         * @return combinations of these parameters as collection of arrays
         */
        @JvmStatic
        @Parameterized.Parameters(name = "{0}, {1}, {2}")
        fun data(): Collection<Array<Any>> {
            val componentPreviews = Showkase.getMetadata().componentList.map(::ComponentPreview)
            val fontScales = listOf(FontScale.Scale100, FontScale.Scale150)
            val themes = listOf(Theme.Light, Theme.Dark)

            return componentPreviews.flatMap { componentPreview ->
                fontScales.flatMap { fontScale ->
                    themes.mapNotNull { theme ->
                        if (theme == Theme.Dark && fontScale == FontScale.Scale150) {
                            null
                        } else {
                            arrayOf(componentPreview, theme, fontScale)
                        }
                    }
                }
            }
        }
    }
}
