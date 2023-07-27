package cz.jankotas.screenshottests.coreui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.android.showkase.annotation.ShowkaseComposable
import cz.jankotas.screenshottests.coreui.PreviewBox

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    navigationIcon: @Composable () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        modifier = modifier.fillMaxWidth(),
        title = {
            Text(
                text = title ?: "",
                style = MaterialTheme.typography.titleLarge,
            )
        },
        navigationIcon = navigationIcon,
    )
}

/**
 * NOTE: There is currently bug in Showkase when using custom annotations of stacked previews and
 * skipPrivatePreviews at the same time. That's why I split it into two previews instead.
 * More info here: https://github.com/airbnb/Showkase/issues/312
 */
@Composable
@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun AppBarLocalPreview() {
    Column {
        AppBarPreview1()
        AppBarPreview2()
    }
}

@Composable
@ShowkaseComposable(name = "AppBar", group = "Navigation", styleName = "Icon + Title")
fun AppBarPreview1() {
    PreviewBox {
        AppBar(
            title = "Title",
            navigationIcon = {
                IconButton(
                    onClick = { },
                    content = {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                        )
                    },
                )
            },
        )
    }
}

@Composable
@ShowkaseComposable(name = "AppBar", group = "Navigation", styleName = "Title")
fun AppBarPreview2() {
    PreviewBox {
        AppBar(title = "Title")
    }
}
