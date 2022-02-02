package com.example.myapplication.di.component

import android.app.Application
import com.example.myapplication.di.module.AppModule
import com.example.myapplication.ui.MainActivity
import com.example.myapplication.di.module.ActivityModule
import com.example.myapplication.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ActivityModule::class, ViewModelModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun withApplication(application: Application): Builder

        fun build(): AppComponent
    }

    fun viewModelSubComponent(): ViewModelSubComponent.Builder
    fun activitySubComponent(): ActivitySubComponent.Builder

    /**
     * Функция инжектирования в заданный activity всех его зависимостей,
     * объявленных в нем через @Inject
     */
    fun inject(activity: MainActivity)
}