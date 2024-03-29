package com.example.realestateapp

import android.app.Application
import com.example.autorus.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate(){
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                mainModule
            )
        }


    }
}