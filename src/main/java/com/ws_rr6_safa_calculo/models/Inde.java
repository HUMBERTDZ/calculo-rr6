package com.ws_rr6_safa_calculo.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "INDE")
@NamedQuery(name = "Inde.findAll", query = "SELECT i FROM Inde i")
public class Inde implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CVE_INDE")
	private int cveInde;

	@Column(name = "NIVEL_1")
	private String nivel1;

	@Column(name = "NIVEL_2")
	private String nivel2;

	@Column(name = "NIVEL_3")
	private String nivel3;

	@Column(name = "NIVEL_4")
	private String nivel4;

	@Column(name = "MONEDA")
	private String moneda;

	@Column(name = "CONSECUTIV")
	private String consecutiv;

	@Column(name = "AFECTACION")
	private String afectacion;

	@Column(name = "MDA_BASE")
	private String mdaBase;

	@Column(name = "FCH_ADQ")
	private String fchAdq;

	@Column(name = "LIQUIDEZ")
	private String liquidez;

	@Column(name = "ISIN")
	private String isin;

	@Column(name = "EMISOR")
	private String emisor;

	@Column(name = "DESCRIPC")
	private String descripc;

	@Column(name = "PARAMETRIZ")
	private String parametriz;

	@Column(name = "SERIE")
	private String serie;

	@Column(name = "TIPO_VALOR")
	private String tipoValor;

	@Column(name = "NUM_CONTRS")
	private String numContrs;

	@Column(name = "FCH_EMI")
	private String fchEmi;

	@Column(name = "FCH_VTO")
	private String fchVto;

	@Column(name = "TASA_RDTO")
	private String tasaRdto;

	@Column(name = "CALIFIC")
	private String calific;

	@Column(name = "TIPO_MOD")
	private String tipoMod;

	@Column(name = "TIPO_ORG")
	private String tipoOrg;

	@Column(name = "CONTRATO")
	private String contrato;

	@Column(name = "CLAVE_ORG")
	private String claveOrg;

	@Column(name = "PRECIO_EJ")
	private String precioEj;

	@Column(name = "IND_EFECT")
	private String indEfect;

	@Column(name = "CTO_ADQ_POSICION_ACTIVA")
	private String ctoAdqPosicionActiva;

	@Column(name = "CTO_ADQ_POSICION_PASIVA")
	private String ctoAdqPosicionPasiva;

	@Column(name = "NETO_ADQUISICION")
	private String netoAdquisicion;

	@Column(name = "COTIZACION_POSICION_ACTIVA")
	private String cotizacionPosicionActiva;

	@Column(name = "COTIZACION_POSICION_PASIV")
	private String cotizacionPosicionPasiv;

	@Column(name = "NETO_COTIZACION")
	private String netoCotizacion;

	@Column(name = "PRIMA_PAGADA_OPCIONES")
	private String primaPagadaOpciones;

	@Column(name = "PRIMA_EVALUADA_OPCIONES")
	private String primaEvaluadaOpciones;

	@Column(name = "INCREMENTO_VALUACIÓN")
	private String incrementoValuación;

	@Column(name = "APORT_GARANT_DERIVADOS")
	private String aportGarantDerivados;

	@Column(name = "CONSEC_DV")
	private String consecDv;

	@Column(name = "MONTO_EFECTO")
	private String montoEfecto;

	@Column(name = "NIVEL_FONDOS")
	private String nivelFondos;

	@Column(name = "TÍTULOS")
	private String títulos;

	@Column(name = "TIPO_EMISORA")
	private String tipoEmisora;

	@Column(name = "PRECIO_EJ_PAS")
	private String precioEjPas;

	@Column(name = "MONEDA_ACT")
	private String monedaAct;

	@Column(name = "MONEDA_PAS")
	private String monedaPas;

	@Column(name = "PZO_PAGO_ACT")
	private String pzoPagoAct;

	@Column(name = "PZO_PAGO_PAS")
	private String pzoPagoPas;

	@Column(name = "TIPO_MOD_PAS")
	private String tipoModPas;

	@Column(name = "PORTA_SEG_FLEX")
	private String portaSegFlex;

	@Column(name = "TASA_GARANTI")
	private String tasaGaranti;

	@Column(name = "CALCE")
	private String calce;

	@Column(name = "TASA_PACTADA_SWAP_ACT")
	private String tasaPactadaSwapAct;

	@Column(name = "TASA_PACTADA_SWAP_PAS")
	private String tasaPactadaSwapPas;

	@Column(name = "ANIOMES")
	private String anioMes;

	public Inde() {
	}

	public int getCveInde() {
		return cveInde;
	}

	public void setCveInde(int cveInde) {
		this.cveInde = cveInde;
	}

	public String getAnioMes() {
		return anioMes;
	}

	public void setAnioMes(String anioMes) {
		this.anioMes = anioMes;
	}

	public String getAfectacion() {
		return this.afectacion;
	}

	public void setAfectacion(String afectacion) {
		this.afectacion = afectacion;
	}

	public String getAportGarantDerivados() {
		return this.aportGarantDerivados;
	}

	public void setAportGarantDerivados(String aportGarantDerivados) {
		this.aportGarantDerivados = aportGarantDerivados;
	}

	public String getCalce() {
		return this.calce;
	}

	public void setCalce(String calce) {
		this.calce = calce;
	}

	public String getCalific() {
		return this.calific;
	}

	public void setCalific(String calific) {
		this.calific = calific;
	}

	public String getClaveOrg() {
		return this.claveOrg;
	}

	public void setClaveOrg(String claveOrg) {
		this.claveOrg = claveOrg;
	}

	public String getConsecDv() {
		return this.consecDv;
	}

	public void setConsecDv(String consecDv) {
		this.consecDv = consecDv;
	}

	public String getConsecutiv() {
		return this.consecutiv;
	}

	public void setConsecutiv(String consecutiv) {
		this.consecutiv = consecutiv;
	}

	public String getContrato() {
		return this.contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public String getCotizacionPosicionActiva() {
		return this.cotizacionPosicionActiva;
	}

	public void setCotizacionPosicionActiva(String cotizacionPosicionActiva) {
		this.cotizacionPosicionActiva = cotizacionPosicionActiva;
	}

	public String getCotizacionPosicionPasiv() {
		return this.cotizacionPosicionPasiv;
	}

	public void setCotizacionPosicionPasiv(String cotizacionPosicionPasiv) {
		this.cotizacionPosicionPasiv = cotizacionPosicionPasiv;
	}

	public String getCtoAdqPosicionActiva() {
		return this.ctoAdqPosicionActiva;
	}

	public void setCtoAdqPosicionActiva(String ctoAdqPosicionActiva) {
		this.ctoAdqPosicionActiva = ctoAdqPosicionActiva;
	}

	public String getCtoAdqPosicionPasiva() {
		return this.ctoAdqPosicionPasiva;
	}

	public void setCtoAdqPosicionPasiva(String ctoAdqPosicionPasiva) {
		this.ctoAdqPosicionPasiva = ctoAdqPosicionPasiva;
	}

	public String getDescripc() {
		return this.descripc;
	}

	public void setDescripc(String descripc) {
		this.descripc = descripc;
	}

	public String getEmisor() {
		return this.emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public String getFchAdq() {
		return this.fchAdq;
	}

	public void setFchAdq(String fchAdq) {
		this.fchAdq = fchAdq;
	}

	public String getFchEmi() {
		return this.fchEmi;
	}

	public void setFchEmi(String fchEmi) {
		this.fchEmi = fchEmi;
	}

	public String getFchVto() {
		return this.fchVto;
	}

	public void setFchVto(String fchVto) {
		this.fchVto = fchVto;
	}

	public String getIncrementoValuación() {
		return this.incrementoValuación;
	}

	public void setIncrementoValuación(String incrementoValuación) {
		this.incrementoValuación = incrementoValuación;
	}

	public String getIndEfect() {
		return this.indEfect;
	}

	public void setIndEfect(String indEfect) {
		this.indEfect = indEfect;
	}

	public String getIsin() {
		return this.isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	public String getLiquidez() {
		return this.liquidez;
	}

	public void setLiquidez(String liquidez) {
		this.liquidez = liquidez;
	}

	public String getMdaBase() {
		return this.mdaBase;
	}

	public void setMdaBase(String mdaBase) {
		this.mdaBase = mdaBase;
	}

	public String getMoneda() {
		return this.moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getMonedaAct() {
		return this.monedaAct;
	}

	public void setMonedaAct(String monedaAct) {
		this.monedaAct = monedaAct;
	}

	public String getMonedaPas() {
		return this.monedaPas;
	}

	public void setMonedaPas(String monedaPas) {
		this.monedaPas = monedaPas;
	}

	public String getMontoEfecto() {
		return this.montoEfecto;
	}

	public void setMontoEfecto(String montoEfecto) {
		this.montoEfecto = montoEfecto;
	}

	public String getNetoAdquisicion() {
		return this.netoAdquisicion;
	}

	public void setNetoAdquisicion(String netoAdquisicion) {
		this.netoAdquisicion = netoAdquisicion;
	}

	public String getNetoCotizacion() {
		return this.netoCotizacion;
	}

	public void setNetoCotizacion(String netoCotizacion) {
		this.netoCotizacion = netoCotizacion;
	}

	public String getNivel1() {
		return this.nivel1;
	}

	public void setNivel1(String nivel1) {
		this.nivel1 = nivel1;
	}

	public String getNivel2() {
		return this.nivel2;
	}

	public void setNivel2(String nivel2) {
		this.nivel2 = nivel2;
	}

	public String getNivel3() {
		return this.nivel3;
	}

	public void setNivel3(String nivel3) {
		this.nivel3 = nivel3;
	}

	public String getNivel4() {
		return this.nivel4;
	}

	public void setNivel4(String nivel4) {
		this.nivel4 = nivel4;
	}

	public String getNivelFondos() {
		return this.nivelFondos;
	}

	public void setNivelFondos(String nivelFondos) {
		this.nivelFondos = nivelFondos;
	}

	public String getNumContrs() {
		return this.numContrs;
	}

	public void setNumContrs(String numContrs) {
		this.numContrs = numContrs;
	}

	public String getParametriz() {
		return this.parametriz;
	}

	public void setParametriz(String parametriz) {
		this.parametriz = parametriz;
	}

	public String getPortaSegFlex() {
		return this.portaSegFlex;
	}

	public void setPortaSegFlex(String portaSegFlex) {
		this.portaSegFlex = portaSegFlex;
	}

	public String getPrecioEj() {
		return this.precioEj;
	}

	public void setPrecioEj(String precioEj) {
		this.precioEj = precioEj;
	}

	public String getPrecioEjPas() {
		return this.precioEjPas;
	}

	public void setPrecioEjPas(String precioEjPas) {
		this.precioEjPas = precioEjPas;
	}

	public String getPrimaEvaluadaOpciones() {
		return this.primaEvaluadaOpciones;
	}

	public void setPrimaEvaluadaOpciones(String primaEvaluadaOpciones) {
		this.primaEvaluadaOpciones = primaEvaluadaOpciones;
	}

	public String getPrimaPagadaOpciones() {
		return this.primaPagadaOpciones;
	}

	public void setPrimaPagadaOpciones(String primaPagadaOpciones) {
		this.primaPagadaOpciones = primaPagadaOpciones;
	}

	public String getPzoPagoAct() {
		return this.pzoPagoAct;
	}

	public void setPzoPagoAct(String pzoPagoAct) {
		this.pzoPagoAct = pzoPagoAct;
	}

	public String getPzoPagoPas() {
		return this.pzoPagoPas;
	}

	public void setPzoPagoPas(String pzoPagoPas) {
		this.pzoPagoPas = pzoPagoPas;
	}

	public String getSerie() {
		return this.serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getTasaGaranti() {
		return this.tasaGaranti;
	}

	public void setTasaGaranti(String tasaGaranti) {
		this.tasaGaranti = tasaGaranti;
	}

	public String getTasaPactadaSwapAct() {
		return this.tasaPactadaSwapAct;
	}

	public void setTasaPactadaSwapAct(String tasaPactadaSwapAct) {
		this.tasaPactadaSwapAct = tasaPactadaSwapAct;
	}

	public String getTasaPactadaSwapPas() {
		return this.tasaPactadaSwapPas;
	}

	public void setTasaPactadaSwapPas(String tasaPactadaSwapPas) {
		this.tasaPactadaSwapPas = tasaPactadaSwapPas;
	}

	public String getTasaRdto() {
		return this.tasaRdto;
	}

	public void setTasaRdto(String tasaRdto) {
		this.tasaRdto = tasaRdto;
	}

	public String getTipoEmisora() {
		return this.tipoEmisora;
	}

	public void setTipoEmisora(String tipoEmisora) {
		this.tipoEmisora = tipoEmisora;
	}

	public String getTipoMod() {
		return this.tipoMod;
	}

	public void setTipoMod(String tipoMod) {
		this.tipoMod = tipoMod;
	}

	public String getTipoModPas() {
		return this.tipoModPas;
	}

	public void setTipoModPas(String tipoModPas) {
		this.tipoModPas = tipoModPas;
	}

	public String getTipoOrg() {
		return this.tipoOrg;
	}

	public void setTipoOrg(String tipoOrg) {
		this.tipoOrg = tipoOrg;
	}

	public String getTipoValor() {
		return this.tipoValor;
	}

	public void setTipoValor(String tipoValor) {
		this.tipoValor = tipoValor;
	}

	public String getTítulos() {
		return this.títulos;
	}

	public void setTítulos(String títulos) {
		this.títulos = títulos;
	}

}
