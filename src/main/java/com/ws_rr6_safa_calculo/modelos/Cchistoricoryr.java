package com.ws_rr6_safa_calculo.modelos;

import javax.persistence.*;

public class Cchistoricoryr {
    private Integer id;
    private String modulo;
    private String nombredocumento;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getNombredocumento() {
        return nombredocumento;
    }

    public void setNombredocumento(String nombredocumento) {
        this.nombredocumento = nombredocumento;
    }

}