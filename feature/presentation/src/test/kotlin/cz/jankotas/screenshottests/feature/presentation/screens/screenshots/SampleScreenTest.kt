package cz.jankotas.screenshottests.feature.presentation.screens.screenshots

import cz.jankotas.screenshottests.coreui.screenshots.PaparazziScreenTest
import cz.jankotas.screenshottests.coreui.screenshots.TestConfig
import cz.jankotas.screenshottests.feature.presentation.screens.SampleScreenPreview
import org.junit.Test

class SampleScreenTest(config: TestConfig) : PaparazziScreenTest(config) {

    @Test
    fun sampleScreenPreviewTest() {
        screenshotTest { SampleScreenPreview() }
    }
}
