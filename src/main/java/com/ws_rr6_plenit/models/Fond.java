package com.ws_rr6_plenit.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the FOND database table.
 * 
 */
@Entity
@Table(name = "FOND")
@NamedQuery(name = "Fond.findAll", query = "SELECT f FROM Fond f")
public class Fond implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CVE_FOND")
	private String cveFond;

	@Column(name = "NIVEL_1")
	private String nivel1;

	@Column(name = "NIVEL_2")
	private String nivel2;

	@Column(name = "NIVEL_3")
	private String nivel3;

	@Column(name = "NIVEL_4")
	private String nivel4;

	@Column(name = "CONSECUTIVO_INVE")
	private int consecutivoInve;

	@Column(name = "CVE_EMISOR_FOND")
	private String cveEmisorFond;

	@Column(name = "SERIE_FOND")
	private String serieFond;

	@Column(name = "TIPO_VALOR_FO")
	private String tipoValorFo;

	@Column(name = "CVE_EMISOR_INST")
	private String cveEmisorInst;

	@Column(name = "SERIE_INST")
	private String serieInst;

	@Column(name = "TIPO_VALOR_INST")
	private String tipoValorInst;

	@Column(name = "CLASIFICACION")
	private String clasificacion;

	@Column(name = "AFECTACION")
	private String afectacion;

	@Column(name = "ISIN")
	private String isin;

	@Column(name = "PARAMETRIZ")
	private String parametriz;

	@Column(name = "CONSECUTIVO_INST")
	private int consecutivoInst;

	@Column(name = "DESCRIPC")
	private String descripc;

	@Column(name = "LIQUIDEZ")
	private String liquidez;

	@Column(name = "MONEDA")
	private String moneda;

	@Column(name = "FCH_EMI_INST")
	private String fchEmiInst;

	@Column(name = "PORC_PARTIC_INST")
	private int porcParticInst;

	@Column(name = "CTO_ADQ_INST")
	private int ctoAdqInst;

	@Column(name = "VAL_COT_INST")
	private int valCotInst;

	@Column(name = "INC_DEC_VALUA")
	private int incDecValua;

	@Column(name = "CALIF")
	private String calif;

	@Column(name = "MDA_BASE")
	private int mdaBase;

	@Column(name = "NIVEL_FONDOS")
	private String nivelFondos;

	@Column(name = "ANIOMES")
	private String anioMes;

	public Fond() {
	}

	public String getAnioMes() {
		return anioMes;
	}

	public void setAnioMes(String anioMes) {
		this.anioMes = anioMes;
	}

	public String getCveFond() {
		return cveFond;
	}

	public void setCveFond(String cveFond) {
		this.cveFond = cveFond;
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

	public int getConsecutivoInve() {
		return consecutivoInve;
	}

	public void setConsecutivoInve(int consecutivoInve) {
		this.consecutivoInve = consecutivoInve;
	}

	public String getSerieFond() {
		return serieFond;
	}

	public void setSerieFond(String serieFond) {
		this.serieFond = serieFond;
	}

	public String getTipoValorFo() {
		return tipoValorFo;
	}

	public void setTipoValorFo(String tipoValorFo) {
		this.tipoValorFo = tipoValorFo;
	}

	public String getCveEmisorInst() {
		return cveEmisorInst;
	}

	public void setCveEmisorInst(String cveEmisorInst) {
		this.cveEmisorInst = cveEmisorInst;
	}

	public String getSerieInst() {
		return serieInst;
	}

	public void setSerieInst(String serieInst) {
		this.serieInst = serieInst;
	}

	public String getTipoValorInst() {
		return tipoValorInst;
	}

	public void setTipoValorInst(String tipoValorInst) {
		this.tipoValorInst = tipoValorInst;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public String getAfectacion() {
		return afectacion;
	}

	public void setAfectacion(String afectacion) {
		this.afectacion = afectacion;
	}

	public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	public String getParametriz() {
		return parametriz;
	}

	public void setParametriz(String parametriz) {
		this.parametriz = parametriz;
	}

	public int getConsecutivoInst() {
		return consecutivoInst;
	}

	public void setConsecutivoInst(int consecutivoInst) {
		this.consecutivoInst = consecutivoInst;
	}

	public String getDescripc() {
		return descripc;
	}

	public void setDescripc(String descripc) {
		this.descripc = descripc;
	}

	public String getLiquidez() {
		return liquidez;
	}

	public void setLiquidez(String liquidez) {
		this.liquidez = liquidez;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getFchEmiInst() {
		return fchEmiInst;
	}

	public void setFchEmiInst(String fchEmiInst) {
		this.fchEmiInst = fchEmiInst;
	}

	public int getPorcParticInst() {
		return porcParticInst;
	}

	public void setPorcParticInst(int porcParticInst) {
		this.porcParticInst = porcParticInst;
	}

	public int getCtoAdqInst() {
		return ctoAdqInst;
	}

	public void setCtoAdqInst(int ctoAdqInst) {
		this.ctoAdqInst = ctoAdqInst;
	}

	public int getValCotInst() {
		return valCotInst;
	}

	public void setValCotInst(int valCotInst) {
		this.valCotInst = valCotInst;
	}

	public int getIncDecValua() {
		return incDecValua;
	}

	public void setIncDecValua(int incDecValua) {
		this.incDecValua = incDecValua;
	}

	public String getCalif() {
		return calif;
	}

	public void setCalif(String calif) {
		this.calif = calif;
	}

	public int getMdaBase() {
		return mdaBase;
	}

	public void setMdaBase(int mdaBase) {
		this.mdaBase = mdaBase;
	}

	public String getNivelFondos() {
		return nivelFondos;
	}

	public void setNivelFondos(String nivelFondos) {
		this.nivelFondos = nivelFondos;
	}

	public String getCveEmisorFond() {
		return cveEmisorFond;
	}

	public void setCveEmisorFond(String cveEmisorFond) {
		this.cveEmisorFond = cveEmisorFond;
	}

}
