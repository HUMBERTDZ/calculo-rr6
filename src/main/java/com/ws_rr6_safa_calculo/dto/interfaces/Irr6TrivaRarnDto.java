package com.ws_rr6_safa_calculo.dto.interfaces;

import java.util.List;
import java.util.Map;

public interface Irr6TrivaRarnDto {

	int crearArchivo(int anio, String nombre);

	int save(int trimestre, int anio, String encodedString, String nombreArchivo, String numeroDocumento);

	int createTablePcc();

	/**ACTUALIZA COSTOCOBERTURA XL */
	int updateCostoCoberturaXL();

	int createTableSa();

	List<Map<String, Object>> selectSa();

	List<Map<String, Object>> selectPCC();

	}
