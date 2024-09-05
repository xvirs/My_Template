package com.project.mytemplate

import android.app.Application
import com.google.firebase.FirebaseApp
import com.project.mytemplate.di.firebaseModule

import com.project.mytemplate.di.useCaseModule
import com.project.mytemplate.di.roomModule
import com.project.mytemplate.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyTemplate : Application() {


    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)

        startKoin {
            androidLogger()
            androidContext(this@MyTemplate)
            modules( roomModule,  viewModelModule, useCaseModule, firebaseModule)
//            logger(org.koin.core.logger.PrintLogger(Level.DEBUG))
        }
    }
}