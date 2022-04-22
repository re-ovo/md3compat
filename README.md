# MD3Compat
Backward compatibility support for [Material You](https://m3.material.io) for Jetpack Compose projects
[中文说明在这里](README_CN.md)

## Screenshots


## Import to your project
1. Add `jitpack.io` to repositories in `settings.gradle`
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

2. Add dependencies to `build.gradle`
// TODO

## Basic API
```kotlin
@Composable
fun BasicAPIExample() {
    // Get all dynamic color schemes based on the wallpaper (Require Android 8.1+)
    val dynamicColorScheme = dynamicColorScheme(isSystemInDarkTheme())
    
    // Get all basic color schemes
    val basicColorScheme = basicColorScheme(isSystemInDarkTheme())
}
```