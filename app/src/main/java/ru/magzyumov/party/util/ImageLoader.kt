package ru.magzyumov.party.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import ru.magzyumov.party.R

object ImageLoader {
    @JvmStatic
    @BindingAdapter("avatar")
    fun loadImage(view: ImageView, image: String) {
        Glide.with(view.context)
            .load(image)
            .centerCrop()
            .fitCenter()
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .placeholder(R.drawable.image_loading)
            .error(R.drawable.image_error)
            .into(view)
    }
}