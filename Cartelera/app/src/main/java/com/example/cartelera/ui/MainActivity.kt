package com.example.cartelera.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.cartelera.adapter.MoviesAdapter
import com.example.cartelera.databinding.ActivityMainBinding
import com.example.cartelera.model.Movie
import com.example.cartelera.util.getJsonFromAssets
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private val TAG = ":::TAG"

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MoviesAdapter()
        binding.recyclerView.adapter = adapter

        adapter.resfreshList(getListFromJson())
    }

    private fun getListFromJson (): ArrayList<Movie> {
        val json = getJsonFromAssets("movies.json")
        Log.d(TAG, "Contenido JSON: $json") // Verifica que el JSON esté cargado correctamente
        val movieList = Gson().fromJson(json, Array<Movie>::class.java).toList()
        return ArrayList(movieList)
    }
}