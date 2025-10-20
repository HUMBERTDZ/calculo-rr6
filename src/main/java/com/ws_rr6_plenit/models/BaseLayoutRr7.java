package com.ws_rr6_plenit.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the BASE_LAYOUT_RR7 database table.
 * 
 */
@Entity
@Table(name="BASE_LAYOUT_RR7")
@NamedQuery(name="BaseLayoutRr7.findAll", query="SELECT b FROM BaseLayoutRr7 b")
public class BaseLayoutRr7 implements Serializable {

	private static final long serialVersionUID = 7504316015532349045L;

	@Column(name="AFECTO")
	private String afecto;

	@Column(name="ANIO")
	private int anio;

	@Column(name="CTA_CAT_ANT")
	private String ctaCatAnt;

	@Column(name="CTA_QTO_NIV_NVO_CAT")
	private String ctaQtoNivNvoCat;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDX")
	private int idx;

	@Column(name="MES")
	private int mes;

	@Column(name="MONT_MON_CONSOLIDADA")
	private double montMonConsolidada;

	@Column(name="NIV_FOND_PROP_ADMI_")
	private String nivFondPropAdmi;

	@Column(name="RAMO")
	private String ramo;

	@Column(name="SUB_CTA_CAT_ANT")
	private String subCtaCatAnt;

	@Column(name="SUBRAMO")
	private String subramo;

	@Column(name="SUBSUBRAMO")
	private String subsubramo;

	@Column(name="TIPO_MONEDA")
	private int tipoMoneda;

	public BaseLayoutRr7() {
	}

	public String getAfecto() {
		return this.afecto;
	}

	public void setAfecto(String afecto) {
		this.afecto = afecto;
	}

	public int getAnio() {
		return this.anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getCtaCatAnt() {
		return this.ctaCatAnt;
	}

	public void setCtaCatAnt(String ctaCatAnt) {
		this.ctaCatAnt = ctaCatAnt;
	}

	public String getCtaQtoNivNvoCat() {
		return this.ctaQtoNivNvoCat;
	}

	public void setCtaQtoNivNvoCat(String ctaQtoNivNvoCat) {
		this.ctaQtoNivNvoCat = ctaQtoNivNvoCat;
	}

	public int getIdx() {
		return this.idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getMes() {
		return this.mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public double getMontMonConsolidada() {
		return this.montMonConsolidada;
	}

	public void setMontMonConsolidada(double montMonConsolidada) {
		this.montMonConsolidada = montMonConsolidada;
	}

	public String getNivFondPropAdmi() {
		return this.nivFondPropAdmi;
	}

	public void setNivFondPropAdmi(String nivFondPropAdmi) {
		this.nivFondPropAdmi = nivFondPropAdmi;
	}

	public String getRamo() {
		return this.ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
	}

	public String getSubCtaCatAnt() {
		return this.subCtaCatAnt;
	}

	public void setSubCtaCatAnt(String subCtaCatAnt) {
		this.subCtaCatAnt = subCtaCatAnt;
	}

	public String getSubramo() {
		return this.subramo;
	}

	public void setSubramo(String subramo) {
		this.subramo = subramo;
	}

	public String getSubsubramo() {
		return this.subsubramo;
	}

	public void setSubsubramo(String subsubramo) {
		this.subsubramo = subsubramo;
	}

	public int getTipoMoneda() {
		return this.tipoMoneda;
	}

	public void setTipoMoneda(int tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	@Override
	public String toString() {
		return "BaseLayoutRr7 [afecto=" + afecto + ", anio=" + anio + ", ctaCatAnt=" + ctaCatAnt + ", ctaQtoNivNvoCat="
				+ ctaQtoNivNvoCat + ", idx=" + idx + ", mes=" + mes + ", montMonConsolidada=" + montMonConsolidada
				+ ", nivFondPropAdmi=" + nivFondPropAdmi + ", ramo=" + ramo + ", subCtaCatAnt=" + subCtaCatAnt
				+ ", subramo=" + subramo + ", subsubramo=" + subsubramo + ", tipoMoneda=" + tipoMoneda + "]";
	}
	
	
	
}