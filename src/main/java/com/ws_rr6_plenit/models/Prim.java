package com.ws_rr6_plenit.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="PRIM")
@NamedQuery(name="Prim.findAll", query="SELECT p FROM Prim p")
public class Prim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CVE_PRIM")
	private String cvePrim;

	@Column(name="NIVEL_1")
	private String nivel1;

	@Column(name="NIVEL_2")
	private String nivel2;

	@Column(name="NIVEL_3")
	private String nivel3;

	@Column(name="NIVEL_4")
	private String nivel4;

	@Column(name="MONEDA")
	private String moneda;
	
	@Column(name="CLAVE_PRIMAS")
	private String clavePrimas;

	@Column(name="SUB_CLAVE_PRIMAS")
	private String subClavePrimas;
	
	@Column(name="OPERACION")
	private String operacion;
	
	@Column(name="CVE_RAMO")
	private String cveRamo;

	@Column(name="CVE_SUBRAMO")
	private String cveSubram;

	@Column(name="CVE_SUBSUBRAMO")
	private String cveSubsubram;

	@Column(name="SALDO")
	private String saldo;
		
	public Prim() {
	}

	public String getClavePrimas() {
		return this.clavePrimas;
	}

	public void setClavePrimas(String clavePrimas) {
		this.clavePrimas = clavePrimas;
	}

	public String getCvePrim() {
		return this.cvePrim;
	}

	public void setCvePrim(String cvePrim) {
		this.cvePrim = cvePrim;
	}

	public String getCveRamo() {
		return this.cveRamo;
	}

	public void setCveRamo(String cveRamo) {
		this.cveRamo = cveRamo;
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

	public void setOperación(String operacion) {
		this.operacion = operacion;
	}

	public String getSaldo() {
		return this.saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public String getSubClavePrimas() {
		return this.subClavePrimas;
	}

	public void setSubClavePrimas(String subClavePrimas) {
		this.subClavePrimas = subClavePrimas;
	}

}
