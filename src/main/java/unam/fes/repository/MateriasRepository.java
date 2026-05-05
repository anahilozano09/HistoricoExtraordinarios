package unam.fes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unam.fes.model.entity.MateriasEntity;

import java.util.List;

public interface MateriasRepository extends JpaRepository<MateriasEntity, String> {

    List<MateriasEntity> findAllByOrderByNombreMateriaAscClaveMateriaAsc();
}


