package com.ws_rr6_plenit.dto.interfaces;

import java.util.List;
import java.util.Map;

import com.ws_rr6_plenit.util.ResponseMessage;

public interface Irr6TrivaRtreDto {
	int validTableRtre();

	int createTableRtre(int trimestre, int anio);

	List<Map<String, Object>> selectRtre();

	int crearArchivo(int anio, String nombre);

	String encriptarArchivo(String nombreArchivo);

	int save(int trimestre, int anio, String encodedString, String nombreArchivo, String numeroDocumento);

	ResponseMessage deleteRr6TrivaById(int idArchivo, int trimestre, int anio);

	ResponseMessage getRr6TrivaByNumFile(int numFile, int trimestre, int anio);
}
