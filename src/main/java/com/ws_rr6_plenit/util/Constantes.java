package com.ws_rr6_plenit.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Constantas que se utilizan comunmente dentro de los controladores
 * 
 */
public class Constantes {

	public static final String RESPONSEMESSAGE_OK = "OK";
	public static final String RESPONSEMESSAGE_ERROR = "ERROR";
	public static final String BUSQUEDA_SIN_RESULTADOS = "No se encontraron resultados";
	public static final String MENSAJE_ERROR_GENERICO = "Error en la operación";
	public static final String ERROR_CARGA_ARCHIVO = "Error al cargar archivo";
	public static final String ERROR_NOMBRE_ARCHIVO = "Error, el nombre del archivo no coincide.";
	public static final String MENSAJE_CAMPO_REQUERIDO = "Campo requerido";
	public static final String MENSAJE_INSERT_REQUERIDO = "NO INSERTADO";

	public static final String TIME24HOURS_PATTERN = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
	public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String EMAIL_REGX_VALID = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	
	public static final String PAGO = "PAGO";
	public static final String GASTO = "GASTO";
	public static final String AJUSTE = "AJUSTE";
	public static final String SALVAMENTO = "SALVAMENTO";
	public static final String RECUPERO = "RECUPERO";
	public static final String LITIGIO = "LITIGIO";
	public static final String ESTIMACION = "ESTIMACION";
	public static final String FORMATO_FECHAS_REPORTES = "yyyyMMdd";
	public static final Integer ID_RAMO_DANIOS = 5;
	public static final Integer ID_RAMO_AP = 1;
	public static final int ID_MUERTE_ACCIDENTAL_CT10COBERTURA = 1;
	public static final int ID_RGM_POR_ACCIDENTE_CT10COBERTURA = 2;
	public static final int ID_INVALIDEZ_TOTAL_PERMANENTE_CT10COBERTURA = 3;
	public static final int ID_ESTRUCTURA_CT10COBERTURA = 4;
	public static final int ID_ASISTENCIA_DENTAL_CT10COBERTURA = 5;
	public static final int ID_ASISTENCIA_FUNERARIA_CT10COBERTURA = 6;
	public static final int ID_IMPERMEABILIDACION_CT10COBERTURA = 7;
	public static final int ID_INSTALACIONES_FIJAS_CT10COBERTURA = 8;
	public static final int ID_ACABADOS_CT10COBERTURA = 9;
	public static final int ID_COORDINACION_PROVEEDORES_CT10COBERTURA = 55;
	public static final String PAGINA_ERROR_ACCESO = "errorAcceso";
	public static final int CT2_ESTATUS_CANCELADO = 2;
	
	
	public static final String ELIMINADO = "ELMINACIÓN REALIZADA";
	
	//Constantes permisos especiales
	public static final String PERMISO_SUMA_ASEGURADA_MAXIMA = "saMaxima";
	
	Constantes() {
		// Constructor vacio
	}
	
	public static boolean rfcValido(Boolean personaFisica, String rfc) {
		if (personaFisica) {
			if (!rfc.matches("^[A-Z]{4}([0-9]{2})(1[0-2]|0[1-9])([0-3][0-9])([ -]?)([A-Z0-9]{3})$")) {
				return false;
			}
		} else {
			if (!rfc.matches("^[A-Z]{3}([0-9]{2})(1[0-2]|0[1-9])([0-3][0-9])([ -]?)([A-Z0-9]{3})$")) {
				return false;
			}
		}

		return true;
	}
	
	public static boolean curpValido(String curp) {
		String regex = "^[A-Z]{1}[AEIOU]{1}[A-Z]{2}[0-9]{2}" + "(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])"
				+ "[HM]{1}"
				+ "(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)"
				+ "[B-DF-HJ-NP-TV-Z]{3}" + "[0-9A-Z]{1}[0-9]{1}$";

		return curp.matches(regex);
	}

	public static boolean emailValido(String email) {
		String regex = EMAIL_REGX_VALID;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
}
