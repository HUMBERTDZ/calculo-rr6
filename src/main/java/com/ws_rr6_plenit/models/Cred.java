package com.ws_rr6_plenit.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "CRED")
@NamedQuery(name = "Cred.findAll", query = "SELECT c FROM Cred c")
public class Cred implements Serializable {

	private static final long serialVersionUID = 6956715493093271144L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CVE_CRED")
	private int cveCred;

	@Column(name = "NIVEL_1")
	private String nivel1;

	@Column(name = "NIVEL_2")
	private String nivel2;

	@Column(name = "NIVEL_3")
	private String nivel3;

	@Column(name = "NIVEL_4")
	private String nivel4;

	@Column(name = "MONEDA")
	private int moneda;

	@Column(name = "CONSECUTIVO")
	private double consecutiv;

	@Column(name = "AFECTACION")
	private String afectacion;

	@Column(name = "TIPO_CREDITO")
	private String tipoCredito;

	@Column(name = "VAL_HIST_INICIAL")
	private double valHistInicial;

	@Column(name = "SALDO_CIERRE")
	private double saldoCierre;

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

	@Column(name = "FECHA_VENCIMIENTO")
	private String fechaVencimiento;

	@Column(name = "ESTIM_CASTIGOS")
	private double estimCastigos;

	@Column(name = "D_X_I")
	private double dXI;

	@Column(name = "PAGO_CAPITAL")
	private double pagoCapital;

	@Column(name = "CARTERA_VENCIDA")
	private double carteraVencida;

	@Column(name = "PLAZO_INT")
	private double plazoInt;

	@Column(name = "TASA_INT")
	private double tasaInt;

	@Column(name = "GARANTIA")
	private String garantia;

	@Column(name = "VALOR_GARAN")
	private double valorGaran;

	@Column(name = "AVALUO_FIS")
	private double avaluoFis;

	@Column(name = "RESERVA_PREVENTIVA")
	private double reservaPreventiva;

	@Column(name = "NIVEL_FONDOS")
	private String nivelFondos;

	@Column(name = "NUMERO_POLIZA_VIDA")
	private String numeroPolizaVida;

	@Column(name = "NUMERO_POLIZA_DANIOS")
	private String numeroPolizaDanios;

	@Column(name = "TIPO_GARANTIA_COBERTURA")
	private String tipoGarantiaCobertura;

	@Column(name = "CALIFONCPT")
	private String califoncpt;

	@Column(name = "CVE_PONDERADOR_CONTRAPARTE")
	private String cvePonderadorContraparte;

	@Column(name = "CALIFONGARAN")
	private String califongaran;

	@Column(name = "CVE_PONDERADOR_GARANTIA")
	private String cvePonderadorGarantia;

	@Column(name = "VALOR_CONVERSION_A_RIESGOCPT")
	private double valorConversionARiesgocpt;

	@Column(name = "VALOR_GARAN_COBER")
	private double valorGaranCober;

	@Column(name = "PORTA_SEG_FLEX")
	private String portaSegFlex;

	@Column(name = "TASA_GARANTI")
	private int tasaGaranti;

	@Column(name = "ANIOMES")
	private String anioMes;

	public Cred() {
	}

	public int getCveCred() {
		return cveCred;
	}

	public void setCveCred(int cveCred) {
		this.cveCred = cveCred;
	}

	public double getdXI() {
		return dXI;
	}

