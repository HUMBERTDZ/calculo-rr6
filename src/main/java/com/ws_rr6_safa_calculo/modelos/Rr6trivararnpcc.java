package com.ws_rr6_safa_calculo.modelos;

import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

public class Rr6trivararnpcc {
    private String mes;
    private String concepto;
    private String claveramo;
    private String reaseguradoresinscritos;
    private String tiporeaseguradornacional;
    private String clavereaseguradornacional;
    private String reaseguradornoinscrito;
    private Double primacedida;
    private BigDecimal costocoberturaxl;
    private String sumasegtotramoautori;
    private String sumasegretramoautori;
    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getClaveramo() {
        return claveramo;
    }

    public void setClaveramo(String claveramo) {
        this.claveramo = claveramo;
    }

    public String getReaseguradoresinscritos() {
        return reaseguradoresinscritos;
    }

    public void setReaseguradoresinscritos(String reaseguradoresinscritos) {
        this.reaseguradoresinscritos = reaseguradoresinscritos;
    }

    public String getTiporeaseguradornacional() {
        return tiporeaseguradornacional;
    }

    public void setTiporeaseguradornacional(String tiporeaseguradornacional) {
        this.tiporeaseguradornacional = tiporeaseguradornacional;
    }

    public String getClavereaseguradornacional() {
        return clavereaseguradornacional;
    }

    public void setClavereaseguradornacional(String clavereaseguradornacional) {
        this.clavereaseguradornacional = clavereaseguradornacional;
    }

    public String getReaseguradornoinscrito() {
        return reaseguradornoinscrito;
    }

    public void setReaseguradornoinscrito(String reaseguradornoinscrito) {
        this.reaseguradornoinscrito = reaseguradornoinscrito;
    }

    public Double getPrimacedida() {
        return primacedida;
    }

    public void setPrimacedida(Double primacedida) {
        this.primacedida = primacedida;
    }

    public BigDecimal getCostocoberturaxl() {
        return costocoberturaxl;
    }

    public void setCostocoberturaxl(BigDecimal costocoberturaxl) {
        this.costocoberturaxl = costocoberturaxl;
    }

    public String getSumasegtotramoautori() {
        return sumasegtotramoautori;
    }

    public void setSumasegtotramoautori(String sumasegtotramoautori) {
        this.sumasegtotramoautori = sumasegtotramoautori;
    }

    public String getSumasegretramoautori() {
        return sumasegretramoautori;
    }

    public void setSumasegretramoautori(String sumasegretramoautori) {
        this.sumasegretramoautori = sumasegretramoautori;
    }

}