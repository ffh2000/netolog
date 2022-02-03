package com.example.myapplication.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.network.NetworkApi
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Главная и единственная ViewModel приложения
 */
class MainViewModel @Inject constructor(
    application: Application,
    val networkApi: NetworkApi,
    private val _screenStateMutable: MutableLiveData<MainScreenState> = MutableLiveData()
) : AndroidViewModel(application) {

    private val screenState: LiveData<MainScreenState>
        get() = _screenStateMutable

    private fun changeState(newState: MainScreenState) {
        Log.d("ResponseApi", "loadData: newState = $newState")
        _screenStateMutable.value = newState
    }

    private val viewModelCoroutineScope = CoroutineScope(
        Dispatchers.Main.immediate
                + SupervisorJob()
                + CoroutineExceptionHandler() { _, throwable -> handleError(throwable) })

    fun subscribeToScreenStateChanges(): LiveData<MainScreenState> = screenState

    init {
        loadData()
    }

    private fun handleError(throwable: Throwable) {
        changeState(MainScreenState.Error(throwable))
    }

    fun loadData() {
        changeState(MainScreenState.Loading)
        viewModelCoroutineScope.launch {
            requestData()
                .flowOn(Dispatchers.IO)
                .collect {
                    changeState(MainScreenState.Working(it))
                }
        }
    }

    private suspend fun requestData() = flow { emit(networkApi.getTasks()) }

}
