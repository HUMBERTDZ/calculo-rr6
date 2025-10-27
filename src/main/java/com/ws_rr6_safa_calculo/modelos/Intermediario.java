package com.ws_rr6_safa_calculo.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

public class Intermediario {
    private Integer id;
    private Integer datoscontratoId;
    private Integer ccintermediariosId;
    private BigDecimal porcentajebrokercorretaje;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDatoscontratoId() {
        return datoscontratoId;
    }

    public void setDatoscontratoId(Integer datoscontratoId) {
        this.datoscontratoId = datoscontratoId;
    }

    public Integer getCcintermediariosId() {
        return ccintermediariosId;
    }

    public void setCcintermediariosId(Integer ccintermediariosId) {
        this.ccintermediariosId = ccintermediariosId;
    }

    public BigDecimal getPorcentajebrokercorretaje() {
        return porcentajebrokercorretaje;
    }

    public void setPorcentajebrokercorretaje(BigDecimal porcentajebrokercorretaje) {
        this.porcentajebrokercorretaje = porcentajebrokercorretaje;
    }

}