package unam.fes.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import unam.fes.model.entity.HistoricoEntity;

import java.util.List;

@Repository
public interface HistoricoRepository extends JpaRepository<HistoricoEntity, Long> {

    @Query("""
            SELECT h FROM HistoricoEntity h
            WHERE (:sinodal1Id IS NULL OR h.sinodal1.id = :sinodal1Id)
            AND (:sinodal2Id IS NULL OR h.sinodal2.id = :sinodal2Id)
            AND (:claveMateria IS NULL OR h.materia.claveMateria = :claveMateria)
            AND (:idVuelta IS NULL OR h.vuelta.id = :idVuelta)
            AND (:semestreId IS NULL OR h.semestre.idSemestre = :semestreId)
            """)
    List<HistoricoEntity> filtrarHistorico(
            @Param("sinodal1Id") Long sinodal1Id,
            @Param("sinodal2Id") Long sinodal2Id,
            @Param("claveMateria") String claveMateria,
            @Param("idVuelta") Long idVuelta,
            @Param("semestreId") Integer semestreId
    );
}



