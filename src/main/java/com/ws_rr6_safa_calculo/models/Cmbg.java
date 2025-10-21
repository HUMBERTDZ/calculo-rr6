package com.ws_rr6_safa_calculo.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CAT_EJEMPLO_CMBG database table.
 * 
 */
@Entity
@Table(name="CMBG")
@NamedQuery(name="Cmbg.findAll", query="SELECT c FROM Cmbg c")
public class Cmbg implements Serializable {
	private static final long serialVersionUID = -2317352373943211395L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CVE_NIV_BAL")
	private int cveNivBal;

	@Column(name="NIVEL1")
	private String nivel1;

	@Column(name="NIVEL2")
	private String nivel2;

	@Column(name="NIVEL3")
	private String nivel3;

	@Column(name="NIVEL4")
	private String nivel4;
	
	@Column(name="CVEMONEDA")
	private String cvemoneda;

	@Column(name="DESC_NIV_BAL")
	private String descNivBal;
	
	@Column(name="VALORES")
	private String valores;
	
	@Column(name="ESSUMA")
	private int essuma;
	
	@Column(name="cve_niv2")
	private String cveNiv2;

	@Column(name="SUMA_NIV_4")
	private String sumaNiv4;	

	@Column(name="A_SUM_NIV_3")
	private String aSumNiv3;

	@Column(name="A_SUM_NIV_4")
	private String aSumNiv4;
	
	@Column(name="SUMA_NIV_3")
	private String sumaNiv3;

	public Cmbg() {
	}

	public String getASumNiv3() {
		return this.aSumNiv3;
	}

	public void setASumNiv3(String aSumNiv3) {
		this.aSumNiv3 = aSumNiv3;
	}

	public String getASumNiv4() {
		return this.aSumNiv4;
	}

	public void setASumNiv4(String aSumNiv4) {
		this.aSumNiv4 = aSumNiv4;
	}

	public int getCveNivBal() {
		return this.cveNivBal;
	}

	public void setCveNivBal(int cveNivBal) {
		this.cveNivBal = cveNivBal;
	}

	public String getCveNiv2() {
		return this.cveNiv2;
	}

	public void setCveNiv2(String cveNiv2) {
		this.cveNiv2 = cveNiv2;
	}

	public String getCvemoneda() {
		return this.cvemoneda;
	}

	public void setCvemoneda(String cvemoneda) {
		this.cvemoneda = cvemoneda;
	}

	public String getDescNivBal() {
		return this.descNivBal;
	}

	public void setDescNivBal(String descNivBal) {
		this.descNivBal = descNivBal;
	}

	public int getEssuma() {
		return this.essuma;
	}

	public void setEssuma(int essuma) {
		this.essuma = essuma;
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

	public String getSumaNiv3() {
		return this.sumaNiv3;
	}

	public void setSumaNiv3(String sumaNiv3) {
		this.sumaNiv3 = sumaNiv3;
	}

	public String getSumaNiv4() {
		return this.sumaNiv4;
	}

	public void setSumaNiv4(String sumaNiv4) {
		this.sumaNiv4 = sumaNiv4;
	}

	public String getValores() {
		return this.valores;
	}

	public void setValores(String valores) {
		this.valores = valores;
	}

	@Override
	public String toString() {
		return "Cmbg [aSumNiv3=" + aSumNiv3 + ", aSumNiv4=" + aSumNiv4 + ", cveNivBal=" + cveNivBal + ", cveNiv2="
				+ cveNiv2 + ", cvemoneda=" + cvemoneda + ", descNivBal=" + descNivBal + ", essuma=" + essuma
				+ ", nivel1=" + nivel1 + ", nivel2=" + nivel2 + ", nivel3=" + nivel3 + ", nivel4=" + nivel4
				+ ", sumaNiv3=" + sumaNiv3 + ", sumaNiv4=" + sumaNiv4 + ", valores=" + valores + "]";
	}

}