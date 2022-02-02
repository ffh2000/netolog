package com.example.myapplication.di.component

import android.app.Application
import com.example.myapplication.di.module.AppModule
import com.example.myapplication.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun withApplication(application: Application): Builder

        fun build(): AppComponent
    }

    fun viewModelSubComponent(): ViewModelSubComponent.Builder
    fun inject(activity: MainActivity)
}