# MD3Compat
为Jetpack Compose提供旧版本安卓版本的 [Material You](https://m3.material.io) 支持.
本项目基于 [material-color-utilities](https://github.com/material-foundation/material-color-utilities) 的取色库

## 截图
![](arts/screenshot.png)

## 导入到你的项目
1. 添加jitpack仓库
```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...
        maven {
            url 'https://jitpack.io'
        }
    }
}
```

2. 添加依赖 
```groovy

```

## 基础API 
```kotlin
@Composable
fun BasicAPIExample() {
    // Get all dynamic color schemes based on the wallpaper (Require Android 8.1+)
    val dynamicColorScheme: List<ColorScheme> = dynamicColorScheme(isSystemInDarkTheme())
    
    // Get all basic color schemes
    val basicColorScheme: List<ColorScheme> = basicColorScheme(isSystemInDarkTheme())
}
```

## 高级API
```kotlin
// 将其作为你的主题
Md3CompatTheme {
    // 内容
}

// 展示一个颜色选择器, 如上面截图所示
ThemeChooser()
```