package com.example.actividad8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class vistaCrearUse extends AppCompatActivity implements View.OnClickListener{
    EditText campoid, nombre, primerapellido, edad, sexo, estatura, peso;
    Integer edadAux;
    Double altuAux, pesoAux;
    String sEdad, sAlt, sPeso;
    Button save, back;
    Conectar conectar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_crear_use);
        setTitle("Crear Usuario");

        campoid = (EditText) findViewById(R.id.idcampo);
        nombre = (EditText) findViewById(R.id.idnombre);
        primerapellido = (EditText) findViewById(R.id.idapellido);
        edad = (EditText) findViewById(R.id.idedad);
        sexo = (EditText) findViewById(R.id.idsexo);
        estatura = (EditText) findViewById(R.id.idaltura);
        peso = (EditText) findViewById(R.id.idpeso);
        save = findViewById(R.id.btnsave);
        back = findViewById(R.id.btnback);

        save.setOnClickListener(this);
        back.setOnClickListener(this);

        conectar = new Conectar(this, Variables.nombre_db, null,1);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnsave:
                insertar();
            case R.id.btnback:
                finish();
                break;
        }

    }

    private void insertar() {
        SQLiteDatabase db = conectar.getWritableDatabase();
        ContentValues valores = new ContentValues();
        sEdad = edad.getText().toString();
        sAlt = estatura.getText().toString();
        sPeso = peso.getText().toString();
        edadAux = Integer.parseInt(sEdad);
        altuAux = Double.parseDouble(sAlt);
        pesoAux = Double.parseDouble(sPeso);
        //Toast.makeText(this,"id="+(edadAux+1)+"--"+(altuAux+2.1),Toast.LENGTH_SHORT).show();

        try {
            //Pasamos los valores a insertar a la BD
            valores.put(Variables.campo_nombre, nombre.getText().toString());
            valores.put(Variables.campo_primerapellido, primerapellido.getText().toString());
            valores.put(Variables.campo_edad, edadAux);
            valores.put(Variables.campo_sexo, sexo.getText().toString());
            valores.put(Variables.campo_estatura, altuAux);
            valores.put(Variables.campo_peso, pesoAux);

            long id = db.insert(Variables.nombre_tabla, Variables.campo_id, valores); //Sentencia sql para insertar nombre tabla y id
            Toast.makeText(this,"id="+id,Toast.LENGTH_SHORT).show();
            nombre.setText("");
            primerapellido.setText("");
            edad.setText("");
            sexo.setText("");
            estatura.setText("");
            peso.setText("");
        }catch (Exception e){
            Toast.makeText(this,"Error: "+e,Toast.LENGTH_SHORT).show();
        }
        db.close();

    }
}