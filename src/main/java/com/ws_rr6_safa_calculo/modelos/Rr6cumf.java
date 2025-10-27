package com.ws_rr6_safa_calculo.modelos;

import com.ws_rr6_safa_calculo.models.HistoricoRyR;

import javax.persistence.*;
import java.math.BigDecimal;

public class Rr6cumf {
    private Integer id;
    private Integer numconsecutivo;
    private String nombrefiado;
    private String rfc;
    private Short clavegrupofiados;
    private String otrosgruposfiados;
    private String claveriesgocomun;
    private BigDecimal responsabilidadessuscritas;
    private BigDecimal responsabilidadesretenidas;
    private BigDecimal numerodefianzas;
    private String aclaraciones;
    private HistoricoRyR historico;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumconsecutivo() {
        return numconsecutivo;
    }

    public void setNumconsecutivo(Integer numconsecutivo) {
        this.numconsecutivo = numconsecutivo;
    }

    public String getNombrefiado() {
        return nombrefiado;
    }

    public void setNombrefiado(String nombrefiado) {
        this.nombrefiado = nombrefiado;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Short getClavegrupofiados() {
        return clavegrupofiados;
    }

    public void setClavegrupofiados(Short clavegrupofiados) {
        this.clavegrupofiados = clavegrupofiados;
    }

    public String getOtrosgruposfiados() {
        return otrosgruposfiados;
    }

    public void setOtrosgruposfiados(String otrosgruposfiados) {
        this.otrosgruposfiados = otrosgruposfiados;
    }

    public String getClaveriesgocomun() {
        return claveriesgocomun;
    }

    public void setClaveriesgocomun(String claveriesgocomun) {
        this.claveriesgocomun = claveriesgocomun;
    }

    public BigDecimal getResponsabilidadessuscritas() {
        return responsabilidadessuscritas;
    }

    public void setResponsabilidadessuscritas(BigDecimal responsabilidadessuscritas) {
        this.responsabilidadessuscritas = responsabilidadessuscritas;
    }

    public BigDecimal getResponsabilidadesretenidas() {
        return responsabilidadesretenidas;
    }

    public void setResponsabilidadesretenidas(BigDecimal responsabilidadesretenidas) {
        this.responsabilidadesretenidas = responsabilidadesretenidas;
    }

    public BigDecimal getNumerodefianzas() {
        return numerodefianzas;
    }

    public void setNumerodefianzas(BigDecimal numerodefianzas) {
        this.numerodefianzas = numerodefianzas;
    }

    public String getAclaraciones() {
        return aclaraciones;
    }

    public void setAclaraciones(String aclaraciones) {
        this.aclaraciones = aclaraciones;
    }

    public HistoricoRyR getHistorico() {
        return historico;
    }

    public void setHistorico(HistoricoRyR historico) {
        this.historico = historico;
    }

}