package com.arka.databindingmvvm2ways.ui

import androidx.lifecycle.LiveData
import com.arka.databindingmvvm2ways.model.Photo

interface PhotoListener {

    fun onLoading()
    fun onSuccess(photoResponse: LiveData<Photo>)
    fun onError(message: String)
}