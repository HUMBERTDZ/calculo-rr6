package com.ws_rr6_plenit.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="OPAS")
@NamedQuery(name="Opas.findAll", query="SELECT o FROM Opas o")
public class Opas implements Serializable {

	private static final long serialVersionUID = 3468706439043328313L;
	
	@Id
	@Column(name="CVE_OPAS")
	private String cveOpas;

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
	
	@Column(name="CLAVE_OTROS_PASIV")
	private String claveOtrosPasiv;
	
	@Column(name="SUB_CLAVE_OTROS_PASIV")
	private String subClaveOtrosPasiv;
	
	@Column(name="SALDO")
	private double saldo;
	
	public Opas() {
	}

	public String getCveOpas() {
		return cveOpas;
	}

	public void setCveOpas(String cveOpas) {
		this.cveOpas = cveOpas;
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

	public String getClaveOtrosPasiv() {
		return claveOtrosPasiv;
	}

	public void setClaveOtrosPasiv(String claveOtrosPasiv) {
		this.claveOtrosPasiv = claveOtrosPasiv;
	}

	public String getSubClaveOtrosPasiv() {
		return subClaveOtrosPasiv;
	}

	public void setSubClaveOtrosPasiv(String subClaveOtrosPasiv) {
		this.subClaveOtrosPasiv = subClaveOtrosPasiv;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


}
