package com.ws_rr6_plenit.util;
public class ResponseMessage {

	private String mensaje;
	private String detalleMensaje;
	private Object dataExtra;

	/**
	 * @param codigo
	 * @param mensaje
	 * @param data
	 */
	public ResponseMessage(String mensaje, String detalleMensaje, Object dataExtra) {
		super();
		this.mensaje = mensaje;
		this.detalleMensaje = detalleMensaje;
		this.dataExtra = dataExtra;
	}
	
	/**
	 * 
	 */
	public ResponseMessage() {
		super();
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje
	 *            the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	/**
	 * @return the detalleMensaje
	 */
	public String getDetalleMensaje() {
		return detalleMensaje;
	}

	/**
	 * @param mensaje
	 *            the detalleMensaje to set
	 */
	public void setDetalleMensaje(String detalleMensaje) {
		this.detalleMensaje = detalleMensaje;
	}

	/**
	 * @return the data
	 */
	public Object getDataExtra() {
		return dataExtra;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setDataExtra(Object dataExtra) {
		this.dataExtra = dataExtra;
	}
}
