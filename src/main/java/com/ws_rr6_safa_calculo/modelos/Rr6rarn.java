package com.ws_rr6_safa_calculo.modelos;

import com.ws_rr6_safa_calculo.models.HistoricoRyR;

import javax.persistence.*;
import java.math.BigDecimal;

public class Rr6rarn {
    private Integer id;
    private String mes;
    private String concepto;
    private String claveramo;
    private String reaseguradoresinscritos;
    private String tiporeaseguradornacional;
    private String clavereaseguradornacional;
    private String reaseguradornoinscrito;
    private BigDecimal primacedida;
    private BigDecimal costocoberturaxl;
    private BigDecimal sumasegtotramoautori;
    private BigDecimal sumasegretramoautori;
    private HistoricoRyR historico;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public BigDecimal getPrimacedida() {
        return primacedida;
    }

    public void setPrimacedida(BigDecimal primacedida) {
        this.primacedida = primacedida;
    }

    public BigDecimal getCostocoberturaxl() {
        return costocoberturaxl;
    }

    public void setCostocoberturaxl(BigDecimal costocoberturaxl) {
        this.costocoberturaxl = costocoberturaxl;
    }

    public BigDecimal getSumasegtotramoautori() {
        return sumasegtotramoautori;
    }

    public void setSumasegtotramoautori(BigDecimal sumasegtotramoautori) {
        this.sumasegtotramoautori = sumasegtotramoautori;
    }

    public BigDecimal getSumasegretramoautori() {
        return sumasegretramoautori;
    }

    public void setSumasegretramoautori(BigDecimal sumasegretramoautori) {
        this.sumasegretramoautori = sumasegretramoautori;
    }

    public HistoricoRyR getHistorico() {
        return historico;
    }

    public void setHistorico(HistoricoRyR historico) {
        this.historico = historico;
    }

}