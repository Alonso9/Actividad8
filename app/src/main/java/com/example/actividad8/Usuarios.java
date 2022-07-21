package com.example.actividad8;

import java.io.Serializable;

public class Usuarios implements Serializable {
    Integer id;
    String nombre;
    String primerapellido;
    Integer edad;
    String sexo;
    Double estatura;
    Double peso;


    public Usuarios(Integer id, String nombre, String primerapellido, Integer edad, String sexo, Double estatura, Double peso) {
        this.id = id;
        this.nombre = nombre;
        this.primerapellido = primerapellido;
        this.edad = edad;
        this.sexo = sexo;
        this.estatura = estatura;
        this.peso = peso;
    }

    public Usuarios(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Double getEstatura() {
        return estatura;
    }

    public void setEstatura(Double estatura) {
        this.estatura = estatura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

}
