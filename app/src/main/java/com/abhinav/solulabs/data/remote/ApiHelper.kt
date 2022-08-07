package com.abhinav.solulabs.data.remote

import javax.inject.Inject


class ApiHelper @Inject constructor(private val apiInterface: ApiInterface) {

    suspend fun getProduct() = apiInterface.getProducts()


}







