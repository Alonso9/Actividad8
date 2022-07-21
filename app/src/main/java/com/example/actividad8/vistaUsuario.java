package com.example.actividad8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class vistaUsuario extends AppCompatActivity implements View.OnClickListener{
    TextView txt;
    Button info, cal;
    Intent i;
    String usuario;
    Integer id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_usuario);
        setTitle("Ventana Principal");

        txt = findViewById(R.id.txtvista);
        info = findViewById(R.id.btninfo);
        cal = findViewById(R.id.btncalcular);
        usuario = getIntent().getExtras().getString("usuario");
        id = getIntent().getExtras().getInt("id");

        txt.setText(usuario+id);
        info.setOnClickListener(this);
        cal.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_vista_usuario,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.iu1:
                i = new Intent(vistaUsuario.this, detalles.class);
                startActivity(i);
                //Toast.makeText(this, "Opcion Detalles", Toast.LENGTH_LONG).show();
                break;
            case R.id.iu2:
                i = new Intent(vistaUsuario.this, ayuda.class);
                startActivity(i);
                //Toast.makeText(this, "Opcion Ayuda", Toast.LENGTH_LONG).show();
                break;
            case R.id.iu3:
                finish();
                break;
            case R.id.iu4:
                i = new Intent(vistaUsuario.this, historial.class);
                i.putExtra("usuario",usuario);
                i.putExtra("id",id);
                startActivity(i);
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btninfo:
                i = new Intent(vistaUsuario.this, covid_info.class);
                startActivity(i);
                break;
            case R.id.btncalcular:
                i = new Intent(vistaUsuario.this, calculadora.class);
                i.putExtra("usuario",usuario);
                i.putExtra("id",id);
                startActivity(i);
        }

    }
}