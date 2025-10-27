package com.ws_rr6_safa_calculo.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

public class Capa {
    private Integer id;
    private Integer datoscontratoId;
    private Integer ccmonedaId;
    private Short numerocapa;
    private BigDecimal prioridadcapacidadminima;
    private BigDecimal capacidadmontocubre;
    private Double cuotaajustecapa;
    private Short numeroreinstalaciones;
    private BigDecimal primaminima;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDatoscontratoId() {
        return datoscontratoId;
    }

    public void setDatoscontratoId(Integer datoscontratoId) {
        this.datoscontratoId = datoscontratoId;
    }

    public Integer getCcmonedaId() {
        return ccmonedaId;
    }

    public void setCcmonedaId(Integer ccmonedaId) {
        this.ccmonedaId = ccmonedaId;
    }

    public Short getNumerocapa() {
        return numerocapa;
    }

    public void setNumerocapa(Short numerocapa) {
        this.numerocapa = numerocapa;
    }

    public BigDecimal getPrioridadcapacidadminima() {
        return prioridadcapacidadminima;
    }

    public void setPrioridadcapacidadminima(BigDecimal prioridadcapacidadminima) {
        this.prioridadcapacidadminima = prioridadcapacidadminima;
    }

    public BigDecimal getCapacidadmontocubre() {
        return capacidadmontocubre;
    }

    public void setCapacidadmontocubre(BigDecimal capacidadmontocubre) {
        this.capacidadmontocubre = capacidadmontocubre;
    }

    public Double getCuotaajustecapa() {
        return cuotaajustecapa;
    }

    public void setCuotaajustecapa(Double cuotaajustecapa) {
        this.cuotaajustecapa = cuotaajustecapa;
    }

    public Short getNumeroreinstalaciones() {
        return numeroreinstalaciones;
    }

    public void setNumeroreinstalaciones(Short numeroreinstalaciones) {
        this.numeroreinstalaciones = numeroreinstalaciones;
    }

    public BigDecimal getPrimaminima() {
        return primaminima;
    }

    public void setPrimaminima(BigDecimal primaminima) {
        this.primaminima = primaminima;
    }

}