package com.ws_rr6_safa_calculo.dto.interfaces;

import java.util.List;
import java.util.Map;

public interface Irr6TrivaRtrsDto {

    int validateTable();

    int createTable(int trimestre, int anio);

    List<Map<String, Object>> select();

    int crearArchivo(int anio, String nombre);

    int save(int trimestre, int anio, String encodedString, String nombreArchivo, String numeroDocumento);

}
