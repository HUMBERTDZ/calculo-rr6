package com.ws_rr6_plenit.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ws_rr6_plenit.services.interfaces.Rr6Service;
import com.ws_rr6_plenit.util.Constantes;
import com.ws_rr6_plenit.util.ResponseMessage;

@Transactional
@Service
public class RestControllerRr6Impl implements IRestControllerRr6{
	// atributos
	final static Logger logger = LoggerFactory.getLogger(RestControllerRr6Impl.class);
	private final Rr6Service rr6Service;

	// inyeccion de dependencia
	@Autowired
	public RestControllerRr6Impl(Rr6Service rr6Service) {
		this.rr6Service = rr6Service;
	}

	@Override
	public ResponseEntity<ResponseMessage> getReportsRr6Triva()  {
		return rr6Service.getRr6Triva();
	}

	@Override
	public ResponseEntity<ResponseMessage> reporteRR6(int anio, int trimestre)  {
		ResponseMessage respuesta = null;
		List<ResponseMessage> listRespuesta = new ArrayList<>();

		respuesta = reportRtre(trimestre, anio, 17);
		if (respuesta.getDetalleMensaje().equals("1")) {
			listRespuesta.add(respuesta);
            logger.info("REPORTE RTRE CALCULADO EXITOSAMENTE trimestre:{} anio:{}", trimestre, anio);
			respuesta = reportRtrc(trimestre, anio, 18);
			if (respuesta.getDetalleMensaje().equals("1")) {
                logger.info("REPORTE RTRC CALCULADO EXITOSAMENTE trimestre:{} anio:{}", trimestre, anio);
				listRespuesta.add(respuesta);
				respuesta = reportRtrf(trimestre, anio, 19);
				if (respuesta.getDetalleMensaje().equals("1")) {
                    logger.info("REPORTE RTRF CALCULADO EXITOSAMENTE trimestre:{} anio:{}", trimestre, anio);
					respuesta = reportRtrr(trimestre, anio, 20);
					if (respuesta.getDetalleMensaje().equals("1")) {
                        logger.info("REPORTE RTRR CALCULADO EXITOSAMENTE trimestre:{} anio:{}", trimestre, anio);
						respuesta = reportRtrs(trimestre, anio, 21);
						if (respuesta.getDetalleMensaje().equals("1")) {
                            logger.info("REPORTE RTRS CALCULADO EXITOSAMENTE trimestre:{} anio:{}", trimestre, anio);
							respuesta = reportRarn(trimestre, anio, 22);
							listRespuesta.add(respuesta);					
							respuesta = new ResponseMessage(Constantes.RESPONSEMESSAGE_OK, "1", listRespuesta);
						} else {
							respuesta = new ResponseMessage(Constantes.RESPONSEMESSAGE_ERROR, "0", "EL REPORTE RTRS NO PUDO SER PROCESADO");
						}							
					} else {
						respuesta = new ResponseMessage(Constantes.RESPONSEMESSAGE_ERROR, "0", "EL REPORTE RTRR NO PUDO SER PROCESADO");
					}					
				} else {
					respuesta = new ResponseMessage(Constantes.RESPONSEMESSAGE_ERROR, "0", "EL REPORTE RTRF NO PUDO SER PROCESADO");
				}
			} else {
				respuesta = new ResponseMessage(Constantes.RESPONSEMESSAGE_ERROR, "0", "EL REPORTE RTRC NO PUDO SER PROCESADO");
			}
		} else {
			respuesta = new ResponseMessage(Constantes.RESPONSEMESSAGE_ERROR, "0", "EL REPORTE RTRE NO PUDO SER PROCESADO");
		}
		return ResponseEntity.ok(respuesta);
	}


