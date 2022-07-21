package com.example.actividad8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ayuda extends AppCompatActivity {
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);
        setTitle("ventana de Ayuda al usuario");

        txt = findViewById(R.id.txt);

        txt.setText("Lo primero que debe hacer es ingresar sus crenciales y en caso de no tener" +
                " cree un nuevo usuario precionando el boton de Crear usuario" +
                ".\nYa dentro puede usar una de los diferentes opciones de la App");

    }
}