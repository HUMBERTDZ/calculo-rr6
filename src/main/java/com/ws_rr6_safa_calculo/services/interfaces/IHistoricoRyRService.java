package com.ws_rr6_safa_calculo.services.interfaces;

import com.ws_rr6_safa_calculo.models.HistoricoRyR;
import com.ws_rr6_safa_calculo.util.ResponseMessage;
import org.springframework.http.ResponseEntity;

public interface IHistoricoRyRService {

	ResponseEntity<ResponseMessage> getListRr6();

	boolean save(HistoricoRyR historicoRyR);

	boolean deleteRr6TrivaByNumFile(int numFile, String fechaDesde, String fechaHasta);

	HistoricoRyR getRr6TrivaByNumFile(int numFile, String fechaDesde, String fechaHasta);

}
