package me.rerere.md3compat

import android.app.WallpaperManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color
import scheme.Scheme

@Throws(IllegalStateException::class)
fun Context.loadColorScheme(): List<CombinedColorScheme> {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
        val wallpaperManager = WallpaperManager.getInstance(this)
        val colors = wallpaperManager.getWallpaperColors(WallpaperManager.FLAG_SYSTEM)
        require(colors != null) { "Wallpaper colors are null" }

        val primary = colors.primaryColor.toArgb()
        val secondary = colors.secondaryColor?.toArgb()
        val tertiary = colors.tertiaryColor?.toArgb()

        mutableListOf<CombinedColorScheme>().apply {
            add(CombinedColorScheme.of(primary))
            secondary?.let {
                add(CombinedColorScheme.of(it))
            }
            tertiary?.let {
                add(CombinedColorScheme.of(it))
            }
        }
    } else {
        throw IllegalStateException("This method requires API level 24")
    }
}

// Represents a color scheme with light mode and dark mode colors
data class CombinedColorScheme(
    val light: ColorScheme,
    val dark: ColorScheme
) {
    companion object {
        @JvmStatic
        internal fun of(argb: Int) = CombinedColorScheme(
            light = Scheme.light(argb).toColorScheme(),
            dark = Scheme.dark(argb).toColorScheme()
        )
    }
}

// Convert internal scheme to Compose ColorScheme
private fun Scheme.toColorScheme(): ColorScheme = ColorScheme(
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
    surfaceTint = Color(this.shadow),
    inverseSurface = Color(this.inverseSurface),
    inverseOnSurface = Color(this.inverseOnSurface),
    error = Color(this.error),
    onError = Color(this.onError),
    errorContainer = Color(this.errorContainer),
    onErrorContainer = Color(this.onErrorContainer),
    outline = Color(this.outline),
)