	@Override
	public ResponseMessage reportRtre(int trimestre, int anio, int numeroDocumento) {
		ResponseMessage respuesta = null;

		try {
			//CONSULTAMOS SI EXISTE EL REPORTE
			respuesta = rr6Service.getRr6TrivaByNumFile( numeroDocumento, trimestre, anio);
			//NO EXISTE = -1
			if (respuesta.getDetalleMensaje().equals("-1")) {
				//SE DEBE CREAR
				respuesta = calcularReporteRtre(trimestre, anio, numeroDocumento);
			} else if  (respuesta.getDetalleMensaje().equals("1")) { 
				//SI EXISTE EL ARCHIVO PROCEDE A SER ELIMINADO
				respuesta = rr6Service.deleteRr6TrivaById(numeroDocumento, trimestre, anio);
				respuesta = calcularReporteRtre(trimestre, anio, numeroDocumento);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			respuesta = new ResponseMessage(Constantes.RESPONSEMESSAGE_OK, "OCURRIO UN ERROR AL PROCESAR EL REPORTE", 0);
		}
		return respuesta;
	}

	@Override
	public ResponseMessage rR6TRIVAById(int idArchivo, int trimestre, int anio) {
		return rr6Service.getRr6TrivaByNumFile( idArchivo, trimestre, anio);
	}

	public ResponseMessage calcularReporteRtre(int trimestre, int anio, int numFile)  {

		ResponseMessage respuesta = null;
		boolean reporteCalculado = rr6Service.reportRtre(trimestre, anio);

		if (!reporteCalculado) {
			respuesta = new ResponseMessage(Constantes.RESPONSEMESSAGE_ERROR, "0", "EL REPORTE NO PUDO SER CALCULADO");
		} else {
			respuesta = rr6Service.getRr6TrivaByNumFile(numFile, trimestre, anio);
		}
		return respuesta;
	}

	@Override
	public ResponseMessage deleteRR6TRIVAById(int idArchivo, int trimestre, int anio) {
		return rr6Service.deleteRr6TrivaById(idArchivo, trimestre, anio);
	}


	public ResponseMessage reportRtrc(int trimestre, int anio, int idArchivo) {
		ResponseMessage respuesta = null;

		try {
			//CONSULTAMOS SI EXISTE EL REPORTE
			respuesta = rr6Service.getRr6TrivaByNumFile( idArchivo, trimestre, anio);
			logger.info("Mensaje: " + respuesta.getMensaje() + " Detalle Mensaje:"+  respuesta.getDetalleMensaje() + " DataExtra:"+ respuesta.getDataExtra());
			//NO EXISTE = -1
			if (respuesta.getDetalleMensaje().equals("-1")) {
				//SE DEBE CREAR
				respuesta = calcularReporteRtrc(trimestre, anio, idArchivo);
			} else if  (respuesta.getDetalleMensaje().equals("1")) { 
				//SI EXISTE EL ARCHIVO PROCEDE A SER ELIMINADO
				respuesta = rr6Service.deleteRr6TrivaById(idArchivo, trimestre, anio);
				logger.info("Mensaje: " + respuesta.getMensaje() + " Detalle Mensaje:"+  respuesta.getDetalleMensaje() + " DataExtra:"+ respuesta.getDataExtra());
				respuesta = calcularReporteRtrc(trimestre, anio, idArchivo);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			respuesta = new ResponseMessage(Constantes.RESPONSEMESSAGE_OK, "OCURRIO UN ERROR AL PROCESAR EL REPORTE", 0);
		}
		return respuesta;
	}

	public ResponseMessage calcularReporteRtrc(int trimestre, int anio, int idArchivo)  {

		ResponseMessage respuesta = null;
		boolean reporteCalculado = rr6Service.reportRtrc(trimestre, anio);

		if (!reporteCalculado) {
			respuesta = new ResponseMessage(Constantes.RESPONSEMESSAGE_ERROR, "0", "EL REPORTE NO PUDO SER CALCULADO");
		} else {
			respuesta = rr6Service.getRr6TrivaByNumFile(idArchivo, trimestre, anio);
		}
		return respuesta;
	}


	public ResponseMessage calcularReporteRtrf(int trimestre, int anio, int idArchivo)  {

		ResponseMessage respuesta = null;
		boolean reporteCalculado = rr6Service.reportRtrf(trimestre, anio);

		if (!reporteCalculado) {
			respuesta = new ResponseMessage(Constantes.RESPONSEMESSAGE_ERROR, "0", "EL REPORTE NO PUDO SER CALCULADO");
		} else {
			respuesta = rr6Service.getRr6TrivaByNumFile(idArchivo, trimestre, anio);
		}
		return respuesta;
	}

	public ResponseMessage reportRtrf(int trimestre, int anio, int idArchivo) {
		ResponseMessage respuesta = null;

		try {
			//CONSULTAMOS SI EXISTE EL REPORTE
			respuesta = rr6Service.getRr6TrivaByNumFile( idArchivo, trimestre, anio);
			logger.info("Mensaje: " + respuesta.getMensaje() + " Detalle Mensaje:"+  respuesta.getDetalleMensaje() + " DataExtra:"+ respuesta.getDataExtra());
			//NO EXISTE = -1
			if (respuesta.getDetalleMensaje().equals("-1")) {
				//SE DEBE CREAR
				respuesta = calcularReporteRtrf(trimestre, anio, idArchivo);
			} else if  (respuesta.getDetalleMensaje().equals("1")) { 
				//SI EXISTE EL ARCHIVO PROCEDE A SER ELIMINADO
				respuesta = rr6Service.deleteRr6TrivaById(idArchivo, trimestre, anio);
				logger.info("Mensaje: " + respuesta.getMensaje() + " Detalle Mensaje:"+  respuesta.getDetalleMensaje() + " DataExtra:"+ respuesta.getDataExtra());
				respuesta = calcularReporteRtrf(trimestre, anio, idArchivo);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			respuesta = new ResponseMessage(Constantes.RESPONSEMESSAGE_OK, "OCURRIO UN ERROR AL PROCESAR EL REPORTE", 0);
		}
		return respuesta;
	}
	
	public ResponseMessage reportRtrr(int trimestre, int anio, int idArchivo) {
		ResponseMessage respuesta = null;

		try {
			//CONSULTAMOS SI EXISTE EL REPORTE
			respuesta = rr6Service.getRr6TrivaByNumFile( idArchivo, trimestre, anio);
			logger.info("Mensaje: " + respuesta.getMensaje() + " Detalle Mensaje:"+  respuesta.getDetalleMensaje() + " DataExtra:"+ respuesta.getDataExtra());
			//NO EXISTE = -1
			if (respuesta.getDetalleMensaje().equals("-1")) {
				//SE DEBE CREAR
				respuesta = calcularReporteRtrr(trimestre, anio, idArchivo);
			} else if  (respuesta.getDetalleMensaje().equals("1")) { 
				//SI EXISTE EL ARCHIVO PROCEDE A SER ELIMINADO
				respuesta = rr6Service.deleteRr6TrivaById(idArchivo, trimestre, anio);
				logger.info("Mensaje: " + respuesta.getMensaje() + " Detalle Mensaje:"+  respuesta.getDetalleMensaje() + " DataExtra:"+ respuesta.getDataExtra());
				respuesta = calcularReporteRtrr(trimestre, anio, idArchivo);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			respuesta = new ResponseMessage(Constantes.RESPONSEMESSAGE_OK, "OCURRIO UN ERROR AL PROCESAR EL REPORTE", 0);
		}
		return respuesta;
	}
	
	public ResponseMessage calcularReporteRtrr(int trimestre, int anio, int idArchivo)  {

		ResponseMessage respuesta = null;
		boolean reporteCalculado = rr6Service.reportRtrr(trimestre, anio);

		if (!reporteCalculado) {
			respuesta = new ResponseMessage(Constantes.RESPONSEMESSAGE_ERROR, "0", "EL REPORTE NO PUDO SER CALCULADO");
		} else {
			respuesta = rr6Service.getRr6TrivaByNumFile(idArchivo, trimestre, anio);
		}
		return respuesta;
	}

	public ResponseMessage reportRtrs(int trimestre, int anio, int idArchivo) {
		ResponseMessage respuesta = null;

		try {
			//CONSULTAMOS SI EXISTE EL REPORTE
			respuesta = rr6Service.getRr6TrivaByNumFile( idArchivo, trimestre, anio);
			logger.info("Mensaje: " + respuesta.getMensaje() + " Detalle Mensaje:"+  respuesta.getDetalleMensaje() + " DataExtra:"+ respuesta.getDataExtra());
			//NO EXISTE = -1
			if (respuesta.getDetalleMensaje().equals("-1")) {
				//SE DEBE CREAR
				respuesta = calcularReporteRtrs(trimestre, anio, idArchivo);
			} else if  (respuesta.getDetalleMensaje().equals("1")) { 
				//SI EXISTE EL ARCHIVO PROCEDE A SER ELIMINADO
				respuesta = rr6Service.deleteRr6TrivaById(idArchivo, trimestre, anio);
				logger.info("Mensaje: " + respuesta.getMensaje() + " Detalle Mensaje:"+  respuesta.getDetalleMensaje() + " DataExtra:"+ respuesta.getDataExtra());
				respuesta = calcularReporteRtrs(trimestre, anio, idArchivo);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			respuesta = new ResponseMessage(Constantes.RESPONSEMESSAGE_OK, "OCURRIO UN ERROR AL PROCESAR EL REPORTE", 0);
		}
		return respuesta;
	}
	
	public ResponseMessage calcularReporteRtrs(int trimestre, int anio, int idArchivo)  {

		ResponseMessage respuesta = null;
		boolean reporteCalculado = rr6Service.reportRtrs(trimestre, anio);

		if (!reporteCalculado) {
			respuesta = new ResponseMessage(Constantes.RESPONSEMESSAGE_ERROR, "0", "EL REPORTE NO PUDO SER CALCULADO");
		} else {
			respuesta = rr6Service.getRr6TrivaByNumFile(idArchivo, trimestre, anio);
		}
		return respuesta;
	}
	

	public ResponseMessage reportRarn(int trimestre, int anio, int idArchivo) {
		ResponseMessage respuesta = null;

		try {
			//CONSULTAMOS SI EXISTE EL REPORTE
			respuesta = rr6Service.getRr6TrivaByNumFile( idArchivo, trimestre, anio);
			logger.info("Mensaje: " + respuesta.getMensaje() + " Detalle Mensaje:"+  respuesta.getDetalleMensaje() + " DataExtra:"+ respuesta.getDataExtra());
			//NO EXISTE = -1
			if (respuesta.getDetalleMensaje().equals("-1")) {
				//SE DEBE CREAR
				respuesta = calcularReporteRarn(trimestre, anio, idArchivo);
			} else if  (respuesta.getDetalleMensaje().equals("1")) { 
				//SI EXISTE EL ARCHIVO PROCEDE A SER ELIMINADO
				respuesta = rr6Service.deleteRr6TrivaById(idArchivo, trimestre, anio);
				logger.info("Mensaje: " + respuesta.getMensaje() + " Detalle Mensaje:"+  respuesta.getDetalleMensaje() + " DataExtra:"+ respuesta.getDataExtra());
				respuesta = calcularReporteRarn(trimestre, anio, idArchivo);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			respuesta = new ResponseMessage(Constantes.RESPONSEMESSAGE_OK, "OCURRIO UN ERROR AL PROCESAR EL REPORTE", 0);
		}
		return respuesta;
	}
	
	public ResponseMessage calcularReporteRarn(int trimestre, int anio, int idArchivo)  {

		ResponseMessage respuesta = null;
		boolean reporteCalculado = rr6Service.reportRarn(trimestre, anio);

		if (!reporteCalculado) {
			respuesta = new ResponseMessage(Constantes.RESPONSEMESSAGE_ERROR, "0", "EL REPORTE NO PUDO SER CALCULADO");
		} else {
			respuesta = rr6Service.getRr6TrivaByNumFile(idArchivo, trimestre, anio);
		}
		return respuesta;
	}
	
	
	
}
