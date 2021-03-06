package com.arka.databindingmvvm2ways.repository


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.arka.databindingmvvm2ways.model.Photo
import com.arka.databindingmvvm2ways.network.MyAPI
import retrofit2.Call


import retrofit2.Callback
import retrofit2.Response

class PhotoRepository {

    fun getPhoto(id: Int) : LiveData<Photo> {
        val photoResponse:MutableLiveData<Photo> = MutableLiveData()
        //it's better to not create MyAPI() instance inside this class (use Dependency Injection).
        MyAPI().getPhoto(id).enqueue(object: Callback<Photo>{
            override fun onFailure(p0: Call<Photo>, p1: Throwable) {
                photoResponse.value = null
            }

            override fun onResponse(p0: Call<Photo>, p1: Response<Photo>) {
                if (p1.isSuccessful) {
                    photoResponse.value = p1.body()
                } else{
                    photoResponse.value = null
                }
            }
        })
        return photoResponse
    }

}