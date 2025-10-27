package com.ws_rr6_safa_calculo.dao;

import com.ws_rr6_safa_calculo.models.Cchistoricoryr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CcHistoricoRyRDao extends JpaRepository<Cchistoricoryr, Integer> {
    Cchistoricoryr findByNombredocumento(String nombredocumento);
}
