package ru.justneedcoffee.zennotes

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.justneedcoffee.zennotes.di.appModule
import ru.justneedcoffee.zennotes.di.dataModule
import ru.justneedcoffee.zennotes.di.domainModule

class ZenNotesApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ZenNotesApp)
            modules(
                appModule,
                domainModule,
                dataModule
            )
        }
    }
}