package com.ws_rr6_safa_calculo.dto.implementations;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ws_rr6_safa_calculo.dto.ContratoDTO;
import com.ws_rr6_safa_calculo.dto.interfaces.Irr6TrivaRarnDto;
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
public class Rr6TrivaRarnDtoImpl implements Irr6TrivaRarnDto {

    final static Logger logger = LoggerFactory.getLogger(Rr6TrivaRarnDtoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    IHistoricoRyRService iHistoricoRyRService;

    String mensaje = "";
    String linea = "";
    String fechaInicio = "";
    String fechaFin = "";
    String searchKey = "";


    @Override
    public int createTablePcc() {
        //--SE VALIDA SI EXISTE LA TABLA, ELIMINA Y CREA LA TABLA PARA EL REPORTE
        String query = "IF OBJECT_ID('RR6TRIVARARNPCC') IS NOT NULL BEGIN DROP TABLE RR6TRIVARARNPCC END;";
        int execute = 0;

        try {
            jdbcTemplate.execute(query);
            logger.info(query);

            query = "	SELECT '20231231'			AS MES, 'PCC' AS CONCEPTO, '030' AS CLAVERAMO, "
                    + "	D.CLAVEREGISTRO 												AS REASEGURADORESINSCRITOS, "
                    + "	IIF( D.EXTRANJERO = 1, '', SUBSTRING(D.CLAVEREGISTRO, 1, 1) ) 	AS TIPOREASEGURADORNACIONAL, "
                    + "	IIF( D.EXTRANJERO = 1, '', D.CLAVEREGISTRO )  					AS CLAVEREASEGURADORNACIONAL, "
                    + "	'' AS REASEGURADORNOINSCRITO, SUM(A.INCREMENTOTOTALMO) 			AS PRIMACEDIDA, "
                    + "	CAST(0 AS NUMERIC (18,2)) AS COSTOCOBERTURAXL, "
                    + "	'0.00' 						AS SUMASEGTOTRAMOAUTORI, "
                    + "	'0.00' 						AS SUMASEGRETRAMOAUTORI "
                    + "	INTO RR6TRIVARARNPCC "
                    + "	FROM CALCULOEMISIONAPGM A  "
                    + "	INNER JOIN DATOSCONTRATO B ON A.IDCONTRATO = B.ID "
                    + "	INNER JOIN REASEGURADORES C ON A.IDCONTRATO = C.DATOSCONTRATO_ID "
                    + "	INNER JOIN CCREASEGURADORAS D ON C.CCREASEGURADORAS_ID = D.ID "
                    + "	GROUP BY D.CLAVEREGISTRO, "
                    + "	IIF( D.EXTRANJERO = 1, '', SUBSTRING(D.CLAVEREGISTRO, 1, 1) ), "
                    + "	IIF( D.EXTRANJERO = 1, '', D.CLAVEREGISTRO);";
            jdbcTemplate.execute(query);
            logger.info(query);

            execute = 1;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return execute;
    }

    /**
     * ACTUALIZA COSTOCOBERTURA XL
     */
    @Override
    public int updateCostoCoberturaXL() {
        String query = "";
        int execute = 0;

        try {

            query = "IF OBJECT_ID('COSTOCOBERTURAXL') IS NOT NULL BEGIN DROP TABLE COSTOCOBERTURAXL END;";
            jdbcTemplate.update(query);
            logger.info(query);

            query = "	SELECT A.PRIMACEDIDA, D.CLAVEREGISTRO "
                    + "	INTO COSTOCOBERTURAXL "
                    + " FROM AJUSTEANUALHANNOVER 	A "
                    + " INNER JOIN DATOSCONTRATO 	B ON A.IDDATOSCONTRATO = B.ID AND A.FECHAPROCESO = '2023-12-31' "
                    + "	INNER JOIN REASEGURADORES 	C ON B.ID = C.DATOSCONTRATO_ID "
                    + " INNER JOIN CCREASEGURADORAS D ON C.CCREASEGURADORAS_ID = D.ID;";
            jdbcTemplate.update(query);
            logger.info(query);

            query = "	UPDATE A SET A.COSTOCOBERTURAXL = B.PRIMACEDIDA "
                    + "	FROM RR6TRIVARARNPCC A  "
                    + "	INNER JOIN COSTOCOBERTURAXL B ON A.REASEGURADORESINSCRITOS = B.CLAVEREGISTRO";
            jdbcTemplate.update(query);
            logger.info(query);


            execute = 1;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return execute;
    }

    @Override
    public int createTableSa() {
        //--SE VALIDA SI EXISTE LA TABLA, ELIMINA Y CREA LA TABLA PARA EL REPORTE
        String query = "IF OBJECT_ID('RR6TRIVARARNSA') IS NOT NULL BEGIN DROP TABLE RR6TRIVARARNSA END;";
        int execute = 0;

        try {
            jdbcTemplate.execute(query);
            logger.info(query);

            query = "	SELECT '20231231' AS MES, 			'SA' AS CONCEPTO, '030' AS CLAVERAMO, "
                    + "	'' AS REASEGURADORESINSCRITOS, 		'' AS TIPOREASEGURADORNACIONAL, "
                    + "	'' AS CLAVEREASEGURADORNACIONAL, 	'' AS REASEGURADORNOINSCRITO, "
                    + "	'' AS PRIMACEDIDA, 					'' COSTOCOBERTURAXL, "
                    + "	CAST(SUM(A.LIMITEMAXIMORESPCONTRATO) AS NUMERIC(14,2)) AS SUMASEGTOTRAMOAUTORI, "
                    + "	SUM(A.RETENCIONIMPORTE) + SUM(PRIORIDAD) AS SUMASEGRETRAMOAUTORI "
                    + "	INTO RR6TRIVARARNSA "
                    + "	FROM  DETALLESCONTRATO A  "
                    + "	INNER JOIN REASEGURADORES C ON A.DATOSCONTRATO_ID = C.DATOSCONTRATO_ID "
                    + "	INNER JOIN CCREASEGURADORAS D ON C.CCREASEGURADORAS_ID = D.ID "
                    + "	INNER JOIN DATOSCONTRATO B ON B.ID = A.DATOSCONTRATO_ID "
                    + "	GROUP BY D.CLAVEREGISTRO;";
            jdbcTemplate.execute(query);
            logger.info(query);

            execute = 1;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return execute;
    }

    @Override
    public List<Map<String, Object>> selectPCC() {

        //DEVUELVE LA LISTA DE OBJETOS PROVENIENTES DE QUERY
        String query = "SELECT * FROM RR6TRIVARARNPCC;";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(query);
        logger.info(query);

        if ((list == null || list.isEmpty())) {
            mensaje = "NO SE ENCONTRARON REGISTROS PARA EL REPORTE  TRIMESTRAL";
            logger.info(mensaje);
        } else {
            return list;
        }
        return null;
    }

    @Override
    public List<Map<String, Object>> selectSa() {

        //DEVUELVE LA LISTA DE OBJETOS PROVENIENTES DE QUERY
        String query = "SELECT * FROM RR6TRIVARARNSA;";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(query);


        if (list == null || list.isEmpty()) {
            mensaje = "NO SE ENCONTRARON REGISTROS PARA EL REPORTE  TRIMESTRAL";
            logger.info(mensaje);
        } else {
            return list;
        }
        return null;
    }


    @Override
    public int crearArchivo(int anio, String nombre) {

        int made = 0;

        List<Map<String, Object>> listPcc = selectPCC();
        List<Map<String, Object>> listSa = selectSa();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        list.addAll(listPcc);
        list.addAll(listSa);

        ContratoDTO contratoDTO = null;
        List<ContratoDTO> listContratos = null;

        try {//MODIFICAR EL NOMBRE DEL ARCHIVO
            File ArchivoSesaValidado = new File(Report.buildPathToSave(nombre));

            if (ArchivoSesaValidado.exists()) {
                ArchivoSesaValidado.delete();
            }

            ArchivoSesaValidado.createNewFile();

            FileWriter fw = new FileWriter(ArchivoSesaValidado, true);
            BufferedWriter bw = new BufferedWriter(fw);

            if (list == null || list.isEmpty()) {
                bw.write("" + "|" + "" + "|" + "" + "|" + "" + "|" + "" + "|" + "" + "|" + "" + "|" + //7
                        0 + "|" + 0 + "|" + 0 + "|" + 0 + "|;");
                bw.newLine();
            } else {
                listContratos = new ArrayList<>();
                for (Map<String, Object> map : list) {
                    made++;
                    contratoDTO = new ContratoDTO();
                    contratoDTO.setMes(map.get("MES").toString() != null ? map.get("MES").toString() : "");
                    contratoDTO.setConcepto(map.get("CONCEPTO").toString() != null ? map.get("CONCEPTO").toString() : "");
                    contratoDTO.setClaveRamo(map.get("CLAVERAMO").toString() != null ? map.get("CLAVERAMO").toString() : "");
                    contratoDTO.setReaseguradoresInscritos(map.get("REASEGURADORESINSCRITOS").toString() != null ? map.get("REASEGURADORESINSCRITOS").toString() : "");
                    contratoDTO.setTipoReaseguradorNacional(map.get("TIPOREASEGURADORNACIONAL").toString() != null ? map.get("TIPOREASEGURADORNACIONAL").toString() : "");
                    contratoDTO.setClaveReaseguradorNacional(map.get("CLAVEREASEGURADORNACIONAL").toString() != null ? map.get("CLAVEREASEGURADORNACIONAL").toString() : "");
                    contratoDTO.setReaseguradorNoInscrito(map.get("REASEGURADORNOINSCRITO").toString() != null ? map.get("REASEGURADORNOINSCRITO").toString() : "");
                    contratoDTO.setPrimaCedida(map.get("PRIMACEDIDA").toString() != null ? map.get("PRIMACEDIDA").toString() : "");
                    contratoDTO.setCostoCoberturaXL(map.get("COSTOCOBERTURAXL").toString() != null ? map.get("COSTOCOBERTURAXL").toString() : "");
                    contratoDTO.setsATotalRamoAutorizado(map.get("SUMASEGTOTRAMOAUTORI").toString() != null ? map.get("SUMASEGTOTRAMOAUTORI").toString() : "");
                    contratoDTO.setsARetenidaRamoAutorizado(map.get("SUMASEGRETRAMOAUTORI").toString() != null ? map.get("SUMASEGRETRAMOAUTORI").toString() : "");
                    listContratos.add(contratoDTO);
                    linea = "";
                }

                for (ContratoDTO contrato : listContratos) {
                    linea =
                            contrato.getMes().concat("|") +
                                    contrato.getConcepto().concat("|") +
                                    contrato.getClaveRamo().concat("|") +
                                    contrato.getReaseguradoresInscritos().concat("|") +
                                    contrato.getTipoReaseguradorNacional().concat("|") +
                                    contrato.getClaveReaseguradorNacional().concat("|") +
                                    contrato.getReaseguradorNoInscrito().concat("|") +
                                    contrato.getPrimaCedida().concat("|") +
                                    contrato.getCostoCoberturaXL().concat("|") +
                                    contrato.getsATotalRamoAutorizado().concat("|") +
                                    contrato.getsARetenidaRamoAutorizado().concat("|;");
                    bw.write(linea);
                    bw.newLine();
                }
            }
            bw.close();
            fw.close();

            made = 1;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return made;
    }

    @Override
    public int save(int trimestre, int anio, String encodedString, String nombreArchivo, String numeroDocumento) {

        int save = 0;

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
            save = 1;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        fechas.clear();
        return save;
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
