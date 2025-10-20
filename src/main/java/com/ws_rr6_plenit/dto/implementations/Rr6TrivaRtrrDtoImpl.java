package com.ws_rr6_plenit.dto.implementations;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ws_rr6_plenit.dto.ContratoDTO;
import com.ws_rr6_plenit.dto.interfaces.Irr6TrivaRtrrDto;
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
public class Rr6TrivaRtrrDtoImpl implements Irr6TrivaRtrrDto {

	final static Logger logger = LoggerFactory.getLogger(Rr6TrivaRtrrDtoImpl.class);

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
		String query = "IF OBJECT_ID('RR6TRIVARTRR') IS NOT NULL BEGIN DROP TABLE RR6TRIVARTRR END";
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
							" SELECT  ID, 		TIPOREASEGURO, 					NOMBRECONTRATO AS IDENTIFICADORCONTRATO, "
							+ " CASE  "
							+ "		WHEN TIPOCONTRATOS = 4 THEN 11 "
							+ "		WHEN (TIPOCONTRATOS = 6 OR TIPOCONTRATOS = 9) THEN 20 "
							+ "		WHEN TIPOCONTRATOS = 7 THEN 21 END AS TIPOCONTRATO, "
							+ " DATEPART(YEAR, 	FINVIGENCIA) AS ANIOREPORTE, 	CONCAT('0', SUBRAMO) AS CLAVENEGOCIO, "
							+ " REPLACE(CAST(INICIOVIGENCIA AS VARCHAR), '-','') AS INICIOVIGENCIA, "
							+ " '0.00' AS MONTOCOMISIONREASEGURO, "
							+ " '0.00' AS MONTOPARTICIPACIONUTILIDADES, "
							+ " CAST(0 AS NUMERIC (24,2)) AS MONTSINRECLAMRECUPPROPFACULT, "
							+ " CAST(0 AS NUMERIC (24,2)) AS MONTSINRECLAMRECUPCONTRNOPROP, "
							+ " '0.00' AS MONTINGREOPERREASEGFINANC, "
							+ " '0.00' AS OTROSINGRESOS, "
							+ " CAST(0 AS NUMERIC (24,2)) AS MONTPRIMACEDIDA, "
							+ " CAST(0 AS NUMERIC (24,2)) AS MONTCOSTOTOTCOBERCONTRATNOPROPOR, "
							+ " '0.00' AS MONTPARTICIPSALVAMENT, "
							+ " '0.00' AS INTERERECURSORETENREASEGU, "
							+ " '0.00' AS INTERDERIVREASEGFINANCI, "
							+ " CAST(0 AS NUMERIC (24,2)) AS CASTIGOCUENTASREASEGURO, "
							+ " '0.00' AS OTROSEGRESOS, "
							+ " '0.00' AS GASTOSREASEGURADOR, "
							+ " 'Sin Aclaraciones' AS ACLARACIONES "
							+ " INTO RR6TRIVARTRR "
							+ " FROM DATOSCONTRATO;";
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

