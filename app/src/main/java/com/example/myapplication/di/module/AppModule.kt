package com.example.myapplication.di.module

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.BuildConfig
import com.example.myapplication.data.network.NetworkApi
import com.example.myapplication.presentation.MainScreenState
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule {

    @Provides
    fun provideMainScreenState() = MutableLiveData<MainScreenState>()

    @Provides
    fun provideLogingInterceptor() =
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }

    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor) =
        OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .build()

    @Provides
    fun provideNetworkApi(okHttpClient: OkHttpClient) =
        Retrofit
            .Builder()
            .baseUrl("https://raw.githubusercontent.com/netology-code/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    fun provideNteworkApi(retrofit: Retrofit) = retrofit.create(NetworkApi::class.java)

}

