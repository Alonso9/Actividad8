package com.example.actividad8;

// Variables para la BD
public class Variables {
    public static final String nombre_db = "bd_usuarios";
    public static final String nombre_tabla = "usuarios";
    public static final String campo_id = "id";
    public static final String campo_nombre = "nombre";
    public static final String campo_primerapellido = "primerapellido";
    public static final String campo_edad = "edad";
    public static final String campo_sexo = "sexo";
    public static final String campo_estatura = "estatura";
    public static final String campo_peso = "peso";
    public static final String crear_tabla = "CREATE TABLE " + nombre_tabla +
            "("+campo_id+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
            campo_nombre+" TEXT, "+
            campo_primerapellido+" TEXT, "+
            campo_edad+" INTEGER, "+
            campo_sexo+" TEXT, "+
            campo_peso+" DOUBLE, "+
            campo_estatura+" DOUBLE)";
    public static final String eleminar_tabla = "DROP TABLE IF EXIST "+nombre_tabla;
}
