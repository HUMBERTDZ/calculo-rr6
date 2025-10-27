package com.ws_rr6_safa_calculo.services.interfaces;


import com.ws_rr6_safa_calculo.models.HistoricoRyR;
import com.ws_rr6_safa_calculo.util.ResponseMessage;
import org.springframework.http.ResponseEntity;

public interface IRr6Service {
    /**
     * Recupera los archivos de los reportes calculados anteriormente
     *
     * @return ResponseEntity<ResponseMessage>
     */
    ResponseEntity<ResponseMessage> getRr6Triva();

    /**
     * Recupera un archivo por su numero de documento
     *
     * @param numFile   numero de archivo correspondiente
     * @param trimestre del archivo
     * @param anio      del archivo
     * @return HistoricoRYR row
     */
    HistoricoRyR getRr6TrivaByNumFile(int numFile, int trimestre, int anio);

    /**
     * Obtener el id/numero documento de acuerdo al tipo de archivo
     * @param name del tipo de archivo
     * @return id/numero
     */
    int getCcIdByNameFile(String name);

    /**
     * Elimina un archivo por su nuemro de documento
     *
     * @param numFile   numero de archivo correspondiente
     * @param trimestre del archivo
     * @param anio      del archivo
     * @return boolean
     */
    boolean deleteRr6TrivaByNumFile(int numFile, int trimestre, int anio);

    /**
     * recuperar el Calculo del Reporte RTRE
     *
     * @param trimestre del archivo a calcular
     * @param anio      del archivo a calcular
     * @return boolean si se hizo el calculo correctamente
     */
    boolean getCalculateRTRE(int trimestre, int anio);

    /**
     * recuperar el Calculo del Reporte RTRC
     *
     * @param trimestre del archivo a calcular
     * @param anio      del archivo a calcular
     * @return boolean si se hizo el calculo correctamente
     */
    boolean getCalculateRTRC(int trimestre, int anio);

    /**
     * recuperar el Calculo del Reporte RTRF
     *
     * @param trimestre del archivo a calcular
     * @param anio      del archivo a calcular
     * @return boolean si se hizo el calculo correctamente
     */
    boolean getCalculateRTRF(int trimestre, int anio);

    /**
     * recuperar el Calculo del Reporte RTRR
     *
     * @param trimestre del archivo a calcular
     * @param anio      del archivo a calcular
     * @return boolean si se hizo el calculo correctamente
     */
    boolean getCalculateRTRR(int trimestre, int anio);

    /**
     * recuperar el Calculo del Reporte RTRS
     *
     * @param trimestre del archivo a calcular
     * @param anio      del archivo a calcular
     * @return boolean si se hizo el calculo correctamente
     */
    boolean getCalculateRTRS(int trimestre, int anio);

    /**
     * recuperar el Calculo del Reporte RARN
     *
     * @param trimestre del archivo a calcular
     * @param anio      del archivo a calcular
     * @return boolean si se hizo el calculo correctamente
     */
    boolean getCalculateRARN(int trimestre, int anio);

}
