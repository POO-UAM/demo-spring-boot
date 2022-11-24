package com.fbc.democlase.Controladores;

import com.fbc.democlase.Modelos.Departamento;
import com.fbc.democlase.Modelos.Profesor;
import com.fbc.democlase.Repositorios.RepositorioDepartamento;
import com.fbc.democlase.Repositorios.RepositorioProfesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/profesores")
public class ControladorProfesores {
    @Autowired
    private RepositorioProfesor miRepositorioProfesor;
    @Autowired
    private RepositorioDepartamento miRepositorioDepartamento;

    @GetMapping("")
    public List<Profesor> index(){
        return this.miRepositorioProfesor.findAll();
    }
    @GetMapping("{id}")
    public Profesor show(@PathVariable String id){
        Profesor ProfesorActual=this.miRepositorioProfesor
                .findById(id)
                .orElse(null);
        return ProfesorActual;
    }
    @PostMapping
    public Profesor create(@RequestBody Profesor infoProfesor){
        return this.miRepositorioProfesor.save(infoProfesor);
    }
    @PutMapping("{id}")
    public Profesor update(@PathVariable String id,@RequestBody Profesor infoProfesor){
        Profesor encontrado=this.miRepositorioProfesor
                .findById(id)
                .orElse(null);
        if (encontrado!=null){
            encontrado.setNombre(infoProfesor.getNombre());
            encontrado.setCedula(infoProfesor.getCedula());
            encontrado.setEmail(infoProfesor.getEmail());
            encontrado.setProfesion(infoProfesor.getProfesion());
            encontrado.setAnosExperiencia(infoProfesor.getAnosExperiencia());
            return this.miRepositorioProfesor.save(encontrado);
        }else{
            return null;
        }
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Profesor encontrado=this.miRepositorioProfesor
                .findById(id)
                .orElse(null);
        if (encontrado!=null){
            this.miRepositorioProfesor.delete(encontrado);
        }
    }
    @PutMapping("{id}/departamento/{id_departamento}")
    public Profesor asociarProfesorConDepartamento(@PathVariable String id,
                                                   @PathVariable String id_departamento){
    Profesor profesorEncontrado=this.miRepositorioProfesor.findById(id).orElse(null);
    Departamento departamentoEncontrado=this.miRepositorioDepartamento
                                                    .findById(id_departamento)
                                                    .orElse(null);
        if (profesorEncontrado!=null && departamentoEncontrado!=null){
            profesorEncontrado.setMiDepartamento(departamentoEncontrado);
            return this.miRepositorioProfesor.save(profesorEncontrado);
        }else{
            return null;
        }
    }
    @PutMapping("{id}/departamento/eliminar")
    public Profesor desasociarProfesorConDepartamento(@PathVariable String id){
        Profesor profesorEncontrado=this.miRepositorioProfesor.findById(id).orElse(null);
        if (profesorEncontrado!=null){
            profesorEncontrado.setMiDepartamento(null);
            return this.miRepositorioProfesor.save(profesorEncontrado);
        }else{
            return null;
        }
    }
}
