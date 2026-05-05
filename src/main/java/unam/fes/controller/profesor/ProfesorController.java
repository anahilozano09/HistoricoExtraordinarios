package unam.fes.controller.profesor;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import unam.fes.model.entity.ProfesorEntity;
import unam.fes.service.ProfesorService;

import java.util.List;

@Controller
@RequestMapping(value = "profesor")
public class ProfesorController {
    @Autowired
    ProfesorService profesorService;

    /// /profesor/alta-profesor
    @GetMapping("alta-profesor")
    public String altaProfesor(Model model) {
        ProfesorEntity profesor = new ProfesorEntity();
        model.addAttribute("profesor", profesor);
        model.addAttribute("contenido", "Alta de profesor");
        return "paginas/profesor/alta-profesor";
    }

    /// /profesor/guardar-profesor
    @PostMapping("guardar-profesor")
    public String guardarProfesor(@Valid @ModelAttribute(value = "profesor") ProfesorEntity profesor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            for(ObjectError error : result.getAllErrors()) {
                System.out.println("Error: " + error.getDefaultMessage());
            }
            return "paginas/profesor/alta-profesor";
        }

        profesorService.save(profesor);
        model.addAttribute("contenido", "Se almaceno con exito");
        return "paginas/profesor/alta-profesor";

    }

    /// /profesor/lista-profesor
    @GetMapping("lista-profesor")
    public String listaProfesor(Model model){
        List<ProfesorEntity> lista=profesorService.findAll();
        model.addAttribute("lista",lista);
        model.addAttribute("contenido","Lista de Profesores");
        return "paginas/profesor/lista-profesor";
    }

    @GetMapping("eliminar-profesor/{id}")
    public String delete(@PathVariable("id")Long id,
                         Model model){
        profesorService.deleteById(id);
        return "redirect:/profesor/lista-profesor";

    }

    @GetMapping("modificar-profesor/{id}")
    public String modificar(@PathVariable("id")Long id,
                           Model model){
        ProfesorEntity profesor=profesorService.findById(id);
        model.addAttribute("profesor",profesor);
        model.addAttribute("contenido","Modificar profesor");
        return "paginas/profesor/alta-profesor";

    }
}
