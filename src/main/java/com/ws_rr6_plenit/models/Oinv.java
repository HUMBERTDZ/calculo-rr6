package com.ws_rr6_plenit.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "OINV")
@NamedQuery(name = "Oinv.findAll", query = "SELECT o FROM Oinv o")
public class Oinv implements Serializable {

	private static final long serialVersionUID = -2243500105152445468L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CVE_OINV")
	private int cveOinv;

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

	@Column(name = "CONSECUTIVO")
	private String consecutivo;

	@Column(name = "AFECTACION")
	private String afectacion;

	@Column(name = "TIPO_ACTIVO")
	private String tipoActivo;

	@Column(name = "VAL_HIST_INICIAL")
	private String valHistInicial;

	@Column(name = "SALDO_CIERRE")
	private String saldoCierre;

	@Column(name = "NUMERO_LICITA")
	private String numeroLicita;

	@Column(name = "FECHA_ADQUI")
	private String fechaAdqui;

	@Column(name = "PERSONALIDAD_JURIDICA")
	private String personalidadJuridica;

	@Column(name = "RAZON_SOCIAL")
	private String razonSocial;

	@Column(name = "PRIMER_NOMBRE")
	private String primerNombre;

	@Column(name = "SEGUNDO_NOMBRE")
	private String segundoNombre;

	@Column(name = "APELLIDO_MATERNO")
	private String apellidoMaterno;

	@Column(name = "APELLIDO_PATERNO")
	private String apellidoPaterno;

	@Column(name = "FCH_VNTO")
	private String fchVnto;

	@Column(name = "D_X_INT")
	private String dXInt;

	@Column(name = "PLAZO_INT")
	private String plazoInt;

	@Column(name = "TASA_INT")
	private String tasaInt;

	@Column(name = "TIPO_DEUDOR")
	private String tipoDeudor;

	@Column(name = "TIPO_DXC")
	private String tipoDxc;

	@Column(name = "IMP_DEU_FIANZAS")
	private String impDeuFianzas;

	@Column(name = "TIPO_DEU_X_RESP")
	private String tipoDeuXResp;

	@Column(name = "TIPO_DIV")
	private String tipoDiv;

	@Column(name = "NIVEL_FONDOS")
	private String nivelFondos;

	@Column(name = "CVE_PONDERADOR_CONTRAPARTE")
	private String cvePonderadorContraparte;

	@Column(name = "CVE_PONDERADOR_GARANTIA")
	private String cvePonderadorGarantia;

	@Column(name = "CALIFONCPT")
	private String califoncpt;

	@Column(name = "CALIFONGARAN")
	private String califongaran;

	@Column(name = "PORTA_SEG_FLEX")
	private String portaSegFlex;

	@Column(name = "TASA_GARANTI")
	private String tasaGaranti;

	@Column(name = "TIPO_GARANTIA_COBERTURA")
	private String tipoGarantiaCobertura;

	@Column(name = "VALOR_CONVERSION_A_RIESGOCPT")
	private String valorConversionARiesgocpt;

	@Column(name = "VALOR_GARAN_COBER")
	private String valorGaranCober;

	@Column(name = "ANIOMES")
	private String anioMes;

	public Oinv() {
	}

	public int getCveOinv() {
		return cveOinv;
	}

	public void setCveOinv(int cveOinv) {
		this.cveOinv = cveOinv;
	}

	public String getdXInt() {
		return dXInt;
	}

