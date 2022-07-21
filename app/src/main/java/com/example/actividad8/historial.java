package com.example.actividad8;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class historial extends AppCompatActivity {
    String usuario;
    ListView lista;
    ArrayList<String> listaresultados;
    ArrayList<Resultados> datos;
    Conectar conectar;
    TextView txt;
    Integer id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        usuario = getIntent().getExtras().getString("usuario");
        id = getIntent().getExtras().getInt("id");
        setTitle("Historial del usuario '"+usuario+"'");

        txt = findViewById(R.id.txthistorial);
        lista = findViewById(R.id.listaid2);

        conectar = new Conectar(this, Variables2.nombre_db, null,1);
        txt.setText("Id - Id reference - Resultado");
        txt.setText("");

        mostrar();
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, listaresultados);
        lista.setAdapter(aa);
        //lista.setOnItemClickListener(this);
    }

    private void mostrar() {
        //Mostrar
        conectar = new Conectar(this, Variables2.nombre_db, null,1);
        Resultados result = null;
        datos = new ArrayList<Resultados>();
        SQLiteDatabase db = conectar.getReadableDatabase();
        Cursor  cursor = db.rawQuery("SELECT * FROM "+Variables2.nombre_tabla+" Where "+
                Variables2.campo_id_reference+" = '"+ id +"'", null);
        while (cursor.moveToNext()){
            result = new Resultados();
            result = new Resultados();
            result.setId(cursor.getInt(0));
            result.setCampo_id_reference(cursor.getInt(1));
            result.setCampo_result(cursor.getDouble(2));
            datos.add(result);
        }agregaralista();
        db.close();

    }

    private void agregaralista() {
        listaresultados = new ArrayList<String>();
        for (int i = 0; i<datos.size(); i++){
            listaresultados.add(datos.get(i).getId()+" - "+datos.get(i).getCampo_id_reference()+" - "+datos.get(i).getCampo_result());
        }

    }
}