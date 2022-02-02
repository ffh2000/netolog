package com.example.myapplication.di.module

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {

    @Provides
    fun mainViewModel(activity: AppCompatActivity) : MainViewModel =
        ViewModelProvider(activity).get(MainViewModel::class.java)
}