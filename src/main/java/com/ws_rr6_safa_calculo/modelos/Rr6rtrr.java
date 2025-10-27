package com.ws_rr6_safa_calculo.modelos;

import com.ws_rr6_safa_calculo.models.HistoricoRyR;

import javax.persistence.*;
import java.math.BigDecimal;

public class Rr6rtrr {
    private Integer id;
    private String identificadorcontrato;
    private Short tipocontrato;
    private String anioreporte;
    private String clavenegocio;
    private String iniciovigencia;
    private BigDecimal montocomisionreaseguro;
    private BigDecimal montoparticipacionutilidades;
    private BigDecimal montsinreclamrecuppropfacult;
    private BigDecimal montsinreclamrecupcontrnoprop;
    private BigDecimal montingreoperreasegfinanc;
    private BigDecimal otrosingresos;
    private BigDecimal montprimacedida;
    private BigDecimal montcostototcobercontratnopropor;
    private BigDecimal montparticipsalvament;
    private BigDecimal intererecursoreten;
    private BigDecimal interderivreasegfinanci;
    private BigDecimal castigocuentasreaseguro;
    private BigDecimal otrosegresos;
    private BigDecimal gastosreasegurador;
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

    public Short getTipocontrato() {
        return tipocontrato;
    }

    public void setTipocontrato(Short tipocontrato) {
        this.tipocontrato = tipocontrato;
    }

    public String getAnioreporte() {
        return anioreporte;
    }

    public void setAnioreporte(String anioreporte) {
        this.anioreporte = anioreporte;
    }

    public String getClavenegocio() {
        return clavenegocio;
    }

    public void setClavenegocio(String clavenegocio) {
        this.clavenegocio = clavenegocio;
    }

    public String getIniciovigencia() {
        return iniciovigencia;
    }

    public void setIniciovigencia(String iniciovigencia) {
        this.iniciovigencia = iniciovigencia;
    }

    public BigDecimal getMontocomisionreaseguro() {
        return montocomisionreaseguro;
    }

    public void setMontocomisionreaseguro(BigDecimal montocomisionreaseguro) {
        this.montocomisionreaseguro = montocomisionreaseguro;
    }

    public BigDecimal getMontoparticipacionutilidades() {
        return montoparticipacionutilidades;
    }

    public void setMontoparticipacionutilidades(BigDecimal montoparticipacionutilidades) {
        this.montoparticipacionutilidades = montoparticipacionutilidades;
    }

    public BigDecimal getMontsinreclamrecuppropfacult() {
        return montsinreclamrecuppropfacult;
    }

    public void setMontsinreclamrecuppropfacult(BigDecimal montsinreclamrecuppropfacult) {
        this.montsinreclamrecuppropfacult = montsinreclamrecuppropfacult;
    }

    public BigDecimal getMontsinreclamrecupcontrnoprop() {
        return montsinreclamrecupcontrnoprop;
    }

    public void setMontsinreclamrecupcontrnoprop(BigDecimal montsinreclamrecupcontrnoprop) {
        this.montsinreclamrecupcontrnoprop = montsinreclamrecupcontrnoprop;
    }

    public BigDecimal getMontingreoperreasegfinanc() {
        return montingreoperreasegfinanc;
    }

    public void setMontingreoperreasegfinanc(BigDecimal montingreoperreasegfinanc) {
        this.montingreoperreasegfinanc = montingreoperreasegfinanc;
    }

    public BigDecimal getOtrosingresos() {
        return otrosingresos;
    }

    public void setOtrosingresos(BigDecimal otrosingresos) {
        this.otrosingresos = otrosingresos;
    }

    public BigDecimal getMontprimacedida() {
        return montprimacedida;
    }

    public void setMontprimacedida(BigDecimal montprimacedida) {
        this.montprimacedida = montprimacedida;
    }

    public BigDecimal getMontcostototcobercontratnopropor() {
        return montcostototcobercontratnopropor;
    }

    public void setMontcostototcobercontratnopropor(BigDecimal montcostototcobercontratnopropor) {
        this.montcostototcobercontratnopropor = montcostototcobercontratnopropor;
    }

    public BigDecimal getMontparticipsalvament() {
        return montparticipsalvament;
    }

    public void setMontparticipsalvament(BigDecimal montparticipsalvament) {
        this.montparticipsalvament = montparticipsalvament;
    }

    public BigDecimal getIntererecursoreten() {
        return intererecursoreten;
    }

    public void setIntererecursoreten(BigDecimal intererecursoreten) {
        this.intererecursoreten = intererecursoreten;
    }

    public BigDecimal getInterderivreasegfinanci() {
        return interderivreasegfinanci;
    }

    public void setInterderivreasegfinanci(BigDecimal interderivreasegfinanci) {
        this.interderivreasegfinanci = interderivreasegfinanci;
    }

    public BigDecimal getCastigocuentasreaseguro() {
        return castigocuentasreaseguro;
    }

    public void setCastigocuentasreaseguro(BigDecimal castigocuentasreaseguro) {
        this.castigocuentasreaseguro = castigocuentasreaseguro;
    }

    public BigDecimal getOtrosegresos() {
        return otrosegresos;
    }

    public void setOtrosegresos(BigDecimal otrosegresos) {
        this.otrosegresos = otrosegresos;
    }

    public BigDecimal getGastosreasegurador() {
        return gastosreasegurador;
    }

    public void setGastosreasegurador(BigDecimal gastosreasegurador) {
        this.gastosreasegurador = gastosreasegurador;
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