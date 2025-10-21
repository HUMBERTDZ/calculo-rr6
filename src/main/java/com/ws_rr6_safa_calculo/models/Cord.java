package com.ws_rr6_safa_calculo.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CORD database table.
 * 
 */
@Entity
@Table(name="CORD")
@NamedQuery(name="Cord.findAll", query="SELECT c FROM Cord c")
public class Cord implements Serializable {

	private static final long serialVersionUID = 4032420861128242810L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CVE_CORD")
	private String cveCord;

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

	@Column(name="CLAVE_CTAS_ORDEN")
	private String claveCtasOrden;
	
	@Column(name="SUB_CLAVE_CTAS_ORDEN")
	private String subClaveCtasOrden;

	@Column(name="SALDO")
	private double saldo;

	public Cord() {
		
	}

	public String getCveCord() {
		return cveCord;
	}

	public void setCveCord(String cveCord) {
		this.cveCord = cveCord;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
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

	public String getClaveCtasOrden() {
		return claveCtasOrden;
	}

	public void setClaveCtasOrden(String claveCtasOrden) {
		this.claveCtasOrden = claveCtasOrden;
	}

	public String getSubClaveCtasOrden() {
		return subClaveCtasOrden;
	}

	public void setSubClaveCtasOrden(String subClaveCtasOrden) {
		this.subClaveCtasOrden = subClaveCtasOrden;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
}