	public void setdXInt(String dXInt) {
		this.dXInt = dXInt;
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

	public String getApellidoMaterno() {
		return this.apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getApellidoPaterno() {
		return this.apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getCalifoncpt() {
		return this.califoncpt;
	}

	public void setCalifoncpt(String califoncpt) {
		this.califoncpt = califoncpt;
	}

	public String getCalifongaran() {
		return this.califongaran;
	}

	public void setCalifongaran(String califongaran) {
		this.califongaran = califongaran;
	}

	public String getConsecutivo() {
		return this.consecutivo;
	}

	public void setConsecutivo(String consecutivo) {
		this.consecutivo = consecutivo;
	}

	public String getCvePonderadorContraparte() {
		return this.cvePonderadorContraparte;
	}

	public void setCvePonderadorContraparte(String cvePonderadorContraparte) {
		this.cvePonderadorContraparte = cvePonderadorContraparte;
	}

	public String getCvePonderadorGarantia() {
		return this.cvePonderadorGarantia;
	}

	public void setCvePonderadorGarantia(String cvePonderadorGarantia) {
		this.cvePonderadorGarantia = cvePonderadorGarantia;
	}

	public String getDXInt() {
		return this.dXInt;
	}

	public void setDXInt(String dXInt) {
		this.dXInt = dXInt;
	}

	public String getFchVnto() {
		return this.fchVnto;
	}

	public void setFchVnto(String fchVnto) {
		this.fchVnto = fchVnto;
	}

	public String getFechaAdqui() {
		return this.fechaAdqui;
	}

	public void setFechaAdqui(String fechaAdqui) {
		this.fechaAdqui = fechaAdqui;
	}

	public String getImpDeuFianzas() {
		return this.impDeuFianzas;
	}

	public void setImpDeuFianzas(String impDeuFianzas) {
		this.impDeuFianzas = impDeuFianzas;
	}

	public String getMoneda() {
		return this.moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
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

	public String getNumeroLicita() {
		return this.numeroLicita;
	}

	public void setNumeroLicita(String numeroLicita) {
		this.numeroLicita = numeroLicita;
	}

	public String getPersonalidadJuridica() {
		return this.personalidadJuridica;
	}

	public void setPersonalidadJuridica(String personalidadJuridica) {
		this.personalidadJuridica = personalidadJuridica;
	}

	public String getPlazoInt() {
		return this.plazoInt;
	}

	public void setPlazoInt(String plazoInt) {
		this.plazoInt = plazoInt;
	}

	public String getPortaSegFlex() {
		return this.portaSegFlex;
	}

	public void setPortaSegFlex(String portaSegFlex) {
		this.portaSegFlex = portaSegFlex;
	}

	public String getPrimerNombre() {
		return this.primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getSaldoCierre() {
		return this.saldoCierre;
	}

	public void setSaldoCierre(String saldoCierre) {
		this.saldoCierre = saldoCierre;
	}

	public String getSegundoNombre() {
		return this.segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getTasaGaranti() {
		return this.tasaGaranti;
	}

	public void setTasaGaranti(String tasaGaranti) {
		this.tasaGaranti = tasaGaranti;
	}

	public String getTasaInt() {
		return this.tasaInt;
	}

	public void setTasaInt(String tasaInt) {
		this.tasaInt = tasaInt;
	}

	public String getTipoActivo() {
		return this.tipoActivo;
	}

	public void setTipoActivo(String tipoActivo) {
		this.tipoActivo = tipoActivo;
	}

	public String getTipoDeuXResp() {
		return this.tipoDeuXResp;
	}

	public void setTipoDeuXResp(String tipoDeuXResp) {
		this.tipoDeuXResp = tipoDeuXResp;
	}

	public String getTipoDeudor() {
		return this.tipoDeudor;
	}

	public void setTipoDeudor(String tipoDeudor) {
		this.tipoDeudor = tipoDeudor;
	}

	public String getTipoDiv() {
		return this.tipoDiv;
	}

	public void setTipoDiv(String tipoDiv) {
		this.tipoDiv = tipoDiv;
	}

	public String getTipoDxc() {
		return this.tipoDxc;
	}

	public void setTipoDxc(String tipoDxc) {
		this.tipoDxc = tipoDxc;
	}

	public String getTipoGarantiaCobertura() {
		return this.tipoGarantiaCobertura;
	}

	public void setTipoGarantiaCobertura(String tipoGarantiaCobertura) {
		this.tipoGarantiaCobertura = tipoGarantiaCobertura;
	}

	public String getValHistInicial() {
		return this.valHistInicial;
	}

	public void setValHistInicial(String valHistInicial) {
		this.valHistInicial = valHistInicial;
	}

	public String getValorConversionARiesgocpt() {
		return this.valorConversionARiesgocpt;
	}

	public void setValorConversionARiesgocpt(String valorConversionARiesgocpt) {
		this.valorConversionARiesgocpt = valorConversionARiesgocpt;
	}

	public String getValorGaranCober() {
		return this.valorGaranCober;
	}

	public void setValorGaranCober(String valorGaranCober) {
		this.valorGaranCober = valorGaranCober;
	}

}
