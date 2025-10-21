package com.ws_rr6_safa_calculo.models;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ACRE database table.
 * 
 */
@Entity
@Table(name="ACRE")
@NamedQuery(name="Acre.findAll", query="SELECT a FROM Acre a")
public class Acre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CVE_ACRE")
	private String cveAcre;
	
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

	@Column(name="CVE_ACREED")
	private String cveAcreed;
	
	@Column(name="SUB_CVE_ACREED")
	private String subCveAcreed;

	@Column(name="SALDO")
	private double valores;
	
	@Column(name="DESC_CVE_ACREED")
	private String descCveAcreed;

	@Column(name="DESC_SUB_CVE_ACREDD")
	private String descSubCveAcredd;

	public Acre() {
	}

	public String getCveAcre() {
		return this.cveAcre;
	}

	public void setCveAcre(String cveAcre) {
		this.cveAcre = cveAcre;
	}

	public String getCveAcreed() {
		return this.cveAcreed;
	}

	public void setCveAcreed(String cveAcreed) {
		this.cveAcreed = cveAcreed;
	}

	public String getDescCveAcreed() {
		return this.descCveAcreed;
	}

	public void setDescCveAcreed(String descCveAcreed) {
		this.descCveAcreed = descCveAcreed;
	}

	public String getDescSubCveAcredd() {
		return this.descSubCveAcredd;
	}

	public void setDescSubCveAcredd(String descSubCveAcredd) {
		this.descSubCveAcredd = descSubCveAcredd;
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

	public String getSubCveAcreed() {
		return this.subCveAcreed;
	}

	public void setSubCveAcreed(String subCveAcreed) {
		this.subCveAcreed = subCveAcreed;
	}

	public double getValores() {
		return this.valores;
	}

	public void setValores(double valores) {
		this.valores = valores;
	}

}