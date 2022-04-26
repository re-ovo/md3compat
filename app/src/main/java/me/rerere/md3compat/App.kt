package me.rerere.md3compat

import android.app.Application
import me.rerere.compose_setting.preference.initComposeSetting

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        initComposeSetting()
    }
}