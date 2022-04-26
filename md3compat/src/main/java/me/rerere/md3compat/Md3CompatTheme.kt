package me.rerere.md3compat

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import me.rerere.compose_setting.preference.rememberBooleanPreference
import me.rerere.compose_setting.preference.rememberIntPreference

@Composable
fun Md3CompatTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    shapes: Shapes = MaterialTheme.shapes,
    typography: Typography = MaterialTheme.typography,
    content: @Composable () -> Unit
) {
    val dynamic by rememberBooleanPreference(
        key = "md3compat.dynamic",
        default = true
    )
    val themeIndex by rememberIntPreference(
        key = "md3compat.themeIndex",
        default = 0
    )
    val colorScheme = if(dynamic) {
        dynamicColorSchemeList(darkTheme)[themeIndex]
    } else {
        basicColorSchemeList(darkTheme)[themeIndex]
    }
    MaterialTheme(
        colorScheme = colorScheme,
        shapes = shapes,
        typography = typography,
        content = content
    )
}