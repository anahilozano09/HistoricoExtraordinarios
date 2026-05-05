package unam.fes.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "semestre")
public class SemestreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_semestre")
    private Long idSemestre;

    @Column(name = "semestre", length = 8, nullable = false)
    private String semestre;

    // Getters y setters

    public Long getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(Long idSemestre) {
        this.idSemestre = idSemestre;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
}
