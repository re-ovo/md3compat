package me.rerere.md3compat

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun ColorSchemeIcon(
    colorScheme: ColorScheme,
    checked: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .border(1.dp, colorScheme.outline, RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .size(64.dp)
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier.clip(CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Surface(
                modifier = Modifier.size(48.dp),
                color = colorScheme.primaryContainer
            ) {}
            Surface(
                modifier = Modifier
                    .size(24.dp)
                    .offset(x = (-12).dp, y = 12.dp),
                color = colorScheme.tertiaryContainer
            ) {}
            Surface(
                modifier = Modifier
                    .size(24.dp)
                    .offset(x = 12.dp, y = 12.dp),
                color = colorScheme.primary
            ) {}
            AnimatedVisibility(checked) {
                Icon(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(colorScheme.primary)
                        .padding(4.dp),
                    imageVector = Icons.Outlined.Check,
                    contentDescription = null
                )
            }
        }
    }
}