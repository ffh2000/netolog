package com.example.myapplication.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel
    @Inject
    constructor(application: Application) : AndroidViewModel(application) {

}