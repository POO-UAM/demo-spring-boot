package com.fbc.democlase.Controladores;

import com.fbc.democlase.Modelos.Estudiante;
import com.fbc.democlase.Repositorios.RepositorioEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/estudiantes")
public class ControladorEstudiantes {
    @Autowired
    private RepositorioEstudiante miRepositorioEstudiante;

    @GetMapping("")
    public List<Estudiante> index(){
        return this.miRepositorioEstudiante.findAll();
    }
    @GetMapping("{id}")
    public Estudiante show(@PathVariable String id){
        Estudiante EstudianteActual=this.miRepositorioEstudiante
                .findById(id)
                .orElse(null);
        return EstudianteActual;
    }
    @PostMapping
    public Estudiante create(@RequestBody Estudiante infoEstudiante){
        return this.miRepositorioEstudiante.save(infoEstudiante);
    }
    @PutMapping("{id}")
    public Estudiante update(@PathVariable String id,@RequestBody Estudiante infoEstudiante){
        Estudiante encontrado=this.miRepositorioEstudiante
                .findById(id)
                .orElse(null);
        if (encontrado!=null){
            encontrado.setNombre(infoEstudiante.getNombre());
            encontrado.setCedula(infoEstudiante.getCedula());
            encontrado.setEmail(infoEstudiante.getEmail());
            encontrado.setApellido(infoEstudiante.getApellido());
            encontrado.setInicialesDepartamento(infoEstudiante.getInicialesDepartamento());
            encontrado.setMunicipioResidencia(infoEstudiante.getMunicipioResidencia());
            return this.miRepositorioEstudiante.save(encontrado);
        }else{
            return null;
        }
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Estudiante encontrado=this.miRepositorioEstudiante
                .findById(id)
                .orElse(null);
        if (encontrado!=null){
            this.miRepositorioEstudiante.delete(encontrado);
        }
    }
}
