package com.ws_rr6_plenit.models;
import java.io.Serializable;

public class ArchivoRespuesta implements Serializable {

	private static final long serialVersionUID = -4159056903771039605L;
	
	private String baseArchivo;
	private String nombreArchivo;
	
	public String getBaseArchivo() {
		return baseArchivo;
	}
	public void setBaseArchivo(String baseArchivo) {
		this.baseArchivo = baseArchivo;
	}
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	

}
