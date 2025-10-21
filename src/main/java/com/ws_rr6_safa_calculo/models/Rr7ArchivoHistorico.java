package com.ws_rr6_safa_calculo.models;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the RR7ARCHIVOHISTORICO database table.
 * 
 */
@Entity
@Table(name = "RR7ARCHIVOHISTORICO")
@NamedQuery(name = "RR7ARCHIVOHISTORICO.findAll", query = "SELECT r FROM Rr7ArchivoHistorico r")
public class Rr7ArchivoHistorico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "FECHAREGISTRO")
	private String fechaRegistro;

	private String nombreSimplificadoRr7;

	private String nombreExtendidoRr7;

	private String infoCargada;

	@Column(name = "BASE64RR7")
	private String base64Rr7;

	@Column(name = "ANIO")
	private String anio;

	@Column(name = "IDARCHIVO")
	private String idArchivo;

	public int codigoDescarga;

	public int requiereInformacion;

	public int activo;

	public int cargaInformacion;

	public int formularioCapInfo;

	@Column(name = "MES")
	private String mes;

	public Rr7ArchivoHistorico() {
	}

	public int getCargaInformacion() {
		return cargaInformacion;
	}

	public void setCargaInformacion(int cargaInformacion) {
		this.cargaInformacion = cargaInformacion;
	}

	public int getFormularioCapInfo() {
		return formularioCapInfo;
	}

	public void setFormularioCapInfo(int formularioCapInfo) {
		this.formularioCapInfo = formularioCapInfo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getNombreSimplificadoRr7() {
		return nombreSimplificadoRr7;
	}

	public void setNombreSimplificadoRr7(String nombreSimplificadoRr7) {
		this.nombreSimplificadoRr7 = nombreSimplificadoRr7;
	}

	public String getNombreExtendidoRr7() {
		return nombreExtendidoRr7;
	}

	public void setNombreExtendidoRr7(String nombreExtendidoRr7) {
		this.nombreExtendidoRr7 = nombreExtendidoRr7;
	}

	public String getBase64Rr7() {
		return base64Rr7;
	}

	public void setBase64Rr7(String base64Rr7) {
		this.base64Rr7 = base64Rr7;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getIdArchivo() {
		return idArchivo;
	}

	public void setIdArchivo(String idArchivo) {
		this.idArchivo = idArchivo;
	}

	public int getCodigoDescarga() {
		return codigoDescarga;
	}

	public void setCodigoDescarga(int codigoDescarga) {
		this.codigoDescarga = codigoDescarga;
	}

	public int getRequiereInformacion() {
		return requiereInformacion;
	}

	public void setRequiereInformacion(int requiereInformacion) {
		this.requiereInformacion = requiereInformacion;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getInfoCargada() {
		return infoCargada;
	}

	public void setInfoCargada(String infoCargada) {
		this.infoCargada = infoCargada;
	}

	@Override
	public String toString() {
		return "Rr7ArchivoHistorico [id=" + id + ", fechaRegistro=" + fechaRegistro + ", nombreSimplificadoRr7="
				+ nombreSimplificadoRr7 + ", nombreExtendidoRr7=" + nombreExtendidoRr7 + ", base64Rr7=" + base64Rr7
				+ ", anio=" + anio + ", idArchivo=" + idArchivo + ", codigoDescarga=" + codigoDescarga
				+ ", requiereInformacion=" + requiereInformacion + ", activo=" + activo + ", cargaInformacion="
				+ cargaInformacion + ", formularioCapInfo=" + formularioCapInfo + ", mes=" + mes + "]";
	}

}
