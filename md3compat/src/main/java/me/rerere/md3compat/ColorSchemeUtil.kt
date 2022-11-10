package me.rerere.md3compat

import android.app.WallpaperManager
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import palettes.CorePalette
import scheme.Scheme

// basic color scheme
private val basicColorScheme = listOf(
    0x5576b2,
    0x35845d,
    0x756eb1,
    0xa16b1c
)

/**
 * Get all basic color schemes.
 */
@Composable
fun basicColorSchemeList(
    darkTheme: Boolean = isSystemInDarkTheme()
): List<ColorScheme> {
    return remember(darkTheme) {
        basicColorScheme.map {
            it.asColorScheme(darkTheme)
        }
    }
}

/**
 * Get all dynamic color schemes based on the current wallpaper.
 */
@Composable
fun dynamicColorSchemeList(
    darkTheme: Boolean = isSystemInDarkTheme()
): List<ColorScheme> {
    val context = LocalContext.current
    return remember(context, darkTheme) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            val wallpaperManager = WallpaperManager.getInstance(context)
            val colors = wallpaperManager.getWallpaperColors(WallpaperManager.FLAG_SYSTEM)

            val primary = colors?.primaryColor?.toArgb()
            val secondary = colors?.secondaryColor?.toArgb()
            val tertiary = colors?.tertiaryColor?.toArgb()

            mutableListOf<ColorScheme>().apply {
                primary?.let {
                    add(it.asColorScheme(darkTheme))
                }
                secondary?.let {
                    add(it.asColorScheme(darkTheme))
                }
                tertiary?.let {
                    add(it.asColorScheme(darkTheme))
                }
            }
        } else {
            basicColorScheme.map {
                it.asColorScheme(darkTheme)
            }
        }
    }
}

private fun Int.asColorScheme(darkTheme: Boolean) = if(darkTheme) {
    Scheme.dark(this).toColorScheme(this)
} else {
    Scheme.light(this).toColorScheme(this)
}

// Convert internal scheme to Compose ColorScheme
private fun Scheme.toColorScheme(seed: Int): ColorScheme = ColorScheme(
    primary = Color(this.primary),
    onPrimary = Color(this.onPrimary),
    primaryContainer = Color(this.primaryContainer),
    onPrimaryContainer = Color(this.onPrimaryContainer),
    inversePrimary = Color(this.inversePrimary),
    secondary = Color(this.secondary),
    onSecondary = Color(this.onSecondary),
    secondaryContainer = Color(this.secondaryContainer),
    onSecondaryContainer = Color(this.onSecondaryContainer),
    tertiary = Color(this.tertiary),
    onTertiary = Color(this.onTertiary),
    tertiaryContainer = Color(this.tertiaryContainer),
    onTertiaryContainer = Color(this.onTertiaryContainer),
    background = Color(this.background),
    onBackground = Color(this.onBackground),
    surface = Color(this.surface),
    onSurface = Color(this.onSurface),
    surfaceVariant = Color(this.surfaceVariant),
    onSurfaceVariant = Color(this.onSurfaceVariant),
    surfaceTint = Color(this.primary),
    inverseSurface = Color(this.inverseSurface),
    inverseOnSurface = Color(this.inverseOnSurface),
    error = Color(this.error),
    onError = Color(this.onError),
    errorContainer = Color(this.errorContainer),
    onErrorContainer = Color(this.onErrorContainer),
    outline = Color(this.outline),
    outlineVariant = Color(this.outlineVariant),
    scrim = Color(CorePalette.of(seed).n1.tone(0))
)