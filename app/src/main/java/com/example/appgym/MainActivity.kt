package com.example.appgym

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var nombreEditText: EditText
    private lateinit var apellidosEditText: EditText
    private lateinit var edadEditText: EditText
    private lateinit var generoEditText: EditText
    private lateinit var nacionalidadEditText: EditText
    private lateinit var pesoEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializa los EditText
        nombreEditText = findViewById(R.id.textNombre)
        apellidosEditText = findViewById(R.id.textApellidos)
        edadEditText = findViewById(R.id.textEdad)
        generoEditText = findViewById(R.id.textGenero)
        nacionalidadEditText = findViewById(R.id.textNacionalidad)
        pesoEditText = findViewById(R.id.textPeso)

        val VentanaPantalla2: Button = findViewById(R.id.BtnSiguiente)
        VentanaPantalla2.setOnClickListener {
            if (validateFields()) {
                openActivity(Pantalla2::class.java)
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateFields(): Boolean {
        return nombreEditText.text.isNotEmpty() &&
                apellidosEditText.text.isNotEmpty() &&
                edadEditText.text.isNotEmpty() &&
                generoEditText.text.isNotEmpty() &&
                nacionalidadEditText.text.isNotEmpty() &&
                pesoEditText.text.isNotEmpty()
    }

    private fun openActivity(activity: Class<*>) {
        val intent = Intent(this, activity)
        startActivity(intent)
    }
}
