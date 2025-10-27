package com.ws_rr6_safa_calculo.modelos;

import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class Ccreaseguradora {
    private Integer id;
    private Integer clave;
    private String reaseguradora;
    private String claveregistro;
    private String calificacionsp;
    private String operacion;
    private Boolean extranjero;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
        this.clave = clave;
    }

    public String getReaseguradora() {
        return reaseguradora;
    }

    public void setReaseguradora(String reaseguradora) {
        this.reaseguradora = reaseguradora;
    }

    public String getClaveregistro() {
        return claveregistro;
    }

    public void setClaveregistro(String claveregistro) {
        this.claveregistro = claveregistro;
    }

    public String getCalificacionsp() {
        return calificacionsp;
    }

    public void setCalificacionsp(String calificacionsp) {
        this.calificacionsp = calificacionsp;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Boolean getExtranjero() {
        return extranjero;
    }

    public void setExtranjero(Boolean extranjero) {
        this.extranjero = extranjero;
    }

}