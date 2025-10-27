package com.ws_rr6_safa_calculo.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.time.LocalDate;

public class Calculoemisionapgm {
    private Integer id;
    private String nombrecontrato;
    private Integer idcontrato;
    private Integer iddetallescontrato;
    private LocalDate fechaproceso;
    private String cobertura;
    private String numeropoliza;
    private String numerocertificado;
    private Integer moneda;
    private Double sareaseguromo;
    private Double primacedidamo;
    private String sareasegurocapanmo;
    private String primacedidacapanmo;
    private Double primaretenidamo;
    private Double primadevengadamo;
    private Double primacedidatotalmo;
    private String reaseguradornmo;
    private Double incrementototalmo;
    private String incrementototalnmo;
    private Integer idcierreemision;
    private Double tipocambio;
    private Integer edad;
    private String llavepcmc;
    private String part2;
    private Boolean asientodiarioprocess;
    
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

    public Integer getIdcontrato() {
        return idcontrato;
    }

    public void setIdcontrato(Integer idcontrato) {
        this.idcontrato = idcontrato;
    }

    public Integer getIddetallescontrato() {
        return iddetallescontrato;
    }

    public void setIddetallescontrato(Integer iddetallescontrato) {
        this.iddetallescontrato = iddetallescontrato;
    }

    public LocalDate getFechaproceso() {
        return fechaproceso;
    }

    public void setFechaproceso(LocalDate fechaproceso) {
        this.fechaproceso = fechaproceso;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }

    public String getNumeropoliza() {
        return numeropoliza;
    }

    public void setNumeropoliza(String numeropoliza) {
        this.numeropoliza = numeropoliza;
    }

    public String getNumerocertificado() {
        return numerocertificado;
    }

    public void setNumerocertificado(String numerocertificado) {
        this.numerocertificado = numerocertificado;
    }

    public Integer getMoneda() {
        return moneda;
    }

    public void setMoneda(Integer moneda) {
        this.moneda = moneda;
    }

    public Double getSareaseguromo() {
        return sareaseguromo;
    }

    public void setSareaseguromo(Double sareaseguromo) {
        this.sareaseguromo = sareaseguromo;
    }

    public Double getPrimacedidamo() {
        return primacedidamo;
    }

    public void setPrimacedidamo(Double primacedidamo) {
        this.primacedidamo = primacedidamo;
    }

    public String getSareasegurocapanmo() {
        return sareasegurocapanmo;
    }

    public void setSareasegurocapanmo(String sareasegurocapanmo) {
        this.sareasegurocapanmo = sareasegurocapanmo;
    }

    public String getPrimacedidacapanmo() {
        return primacedidacapanmo;
    }

    public void setPrimacedidacapanmo(String primacedidacapanmo) {
        this.primacedidacapanmo = primacedidacapanmo;
    }

    public Double getPrimaretenidamo() {
        return primaretenidamo;
    }

    public void setPrimaretenidamo(Double primaretenidamo) {
        this.primaretenidamo = primaretenidamo;
    }

    public Double getPrimadevengadamo() {
        return primadevengadamo;
    }

    public void setPrimadevengadamo(Double primadevengadamo) {
        this.primadevengadamo = primadevengadamo;
    }

    public Double getPrimacedidatotalmo() {
        return primacedidatotalmo;
    }

    public void setPrimacedidatotalmo(Double primacedidatotalmo) {
        this.primacedidatotalmo = primacedidatotalmo;
    }

    public String getReaseguradornmo() {
        return reaseguradornmo;
    }

    public void setReaseguradornmo(String reaseguradornmo) {
        this.reaseguradornmo = reaseguradornmo;
    }

    public Double getIncrementototalmo() {
        return incrementototalmo;
    }

    public void setIncrementototalmo(Double incrementototalmo) {
        this.incrementototalmo = incrementototalmo;
    }

    public String getIncrementototalnmo() {
        return incrementototalnmo;
    }

    public void setIncrementototalnmo(String incrementototalnmo) {
        this.incrementototalnmo = incrementototalnmo;
    }

    public Integer getIdcierreemision() {
        return idcierreemision;
    }

    public void setIdcierreemision(Integer idcierreemision) {
        this.idcierreemision = idcierreemision;
    }

    public Double getTipocambio() {
        return tipocambio;
    }

    public void setTipocambio(Double tipocambio) {
        this.tipocambio = tipocambio;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getLlavepcmc() {
        return llavepcmc;
    }

    public void setLlavepcmc(String llavepcmc) {
        this.llavepcmc = llavepcmc;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public Boolean getAsientodiarioprocess() {
        return asientodiarioprocess;
    }

    public void setAsientodiarioprocess(Boolean asientodiarioprocess) {
        this.asientodiarioprocess = asientodiarioprocess;
    }

}