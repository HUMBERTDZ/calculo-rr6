package com.ws_rr6_plenit.util;

public class Report {
    private static String tipoReporte = "RR6";
    private static String producto ="TRIVA";
    private static String claveCompania = "S1015";
    private static String extencion = ".txt";

    /**
     * COnstruye el nombre del archivo en base al tipo de documento
     * @param typeFile tipo de archivo
     * @return
     */
    public static String buildFileName(String typeFile){
        return tipoReporte.concat(producto).concat(typeFile).concat(claveCompania).concat(extencion);
    }
}
