package com.ws_rr6_safa_calculo.modelos;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

public class HistoricoRyR{
    private int id;
    private String fechaProceso;
    private String fechaDesde;
    private String fechaHasta;
    private String contentType;
    private String numeroDocumento;
    private String base64;
    private String moneda;
    private String subramo;
    private String reaseguradora;

    
	public HistoricoRyR() {
		super();
	}

	public HistoricoRyR(int id, String fechaProceso, String fechaDesde, String fechaHasta, String contentType,
			String numeroDocumento, String base64, String moneda, String subramo, String reaseguradora) {
		super();
		this.id = id;
		this.fechaProceso = fechaProceso;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.contentType = contentType;
		this.numeroDocumento = numeroDocumento;
		this.base64 = base64;
		this.moneda = moneda;
		this.subramo = subramo;
		this.reaseguradora = reaseguradora;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFechaProceso() {
		return fechaProceso;
	}

	public void setFechaProceso(String fechaProceso) {
		this.fechaProceso = fechaProceso;
	}

	public String getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public String getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(String fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getSubramo() {
		return subramo;
	}

	public void setSubramo(String subramo) {
		this.subramo = subramo;
	}

	public String getReaseguradora() {
		return reaseguradora;
	}

	public void setReaseguradora(String reaseguradora) {
		this.reaseguradora = reaseguradora;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String toString() {
		return "HistoricoRyR [id=" + id + ", fechaProceso=" + fechaProceso + ", fechaDesde=" + fechaDesde
				+ ", fechaHasta=" + fechaHasta + ", contentType=" + contentType + ", numeroDocumento=" + numeroDocumento
				+ ", base64=" + base64 + ", moneda=" + moneda + ", subramo=" + subramo + ", reaseguradora="
				+ reaseguradora + "]";
	}
	
	

    
}
