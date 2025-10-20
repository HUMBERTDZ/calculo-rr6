package com.ws_rr6_plenit.dto.implementations;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ws_rr6_plenit.dto.ContratoDTO;
import com.ws_rr6_plenit.dto.interfaces.Irr6TrivaRtrsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ws_rr6_plenit.models.HistoricoRyR;
import com.ws_rr6_plenit.services.interfaces.IHistoricoRyRService;
import com.ws_rr6_plenit.util.GenericsMethods;

@Transactional(rollbackFor = Exception.class)
@Service
public class Rr6TrivaRtrsDtoImpl implements Irr6TrivaRtrsDto {

	final static Logger logger = LoggerFactory.getLogger(Rr6TrivaRtrsDtoImpl.class);

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
	public int validateTable () {
		//--SE VALIDA SI EXISTE LA TABLA, ELIMINA Y CREA LA TABLA PARA EL REPORTE 		
		String query = "IF OBJECT_ID('SELECTRR6TRIVARTRS') IS NOT NULL BEGIN DROP TABLE SELECTRR6TRIVARTRS END;";
		int execute  = 0;

		try {
			jdbcTemplate.execute(query);
			logger.info(query);
			execute  = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		return execute;
	}

	//--SELECCION PARA CREAR TABLA  TRIMESTRAL	
	@Override
	public int createTable (int trimestre, int anio) {

		int execute  = 0;

		Map<String, String> fechas = GenericsMethods.getFechas(trimestre, anio);
		if (trimestre == 0 || anio == 0) {	
			mensaje ="ALGUNO DE LOS CAMPOS TRIMESTRO O AÑO NO SON VALIDOS. TRIMESTRE:" + trimestre + " AÑO:" + anio ;
			logger.info(mensaje);
		} else {
			getfechas(trimestre, anio);
			//EVALUAMOS FECHAS DE INICIO Y FIN DE VIGENCIA DEL TRIMESTRE
			if (fechaInicio.equals("") || fechaInicio.isEmpty()) {
				mensaje ="NO SE PUDO OBETENER LA FECHA DE INICIO DEL TRIMESTRE: " + fechaInicio;
				logger.info(mensaje);
			} else {
				if (fechaFin.equals("") || fechaFin.isEmpty()) {
					mensaje ="NO SE PUDO OBETENER LA FECHA DE FIN DEL TRIMESTRE: " + fechaFin;
					logger.info(mensaje);
				} else {
					//EJECUTAMOS LA CREACION DE LA TABLA
					String query = 
							"	SELECT TOP 20  "
							+ " 0 AS CONSECUTIVO, "
							+ " B.NUMEROSINIESTRO, "
							+ " B.SUBRAMO 										AS CLAVENEGOCIO, "
							+ " B.DESCRIPCIONCAUSASINIESTRO 					AS EVENTOSINIESTRORELCAMACION, "
							+ " B.NOMBREASEGURADO 								AS ASEGURADOAFIANZADO, "
							+ " REPLACE(CAST(B.FECHAREPORTERECLAMACION AS VARCHAR), '-','') 	AS FECHASINIESTRORECLAMACION, "
							+ " (B.MONTORECLAMACIONMXN + B.MONTOPAGADORECLAMACIONMXN) 		AS IMPORTESINIESTRORECLAMACION, "
							+ " B.MONTORECUPERADOREASEGURO 									AS IMPORTERECUPERADOSINIESTRO, "
							+ " E.CLAVEREGISTRO 												AS REASEGURADORESINSCRITOS, "
							+ " IIF(E.EXTRANJERO = 1, '', SUBSTRING(E.CLAVEREGISTRO, 1, 1)) 	AS TIPOREASEGURADORNACIONAL, "
							+ " IIF(E.EXTRANJERO = 1, '', E.CLAVEREGISTRO) 					AS CLAVEREASEGURADORNACIONAL, "
							+ " '' AS REASEGURADORNOINSCRITO, "
							+ " C.TIPOREASEGURO, "
							+ " IIF(C.TIPOREASEGURO = 0, (B.MONTORECLAMACIONMXN + B.MONTOPAGADORECLAMACIONMXN), '0.00') AS IMPORTEPROPORCIONAL, "
							+ " IIF(C.TIPOREASEGURO = 0, '0.00', (B.MONTORECLAMACIONMXN + B.MONTOPAGADORECLAMACIONMXN)) AS IMPORTENOPROPORCIONAL, "
							+ " CASE "
							+ "	WHEN C.TIPOCONTRATOS = 1 THEN (B.MONTORECLAMACIONMXN + B.MONTOPAGADORECLAMACIONMXN) "
							+ "	WHEN C.TIPOCONTRATOS = 3 THEN (B.MONTORECLAMACIONMXN + B.MONTOPAGADORECLAMACIONMXN) "
							+ "	WHEN C.TIPOCONTRATOS = 5 THEN (B.MONTORECLAMACIONMXN + B.MONTOPAGADORECLAMACIONMXN) "
							+ "	WHEN C.TIPOCONTRATOS = 8 THEN (B.MONTORECLAMACIONMXN + B.MONTOPAGADORECLAMACIONMXN) "
							+ "	ELSE '0.00' END 		AS IMPORTFACULTATIVO, "
							+ " B.CLAVEENTIDAD 			AS ENTIDADES, "
							+ " B.MUNICIPIO 				AS MUNICIPIO, "
							+ " 1 						AS SECTORPUBLICOPRIVADO	"
							+ " INTO SELECTRR6TRIVARTRS "
							+ " FROM CALCULOSINIESTROAPGM A  "
							+ " INNER JOIN SINIESTROCONTABLE B ON A.IDSINIESTROCONTABLE = B.ID "
							+ " AND B.FECHAREPORTERECLAMACION BETWEEN '2023-10-01' AND '2023-12-31' "
							+ " AND B.ESTATUSRECLAMACION IN (1,2) "
							+ " INNER JOIN DATOSCONTRATO C ON A.NOMBRECONTRATO = C.ALIAS "
							+ " INNER JOIN  REASEGURADORES D ON C.ID = D.DATOSCONTRATO_ID "
							+ " INNER JOIN CCREASEGURADORAS E ON D.CCREASEGURADORAS_ID = E.ID "
							+ " ORDER BY B.MONTOPAGADORECLAMACIONMXN DESC;";
					try {
						jdbcTemplate.execute(query);
						logger.info(query);
						execute  = 1;
					} catch (Exception e) {
						e.printStackTrace();						
					}
				}
			}		
			// Clear all values.
			fechas.clear();
			// Equals to zero.
			logger.info("After clear operation, size: " + fechas.size());

		}

		return execute;
	}	
		
	@Override
	public List<Map<String, Object>> select () {

		//DEVUELVE LA LISTA DE OBJETOS PROVENIENTES DE QUERY 		
		String query =  "SELECT * FROM SELECTRR6TRIVARTRS;";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(query);

		logger.info(query);
		if (list == null || list.isEmpty()) {
			mensaje = "NO SE ENCONTRARON REGISTROS PARA EL REPORTE  TRIMESTRAL";
			logger.info(mensaje);			
		}else {			
			return list;
		}
		return null;
	}	


	@Override
	public int crearArchivo (int anio, String nombre) {				

		int made = 0;

		List<Map<String, Object>> list = select();		
		ContratoDTO contratoDTO = null;
		List<ContratoDTO> listContratos = null;

		try {//MODIFICAR EL NOMBRE DEL ARCHIVO
			File ArchivoSesaValidado = new File("D:\\SesasPlenit\\" + nombre);

			if (ArchivoSesaValidado.exists()) {
				ArchivoSesaValidado.delete();
			}

			ArchivoSesaValidado.createNewFile();

			FileWriter fw = new FileWriter(ArchivoSesaValidado, true);
			BufferedWriter bw = new BufferedWriter(fw);

			if (list == null || list.isEmpty()) {
				bw.write(0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + //7
						 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" +						 
						 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|;");
				bw.newLine();
			} else {
				listContratos = new ArrayList<>();				
				for (Map<String, Object> map : list) {
					made++;
					contratoDTO = new ContratoDTO();
					contratoDTO.setNumeroConsecutivo("" + made);
					contratoDTO.setNumeroSiniestro(			       	map.get("NUMEROSINIESTRO").toString() 			!= null ? map.get("NUMEROSINIESTRO").toString() 			: "");
					contratoDTO.setClaveNegocio(					map.get("CLAVENEGOCIO").toString() 				!= null ? map.get("CLAVENEGOCIO").toString() 				: "");
					contratoDTO.setEventoSiniestroReclamacion(		map.get("EVENTOSINIESTRORELCAMACION").toString()!= null ? map.get("EVENTOSINIESTRORELCAMACION").toString() 	: "");
					contratoDTO.setAseguradoAfianzado(		      	map.get("ASEGURADOAFIANZADO").toString() 		!= null ? map.get("ASEGURADOAFIANZADO").toString() 			: "");
					contratoDTO.setFechaSiniestroReclamacion(  		map.get("FECHASINIESTRORECLAMACION").toString() != null ? map.get("FECHASINIESTRORECLAMACION").toString() 	: "");
					contratoDTO.setImporteSiniestroReclamacion(		map.get("IMPORTESINIESTRORECLAMACION").toString()!= null ? map.get("IMPORTESINIESTRORECLAMACION").toString(): "");
					contratoDTO.setImporteRecuperadoSiniestros(		map.get("IMPORTERECUPERADOSINIESTRO").toString() != null ? map.get("IMPORTERECUPERADOSINIESTRO").toString() : "");					
					contratoDTO.setReaseguradoresInscritos(			map.get("REASEGURADORESINSCRITOS").toString() 	!= null ? map.get("REASEGURADORESINSCRITOS").toString()		: "");
					contratoDTO.setTipoReaseguradorNacional(		map.get("TIPOREASEGURADORNACIONAL").toString() 	!= null ? map.get("TIPOREASEGURADORNACIONAL").toString() 	: "");					
					contratoDTO.setClaveReaseguradorNacional(		map.get("CLAVEREASEGURADORNACIONAL").toString() != null ? map.get("CLAVEREASEGURADORNACIONAL").toString() 	: "");					
					contratoDTO.setReaseguradorNoInscrito(			map.get("REASEGURADORNOINSCRITO").toString() 	!= null ? map.get("REASEGURADORNOINSCRITO").toString() 		: "");
					contratoDTO.setImporteProporcional(				map.get("IMPORTEPROPORCIONAL").toString() 		!= null ? map.get("IMPORTEPROPORCIONAL").toString() 		: "");					
					contratoDTO.setImporteNoProporcional(           map.get("IMPORTENOPROPORCIONAL").toString() 	!= null ? map.get("IMPORTENOPROPORCIONAL").toString() 		: "");	
					contratoDTO.setImporteFacultativo(				map.get("IMPORTFACULTATIVO").toString() 		!= null ? map.get("IMPORTFACULTATIVO").toString() 			: "");					
					contratoDTO.setEntidades(						map.get("ENTIDADES").toString()					!= null ? map.get("ENTIDADES").toString() 					: "");					
					contratoDTO.setMunicipio(						map.get("MUNICIPIO").toString()					!= null ? map.get("MUNICIPIO").toString() 					: "");
					contratoDTO.setSectorPrivadoPublico(			map.get("SECTORPUBLICOPRIVADO").toString()		!= null ? map.get("SECTORPUBLICOPRIVADO").toString()		: "");			
					listContratos.add(contratoDTO);
					linea = "";
				}

				for (ContratoDTO contrato : listContratos) {
					linea = 
							contrato.getNumeroConsecutivo() 			.concat("|")+ 
							contrato.getNumeroSiniestro() 				.concat("|")+														
							contrato.getClaveNegocio()  				.concat("|")+
							contrato.getEventoSiniestroReclamacion() 	.concat("|")+
							contrato.getAseguradoAfianzado()			.concat("|")+
							contrato.getFechaSiniestroReclamacion()		.concat("|")+
							contrato.getImporteSiniestroReclamacion()	.concat("|")+
							contrato.getImporteRecuperadoSiniestros()	.concat("|")+
							contrato.getReaseguradoresInscritos()		.concat("|")+
							contrato.getTipoReaseguradorNacional() 		.concat("|")+
							contrato.getClaveReaseguradorNacional() 	.concat("|")+
							contrato.getReaseguradorNoInscrito()		.concat("|")+
							contrato.getImporteProporcional() 			.concat("|")+
							contrato.getImporteNoProporcional() 		.concat("|")+
							contrato.getImporteFacultativo()			.concat("|")+
							contrato.getEntidades() 					.concat("|")+
							contrato.getMunicipio() 					.concat("|")+
							contrato.getSectorPrivadoPublico() 			.concat("|;") ;
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
	public int save (int trimestre, int anio, String encodedString, String nombreArchivo, String numeroDocumento) {

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



	public void getfechas (int trimestre, int anio){
		Map<String, String> fechas = GenericsMethods.getFechas(trimestre, anio);
		searchKey = "fechaInicio";
		if (fechas.containsKey(searchKey))
			fechaInicio = fechas.get(searchKey);		
		searchKey = "fechaFin";
		fechaFin = fechas.get(searchKey);
	}

	
	

}
