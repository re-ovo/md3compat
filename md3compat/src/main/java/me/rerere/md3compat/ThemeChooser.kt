package me.rerere.md3compat

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.rerere.compose_setting.preference.rememberBooleanPreference
import me.rerere.compose_setting.preference.rememberIntPreference

@Composable
fun ThemeChooser(
    modifier: Modifier = Modifier
) {
    var dynamic by rememberBooleanPreference(
        key = "md3compat.dynamic",
        defaultValue = true
    )
    var themeIndex by rememberIntPreference(
        key = "md3compat.themeIndex",
        defaultValue = 0
    )
    var dynamicTab by remember(dynamic) {
        mutableStateOf(dynamic)
    }
    val dynamicColorSchemeList = dynamicColorSchemeList()
    val basicColorSchemeList = basicColorSchemeList()
    Column(
        modifier = modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TabButton(
                modifier = Modifier.weight(1f),
                selected = dynamicTab,
                onClick = {
                    dynamicTab = true
                }
            ) {
                Text(text = "动态颜色")
            }
            TabButton(
                modifier = Modifier.weight(1f),
                selected = !dynamicTab,
                onClick = {
                    dynamicTab = false
                }
            ) {
                Text(text = "基础颜色")
            }
        }
        Crossfade(dynamicTab) {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                if (it) {
                    itemsIndexed(dynamicColorSchemeList) { index, item ->
                        ColorSchemeIcon(
                            colorScheme = item,
                            checked = dynamic && index == themeIndex
                        ) {
                            themeIndex = index
                            dynamic = true
                        }
                    }
                } else {
                    itemsIndexed(basicColorSchemeList) { index, item ->
                        ColorSchemeIcon(
                            colorScheme = item,
                            checked = !dynamic && index == themeIndex
                        ) {
                            themeIndex = index
                            dynamic = false
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TabButton(
    modifier: Modifier,
    selected: Boolean,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier,
        onClick = {
            onClick()
        },
        shape = RoundedCornerShape(8.dp),
        color = if (selected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant,
        content = {
            Box(modifier = Modifier.padding(16.dp), contentAlignment = Alignment.Center) {
                content()
            }
        }
    )
}