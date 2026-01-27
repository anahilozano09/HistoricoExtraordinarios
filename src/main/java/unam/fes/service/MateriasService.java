package unam.fes.service;

import unam.fes.model.entity.MateriasEntity;
import java.util.List;

public interface MateriasService {

    MateriasEntity save(MateriasEntity materia);

    List<MateriasEntity> findAll();

    MateriasEntity findById(String claveMateria);

    void deleteById(String claveMateria);
}
