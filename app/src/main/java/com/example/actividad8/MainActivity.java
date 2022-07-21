package com.example.actividad8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Intent i;
    EditText nombre, passwd;
    Button boton1, boton2;
    Conectar conectar;
    ArrayList<String>listausuarios;
    ArrayList<Usuarios> datosusuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton1 = (Button) findViewById(R.id.boton);
        boton2 = (Button) findViewById(R.id.boton2);
        nombre = findViewById(R.id.nombre);
        passwd = findViewById(R.id.passwd);
        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);

        //conectar = new Conectar(this, Variables.nombre_db, null,1);

    }

    //Agregamos el menu principal
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        return true;
    }

    //Si da click en una opcion del menu

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.i1:
                i = new Intent(MainActivity.this, ayuda.class);
                startActivity(i);
                //Toast.makeText(this, "Opcion Configuaracion", Toast.LENGTH_LONG).show();
                break;
            case R.id.i2:
                i = new Intent(MainActivity.this, acerca.class);
                startActivity(i);
                //Toast.makeText(this, "Opcion Microfono", Toast.LENGTH_LONG).show();
                break;
            case R.id.i3:
                finish();
                break;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.boton:
                login();
                break;
            case R.id.boton2:
                i = new Intent(MainActivity.this, vistaCrearUse.class);
                startActivity(i);
                break;
        }
    }

    private void login() {
        try {
            conectar = new Conectar(this, Variables.nombre_db, null, 1);
            SQLiteDatabase db = conectar.getReadableDatabase(); //Acceso de solo lectura
            Usuarios usuario = null;
            Cursor cursor = db.rawQuery("SELECT * FROM "+Variables.nombre_tabla+" Where "+
                    Variables.campo_nombre+" = '"+ nombre.getText() +"' AND "+
                    Variables.campo_primerapellido+" = '"+passwd.getText()+"'", null);
                if (cursor.moveToFirst()) {
                    int id = cursor.getInt(0);
                    String usua = cursor.getString(1);
                    Toast.makeText(this, "Bienvenido Usuario "+usua, Toast.LENGTH_LONG).show();

                        i = new Intent(MainActivity.this, vistaUsuario.class);
                        i.putExtra("usuario",usua);
                        i.putExtra("id",id);
                        startActivity(i);
                        nombre.setText("");
                        passwd.setText("");
                }else {
                    Toast.makeText(this, "Credenciales no validas", Toast.LENGTH_LONG).show();
                }
        } catch (Exception e) {
            Toast.makeText(this,"Error; "+e,Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}