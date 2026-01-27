package unam.fes.service;

import unam.fes.model.entity.ProfesorEntity;

import java.util.List;

public interface ProfesorService {
    ProfesorEntity save(ProfesorEntity profesorEntity);
    List<ProfesorEntity> findAll();
    void deleteById(Long id);
    ProfesorEntity findById(Long id);
}
