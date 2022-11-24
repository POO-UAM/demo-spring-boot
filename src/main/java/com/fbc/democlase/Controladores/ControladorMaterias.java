package com.fbc.democlase.Controladores;

import com.fbc.democlase.Modelos.Departamento;
import com.fbc.democlase.Modelos.Materia;
import com.fbc.democlase.Repositorios.RepositorioDepartamento;
import com.fbc.democlase.Repositorios.RepositorioMateria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/materias")
public class ControladorMaterias {
    @Autowired
    private RepositorioMateria miRepositorioMateria;
    @Autowired
    private RepositorioDepartamento miRepositorioDepartamento;


    @GetMapping("")
    public List<Materia> index(){
        return this.miRepositorioMateria.findAll();
    }
    @GetMapping("{id}")
    public Materia show(@PathVariable String id){
        Materia MateriaActual=this.miRepositorioMateria
                .findById(id)
                .orElse(null);
        return MateriaActual;
    }
    @PostMapping
    public Materia create(@RequestBody  Materia infoMateria){
        return this.miRepositorioMateria.save(infoMateria);
    }
    @PutMapping("{id}")
    public Materia update(@PathVariable String id,@RequestBody Materia infoMateria){
        Materia encontrado=this.miRepositorioMateria
                .findById(id)
                .orElse(null);
        if (encontrado!=null){
            encontrado.setInicialesMateria(infoMateria.getInicialesMateria());
            encontrado.setDescripcion(infoMateria.getDescripcion());
            return this.miRepositorioMateria.save(encontrado);
        }else{
            return null;
        }
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Materia encontrado=this.miRepositorioMateria
                .findById(id)
                .orElse(null);
        if (encontrado!=null){
            this.miRepositorioMateria.delete(encontrado);
        }
    }
    @PutMapping("{id}/departamentos/{id_departamento}")
    public Materia asociarMateriaADepartamento(@PathVariable String id,
                                               @PathVariable String id_departamento){
        Materia materiaEncontrada=this.miRepositorioMateria.findById(id).orElse(null);
        Departamento departamentoEncontrado=this.miRepositorioDepartamento
                                                    .findById(id_departamento)
                                                    .orElse(null);
        if(materiaEncontrada!=null && departamentoEncontrado!=null){
            materiaEncontrada.setMiDepartamento(departamentoEncontrado);
            return this.miRepositorioMateria.save(materiaEncontrada);
        }else{
            return null;
        }

    }
}
