package com.ws_rr6_safa_calculo.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "INMU")
@NamedQuery(name = "Inmu.findAll", query = "SELECT i FROM Inmu i")
public class Inmu implements Serializable {

	private static final long serialVersionUID = 8457834036906419977L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CVE_INMU")
	private int cveInmu;

	@Column(name = "NIVEL_1")
	private String nivel1;

	@Column(name = "NIVEL_2")
	private String nivel2;

	@Column(name = "NIVEL_3")
	private String nivel3;

	@Column(name = "NIVEL_4")
	private String nivel4;

	@Column(name = "AFECTACION")
	private String afectacion;

	@Column(name = "CALLE")
	private String calle;

	@Column(name = "CAP_SUPERAVIT")
	private double capSuperavit;

	@Column(name = "CLASIF_INM")
	private String clasifInm;

	@Column(name = "COLONIA")
	private String colonia;

	@Column(name = "CONSECUTIV")
	private double consecutiv;

	@Column(name = "CP")
	private String cp;

	@Column(name = "CTO_HIST")
	private double ctoHist;

	@Column(name = "DEPRE_INC")
	private double depreInc;

	@Column(name = "DEPRECI_HI")
	private double depreciHi;

	@Column(name = "ENTIDAD")
	private String entidad;

	@Column(name = "ESTATUS_P_R")
	private String estatusPR;

	@Column(name = "FCH_ADQ")
	private String fchAdq;

	@Column(name = "FCH_CAP_SV")
	private String fchCapSv;

	@Column(name = "FCH_INI_ARREN")
	private String fchIniArren;

	@Column(name = "FCH_INI_CONS")
	private String fchIniCons;

	@Column(name = "FCH_ULT_VAL")
	private String fchUltVal;

	@Column(name = "FCH_VEN_ARREN")
	private String fchVenArren;

	@Column(name = "GASTOS_AN")
	private double gastosAn;

	@Column(name = "IMPORTE_AFECTO_TOTAL")
	private double importeAfectoTotal;

	@Column(name = "INCR_VAL")
	private double incrVal;

	@Column(name = "MONEDA")
	private int moneda;

	@Column(name = "NIVEL_FONDOS")
	private String nivelFondos;

	@Column(name = "NUMERO")
	private String numero;

	@Column(name = "PORCENTAJE_AFECT")
	private double porcentajeAfect;

	@Column(name = "PORTA_SEG_FLEX")
	private String portaSegFlex;

	@Column(name = "RENTAS_AN")
	private double rentasAn;

	@Column(name = "SUPERAVIT_AFECTO_BI")
	private double superavitAfecto;

	@Column(name = "SUPERAVIT_AFECTO_OP")
	private double superavitAfectoOp;

	@Column(name = "SUPERAVIT_AFECTO_RCS")
	private double superavitAfectoRcs;

	@Column(name = "TASA_GARANTI")
	private double tasaGaranti;

	@Column(name = "TASA_RDTO")
	private double tasaRdto;

	@Column(name = "TIPO_INM")
	private String tipoInm;

	@Column(name = "TOTAL_INMUEBLE")
	private double totalInmueble;

	@Column(name = "VALOR_COMER")
	private double valorComer;

	@Column(name = "VALOR_FIS")
	private double valorFis;

	@Column(name = "VALOR_RENT")
	private double valorRent;

	@Column(name = "ANIOMES")
	private String anioMes;

	public Inmu() {
	}

	public int getCveInmu() {
		return cveInmu;
	}

