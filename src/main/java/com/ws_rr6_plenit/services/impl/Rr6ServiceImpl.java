package com.ws_rr6_plenit.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ws_rr6_plenit.dto.interfaces.Irr6TrivaRarnDto;
import com.ws_rr6_plenit.dto.interfaces.Irr6TrivaRtrcDto;
import com.ws_rr6_plenit.dto.interfaces.Irr6TrivaRtreDto;
import com.ws_rr6_plenit.dto.interfaces.Irr6TrivaRtrfDto;
import com.ws_rr6_plenit.dto.interfaces.Irr6TrivaRtrrDto;
import com.ws_rr6_plenit.dto.interfaces.Irr6TrivaRtrsDto;
import com.ws_rr6_plenit.services.interfaces.IHistoricoRyRService;
import com.ws_rr6_plenit.services.interfaces.Rr6Service;
import com.ws_rr6_plenit.util.ResponseMessage;


@Transactional(rollbackFor = Exception.class)
@Service
public class Rr6ServiceImpl implements Rr6Service{
	// atributos
	final static Logger logger = LoggerFactory.getLogger(Rr6ServiceImpl.class);
	private final Irr6TrivaRtreDto irr6TrivaRtreDto;
	private final Irr6TrivaRtrcDto irr6TrivaRtrcDto;
	private final Irr6TrivaRtrfDto irr6TrivaRtrfDto;
	private final Irr6TrivaRtrrDto irr6TrivaRtrrDto;
	private final Irr6TrivaRtrsDto irr6TrivaRtrsDto;
	private final Irr6TrivaRarnDto irr6TrivaRarnDto;
	private final  IHistoricoRyRService iHistoricoRyRService;

	// inyeccion de dependencias
	@Autowired
	public Rr6ServiceImpl(Irr6TrivaRtreDto irr6TrivaRtreDto, Irr6TrivaRtrcDto irr6TrivaRtrcDto, Irr6TrivaRtrfDto irr6TrivaRtrfDto, Irr6TrivaRtrrDto irr6TrivaRtrrDto, Irr6TrivaRtrsDto irr6TrivaRtrsDto, Irr6TrivaRarnDto irr6TrivaRarnDto, IHistoricoRyRService iHistoricoRyRService) {
		this.irr6TrivaRtreDto = irr6TrivaRtreDto;
		this.irr6TrivaRtrcDto = irr6TrivaRtrcDto;
		this.irr6TrivaRtrfDto = irr6TrivaRtrfDto;
		this.irr6TrivaRtrrDto = irr6TrivaRtrrDto;
		this.irr6TrivaRtrsDto = irr6TrivaRtrsDto;
		this.irr6TrivaRarnDto = irr6TrivaRarnDto;
		this.iHistoricoRyRService = iHistoricoRyRService;
	}

	@Override
	public ResponseEntity<ResponseMessage> getRr6Triva() {
		return	iHistoricoRyRService.getListRr6();
	}
	
	@Override
	public boolean reportRtre (int trimestre, int anio) {
		boolean reporteCreado = false;
		String tipoReporte = "RR6";
		String producto ="TRIVA";
		String claveCompania = "S1015";
		String nombreArchivo = "RTRE";
		String extencion = ".txt";
		String numeroDocumento = "17";
		String nombreCompleto = tipoReporte.concat(producto).concat(claveCompania) +  + anio + nombreArchivo.concat(extencion);
		
		try {
			irr6TrivaRtreDto.validTableRtre();
			irr6TrivaRtreDto.createTableRtre(trimestre, anio);
			irr6TrivaRtreDto.crearArchivo(anio, nombreCompleto);
			irr6TrivaRtreDto.save(trimestre, anio, irr6TrivaRtreDto.encriptarArchivo(nombreCompleto), nombreCompleto, numeroDocumento);			
			reporteCreado = true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}		
		
		return reporteCreado;
	}
	
