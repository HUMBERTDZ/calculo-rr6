package com.ws_rr6_safa_calculo.rest;

import java.util.ArrayList;
import java.util.List;

import com.ws_rr6_safa_calculo.models.HistoricoRyR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ws_rr6_safa_calculo.services.interfaces.IRr6Service;
import com.ws_rr6_safa_calculo.util.Constantes;
import com.ws_rr6_safa_calculo.util.ResponseMessage;

@Transactional
@Service
public class RestControllerRr6Impl implements IRestControllerRr6 {
    // atributos
    private final IRr6Service irr6Ser;

    // inyeccion de dependencia
    @Autowired
    public RestControllerRr6Impl(IRr6Service iRr6Service) {
        this.irr6Ser = iRr6Service;
    }

    // implementaciones
    @Override
    public ResponseEntity<ResponseMessage> getReportsRr6Triva() {
        return irr6Ser.getRr6Triva();
    }

    @Override
    public ResponseEntity<ResponseMessage> reporteRR6(int anio, int trimestre) {
        try {
            List<HistoricoRyR> listHistoricoRR = new ArrayList<>();
            listHistoricoRR.add(reportRtre(trimestre, anio, irr6Ser.getCcIdByNameFile("RTRE")));
            listHistoricoRR.add(reportRtrc(trimestre, anio, irr6Ser.getCcIdByNameFile("RTRC")));
            listHistoricoRR.add(reportRtrf(trimestre, anio, irr6Ser.getCcIdByNameFile("RTRF")));
            listHistoricoRR.add(reportRtrr(trimestre, anio, irr6Ser.getCcIdByNameFile("RTRR")));
            listHistoricoRR.add(reportRtrs(trimestre, anio, irr6Ser.getCcIdByNameFile("RTRS")));
            listHistoricoRR.add(reportRarn(trimestre, anio, irr6Ser.getCcIdByNameFile("RARN")));

            return ResponseEntity.ok(new ResponseMessage(Constantes.RESPONSEMESSAGE_OK, "reportes calculados", listHistoricoRR));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponseMessage(Constantes.RESPONSEMESSAGE_ERROR, "Algo ocurrio...", null));
        }
    }


    public HistoricoRyR reportRtre(int trimestre, int anio, int numeroDocumento) {
        HistoricoRyR historico = null;

        try {
            //consultando si existe el reporte
            historico = irr6Ser.getRr6TrivaByNumFile(numeroDocumento, trimestre, anio);
            //NO EXISTE
            if (historico == null) {
                //SE DEBE CALCULAR
                historico = calcularReporteRtre(trimestre, anio, numeroDocumento);
            }

            //SI EXISTE EL ARCHIVO PROCEDE A SER ELIMINADO para recalcular
            boolean isDeleted = irr6Ser.deleteRr6TrivaByNumFile(numeroDocumento, trimestre, anio);

            if (isDeleted) {
                historico = calcularReporteRtre(trimestre, anio, numeroDocumento);
            }

        } catch (Exception e) {
            return null;
        }
        return historico;
    }

    public HistoricoRyR calcularReporteRtre(int trimestre, int anio, int numFile) {
        // intenta calcular el reporte
        boolean reporteCalculado = irr6Ser.getCalculateRTRE(trimestre, anio);

        // si el reporte no fue calculado
        if (!reporteCalculado) {
            return null;
        }

        return irr6Ser.getRr6TrivaByNumFile(numFile, trimestre, anio);
    }


    public HistoricoRyR reportRtrc(int trimestre, int anio, int numeroDocumento) {
        HistoricoRyR historico = null;

        try {
            //CONSULTAMOS SI EXISTE EL REPORTE
            historico = irr6Ser.getRr6TrivaByNumFile(numeroDocumento, trimestre, anio);

            //NO EXISTE
            if (historico == null) {
                //SE DEBE CREAR
                historico = calcularReporteRtrc(trimestre, anio, numeroDocumento);
            }
            //SI EXISTE EL ARCHIVO PROCEDE A SER ELIMINADO
            boolean deleted = irr6Ser.deleteRr6TrivaByNumFile(numeroDocumento, trimestre, anio);

            if (deleted) {
                historico = calcularReporteRtrc(trimestre, anio, numeroDocumento);
            }

        } catch (Exception e) {
            historico = null;
        }
        return historico;
    }

    public HistoricoRyR calcularReporteRtrc(int trimestre, int anio, int numeroDocumento) {
        boolean reporteCalculado = irr6Ser.getCalculateRTRC(trimestre, anio);

        if (!reporteCalculado) {
            return null;
        } else {
            return irr6Ser.getRr6TrivaByNumFile(numeroDocumento, trimestre, anio);
        }
    }


    public HistoricoRyR reportRtrf(int trimestre, int anio, int numeroDocumento) {
        HistoricoRyR historico = null;

        try {
            //CONSULTAMOS SI EXISTE EL REPORTE
            historico = irr6Ser.getRr6TrivaByNumFile(numeroDocumento, trimestre, anio);
            //NO EXISTE = -1
            if (historico == null) {
                //SE DEBE CREAR
                historico = calcularReporteRtrf(trimestre, anio, numeroDocumento);
            }

            boolean isDeleted = irr6Ser.deleteRr6TrivaByNumFile(numeroDocumento, trimestre, anio);
            if (isDeleted) {
                historico = calcularReporteRtrf(trimestre, anio, numeroDocumento);
            }
        } catch (Exception e) {

            return null;
        }
        return historico;
    }

    public HistoricoRyR calcularReporteRtrf(int trimestre, int anio, int numeroDocumento) {
        boolean reporteCalculado = irr6Ser.getCalculateRTRF(trimestre, anio);

        if (!reporteCalculado) {
            return null;
        } else {
            return irr6Ser.getRr6TrivaByNumFile(numeroDocumento, trimestre, anio);
        }
    }


    public HistoricoRyR reportRtrr(int trimestre, int anio, int numeroDocumento) {
        HistoricoRyR historico = null;

        try {
            //CONSULTAMOS SI EXISTE EL REPORTE
            historico = irr6Ser.getRr6TrivaByNumFile(numeroDocumento, trimestre, anio);

            if (historico == null) {
                //SE DEBE CREAR
                historico = calcularReporteRtrr(trimestre, anio, numeroDocumento);
            }
            //SI EXISTE EL ARCHIVO PROCEDE A SER ELIMINADO
            boolean isDeleted = irr6Ser.deleteRr6TrivaByNumFile(numeroDocumento, trimestre, anio);

            if (isDeleted) {
                historico = calcularReporteRtrr(trimestre, anio, numeroDocumento);
            }


        } catch (Exception e) {
            return null;
        }
        return historico;
    }

    public HistoricoRyR calcularReporteRtrr(int trimestre, int anio, int numeroDocumento) {
        boolean reporteCalculado = irr6Ser.getCalculateRTRR(trimestre, anio);

        if (!reporteCalculado) {
            return null;
        } else {
            return irr6Ser.getRr6TrivaByNumFile(numeroDocumento, trimestre, anio);
        }
    }


    public HistoricoRyR reportRtrs(int trimestre, int anio, int numeroDocumento) {
        HistoricoRyR historico = null;

        try {
            //CONSULTAMOS SI EXISTE EL REPORTE
            historico = irr6Ser.getRr6TrivaByNumFile(numeroDocumento, trimestre, anio);

            //NO EXISTE
            if (historico == null) {
                //SE DEBE CREAR
                historico = calcularReporteRtrs(trimestre, anio, numeroDocumento);
            }

            //SI EXISTE EL ARCHIVO PROCEDE A SER ELIMINADO
            boolean isDeleted = irr6Ser.deleteRr6TrivaByNumFile(numeroDocumento, trimestre, anio);
            if (isDeleted) {
                historico = calcularReporteRtrs(trimestre, anio, numeroDocumento);
            }

        } catch (Exception e) {
            historico = null;
        }
        return historico;
    }

    public HistoricoRyR calcularReporteRtrs(int trimestre, int anio, int numeroDocumento) {
        boolean reporteCalculado = irr6Ser.getCalculateRTRS(trimestre, anio);

        if (!reporteCalculado) {
            return null;
        } else {
            return irr6Ser.getRr6TrivaByNumFile(numeroDocumento, trimestre, anio);
        }
    }


    public HistoricoRyR reportRarn(int trimestre, int anio, int numeroDocumento) {
        HistoricoRyR historico = null;

        try {
            //CONSULTAMOS SI EXISTE EL REPORTE
            historico = irr6Ser.getRr6TrivaByNumFile(numeroDocumento, trimestre, anio);

            //NO EXISTE
            if (historico == null) {
                //SE DEBE CREAR
                historico = calcularReporteRarn(trimestre, anio, numeroDocumento);
            }

            //SI EXISTE EL ARCHIVO PROCEDE A SER ELIMINADO
            boolean isDeleted = irr6Ser.deleteRr6TrivaByNumFile(numeroDocumento, trimestre, anio);

            if (isDeleted) {
                historico = calcularReporteRarn(trimestre, anio, numeroDocumento);
            }

        } catch (Exception e) {

            return null;
        }
        return historico;
    }

    public HistoricoRyR calcularReporteRarn(int trimestre, int anio, int numeroDocumento) {
        boolean reporteCalculado = irr6Ser.getCalculateRARN(trimestre, anio);

        if (!reporteCalculado) {
            return null;
        } else {
            return irr6Ser.getRr6TrivaByNumFile(numeroDocumento, trimestre, anio);
        }
    }

}
