package com.ws_rr6_safa_calculo.services.impl;

import com.ws_rr6_safa_calculo.dto.interfaces.*;
import com.ws_rr6_safa_calculo.services.interfaces.ICalculateTrivaService;
import com.ws_rr6_safa_calculo.services.interfaces.IRr6Service;
import com.ws_rr6_safa_calculo.util.Report;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculateTrivaServiceImpl implements ICalculateTrivaService {
    // atributos
    static final Logger logger = LoggerFactory.getLogger(CalculateTrivaServiceImpl.class);
    private final Irr6TrivaRtreDto irr6TrivaRtreDto;
    private final Irr6TrivaRtrcDto irr6TrivaRtrcDto;
    private final Irr6TrivaRtrfDto irr6TrivaRtrfDto;
    private final Irr6TrivaRtrrDto irr6TrivaRtrrDto;
    private final Irr6TrivaRtrsDto irr6TrivaRtrsDto;
    private final Irr6TrivaRarnDto irr6TrivaRarnDto;

    // inyeccion de dependencias
    @Autowired
    public CalculateTrivaServiceImpl(Irr6TrivaRtreDto irr6TrivaRtreDto, Irr6TrivaRtrcDto irr6TrivaRtrcDto, Irr6TrivaRtrfDto irr6TrivaRtrfDto, Irr6TrivaRtrrDto irr6TrivaRtrrDto, Irr6TrivaRtrsDto irr6TrivaRtrsDto, Irr6TrivaRarnDto irr6TrivaRarnDto) {
        this.irr6TrivaRtreDto = irr6TrivaRtreDto;
        this.irr6TrivaRtrcDto = irr6TrivaRtrcDto;
        this.irr6TrivaRtrfDto = irr6TrivaRtrfDto;
        this.irr6TrivaRtrrDto = irr6TrivaRtrrDto;
        this.irr6TrivaRtrsDto = irr6TrivaRtrsDto;
        this.irr6TrivaRarnDto = irr6TrivaRarnDto;
    }

    @Override
    public boolean calculateRTRE(int trimestre, int anio, String numeroDocumento) {
        boolean reporteCreado = false;
        String nombreCompleto = Report.buildFileName("RTRE", anio, trimestre);
        try {
            irr6TrivaRtreDto.validTableRtre();
            irr6TrivaRtreDto.createTableRtre(trimestre, anio);
            irr6TrivaRtreDto.crearArchivo(anio, nombreCompleto);
            irr6TrivaRtreDto.save(trimestre, anio, Report.encodeFileToBase64(nombreCompleto), nombreCompleto, numeroDocumento);
            reporteCreado = true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return reporteCreado;
    }

    @Override
    public boolean calculateRTRC(int trimestre, int anio, String numeroDocumento) {
        boolean reporteCreado = false;
        String nombreCompleto = Report.buildFileName("RTRC", anio, trimestre);
        try {
            irr6TrivaRtrcDto.validateTable();
            irr6TrivaRtrcDto.createTable(trimestre, anio);
            irr6TrivaRtrcDto.updateTipoCaptura();
            irr6TrivaRtrcDto.updateFormatDate();
            irr6TrivaRtrcDto.updateLineasContrato();
            irr6TrivaRtrcDto.updatePorcionCedida();
            irr6TrivaRtrcDto.updateRetencionPrioridad();
            irr6TrivaRtrcDto.updateCapacMaxLimResp();
            irr6TrivaRtrcDto.updateImporteReinstalaciones();
            irr6TrivaRtrcDto.updateComisReasegRateOnLine();
            irr6TrivaRtrcDto.updateReasegInscritos();
            irr6TrivaRtrcDto.updateTipoReasegNacional();
            irr6TrivaRtrcDto.updateClaveReasegNacional();
            irr6TrivaRtrcDto.updateParticipacionReaseg();
            irr6TrivaRtrcDto.crearArchivo(anio, nombreCompleto);
            irr6TrivaRtrcDto.save(trimestre, anio, Report.encodeFileToBase64(nombreCompleto), nombreCompleto, numeroDocumento);
            reporteCreado = true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return reporteCreado;
    }

    @Override
    public boolean calculateRTRF(int trimestre, int anio, String numeroDocumento) {

        boolean reporteCreado = false;
        String nombreCompleto = Report.buildFileName("RTRF", anio, trimestre);
        try {
            irr6TrivaRtrfDto.validateTable();
            irr6TrivaRtrfDto.createTable(trimestre, anio);
            irr6TrivaRtrfDto.crearArchivo(anio, nombreCompleto);
            irr6TrivaRtrfDto.save(trimestre, anio, Report.encodeFileToBase64(nombreCompleto), nombreCompleto, numeroDocumento);
            reporteCreado = true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return reporteCreado;
    }

    @Override
    public boolean calculateRTRR(int trimestre, int anio, String numeroDocumento) {

        boolean reporteCreado = false;
        String nombreCompleto = Report.buildFileName("RTRR", anio, trimestre);
        try {
            irr6TrivaRtrrDto.validateTable();
            irr6TrivaRtrrDto.createTable(trimestre, anio);
            irr6TrivaRtrrDto.updateSinReclamRecupPropFacult();
            irr6TrivaRtrrDto.updateMontSinReclamRecupContrNoPropor();
            irr6TrivaRtrrDto.updateMontPrimaCedida();
            irr6TrivaRtrrDto.updateMontCostTotalCoberContratNoProporc();
            irr6TrivaRtrrDto.updateCastigoCtasReaseguro();
            irr6TrivaRtrrDto.crearArchivo(anio, nombreCompleto);
            irr6TrivaRtrrDto.save(trimestre, anio, Report.encodeFileToBase64(nombreCompleto), nombreCompleto, numeroDocumento);
            reporteCreado = true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return reporteCreado;
    }

    @Override
    public boolean calculateRTRS(int trimestre, int anio, String numeroDocumento) {

        boolean reporteCreado = false;
        String nombreCompleto = Report.buildFileName("RTRS", anio, trimestre);
        try {
            irr6TrivaRtrsDto.validateTable();
            irr6TrivaRtrsDto.createTable(trimestre, anio);
            irr6TrivaRtrsDto.crearArchivo(anio, nombreCompleto);
            irr6TrivaRtrsDto.save(trimestre, anio, Report.encodeFileToBase64(nombreCompleto), nombreCompleto, numeroDocumento);
            reporteCreado = true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return reporteCreado;
    }

    @Override
    public boolean calculateRARN(int trimestre, int anio, String numeroDocumento) {

        boolean reporteCreado = false;
        String nombreCompleto = Report.buildFileName("RARN", anio, trimestre);
        try {
            irr6TrivaRarnDto.createTablePcc();
            irr6TrivaRarnDto.updateCostoCoberturaXL();
            irr6TrivaRarnDto.createTableSa();
            irr6TrivaRarnDto.crearArchivo(anio, nombreCompleto);
            irr6TrivaRarnDto.save(trimestre, anio, Report.encodeFileToBase64(nombreCompleto), nombreCompleto, numeroDocumento);
            reporteCreado = true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return reporteCreado;
    }
}
