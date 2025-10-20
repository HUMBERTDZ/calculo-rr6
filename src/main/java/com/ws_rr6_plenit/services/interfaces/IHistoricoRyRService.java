package com.ws_rr6_plenit.services.interfaces;

import com.ws_rr6_plenit.models.HistoricoRyR;
import com.ws_rr6_plenit.util.ResponseMessage;
import org.springframework.http.ResponseEntity;

public interface IHistoricoRyRService {

	boolean save(HistoricoRyR historicoRyR);

	ResponseMessage deleteRr6TrivaById(int idArchivo, String fechaDesde, String fechaHasta);

	ResponseMessage getRr6TrivaByNumFile(int numFile, String fechaDesde, String fechaHasta);

	ResponseEntity<ResponseMessage> getListRr6();
	
	
}
