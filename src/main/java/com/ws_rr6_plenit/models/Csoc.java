package com.ws_rr6_plenit.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="CSOC")
@NamedQuery(name="CSOC.findAll", query="SELECT c FROM Csoc c")
public class Csoc implements Serializable{

	private static final long serialVersionUID = 1883033385354943352L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CVE_CSOC")
	private String cveCsoc;

	@Column(name="NIVEL_1")
	private String nivel_1;

	@Column(name="NIVEL_2")
	private String nivel_2;

	@Column(name="NIVEL_3")
	private String nivel_3;

	@Column(name="NIVEL_4")
	private String nivel_4;
	
	@Column(name="MONEDA")
	private int moneda;
	
	@Column(name="CLAVE_CAP_SOC")
	private String claveCapSoc;
	
	@Column(name="SUB_CLAVE_CAP_SOC")
	private String subClaveCapSoc;

	@Column(name="SALDO")
	private int saldo;
	
	@Column(name="AFECTACION")
	private String afectacion;
	
	@Column(name="NIVEL_FONDOS")
	private String nivelFondos;
	
	@Column(name="CONTROL_CONSECUTIVO")
	private String controlConsecutivo;
	
	@Column(name="NOMBRE_CUENTA")
	private String nombreCuenta;

	public Csoc() {
	}

	public String getCveCsoc() {
		return cveCsoc;
	}

	public void setCveCsoc(String cveCsoc) {
		this.cveCsoc = cveCsoc;
	}

	public String getNivel_1() {
		return nivel_1;
	}

	public void setNivel_1(String nivel_1) {
		this.nivel_1 = nivel_1;
	}

	public String getNivel_2() {
		return nivel_2;
	}

	public void setNivel_2(String nivel_2) {
		this.nivel_2 = nivel_2;
	}

	public String getNivel_3() {
		return nivel_3;
	}

	public void setNivel_3(String nivel_3) {
		this.nivel_3 = nivel_3;
	}

	public String getNivel_4() {
		return nivel_4;
	}

	public void setNivel_4(String nivel_4) {
		this.nivel_4 = nivel_4;
	}

	public int getMoneda() {
		return moneda;
	}

	public void setMoneda(int moneda) {
		this.moneda = moneda;
	}

	public String getClaveCapSoc() {
		return claveCapSoc;
	}

	public void setClaveCapSoc(String claveCapSoc) {
		this.claveCapSoc = claveCapSoc;
	}

	public String getSubClaveCapSoc() {
		return subClaveCapSoc;
	}

	public void setSubClaveCapSoc(String subClaveCapSoc) {
		this.subClaveCapSoc = subClaveCapSoc;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public String getAfectacion() {
		return afectacion;
	}

	public void setAfectacion(String afectacion) {
		this.afectacion = afectacion;
	}

	public String getNivelFondos() {
		return nivelFondos;
	}

	public void setNivelFondos(String nivelFondos) {
		this.nivelFondos = nivelFondos;
	}

	public String getControlConsecutivo() {
		return controlConsecutivo;
	}

	public void setControlConsecutivo(String controlConsecutivo) {
		this.controlConsecutivo = controlConsecutivo;
	}

	public String getNombreCuenta() {
		return nombreCuenta;
	}

	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}
	
}
