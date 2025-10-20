package com.ws_rr6_plenit.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ws_rr6_plenit.util.ResponseMessage;

@RestController
@CrossOrigin
@RequestMapping("rr6/v1/")
public interface IRestControllerRr6 {

    /**
     * Recupera los archivos de los reportes
     * @return ResponseEntity<ResponseMessage> respuesta http
     */
    @GetMapping("rr6Triva")
    ResponseEntity<ResponseMessage> getReportsRr6Triva();

    /**
     * Realiza el calculo del reporte
     * @param anio del reporte a generar
     * @param trimestre del reporte a generar
     * @return ResponseEntity<ResponseMessage> respuesta http
     */
    @PostMapping("reporteRR6/{anio}/{trimestre}")
    ResponseEntity<ResponseMessage> reporteRR6(@PathVariable("anio") int anio, @PathVariable("trimestre") int trimestre);






	
	
	@PostMapping("/reportRtre/{trimestre}/{anio}/{idArchivo}") 
	ResponseMessage reportRtre(@PathVariable("trimestre") int trimestre, @PathVariable("anio") int anio, @PathVariable("idArchivo") int idArchivo);
	
    @GetMapping("RR6TRIVAById/{idArchivo}/{trimestre}/{anio}")
    ResponseMessage rR6TRIVAById(@PathVariable("idArchivo") int idArchivo, @PathVariable("trimestre") int trimestre, @PathVariable("anio") int anio);

    @DeleteMapping("RR6TRIVAById/{idArchivo}/{trimestre}/{anio}")
    ResponseMessage deleteRR6TRIVAById(@PathVariable("idArchivo") int idArchivo, @PathVariable("trimestre") int trimestre, @PathVariable("anio") int anio);

}
