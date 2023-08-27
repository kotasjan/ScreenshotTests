package cz.jankotas.screenshottests.feature.presentation.screens.screenshots

import cz.jankotas.screenshottests.coretest.PaparazziScreenTest
import cz.jankotas.screenshottests.coretest.TestConfig
import cz.jankotas.screenshottests.feature.presentation.screens.SampleScreenPreview
import org.junit.Test

class SampleScreenTest(config: TestConfig) : PaparazziScreenTest(config) {

    @Test
    fun sampleScreenPreviewTest() {
        screenshotTest { SampleScreenPreview() }
    }
}
