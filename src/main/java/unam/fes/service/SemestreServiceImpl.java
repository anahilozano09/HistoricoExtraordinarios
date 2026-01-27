package unam.fes.service;

import org.springframework.stereotype.Service;
import unam.fes.model.entity.SemestreEntity;
import unam.fes.repository.SemestreRepository;
import unam.fes.service.SemestreService;

import java.util.List;

@Service
public class SemestreServiceImpl implements SemestreService {

    private final SemestreRepository semestreRepository;

    public SemestreServiceImpl(SemestreRepository semestreRepository) {
        this.semestreRepository = semestreRepository;
    }

    @Override
    public List<SemestreEntity> findAll() {
        return semestreRepository.findAllByOrderBySemestreAsc();
    }
}
