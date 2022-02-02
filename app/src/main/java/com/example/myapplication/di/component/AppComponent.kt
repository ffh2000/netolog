package com.example.myapplication.di.component

import android.app.Application
import com.example.myapplication.di.module.AppModule
import com.example.myapplication.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Компонент для предоставления зависимостей приложения
 */
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    /**
     * Подкласс билдера. Нужен т.к. dagger по умолчанию (без расширений)
     * не умеет получаить context, application и т.п. зависимости от Android.
     * Поэтому эти зависимости привязываем в момент инициализации dagger в [MyApplication]
     */
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun withApplication(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(activity: MainActivity)
}
