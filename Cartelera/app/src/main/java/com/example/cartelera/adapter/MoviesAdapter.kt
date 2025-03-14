package com.example.cartelera.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cartelera.R
import com.example.cartelera.model.Movie
import com.example.cartelera.util.inflate

class MoviesAdapter : RecyclerView.Adapter<MoviesViewsHolder>() {

    private val movieList = arrayListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewsHolder {
        val view = parent.inflate(R.layout.item_movie, false)
        return MoviesViewsHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewsHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = movieList.size

    @SuppressLint("NotifyDataSetChanged")
    fun resfreshList (movieList: ArrayList<Movie>) {
        this.movieList.addAll(movieList)
        notifyDataSetChanged()
    }

}