	/**ACTUALIZA MONTO SINIESTRO RECLAMACIONES RECUPERADAS PROPORCIONAL FACULTATIVO*/
	@Override
	public int updateSinReclamRecupPropFacult () {
		/**Si el contrato es automático (Excedente, Cuota parte, Cuota parte-Excedente)
		 * se hará la suma de la columna “Monto Cedido MO” multiplicada cada una por el tipo de cambio correspondiente a la fecha de proceso.*/

		
		String query = "";
		int execute  = 0;

		try {
			
			query = "IF OBJECT_ID('RTRRSUMMONTOCEDIDOMO') IS NOT NULL BEGIN DROP TABLE RTRRSUMMONTOCEDIDOMO END;";			
			jdbcTemplate.update(query);
			logger.info(query);
			
			query = "SELECT B.IDDATOSCONTRATO, B.IDSINIESTROCONTABLE,  SUM(MONTOCEDIDOMO) AS SUMMONTOCEDIDOMO "
					+ "	INTO RTRRSUMMONTOCEDIDOMO "
					+ "	FROM  RR6TRIVARTRR A "
					+ "	INNER JOIN CALCULOSINIESTROAPGM B "
					+ "	ON A.ID = B.IDDATOSCONTRATO "
					+ "	WHERE LLAVE IS NOT NULL "
					+ "	GROUP BY B.IDDATOSCONTRATO, B.IDSINIESTROCONTABLE;";			
			jdbcTemplate.update(query);
			logger.info(query);
			
			query = "UPDATE A SET A.MONTSINRECLAMRECUPPROPFACULT = B.SUMMONTOCEDIDOMO "
					+ "	FROM  RR6TRIVARTRR A INNER JOIN "
					+ "	RTRRSUMMONTOCEDIDOMO B ON A.ID = B.IDDATOSCONTRATO";			
			jdbcTemplate.update(query);
			logger.info(query);
			
			
			execute  = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		return execute;
	}
	
	
	/**ACTUALIZAMOS Monto de siniestros o reclamaciones recuperados de contratos no proporcionales**/
	@Override
	public int updateMontSinReclamRecupContrNoPropor() {
		/**Si el contrato es de tipo facultativo (FACaño) o en la descripción del tipo de contrato contiene “Facultativo”
		 * se hará la suma de todos los contratos facultativos de la columna “Monto Cedido total MO” multiplicada cada una por el tipo de cambio correspondiente a la fecha de proceso.
		 * NO TENEMOS CONTRATOS FACULTATIVOS***/
		String query = "";
		int execute  = 0;
		
		/**Notas: No se contemplarán los siniestros donde no hayan tenido o no se les haya calculado Monto Cedido total.
		 * Si no hay contratos Proporcional se colocara 0.
		 * Por contrato se colocará la siguiente operación:
		 * Monto de siniestro = ∑(Monto Cedido  MO) * tipo de cambio
		 * Los proporcionales tienen 0 EN EL CAMPO tipo de reaseguro
		 * Monto de siniestros o reclamaciones recuperados de contratos no proporcionales (9):
		 * del archivo “CALCULOSINIESTROSAPGM” por LLAVE igual a NULL y después filtrar por cada identificador del contrato(1) y se obtendrá lo siguiente:
		 * Notas:No se contemplarán los siniestros donde no hayan tenido o no se les haya calculado Monto Cedido total. ES EL MISMO CAMPO UTILIZADO ANTERIORMENTE
		 * Si no hay contratos No Proporcional se colocara 0.Por contrato se colocará la siguiente operación:Monto de siniestro = ∑(Monto Cedido MO) * tipo de cambio **/
		
		try {
			
			query = "IF OBJECT_ID('RTRRSUMMONTOCEDIDOMO') IS NOT NULL BEGIN DROP TABLE RTRRSUMMONTOCEDIDOMO END;";			
			jdbcTemplate.update(query);
			logger.info(query);
			
			query = "	SELECT A.IDDATOSCONTRATO, A.IDSINIESTROCONTABLE, SUM(MONTOCEDIDOMO) AS SUMMONTOCEDIDOMO "
					+ "	INTO RTRRSUMMONTOCEDIDOMO "
					+ "	FROM CALCULOSINIESTROAPGM A "
					+ "	INNER JOIN RR6TRIVARTRR B "
					+ "	ON A.IDDATOSCONTRATO = B.ID "
					+ "	WHERE A.LLAVE IS NULL AND A.MONTOCEDIDOMO != 0 "
					+ "	GROUP BY A.IDDATOSCONTRATO, A.IDSINIESTROCONTABLE;";			
			jdbcTemplate.update(query);
			logger.info(query);
			/***Si no hay contratos No Proporcional se colocara 0.
			 * Los proporcionales tienen 0 EN EL CAMPO tipo de reaseguro**/
			query = "	UPDATE A SET A.MONTSINRECLAMRECUPCONTRNOPROP = IIF(A.TIPOREASEGURO = '0', 0, B.SUMMONTOCEDIDOMO) "
					+ "	FROM RR6TRIVARTRR A "
					+ "	INNER JOIN RTRRSUMMONTOCEDIDOMO B "
					+ "	ON A.ID = B.IDDATOSCONTRATO; ";			
			jdbcTemplate.update(query);
			logger.info(query);			
			execute  = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		return execute;
	}
	
	/**ACTUALIZAMOS Monto de prima cedida (12)**/
	@Override
	public int updateMontPrimaCedida() {
		
		String query = "";
		int execute  = 0;
		
		try {
			
			query = "IF OBJECT_ID('RRSUMINCREMENTOTOTALMO') IS NOT NULL BEGIN DROP TABLE RRSUMINCREMENTOTOTALMO END;";			
			jdbcTemplate.update(query);
			logger.info(query);
			
			query = "		SELECT NOMBRECONTRATO, IDCONTRATO, "
					+ "		SUM(INCREMENTOTOTALMO) AS SUMINCREMENTOTOTALMO "
					+ "		INTO RRSUMINCREMENTOTOTALMO "
					+ "		FROM CALCULOEMISIONAPGM "
					+ "		WHERE PRIMACEDIDAMO != 0 "
					+ "		GROUP BY NOMBRECONTRATO, IDCONTRATO;";			
			jdbcTemplate.update(query);
			logger.info(query);
		
			query = "		UPDATE A SET A.MONTPRIMACEDIDA = B.SUMINCREMENTOTOTALMO "
					+ "		FROM RR6TRIVARTRR A "
					+ "		INNER JOIN RRSUMINCREMENTOTOTALMO B "
					+ "		ON A.ID = B.IDCONTRATO AND A.IDENTIFICADORCONTRATO = B.NOMBRECONTRATO "
					+ "		AND TIPOCONTRATO = 11;";			
			jdbcTemplate.update(query);
			logger.info(query);			
			execute  = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		return execute;
	}
			
		
	
	/**ACTUALIZAMOS Monto del costo total de la cobertura de contratos no proporcionales (13):**/
	@Override
	public int updateMontCostTotalCoberContratNoProporc() {
		/*para los contratos que en su columna “Tipo de reaseguro” sean No Proporcional  = 1 se colocara lo siguiente:
		 * Los proporcionales tienen 0 EN EL CAMPO tipo de reaseguro de los archivos que se obtuvieron de primas por mes (últimos 12 meses) 
		 * de las pestañas “Ajusteanjualhannover”(este solo conserva los contratos WXL con ajuste, es decir, tipo de contrato 9) y 
		--Para los contratos automático (
		--Excedente				id = 2, 
		--Cuota parte			id = 0, 
		--Cuota parte-Excedente id = 4 == 11) 
		--WHEN TIPOCONTRATOS = 4 THEN 11
		--WHEN (TIPOCONTRATOS = 6 OR TIPOCONTRATOS = 9) THEN 20
		--WHEN TIPOCONTRATOS = 7 THEN 21
		--“ajusteanual” ( esta conserva todos los contratos no proporcionales a excepción del WXLcon ajuste) 
		--se filtrará por ramo y por “FECHAPROCESO” eso considerando la fecha de cierre y se tomará la columna “PRIMACEDIDA”.
		--Nota: si maneja moneda nacional se colocará tal cual el monto de prima mínima, 
		--si maneja una moneda distinta se tomará de referencia la moneda USD y 
		--se multiplicara por el tipo de cambio, si no se tomara UDIS se multiplicará por el tipo de cambio correspondiente.*/
		
		String query = "";
		int execute  = 0;
		
		try {
			
			query = "IF OBJECT_ID('RRPRIMACEDIDA') IS NOT NULL BEGIN DROP TABLE RRPRIMACEDIDA END;";			
			jdbcTemplate.update(query);
			logger.info(query);
			
			query = "SELECT A.ID, B.PRIMACEDIDA "
					+ "	INTO RRPRIMACEDIDA "
					+ "	FROM RR6TRIVARTRR A "
					+ "	INNER JOIN AJUSTEANUALHANNOVER B ON A.ID = B.IDDATOSCONTRATO "
					+ "	WHERE TIPOREASEGURO = 1 "
					+ "	GROUP BY A.ID, B.PRIMACEDIDA;";			
			jdbcTemplate.update(query);
			logger.info(query);
		
			query = "	UPDATE A SET A.MONTCOSTOTOTCOBERCONTRATNOPROPOR  = B.PRIMACEDIDA "
					+ "	FROM RR6TRIVARTRR A "
					+ "	INNER JOIN RRPRIMACEDIDA B ON A.ID = B.ID;";			
			jdbcTemplate.update(query);
			logger.info(query);			
			execute  = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		return execute;
	}
	
	/**ACTUALIZAMOS Castigo de cuentas de reaseguro (17)**/
	@Override
	public int updateCastigoCtasReaseguro() {
		/*se deberá tomar el cálculo de 
		--IRR_RRC  e IRR_IBNR y LA TABLA SE LLAMA IRRCASTIGO
		--Castigo de los 12 meses del año a reportar y del último mes anterior al año que se esta registrando (diciembre) y 
		--se tomará de acuerdo con el contrato que se registrando la suma del campo “Castigo MXN” 
		--Castigo de cuentas de reaseguro = ∑Castigo MXN mes n      donde n= 1,,,,,12*/
		
		String query = "";
		int execute  = 0;
		
		try {
			
			query = "IF OBJECT_ID('CASTIGOMXN') IS NOT NULL BEGIN DROP TABLE CASTIGOMXN END;";			
			jdbcTemplate.update(query);
			logger.info(query);
			
			query = "		SELECT "
					+ "		(SUM(CAST(IRRRRCMO AS numeric (14,2))) + SUM(CAST(IRRIBNRMO AS NUMERIC(14,2)))) AS CASTIGOMXN, "
					+ "		IDCONTRATO "
					+ "		INTO CASTIGOMXN "
					+ "		FROM IRRCASTIGO "
					+ "		GROUP BY IDCONTRATO;";			
			jdbcTemplate.update(query);
			logger.info(query);
		
			query = "		UPDATE A SET A.CASTIGOCUENTASREASEGURO = B.CASTIGOMXN "
					+ "		FROM RR6TRIVARTRR A "
					+ "		INNER JOIN CASTIGOMXN B ON A.ID = B.IDCONTRATO;";			
			jdbcTemplate.update(query);
			logger.info(query);			
			execute  = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		return execute;
	}		
		
	@Override
	public List<Map<String, Object>> select () {

		//DEVUELVE LA LISTA DE OBJETOS PROVENIENTES DE QUERY 		
		String query =  "SELECT * FROM RR6TRIVARTRR;";
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
						 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|" + 0 + "|;");
				bw.newLine();
			} else {
				listContratos = new ArrayList<>();				
				for (Map<String, Object> map : list) {
					contratoDTO = new ContratoDTO();				
					contratoDTO.setIdentificadorContrato(			map.get("IDENTIFICADORCONTRATO").toString() 	!= null ? map.get("IDENTIFICADORCONTRATO").toString() 		: "");
					contratoDTO.setTipoContrato(					map.get("TIPOCONTRATO").toString() 				!= null ? map.get("TIPOCONTRATO").toString() 				: "");
					contratoDTO.setAnioReporte(						map.get("ANIOREPORTE").toString() 				!= null ? map.get("ANIOREPORTE").toString() 				: "");					
					contratoDTO.setClaveNegocio(					map.get("CLAVENEGOCIO").toString() 				!= null ? map.get("CLAVENEGOCIO").toString() 				: "");
					contratoDTO.setIniciovigenciaContrato(			map.get("INICIOVIGENCIA").toString() 			!= null ? map.get("INICIOVIGENCIA").toString() 				: "");					
					contratoDTO.setMontoComisionesReasegurado(		map.get("MONTOCOMISIONREASEGURO").toString() 	!= null ? map.get("MONTOCOMISIONREASEGURO").toString() 		: "");					
					contratoDTO.setMontoParticipacionUtilidadesReaseguro(map.get("MONTOPARTICIPACIONUTILIDADES").toString() != null ? map.get("MONTOPARTICIPACIONUTILIDADES").toString()		: "");
					contratoDTO.setMontSinReclamaRecupPorcioOperFacult(map.get("MONTSINRECLAMRECUPPROPFACULT").toString() != null ? map.get("MONTSINRECLAMRECUPPROPFACULT").toString() 			: "");					
					contratoDTO.setMontSinReclamaRecupContratosNoPropor(map.get("MONTSINRECLAMRECUPCONTRNOPROP").toString() != null ? map.get("MONTSINRECLAMRECUPCONTRNOPROP").toString() 			: "");
					contratoDTO.setMontIngresosOperReasegFinanc(	map.get("MONTINGREOPERREASEGFINANC").toString() != null ? map.get("MONTINGREOPERREASEGFINANC").toString() 					: "");					
					contratoDTO.setOtrosIngresos(					map.get("OTROSINGRESOS").toString() 			!= null ? map.get("OTROSINGRESOS").toString() 								: "");					
					contratoDTO.setMontoPrimaCedida(				map.get("MONTPRIMACEDIDA").toString() 			!= null ? map.get("MONTPRIMACEDIDA").toString() 					: "");	
					contratoDTO.setMontCostTotalCobertContratNoPropor(map.get("MONTCOSTOTOTCOBERCONTRATNOPROPOR").toString() != null ? map.get("MONTCOSTOTOTCOBERCONTRATNOPROPOR").toString() 	: "");					
					contratoDTO.setMontoParticipacionSalvamentos(	map.get("MONTPARTICIPSALVAMENT").toString()		!= null ? map.get("MONTPARTICIPSALVAMENT").toString() 				: "");					
					contratoDTO.setInteresesRecursosRetenidos(		map.get("INTERERECURSORETENREASEGU").toString()		!= null ? map.get("INTERERECURSORETENREASEGU").toString() 		: "");
					contratoDTO.setInteresesDerivadosReaseguroFinanciero(map.get("INTERDERIVREASEGFINANCI").toString()		!= null ? map.get("INTERDERIVREASEGFINANCI").toString()		: "");					
					contratoDTO.setCastigoCuentasReaseguro(			map.get("CASTIGOCUENTASREASEGURO").toString()	!= null ? map.get("CASTIGOCUENTASREASEGURO").toString() 		: "");
					contratoDTO.setOtrosEgresos(					map.get("OTROSEGRESOS").toString()				!= null ? map.get("OTROSEGRESOS").toString() 					: "");					
					contratoDTO.setGastosReasegurador(				map.get("GASTOSREASEGURADOR").toString()		!= null ? map.get("GASTOSREASEGURADOR").toString()				: "");
					contratoDTO.setAclaraciones(					map.get("ACLARACIONES").toString()				!= null ? map.get("ACLARACIONES").toString()					: "");
					listContratos.add(contratoDTO);
					linea = "";
				}

				for (ContratoDTO contrato : listContratos) {
					linea = 
							contrato.getIdentificadorContrato() 			.concat("|")+ 
							contrato.getTipoContrato() 						.concat("|")+
							contrato.getAnioReporte() 						.concat("|")+							
							contrato.getClaveNegocio()  					.concat("|")+
							contrato.getIniciovigenciaContrato() 			.concat("|")+
							contrato.getMontoComisionesReasegurado()		.concat("|")+
							contrato.getMontoParticipacionUtilidadesReaseguro().concat("|")+
							contrato.getMontSinReclamaRecupPorcioOperFacult().concat("|")+
							contrato.getMontSinReclamaRecupContratosNoPropor().concat("|")+
							contrato.getMontIngresosOperReasegFinanc()		.concat("|")+
							contrato.getOtrosIngresos() 					.concat("|")+
							contrato.getMontoPrimaCedida() 					.concat("|")+
							contrato.getMontCostTotalCobertContratNoPropor().concat("|")+
							contrato.getMontoParticipacionSalvamentos() 	.concat("|")+
							contrato.getInteresesRecursosRetenidos() 		.concat("|")+
							contrato.getInteresesDerivadosReaseguroFinanciero().concat("|")+
							contrato.getCastigoCuentasReaseguro() 			.concat("|")+
							contrato.getOtrosEgresos() 						.concat("|")+
							contrato.getGastosReasegurador() 				.concat("|")+
							contrato.getAclaraciones().concat("|;") ;
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
