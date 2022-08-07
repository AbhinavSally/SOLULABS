package com.abhinav.solulabs.data.remote

import com.abhinav.solulabs.data.models.response.ProductResponse
import retrofit2.Response
import retrofit2.http.GET


interface ApiInterface {


    @GET("/coinlist")
    suspend fun getProducts(
    ): Response<ProductResponse>

}