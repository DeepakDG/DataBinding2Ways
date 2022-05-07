package com.arka.databindingmvvm2ways.ui

import androidx.lifecycle.ViewModel
import com.arka.databindingmvvm2ways.repository.PhotoRepository
import com.arka.databindingmvvm2ways.ui.PhotoListener

class PhotoViewModel: ViewModel() {

    var id: Int = 0
    var photoListener: PhotoListener? = null

    fun onGetPhotoButtonClick() {
        photoListener?.onLoading()
        if (!isPhotoIdValid()) {
            photoListener?.onError("Invalid id...")
            return
        }

        //it's better to not create PhotoRepository() instance inside this class (use Dependency Injection)
        val photoResponse = PhotoRepository().getPhoto(id)
        photoListener?.onSuccess(photoResponse)
    }

    private fun isPhotoIdValid(): Boolean {
        return id in 1..5000
    }
}