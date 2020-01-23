package com.adaoud.leboncoin.ui.list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.adaoud.data.network.LeBoncoinApi
import com.adaoud.data.network.NetworkAlbumsRepository
import com.adaoud.domain.Albums
import com.deezer.demo.ui.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ListAlbumsViewModel : BaseViewModel(), CoroutineScope {


    @Inject
    lateinit var albumsApi: LeBoncoinApi


    var networkRepo = NetworkAlbumsRepository(albumsApi)

    private val viewModelJob = Job()

    private var index = ""

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + viewModelJob

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private lateinit var responseData: MutableLiveData<Albums>

     fun getAlbumsResponse(): MutableLiveData<Albums> {
        if (!::responseData.isInitialized) {
            responseData = MutableLiveData()
        }
        return responseData
    }



    fun getAlbums() {

            launch {

                try {
                    isLoading.value = true
                    val result = networkRepo.getAlbumsAsync(Dispatchers.IO)

                    result.await()?.let { response ->

                        responseData.value = response

                        showError.value = false


                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    showError.value = true
                } finally {
                    isLoading.value = false
                }
            }
    }
}