	public void setCveInmu(int cveInmu) {
		this.cveInmu = cveInmu;
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

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public double getCapSuperavit() {
		return this.capSuperavit;
	}

	public void setCapSuperavit(double capSuperavit) {
		this.capSuperavit = capSuperavit;
	}

	public String getClasifInm() {
		return this.clasifInm;
	}

	public void setClasifInm(String clasifInm) {
		this.clasifInm = clasifInm;
	}

	public String getColonia() {
		return this.colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public double getConsecutiv() {
		return this.consecutiv;
	}

	public void setConsecutiv(double consecutiv) {
		this.consecutiv = consecutiv;
	}

	public String getCp() {
		return this.cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public double getCtoHist() {
		return this.ctoHist;
	}

	public void setCtoHist(double ctoHist) {
		this.ctoHist = ctoHist;
	}

	public double getDepreInc() {
		return this.depreInc;
	}

	public void setDepreInc(double depreInc) {
		this.depreInc = depreInc;
	}

	public double getDepreciHi() {
		return this.depreciHi;
	}

	public void setDepreciHi(double depreciHi) {
		this.depreciHi = depreciHi;
	}

	public String getEntidad() {
		return this.entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public String getEstatusPR() {
		return this.estatusPR;
	}

	public void setEstatusPR(String estatusPR) {
		this.estatusPR = estatusPR;
	}

	public String getFchAdq() {
		return this.fchAdq;
	}

	public void setFchAdq(String fchAdq) {
		this.fchAdq = fchAdq;
	}

	public String getFchCapSv() {
		return this.fchCapSv;
	}

	public void setFchCapSv(String fchCapSv) {
		this.fchCapSv = fchCapSv;
	}

	public String getFchIniArren() {
		return this.fchIniArren;
	}

	public void setFchIniArren(String fchIniArren) {
		this.fchIniArren = fchIniArren;
	}

	public String getFchIniCons() {
		return this.fchIniCons;
	}

	public void setFchIniCons(String fchIniCons) {
		this.fchIniCons = fchIniCons;
	}

	public String getFchUltVal() {
		return this.fchUltVal;
	}

	public void setFchUltVal(String fchUltVal) {
		this.fchUltVal = fchUltVal;
	}

	public String getFchVenArren() {
		return this.fchVenArren;
	}

	public void setFchVenArren(String fchVenArren) {
		this.fchVenArren = fchVenArren;
	}

	public double getGastosAn() {
		return this.gastosAn;
	}

	public void setGastosAn(double gastosAn) {
		this.gastosAn = gastosAn;
	}

	public double getImporteAfectoTotal() {
		return this.importeAfectoTotal;
	}

	public void setImporteAfectoTotal(double importeAfectoTotal) {
		this.importeAfectoTotal = importeAfectoTotal;
	}

	public double getIncrVal() {
		return this.incrVal;
	}

	public void setIncrVal(double incrVal) {
		this.incrVal = incrVal;
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

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getPorcentajeAfect() {
		return this.porcentajeAfect;
	}

	public void setPorcentajeAfect(double porcentajeAfect) {
		this.porcentajeAfect = porcentajeAfect;
	}

	public String getPortaSegFlex() {
		return this.portaSegFlex;
	}

	public void setPortaSegFlex(String portaSegFlex) {
		this.portaSegFlex = portaSegFlex;
	}

	public double getRentasAn() {
		return this.rentasAn;
	}

	public void setRentasAn(double rentasAn) {
		this.rentasAn = rentasAn;
	}

	public double getSuperavitAfecto() {
		return this.superavitAfecto;
	}

	public void setSuperavitAfecto(double superavitAfecto) {
		this.superavitAfecto = superavitAfecto;
	}

	public double getSuperavitAfectoOp() {
		return this.superavitAfectoOp;
	}

	public void setSuperavitAfectoOp(double superavitAfectoOp) {
		this.superavitAfectoOp = superavitAfectoOp;
	}

	public double getSuperavitAfectoRcs() {
		return this.superavitAfectoRcs;
	}

	public void setSuperavitAfectoRcs(double superavitAfectoRcs) {
		this.superavitAfectoRcs = superavitAfectoRcs;
	}

	public double getTasaGaranti() {
		return this.tasaGaranti;
	}

	public void setTasaGaranti(double tasaGaranti) {
		this.tasaGaranti = tasaGaranti;
	}

	public double getTasaRdto() {
		return this.tasaRdto;
	}

	public void setTasaRdto(double tasaRdto) {
		this.tasaRdto = tasaRdto;
	}

	public String getTipoInm() {
		return this.tipoInm;
	}

	public void setTipoInm(String tipoInm) {
		this.tipoInm = tipoInm;
	}

	public double getTotalInmueble() {
		return this.totalInmueble;
	}

	public void setTotalInmueble(double totalInmueble) {
		this.totalInmueble = totalInmueble;
	}

	public double getValorComer() {
		return this.valorComer;
	}

	public void setValorComer(double valorComer) {
		this.valorComer = valorComer;
	}

	public double getValorFis() {
		return this.valorFis;
	}

	public void setValorFis(double valorFis) {
		this.valorFis = valorFis;
	}

	public double getValorRent() {
		return this.valorRent;
	}

	public void setValorRent(double valorRent) {
		this.valorRent = valorRent;
	}

}