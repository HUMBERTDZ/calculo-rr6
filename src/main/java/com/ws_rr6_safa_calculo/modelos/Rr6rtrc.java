package com.ws_rr6_safa_calculo.modelos;

import com.ws_rr6_safa_calculo.models.HistoricoRyR;

import javax.persistence.*;
import java.math.BigDecimal;

public class Rr6rtrc {
    private Integer id;
    private String identificadorcontrato;
    private String clavenegocio;
    private String negocioscubiertos;
    private String moneda;
    private Short tipocaptura;
    private String camposmodificados;
    private String iniciovigencia;
    private String finvigencia;
    private Short tipocontrato;
    private Short capaslineascontrato;
    private BigDecimal porcioncedida;
    private BigDecimal retencionprioridad;
    private String retencionprioridadfianzas;
    private BigDecimal capacidadmaxlimresp;
    private String capacidadmaxlimrespfian;
    private BigDecimal importereinstalaciones;
    private String comisionreasegurorateonline;
    private String participacionutilidades;
    private String reaseguradoresinscritos;
    private String tiporeaseguradornacional;
    private String clavereaseguradornacional;
    private String reaseguradornoinscrito;
    private BigDecimal participacionreasegurador;
    private Character tipointermediarioutilizado;
    private String claveintermediarioutilizado;
    private String intermediarionoautorizado;
    private String suscriptorfacultado;
    private String aclaraciones;
    private HistoricoRyR historico;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificadorcontrato() {
        return identificadorcontrato;
    }

    public void setIdentificadorcontrato(String identificadorcontrato) {
        this.identificadorcontrato = identificadorcontrato;
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

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Short getTipocaptura() {
        return tipocaptura;
    }

    public void setTipocaptura(Short tipocaptura) {
        this.tipocaptura = tipocaptura;
    }

    public String getCamposmodificados() {
        return camposmodificados;
    }

    public void setCamposmodificados(String camposmodificados) {
        this.camposmodificados = camposmodificados;
    }

    public String getIniciovigencia() {
        return iniciovigencia;
    }

    public void setIniciovigencia(String iniciovigencia) {
        this.iniciovigencia = iniciovigencia;
    }

    public String getFinvigencia() {
        return finvigencia;
    }

    public void setFinvigencia(String finvigencia) {
        this.finvigencia = finvigencia;
    }

    public Short getTipocontrato() {
        return tipocontrato;
    }

    public void setTipocontrato(Short tipocontrato) {
        this.tipocontrato = tipocontrato;
    }

    public Short getCapaslineascontrato() {
        return capaslineascontrato;
    }

    public void setCapaslineascontrato(Short capaslineascontrato) {
        this.capaslineascontrato = capaslineascontrato;
    }

    public BigDecimal getPorcioncedida() {
        return porcioncedida;
    }

    public void setPorcioncedida(BigDecimal porcioncedida) {
        this.porcioncedida = porcioncedida;
    }

    public BigDecimal getRetencionprioridad() {
        return retencionprioridad;
    }

    public void setRetencionprioridad(BigDecimal retencionprioridad) {
        this.retencionprioridad = retencionprioridad;
    }

    public String getRetencionprioridadfianzas() {
        return retencionprioridadfianzas;
    }

    public void setRetencionprioridadfianzas(String retencionprioridadfianzas) {
        this.retencionprioridadfianzas = retencionprioridadfianzas;
    }

    public BigDecimal getCapacidadmaxlimresp() {
        return capacidadmaxlimresp;
    }

    public void setCapacidadmaxlimresp(BigDecimal capacidadmaxlimresp) {
        this.capacidadmaxlimresp = capacidadmaxlimresp;
    }

    public String getCapacidadmaxlimrespfian() {
        return capacidadmaxlimrespfian;
    }

    public void setCapacidadmaxlimrespfian(String capacidadmaxlimrespfian) {
        this.capacidadmaxlimrespfian = capacidadmaxlimrespfian;
    }

    public BigDecimal getImportereinstalaciones() {
        return importereinstalaciones;
    }

    public void setImportereinstalaciones(BigDecimal importereinstalaciones) {
        this.importereinstalaciones = importereinstalaciones;
    }

    public String getComisionreasegurorateonline() {
        return comisionreasegurorateonline;
    }

    public void setComisionreasegurorateonline(String comisionreasegurorateonline) {
        this.comisionreasegurorateonline = comisionreasegurorateonline;
    }

    public String getParticipacionutilidades() {
        return participacionutilidades;
    }

    public void setParticipacionutilidades(String participacionutilidades) {
        this.participacionutilidades = participacionutilidades;
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

    public BigDecimal getParticipacionreasegurador() {
        return participacionreasegurador;
    }

    public void setParticipacionreasegurador(BigDecimal participacionreasegurador) {
        this.participacionreasegurador = participacionreasegurador;
    }

    public Character getTipointermediarioutilizado() {
        return tipointermediarioutilizado;
    }

    public void setTipointermediarioutilizado(Character tipointermediarioutilizado) {
        this.tipointermediarioutilizado = tipointermediarioutilizado;
    }

    public String getClaveintermediarioutilizado() {
        return claveintermediarioutilizado;
    }

    public void setClaveintermediarioutilizado(String claveintermediarioutilizado) {
        this.claveintermediarioutilizado = claveintermediarioutilizado;
    }

    public String getIntermediarionoautorizado() {
        return intermediarionoautorizado;
    }

    public void setIntermediarionoautorizado(String intermediarionoautorizado) {
        this.intermediarionoautorizado = intermediarionoautorizado;
    }

    public String getSuscriptorfacultado() {
        return suscriptorfacultado;
    }

    public void setSuscriptorfacultado(String suscriptorfacultado) {
        this.suscriptorfacultado = suscriptorfacultado;
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