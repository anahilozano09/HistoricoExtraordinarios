package unam.fes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unam.fes.model.entity.VueltaEntity;
import unam.fes.repository.VueltaRepository;

import java.util.List;

@Service
public class VueltaServiceImpl implements VueltaService {

    @Autowired
    private VueltaRepository vueltaRepository;

    @Override
    @Transactional
    public VueltaEntity save(VueltaEntity vuelta) {
        return vueltaRepository.save(vuelta);
    }

    @Override
    public List<VueltaEntity> findAll() {
        return vueltaRepository.findAll();
    }

    @Override
    public VueltaEntity findById(Long id) {
        return vueltaRepository.findById(id)
                .orElse(null);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        vueltaRepository.deleteById(id);
    }
}

