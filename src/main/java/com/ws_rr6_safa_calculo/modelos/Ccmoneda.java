package com.ws_rr6_safa_calculo.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class Ccmoneda {
    private Integer id;
    private String cvemoneda;
    private String descmoneda;
    private String clavesatmoneda;
    private Boolean esactivo;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCvemoneda() {
        return cvemoneda;
    }

    public void setCvemoneda(String cvemoneda) {
        this.cvemoneda = cvemoneda;
    }

    public String getDescmoneda() {
        return descmoneda;
    }

    public void setDescmoneda(String descmoneda) {
        this.descmoneda = descmoneda;
    }

    public String getClavesatmoneda() {
        return clavesatmoneda;
    }

    public void setClavesatmoneda(String clavesatmoneda) {
        this.clavesatmoneda = clavesatmoneda;
    }

    public Boolean getEsactivo() {
        return esactivo;
    }

    public void setEsactivo(Boolean esactivo) {
        this.esactivo = esactivo;
    }

}