package unam.fes.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity

@Table(name = "historico")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistoricoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hist")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_sinodal1", nullable = false)
    private ProfesorEntity sinodal1;

    @ManyToOne
    @JoinColumn(name = "id_sinodal2", nullable = false)
    private ProfesorEntity sinodal2;

    @ManyToOne
    @JoinColumn(name = "id_semestre", nullable = false)
    private SemestreEntity semestre;

    @ManyToOne
    @JoinColumn(name = "id_vuelta", nullable = false)
    private VueltaEntity vuelta;

    @ManyToOne
    @JoinColumn(name = "clave_materia", nullable = false)
    private MateriasEntity materia;
}

