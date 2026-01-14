package unam.fes.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "profesor")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfesorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prof")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

}
