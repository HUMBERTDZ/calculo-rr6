package com.ws_rr6_safa_calculo.services.interfaces;

public interface ICalculateTrivaService {
    /**
     * Calcular Reporte RTRC
     *
     * @param trimestre del archivo a calcular
     * @param anio      del archivo a calcular
     * @return boolean si se hizo el calculo correctamente
     */
    boolean calculateRTRC(int trimestre, int anio);

    /**
     * Calcular Reporte RTRF
     *
     * @param trimestre del archivo a calcular
     * @param anio      del archivo a calcular
     * @return boolean si se hizo el calculo correctamente
     */
    boolean calculateRTRF(int trimestre, int anio);

    /**
     * Calcular Reporte RTRE
     *
     * @param trimestre del archivo a calcular
     * @param anio      del archivo a calcular
     * @return boolean si se hizo el calculo correctamente
     */
    boolean calculateRTRE(int trimestre, int anio);

    /**
     * Calcular Reporte RTRR
     *
     * @param trimestre del archivo a calcular
     * @param anio      del archivo a calcular
     * @return boolean si se hizo el calculo correctamente
     */
    boolean calculateRTRR(int trimestre, int anio);

    /**
     * Calcular Reporte RTRS
     *
     * @param trimestre del archivo a calcular
     * @param anio      del archivo a calcular
     * @return boolean si se hizo el calculo correctamente
     */
    boolean calculateRTRS(int trimestre, int anio);

    /**
     * Calcular Reporte RARN
     *
     * @param trimestre del archivo a calcular
     * @param anio      del archivo a calcular
     * @return boolean si se hizo el calculo correctamente
     */
    boolean calculateRARN(int trimestre, int anio);
}
