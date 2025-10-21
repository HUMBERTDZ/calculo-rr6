package com.ws_rr6_safa_calculo.models;
import java.io.Serializable;

public class CCArchivosRR7 implements Serializable {

	private static final long serialVersionUID = -4159056903771039605L;
	
	private int id;
	private String infoCargada;
	private String nombreSimplificado;
	private String nombreExtendido;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInfoCargada() {
		return infoCargada;
	}
	public void setInfoCargada(String infoCargada) {
		this.infoCargada = infoCargada;
	}
	public String getNombreSimplificado() {
		return nombreSimplificado;
	}
	public void setNombreSimplificado(String nombreSimplificado) {
		this.nombreSimplificado = nombreSimplificado;
	}
	public String getNombreExtendido() {
		return nombreExtendido;
	}
	public void setNombreExtendido(String nombreExtendido) {
		this.nombreExtendido = nombreExtendido;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
