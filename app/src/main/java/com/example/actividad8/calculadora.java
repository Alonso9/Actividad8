package com.example.actividad8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class calculadora extends AppCompatActivity implements View.OnClickListener{
    Button save_res, regre;
    EditText resp;
    String usuario, auxRes;
    Double res;
    Integer id;
    Conectar conectar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        setTitle("Calculadora de complicación de salud por COVID -19");

        save_res = findViewById(R.id.botonsaveres);
        resp = findViewById(R.id.res);
        regre = findViewById(R.id.regresar);

        usuario = getIntent().getExtras().getString("usuario");
        id = getIntent().getExtras().getInt("id");

        //Toast.makeText(this, "Opcion Ayuda"+usuario+id, Toast.LENGTH_LONG).show();
        save_res.setOnClickListener(this);
        regre.setOnClickListener(this);
        conectar = new Conectar(this, Variables2.nombre_db, null,1);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.botonsaveres:
                save();
                break;
            case R.id.regresar:
                finish();

        }
    }

    private void save() {
        //Guardar resultaddos
        SQLiteDatabase db = conectar.getWritableDatabase();
        ContentValues valores = new ContentValues();
        auxRes = resp.getText().toString();
        res = Double.parseDouble(auxRes);
        try {
            //Pasamos los valores a insertar a la BD
            valores.put(Variables2.campo_id_reference,id);
            valores.put(Variables2.campo_result, res);
            long id = db.insert(Variables2.nombre_tabla, Variables2.campo_id, valores); //Sentencia sql para insertar nombre tabla y id
            Toast.makeText(this,"id="+id,Toast.LENGTH_SHORT).show();
            resp.setText("");
        }catch (Exception e){
            Toast.makeText(this,"Error: "+e,Toast.LENGTH_SHORT).show();
        }
        db.close();


    }
}