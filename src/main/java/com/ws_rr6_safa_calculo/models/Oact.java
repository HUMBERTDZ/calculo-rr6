package com.ws_rr6_safa_calculo.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the OACT database table.
 * 
 */
@Entity
@Table(name = "OACT")
@NamedQuery(name = "Oact.findAll", query = "SELECT o FROM Oact o")
public class Oact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_OACT")
	private String id_oact;

	@Column(name = "NIVEL_1")
	private String nivel1;

	@Column(name = "NIVEL_2")
	private String nivel2;

	@Column(name = "NIVEL_3")
	private String nivel3;

	@Column(name = "NIVEL_4")
	private String nivel4;

	@Column(name = "MONEDA")
	private String moneda;

	@Column(name = "CVE_OTROS_ACTIV")
	private String cveOtrosActivos;

	@Column(name = "SUB_CVE_OTROS_ACTIV")
	private String Sub_Cve_Otros_Activos;

	@Column(name = "SALDO")
	private String valores;

	@Column(name = "AFECTACION")
	private String afectacion;

	@Column(name = "NIVEL_FONDOS")
	private String nivFondProp;

	@Column(name = "DESC_CVE_OTROS_ACTIVOS")
	private String descCveOtrosActivos;

	@Column(name = "DESC_SUBCVE_OTROS_ACTIVOS")
	private String descSubcveOtrosActivos;

	@Column(name = "ANIOMES")
	private String anioMes;

	public Oact() {
	}

	public String getId_oact() {
		return id_oact;
	}

	public void setId_oact(String id_oact) {
		this.id_oact = id_oact;
	}

	public String getAnioMes() {
		return anioMes;
	}

	public void setAnioMes(String anioMes) {
		this.anioMes = anioMes;
	}

	public String getAfectacion() {
		return this.afectacion;
	}

	public void setAfectacion(String afectacion) {
		this.afectacion = afectacion;
	}

	public String getId_Oact() {
		return id_oact;
	}

	public void setIdOact(String id_oact) {
		this.id_oact = id_oact;
	}

	public String getCveOtrosActivos() {
		return this.cveOtrosActivos;
	}

	public void setCveOtrosActivos(String cveOtrosActivos) {
		this.cveOtrosActivos = cveOtrosActivos;
	}

	public String getDescCveOtrosActivos() {
		return this.descCveOtrosActivos;
	}

	public void setDescCveOtrosActivos(String descCveOtrosActivos) {
		this.descCveOtrosActivos = descCveOtrosActivos;
	}

	public String getDescSubcveOtrosActivos() {
		return this.descSubcveOtrosActivos;
	}

	public void setDescSubcveOtrosActivos(String descSubcveOtrosActivos) {
		this.descSubcveOtrosActivos = descSubcveOtrosActivos;
	}

	public String getMoneda() {
		return this.moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getNivFondProp() {
		return this.nivFondProp;
	}

	public void setNivFondProp(String nivFondProp) {
		this.nivFondProp = nivFondProp;
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

	public String getSub_Cve_Otros_Activos() {
		return this.Sub_Cve_Otros_Activos;
	}

	public void setSub_Cve_Otros_Activos(String Sub_Cve_Otros_Activos) {
		this.Sub_Cve_Otros_Activos = Sub_Cve_Otros_Activos;
	}

	public String getValores() {
		return this.valores;
	}

	public void setValores(String valores) {
		this.valores = valores;
	}

}
