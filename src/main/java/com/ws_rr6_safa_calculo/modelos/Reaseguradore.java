package com.ws_rr6_safa_calculo.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

public class Reaseguradore {
    private Integer id;
    private Integer datoscontratoId;
    private Integer ccreaseguradorasId;
    private BigDecimal porcentajeparticipacionporcontrato;
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

    public Integer getCcreaseguradorasId() {
        return ccreaseguradorasId;
    }

    public void setCcreaseguradorasId(Integer ccreaseguradorasId) {
        this.ccreaseguradorasId = ccreaseguradorasId;
    }

    public BigDecimal getPorcentajeparticipacionporcontrato() {
        return porcentajeparticipacionporcontrato;
    }

    public void setPorcentajeparticipacionporcontrato(BigDecimal porcentajeparticipacionporcontrato) {
        this.porcentajeparticipacionporcontrato = porcentajeparticipacionporcontrato;
    }

}