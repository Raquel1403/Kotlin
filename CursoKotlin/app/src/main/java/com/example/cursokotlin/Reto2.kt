package com.example.cursokotlin

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Reto2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto2)

        botDeSeguridad()
    }


    private fun botDeSeguridad(){

        val persona = Persona("Raquel", 16, arrayListOf("Programar", "TV", "Deportes"))

        if (persona.name == "Raquel"){
            Log.d(TAG, "Bienvenida ${persona.name}")
            when(persona.age){
                in 0..17 -> Log.d(TAG, "Tienes ${persona.age} años, eres demasiado joven para acceder.")
                in 18 ..64 -> {
                    Log.d(TAG, "Tienes ${persona.age} años, eres mayor de edad, bienevenido.")
                    for (hobby in persona.hobbies){
                        Log.d(TAG, "Te gusta $hobby")
                    }
                }
                in 65 ..100 -> Log.d(TAG, "Tienes ${persona.age} años, eres demasiado mayor para acceder.")
            }
        } else {
            Log.d(TAG, "Lago de aquí ${persona.name}")

        }
    }
}

data class Persona (
    val name: String,
    val age: Int,
    val hobbies: ArrayList<String>
)