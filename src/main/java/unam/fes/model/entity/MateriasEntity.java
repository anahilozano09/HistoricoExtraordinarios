package unam.fes.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "materias")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MateriasEntity {

    @Id
    @Column(name = "clave_materia", length = 50)
    private String claveMateria;

    @Column(name = "nombre_materia", nullable = false, length = 150)
    private String nombreMateria;

    @Column(name = "creditos", nullable = false)
    private Integer creditos;

    @Column(name = "semestre", nullable = false, length = 6)
    private String semestre;
}



