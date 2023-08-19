package cz.jankotas.screenshottests.feature.presentation.screens

import cz.jankotas.screenshottests.coreui.PaparazziScreenTest
import cz.jankotas.screenshottests.coreui.TestConfig
import org.junit.Test

class SampleScreenTest(config: TestConfig) : PaparazziScreenTest(config) {

    @Test
    fun sampleScreenPreviewTest() {
        screenshotTest { SampleScreenPreview() }
    }
}
