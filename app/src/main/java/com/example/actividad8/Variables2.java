package com.example.actividad8;

public class Variables2 {
    public static final String nombre_db = "bd_consultas";
    public static final String nombre_tabla = "resultados";
    public static final String campo_id = "id";
    public static final String campo_id_reference = "nombre";
    public static final String campo_result = "primerapellido";
    public static final String crear_tabla = "CREATE TABLE " + nombre_tabla +
            "("+campo_id+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
            campo_id_reference+" INTEGER, "+
            campo_result+" DOUBLE)";
    public static final String eleminar_tabla = "DROP TABLE IF EXIST "+nombre_tabla;
}
