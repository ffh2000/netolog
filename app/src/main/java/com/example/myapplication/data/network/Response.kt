package com.example.myapplication.data.network

import com.google.gson.annotations.SerializedName

class Response(
    @SerializedName("data")
    val data: List<DataResponse>
) {
}
