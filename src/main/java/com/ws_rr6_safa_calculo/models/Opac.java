package com.ws_rr6_safa_calculo.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="OPAC")
@NamedQuery(name="OPAC.findAll", query="SELECT o FROM Opac o")
public class Opac implements Serializable {

	private static final long serialVersionUID = -2057099427910520585L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CVE_OPAC")
	private String cveOpac;

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
	
	@Column(name="CLAVE_OPER_ANA_CONEX")
	private String claveOperAnaConex;
	
	@Column(name="SUB_CLAVE_OPER_ANA_CONEX")
	private String subClaveOperAnaConex;
	
	@Column(name="OPERACION")
	private String cveOper;

	@Column(name="CVE_RAMO")
	private String cveRamo;
	
	@Column(name="CVE_SUBRAMO")
	private String cveSubRam;
	
	@Column(name="CVE_SUBSUBRAMO")
	private String cveSubSubRamo;
	
	@Column(name="SALDO")
	private int saldo;

	public Opac() {
		
	}

	public String getCveOpac() {
		return cveOpac;
	}

	public void setCveOpac(String cveOpac) {
		this.cveOpac = cveOpac;
	}

	public String getNivel1() {
		return nivel1;
	}

	public void setNivel1(String nivel1) {
		this.nivel1 = nivel1;
	}

	public String getNivel2() {
		return nivel2;
	}

	public void setNivel2(String nivel2) {
		this.nivel2 = nivel2;
	}

	public String getNivel3() {
		return nivel3;
	}

	public void setNivel3(String nivel3) {
		this.nivel3 = nivel3;
	}

	public String getNivel4() {
		return nivel4;
	}

	public void setNivel4(String nivel4) {
		this.nivel4 = nivel4;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getClaveOperAnaConex() {
		return claveOperAnaConex;
	}

	public void setClaveOperAnaConex(String claveOperAnaConex) {
		this.claveOperAnaConex = claveOperAnaConex;
	}

	public String getSubClaveOperAnaConex() {
		return subClaveOperAnaConex;
	}

	public void setSubClaveOperAnaConex(String subClaveOperAnaConex) {
		this.subClaveOperAnaConex = subClaveOperAnaConex;
	}

	public String getCveOper() {
		return cveOper;
	}

	public void setCveOper(String cveOper) {
		this.cveOper = cveOper;
	}

	public String getCveRamo() {
		return cveRamo;
	}

	public void setCveRamo(String cveRamo) {
		this.cveRamo = cveRamo;
	}

	public String getCveSubRam() {
		return cveSubRam;
	}

	public void setCveSubRam(String cveSubRam) {
		this.cveSubRam = cveSubRam;
	}

	public String getCveSubSubRamo() {
		return cveSubSubRamo;
	}

	public void setCveSubSubRamo(String cveSubSubRamo) {
		this.cveSubSubRamo = cveSubSubRamo;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
}
