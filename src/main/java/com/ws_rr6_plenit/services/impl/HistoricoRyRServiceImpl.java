package com.ws_rr6_plenit.services.impl;


import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ws_rr6_plenit.dao.HistoricoRyRDao;
import com.ws_rr6_plenit.models.HistoricoRyR;
import com.ws_rr6_plenit.services.interfaces.IHistoricoRyRService;
import com.ws_rr6_plenit.util.Constantes;
import com.ws_rr6_plenit.util.ResponseMessage;

@Transactional(rollbackFor = Exception.class)
@Service
public class HistoricoRyRServiceImpl implements IHistoricoRyRService{
	static final Logger logger = LoggerFactory.getLogger(HistoricoRyRServiceImpl.class);
	@Resource
	HistoricoRyRDao historicoRyRDao;

	// guardar un historico
	@Override
	public boolean save(HistoricoRyR historicoRyR) {
		try {
			historicoRyRDao.save(historicoRyR);
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return false;
		}
	}

	/**
	 * obtiene un reporte por su id
	 * @param numFile  de reporte a obtener
	 * @param fechaDesde de reporte a obtener
	 * @param fechaHasta de reporte a obtener
	 * @return
	 */
	@Override
	public ResponseMessage getRr6TrivaByNumFile(int numFile, String fechaDesde, String fechaHasta) {
        logger.info("Consultando reporte almacenado {} fechaDesde:{} fechaHasta:{}", numFile, fechaDesde, fechaHasta);

		// recuperando el reporte
	    HistoricoRyR archivoOptional = historicoRyRDao.getReporteByNumDoc( numFile, fechaDesde, fechaHasta);
	    if (archivoOptional == null) {
	    	logger.info("REPORTE NO ENCONTRADO O NULO {}", numFile);
	    	return new ResponseMessage(Constantes.BUSQUEDA_SIN_RESULTADOS, "-1", numFile);

	    } else {
	    	return new ResponseMessage(Constantes.RESPONSEMESSAGE_OK, "1", archivoOptional);
	    }
	}

	@Override
	public ResponseMessage deleteRr6TrivaById(int idArchivo, String fechaDesde, String fechaHasta) {
		int delete= 0;
		logger.info("Eliminando reporte almacenado  {}, trimestre  {}, {}.", idArchivo, fechaDesde, fechaHasta);
		try {
			historicoRyRDao.deleteReporteByNumDoc( idArchivo, fechaDesde, fechaHasta);
			delete = 1;			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		if (delete == 1) {
			 return new ResponseMessage(Constantes.ELIMINADO, "1", delete);	       
	    } else {
	        return new ResponseMessage(Constantes.BUSQUEDA_SIN_RESULTADOS, "-1", idArchivo);
	    }
	}
	
	@Override
	public ResponseEntity<ResponseMessage> getListRr6() {
		
		logger.info("consultando historico");
		try {
			return ResponseEntity.ok(new ResponseMessage(Constantes.RESPONSEMESSAGE_OK, "1", historicoRyRDao.getListRr6()));
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ResponseEntity.badRequest().body(new ResponseMessage(Constantes.RESPONSEMESSAGE_ERROR, "-1", "NO SE ENCONTRARON RESULTADOS"));
		}
		
	}
	
}

