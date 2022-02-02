package com.example.myapplication

import android.app.Application
import com.example.myapplication.di.component.AppComponent
import com.example.myapplication.di.component.DaggerAppComponent
import com.example.myapplication.di.component.ViewModelSubComponent

class MyApplication : Application() {

    val appComponent: AppComponent = DaggerAppComponent
        .builder()
        .withApplication(this)
        .build()
    val viewModelSubComponent: ViewModelSubComponent = appComponent.viewModelSubComponent().build()

}