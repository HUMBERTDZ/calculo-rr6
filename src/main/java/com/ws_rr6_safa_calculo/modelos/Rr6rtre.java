package com.ws_rr6_safa_calculo.modelos;

import com.ws_rr6_safa_calculo.models.HistoricoRyR;

import javax.persistence.*;

public class Rr6rtre {
    private Integer id;
    private String clavenegocio;
    private String negocioscubiertos;
    private Integer claveestrategiareaseguro;
    private Short ordencobertura;
    private String identificadorcontrato;
    private HistoricoRyR historico;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getClaveestrategiareaseguro() {
        return claveestrategiareaseguro;
    }

    public void setClaveestrategiareaseguro(Integer claveestrategiareaseguro) {
        this.claveestrategiareaseguro = claveestrategiareaseguro;
    }

    public Short getOrdencobertura() {
        return ordencobertura;
    }

    public void setOrdencobertura(Short ordencobertura) {
        this.ordencobertura = ordencobertura;
    }

    public String getIdentificadorcontrato() {
        return identificadorcontrato;
    }

    public void setIdentificadorcontrato(String identificadorcontrato) {
        this.identificadorcontrato = identificadorcontrato;
    }

    public HistoricoRyR getHistorico() {
        return historico;
    }

    public void setHistorico(HistoricoRyR historico) {
        this.historico = historico;
    }

}