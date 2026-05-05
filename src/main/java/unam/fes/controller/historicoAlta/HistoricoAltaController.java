package unam.fes.controller.historicoAlta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import unam.fes.model.entity.HistoricoEntity;
import unam.fes.model.entity.MateriasEntity;
import unam.fes.model.entity.ProfesorEntity;
import unam.fes.model.entity.SemestreEntity;
import unam.fes.model.entity.VueltaEntity;
import unam.fes.service.HistoricoService;
import unam.fes.service.MateriasService;
import unam.fes.service.ProfesorService;
import unam.fes.service.SemestreService;
import unam.fes.service.VueltaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping(value = "historicoAlta")
public class HistoricoAltaController {
    @Autowired
    ProfesorService profesorService;

    @Autowired
    VueltaService vueltaService;

    @Autowired
    MateriasService materiasService;

    @Autowired
    SemestreService semestreService;

    @Autowired
    HistoricoService historicoService;

    @GetMapping("alta-extra")
    public String altaExtra(Model model){

        HistoricoEntity historico = new HistoricoEntity();


        historico.setMateria(new MateriasEntity());
        historico.setSemestre(new SemestreEntity());
        historico.setVuelta(new VueltaEntity());
        historico.setSinodal1(new ProfesorEntity());
        historico.setSinodal2(new ProfesorEntity());

        model.addAttribute("historico", historico);
        model.addAttribute("sinodal1", profesorService.findAll());
        model.addAttribute("sinodal2", profesorService.findAll());
        model.addAttribute("vuelta", vueltaService.findAll());
        model.addAttribute("materia", materiasService.findAll());
        model.addAttribute("semestre", semestreService.findAll());

        model.addAttribute("contenido","Alta de Extraordinario");
        return "paginas/historico/alta-extra";
    }

    @PostMapping("guardar-Extra")
    public String guardarExtra(
        @Valid @ModelAttribute("historico") HistoricoEntity historico,
        BindingResult result,
        Model model) {

    if (historico.getMateria() == null || historico.getSemestre() == null ||
        historico.getSinodal1() == null || historico.getSinodal2() == null ||
        historico.getVuelta() == null){
        result.reject("", "Debe seleccionar todos los campos");
    }

    // 🔥 CAMBIO AQUÍ
    String idMateria = historico.getMateria().getClaveMateria();

    Long idSinodal1 = historico.getSinodal1().getId();
    Long idSinodal2 = historico.getSinodal2().getId();
    Long idVuelta = historico.getVuelta().getId();
    Long idSemestre = historico.getSemestre().getIdSemestre();

    // 🔥 SERVICE TAMBIÉN DEBE RECIBIR STRING
    MateriasEntity materia = materiasService.findById(idMateria);

    ProfesorEntity sinodal1 = profesorService.findById(idSinodal1);
    ProfesorEntity sinodal2 = profesorService.findById(idSinodal2);
    VueltaEntity vuelta = vueltaService.findById(idVuelta);
    SemestreEntity semestre = semestreService.findById(idSemestre);

    if (sinodal1 == null || sinodal2 == null || vuelta == null || semestre == null || materia == null){
        result.reject("", "Datos no encontrados");
    }

    if (result.hasErrors()) {

        model.addAttribute("sinodal1", profesorService.findAll());
        model.addAttribute("sinodal2", profesorService.findAll());
        model.addAttribute("vuelta", vueltaService.findAll());
        model.addAttribute("materia", materiasService.findAll());
        model.addAttribute("semestre", semestreService.findAll());

        return "paginas/historico/alta-extra";
    }

    historico.setMateria(materia);
    historico.setSinodal1(sinodal1);
    historico.setSinodal2(sinodal2);
    historico.setVuelta(vuelta);
    historico.setSemestre(semestre);

    historicoService.save(historico);

    model.addAttribute("contenido","Se almacenó con éxito");
    return "paginas/historico/alta-extra";
}

}
