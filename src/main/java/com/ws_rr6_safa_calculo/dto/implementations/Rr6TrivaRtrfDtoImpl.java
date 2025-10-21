package com.ws_rr6_safa_calculo.dto.implementations;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ws_rr6_safa_calculo.dto.ContratoDTO;
import com.ws_rr6_safa_calculo.dto.interfaces.Irr6TrivaRtreDto;
import com.ws_rr6_safa_calculo.dto.interfaces.Irr6TrivaRtrfDto;
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
public class Rr6TrivaRtrfDtoImpl implements Irr6TrivaRtrfDto {

    final static Logger logger = LoggerFactory.getLogger(Rr6TrivaRtrfDtoImpl.class);

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
    public int validateTable() {
        //--SE VALIDA SI EXISTE LA TABLA, ELIMINA Y CREA LA TABLA PARA EL REPORTE
        String query = "IF OBJECT_ID('RR6TRIVARTRF') IS NOT NULL BEGIN DROP TABLE RR6TRIVARTRF END";
        int execute = 0;

        try {
            jdbcTemplate.execute(query);
            logger.info(query);
            execute = 1;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return execute;
    }

    //--SELECCION PARA CREAR TABLA  TRIMESTRAL
    @Override
    public int createTable(int trimestre, int anio) {

        int execute = 0;
        getfechas(trimestre, anio);
        //Map<String, String> fechas = GenericsMethods.getFechas(trimestre, anio);
        if (trimestre == 0 || anio == 0) {
            mensaje = "ALGUNO DE LOS CAMPOS TRIMESTRO O AÑO NO SON VALIDOS. TRIMESTRE:" + trimestre + " AÑO:" + anio;
            logger.info(mensaje);
        } else {
            getfechas(trimestre, anio);
            //EVALUAMOS FECHAS DE INICIO Y FIN DE VIGENCIA DEL TRIMESTRE
            if (fechaInicio.equals("") || fechaInicio.isEmpty()) {
                mensaje = "NO SE PUDO OBETENER LA FECHA DE INICIO DEL TRIMESTRE: " + fechaInicio;
                logger.info(mensaje);
            } else {
                if (fechaFin.equals("") || fechaFin.isEmpty()) {
                    mensaje = "NO SE PUDO OBETENER LA FECHA DE FIN DEL TRIMESTRE: " + fechaFin;
                    logger.info(mensaje);
                } else {
                    //EJECUTAMOS LA CREACION DE LA TABLA
                    String query =
                            "SELECT TOP 0"
                                    + "CAST('' AS VARCHAR(30)) AS CLAVENEGOCIO, "
                                    + "CAST('' AS VARCHAR(30)) AS NEGOCIOSCUBIERTOS, "
                                    + "CAST('' AS VARCHAR(30)) AS NOMBREASEGURADO, "
                                    + "CAST('' AS VARCHAR(30)) AS SUMAASEGURADAAFIANZADA, "
                                    + "CAST('' AS VARCHAR(30)) AS MONEDA, "
                                    + "CAST('' AS VARCHAR(30)) AS PRIMAEMITIDA, "
                                    + "CAST('' AS VARCHAR(30)) AS PRIMACEDIDAFACULTATIVA, "
                                    + "CAST('' AS VARCHAR(30)) AS PRIMACEDIDAPROPORCIONAL, "
                                    + "CAST('' AS VARCHAR(30)) AS PRIMARETENIDA, "
                                    + "CAST('' AS VARCHAR(30)) AS INICIOVIGENCIA, "
                                    + "CAST('' AS VARCHAR(30)) AS FINVIGENCIA, "
                                    + "CAST('' AS VARCHAR(30)) AS TIPOCONTRATO, "
                                    + "CAST('' AS VARCHAR(30)) AS CAPASLINEASCONTRATO, "
                                    + "CAST('' AS VARCHAR(30)) AS RETENCIONPRIORIDAD, "
                                    + "CAST('' AS VARCHAR(30)) AS RETENCIONPRIORIDADFIANZAS, "
                                    + "CAST('' AS VARCHAR(30)) AS CAPACIDADMAXLIMRESPREASEGURADOR, "
                                    + "CAST('' AS VARCHAR(30)) AS CAPACIDADMAXLIMRESPFIANZAS, "
                                    + "CAST('' AS VARCHAR(30)) AS COMISIONREASEGURORATEONLINE, "
                                    + "CAST('' AS VARCHAR(30)) AS PARTICIPACIONUTILIDADES, "
                                    + "CAST('' AS VARCHAR(30)) AS REASEGURADORESINSCRITOS, "
                                    + "CAST('' AS VARCHAR(30)) AS TIPOREASEGURADORNACIONAL, "
                                    + "CAST('' AS VARCHAR(30)) AS CLAVEREASEGURADORNACIONAL, "
                                    + "CAST('' AS VARCHAR(30)) AS REASEGURADORNOINSCRITO, "
                                    + "CAST('' AS VARCHAR(30)) AS PARTICIPACIONREASEGURADOR, "
                                    + "CAST('' AS VARCHAR(30)) AS TIPOINTERMEDIARIOUTILIZADO, "
                                    + "CAST('' AS VARCHAR(30)) AS CLAVEINTERMEDIARIOUTILIZADO, "
                                    + "CAST('' AS VARCHAR(30)) AS INTERMEDIARIONOAUTORIZADO, "
                                    + "CAST('' AS VARCHAR(30)) AS SUSCRIPTORFACULTADO, "
                                    + "CAST('' AS VARCHAR(30)) AS ACLARACIONES, "
                                    + "CAST('' AS VARCHAR(30)) AS ENTIDADES, "
                                    + "CAST('' AS VARCHAR(30)) AS MUNICIPIO, "
                                    + "CAST('' AS VARCHAR(30)) AS SECTORPUBLICOPRIVADO "
                                    + "INTO RR6TRIVARTRF "
                                    + "FROM DATOSCONTRATO; ";
                    try {
                        jdbcTemplate.execute(query);
                        logger.info(query);
                        execute = 1;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return execute;
    }

    @Override
    public List<Map<String, Object>> select() {

        //DEVUELVE LA LISTA DE OBJETOS PROVENIENTES DE QUERY
        String query = "SELECT * FROM RR6TRIVARTRF;";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(query);

        logger.info(query);
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

        List<Map<String, Object>> list = select();

        try {//MODIFICAR EL NOMBRE DEL ARCHIVO
            File ArchivoSesaValidado = new File(Report.buildPathToSave(nombre));

            if (ArchivoSesaValidado.exists()) {
                ArchivoSesaValidado.delete();
            }

            ArchivoSesaValidado.createNewFile();

            FileWriter fw = new FileWriter(ArchivoSesaValidado, true);
            BufferedWriter bw = new BufferedWriter(fw);

            if (list == null || list.isEmpty()) {
                bw.write(0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + //7
                        0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" +
                        0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" +
                        0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + //28
                        0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|;");//33
                bw.newLine();
            } else {
                List<ContratoDTO> listContratos = new ArrayList<>();
                for (Map<String, Object> map : list) {
                    ContratoDTO contratoDTO = new ContratoDTO();
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
                    linea =
                            contrato.getIdentificadorContrato().concat("|") +
                                    contrato.getClaveNegocio().concat("|") +
                                    contrato.getNegociosCubiertos().concat("|") +
                                    contrato.getMoneda().concat("|") +
                                    contrato.getTipoCaptura().concat("|") +
                                    contrato.getCamposModificados().concat("|") +
                                    contrato.getIniciovigenciaContrato().concat("|") +
                                    contrato.getFinVigencia().concat("|") +
                                    contrato.getTipoContrato().concat("|") +
                                    contrato.getCapasLineasContrato().concat("|") +
                                    contrato.getPorcionCedida().concat("|") +
                                    contrato.getRetencionPrioridad().concat("|") +
                                    contrato.getRetencionPrioridadFianzas().concat("|") +
                                    contrato.getCapacidadMaxLimRespons().concat("|") +
                                    contrato.getCapacidadMaxLimResponsFianzas().concat("|") +
                                    contrato.getImporteasReinstalaciones().concat("|") +
                                    contrato.getComisionReaseguroRateOnLine().concat("|") +
                                    contrato.getParticipacionUtilidades().concat("|") +
                                    contrato.getReaseguradoresInscritos().concat("|") +
                                    contrato.getTipoReaseguradorNacional().concat("|") +
                                    contrato.getClaveReaseguradorNacional().concat("|") +
                                    contrato.getReaseguradorNoInscrito().concat("|") +
                                    contrato.getParticipacionReasegurador().concat("|") +
                                    contrato.getTipoIntermediarioUtilizado().concat("|") +
                                    contrato.getClaveIntermediarioUtilizado().concat("|") +
                                    contrato.getIntermediarioNoAutorizado().concat("|") +
                                    contrato.getSuscriptorFacultado().concat("|") +
                                    contrato.getAclaraciones().concat("|;");
                    bw.write(linea);
                    bw.newLine();
                }
            }
            bw.close();
            fw.close();

            made = 1;
        } catch (Exception e) {
            return 0;
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
            fechas.clear();
            return save;
        }
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

