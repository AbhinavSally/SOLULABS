package com.abhinav.solulabs.data.repo

import com.abhinav.solulabs.data.models.response.ProductResponse
import com.abhinav.solulabs.data.remote.ApiHelper
import com.abhinav.solulabs.data.remote.ResultData
import com.abhinav.solulabs.utils.HelperUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ProductsRepo @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getProducts(): Flow<ResultData<ProductResponse>> = flow {
        emit(ResultData.loading(null))
        emit(HelperUtils.safeApiCall { apiHelper.getProduct() })
    }.flowOn(Dispatchers.IO)


}