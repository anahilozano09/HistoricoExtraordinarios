package unam.fes.service;

import unam.fes.model.entity.VueltaEntity;
import java.util.List;

public interface VueltaService {

    VueltaEntity save(VueltaEntity vuelta);

    List<VueltaEntity> findAll();

    VueltaEntity findById(Long id);

    void deleteById(Long id);
}

