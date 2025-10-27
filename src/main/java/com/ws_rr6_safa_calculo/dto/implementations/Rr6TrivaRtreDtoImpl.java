package com.ws_rr6_safa_calculo.dto.implementations;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ws_rr6_safa_calculo.dto.ContratoDTO;
import com.ws_rr6_safa_calculo.dto.interfaces.Irr6TrivaRtreDto;
import com.ws_rr6_safa_calculo.util.Report;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ws_rr6_safa_calculo.models.HistoricoRyR;
import com.ws_rr6_safa_calculo.services.interfaces.IHistoricoRyRService;
import com.ws_rr6_safa_calculo.util.GenericsMethods;

@Transactional(rollbackFor = Exception.class)
@Service
public class Rr6TrivaRtreDtoImpl implements Irr6TrivaRtreDto {
    private final JdbcTemplate jdbcTemplate;
    private final IHistoricoRyRService iHistoricoRyRService;
    final static Logger logger = LoggerFactory.getLogger(Rr6TrivaRtreDtoImpl.class);

    @Autowired
    public Rr6TrivaRtreDtoImpl(JdbcTemplate jdbcTemplate, IHistoricoRyRService iHistoricoRyRService) {
        this.jdbcTemplate = jdbcTemplate;
        this.iHistoricoRyRService = iHistoricoRyRService;
    }

    String mensaje = "";
    String linea = "";
    String fechaInicio = "";
    String fechaFin = "";
    String searchKey = "";


    @Override
    public boolean validTableRtre() {
        //--SE VALIDA SI EXISTE LA TABLA, ELIMINA Y CREA LA TABLA PARA EL REPORTE RTRE
        String query = "IF OBJECT_ID('RR6TRIVARTRE') IS NOT NULL BEGIN DROP TABLE RR6TRIVARTRE END";
        try {
            jdbcTemplate.execute(query);
            logger.info(query);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        }
    }

    //--SELECCION PARA CREAR TABLA RTRE TRIMESTRAL
    @Override
    public boolean createTableRtre(int trimestre, int anio) {
        if (trimestre == 0 || anio == 0) {
            mensaje = "ALGUNO DE LOS CAMPOS TRIMESTRO O AÑO NO SON VALIDOS. TRIMESTRE:" + trimestre + " AÑO:" + anio;
            logger.info(mensaje);
        }
        //EJECUTAMOS LA CREACION DE LA TABLA
        String query = " SELECT GETDATE() AS FECHACALCULO, 	SUBRAMO AS CLAVENEGOCIO,  "
                + " NEGOCIOSCUBIERTOS, 				1 AS CLAVEESTRATEGICA, "
                + "  1 AS ORDENCOBERTURA, 				NOMBRECONTRATO "
                + " INTO RR6TRIVARTRE "
                + " FROM DATOSCONTRATO "
                + " WHERE (INICIOVIGENCIA BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "') "
                + " AND TIPOCONTRATOS NOT IN (1,3,5,8); ";
        try {
            jdbcTemplate.execute(query);
            logger.info(query);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        }
    }

    @Override
    public List<Map<String, Object>> selectRtre() {

        // obteniendo los registros de la tabla
        String query = "SELECT * FROM RR6TRIVARTRE;";
        List<Map<String, Object>> listRtre = jdbcTemplate.queryForList(query);

        logger.info(query);
        if (listRtre == null || listRtre.isEmpty()) {
            mensaje = "NO SE ENCONTRARON REGISTROS PARA EL REPORTE RTRE TRIMESTRAL";
            logger.info(mensaje);
            return null;
        }
        return listRtre;
    }


