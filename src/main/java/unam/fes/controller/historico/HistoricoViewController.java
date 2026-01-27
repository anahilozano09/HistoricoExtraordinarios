package unam.fes.controller.historico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import unam.fes.model.entity.*;
import unam.fes.service.*;

import java.util.List;

@Controller
public class HistoricoViewController {

    @Autowired
    private HistoricoService historicoService;

    @Autowired
    private ProfesorService profesorService;

    @Autowired
    private MateriasService materiasService;

    @Autowired
    private VueltaService vueltaService;

    @Autowired
    private SemestreService semestreService;

    @GetMapping("/historico")
    public String mostrarHistorico(
            @RequestParam(required = false) Long sinodal1Id,
            @RequestParam(required = false) Long sinodal2Id,
            @RequestParam(required = false) String claveMateria,
            @RequestParam(required = false) Long idVuelta,
            @RequestParam(required = false) Integer semestreId,
            Model model
    ) {

        // Normalizar vacíos a null
        sinodal1Id = (sinodal1Id != null && sinodal1Id != 0) ? sinodal1Id : null;
        sinodal2Id = (sinodal2Id != null && sinodal2Id != 0) ? sinodal2Id : null;
        idVuelta = (idVuelta != null && idVuelta != 0) ? idVuelta : null;
        semestreId = (semestreId != null && semestreId != 0) ? semestreId : null;
        claveMateria = (claveMateria != null && !claveMateria.isBlank()) ? claveMateria : null;

        model.addAttribute("historicos",
                historicoService.filtrarHistorico(
                        sinodal1Id, sinodal2Id, claveMateria, idVuelta, semestreId
                )
        );

        model.addAttribute("profesores", profesorService.findAll());
        model.addAttribute("materias", materiasService.findAll());
        model.addAttribute("vueltas", vueltaService.findAll());
        model.addAttribute("semestres", semestreService.findAll());

        // 🔹 mantener estado de filtros
        model.addAttribute("sinodal1Id", sinodal1Id);
        model.addAttribute("sinodal2Id", sinodal2Id);
        model.addAttribute("claveMateria", claveMateria);
        model.addAttribute("idVuelta", idVuelta);
        model.addAttribute("semestreId", semestreId);

        return "paginas/historico/historico";
    }


}
