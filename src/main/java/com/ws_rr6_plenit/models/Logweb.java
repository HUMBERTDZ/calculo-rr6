package com.ws_rr6_plenit.models;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the LOGWEB database table.
 * 
 */
@Entity
@Table(name="LOGWEB")
@NamedQuery(name="Logweb.findAll", query="SELECT a FROM Logweb a")
public class Logweb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="FECHA")
	private String fecha;

	@Column(name="USUARIO")
	private String usuario;

	@Column(name="MODULO")
	private String modulo;

	@Column(name="MOVIMENTO")
	private String movimento;
	
	@Column(name="DATOSPRELIMINARES")
	private String datosPreliminares;

	@Column(name="DATOSPOSTERIORES")
	private String datosPosteriores;

	@Column(name="TABLA_ID")
	private int tablaId;
	
	public Logweb(int id, String fecha, String usuario, String modulo, String movimento, String datosPreliminares,
			String datosPosteriores, int tablaId) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.usuario = usuario;
		this.modulo = modulo;
		this.movimento = movimento;
		this.datosPreliminares = datosPreliminares;
		this.datosPosteriores = datosPosteriores;
		this.tablaId = tablaId;
	}

	public Logweb() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public String getmovimento() {
		return movimento;
	}

	public void setmovimento(String movimento) {
		this.movimento = movimento;
	}

	public String getDatosPreliminares() {
		return datosPreliminares;
	}

	public void setDatosPreliminares(String datosPreliminares) {
		this.datosPreliminares = datosPreliminares;
	}

	public String getDatosPosteriores() {
		return datosPosteriores;
	}

	public void setDatosPosteriores(String datosPosteriores) {
		this.datosPosteriores = datosPosteriores;
	}

	public int getTablaId() {
		return tablaId;
	}

	public void setTablaId(int tablaId) {
		this.tablaId = tablaId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Logweb [id=" + id + ", fecha=" + fecha + ", usuario=" + usuario + ", modulo=" + modulo + ", movimento="
				+ movimento + ", datosPreliminares=" + datosPreliminares + ", datosPosteriores=" + datosPosteriores
				+ ", tablaId=" + tablaId + "]";
	}
	

	
	

}