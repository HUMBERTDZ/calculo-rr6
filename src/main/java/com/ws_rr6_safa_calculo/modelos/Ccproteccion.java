package com.ws_rr6_safa_calculo.modelos;

import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
public class Ccproteccion {
    private Integer id;
    private String clave;
    private String tipoproteccion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipoproteccion() {
        return tipoproteccion;
    }

    public void setTipoproteccion(String tipoproteccion) {
        this.tipoproteccion = tipoproteccion;
    }

}