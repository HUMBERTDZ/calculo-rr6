package com.ws_rr6_plenit.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="BASE")
@NamedQuery(name="Base.findAll", query="SELECT b FROM Base b")
public class Base implements Serializable {

	private static final long serialVersionUID = 1659453844269766991L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CVE_BASE")
	private int cveBase;
	
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
	
	@Column(name="OPERACION")
	private String operacion;

	@Column(name="CVE_RAMO")
	private String cveRamo;

	@Column(name="CVE_SUBRAMO")
	private String cveSubram;

	@Column(name="CVE_SUBSUBRAMO")
	private String cveSubsubramo;

	@Column(name="RSVA_TOT")
	private double rsvaTot;

	@Column(name="RSVA_RET")
	private double rsvaRet;

	@Column(name="RSVA_CED")
	private double rsvaCed;
	
	@Column(name="POR_CP")
	private double porCp;

	@Column(name="ANIOMES")
	private String anioMes;

	public Base() {
	}

	public int getCveBase() {
		return cveBase;
	}

	public void setCveBase(int cveBase) {
		this.cveBase = cveBase;
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

	public String getCveSubsubramo() {
		return this.cveSubsubramo;
	}

	public void setCveSubsubramo(String cveSubsubramo) {
		this.cveSubsubramo = cveSubsubramo;
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

	public double getPorCp() {
		return this.porCp;
	}

	public void setPorCp(double porCp) {
		this.porCp = porCp;
	}

	public double getRsvaCed() {
		return this.rsvaCed;
	}

	public void setRsvaCed(double rsvaCed) {
		this.rsvaCed = rsvaCed;
	}

	public double getRsvaRet() {
		return this.rsvaRet;
	}

	public void setRsvaRet(double rsvaRet) {
		this.rsvaRet = rsvaRet;
	}

	public double getRsvaTot() {
		return this.rsvaTot;
	}

	public void setRsvaTot(double rsvaTot) {
		this.rsvaTot = rsvaTot;
	}

	public String getAnioMes() {
		return anioMes;
	}

	public void setAnioMes(String anioMes) {
		this.anioMes = anioMes;
	}



}