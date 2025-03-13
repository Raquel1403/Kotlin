package com.example.calculadora

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var firtNumber = 0.0
    private var secundNumber = 0.0
    private var operation: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Inflar el layout usando ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) //Esto referencia a activity_main.xml

        operation = null

        binding.bt0.setOnClickListener(this)
        binding.bt1.setOnClickListener(this)
        binding.bt2.setOnClickListener(this)
        binding.bt3.setOnClickListener(this)
        binding.bt4.setOnClickListener(this)
        binding.bt5.setOnClickListener(this)
        binding.bt6.setOnClickListener(this)
        binding.bt7.setOnClickListener(this)
        binding.bt8.setOnClickListener(this)
        binding.bt9.setOnClickListener(this)
        binding.btComa.setOnClickListener(this)
        binding.btPlus.setOnClickListener(this)
        binding.btMinus.setOnClickListener(this)
        binding.btMul.setOnClickListener(this)
        binding.btDiv.setOnClickListener(this)
        binding.btEqual.setOnClickListener(this)
        binding.btClear.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            binding.bt0.id -> onNumberPressed("0")
            binding.bt1.id -> onNumberPressed("1")
            binding.bt2.id -> onNumberPressed("2")
            binding.bt3.id -> onNumberPressed("3")
            binding.bt4.id -> onNumberPressed("4")
            binding.bt5.id -> onNumberPressed("5")
            binding.bt6.id -> onNumberPressed("6")
            binding.bt7.id -> onNumberPressed("7")
            binding.bt8.id -> onNumberPressed("8")
            binding.bt9.id -> onNumberPressed("9")
            binding.btComa.id -> onDecimalPressed()
            binding.btPlus.id -> onOperationPressed("+")
            binding.btMinus.id -> onOperationPressed("-")
            binding.btMul.id -> onOperationPressed("x")
            binding.btDiv.id -> onOperationPressed("/")
            binding.btEqual.id -> onEqualPressed()
            binding.btClear.id -> onClearPressed()

        }
    }

    private fun onNumberPressed(number: String) {
        renderScreen(number)
        checkOperation()
    }

    @SuppressLint("SetTextI18n")
    private fun onDecimalPressed() {
        val currentText = binding.screen.text.toString()
        if (!currentText.contains(".")) {
            binding.screen.text = "$currentText."
        }
    }

    @SuppressLint("SetTextI18n")
    private fun renderScreen(number: String) {
        if (binding.screen.text == "0" && number != ".") {
            binding.screen.text = number
        } else {
            binding.screen.text = binding.screen.text.toString() + number
        }
    }

    private fun checkOperation() {
        if (operation == null)
            firtNumber = binding.screen.text.toString().toDouble()
    }

    private fun onOperationPressed(operation: String) {
        if (this.operation != null) {
            secundNumber = binding.screen.text.toString().toDouble()
            onEqualPressed()
        }

        this.operation = operation
        firtNumber = binding.screen.text.toString().toDouble()

        binding.screen.text = "0"
    }

    private fun onEqualPressed() {
        secundNumber = binding.screen.text.toString().toDouble()

        val result = when (operation) {
            "+" -> firtNumber + secundNumber
            "-" -> firtNumber - secundNumber
            "x" -> firtNumber * secundNumber
            "/" -> if (secundNumber != 0.0) firtNumber / secundNumber else Double.NaN
            else -> 0.0
        }

        operation = null
        firtNumber = result

        try {
            binding.screen.text = if (result.toString().endsWith(".0")) {
                result.toString().replace(".0", "")
            } else {
                "%.2f".format(result)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun onClearPressed() {
        binding.screen.text = "0"
        firtNumber = 0.0
        secundNumber = 0.0

    }
}