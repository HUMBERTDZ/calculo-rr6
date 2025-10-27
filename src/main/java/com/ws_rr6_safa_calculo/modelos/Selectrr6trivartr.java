package com.ws_rr6_safa_calculo.modelos;

import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

public class Selectrr6trivartr {
    private Integer consecutivo;
    private String numerosiniestro;
    private String clavenegocio;
    private String eventosiniestrorelcamacion;
    private String aseguradoafianzado;
    private String fechasiniestroreclamacion;
    private BigDecimal importesiniestroreclamacion;
    private BigDecimal importerecuperadosiniestro;
    private String reaseguradoresinscritos;
    private String tiporeaseguradornacional;
    private String clavereaseguradornacional;
    private String reaseguradornoinscrito;
    private Integer tiporeaseguro;
    private BigDecimal importeproporcional;
    private BigDecimal importenoproporcional;
    private BigDecimal importfacultativo;
    private String entidades;
    private String municipio;
    private Integer sectorpublicoprivado;
    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getNumerosiniestro() {
        return numerosiniestro;
    }

    public void setNumerosiniestro(String numerosiniestro) {
        this.numerosiniestro = numerosiniestro;
    }

    public String getClavenegocio() {
        return clavenegocio;
    }

    public void setClavenegocio(String clavenegocio) {
        this.clavenegocio = clavenegocio;
    }

    public String getEventosiniestrorelcamacion() {
        return eventosiniestrorelcamacion;
    }

    public void setEventosiniestrorelcamacion(String eventosiniestrorelcamacion) {
        this.eventosiniestrorelcamacion = eventosiniestrorelcamacion;
    }

    public String getAseguradoafianzado() {
        return aseguradoafianzado;
    }

    public void setAseguradoafianzado(String aseguradoafianzado) {
        this.aseguradoafianzado = aseguradoafianzado;
    }

    public String getFechasiniestroreclamacion() {
        return fechasiniestroreclamacion;
    }

    public void setFechasiniestroreclamacion(String fechasiniestroreclamacion) {
        this.fechasiniestroreclamacion = fechasiniestroreclamacion;
    }

    public BigDecimal getImportesiniestroreclamacion() {
        return importesiniestroreclamacion;
    }

    public void setImportesiniestroreclamacion(BigDecimal importesiniestroreclamacion) {
        this.importesiniestroreclamacion = importesiniestroreclamacion;
    }

    public BigDecimal getImporterecuperadosiniestro() {
        return importerecuperadosiniestro;
    }

    public void setImporterecuperadosiniestro(BigDecimal importerecuperadosiniestro) {
        this.importerecuperadosiniestro = importerecuperadosiniestro;
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

    public Integer getTiporeaseguro() {
        return tiporeaseguro;
    }

    public void setTiporeaseguro(Integer tiporeaseguro) {
        this.tiporeaseguro = tiporeaseguro;
    }

    public BigDecimal getImporteproporcional() {
        return importeproporcional;
    }

    public void setImporteproporcional(BigDecimal importeproporcional) {
        this.importeproporcional = importeproporcional;
    }

    public BigDecimal getImportenoproporcional() {
        return importenoproporcional;
    }

    public void setImportenoproporcional(BigDecimal importenoproporcional) {
        this.importenoproporcional = importenoproporcional;
    }

    public BigDecimal getImportfacultativo() {
        return importfacultativo;
    }

    public void setImportfacultativo(BigDecimal importfacultativo) {
        this.importfacultativo = importfacultativo;
    }

    public String getEntidades() {
        return entidades;
    }

    public void setEntidades(String entidades) {
        this.entidades = entidades;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public Integer getSectorpublicoprivado() {
        return sectorpublicoprivado;
    }

    public void setSectorpublicoprivado(Integer sectorpublicoprivado) {
        this.sectorpublicoprivado = sectorpublicoprivado;
    }

}