	@Override
	public boolean reportRtrc (int trimestre, int anio) {
		
		boolean reporteCreado = false;		
		String tipoReporte = "RR6";
		String producto ="TRIVAS";
		String claveCompania = "S1015";
		String nombreArchivo = "RTRC";
		String extencion = ".txt";
		String numeroDocumento = "18";
		String nombreCompleto = tipoReporte.concat(producto).concat(claveCompania) +  + anio + nombreArchivo.concat(extencion);
		try {
			irr6TrivaRtrcDto.validateTable();
			irr6TrivaRtrcDto.createTable(trimestre, anio);
			irr6TrivaRtrcDto.updateTipoCaptura();
			irr6TrivaRtrcDto.updateFormatDate();
			irr6TrivaRtrcDto.updateLineasContrato();
			irr6TrivaRtrcDto.updatePorcionCedida();
			irr6TrivaRtrcDto.updateRetencionPrioridad();
			irr6TrivaRtrcDto.updateCapacMaxLimResp();
			irr6TrivaRtrcDto.updateImporteReinstalaciones();
			irr6TrivaRtrcDto.updateComisReasegRateOnLine();
			irr6TrivaRtrcDto.updateReasegInscritos();
			irr6TrivaRtrcDto.updateTipoReasegNacional();
			irr6TrivaRtrcDto.updateClaveReasegNacional();
			irr6TrivaRtrcDto.updateParticipacionReaseg();
			
			irr6TrivaRtrcDto.crearArchivo(anio, nombreCompleto);
			irr6TrivaRtreDto.save(trimestre, anio, irr6TrivaRtreDto.encriptarArchivo(nombreCompleto), nombreCompleto, numeroDocumento);			
			reporteCreado = true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
				
		return reporteCreado;
	}
	
	@Override
	public boolean reportRtrf (int trimestre, int anio) {
		
		boolean reporteCreado = false;
		String tipoReporte = "RR6";
		String producto ="TRIVAS";
		String claveCompania = "S1015";
		String nombreArchivo = "RTRF";
		String extencion = ".txt";
		String numeroDocumento = "19";
		String nombreCompleto = tipoReporte.concat(producto).concat(claveCompania) +  + anio + nombreArchivo.concat(extencion);
		try {
			irr6TrivaRtrfDto.validateTable();
			irr6TrivaRtrfDto.createTable(trimestre, anio);
			irr6TrivaRtrfDto.crearArchivo(anio, nombreCompleto);
			irr6TrivaRtrfDto.save(trimestre, anio, irr6TrivaRtreDto.encriptarArchivo(nombreCompleto), nombreCompleto, numeroDocumento);			
			reporteCreado = true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
				
		return reporteCreado;
	}	
	
	@Override
	public boolean reportRtrr(int trimestre, int anio) {
		
		boolean reporteCreado = false;		
		String tipoReporte = "RR6";
		String producto ="TRIVAS";
		String claveCompania = "S1015";
		String nombreArchivo = "RTRR";
		String extencion = ".txt";
		String numeroDocumento = "20";
		String nombreCompleto = tipoReporte.concat(producto).concat(claveCompania) +  + anio + nombreArchivo.concat(extencion);
		try {
			irr6TrivaRtrrDto.validateTable();
			irr6TrivaRtrrDto.createTable(trimestre, anio);
			irr6TrivaRtrrDto.updateSinReclamRecupPropFacult();
			irr6TrivaRtrrDto.updateMontSinReclamRecupContrNoPropor();			
			irr6TrivaRtrrDto.updateMontPrimaCedida();
			irr6TrivaRtrrDto.updateMontCostTotalCoberContratNoProporc();
			irr6TrivaRtrrDto.updateCastigoCtasReaseguro();
			irr6TrivaRtrrDto.crearArchivo(anio, nombreCompleto);
			irr6TrivaRtrrDto.save(trimestre, anio, irr6TrivaRtreDto.encriptarArchivo(nombreCompleto), nombreCompleto, numeroDocumento);			
			reporteCreado = true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}		

		return reporteCreado;
	}
	
	@Override
	public boolean reportRtrs(int trimestre, int anio) {
		
		boolean reporteCreado = false;		
		String tipoReporte = "RR6";
		String producto ="TRIVAS";
		String claveCompania = "S1015";
		String nombreArchivo = "RTRS";
		String extencion = ".txt";
		String numeroDocumento = "21";
		String nombreCompleto = tipoReporte.concat(producto).concat(claveCompania) +  + anio + nombreArchivo.concat(extencion);
		try {
			irr6TrivaRtrsDto.validateTable();
			irr6TrivaRtrsDto.createTable(trimestre, anio);			
			irr6TrivaRtrsDto.crearArchivo(anio, nombreCompleto);
			irr6TrivaRtrsDto.save(trimestre, anio, irr6TrivaRtreDto.encriptarArchivo(nombreCompleto), nombreCompleto, numeroDocumento);			
			reporteCreado = true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}		
						
		return reporteCreado;
	}
	
	@Override
	public boolean reportRarn(int trimestre, int anio) {
		
		boolean reporteCreado = false;		
		String tipoReporte = "RR6";
		String producto ="TRIVAS";
		String claveCompania = "S1015";
		String nombreArchivo = "RARN";
		String extencion = ".txt";
		String numeroDocumento = "22";
		String nombreCompleto = tipoReporte.concat(producto).concat(claveCompania) +  + anio + nombreArchivo.concat(extencion);
		try {
			irr6TrivaRarnDto.createTablePcc();			
			irr6TrivaRarnDto.updateCostoCoberturaXL();			
			irr6TrivaRarnDto.createTableSa();
			irr6TrivaRarnDto.crearArchivo(anio, nombreCompleto);
			irr6TrivaRarnDto.save(trimestre, anio, irr6TrivaRtreDto.encriptarArchivo(nombreCompleto), nombreCompleto, numeroDocumento);			
			reporteCreado = true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}		
						
		return reporteCreado;
	}

	@Override
	public ResponseMessage getRr6TrivaByNumFile(int numFile, int trimestre, int anio) {

		ResponseMessage respuesta = irr6TrivaRtreDto.getRr6TrivaByNumFile(numFile, trimestre, anio);
		logger.info("Mensaje: " + respuesta.getMensaje() + " Detalle Mensaje:"+  respuesta.getDetalleMensaje() + " DataExtra:"+ respuesta.getDataExtra());
		return respuesta;
	}

	@Override
	public ResponseMessage deleteRr6TrivaById(int idArchivo, int trimestre, int anio) {

		ResponseMessage respuesta = irr6TrivaRtreDto.deleteRr6TrivaById(idArchivo, trimestre, anio);
		logger.info("Mensaje: " + respuesta.getMensaje() + " Detalle Mensaje:"+  respuesta.getDetalleMensaje() + " DataExtra:"+ respuesta.getDataExtra());
		return respuesta;
	}



}

