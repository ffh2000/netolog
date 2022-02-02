package com.example.myapplication.di.component

import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.di.module.ActivityModule
import com.example.myapplication.ui.MainActivity
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [ActivityModule::class])
interface ActivitySubComponent {

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun with(activity: AppCompatActivity): Builder

        fun build(): ActivitySubComponent
    }

    fun inject(activity: MainActivity)
}