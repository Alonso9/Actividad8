package com.example.actividad8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class acerca extends AppCompatActivity {
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca);
        setTitle("Ventana de informacion de la App");

        txt = findViewById(R.id.txtacerca);

        txt.setText("Esta app puede consustal su riesgo de covid y saber la situacion de su  " +
                "estado.\n\nLicencia\nThe GNU General Public License is a free, copyleft license for software and other kinds of works.\n" +
                "\n");
    }
}