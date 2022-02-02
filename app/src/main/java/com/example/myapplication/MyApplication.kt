package com.example.myapplication

import android.app.Application
import com.example.myapplication.di.component.AppComponent
import com.example.myapplication.di.component.DaggerAppComponent

class MyApplication : Application() {

    val appComponent: AppComponent = DaggerAppComponent
        .builder()
        .withApplication(this) //передаю экземпляр текущего Application для хранения в зависимотях Dagger
        .build()

}
