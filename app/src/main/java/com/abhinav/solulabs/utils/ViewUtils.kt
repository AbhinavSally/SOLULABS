package com.abhinav.solulabs.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

object ViewUtils {

    fun ImageView.load(url: String)
    {
        Glide.with(this.context).load(url).into(this)
    }

}