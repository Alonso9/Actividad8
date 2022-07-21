package com.example.actividad8;

public class Resultados {
    Integer id;
    Integer campo_id_reference;
    Double campo_result;



    public Resultados(Integer id, Integer campo_id_reference, Double campo_result) {
        this.id = id;
        this.campo_id_reference = campo_id_reference;
        this.campo_result = campo_result;
    }

    public Resultados(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCampo_id_reference() {
        return campo_id_reference;
    }

    public void setCampo_id_reference(Integer campo_id_reference) {
        this.campo_id_reference = campo_id_reference;
    }

    public Double getCampo_result() {
        return campo_result;
    }

    public void setCampo_result(Double campo_result) {
        this.campo_result = campo_result;
    }
}
