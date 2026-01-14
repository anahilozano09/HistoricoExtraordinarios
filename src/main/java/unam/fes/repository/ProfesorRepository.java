package unam.fes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unam.fes.model.entity.ProfesorEntity;

public interface ProfesorRepository extends JpaRepository<ProfesorEntity,Long> {
}
