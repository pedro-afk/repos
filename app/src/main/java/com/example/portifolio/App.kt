package com.example.portifolio

import android.app.Application
import com.example.portifolio.data.di.DataModule
import com.example.portifolio.domain.di.DomainModule
import com.example.portifolio.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App: Application() {
    //val a1 by lazy { DataModule.load() }
    //val a2 by lazy { DomainModule.load() }
    //val a3 by lazy { PresentationModule.load() }

    val appModule = module {

    }

    override fun onCreate() {
        startKoin {
            androidLogger()
            androidContext(this@App)
            DataModule.load()
            DomainModule.load()
            PresentationModule.load()
        }

    }

}