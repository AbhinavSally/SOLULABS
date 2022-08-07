package com.abhinav.solulabs.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel:ViewModel() {
    private val _isFailure = MutableLiveData<String?>()
    val isFailure: LiveData<String?>
    get() = _isFailure

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
    get() = _isLoading

    fun setLoading(isLoading:Boolean)
    {
        _isLoading.postValue(isLoading)
    }

    fun setFailure(failureMsg: String?)
    {
        _isFailure.postValue(failureMsg)
    }
}