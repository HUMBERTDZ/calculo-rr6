package com.ws_rr6_safa_calculo.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

public class Rr6trivartre {
    private Instant fechacalculo;
    private String clavenegocio;
    private String negocioscubiertos;
    private Integer claveestrategica;
    private Integer ordencobertura;
    private String nombrecontrato;
    public Instant getFechacalculo() {
        return fechacalculo;
    }

    public void setFechacalculo(Instant fechacalculo) {
        this.fechacalculo = fechacalculo;
    }

    public String getClavenegocio() {
        return clavenegocio;
    }

    public void setClavenegocio(String clavenegocio) {
        this.clavenegocio = clavenegocio;
    }

    public String getNegocioscubiertos() {
        return negocioscubiertos;
    }

    public void setNegocioscubiertos(String negocioscubiertos) {
        this.negocioscubiertos = negocioscubiertos;
    }

    public Integer getClaveestrategica() {
        return claveestrategica;
    }

    public void setClaveestrategica(Integer claveestrategica) {
        this.claveestrategica = claveestrategica;
    }

    public Integer getOrdencobertura() {
        return ordencobertura;
    }

    public void setOrdencobertura(Integer ordencobertura) {
        this.ordencobertura = ordencobertura;
    }

    public String getNombrecontrato() {
        return nombrecontrato;
    }

    public void setNombrecontrato(String nombrecontrato) {
        this.nombrecontrato = nombrecontrato;
    }

}