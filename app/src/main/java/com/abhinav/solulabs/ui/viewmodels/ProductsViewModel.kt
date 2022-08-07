package com.abhinav.solulabs.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.abhinav.solulabs.data.models.response.Data
import com.abhinav.solulabs.data.models.response.ProductResponse
import com.abhinav.solulabs.data.remote.ApiHelper
import com.abhinav.solulabs.data.remote.ResultData
import com.abhinav.solulabs.data.repo.ProductsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductsViewModel @Inject constructor(apiHelper: ApiHelper):BaseViewModel() {

    private var productsRepo: ProductsRepo = ProductsRepo(apiHelper)

    val productsResponse: LiveData<Data>
        get() = _productsResponse

    private val _productsResponse = MutableLiveData<Data>()


    fun getProducts()
    {
        viewModelScope.launch {


            productsRepo.getProducts().collect(){
                when(it)
                {
                    is ResultData.Failure ->
                    {
                        setFailure(it.message)
                        setLoading(false)
                    }
                    is ResultData.Loading ->
                    {
                        setFailure(null)
                        setLoading(true)
                    }
                    is ResultData.Success ->
                    {
                        setFailure(null)
                        setLoading(false)
                        it.value.let {
                            _productsResponse.value = it.toResponseModel(Data::class.java)
                        }

                    }
                }

            }
        }
    }

}