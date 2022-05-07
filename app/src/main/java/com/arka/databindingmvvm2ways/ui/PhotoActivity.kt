package com.arka.databindingmvvm2ways.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.arka.databindingmvvm2ways.R
import com.arka.databindingmvvm2ways.databinding.ActivityPhotoBinding
import com.arka.databindingmvvm2ways.model.Photo
import com.arka.databindingmvvm2ways.util.hide
import com.arka.databindingmvvm2ways.util.show
import com.arka.databindingmvvm2ways.util.showToast
import kotlinx.android.synthetic.main.activity_photo.*

class PhotoActivity : AppCompatActivity(), PhotoListener {

    lateinit var photoBinding: ActivityPhotoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        photoBinding = DataBindingUtil.setContentView(this, R.layout.activity_photo)
        val photoViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(PhotoViewModel::class.java)

        photoBinding.photoViewModel = photoViewModel
        photoViewModel.photoListener = this
    }

// ---------------------------------------------------------------------------------------------------------------------

    override fun onLoading() {
        progress_bar.show()
    }

    override fun onSuccess(photoResponse: LiveData<Photo>) {
        photoResponse.observe(this, Observer {
                progress_bar.hide()
                if (it != null) {
                    photoBinding.photoModel = it
                    showToast(getString(R.string.success))
                } else {
                    showToast(getString(R.string.error))
                }
            })
    }

    override fun onError(message: String) {
        progress_bar.hide()
        showToast(message)
    }
}
