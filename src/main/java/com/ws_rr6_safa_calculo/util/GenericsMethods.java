package com.ws_rr6_safa_calculo.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenericsMethods {

	/**
	 * @param month integer value of month
	 * @param year integer value of month
	 * @return last day of month in MM/dd/YYYY format
	 */

	static DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	static Calendar calendar = Calendar.getInstance();

	final static Logger logger = LoggerFactory.getLogger(GenericsMethods.class);

	public static String getLastDaytoMonth(int month, int year) {		
		// passing month-1 because 0-->jan, 1-->feb... 11-->dec
		calendar.set(year, month - 1, 1);
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));		
		Date date = calendar.getTime();		
		return DATE_FORMAT.format(date);
	}

	public static Map<String, String> getFechas (int trimestre, int anio) {

		int mesFin = 0;
		String fechaInicio = "";
		String fechaFin = "";		

		Map<String, String> fechas = new HashMap<>();

		if (trimestre != 0 && anio != 0) {
			//ASIGNAMOS PARAMETROS
			switch (trimestre) {
			case 1:			
				mesFin = 3;
				fechaInicio = anio + "-01-01";			
				fechaFin = getLastDaytoMonth(mesFin, anio);			
				break;
			case 2:
				mesFin = 6;
				fechaInicio = anio + "-04-01";			
				fechaFin = getLastDaytoMonth(mesFin, anio);			
				break;
			case 3:
				mesFin = 9;
				fechaInicio = anio + "-07-01";			
				fechaFin = getLastDaytoMonth(mesFin, anio);			
				break;
			case 4:
				mesFin = 12;
				fechaInicio = anio + "-10-01";			
				fechaFin = getLastDaytoMonth(mesFin, anio);			
				break;
			default:
				break;
			}
		}

		// Add fechas
		fechas.put("fechaInicio", fechaInicio);
		fechas.put("fechaFin", fechaFin);
		logger.info("No. Fechas: " + fechas.size());
		return fechas;

	}

	public static String getDate () {

		LocalDate myObj = LocalDate.now(); // Create a date object
		logger.info("Fecha Calculo: " + myObj); // Display the current date
		return myObj.toString();   

	}

	public static int dateBetween (String fechaInicio, String fechaFin, String fechaEvaluar) {
		int between = 0;

		try {
			Date startDate = DATE_FORMAT.parse(fechaInicio);
			logger.info("startDate:" + startDate);
			Date endDate = DATE_FORMAT.parse(fechaFin);
			logger.info("endDate:" + endDate);
			Date date  = DATE_FORMAT.parse(fechaEvaluar);
			logger.info("DATE:" + date);
			calendar.setTime(date);
			logger.info("calendar.getTime:" + calendar.getTime());
			calendar.add(Calendar.DATE, -1);
			logger.info("Calendar.DATE; " + Calendar.DATE + " fechaEvaluar -1 :" + calendar.getTime());		 

			if (date.equals(startDate) || date.after(startDate)) {
				logger.info("EL INICIO DE VIGENCIA DEL CONTRATO ES IGUAL O MAYOR AL INICIO DEL TRIMESTRE" + startDate);
				if (date.equals(endDate) || date.before(endDate)) {
					logger.info("EL INICIO DE VIGENCIA DEL CONTRATO ES IGUAL O MENOR AL FIN DEL TRIMESTRE" + endDate);
					between = 1;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return between;
	}

}
