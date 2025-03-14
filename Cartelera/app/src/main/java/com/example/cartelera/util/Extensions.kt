package com.example.cartelera.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide
import com.example.cartelera.R
import java.io.InputStream
import java.nio.charset.Charset

fun Context.getJsonFromAssets(file: String): String? {
    var json = ""
    val stream: InputStream = assets.open(file)
    val size: Int = stream.available()
    val buffer = ByteArray(size)
    stream.read(buffer)
    stream.close()

    json = String(buffer, Charset.defaultCharset())
    return json
}

fun ImageView.loadImage(image: String) {
    Glide.with(this)
        .load(image)
        .error(R.drawable.ic_launcher_foreground)  // Reemplazar con un ícono de error si la carga falla
        .into(this)
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = true) : View =
    LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)