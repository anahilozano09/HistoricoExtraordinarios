package unam.fes.service;

import unam.fes.model.entity.HistoricoEntity;
import java.util.List;


public interface HistoricoService {

    List<HistoricoEntity> filtrarHistorico(
            Long sinodal1Id,
            Long sinodal2Id,
            String claveMateria,
            Long idVuelta,
            Integer semestreId
    );

}






