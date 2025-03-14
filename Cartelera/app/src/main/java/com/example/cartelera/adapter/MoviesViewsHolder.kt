package com.example.cartelera.adapter

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cartelera.R
import com.example.cartelera.model.Movie
import com.example.cartelera.util.loadImage

class MoviesViewsHolder(view: View) : RecyclerView.ViewHolder(view){
    private val TAG = ":::TAG"

    // Busca los elementos manualmente con findViewById
    private val movieTitle: TextView = view.findViewById(R.id.movieTitle)
    private val movieCover: ImageView = view.findViewById(R.id.movieCover)

    fun bind(movie: Movie) {
        movieTitle.text = movie.name
        Log.d(TAG, "Cargando imagen desde: ${movie.cover}")
        movieCover.loadImage(movie.cover)
    }
}