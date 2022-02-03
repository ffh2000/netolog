package com.example.myapplication.data.network

import com.google.gson.annotations.SerializedName

class DataResponse(
    @SerializedName("direction")
    val direction: List<DirectionResponse>
) {}
