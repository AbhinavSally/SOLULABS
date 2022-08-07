package com.abhinav.solulabs.data.models.response

import com.google.gson.Gson

data class ProductResponse(
    val `data`: Data,
    val msg: String,
    val result: Int
)
{
    /**
     * Get data model.
     *
     * @param classRef
     * @param <T>
     * @return
    </T> */
    fun <T> toResponseModel(classRef: Class<T>): T {
        return Gson().fromJson(Gson().toJson(data), classRef)
    }
}