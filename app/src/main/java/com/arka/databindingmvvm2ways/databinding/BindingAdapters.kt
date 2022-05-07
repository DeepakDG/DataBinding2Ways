package com.arka.databindingmvvm2ways.databinding
import android.widget.ImageView

import androidx.databinding.BindingAdapter
import com.arka.databindingmvvm2ways.R
import com.squareup.picasso.Picasso

@BindingAdapter("imageResource")
fun setImageResource(view: ImageView, imageUrl: String?) {

    if (!imageUrl.isNullOrBlank()) {
        Picasso.get()
            .load(imageUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(view)
    }
}