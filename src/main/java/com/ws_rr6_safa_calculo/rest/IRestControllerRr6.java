package com.ws_rr6_safa_calculo.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ws_rr6_safa_calculo.util.ResponseMessage;

@RestController
@CrossOrigin
@RequestMapping("rr6/v1/")
public interface IRestControllerRr6 {

    /**
     * Recupera los archivos de los reportes
     *
     * @return ResponseEntity<ResponseMessage> respuesta http
     */
    @GetMapping("rr6Triva")
    ResponseEntity<ResponseMessage> getReportsRr6Triva();

    /**
     * Realiza el calculo del reporte
     *
     * @param anio      del reporte a generar
     * @param trimestre del reporte a generar
     * @return ResponseEntity<ResponseMessage> respuesta http
     */
    @PostMapping("reporteRR6/{anio}/{trimestre}")
    ResponseEntity<ResponseMessage> reporteRR6(@PathVariable("anio") int anio, @PathVariable("trimestre") int trimestre);

}
