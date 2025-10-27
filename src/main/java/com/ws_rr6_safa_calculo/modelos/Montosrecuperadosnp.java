package com.ws_rr6_safa_calculo.modelos;

import com.ws_rr6_safa_calculo.models.HistoricoRyR;

import javax.persistence.*;
import java.math.BigDecimal;

public class Montosrecuperadosnp {
    private Integer id;
    private String siniestro;
    private String prodAct;
    private String poliza;
    private String certificadoCredito;
    private String subramo;
    private String evento;
    private Integer anio;
    private Short mes;
    private BigDecimal montornp;
    private HistoricoRyR historico;
    private Character typed;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSiniestro() {
        return siniestro;
    }

    public void setSiniestro(String siniestro) {
        this.siniestro = siniestro;
    }

    public String getProdAct() {
        return prodAct;
    }

    public void setProdAct(String prodAct) {
        this.prodAct = prodAct;
    }

    public String getPoliza() {
        return poliza;
    }

    public void setPoliza(String poliza) {
        this.poliza = poliza;
    }

    public String getCertificadoCredito() {
        return certificadoCredito;
    }

    public void setCertificadoCredito(String certificadoCredito) {
        this.certificadoCredito = certificadoCredito;
    }

    public String getSubramo() {
        return subramo;
    }

    public void setSubramo(String subramo) {
        this.subramo = subramo;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Short getMes() {
        return mes;
    }

    public void setMes(Short mes) {
        this.mes = mes;
    }

    public BigDecimal getMontornp() {
        return montornp;
    }

    public void setMontornp(BigDecimal montornp) {
        this.montornp = montornp;
    }

    public HistoricoRyR getHistorico() {
        return historico;
    }

    public void setHistorico(HistoricoRyR historico) {
        this.historico = historico;
    }

    public Character getTyped() {
        return typed;
    }

    public void setTyped(Character typed) {
        this.typed = typed;
    }

}