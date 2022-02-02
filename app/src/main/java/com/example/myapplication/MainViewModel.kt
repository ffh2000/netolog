package com.example.myapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel : AndroidViewModel {

    @Inject
    constructor(application: Application) : super(application) {
    }

}