package com.example.myapplication.di.module

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.presentation.MainScreenState
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideMainScreenState() = MutableLiveData<MainScreenState>()
}
