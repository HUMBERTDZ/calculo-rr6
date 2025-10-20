package com.ws_rr6_plenit.services.interfaces;

import java.io.IOException;

import com.ws_rr6_plenit.util.ResponseMessage;

public interface ReportesRegulatoriosService {
	ResponseMessage respuestaRR7(int[] idsArchivos,String anioMes) throws IOException ;
	
	ResponseMessage saveObjectList(int idArchivo,Object lista) throws IOException ;

	int updateAndCalculate(int idArchivo,String anioMes) throws IOException;

	ResponseMessage respuestaRR72(int[] idsArchivos, String anioMes) throws IOException;

	ResponseMessage calcularReportes(int[] idsArchivos, String anioMes) throws IOException;

	ResponseMessage updateFiles(int[] idsArchivos, String anioMes) throws IOException;


	
}
