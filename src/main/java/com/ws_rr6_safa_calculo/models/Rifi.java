package com.ws_rr6_safa_calculo.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="RIFI")
@NamedQuery(name="Rifi.findAll", query="SELECT r FROM Rifi r")
public class Rifi implements Serializable {

	private static final long serialVersionUID = -8742730249699038100L;

	@Id
	@Column(name="CVE_RIFI")
	private String cveRifi;

	@Column(name="NIVEL_1")
	private String nivel1;

	@Column(name="NIVEL_2")
	private String nivel2;

	@Column(name="NIVEL_3")
	private String nivel3;

	@Column(name="NIVEL_4")
	private String nivel4;
	
	@Column(name="MONEDA")
	private int moneda;

	@Column(name="CLAVE_RIF")
	private String claveRif;
	
	@Column(name="SUB_CLAVE_RIF")
	private String subClaveRif;

	@Column(name="OPERACION")
	private String operacion;
	
	@Column(name="CVE_RAMO")
	private String cveRamo;
	
	@Column(name="CVE_SUBRAMO")
	private String cveSubram;

	@Column(name="CVE_SUBSUBRAMO")
	private String cveSubsubram;

	@Column(name="SALDO")
	private double saldo;

	public Rifi() {
	}

	public String getClaveRif() {
		return this.claveRif;
	}

	public void setClaveRif(String claveRif) {
		this.claveRif = claveRif;
	}

	public String getCveRamo() {
		return this.cveRamo;
	}

	public void setCveRamo(String cveRamo) {
		this.cveRamo = cveRamo;
	}

	public String getCveRifi() {
		return this.cveRifi;
	}

	public void setCveRifi(String cveRifi) {
		this.cveRifi = cveRifi;
	}

	public String getCveSubram() {
		return this.cveSubram;
	}

	public void setCveSubram(String cveSubram) {
		this.cveSubram = cveSubram;
	}

	public String getCveSubsubram() {
		return this.cveSubsubram;
	}

	public void setCveSubsubram(String cveSubsubram) {
		this.cveSubsubram = cveSubsubram;
	}

	public int getMoneda() {
		return this.moneda;
	}

	public void setMoneda(int moneda) {
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

	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getSubClaveRif() {
		return this.subClaveRif;
	}

	public void setSubClaveRif(String subClaveRif) {
		this.subClaveRif = subClaveRif;
	}

}