package cz.jankotas.screenshottests.feature.presentation.screens

import cz.jankotas.screenshottests.coreui.FontScale
import cz.jankotas.screenshottests.coreui.PaparazziScreenTest
import cz.jankotas.screenshottests.coreui.Theme
import org.junit.Test

class SampleScreenTest(theme: Theme, fontScale: FontScale) : PaparazziScreenTest(theme, fontScale) {

    @Test
    fun sampleScreenPreviewTest() {
        screenshotTest { SampleScreenPreview() }
    }
}
