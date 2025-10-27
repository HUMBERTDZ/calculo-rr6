package com.ws_rr6_safa_calculo.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
public class Calculosiniestroapgm {
    private Integer id;

    private String nombrecontrato;

    private Integer tiporeaseguro;

    private Integer clavemoneda;

    private Integer subramo;

    private Integer cambioestatus;

    private String llave;

    private LocalDate fechaevaluacion;

    private Double retencionprioridad;

    private Integer edad;

    private Double montoretencionmo;

    private Double montocedidomo;

    private Double tipocambio;

    private Double montosobrantemo;

    private Double montofacultativomo;

    private Double montocedidototalmo;

    private String reaseguradornmo;

    private Integer idsiniestrocontable;

    private Integer iddatoscontrato;

    private Integer asientodiarioprocess;

    private String tipogastoajuste;

    private Double montoexcedentemo;

    private Integer orden;

    private Double montoexcedenteacum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombrecontrato() {
        return nombrecontrato;
    }

    public void setNombrecontrato(String nombrecontrato) {
        this.nombrecontrato = nombrecontrato;
    }

    public Integer getTiporeaseguro() {
        return tiporeaseguro;
    }

    public void setTiporeaseguro(Integer tiporeaseguro) {
        this.tiporeaseguro = tiporeaseguro;
    }

    public Integer getClavemoneda() {
        return clavemoneda;
    }

    public void setClavemoneda(Integer clavemoneda) {
        this.clavemoneda = clavemoneda;
    }

    public Integer getSubramo() {
        return subramo;
    }

    public void setSubramo(Integer subramo) {
        this.subramo = subramo;
    }

    public Integer getCambioestatus() {
        return cambioestatus;
    }

    public void setCambioestatus(Integer cambioestatus) {
        this.cambioestatus = cambioestatus;
    }

    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }

    public LocalDate getFechaevaluacion() {
        return fechaevaluacion;
    }

    public void setFechaevaluacion(LocalDate fechaevaluacion) {
        this.fechaevaluacion = fechaevaluacion;
    }

    public Double getRetencionprioridad() {
        return retencionprioridad;
    }

    public void setRetencionprioridad(Double retencionprioridad) {
        this.retencionprioridad = retencionprioridad;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Double getMontoretencionmo() {
        return montoretencionmo;
    }

    public void setMontoretencionmo(Double montoretencionmo) {
        this.montoretencionmo = montoretencionmo;
    }

    public Double getMontocedidomo() {
        return montocedidomo;
    }

    public void setMontocedidomo(Double montocedidomo) {
        this.montocedidomo = montocedidomo;
    }

    public Double getTipocambio() {
        return tipocambio;
    }

    public void setTipocambio(Double tipocambio) {
        this.tipocambio = tipocambio;
    }

    public Double getMontosobrantemo() {
        return montosobrantemo;
    }

    public void setMontosobrantemo(Double montosobrantemo) {
        this.montosobrantemo = montosobrantemo;
    }

    public Double getMontofacultativomo() {
        return montofacultativomo;
    }

    public void setMontofacultativomo(Double montofacultativomo) {
        this.montofacultativomo = montofacultativomo;
    }

    public Double getMontocedidototalmo() {
        return montocedidototalmo;
    }

    public void setMontocedidototalmo(Double montocedidototalmo) {
        this.montocedidototalmo = montocedidototalmo;
    }

    public String getReaseguradornmo() {
        return reaseguradornmo;
    }

    public void setReaseguradornmo(String reaseguradornmo) {
        this.reaseguradornmo = reaseguradornmo;
    }

    public Integer getIdsiniestrocontable() {
        return idsiniestrocontable;
    }

    public void setIdsiniestrocontable(Integer idsiniestrocontable) {
        this.idsiniestrocontable = idsiniestrocontable;
    }

    public Integer getIddatoscontrato() {
        return iddatoscontrato;
    }

    public void setIddatoscontrato(Integer iddatoscontrato) {
        this.iddatoscontrato = iddatoscontrato;
    }

    public Integer getAsientodiarioprocess() {
        return asientodiarioprocess;
    }

    public void setAsientodiarioprocess(Integer asientodiarioprocess) {
        this.asientodiarioprocess = asientodiarioprocess;
    }

    public String getTipogastoajuste() {
        return tipogastoajuste;
    }

    public void setTipogastoajuste(String tipogastoajuste) {
        this.tipogastoajuste = tipogastoajuste;
    }

    public Double getMontoexcedentemo() {
        return montoexcedentemo;
    }

    public void setMontoexcedentemo(Double montoexcedentemo) {
        this.montoexcedentemo = montoexcedentemo;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Double getMontoexcedenteacum() {
        return montoexcedenteacum;
    }

    public void setMontoexcedenteacum(Double montoexcedenteacum) {
        this.montoexcedenteacum = montoexcedenteacum;
    }

}