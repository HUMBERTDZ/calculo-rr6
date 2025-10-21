package com.ws_rr6_safa_calculo.services.impl;


import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ws_rr6_safa_calculo.dao.HistoricoRyRDao;
import com.ws_rr6_safa_calculo.models.HistoricoRyR;
import com.ws_rr6_safa_calculo.services.interfaces.IHistoricoRyRService;
import com.ws_rr6_safa_calculo.util.Constantes;
import com.ws_rr6_safa_calculo.util.ResponseMessage;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service
public class HistoricoRyRServiceImpl implements IHistoricoRyRService {
    static final Logger logger = LoggerFactory.getLogger(HistoricoRyRServiceImpl.class);
    @Resource
    HistoricoRyRDao historicoRyRDao;

    @Override
    public ResponseEntity<ResponseMessage> getListRr6() {

        logger.info("consultando historico");
        try {

            List<HistoricoRyR> data = historicoRyRDao.getListRr6();

            if (data.isEmpty()) {
                return ResponseEntity.badRequest().body(new ResponseMessage(Constantes.RESPONSEMESSAGE_ERROR, "NO SE ENCONTRARON RESULTADOS", null));
            }
            return ResponseEntity.ok(new ResponseMessage(Constantes.RESPONSEMESSAGE_OK, "informacion recuperada con exito", data));

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(new ResponseMessage(Constantes.RESPONSEMESSAGE_ERROR, "NO SE ENCONTRARON RESULTADOS", null));
        }

    }

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
     *
     * @param numFile    de reporte a obtener
     * @param fechaDesde de reporte a obtener
     * @param fechaHasta de reporte a obtener
     * @return
     */
    @Override
    public HistoricoRyR getRr6TrivaByNumFile(int numFile, String fechaDesde, String fechaHasta) {
        logger.info("Consultando reporte almacenado {} fechaDesde:{} fechaHasta:{}", numFile, fechaDesde, fechaHasta);

        // recuperando el reporte
        HistoricoRyR archivoOptional = historicoRyRDao.getReporteByNumDoc(numFile, fechaDesde, fechaHasta);

        if (archivoOptional == null || archivoOptional.getNumeroDocumento() == null) {
            logger.info("REPORTE NO ENCONTRADO O NULO {}", numFile);
            return null;

        } else {
            return archivoOptional;
        }
    }

    @Override
    public boolean deleteRr6TrivaByNumFile(int numFile, String fechaDesde, String fechaHasta) {
        logger.info("Eliminando reporte almacenado  {}, trimestre  {}, {}.", numFile, fechaDesde, fechaHasta);
        try {
            historicoRyRDao.deleteReporteByNumDoc(numFile, fechaDesde, fechaHasta);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        }
    }


}

