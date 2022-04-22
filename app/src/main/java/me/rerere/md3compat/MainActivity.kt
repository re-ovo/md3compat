package me.rerere.md3compat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Md3CompatTheme {
                Scaffold(
                    topBar = {
                        LargeTopAppBar(
                            title = {
                                Text(text = "MD3 Theme Compat")
                            }
                        )
                    }
                ) {
                    Column(
                        modifier = Modifier.padding(it)
                    ) {
                        ThemeChooser()
                    }
                }
            }
        }
    }
}
