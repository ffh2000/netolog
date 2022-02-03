package com.example.myapplication.data.network

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface NetworkApi {

    @GET("rn-task/master/netology.json")
    suspend fun getTasks(): Flow<DataResponse>

}
