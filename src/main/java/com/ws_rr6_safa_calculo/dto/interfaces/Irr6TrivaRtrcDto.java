package com.ws_rr6_safa_calculo.dto.interfaces;

import java.util.List;
import java.util.Map;

public interface Irr6TrivaRtrcDto {


	boolean createTable(int trimestre, int anio);

	List<Map<String, Object>> select();

	boolean crearArchivo(int anio, String nombre);

	boolean validateTable();

	int updateParticipacionReaseg();

	int updateClaveReasegNacional();

	int updateTipoReasegNacional();

	int updateComisReasegRateOnLine();

	int updateImporteReinstalaciones();

	int updateCapacMaxLimResp();

	int updateRetencionPrioridad();

	int updatePorcionCedida();

	int updateLineasContrato();

	boolean updateFormatDate();

	/**
	 * SOLO SE UTILIZA CUANDO SE GENERA EL PRIMER REPORTE SIN HISTORICO
	 */
	boolean updateTipoCaptura();

	int updateReasegInscritos();

	boolean save(int trimestre, int anio, String encodedString, String nombreArchivo, String numeroDocumento);
}
