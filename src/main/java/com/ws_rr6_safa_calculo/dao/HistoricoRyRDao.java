package com.ws_rr6_safa_calculo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ws_rr6_safa_calculo.models.HistoricoRyR;

@Repository
public interface HistoricoRyRDao extends JpaRepository<HistoricoRyR, Integer> {

    @Query(value = "SELECT * FROM HISTORICOSRYR WHERE NUMERODOCUMENTO = :numeroDocumento AND FECHADESDE = :fechaDesde AND FECHAHASTA = :fechaHasta",nativeQuery = true)
    HistoricoRyR getReporteByNumDoc(@Param("numeroDocumento") int numeroDocumento, @Param("fechaDesde") String fechaDesde, @Param("fechaHasta") String fechaHasta);

    @Modifying
	@Transactional
    @Query(value = "DELETE FROM HISTORICOSRYR WHERE NUMERODOCUMENTO = :numeroDocumento AND FECHADESDE = :fechaDesde AND FECHAHASTA = :fechaHasta",nativeQuery = true)
    void deleteReporteByNumDoc(@Param("numeroDocumento") int numeroDocumento, @Param("fechaDesde") String fechaDesde, @Param("fechaHasta") String fechaHasta);
 
    @Query(value = "SELECT ID, FECHAPROCESO, FECHADESDE, FECHAHASTA, CONTENTTYPE, NUMERODOCUMENTO, BASE64, MONEDA, YEAR(FECHAHASTA) AS SUBRAMO, REASEGURADORA FROM HISTORICOSRYR WHERE NUMERODOCUMENTO IN (17, 18, 19, 20, 21, 22) ORDER BY YEAR(FECHAHASTA), REASEGURADORA, NUMERODOCUMENTO;",nativeQuery = true)
    List<HistoricoRyR>  getListRr6();
 
	
}
