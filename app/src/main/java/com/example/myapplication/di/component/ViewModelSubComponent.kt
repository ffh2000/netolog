package com.example.myapplication.di.component

import com.example.myapplication.MainViewModel
import dagger.Subcomponent

@Subcomponent
interface ViewModelSubComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): ViewModelSubComponent
    }

    fun inject(mainViewModel: MainViewModel)
}