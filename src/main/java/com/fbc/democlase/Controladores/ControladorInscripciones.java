package com.fbc.democlase.Controladores;

import com.fbc.democlase.Modelos.Estudiante;
import com.fbc.democlase.Modelos.Inscripcion;
import com.fbc.democlase.Modelos.Materia;
import com.fbc.democlase.Repositorios.RepositorioEstudiante;
import com.fbc.democlase.Repositorios.RepositorioInscripcion;
import com.fbc.democlase.Repositorios.RepositorioMateria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/inscripciones")
public class ControladorInscripciones {
    @Autowired
    private RepositorioInscripcion miRepositorioInscripcion;
    @Autowired
    private RepositorioEstudiante miRepositorioEstudiante;
    @Autowired
    private RepositorioMateria miRepositorioMateria;

    @GetMapping("")
    public List<Inscripcion> index(){
        return this.miRepositorioInscripcion.findAll();
    }
    @GetMapping("{id}")
    public Inscripcion show(@PathVariable String id){
        Inscripcion InscripcionActual=this.miRepositorioInscripcion
                .findById(id)
                .orElse(null);
        return InscripcionActual;
    }
    @PostMapping("estudiante/{id_estudiante}/materia/{id_materia}")
    public Inscripcion create(@RequestBody Inscripcion infoInscripcion,
                              @PathVariable String id_estudiante,
                              @PathVariable String id_materia){
        Estudiante elEstudiante=this.miRepositorioEstudiante.findById(id_estudiante).orElse(null);
        Materia laMateria=this.miRepositorioMateria.findById(id_materia).orElse(null);
        if(elEstudiante!=null && laMateria!=null){
            infoInscripcion.setMiEstudiante(elEstudiante);
            infoInscripcion.setMiMateria(laMateria);
            return this.miRepositorioInscripcion.save(infoInscripcion);
        }else{
            return null;
        }

    }
    @PutMapping("{id}/estudiante/{id_estudiante}/materia/{id_materia}")
    public Inscripcion update(@PathVariable String id,
                              @PathVariable String id_estudiante,
                              @PathVariable String id_materia,
                              @RequestBody Inscripcion infoInscripcion){
        Inscripcion encontrado=this.miRepositorioInscripcion
                                            .findById(id)
                                            .orElse(null);
        Estudiante elEstudiante=this.miRepositorioEstudiante.findById(id_estudiante).orElse(null);
        Materia laMateria=this.miRepositorioMateria.findById(id_materia).orElse(null);
        if (encontrado!=null && elEstudiante!=null && laMateria!=null){
            encontrado.setNotaFinal(infoInscripcion.getNotaFinal());
            encontrado.setSemestre(infoInscripcion.getSemestre());
            encontrado.setMiMateria(laMateria);
            encontrado.setMiEstudiante(elEstudiante);
            return this.miRepositorioInscripcion.save(encontrado);
        }else{
            return null;
        }
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Inscripcion encontrado=this.miRepositorioInscripcion
                .findById(id)
                .orElse(null);
        if (encontrado!=null){
            this.miRepositorioInscripcion.delete(encontrado);
        }
    }

}
