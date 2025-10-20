package com.ws_rr6_plenit.dto.interfaces;

import java.util.List;
import java.util.Map;

import com.ws_rr6_plenit.util.ResponseMessage;

public interface Irr6TrivaRtrcDto {


	int createTable(int trimestre, int anio);

	List<Map<String, Object>> select();

	int crearArchivo(int anio, String nombre);

	String encriptarArchivo(String nombreArchivo);

	ResponseMessage deleteRr6TrivaById(int idArchivo, int trimestre, int anio);

	ResponseMessage getRr6TrivaById(int idArchivo, int trimestre, int anio);

	int validateTable();

	int updateParticipacionReaseg();

	int updateClaveReasegNacional();

	int updateTipoReasegNacional();

	int updateComisReasegRateOnLine();

	int updateImporteReinstalaciones();

	int updateCapacMaxLimResp();

	int updateRetencionPrioridad();

	int updatePorcionCedida();

	int updateLineasContrato();

	int updateFormatDate();

	/**SOLO SE UTILIZA CUANDO SE GENERA EL PRIMER REPORTE SIN HISTORICO*/
	int updateTipoCaptura();

	int updateReasegInscritos();

	int save(int trimestre, int anio, String encodedString, String nombreArchivo, String numeroDocumento);
}
