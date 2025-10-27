package com.ws_rr6_safa_calculo.modelos;

import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class Cc230 {
    private Integer id;
    private String operacion;
    private String ramo;
    private String subramo;
    private String descripcion;
    private Boolean esactivo;
    private String claveOrs;
    private String ramoOrs;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public String getSubramo() {
        return subramo;
    }

    public void setSubramo(String subramo) {
        this.subramo = subramo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEsactivo() {
        return esactivo;
    }

    public void setEsactivo(Boolean esactivo) {
        this.esactivo = esactivo;
    }

    public String getClaveOrs() {
        return claveOrs;
    }

    public void setClaveOrs(String claveOrs) {
        this.claveOrs = claveOrs;
    }

    public String getRamoOrs() {
        return ramoOrs;
    }

    public void setRamoOrs(String ramoOrs) {
        this.ramoOrs = ramoOrs;
    }

}