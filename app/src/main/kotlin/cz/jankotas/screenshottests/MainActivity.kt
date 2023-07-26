package cz.jankotas.screenshottests

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import cz.jankotas.screenshottests.ui.theme.ScreenshotTestsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenshotTestsTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) {

                }
            }
        }
    }
}
