package com.ws_rr6_safa_calculo.dto.interfaces;

import java.util.List;
import java.util.Map;

public interface Irr6TrivaRtreDto {
	boolean validTableRtre();

	boolean createTableRtre(int trimestre, int anio);

	List<Map<String, Object>> selectRtre();

	boolean crearArchivo(int anio, String nombre);

	boolean save(int trimestre, int anio, String encodedString, String nombreArchivo, String numeroDocumento);

	boolean deleteRr6TrivaByNumFile(int numFile, int trimestre, int anio);

}
