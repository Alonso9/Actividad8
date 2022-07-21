package com.example.actividad8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class detalles extends AppCompatActivity {
    TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        setTitle("Detalles de la App");

        info = findViewById(R.id.txtinfodetalles);

        info.setText("Esta Calculadora te permite estimar tu probabilidad de agravamiento " +
                "de la enfermedad ante un posible contagio de COVID-19 y se basa en los factores " +
                "de riesgo que puedas presentar en estos momentos, " +
                "indicándote una probable ponderación.");
    }
}