    @Override
    public boolean crearArchivo(int anio, String nombre) {
        List<Map<String, Object>> listRtre = selectRtre();
        ContratoDTO contratoDTO = null;
        List<ContratoDTO> listContratos = null;

        try {
            File ArchivoSesaValidado = new File(Report.buildPathToSave(nombre));

            if (ArchivoSesaValidado.exists()) {
                ArchivoSesaValidado.delete();
            }

            ArchivoSesaValidado.createNewFile();

            FileWriter fw = new FileWriter(ArchivoSesaValidado, true);
            BufferedWriter bw = new BufferedWriter(fw);

            if (listRtre == null || listRtre.isEmpty()) {
                bw.write("" + "|" + "" + "|" + 0 + "|" + 0 + "|" + "" + "|;");
                bw.newLine();
            } else {
                listContratos = new ArrayList<>();
                for (Map<String, Object> map : listRtre) {
                    contratoDTO = new ContratoDTO();
                    contratoDTO.setClaveNegocio("0" + (map.get("CLAVENEGOCIO").toString() != null ? map.get("CLAVENEGOCIO").toString() : ""));
                    contratoDTO.setNegociosCubiertos(map.get("NEGOCIOSCUBIERTOS").toString() != null ? map.get("NEGOCIOSCUBIERTOS").toString() : "");
                    contratoDTO.setClaveEstrategiaReaseguro(map.get("CLAVEESTRATEGICA").toString() != null ? map.get("CLAVEESTRATEGICA").toString() : "");
                    contratoDTO.setOrdenCobertura(map.get("ORDENCOBERTURA").toString() != null ? map.get("ORDENCOBERTURA").toString() : "");
                    contratoDTO.setIdentificadorContrato(map.get("NOMBRECONTRATO").toString() != null ? map.get("NOMBRECONTRATO").toString() : "");
                    listContratos.add(contratoDTO);
                    linea = "";
                }

                for (ContratoDTO contratoRTRE : listContratos) {
                    linea =
                            contratoRTRE.getClaveNegocio() + "|" +
                                    contratoRTRE.getNegociosCubiertos() + "|" +
                                    contratoRTRE.getClaveEstrategiaReaseguro() + "|" +
                                    contratoRTRE.getOrdenCobertura() + "|" +
                                    contratoRTRE.getIdentificadorContrato() + "|;";
                    bw.write(linea);
                    bw.newLine();
                }
            }
            bw.close();
            fw.close();

            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        }
    }


    @Override
    public boolean save(int trimestre, int anio, String encodedString, String nombreArchivo, String numeroDocumento) {
        Map<String, String> fechas = GenericsMethods.getFechas(trimestre, anio);

        searchKey = "fechaInicio";
        if (fechas.containsKey(searchKey))
            fechaInicio = fechas.get(searchKey);
        searchKey = "fechaFin";
        fechaFin = fechas.get(searchKey);
        try {
            HistoricoRyR historicoRyR = new HistoricoRyR();
            historicoRyR.setFechaProceso(GenericsMethods.getDate());
            historicoRyR.setFechaDesde(fechaInicio);
            historicoRyR.setFechaHasta(fechaFin);
            historicoRyR.setContentType(nombreArchivo);
            historicoRyR.setNumeroDocumento(numeroDocumento);
            historicoRyR.setBase64(encodedString);
            historicoRyR.setMoneda("10");
            historicoRyR.setSubramo("000");
            historicoRyR.setReaseguradora(String.valueOf(trimestre));
            iHistoricoRyRService.save(historicoRyR);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    @Override
    public boolean deleteRr6TrivaByNumFile(int numFile, int trimestre, int anio) {
        getfechas(trimestre, anio);
        return iHistoricoRyRService.deleteRr6TrivaByNumFile(numFile, fechaInicio, fechaFin);
    }

    public void getfechas(int trimestre, int anio) {
        Map<String, String> fechas = GenericsMethods.getFechas(trimestre, anio);
        searchKey = "fechaInicio";
        if (fechas.containsKey(searchKey))
            fechaInicio = fechas.get(searchKey);
        searchKey = "fechaFin";
        fechaFin = fechas.get(searchKey);
    }


}
