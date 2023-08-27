package cz.jankotas.screenshottests.coretest

import com.android.resources.NightMode

/**
 * This class keep information about configuration of each screenshot test.
 *
 * @property device type of device on which should the screenshot be taken
 * @property nightMode to define if dark mode (night mode) is turned on
 * @property fontScale scaling of displayed text
 */
data class TestConfig(
    val device: Device,
    val nightMode: NightMode,
    val fontScale: Float,
) {
    override fun toString(): String {
        return "device=$device, nightMode=$nightMode, fontScale=$fontScale"
    }
}

/**
 * Defines types of devices which are used for tests.
 */
enum class Device {
    PIXEL_6, // phone
    PIXEL_C, // tablet
}
