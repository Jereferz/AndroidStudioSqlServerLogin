package com.example.logiiiinulti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.sql.PreparedStatement
import java.sql.SQLException

lateinit var CajitaNombre: EditText
lateinit var CajitaCodigo: EditText
lateinit var Boton: Button

class MainActivity : AppCompatActivity() {

    private var connectSql = ConexionSql()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CajitaNombre = findViewById(R.id.txtNombre)
        CajitaCodigo = findViewById(R.id.txtCodigo)
        Boton = findViewById(R.id.btnEnviar)

        Boton.setOnClickListener {
            try {
                val addEstudiantee: PreparedStatement =
                    connectSql.dbConn()?.prepareStatement("insert into Estudiantes values (?,?)")!!
                addEstudiantee.setString(1, CajitaNombre.text.toString())
                addEstudiantee.setString(2, CajitaCodigo.text.toString())
                addEstudiantee.executeUpdate()

                Toast.makeText(this, "Estudiante ingresado correctamente", Toast.LENGTH_SHORT)
                    .show()
            }catch (ex: SQLException){
                Toast.makeText(this,"Error al ingresar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}