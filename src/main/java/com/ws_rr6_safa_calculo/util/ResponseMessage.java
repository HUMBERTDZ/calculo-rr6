package com.ws_rr6_safa_calculo.util;

public class ResponseMessage {

    private String mensaje;
    private String detalleMensaje;
    private Object dataExtra;

    /**
     * @param mensaje
     * @param detalleMensaje
     * @param dataExtra
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
     * @param mensaje the mensaje to set
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
     * @param detalleMensaje
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
     * @param dataExtra
     */
    public void setDataExtra(Object dataExtra) {
        this.dataExtra = dataExtra;
    }
}