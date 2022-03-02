package io.gifpack

import android.app.Application
import io.gifpack.core.di.useCases
import io.gifpack.di.viewModels
import org.koin.core.context.startKoin

class GifPackApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(useCases, viewModels)
        }
    }
}