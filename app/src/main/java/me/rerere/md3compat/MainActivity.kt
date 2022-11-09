package me.rerere.md3compat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

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
                        modifier = Modifier.padding(it),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        TabRow(0) {
                            Tab(
                                selected = true,
                                onClick = { /*TODO*/ },
                                text = {
                                    Text("Tab 1")
                                }
                            )
                            Tab(
                                selected = false,
                                onClick = { /*TODO*/ },
                                text = {
                                    Text("Tab 2")
                                }
                            )
                            Tab(
                                selected = false,
                                onClick = { /*TODO*/ },
                                text = {
                                    Text("Tab 3")
                                }
                            )
                        }
                        ThemeChooser()
                        Surface(
                            tonalElevation = 8.dp,
                            onClick = {

                            }
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(100.dp)
                                    .padding(16.dp)
                            ) {
                                Text(text = "ces")
                            }
                        }
                    }
                }
            }
        }
    }
}