package com.ws_rr6_safa_calculo.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="FOPA")
@NamedQuery(name="Fopa.findAll", query="SELECT f FROM Fopa f")
public class Fopa implements Serializable {

	private static final long serialVersionUID = -8652993341359620854L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CVE_FOPA")
	private int cveFopa;

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

	@Column(name="AFECTACION")
	private String afectacion;

	@Column(name="NIVELFONDOS")
	private String nivelfondos;

	@Column(name="SALDO")
	private double saldo;

	public Fopa() {
	}

	public int getCveFopa() {
		return cveFopa;
	}

	public void setCveFopa(int cveFopa) {
		this.cveFopa = cveFopa;
	}

	public String getAfectacion() {
		return this.afectacion;
	}

	public void setAfectacion(String afectacion) {
		this.afectacion = afectacion;
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

	public String getNivelfondos() {
		return this.nivelfondos;
	}

	public void setNivelfondos(String nivelfondos) {
		this.nivelfondos = nivelfondos;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}