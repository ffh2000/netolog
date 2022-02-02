package com.example.myapplication.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Inject

/**
 * Главная и единственная ViewModel приложения
 */
class MainViewModel @Inject constructor(
    application: Application,
    private val _screenStateMutable: MutableLiveData<MainScreenState> = MutableLiveData()
) : AndroidViewModel(application) {

    private val _screenState: LiveData<MainScreenState>
        get() = _screenStateMutable

    private fun changeState(newState: MainScreenState) {
        _screenStateMutable.value = newState
    }

    private val viewModelCoroutineScope = CoroutineScope(
        Dispatchers.Main.immediate
                + SupervisorJob()
                + CoroutineExceptionHandler() { _, throwable -> handleError(throwable) })

    init {
        changeState(MainScreenState.Loading)
    }

    fun handleError(throwable: Throwable) {
        changeState(MainScreenState.Error(throwable))
    }
}
