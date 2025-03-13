package com.example.cursokotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class Reto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto)

        retoFunciones()
    }

    private fun retoFunciones() {
        val reto = Programador()
        val raquel = reto.getProgrammerData()
        Log.d(
            TAG,
            "My name is ${raquel.name}, my age is ${raquel.age} and I love ${raquel.lenguaje}"
        )
    }
}

class Programador : ProgramadorInterface {

    override fun getProgrammerData(): ProgrammerData =
        ProgrammerData(getName(), getEdad(), getLenguaje())

    private fun getName(): String {
        return "Raquel"
    }

    private fun getEdad(): Int {
        return 2025 - 2000
    }

    private fun getLenguaje(): String = "Kotlin"

}

interface ProgramadorInterface {
    fun getProgrammerData(): ProgrammerData
}

data class ProgrammerData(
    val name: String,
    val age: Int,
    val lenguaje: String
)