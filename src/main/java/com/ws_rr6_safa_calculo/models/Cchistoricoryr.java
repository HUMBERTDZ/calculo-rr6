package com.ws_rr6_safa_calculo.models;

import javax.persistence.*;

@Entity
@Table(name = "CCHISTORICORYR", schema = "dbo")
public class Cchistoricoryr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "MODULO", length = 100)
    private String modulo;

    @Column(name = "NOMBREDOCUMENTO", length = 200)
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