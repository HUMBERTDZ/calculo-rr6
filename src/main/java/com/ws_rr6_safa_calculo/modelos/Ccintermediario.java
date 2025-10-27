package com.ws_rr6_safa_calculo.modelos;

import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class Ccintermediario {
    private Integer id;
    private Integer clave;
    private String intermediario;
    private String directorgeneral;
    private String domicilio;
    private String telefono;
    private String correoelectronico;
    
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

    public String getIntermediario() {
        return intermediario;
    }

    public void setIntermediario(String intermediario) {
        this.intermediario = intermediario;
    }

    public String getDirectorgeneral() {
        return directorgeneral;
    }

    public void setDirectorgeneral(String directorgeneral) {
        this.directorgeneral = directorgeneral;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoelectronico() {
        return correoelectronico;
    }

    public void setCorreoelectronico(String correoelectronico) {
        this.correoelectronico = correoelectronico;
    }

}