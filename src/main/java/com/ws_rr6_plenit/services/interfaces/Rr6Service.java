package com.ws_rr6_plenit.services.interfaces;


import com.ws_rr6_plenit.util.ResponseMessage;
import org.springframework.http.ResponseEntity;

public interface Rr6Service {

	/**
	 * Reporte RTRE
	 * @param trimestre
	 * @param anio
	 * @return
	 */
	boolean reportRtre(int trimestre, int anio);


	boolean reportRtrc(int trimestre, int anio);

	boolean reportRtrf(int trimestre, int anio);

	boolean reportRtrr(int trimestre, int anio);

	boolean reportRtrs(int trimestre, int anio);

	boolean reportRarn(int trimestre, int anio);

	//
	ResponseMessage deleteRr6TrivaById(int idArchivo, int trimestre, int anio);

	ResponseMessage getRr6TrivaByNumFile(int numFile, int trimestre, int anio);



	ResponseEntity<ResponseMessage> getRr6Triva();
	
	
	
}
