package com.ws_rr6_safa_calculo.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Siniestrocontable {
    private Integer id;
    private String llave;
    private String ramo;
    private String numeropoliza;
    private String numerocertificado;
    private String clavecobertura;
    private String estatusreclamacion;
    private String numeroreclamacion;
    private String numerosiniestro;
    private BigDecimal periodoespera;
    private String clavesexo;
    private String clavecausasiniestro;
    private String claveentidad;
    private LocalDate fechacontabilizacionreclamacion;
    private LocalDate fechaocurrenciasiniestro;
    private LocalDate fechanacimiento;
    private LocalDate fechapagoreclamacion;
    private LocalDate fechareportereclamacion;
    private String tipogasto;
    private String tipomovimientoreclamacion;
    private String tipopago;
    private BigDecimal montocoaseguro;
    private BigDecimal montodeducible;
    private BigDecimal montoreclamacion;
    private BigDecimal montopagadoreclamacion;
    private BigDecimal montorecuperadoreaseguro;
    private String municipio;
    private String subramo;
    private LocalDate fechacorte;
    private BigDecimal montocoaseguromxn;
    private BigDecimal montodeduciblemxn;
    private BigDecimal montoreclamacionmxn;
    private BigDecimal montopagadoreclamacionmxn;
    private String tipoajuste;
    private String evento;
    private String nombreasegurado;
    private String clavemoneda;
    private BigDecimal tipocambio;
    private String descripcioncausasiniestro;
    private LocalDate fechainiciovigenciapoliza;
    private LocalDate fechafinvigenciapoliza;
    private LocalDate fechaemision;
    private Integer fumador;
    private String estatussiniestro;
    private String aniopoliza;
    private BigDecimal sumaaseguradamo;
    private BigDecimal sumaaseguradamxn;
    private BigDecimal gastoajustemo;
    private BigDecimal gastoajustemxn;
    private String costos;
    private String producto;
    private String contratonoproporcional;
    private BigDecimal afectacionxl;
    private String reinstalacioncapas;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
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

    public String getClavecobertura() {
        return clavecobertura;
    }

    public void setClavecobertura(String clavecobertura) {
        this.clavecobertura = clavecobertura;
    }

    public String getEstatusreclamacion() {
        return estatusreclamacion;
    }

    public void setEstatusreclamacion(String estatusreclamacion) {
        this.estatusreclamacion = estatusreclamacion;
    }

    public String getNumeroreclamacion() {
        return numeroreclamacion;
    }

    public void setNumeroreclamacion(String numeroreclamacion) {
        this.numeroreclamacion = numeroreclamacion;
    }

    public String getNumerosiniestro() {
        return numerosiniestro;
    }

    public void setNumerosiniestro(String numerosiniestro) {
        this.numerosiniestro = numerosiniestro;
    }

    public BigDecimal getPeriodoespera() {
        return periodoespera;
    }

    public void setPeriodoespera(BigDecimal periodoespera) {
        this.periodoespera = periodoespera;
    }

    public String getClavesexo() {
        return clavesexo;
    }

    public void setClavesexo(String clavesexo) {
        this.clavesexo = clavesexo;
    }

    public String getClavecausasiniestro() {
        return clavecausasiniestro;
    }

    public void setClavecausasiniestro(String clavecausasiniestro) {
        this.clavecausasiniestro = clavecausasiniestro;
    }

    public String getClaveentidad() {
        return claveentidad;
    }

    public void setClaveentidad(String claveentidad) {
        this.claveentidad = claveentidad;
    }

    public LocalDate getFechacontabilizacionreclamacion() {
        return fechacontabilizacionreclamacion;
    }

    public void setFechacontabilizacionreclamacion(LocalDate fechacontabilizacionreclamacion) {
        this.fechacontabilizacionreclamacion = fechacontabilizacionreclamacion;
    }

    public LocalDate getFechaocurrenciasiniestro() {
        return fechaocurrenciasiniestro;
    }

    public void setFechaocurrenciasiniestro(LocalDate fechaocurrenciasiniestro) {
        this.fechaocurrenciasiniestro = fechaocurrenciasiniestro;
    }

    public LocalDate getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(LocalDate fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public LocalDate getFechapagoreclamacion() {
        return fechapagoreclamacion;
    }

    public void setFechapagoreclamacion(LocalDate fechapagoreclamacion) {
        this.fechapagoreclamacion = fechapagoreclamacion;
    }

    public LocalDate getFechareportereclamacion() {
        return fechareportereclamacion;
    }

    public void setFechareportereclamacion(LocalDate fechareportereclamacion) {
        this.fechareportereclamacion = fechareportereclamacion;
    }

    public String getTipogasto() {
        return tipogasto;
    }

    public void setTipogasto(String tipogasto) {
        this.tipogasto = tipogasto;
    }

    public String getTipomovimientoreclamacion() {
        return tipomovimientoreclamacion;
    }

    public void setTipomovimientoreclamacion(String tipomovimientoreclamacion) {
        this.tipomovimientoreclamacion = tipomovimientoreclamacion;
    }

    public String getTipopago() {
        return tipopago;
    }

    public void setTipopago(String tipopago) {
        this.tipopago = tipopago;
    }

    public BigDecimal getMontocoaseguro() {
        return montocoaseguro;
    }

    public void setMontocoaseguro(BigDecimal montocoaseguro) {
        this.montocoaseguro = montocoaseguro;
    }

    public BigDecimal getMontodeducible() {
        return montodeducible;
    }

    public void setMontodeducible(BigDecimal montodeducible) {
        this.montodeducible = montodeducible;
    }

    public BigDecimal getMontoreclamacion() {
        return montoreclamacion;
    }

    public void setMontoreclamacion(BigDecimal montoreclamacion) {
        this.montoreclamacion = montoreclamacion;
    }

    public BigDecimal getMontopagadoreclamacion() {
        return montopagadoreclamacion;
    }

    public void setMontopagadoreclamacion(BigDecimal montopagadoreclamacion) {
        this.montopagadoreclamacion = montopagadoreclamacion;
    }

    public BigDecimal getMontorecuperadoreaseguro() {
        return montorecuperadoreaseguro;
    }

    public void setMontorecuperadoreaseguro(BigDecimal montorecuperadoreaseguro) {
        this.montorecuperadoreaseguro = montorecuperadoreaseguro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getSubramo() {
        return subramo;
    }

    public void setSubramo(String subramo) {
        this.subramo = subramo;
    }

    public LocalDate getFechacorte() {
        return fechacorte;
    }

    public void setFechacorte(LocalDate fechacorte) {
        this.fechacorte = fechacorte;
    }

    public BigDecimal getMontocoaseguromxn() {
        return montocoaseguromxn;
    }

    public void setMontocoaseguromxn(BigDecimal montocoaseguromxn) {
        this.montocoaseguromxn = montocoaseguromxn;
    }

    public BigDecimal getMontodeduciblemxn() {
        return montodeduciblemxn;
    }

    public void setMontodeduciblemxn(BigDecimal montodeduciblemxn) {
        this.montodeduciblemxn = montodeduciblemxn;
    }

    public BigDecimal getMontoreclamacionmxn() {
        return montoreclamacionmxn;
    }

    public void setMontoreclamacionmxn(BigDecimal montoreclamacionmxn) {
        this.montoreclamacionmxn = montoreclamacionmxn;
    }

    public BigDecimal getMontopagadoreclamacionmxn() {
        return montopagadoreclamacionmxn;
    }

    public void setMontopagadoreclamacionmxn(BigDecimal montopagadoreclamacionmxn) {
        this.montopagadoreclamacionmxn = montopagadoreclamacionmxn;
    }

    public String getTipoajuste() {
        return tipoajuste;
    }

    public void setTipoajuste(String tipoajuste) {
        this.tipoajuste = tipoajuste;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getNombreasegurado() {
        return nombreasegurado;
    }

    public void setNombreasegurado(String nombreasegurado) {
        this.nombreasegurado = nombreasegurado;
    }

    public String getClavemoneda() {
        return clavemoneda;
    }

    public void setClavemoneda(String clavemoneda) {
        this.clavemoneda = clavemoneda;
    }

    public BigDecimal getTipocambio() {
        return tipocambio;
    }

    public void setTipocambio(BigDecimal tipocambio) {
        this.tipocambio = tipocambio;
    }

    public String getDescripcioncausasiniestro() {
        return descripcioncausasiniestro;
    }

    public void setDescripcioncausasiniestro(String descripcioncausasiniestro) {
        this.descripcioncausasiniestro = descripcioncausasiniestro;
    }

    public LocalDate getFechainiciovigenciapoliza() {
        return fechainiciovigenciapoliza;
    }

    public void setFechainiciovigenciapoliza(LocalDate fechainiciovigenciapoliza) {
        this.fechainiciovigenciapoliza = fechainiciovigenciapoliza;
    }

    public LocalDate getFechafinvigenciapoliza() {
        return fechafinvigenciapoliza;
    }

    public void setFechafinvigenciapoliza(LocalDate fechafinvigenciapoliza) {
        this.fechafinvigenciapoliza = fechafinvigenciapoliza;
    }

    public LocalDate getFechaemision() {
        return fechaemision;
    }

    public void setFechaemision(LocalDate fechaemision) {
        this.fechaemision = fechaemision;
    }

    public Integer getFumador() {
        return fumador;
    }

    public void setFumador(Integer fumador) {
        this.fumador = fumador;
    }

    public String getEstatussiniestro() {
        return estatussiniestro;
    }

    public void setEstatussiniestro(String estatussiniestro) {
        this.estatussiniestro = estatussiniestro;
    }

    public String getAniopoliza() {
        return aniopoliza;
    }

    public void setAniopoliza(String aniopoliza) {
        this.aniopoliza = aniopoliza;
    }

    public BigDecimal getSumaaseguradamo() {
        return sumaaseguradamo;
    }

    public void setSumaaseguradamo(BigDecimal sumaaseguradamo) {
        this.sumaaseguradamo = sumaaseguradamo;
    }

    public BigDecimal getSumaaseguradamxn() {
        return sumaaseguradamxn;
    }

    public void setSumaaseguradamxn(BigDecimal sumaaseguradamxn) {
        this.sumaaseguradamxn = sumaaseguradamxn;
    }

    public BigDecimal getGastoajustemo() {
        return gastoajustemo;
    }

    public void setGastoajustemo(BigDecimal gastoajustemo) {
        this.gastoajustemo = gastoajustemo;
    }

    public BigDecimal getGastoajustemxn() {
        return gastoajustemxn;
    }

    public void setGastoajustemxn(BigDecimal gastoajustemxn) {
        this.gastoajustemxn = gastoajustemxn;
    }

    public String getCostos() {
        return costos;
    }

    public void setCostos(String costos) {
        this.costos = costos;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getContratonoproporcional() {
        return contratonoproporcional;
    }

    public void setContratonoproporcional(String contratonoproporcional) {
        this.contratonoproporcional = contratonoproporcional;
    }

    public BigDecimal getAfectacionxl() {
        return afectacionxl;
    }

    public void setAfectacionxl(BigDecimal afectacionxl) {
        this.afectacionxl = afectacionxl;
    }

    public String getReinstalacioncapas() {
        return reinstalacioncapas;
    }

    public void setReinstalacioncapas(String reinstalacioncapas) {
        this.reinstalacioncapas = reinstalacioncapas;
    }

}