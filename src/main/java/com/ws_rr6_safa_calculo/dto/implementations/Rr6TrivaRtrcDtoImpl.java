package com.ws_rr6_safa_calculo.dto.implementations;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ws_rr6_safa_calculo.dto.ContratoDTO;
import com.ws_rr6_safa_calculo.dto.interfaces.Irr6TrivaRtrcDto;
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
public class Rr6TrivaRtrcDtoImpl implements Irr6TrivaRtrcDto {
    static final Logger logger = LoggerFactory.getLogger(Rr6TrivaRtrcDtoImpl.class);
    private String mensaje = "";
    private String linea = "";
    private String fechaInicio = "";
    private String fechaFin = "";
    private String searchKey = "";
    private final JdbcTemplate jdbcTemplate;
    private final IHistoricoRyRService iHistoricoRyRService;

    @Autowired
    public Rr6TrivaRtrcDtoImpl(JdbcTemplate jdbcTemplate, IHistoricoRyRService iHistoricoRyRService) {
        this.jdbcTemplate = jdbcTemplate;
        this.iHistoricoRyRService = iHistoricoRyRService;
    }

    @Override
    public boolean validateTable() {
        //--SE VALIDA SI EXISTE LA TABLA, ELIMINA
        String query = "IF OBJECT_ID('RR6TRIVARTRC') IS NOT NULL BEGIN DROP TABLE RR6TRIVARTRC END";

        try {
            jdbcTemplate.execute(query);
            logger.info(query);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    //--SELECCION PARA CREAR TABLA  TRIMESTRAL
    @Override
    public boolean createTable(int trimestre, int anio) {

        if (trimestre == 0 || anio == 0) {
            mensaje = "ALGUNO DE LOS CAMPOS TRIMESTRO O AÑO NO SON VALIDOS. TRIMESTRE:" + trimestre + " AÑO:" + anio;
            logger.info(mensaje);
            return false;
        }

        //EJECUTAMOS LA CREACION DE LA TABLA
        String query =
                "SELECT ID, NOMBRECONTRATO AS IDENTIFICADORCONTRATO, SUBRAMO AS CLAVENEGOCIO,"
                        + "NEGOCIOSCUBIERTOS, CVEMONEDA AS MONEDA, CAST('' AS VARCHAR(10)) AS TIPOCAPTURA, "
                        + "'ninguno' AS CAMPOSMODIFICADOS, CAST(INICIOVIGENCIA AS VARCHAR) AS  INICIOVIGENCIA, "
                        + "CAST(FINVIGENCIA AS VARCHAR) AS FINVIGENCIA, "
                        + "CASE  " + " WHEN TIPOCONTRATOS  = 4 THEN 11 "
                        + "WHEN (TIPOCONTRATOS = 6 OR TIPOCONTRATOS = 9) THEN 20 "
                        + "WHEN TIPOCONTRATOS  = 7 THEN 21 "
                        + "END AS TIPOCONTRATO, "
                        + "TIPOREASEGURO, CAST('' AS VARCHAR(10)) AS CAPASLINEASCONTRATO, "
                        + "CAST('' AS VARCHAR(10)) AS PORCIONCEDIDA, CAST('' AS VARCHAR(10)) AS RETENCIONPRIORIDAD, "
                        + "'0.00' AS RETENCIONPRIORIDADFIANZAS, CAST('' AS VARCHAR(19)) AS CAPACIDADMAXLIMRESP, "
                        + "'0.00' AS CAPACIDADMAXLIMRESPFIAN, CAST('' AS VARCHAR(30)) AS IMPORTEREINSTALACIONES, "
                        + "CAST('' AS VARCHAR(10)) AS COMISIONREASEGURORATEONLINE, PORCENTAJEPTU, "
                        + "CASE " + " WHEN OTORGAPTU = 'SI' THEN CAST(PORCENTAJEPTU AS VARCHAR) "
                        + "WHEN OTORGAPTU = 'NO' THEN 'noaplica' "
                        + "END AS PARTICIPACIONUTILIDADES, "
                        + "CAST('' AS VARCHAR(10)) AS REASEGURADORESINSCRITOS, CAST('' AS VARCHAR(10)) AS TIPOREASEGURADORNACIONAL, "
                        + "CAST('' AS VARCHAR(10)) AS CLAVEREASEGURADORNACIONAL, '' AS REASEGURADORNOINSCRITO, "
                        + "CAST('' AS VARCHAR(10)) AS PARTICIPACIONREASEGURADOR, '' AS TIPOINTERMEDIARIOUTILIZADO, "
                        + "'' AS CLAVEINTERMEDIARIOUTILIZADO, '' AS INTERMEDIARIONOAUTORIZADO, "
                        + "'' AS SUSCRIPTORFACULTADO, 'Sin Aclaraciones' AS ACLARACIONES "
                        + "INTO RR6TRIVARTRC " + "FROM DATOSCONTRATO "
                        + "WHERE (INICIOVIGENCIA BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "') " + "AND TIPOCONTRATOS NOT IN (1,3,5,8);";

        try {
            jdbcTemplate.execute(query);
            logger.info(query);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    /**
     * SOLO SE UTILIZA CUANDO SE GENERA EL PRIMER REPORTE SIN HISTORICO
     */
    @Override
    public boolean updateTipoCaptura() {
        String query = "UPDATE RR6TRIVARTRC SET TIPOCAPTURA = 1;";
        try {
            jdbcTemplate.update(query);
            logger.info(query);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Map<String, Object>> select() {
        //DEVUELVE LA LISTA DE OBJETOS PROVENIENTES DE QUERY
        String query = "SELECT * FROM RR6TRIVARTRC;";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(query);

        logger.info(query);
        if (list == null || list.isEmpty()) {
            mensaje = "NO SE ENCONTRARON REGISTROS PARA EL REPORTE  TRIMESTRAL";
            logger.info(mensaje);
            return null;
        }
        return list;
    }


    @Override
    public boolean crearArchivo(int anio, String nombre) {
        List<Map<String, Object>> list = select();
        ContratoDTO contratoDTO = null;
        List<ContratoDTO> listContratos = null;

        try {//MODIFICAR EL NOMBRE DEL ARCHIVO
            File file = new File(Report.buildPathToSave(nombre));

            if (file.exists()) {
                file.delete();
            }

            file.createNewFile();

            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            if (list == null || list.isEmpty()) {
                bw.write("" + "|" + "" + "|" + "" + "|" + "" + "|" + 0 + "|" + "" + "|" + "" + "|" +
                             "" + "|" + 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + "" + "|" + 0 + "|" +
                             0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" +
                             "" + "|" + 0 + "|" + "" + "|" + "" + "|" + "" + "|" + "" + "|" + "" + "|;");
                bw.newLine();
            } else {
                listContratos = new ArrayList<>();
                for (Map<String, Object> map : list) {
                    contratoDTO = new ContratoDTO();
                    contratoDTO.setIdentificadorContrato(map.get("IDENTIFICADORCONTRATO").toString() != null ? map.get("IDENTIFICADORCONTRATO").toString() : "");
                    contratoDTO.setClaveNegocio("0" + (map.get("CLAVENEGOCIO").toString() != null ? map.get("CLAVENEGOCIO").toString() : ""));
                    contratoDTO.setNegociosCubiertos(map.get("NEGOCIOSCUBIERTOS").toString() != null ? map.get("NEGOCIOSCUBIERTOS").toString() : "");
                    contratoDTO.setMoneda(map.get("MONEDA").toString() != null ? map.get("MONEDA").toString() : "");
                    contratoDTO.setTipoCaptura(map.get("TIPOCAPTURA").toString() != null ? map.get("TIPOCAPTURA").toString() : "");
                    contratoDTO.setCamposModificados(map.get("CAMPOSMODIFICADOS").toString() != null ? map.get("CAMPOSMODIFICADOS").toString() : "");
                    contratoDTO.setIniciovigenciaContrato(map.get("INICIOVIGENCIA").toString() != null ? map.get("INICIOVIGENCIA").toString() : "");
                    contratoDTO.setFinVigencia(map.get("FINVIGENCIA").toString() != null ? map.get("FINVIGENCIA").toString() : "");
                    contratoDTO.setTipoContrato(map.get("TIPOCONTRATO").toString() != null ? map.get("TIPOCONTRATO").toString() : "");
                    contratoDTO.setCapasLineasContrato(map.get("CAPASLINEASCONTRATO").toString() != null ? map.get("CAPASLINEASCONTRATO").toString() : "");
                    contratoDTO.setPorcionCedida(map.get("PORCIONCEDIDA").toString() != null ? map.get("PORCIONCEDIDA").toString() : "");
                    contratoDTO.setRetencionPrioridad(map.get("RETENCIONPRIORIDAD").toString() != null ? map.get("RETENCIONPRIORIDAD").toString() : "");
                    contratoDTO.setRetencionPrioridadFianzas(map.get("RETENCIONPRIORIDADFIANZAS").toString() != null ? map.get("RETENCIONPRIORIDADFIANZAS").toString() : "");
                    contratoDTO.setCapacidadMaxLimRespons(map.get("CAPACIDADMAXLIMRESP").toString() != null ? map.get("CAPACIDADMAXLIMRESP").toString() : "");
                    contratoDTO.setCapacidadMaxLimResponsFianzas(map.get("CAPACIDADMAXLIMRESPFIAN").toString() != null ? map.get("CAPACIDADMAXLIMRESPFIAN").toString() : "");
                    contratoDTO.setImporteasReinstalaciones(map.get("IMPORTEREINSTALACIONES").toString() != null ? map.get("IMPORTEREINSTALACIONES").toString() : "");
                    contratoDTO.setComisionReaseguroRateOnLine(map.get("COMISIONREASEGURORATEONLINE").toString() != null ? map.get("COMISIONREASEGURORATEONLINE").toString() : "");
                    contratoDTO.setParticipacionUtilidades(map.get("PARTICIPACIONUTILIDADES").toString() != null ? map.get("PARTICIPACIONUTILIDADES").toString() : "");
                    contratoDTO.setReaseguradoresInscritos(map.get("REASEGURADORESINSCRITOS").toString() != null ? map.get("REASEGURADORESINSCRITOS").toString() : "");
                    contratoDTO.setTipoReaseguradorNacional(map.get("TIPOREASEGURADORNACIONAL").toString() != null ? map.get("TIPOREASEGURADORNACIONAL").toString() : "");
                    contratoDTO.setClaveReaseguradorNacional(map.get("CLAVEREASEGURADORNACIONAL").toString() != null ? map.get("CLAVEREASEGURADORNACIONAL").toString() : "");
                    contratoDTO.setReaseguradorNoInscrito(map.get("REASEGURADORNOINSCRITO").toString() != null ? map.get("REASEGURADORNOINSCRITO").toString() : "");
                    contratoDTO.setParticipacionReasegurador(map.get("PARTICIPACIONREASEGURADOR").toString() != null ? map.get("PARTICIPACIONREASEGURADOR").toString() : "");
                    contratoDTO.setTipoIntermediarioUtilizado(map.get("TIPOINTERMEDIARIOUTILIZADO").toString() != null ? map.get("TIPOINTERMEDIARIOUTILIZADO").toString() : "");
                    contratoDTO.setClaveIntermediarioUtilizado(map.get("CLAVEINTERMEDIARIOUTILIZADO").toString() != null ? map.get("CLAVEINTERMEDIARIOUTILIZADO").toString() : "");
                    contratoDTO.setIntermediarioNoAutorizado(map.get("INTERMEDIARIONOAUTORIZADO").toString() != null ? map.get("INTERMEDIARIONOAUTORIZADO").toString() : "");
                    contratoDTO.setSuscriptorFacultado(map.get("SUSCRIPTORFACULTADO").toString() != null ? map.get("SUSCRIPTORFACULTADO").toString() : "");
                    contratoDTO.setAclaraciones(map.get("ACLARACIONES").toString() != null ? map.get("ACLARACIONES").toString() : "");
                    listContratos.add(contratoDTO);
                    linea = "";
                }

                for (ContratoDTO contrato : listContratos) {
                    linea = contrato.getIdentificadorContrato().concat("|") + contrato.getClaveNegocio().concat("|") + contrato.getNegociosCubiertos().concat("|") + contrato.getMoneda().concat("|") + contrato.getTipoCaptura().concat("|") + contrato.getCamposModificados().concat("|") + contrato.getIniciovigenciaContrato().concat("|") + contrato.getFinVigencia().concat("|") + contrato.getTipoContrato().concat("|") + contrato.getCapasLineasContrato().concat("|") + contrato.getPorcionCedida().concat("|") + contrato.getRetencionPrioridad().concat("|") + contrato.getRetencionPrioridadFianzas().concat("|") + contrato.getCapacidadMaxLimRespons().concat("|") + contrato.getCapacidadMaxLimResponsFianzas().concat("|") + contrato.getImporteasReinstalaciones().concat("|") + contrato.getComisionReaseguroRateOnLine().concat("|") + contrato.getParticipacionUtilidades().concat("|") + contrato.getReaseguradoresInscritos().concat("|") + contrato.getTipoReaseguradorNacional().concat("|") + contrato.getClaveReaseguradorNacional().concat("|") + contrato.getReaseguradorNoInscrito().concat("|") + contrato.getParticipacionReasegurador().concat("|") + contrato.getTipoIntermediarioUtilizado().concat("|") + contrato.getClaveIntermediarioUtilizado().concat("|") + contrato.getIntermediarioNoAutorizado().concat("|") + contrato.getSuscriptorFacultado().concat("|") + contrato.getAclaraciones().concat("|;");
                    bw.write(linea);
                    bw.newLine();
                }
            }
            bw.close();
            fw.close();

            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }


    @Override
    public boolean save(int trimestre, int anio, String encodedString, String nombreArchivo, String numeroDocumento) {
        Map<String, String> fechas = GenericsMethods.getFechas(trimestre, anio);

        searchKey = "fechaInicio";
        if (fechas.containsKey(searchKey)) fechaInicio = fechas.get(searchKey);
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
            logger.error(e.getMessage());
        }
        fechas.clear();
        return false;
    }


    //	*--ACTUALIZAMOS LOS FORMATOS PARA INICIO Y FIN DE VIGENCIA ..yyyymmdd.*//
    @Override
    public boolean updateFormatDate() {

        String query = "";

        try {
            query = "UPDATE RR6TRIVARTRC SET INICIOVIGENCIA = REPLACE(INICIOVIGENCIA, '-', '');";
            jdbcTemplate.update(query);
            logger.info(query);
            query = "UPDATE RR6TRIVARTRC SET FINVIGENCIA = REPLACE(FINVIGENCIA, '-', '');";
            jdbcTemplate.update(query);
            logger.info(query);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    //**	--ACTUALIZAMOS EL CAMPO CAPAS LINEAS DEL CONTRATO
    //	--o	Si Tipo de Reaseguro = 0 entonces Proporcional: se deberá capturar como capa “01”.**//
    @Override
    public int updateLineasContrato() {

        String query = "";
        int execute = 0;
        try {
            query = "UPDATE RR6TRIVARTRC SET CAPASLINEASCONTRATO = IIF(TIPOREASEGURO = 0, '01', '');";
            jdbcTemplate.update(query);
            logger.info(query);

            query = "UPDATE A SET " + "A.CAPASLINEASCONTRATO = '01' " + "FROM RR6TRIVARTRC A " + "INNER JOIN DETALLESCONTRATO B ON A.ID = B.DATOSCONTRATO_ID " + "WHERE A.TIPOREASEGURO = 1 AND (B.REINSTALACIONES != '' OR B.REINSTALACIONES != 0);";
            jdbcTemplate.update(query);
            logger.info(query);

            query = "UPDATE A SET " + " A.CAPASLINEASCONTRATO = C.NUMEROCAPA " + " FROM RR6TRIVARTRC A  " + " INNER JOIN DETALLESCONTRATO B ON A.ID = B.DATOSCONTRATO_ID " + " INNER JOIN CAPAS C ON A.ID = C.DATOSCONTRATO_ID " + " WHERE A.TIPOREASEGURO = 1 AND (B.REINSTALACIONES = '' OR B.REINSTALACIONES = 0);";
            jdbcTemplate.update(query);
            logger.info(query);

            execute = 1;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return execute;
    }

    /*--VAMOS A ACTUALIZAR EL CAMPO PORCION CEDIDA
 
    --•	Cuota parte (clave 11): se colocará la columna “Cesión (Porcentaje) QUE VIENE DE LA TABLA DETALLECONTRATO”.
    --•	Para el caso de todos los contratos diferentes de cuota parte se deberá capturar cero “0.00”.*/
    @Override
    public int updatePorcionCedida() {

        String query = "";
        int execute = 0;
        try {
            query = "UPDATE A SET " + "A.PORCIONCEDIDA = '0.00' " + "FROM RR6TRIVARTRC A " + "INNER JOIN DETALLESCONTRATO B ON A.ID = B.DATOSCONTRATO_ID " + "WHERE A.TIPOCONTRATO != 11";
            jdbcTemplate.update(query);
            logger.info(query);
            //	 --para un contrato QUE SI ES cuota parte con Cesión del 35% la porción cedida será “35.00”.
            query = "UPDATE A SET " + "A.PORCIONCEDIDA = CONCAT(B.CESIONPORCENTAJE, '.00') " + "FROM RR6TRIVARTRC A " + "INNER JOIN DETALLESCONTRATO B ON A.ID = B.DATOSCONTRATO_ID " + "WHERE A.TIPOCONTRATO = 11;";
            jdbcTemplate.update(query);
            logger.info(query);

            execute = 1;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return execute;
    }

    /*--Retención-prioridad (12): de la pestaña “datos_contrato” con base en la columna “Tipo de Reaseguro” y “Moneda” especificará lo siguiente:
         --Proporcionales: De la pestaña “detalles_ contrato” se tomará la columna “Retención (Importe)” y se colocará lo siguiente:
        --Retención-prioridad= (Retención Importe) * (Tipo de cambio)
        -- 	Nota: si maneja moneda nacional se colocará tal cual el monto de Retención,
        --si maneja una moneda distinta se tomará de preferencia la moneda USD y se multiplicara por el tipo de cambio,
        --si no se tomara UDIS se multiplicará por el tipo de cambio correspondiente.
        --PARA IDENTIFICAR TODOS LOS CONTRATOS PROPORCIONALES VAMOS A FILTRAR POR EL CAMPO TIPOREASEGURO QUE EN ESTE CASO CORRESPONDE A LA CLAVE CERO '0'*/
    @Override
    public int updateRetencionPrioridad() {

        String query = "";
        int execute = 0;
        try {
            query = "UPDATE A SET A.RETENCIONPRIORIDAD = IIF(A.MONEDA = 10, CAST(B.RETENCIONIMPORTE AS NUMERIC(14,2)), 0) " + "FROM RR6TRIVARTRC A " + "INNER JOIN DETALLESCONTRATO B ON A.ID = B.DATOSCONTRATO_ID AND A.TIPOREASEGURO = 0";
            jdbcTemplate.update(query);
            logger.info(query);
			/*-- No Proporcionales: De la pestaña “detalles_ contrato” se tomará la columna “Reinstalaciones” y se colocará lo siguiente:
				 --NO PROPORCIONALES EN TIPO REASEGURO ES = 1
				 --	Si Reinstalaciones <> “ ” o 0, entonces:
				 --	De la pestaña “detalles_contrato” se tomará el campo prioridad y se colocara lo siguiente:
				 --Retención-prioridad= (Prioridad) * (Tipo de cambio) */
            query = "UPDATE A SET A.RETENCIONPRIORIDAD = IIF(A.MONEDA = 10, CAST(B.PRIORIDAD AS NUMERIC(14,2)), 0) " + "FROM RR6TRIVARTRC A " + "INNER JOIN DETALLESCONTRATO B ON A.ID = B.DATOSCONTRATO_ID AND A.TIPOREASEGURO = 1 AND (B.REINSTALACIONES != '' OR B.REINSTALACIONES != 0);";
            jdbcTemplate.update(query);
            logger.info(query);
            /*Si Reinstalaciones =” “ o 0, entonces: Se aplican capas
             * De la pestaña “capas” se tomará la columna “Prioridad” correspondiente a la capa y contrato que se esté registrando y se colocará lo siguiente:
             * Retención-prioridad= (Prioridad capa n) * (Tipo de cambio)
             * Nota: si maneja moneda nacional se colocará tal cual el monto de prioridad, si maneja una moneda distinta se tomará de referencia la moneda USD y se multiplicara por el tipo de cambio, si no se tomara UDIS se multiplicará por el tipo de cambio correspondiente.*/
            query = "UPDATE A SET A.RETENCIONPRIORIDAD = IIF(A.MONEDA = 10, CAST(C.PRIORIDADCAPACIDADMINIMA AS NUMERIC(14,2)), 0) " + "FROM RR6TRIVARTRC A " + "INNER JOIN DETALLESCONTRATO B ON A.ID = B.DATOSCONTRATO_ID AND A.TIPOREASEGURO = 1 AND (B.REINSTALACIONES = '' OR B.REINSTALACIONES = 0) " + " INNER JOIN CAPAS C ON A.ID = C.DATOSCONTRATO_ID;";
            jdbcTemplate.update(query);
            logger.info(query);
            execute = 1;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return execute;
    }

    /*Capacidad Máxima-Limite de responsabilidad (14):
    de la pestaña “datos_contrato” con base a la columna “Tipo de Reaseguro” y “Moneda” especificará lo siguiente:
    CASO CONRATOS PROPORCIONALES
    PARA IDENTIFICAR TODOS LOS CONTRATOS PROPORCIONALES VAMOS A FILTRAR POR EL CAMPO TIPOREASEGURO QUE EN ESTE CASO CORRESPONDE A LA CLAVE CERO '0'
    •Proporcionales: De la pestaña “detalles del contrato” se tomará la columna “Límite Máximo resp. del contrato” y se colocará lo siguiente:
    Capacidad Máxima-Limite de responsabilidad = (Límite máximo resp. del contrato) * (Tipo de cambio)
    Nota: si maneja moneda nacional se colocará tal cual el monto de Capacidad Máxima, si maneja una moneda distinta se tomará de referencia la moneda USD y se multiplicara por el tipo de cambio, si no se tomara UDIS se multiplicará por el tipo de cambio correspondiente.*/
    @Override
    public int updateCapacMaxLimResp() {

        String query = "";
        int execute = 0;
        try {
            query = " UPDATE A SET A.CAPACIDADMAXLIMRESP = IIF(A.MONEDA = 10, CAST(B.LIMITEMAXIMORESPCONTRATO AS NUMERIC(14,2)), 0) " + " FROM RR6TRIVARTRC A  " + " INNER JOIN DETALLESCONTRATO B ON A.ID = B.DATOSCONTRATO_ID AND A.TIPOREASEGURO = 0;";
            jdbcTemplate.update(query);
            logger.info(query);
            /*		--CASO NO PROPORCIONALES TIPO REASEGURO = 1
             * 		No Proporcionales: De la pestaña “detalles_ contrato” se tomará la columna “Reinstalaciones” y se colocará lo siguiente:
             * 		Si Reinstalaciones <> “ ” o 0, entonces:
             * 		De la pestaña “detalles_contrato” se tomará el campo límite máximo resp. de contrato y se colocará lo siguiente:
             * 		Capacidad Máxima-Limite de responsabilidad = (Límite máximo resp. del contrato) * (Tipo de cambio)*/
            query = " UPDATE A SET A.CAPACIDADMAXLIMRESP = IIF(A.MONEDA = 10, CAST(B.LIMITEMAXIMORESPCONTRATO AS NUMERIC(14,2)), 0) " + " FROM RR6TRIVARTRC A  " + " INNER JOIN DETALLESCONTRATO B ON A.ID = B.DATOSCONTRATO_ID " + " AND A.TIPOREASEGURO = 1 AND (B.REINSTALACIONES != '' OR B.REINSTALACIONES != 0);";
            jdbcTemplate.update(query);
            logger.info(query);
            /*Si Reinstalaciones =” “ o 0, entonces: Se aplican capas
             *De la pestaña “capas” se tomará la columna “Capacidad” correspondiente a la capa y contrato que se esté registrando y se colocará lo siguiente:
             *Capacidad Máxima-Limite de responsabilidad = (Capacidad capa n) * (Tipo de cambio)
             *Nota: si maneja moneda nacional se colocará tal cual el monto de Limite de responsabilidad, si maneja una moneda distinta se tomará de referencia la moneda USD y se multiplicara por el tipo de cambio, si no se tomara UDIS se multiplicará por el tipo de cambio correspondiente.*/
            query = " UPDATE A SET A.CAPACIDADMAXLIMRESP = IIF(A.MONEDA = 10, CAST(C.CAPACIDADMONTOCUBRE AS NUMERIC(14,2)), 0) " + " FROM RR6TRIVARTRC A " + " INNER JOIN DETALLESCONTRATO B ON A.ID = B.DATOSCONTRATO_ID AND A.TIPOREASEGURO = 1 AND (B.REINSTALACIONES = '' OR B.REINSTALACIONES = 0) " + " INNER JOIN CAPAS C ON A.ID = C.DATOSCONTRATO_ID ;";
            jdbcTemplate.update(query);
            logger.info(query);
            execute = 1;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return execute;
    }


    /*Importe de las reinstalaciones (16):
    con base en la columna “Tipo se Reaseguro” de la pestaña “datos_contrato “se especificará lo siguiente:
    Proporcionales: en este caso no aplica por lo que se deberá colocar cero “0.00”.
    CASO CONTRATOS PROPORCIONALES
    PARA IDENTIFICAR TODOS LOS CONTRATOS PROPORCIONALES VAMOS A FILTRAR POR EL CAMPO TIPOREASEGURO QUE EN ESTE CASO CORRESPONDE A LA CLAVE CERO '0'*/
    @Override
    public int updateImporteReinstalaciones() {

        String query = "";
        int execute = 0;
        try {
            query = " UPDATE RR6TRIVARTRC SET IMPORTEREINSTALACIONES = '0.00'" + " WHERE TIPOREASEGURO = 0;";
            jdbcTemplate.update(query);
            logger.info(query);

			/*CASO NO PROPORCIONALES TIPO REASEGURO = 1
			No Proporcionales: De la pestaña “detalles_ contrato” se tomará la columna “Reinstalaciones” y se colocará lo siguiente:
			Si Reinstalaciones <> “ ” o 0, entonces:
			De la pestaña “detalles_contrato” se tomarán los campos límite máximo resp. de contrato,  Prioridad y Reinstalaciones y se colocará lo siguiente:
			Importe reinstalaciones = (Límite máximo resp. del contrato - Prioridad) * (Reinstalaciones) * (Tipo de cambio)*/

            query = " UPDATE A SET A.IMPORTEREINSTALACIONES = " + " IIF(A.MONEDA = 10, (CAST(B.LIMITEMAXIMORESPCONTRATO AS NUMERIC(14,2)) - CAST(B.PRIORIDAD AS NUMERIC(14,2))) " + " * CAST(REINSTALACIONES AS NUMERIC (14,2)) , 0) " + "FROM RR6TRIVARTRC A  " + " INNER JOIN DETALLESCONTRATO B ON A.ID = B.DATOSCONTRATO_ID " + "AND A.TIPOREASEGURO = 1 AND (B.REINSTALACIONES != '' OR B.REINSTALACIONES != 0);";
            jdbcTemplate.update(query);
            logger.info(query);
			/*CASO NO PROPORCIONALES TIPO REASEGURO = 1
			Si Reinstalaciones =” “ o 0, entonces: Se aplican capas
			De la pestaña “capas” se tomarán las columnas “Capacidad” y “Prioridad” y “Reinstalaciones” correspondiente a la capa y contrato que se esté registrando y se colocará lo siguiente: 
			Importe reinstalaciones = (Capacidad capa n- Prioridad capa n) * (Reinstalaciones capa n) * (Tipo de cambio)
			Nota: si maneja moneda nacional se colocará tal cual el monto de Limite de responsabilidad, si maneja una moneda distinta se tomará de referencia la moneda USD y se multiplicara por el tipo de cambio, si no se tomara UDIS se multiplicará por el tipo de cambio correspondiente.*/

            query = "UPDATE A SET A.IMPORTEREINSTALACIONES = " + " IIF(A.MONEDA = 10, (CAST(C.CAPACIDADMONTOCUBRE AS NUMERIC(14,2)) - CAST(C.PRIORIDADCAPACIDADMINIMA AS NUMERIC(14,2))) " + " * CAST(C.NUMEROREINSTALACIONES AS NUMERIC (14,2)) , 0) " + "FROM RR6TRIVARTRC A " + "INNER JOIN DETALLESCONTRATO B ON A.ID = B.DATOSCONTRATO_ID " + "AND A.TIPOREASEGURO = 1 AND (B.REINSTALACIONES = '' OR B.REINSTALACIONES = 0) " + "INNER JOIN CAPAS C ON A.ID = C.DATOSCONTRATO_ID;";
            jdbcTemplate.update(query);
            logger.info(query);
            execute = 1;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return execute;
    }

    /*Comisión de reaseguro-rate on line (17):
     * Con base en la columna “Tipo se Reaseguro” de la pestaña “datos_contrato “se especificará lo siguiente:
     * CASO PROPORCIONALES LLEVAN CERO 0 EN TIPO REASEGURO
     * Proporcionales: De la pestaña “detalles_contrato” se tomará la columna “% comisión de Reaseguro sobre prima cedida” y se colocará lo siguiente:
     * Comisión de reaseguro = (% comisión de Reaseguro sobre prima cedida)
     * Ejemplo: si la comisión de reaseguro es de 10% se colocará 10.00.*/
    @Override
    public int updateComisReasegRateOnLine() {

        String query = "";
        int execute = 0;
        try {

            query = " UPDATE A SET A.COMISIONREASEGURORATEONLINE = CONCAT (B.PORCENTAJECOMISIONREASEGUROSOBREPRIMACEDIDA, '.00') " + " FROM RR6TRIVARTRC A " + " INNER JOIN DETALLESCONTRATO B ON A.ID = B.DATOSCONTRATO_ID " + "AND A.TIPOREASEGURO = 0;";
            jdbcTemplate.update(query);
            logger.info(query);
            /*CONTRATOS NO PROPORCIONALES LLEVA 1 EN EL CAMPO TIPO REASEGURO
             * No Proporcionales: De la pestaña “detalles_contrato” se tomará la columna “Comisión/Rate on Line” y se colocará lo siguiente:
             * Comisión de reaseguro = (Comisión/Rate on Line)
             * Ejemplo: si la comisión es de 10% se colocará 10.00.
             * Nota: Si el campo es vacío se colocará 0.00.*/
            query = " UPDATE A SET A.COMISIONREASEGURORATEONLINE = CONCAT (B.COMISIONRATEONLINE, '.00') " + " FROM RR6TRIVARTRC A " + "INNER JOIN DETALLESCONTRATO B ON A.ID = B.DATOSCONTRATO_ID " + " AND A.TIPOREASEGURO = 1;";
            jdbcTemplate.update(query);
            logger.info(query);
            execute = 1;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return execute;
    }


    /*Para los siguientes campos se tomará la información de la pestaña “ccreaseguradoras”
    donde deberá filtrarse la columna “Clave” por todos las “CCREASEGURADORAS_ID” de la pestaña
    “reaseguradores” donde deberá filtrarse la columna “Nombre contrato” por todos los contratos obtenidos en la pestaña “datos_contrato”.
    Reaseguradores inscritos (19):
    se colocará la columna “Clave registro CNSF”. Formato: alfanumérico. Longitud máxima: 20.*/
    @Override
    public int updateReasegInscritos() {

        String query = "";
        int execute = 0;
        try {
            query = "UPDATE A SET A.REASEGURADORESINSCRITOS = D.CLAVEREGISTRO " + "FROM RR6TRIVARTRC A " + "INNER JOIN REASEGURADORES C ON A.ID = C.DATOSCONTRATO_ID " + "INNER JOIN CCREASEGURADORAS D ON C.CCREASEGURADORAS_ID = D.ID;";
            jdbcTemplate.update(query);
            logger.info(query);
            execute = 1;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return execute;
    }

    /*Tipo de reasegurador nacional (20):
    con base al campo Reaseguradores inscritos (19) se colocará lo siguiente:
    De la pestaña “CCREASEGURADORAS” se va a filtrar por Reaseguradores inscritos y se va a recuperar el valor de “Extranjero”
    Si extranjero = 1 entonces Tipo de reasegurador nacional se va a quedar vacio*/
    @Override
    public int updateTipoReasegNacional() {

        String query = "";
        int execute = 0;
        try {
            query = "UPDATE A SET A.TIPOREASEGURADORNACIONAL = '' " + "FROM RR6TRIVARTRC A  " + " INNER JOIN REASEGURADORES C ON A.ID = C.DATOSCONTRATO_ID " + "INNER JOIN CCREASEGURADORAS D ON A.REASEGURADORESINSCRITOS = D.CLAVEREGISTRO AND D.EXTRANJERO = 1;";
            jdbcTemplate.update(query);
            logger.info(query);
            /*Si extranjero = 0 entonces se va a recuperar la primera letra de Reaseguradores inscritos*/

            query = "UPDATE A SET A.TIPOREASEGURADORNACIONAL = SUBSTRING(A.REASEGURADORESINSCRITOS, 1,1) " + "FROM RR6TRIVARTRC A " + "INNER JOIN REASEGURADORES C ON A.ID = C.DATOSCONTRATO_ID " + " INNER JOIN CCREASEGURADORAS D ON A.REASEGURADORESINSCRITOS = D.CLAVEREGISTRO AND D.EXTRANJERO = 0;";
            jdbcTemplate.update(query);
            logger.info(query);

            execute = 1;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return execute;
    }

    /*Clave de reasegurador nacional (21):
        con base al campo Reaseguradores inscritos (19) se colocará lo siguiente:
        De la pestaña “CCREASEGURADORAS” se va a filtrar por Reaseguradores inscritos y se va a recuperar el valor de “Extranjero”
        Si extranjero = 1 entonces Tipo de reasegurador nacional se va a quedar vacio*/
    @Override
    public int updateClaveReasegNacional() {

        String query = "";
        int execute = 0;
        try {
            query = "UPDATE A SET A.CLAVEREASEGURADORNACIONAL = '' " + " FROM RR6TRIVARTRC A " + "INNER JOIN REASEGURADORES C ON A.ID = C.DATOSCONTRATO_ID " + "INNER JOIN CCREASEGURADORAS D ON A.REASEGURADORESINSCRITOS = D.CLAVEREGISTRO AND D.EXTRANJERO = 1;";
            jdbcTemplate.update(query);
            logger.info(query);
            /*--Si extranjero = 0 entonces se va a recuperar Reaseguradores inscritos */

            query = "UPDATE A SET A.CLAVEREASEGURADORNACIONAL = A.REASEGURADORESINSCRITOS " + "FROM RR6TRIVARTRC A" + " INNER JOIN REASEGURADORES C ON A.ID = C.DATOSCONTRATO_ID " + "INNER JOIN CCREASEGURADORAS D ON A.REASEGURADORESINSCRITOS = D.CLAVEREGISTRO AND D.EXTRANJERO = 0;";
            jdbcTemplate.update(query);
            logger.info(query);

            execute = 1;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return execute;
    }

    /*Participación del reasegurador (23):
    se tomará la columna “Participación % por contrato SE LLLAMA (PORCENTAJEPARTICIPACIONPORCONTRAT)” QUE VIENE DE LA TABLA REASEGURADORES
    y se colocará lo siguiente:
    Participación del reasegurador = Participación % por contrato * 100
    Nota: deberá capturar tantos renglones como reaseguradores participen en el negocio y deberán sumar el 100% por contrato.
    Ejemplo: si la participación del contrato es del 35% se deberá colocar “35.00”.*/
    @Override
    public int updateParticipacionReaseg() {

        String query = "";
        int execute = 0;
        try {
            query = " UPDATE A SET A.PARTICIPACIONREASEGURADOR = CAST((C.PORCENTAJEPARTICIPACIONPORCONTRATO * 100) AS VARCHAR) " + " FROM RR6TRIVARTRC A " + " INNER JOIN REASEGURADORES C ON A.ID = C.DATOSCONTRATO_ID;";
            jdbcTemplate.update(query);
            logger.info(query);
            execute = 1;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return execute;
    }


}
