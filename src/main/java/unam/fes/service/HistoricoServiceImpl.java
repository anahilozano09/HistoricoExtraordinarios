package unam.fes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unam.fes.model.entity.HistoricoEntity;
import unam.fes.repository.HistoricoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HistoricoServiceImpl implements HistoricoService {

    private final HistoricoRepository historicoRepository;

    public HistoricoServiceImpl(HistoricoRepository historicoRepository) {
        this.historicoRepository = historicoRepository;
    }

    @Override
    public List<HistoricoEntity> filtrarHistorico(
            Long sinodal1Id,
            Long sinodal2Id,
            String claveMateria,
            Long idVuelta,
            Integer idSemestre
    ) {
        return historicoRepository.filtrarHistorico(
                sinodal1Id,
                sinodal2Id,
                claveMateria,
                idVuelta,
                idSemestre
        );
    }
}




