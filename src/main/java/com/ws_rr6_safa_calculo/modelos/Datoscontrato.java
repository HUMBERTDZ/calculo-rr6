package com.ws_rr6_safa_calculo.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

public class Datoscontrato {
    private Integer id;
    private String subramo;
    private String tipoplan;
    private String alias;
    private Integer tiporeaseguro;
    private Integer tipocontratos;
    private String nombrecontrato;
    private LocalDate iniciovigencia;
    private LocalDate finvigencia;
    private Integer aniosuscripcion;
    private String cvemoneda;
    private Integer mesiniciotrimestre;
    private Integer ccperiodicidadId;
    private String otorgaptu;
    private Double porcentajeptu;
    private Double cuotafacultativosmillar;
    private Double extraprimamul;
    private Double extraprimaadi;
    private Double factorriesgoabc;
    private Double factorriesgode;
    private Double factorriesgofg;
    private Double factorriesgohij;
    private Integer ccpduId;
    private String certificado;
    private Integer numfacultativo;
    private String negocioscubiertos;
    private String poliza;
    private Integer idcalculoemision;
    private Integer tipocalculo;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubramo() {
        return subramo;
    }

    public void setSubramo(String subramo) {
        this.subramo = subramo;
    }

    public String getTipoplan() {
        return tipoplan;
    }

    public void setTipoplan(String tipoplan) {
        this.tipoplan = tipoplan;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getTiporeaseguro() {
        return tiporeaseguro;
    }

    public void setTiporeaseguro(Integer tiporeaseguro) {
        this.tiporeaseguro = tiporeaseguro;
    }

    public Integer getTipocontratos() {
        return tipocontratos;
    }

    public void setTipocontratos(Integer tipocontratos) {
        this.tipocontratos = tipocontratos;
    }

    public String getNombrecontrato() {
        return nombrecontrato;
    }

    public void setNombrecontrato(String nombrecontrato) {
        this.nombrecontrato = nombrecontrato;
    }

    public LocalDate getIniciovigencia() {
        return iniciovigencia;
    }

    public void setIniciovigencia(LocalDate iniciovigencia) {
        this.iniciovigencia = iniciovigencia;
    }

    public LocalDate getFinvigencia() {
        return finvigencia;
    }

    public void setFinvigencia(LocalDate finvigencia) {
        this.finvigencia = finvigencia;
    }

    public Integer getAniosuscripcion() {
        return aniosuscripcion;
    }

    public void setAniosuscripcion(Integer aniosuscripcion) {
        this.aniosuscripcion = aniosuscripcion;
    }

    public String getCvemoneda() {
        return cvemoneda;
    }

    public void setCvemoneda(String cvemoneda) {
        this.cvemoneda = cvemoneda;
    }

    public Integer getMesiniciotrimestre() {
        return mesiniciotrimestre;
    }

    public void setMesiniciotrimestre(Integer mesiniciotrimestre) {
        this.mesiniciotrimestre = mesiniciotrimestre;
    }

    public Integer getCcperiodicidadId() {
        return ccperiodicidadId;
    }

    public void setCcperiodicidadId(Integer ccperiodicidadId) {
        this.ccperiodicidadId = ccperiodicidadId;
    }

    public String getOtorgaptu() {
        return otorgaptu;
    }

    public void setOtorgaptu(String otorgaptu) {
        this.otorgaptu = otorgaptu;
    }

    public Double getPorcentajeptu() {
        return porcentajeptu;
    }

    public void setPorcentajeptu(Double porcentajeptu) {
        this.porcentajeptu = porcentajeptu;
    }

    public Double getCuotafacultativosmillar() {
        return cuotafacultativosmillar;
    }

    public void setCuotafacultativosmillar(Double cuotafacultativosmillar) {
        this.cuotafacultativosmillar = cuotafacultativosmillar;
    }

    public Double getExtraprimamul() {
        return extraprimamul;
    }

    public void setExtraprimamul(Double extraprimamul) {
        this.extraprimamul = extraprimamul;
    }

    public Double getExtraprimaadi() {
        return extraprimaadi;
    }

    public void setExtraprimaadi(Double extraprimaadi) {
        this.extraprimaadi = extraprimaadi;
    }

    public Double getFactorriesgoabc() {
        return factorriesgoabc;
    }

    public void setFactorriesgoabc(Double factorriesgoabc) {
        this.factorriesgoabc = factorriesgoabc;
    }

    public Double getFactorriesgode() {
        return factorriesgode;
    }

    public void setFactorriesgode(Double factorriesgode) {
        this.factorriesgode = factorriesgode;
    }

    public Double getFactorriesgofg() {
        return factorriesgofg;
    }

    public void setFactorriesgofg(Double factorriesgofg) {
        this.factorriesgofg = factorriesgofg;
    }

    public Double getFactorriesgohij() {
        return factorriesgohij;
    }

    public void setFactorriesgohij(Double factorriesgohij) {
        this.factorriesgohij = factorriesgohij;
    }

    public Integer getCcpduId() {
        return ccpduId;
    }

    public void setCcpduId(Integer ccpduId) {
        this.ccpduId = ccpduId;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public Integer getNumfacultativo() {
        return numfacultativo;
    }

    public void setNumfacultativo(Integer numfacultativo) {
        this.numfacultativo = numfacultativo;
    }

    public String getNegocioscubiertos() {
        return negocioscubiertos;
    }

    public void setNegocioscubiertos(String negocioscubiertos) {
        this.negocioscubiertos = negocioscubiertos;
    }

    public String getPoliza() {
        return poliza;
    }

    public void setPoliza(String poliza) {
        this.poliza = poliza;
    }

    public Integer getIdcalculoemision() {
        return idcalculoemision;
    }

    public void setIdcalculoemision(Integer idcalculoemision) {
        this.idcalculoemision = idcalculoemision;
    }

    public Integer getTipocalculo() {
        return tipocalculo;
    }

    public void setTipocalculo(Integer tipocalculo) {
        this.tipocalculo = tipocalculo;
    }

}