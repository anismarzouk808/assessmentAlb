package com.deezer.demo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


abstract class BaseViewModel : ViewModel() {


    protected var isLoading: MutableLiveData<Boolean> = MutableLiveData()
    open fun getIsLoading(): LiveData<Boolean> {
        return isLoading
    }


    protected var showError: MutableLiveData<Boolean> = MutableLiveData()
    open fun shouldShowError(): LiveData<Boolean> {
        return showError
    }


    protected var messageError: MutableLiveData<String> = MutableLiveData()
    open fun shouldShowMessageError(): LiveData<String> {
        return messageError
    }


}