	public void setdXI(double dXI) {
		this.dXI = dXI;
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

	public double getAvaluoFis() {
		return this.avaluoFis;
	}

	public void setAvaluoFis(double avaluoFis) {
		this.avaluoFis = avaluoFis;
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

	public double getCarteraVencida() {
		return this.carteraVencida;
	}

	public void setCarteraVencida(double carteraVencida) {
		this.carteraVencida = carteraVencida;
	}

	public double getConsecutiv() {
		return this.consecutiv;
	}

	public void setConsecutiv(double consecutiv) {
		this.consecutiv = consecutiv;
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

	public double getDXI() {
		return this.dXI;
	}

	public void setDXI(double dXI) {
		this.dXI = dXI;
	}

	public double getEstimCastigos() {
		return this.estimCastigos;
	}

	public void setEstimCastigos(double estimCastigos) {
		this.estimCastigos = estimCastigos;
	}

	public String getFechaAdqui() {
		return this.fechaAdqui;
	}

	public void setFechaAdqui(String fechaAdqui) {
		this.fechaAdqui = fechaAdqui;
	}

	public String getFechaVencimiento() {
		return this.fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getGarantia() {
		return this.garantia;
	}

	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}

	public int getMoneda() {
		return this.moneda;
	}

	public void setMoneda(int moneda) {
		this.moneda = moneda;
	}

	public String getNivelFondos() {
		return this.nivelFondos;
	}

	public void setNivelFondos(String nivelFondos) {
		this.nivelFondos = nivelFondos;
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

	public String getNumeroPolizaDanios() {
		return this.numeroPolizaDanios;
	}

	public void setNumeroPolizaDanios(String numeroPolizaDanios) {
		this.numeroPolizaDanios = numeroPolizaDanios;
	}

	public String getNumeroPolizaVida() {
		return this.numeroPolizaVida;
	}

	public void setNumeroPolizaVida(String numeroPolizaVida) {
		this.numeroPolizaVida = numeroPolizaVida;
	}

	public double getPagoCapital() {
		return this.pagoCapital;
	}

	public void setPagoCapital(double pagoCapital) {
		this.pagoCapital = pagoCapital;
	}

	public String getPersonalidadJuridica() {
		return this.personalidadJuridica;
	}

	public void setPersonalidadJuridica(String personalidadJuridica) {
		this.personalidadJuridica = personalidadJuridica;
	}

	public double getPlazoInt() {
		return this.plazoInt;
	}

	public void setPlazoInt(double plazoInt) {
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

	public double getReservaPreventiva() {
		return this.reservaPreventiva;
	}

	public void setReservaPreventiva(double reservaPreventiva) {
		this.reservaPreventiva = reservaPreventiva;
	}

	public double getSaldoCierre() {
		return this.saldoCierre;
	}

	public void setSaldoCierre(double saldoCierre) {
		this.saldoCierre = saldoCierre;
	}

	public String getSegundoNombre() {
		return this.segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public int getTasaGaranti() {
		return this.tasaGaranti;
	}

	public void setTasaGaranti(int tasaGaranti) {
		this.tasaGaranti = tasaGaranti;
	}

	public double getTasaInt() {
		return this.tasaInt;
	}

	public void setTasaInt(double tasaInt) {
		this.tasaInt = tasaInt;
	}

	public String getTipoCredito() {
		return this.tipoCredito;
	}

	public void setTipoCredito(String tipoCredito) {
		this.tipoCredito = tipoCredito;
	}

	public String getTipoGarantiaCobertura() {
		return this.tipoGarantiaCobertura;
	}

	public void setTipoGarantiaCobertura(String tipoGarantiaCobertura) {
		this.tipoGarantiaCobertura = tipoGarantiaCobertura;
	}

	public double getValHistInicial() {
		return this.valHistInicial;
	}

	public void setValHistInicial(double valHistInicial) {
		this.valHistInicial = valHistInicial;
	}

	public double getValorConversionARiesgocpt() {
		return this.valorConversionARiesgocpt;
	}

	public void setValorConversionARiesgocpt(double valorConversionARiesgocpt) {
		this.valorConversionARiesgocpt = valorConversionARiesgocpt;
	}

	public double getValorGaran() {
		return this.valorGaran;
	}

	public void setValorGaran(double valorGaran) {
		this.valorGaran = valorGaran;
	}

	public double getValorGaranCober() {
		return this.valorGaranCober;
	}

	public void setValorGaranCober(double valorGaranCober) {
		this.valorGaranCober = valorGaranCober;
	}

}