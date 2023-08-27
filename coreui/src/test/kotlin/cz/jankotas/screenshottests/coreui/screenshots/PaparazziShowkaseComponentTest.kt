package cz.jankotas.screenshottests.coreui.screenshots

import androidx.compose.runtime.Composable
import com.airbnb.android.showkase.models.Showkase
import com.airbnb.android.showkase.models.ShowkaseBrowserComponent
import com.android.resources.NightMode
import cz.jankotas.screenshottests.coretest.Device
import cz.jankotas.screenshottests.coretest.TestConfig
import cz.jankotas.screenshottests.coreui.getMetadata
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
    override fun toString(): String = "component=${
        listOfNotNull(
            showkaseBrowserComponent.group,
            showkaseBrowserComponent.componentName,
            showkaseBrowserComponent.styleName,
        ).joinToString(":")
    }"
}

/**
 * Test class for screenshot testing of components that are part of this module and contain showkase
 * annotation (@ShowkaseComposable).
 */
class ComponentTests(
    componentPreview: ComponentPreview,
    config: TestConfig,
) : PaparazziShowkaseTest<ComponentPreview>(componentPreview, config) {

    companion object {

        /**
         * Function to provide custom Parameterized runner to run tests over collection of given
         * attributes. There are two parameters of [ComponentPreview] and [TestConfig].
         *
         * @return combinations of these parameters as collection of arrays
         */
        @JvmStatic
        @Parameterized.Parameters(name = "{0}, {1}")
        fun data(): Collection<Array<Any>> {
            val componentPreviews = Showkase.getMetadata().componentList.map(::ComponentPreview)
            val fontScales = listOf(1f, 1.5f)
            val modes = listOf(NightMode.NIGHT, NightMode.NOTNIGHT)

            return componentPreviews.flatMap { componentPreview ->
                fontScales.flatMap { fontScale ->
                    modes.mapNotNull { mode ->
                        if (mode == NightMode.NIGHT && fontScale == 1.5f) {
                            null
                        } else {
                            arrayOf(componentPreview, TestConfig(Device.PIXEL_6, mode, fontScale))
                        }
                    }
                }
            }
        }
    }
}
