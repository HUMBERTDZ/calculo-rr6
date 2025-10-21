package com.ws_rr6_safa_calculo.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "DEUD")
@NamedQuery(name = "Deud.findAll", query = "SELECT d FROM Deud d")
public class Deud implements Serializable {

	private static final long serialVersionUID = 421850341390378924L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CVE_DEUD")
	private int cveDeud;

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
	private double consecutivo;

	@Column(name = "OPERACION")
	private String operacion;

	@Column(name = "CVE_RAMO")
	private String cveRamo;

	@Column(name = "PLAZO")
	private String plazo;

	@Column(name = "AFECTACION")
	private String afectacion;

	@Column(name = "PRIMAS_POR_COBRAR_TOTAL")
	private double primasPorCobrarTotal;

	@Column(name = "RECARGOS")
	private double recargos;

	@Column(name = "IMPUESTOS")
	private double impuestos;

	@Column(name = "DERECHOS_POLIZA")
	private double derechosPoliza;

	@Column(name = "RECARGOS_DEV")
	private double recargosDev;

	@Column(name = "DERECHOS_POLIZA_DEV")
	private double derechosPolizaDev;

	@Column(name = "COMI_X_DEV")
	private double comiXDev;

	@Column(name = "PRIMAS_POR_COBRAR_AFECTO")
	private double primasPorCobrarAfecto;

	@Column(name = "ANIOMES")
	private String anioMes;

	public Deud() {
	}

	public int getCveDeud() {
		return cveDeud;
	}

	public void setCveDeud(int cveDeud) {
		this.cveDeud = cveDeud;
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

	public double getComiXDev() {
		return this.comiXDev;
	}

	public void setComiXDev(double comiXDev) {
		this.comiXDev = comiXDev;
	}

	public double getConsecutivo() {
		return this.consecutivo;
	}

	public void setConsecutivo(double consecutivo) {
		this.consecutivo = consecutivo;
	}

	public String getCveRamo() {
		return this.cveRamo;
	}

	public void setCveRamo(String cveRamo) {
		this.cveRamo = cveRamo;
	}

	public double getDerechosPoliza() {
		return this.derechosPoliza;
	}

	public void setDerechosPoliza(double derechosPoliza) {
		this.derechosPoliza = derechosPoliza;
	}

	public double getDerechosPolizaDev() {
		return this.derechosPolizaDev;
	}

	public void setDerechosPolizaDev(double derechosPolizaDev) {
		this.derechosPolizaDev = derechosPolizaDev;
	}

	public double getImpuestos() {
		return this.impuestos;
	}

	public void setImpuestos(double impuestos) {
		this.impuestos = impuestos;
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

	public String getOperacion() {
		return this.operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public String getPlazo() {
		return this.plazo;
	}

	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}

	public double getPrimasPorCobrarAfecto() {
		return this.primasPorCobrarAfecto;
	}

	public void setPrimasPorCobrarAfecto(double primasPorCobrarAfecto) {
		this.primasPorCobrarAfecto = primasPorCobrarAfecto;
	}

	public double getPrimasPorCobrarTotal() {
		return this.primasPorCobrarTotal;
	}

	public void setPrimasPorCobrarTotal(double primasPorCobrarTotal) {
		this.primasPorCobrarTotal = primasPorCobrarTotal;
	}

	public double getRecargos() {
		return this.recargos;
	}

	public void setRecargos(double recargos) {
		this.recargos = recargos;
	}

	public double getRecargosDev() {
		return this.recargosDev;
	}

	public void setRecargosDev(double recargosDev) {
		this.recargosDev = recargosDev;
	}

}