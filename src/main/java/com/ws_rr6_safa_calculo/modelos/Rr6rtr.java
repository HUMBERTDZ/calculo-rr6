package com.ws_rr6_safa_calculo.modelos;

import com.ws_rr6_safa_calculo.models.HistoricoRyR;

import javax.persistence.*;
import java.math.BigDecimal;

public class Rr6rtr {
    private Integer id;
    private Integer numconsecutivo;
    private String numsiniestro;
    private String clavenegocio;
    private String esreclamacion;
    private String asfianzado;
    private String fsreclamacion;
    private BigDecimal impsinireclamado;
    private BigDecimal imprecuperadosini;
    private String reaseguradoresinscritos;
    private Character tiporeaseguradornacional;
    private String clavereaseguradornacional;
    private String reaseguradornoinscrito;
    private BigDecimal importeproporcional;
    private BigDecimal importenoproporcional;
    private BigDecimal importefacultativo;
    private String entidades;
    private String municipio;
    private Short sectorpuoprivado;
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

    public String getNumsiniestro() {
        return numsiniestro;
    }

    public void setNumsiniestro(String numsiniestro) {
        this.numsiniestro = numsiniestro;
    }

    public String getClavenegocio() {
        return clavenegocio;
    }

    public void setClavenegocio(String clavenegocio) {
        this.clavenegocio = clavenegocio;
    }

    public String getEsreclamacion() {
        return esreclamacion;
    }

    public void setEsreclamacion(String esreclamacion) {
        this.esreclamacion = esreclamacion;
    }

    public String getAsfianzado() {
        return asfianzado;
    }

    public void setAsfianzado(String asfianzado) {
        this.asfianzado = asfianzado;
    }

    public String getFsreclamacion() {
        return fsreclamacion;
    }

    public void setFsreclamacion(String fsreclamacion) {
        this.fsreclamacion = fsreclamacion;
    }

    public BigDecimal getImpsinireclamado() {
        return impsinireclamado;
    }

    public void setImpsinireclamado(BigDecimal impsinireclamado) {
        this.impsinireclamado = impsinireclamado;
    }

    public BigDecimal getImprecuperadosini() {
        return imprecuperadosini;
    }

    public void setImprecuperadosini(BigDecimal imprecuperadosini) {
        this.imprecuperadosini = imprecuperadosini;
    }

    public String getReaseguradoresinscritos() {
        return reaseguradoresinscritos;
    }

    public void setReaseguradoresinscritos(String reaseguradoresinscritos) {
        this.reaseguradoresinscritos = reaseguradoresinscritos;
    }

    public Character getTiporeaseguradornacional() {
        return tiporeaseguradornacional;
    }

    public void setTiporeaseguradornacional(Character tiporeaseguradornacional) {
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

    public BigDecimal getImportefacultativo() {
        return importefacultativo;
    }

    public void setImportefacultativo(BigDecimal importefacultativo) {
        this.importefacultativo = importefacultativo;
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

    public Short getSectorpuoprivado() {
        return sectorpuoprivado;
    }

    public void setSectorpuoprivado(Short sectorpuoprivado) {
        this.sectorpuoprivado = sectorpuoprivado;
    }

    public HistoricoRyR getHistorico() {
        return historico;
    }

    public void setHistorico(HistoricoRyR historico) {
        this.historico = historico;
    }

}