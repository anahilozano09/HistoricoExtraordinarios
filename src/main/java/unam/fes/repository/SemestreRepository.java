package unam.fes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unam.fes.model.entity.SemestreEntity;

import java.util.List;

@Repository
public interface SemestreRepository extends JpaRepository<SemestreEntity, Integer> {

    List<SemestreEntity> findAllByOrderBySemestreAsc();
}


