package com.ws_rr6_safa_calculo.util;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Map;

public class Report {
    private static String PATH = "D:\\FTPServer\\RR6REASEGURO\\";
    private static String tipoReporte = "RR6";
    private static String producto = "TRIVA";
    private static String claveCompania = "S1015";
    private static String extencion = ".txt";

    /**
     * COnstruye el nombre del archivo en base al tipo de documento
     *
     * @param typeFile tipo de archivo
     * @return
     */
    public static String buildFileName(String typeFile, int anio, int trimestre) {
        Map<String, String> fechas = GenericsMethods.getFechas(trimestre, anio);

        return tipoReporte.concat(producto).concat(typeFile).concat(claveCompania).concat(fechas.get("fechaFin").replaceAll("-", "")).concat(extencion);
    }

    public static String buildPathToSave(String fileName) {
        return PATH.concat(producto).concat("\\").concat(fileName);
    }

    public static String encodeFileToBase64(String nombreArchivo) {
        String rutaArchivo = Report.buildPathToSave(nombreArchivo);
        File archivo = new File(rutaArchivo);
        byte[] input_file;
        byte[] encodedBytes;
        String encodedString = null;

        try {
            input_file = Files.readAllBytes(Paths.get(archivo.getAbsolutePath()));
            encodedBytes = Base64.getEncoder().encode(input_file);
            encodedString = new String(encodedBytes);
        } catch (Exception e) {
            return null;
        }
        return encodedString;
    }
}
