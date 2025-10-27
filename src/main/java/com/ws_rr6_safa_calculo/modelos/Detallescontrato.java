package com.ws_rr6_safa_calculo.modelos;

import javax.persistence.*;

public class Detallescontrato {
    private Integer id;
    private Datoscontrato datoscontrato;
    private Integer ccmonedaId;
    private Double limitemaximorespcontrato;
    private Double capacidadmaximaautomatica;
    private Double retencionimporte;
    private Double retencionporcetaje;
    private Double cesionimporte;
    private Double cesionporcentaje;
    private Double porcentajecomisionreasegurosobreprimacedida;
    private Double porcentajegastosreasegurador;
    private Double comisionsobreutilidades;
    private Integer ccproteccionId;
    private Double prioridad;
    private Integer reinstalaciones;
    private Double primaminimaanualimporte;
    private Double cuotaajuste;
    private Double comisionrateonline;
    private Double primamaximaanualimporte;
    private Integer minimoeventos;
    private Integer maximoeventos;
    private Double primaminimadeposito;
    private Double capacidadx;
    private Double retencionprioridadx;
    private Double tarifaminpermensual;
    private Double tarifamaxpermensual;
    private Double factorajuste;
    private Integer periodopago;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Datoscontrato getDatoscontrato() {
        return datoscontrato;
    }

    public void setDatoscontrato(Datoscontrato datoscontrato) {
        this.datoscontrato = datoscontrato;
    }

    public Integer getCcmonedaId() {
        return ccmonedaId;
    }

    public void setCcmonedaId(Integer ccmonedaId) {
        this.ccmonedaId = ccmonedaId;
    }

    public Double getLimitemaximorespcontrato() {
        return limitemaximorespcontrato;
    }

    public void setLimitemaximorespcontrato(Double limitemaximorespcontrato) {
        this.limitemaximorespcontrato = limitemaximorespcontrato;
    }

    public Double getCapacidadmaximaautomatica() {
        return capacidadmaximaautomatica;
    }

    public void setCapacidadmaximaautomatica(Double capacidadmaximaautomatica) {
        this.capacidadmaximaautomatica = capacidadmaximaautomatica;
    }

    public Double getRetencionimporte() {
        return retencionimporte;
    }

    public void setRetencionimporte(Double retencionimporte) {
        this.retencionimporte = retencionimporte;
    }

    public Double getRetencionporcetaje() {
        return retencionporcetaje;
    }

    public void setRetencionporcetaje(Double retencionporcetaje) {
        this.retencionporcetaje = retencionporcetaje;
    }

    public Double getCesionimporte() {
        return cesionimporte;
    }

    public void setCesionimporte(Double cesionimporte) {
        this.cesionimporte = cesionimporte;
    }

    public Double getCesionporcentaje() {
        return cesionporcentaje;
    }

    public void setCesionporcentaje(Double cesionporcentaje) {
        this.cesionporcentaje = cesionporcentaje;
    }

    public Double getPorcentajecomisionreasegurosobreprimacedida() {
        return porcentajecomisionreasegurosobreprimacedida;
    }

    public void setPorcentajecomisionreasegurosobreprimacedida(Double porcentajecomisionreasegurosobreprimacedida) {
        this.porcentajecomisionreasegurosobreprimacedida = porcentajecomisionreasegurosobreprimacedida;
    }

    public Double getPorcentajegastosreasegurador() {
        return porcentajegastosreasegurador;
    }

    public void setPorcentajegastosreasegurador(Double porcentajegastosreasegurador) {
        this.porcentajegastosreasegurador = porcentajegastosreasegurador;
    }

    public Double getComisionsobreutilidades() {
        return comisionsobreutilidades;
    }

    public void setComisionsobreutilidades(Double comisionsobreutilidades) {
        this.comisionsobreutilidades = comisionsobreutilidades;
    }

    public Integer getCcproteccionId() {
        return ccproteccionId;
    }

    public void setCcproteccionId(Integer ccproteccionId) {
        this.ccproteccionId = ccproteccionId;
    }

    public Double getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Double prioridad) {
        this.prioridad = prioridad;
    }

    public Integer getReinstalaciones() {
        return reinstalaciones;
    }

    public void setReinstalaciones(Integer reinstalaciones) {
        this.reinstalaciones = reinstalaciones;
    }

    public Double getPrimaminimaanualimporte() {
        return primaminimaanualimporte;
    }

    public void setPrimaminimaanualimporte(Double primaminimaanualimporte) {
        this.primaminimaanualimporte = primaminimaanualimporte;
    }

    public Double getCuotaajuste() {
        return cuotaajuste;
    }

    public void setCuotaajuste(Double cuotaajuste) {
        this.cuotaajuste = cuotaajuste;
    }

    public Double getComisionrateonline() {
        return comisionrateonline;
    }

    public void setComisionrateonline(Double comisionrateonline) {
        this.comisionrateonline = comisionrateonline;
    }

    public Double getPrimamaximaanualimporte() {
        return primamaximaanualimporte;
    }

    public void setPrimamaximaanualimporte(Double primamaximaanualimporte) {
        this.primamaximaanualimporte = primamaximaanualimporte;
    }

    public Integer getMinimoeventos() {
        return minimoeventos;
    }

    public void setMinimoeventos(Integer minimoeventos) {
        this.minimoeventos = minimoeventos;
    }

    public Integer getMaximoeventos() {
        return maximoeventos;
    }

    public void setMaximoeventos(Integer maximoeventos) {
        this.maximoeventos = maximoeventos;
    }

    public Double getPrimaminimadeposito() {
        return primaminimadeposito;
    }

    public void setPrimaminimadeposito(Double primaminimadeposito) {
        this.primaminimadeposito = primaminimadeposito;
    }

    public Double getCapacidadx() {
        return capacidadx;
    }

    public void setCapacidadx(Double capacidadx) {
        this.capacidadx = capacidadx;
    }

    public Double getRetencionprioridadx() {
        return retencionprioridadx;
    }

    public void setRetencionprioridadx(Double retencionprioridadx) {
        this.retencionprioridadx = retencionprioridadx;
    }

    public Double getTarifaminpermensual() {
        return tarifaminpermensual;
    }

    public void setTarifaminpermensual(Double tarifaminpermensual) {
        this.tarifaminpermensual = tarifaminpermensual;
    }

    public Double getTarifamaxpermensual() {
        return tarifamaxpermensual;
    }

    public void setTarifamaxpermensual(Double tarifamaxpermensual) {
        this.tarifamaxpermensual = tarifamaxpermensual;
    }

    public Double getFactorajuste() {
        return factorajuste;
    }

    public void setFactorajuste(Double factorajuste) {
        this.factorajuste = factorajuste;
    }

    public Integer getPeriodopago() {
        return periodopago;
    }

    public void setPeriodopago(Integer periodopago) {
        this.periodopago = periodopago;
    }

}