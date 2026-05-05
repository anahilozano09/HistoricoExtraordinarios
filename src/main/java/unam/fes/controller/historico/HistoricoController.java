package unam.fes.controller.historico;
import unam.fes.model.entity.HistoricoEntity;
import unam.fes.service.HistoricoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historico")
public class HistoricoController {

    @Autowired
    private HistoricoService historicoService;

    @GetMapping
    public List<HistoricoEntity> obtenerHistorico(
            @RequestParam(required = false) Long sinodal1Id,
            @RequestParam(required = false) Long sinodal2Id,
            @RequestParam(required = false) String claveMateria,
            @RequestParam(required = false) Long idVuelta,
            @RequestParam(required = false) Integer idSemestre
    ) {
        return historicoService.filtrarHistorico(
                sinodal1Id,
                sinodal2Id,
                claveMateria,
                idVuelta,
                idSemestre
        );
    }
}



