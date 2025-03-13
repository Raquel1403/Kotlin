package com.example.cursokotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

const val TAG: String = ":::TAG"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        funciones()
        clases()
        interfaces()

        condicionalesIf()
        condicionalesWhen() //Es como swith case en Java
        listado()
        bucleFor()
        bucleWhile()
        bucleDoWhile()

        */
        controlDeErrores()

    }

    private fun condicionalesIf() {
        val primerNumero = 10
        val segundoNumero = 5
        val booleanValue = true

        if (primerNumero > segundoNumero) {
            Log.d(TAG, "Primera opción")
        } else if (booleanValue) {
            Log.d(TAG, "Segunda opción")
        } else {
            Log.d(TAG, "Tercera opción")
        }

        val edad: Int = if (!booleanValue) {
            17
        } else {
            26
        }
    }

    private fun condicionalesWhen() {
        val language = "Kotlin"
        val myNumber = 94

        when (language) {
            "Kotlin" -> Log.d(TAG, "Lenguaje seleccionado $language")
            "Java" -> Log.d(TAG, "Lenguaje seleccionado $language")
            "Python" -> Log.d(TAG, "Lenguaje seleccionado $language")
            "JavaScript" -> Log.d(TAG, "Lenguaje seleccionado $language")
            else -> Log.d(TAG, "Se ha seleccionado otro lenguaje")
        }

        when (myNumber) {
            in 0..10 -> Log.d(TAG, "Lenguaje seleccionado $language")
            40 -> Log.d(TAG, "Lenguaje seleccionado $language")
            in 80..119 -> Log.d(TAG, "Lenguaje seleccionado $language")
            120 -> Log.d(TAG, "Lenguaje seleccionado $language")
            else -> Log.d(TAG, "Se ha seleccionado otro lenguaje")
        }
    }

    private fun listado() {
        val list = listOf<String>()
        val list2: List<String> = listOf()

        val arrayList = arrayListOf<String>()
        val arrayList2: ArrayList<String> = arrayListOf()

        //Listado inmutable
        val myList = listOf("Rodrigo", "Raquel", "María")
        //Array mutable
        val myArrayList = arrayListOf("Rodrigo", "Raquel", "María")

        val listItem = myList[0]
        val arrayListItem = myList[1]
        Log.d(TAG, listItem)
        Log.d(TAG, arrayListItem)

        myArrayList[2] = "Sandra"
        Log.d(TAG, arrayListItem)

        //Borrar
        myArrayList.remove("Sandra")
        myArrayList.removeAt(2)
        myArrayList.clear() //Borramos todo el listado.

        //Añadir
        myArrayList.addAll(myList)

        //Ordenar
        myArrayList.sort()
    }

    private fun bucleFor() {
        val myArrayList = arrayListOf("Rodrigo", "Raquel", "María")

        for (persona in myArrayList) {
            Log.d(TAG, persona)
        }

        for (position in 0..10) {
            Log.d(TAG, position.toString())
        }

        for (position in 0 until 10) {
            Log.d(TAG, position.toString())
        }

        for (position in 0..10 step 3) {
            Log.d(TAG, position.toString())
        }

        for (position in 10 downTo 3 step 2) {
            Log.d(TAG, position.toString())
        }
    }

    private fun bucleWhile() {
        var myNumber = 0

        while (myNumber <= 10) {
            Log.d(TAG, myNumber.toString())
            myNumber++
        }
    }

    private fun bucleDoWhile() {
        var myNumber = 1
        do {
            Log.d(TAG, "He entrado en el bucle do")
            Log.d(TAG, myNumber.toString())
            myNumber++
        } while (myNumber <= 10)
    }

    private fun controlDeErrores(){
        val myArrayList = arrayListOf(1,2,3,4,5)
        val myString: String? = null

        try {
            for (position in 0..myArrayList.size){
                Log.d(TAG, myArrayList[position].toString())
                Log.d(TAG, myString!!)
            }
        }catch (exception: Exception){
            exception.printStackTrace()
            Log.d(TAG, "Catch")
        }finally {
            Log.d(TAG, "Finally")

        }

    }


    /* private fun funciones() {
         funcionSimple()
         funcionParametros("Raquel", 25)
         funcionParametros("Rodrigo", 26)
         var calculaEdad: Int = funcionRetorno(2000)
         Log.d(TAG, "My age is $calculaEdad")
         calculaEdad = funcionRetorno(1996)
         Log.d(TAG, "My age is $calculaEdad")

     }

     private fun funcionSimple() {
         Log.d(TAG, "Raquel")
         Log.d(TAG, 26.toString())
     }

     private fun funcionParametros(name: String, age: Int) {
         Log.d(TAG, "My name is $name")
         Log.d(TAG, "My age is $age")
     }

     private fun funcionRetorno(birthYear: Int): Int = 2025 - birthYear

     private fun clases() {
         val raquel = Persona("Raquel", 24)
         raquel.presentacion()
         val rodrigo = Persona("Rodrigo", 26)
         rodrigo.presentacion()
         val raquelData = PersonData("Raquel", 24)
         val raquelDos = PersonaDos(raquelData)
         raquelDos.presentacion()
     }

     class Persona(private val name: String, private val age: Int) {
         fun presentacion() {
             Log.d(TAG, "My name is $name and my age is $age")
         }
     }
     class PersonaDos(private val data : PersonData) {
         fun presentacion() {
             Log.d(TAG, "My name is ${data.name} and my age is ${data.age}")
         }
     }
     //Sirve para agrupar paquetes de datos
     data class PersonData(
         val name: String?,
         val age: Int
     )

     private fun interfaces(){
         val raquelData = PersonData("Raquel", 24)
         val raquelDos = SegundaPersona(raquelData)
         raquelDos.presentacion()
         val edad = raquelDos.returnAge(2000)
         Log.d(TAG, "My age is $edad")

     }

     class SegundaPersona(private val data : PersonData): PersonInterface {
         fun presentacion() {
             Log.d(TAG, "My name is ${data.name} and my age is ${data.age}")
         }

         override fun returnAge(birthYear: Int): Int = 2025 - birthYear
     }

     interface PersonInterface {fun returnAge(birthYear: Int): Int}*/
}




