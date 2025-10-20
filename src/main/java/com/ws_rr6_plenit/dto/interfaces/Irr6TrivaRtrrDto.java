package com.ws_rr6_plenit.dto.interfaces;

import java.util.List;
import java.util.Map;

public interface Irr6TrivaRtrrDto {

	int validateTable();

	int createTable(int trimestre, int anio);

	/**CTUALIZA MONTO SINIESTRO RECLAMACIONES RECUPERADAS PROPORCIONAL FACULTATIVO*/
	int updateSinReclamRecupPropFacult();

	List<Map<String, Object>> select();

	int crearArchivo(int anio, String nombre);

	int save(int trimestre, int anio, String encodedString, String nombreArchivo, String numeroDocumento);

	/**ACTUALIZAMOS Monto de siniestros o reclamaciones recuperados de contratos no proporcionales**/
	int updateMontSinReclamRecupContrNoPropor();

	/**ACTUALIZAMOS Monto de prima cedida (12)**/
	int updateMontPrimaCedida();

	/**ACTUALIZAMOS Monto del costo total de la cobertura de contratos no proporcionales (13):**/
	int updateMontCostTotalCoberContratNoProporc();

	/**ACTUALIZAMOS Castigo de cuentas de reaseguro (17)**/
	int updateCastigoCtasReaseguro();


	}
