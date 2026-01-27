package unam.fes.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "vuelta")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VueltaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vuelta")
    private Long id;

    @Column(name = "num_vuelta", length = 25)
    private String numVuelta;
}

