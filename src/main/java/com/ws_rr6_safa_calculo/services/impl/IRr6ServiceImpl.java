package com.ws_rr6_safa_calculo.services.impl;

import com.ws_rr6_safa_calculo.models.HistoricoRyR;
import com.ws_rr6_safa_calculo.services.interfaces.ICalculateTrivaService;
import com.ws_rr6_safa_calculo.util.GenericsMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ws_rr6_safa_calculo.dto.interfaces.Irr6TrivaRtreDto;
import com.ws_rr6_safa_calculo.services.interfaces.IHistoricoRyRService;
import com.ws_rr6_safa_calculo.services.interfaces.IRr6Service;
import com.ws_rr6_safa_calculo.util.ResponseMessage;

import java.util.Map;


@Transactional(rollbackFor = Exception.class)
@Service
public class IRr6ServiceImpl implements IRr6Service {
    // atributos
    private final Irr6TrivaRtreDto irr6TrivaRtreDto;
    private final IHistoricoRyRService iHistoricoRyRService;
    private final ICalculateTrivaService iCalculateTrivaService;

    // inyeccion de dependencias
    @Autowired
    public IRr6ServiceImpl(Irr6TrivaRtreDto irr6TrivaRtreDto, IHistoricoRyRService iHistoricoRyRService, ICalculateTrivaService iCalculateTrivaService) {
        this.irr6TrivaRtreDto = irr6TrivaRtreDto;
        this.iHistoricoRyRService = iHistoricoRyRService;
        this.iCalculateTrivaService = iCalculateTrivaService;
    }

    @Override
    public ResponseEntity<ResponseMessage> getRr6Triva() {
        return iHistoricoRyRService.getListRr6();
    }

    @Override
    public HistoricoRyR getRr6TrivaByNumFile(int numFile, int trimestre, int anio) {
        Map<String, String> fechas = GenericsMethods.getFechas(trimestre, anio);
        return iHistoricoRyRService.getRr6TrivaByNumFile(numFile, fechas.get("fechaInicio"), fechas.get("fechaFin"));
    }

    @Override
    public boolean deleteRr6TrivaByNumFile(int numFile, int trimestre, int anio) {
        try {
            return irr6TrivaRtreDto.deleteRr6TrivaByNumFile(numFile, trimestre, anio);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean getCalculateRTRE(int trimestre, int anio) {
        return iCalculateTrivaService.calculateRTRE(trimestre, anio);
    }

    @Override
    public boolean getCalculateRTRC(int trimestre, int anio) {
        return iCalculateTrivaService.calculateRTRC(trimestre, anio);
    }

    @Override
    public boolean getCalculateRTRF(int trimestre, int anio) {
        return iCalculateTrivaService.calculateRTRF(trimestre, anio);
    }

    @Override
    public boolean getCalculateRTRR(int trimestre, int anio) {
        return iCalculateTrivaService.calculateRTRR(trimestre, anio);
    }

    @Override
    public boolean getCalculateRTRS(int trimestre, int anio) {
        return iCalculateTrivaService.calculateRTRS(trimestre, anio);
    }

    @Override
    public boolean getCalculateRARN(int trimestre, int anio) {
        return iCalculateTrivaService.calculateRARN(trimestre, anio);
    }
}

