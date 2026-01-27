package unam.fes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unam.fes.model.entity.ProfesorEntity;

import java.util.List;

public interface ProfesorRepository extends JpaRepository<ProfesorEntity, Long> {

    List<ProfesorEntity> findAllByOrderByNombreAsc();
}

