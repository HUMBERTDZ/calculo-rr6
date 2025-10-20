package com.ws_rr6_plenit.dto.implementations;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import com.ws_rr6_plenit.dto.ContratoDTO;
import com.ws_rr6_plenit.dto.interfaces.Irr6TrivaRtreDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ws_rr6_plenit.models.HistoricoRyR;
import com.ws_rr6_plenit.services.interfaces.IHistoricoRyRService;
import com.ws_rr6_plenit.util.GenericsMethods;
import com.ws_rr6_plenit.util.ResponseMessage;

@Transactional(rollbackFor = Exception.class)
@Service
public class Rr6TrivaRtreDtoImpl implements Irr6TrivaRtreDto {

	final static Logger logger = LoggerFactory.getLogger(Rr6TrivaRtreDtoImpl.class);

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
	public int validTableRtre () {
		//--SE VALIDA SI EXISTE LA TABLA, ELIMINA Y CREA LA TABLA PARA EL REPORTE RTRE		
		String query = "IF OBJECT_ID('RR6TRIVARTRE') IS NOT NULL BEGIN DROP TABLE RR6TRIVARTRE END";
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

	//--SELECCION PARA CREAR TABLA RTRE TRIMESTRAL
	@Override
	public int createTableRtre (int trimestre, int anio) {

		int execute  = 0;

		Map<String, String> fechas = GenericsMethods.getFechas(trimestre, anio);
		if (trimestre == 0 || anio == 0) {	
			mensaje ="ALGUNO DE LOS CAMPOS TRIMESTRO O AÑO NO SON VALIDOS. TRIMESTRE:" + trimestre + " AÑO:" + anio ;
			logger.info(mensaje);
		} else {
			// Iterate over all fechas, using the keySet method.			
			//System.out.println(key + " - " + fechas.get(key));
			searchKey = "fechaInicio";
			if (fechas.containsKey(searchKey))
				fechaInicio = fechas.get(searchKey);
			logger.info("Found total " + fechas.get(searchKey) + " " + searchKey);
			searchKey = "fechaFin";
			fechaFin = fechas.get(searchKey);
			logger.info("Found total " + fechas.get(searchKey) + " " + searchKey);

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
					String query = " SELECT GETDATE() AS FECHACALCULO, 	SUBRAMO AS CLAVENEGOCIO,  "
							+  " NEGOCIOSCUBIERTOS, 				1 AS CLAVEESTRATEGICA, "
							+ "  1 AS ORDENCOBERTURA, 				NOMBRECONTRATO "
							+ " INTO RR6TRIVARTRE "
							+ " FROM DATOSCONTRATO "
							+ " WHERE (INICIOVIGENCIA BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "') "
							+ " AND TIPOCONTRATOS NOT IN (1,3,5,8); ";
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
	public List<Map<String, Object>> selectRtre () {

		//DEVUELVE LA LISTA DE OBJETOS PROVENIENTES DE QUERY 		
		String query =  "SELECT * FROM RR6TRIVARTRE;";
		List<Map<String, Object>> listRtre = jdbcTemplate.queryForList(query);

		logger.info(query);
		if (listRtre == null || listRtre.isEmpty()) {
			mensaje = "NO SE ENCONTRARON REGISTROS PARA EL REPORTE RTRE TRIMESTRAL";
			logger.info(mensaje);			
		}else {			
			return listRtre;
		}
		return null;
	}	


	@Override
	public int crearArchivo (int anio, String nombre) {				

		int made = 0;

		List<Map<String, Object>> listRtre = selectRtre();		
		ContratoDTO contratoDTO = null;
		List<ContratoDTO> listContratos = null;

		try {
			File ArchivoSesaValidado = new File("D:\\FTPServer\\" + nombre);

			if (ArchivoSesaValidado.exists()) {
				ArchivoSesaValidado.delete();
			}

			ArchivoSesaValidado.createNewFile();

			FileWriter fw = new FileWriter(ArchivoSesaValidado, true);
			BufferedWriter bw = new BufferedWriter(fw);

			if (listRtre == null || listRtre.isEmpty()) {
				bw.write(0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|;");
				bw.newLine();
			} else {
				listContratos = new ArrayList<>();				
				for (Map<String, Object> map : listRtre) {
					contratoDTO = new ContratoDTO();				
					contratoDTO.setClaveNegocio(		"0" + (	map.get("CLAVENEGOCIO").toString() != null ? map.get("CLAVENEGOCIO").toString() : ""));
					contratoDTO.setNegociosCubiertos(			map.get("NEGOCIOSCUBIERTOS").toString() != null ? map.get("NEGOCIOSCUBIERTOS").toString() : "");
					contratoDTO.setClaveEstrategiaReaseguro(	map.get("CLAVEESTRATEGICA").toString() != null ? map.get("CLAVEESTRATEGICA").toString() : "");
					contratoDTO.setOrdenCobertura(			map.get("ORDENCOBERTURA").toString() != null ? map.get("ORDENCOBERTURA").toString() : "");
					contratoDTO.setIdentificadorContrato(		map.get("NOMBRECONTRATO").toString() != null ? map.get("NOMBRECONTRATO").toString() : "");
					listContratos.add(contratoDTO);
					linea = "";
				}

				for (ContratoDTO contratoRTRE : listContratos) {
					linea = 
							contratoRTRE.getClaveNegocio() 				+ "|" + 
									contratoRTRE.getNegociosCubiertos() 		+ "|" +
									contratoRTRE.getClaveEstrategiaReaseguro() 	+ "|" +
									contratoRTRE.getOrdenCobertura() 			+ "|" +
									contratoRTRE.getIdentificadorContrato()		+ "|;";
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
	public String encriptarArchivo (String nombreArchivo) {

		String rutaArchivo = "D:\\SesasPlenit\\" + nombreArchivo;
		File archivo = new File(rutaArchivo);
		byte[] input_file;
		byte[] encodedBytes;		
		String encodedString = null;

		try {
			if (archivo.exists() != true) {
				System.err.println("No existe archivo");
			}else{

				input_file = Files.readAllBytes(Paths.get(archivo.getAbsolutePath()));
				encodedBytes = Base64.getEncoder().encode(input_file);
				encodedString = new String(encodedBytes);
				logger.info("Path:"  + rutaArchivo);								
				logger.info("Base 64  " + encodedString);				
			}			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return encodedString;
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

	@Override
	public ResponseMessage getRr6TrivaByNumFile(int numFile, int trimestre, int anio) {

		getfechas(trimestre, anio);	    
		ResponseMessage respuesta = iHistoricoRyRService.getRr6TrivaByNumFile(numFile, fechaInicio, fechaFin);
		logger.info("Mensaje: " + respuesta.getMensaje() + " Detalle Mensaje:"+  respuesta.getDetalleMensaje() + " DataExtra:"+ respuesta.getDataExtra());
		return respuesta;	    
	}

	@Override
	public ResponseMessage deleteRr6TrivaById(int idArchivo, int trimestre, int anio) {
		getfechas(trimestre, anio);
		ResponseMessage repuesta = iHistoricoRyRService.deleteRr6TrivaById(idArchivo, fechaInicio, fechaFin);	    	    	
		return repuesta;	    
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
