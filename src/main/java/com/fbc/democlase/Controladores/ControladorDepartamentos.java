package com.fbc.democlase.Controladores;

import com.fbc.democlase.Modelos.Departamento;
import com.fbc.democlase.Repositorios.RepositorioDepartamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/departamentos")

public class ControladorDepartamentos {
    @Autowired
    private RepositorioDepartamento miRepositorioDepartamento;

    @GetMapping("")
    public List<Departamento> index(){
        return this.miRepositorioDepartamento.findAll();
    }
    @GetMapping("{id}")
    public Departamento show(@PathVariable String id){
        Departamento departamentoActual=this.miRepositorioDepartamento
                                    .findById(id)
                                    .orElse(null);
        return departamentoActual;
    }
    @PostMapping
    public Departamento create(@RequestBody  Departamento infoDepartamento){
        return this.miRepositorioDepartamento.save(infoDepartamento);
    }
    @PutMapping("{id}")
    public Departamento update(@PathVariable String id,@RequestBody Departamento infoDepartamento){
        Departamento encontrado=this.miRepositorioDepartamento
                                            .findById(id)
                                            .orElse(null);
        if (encontrado!=null){
            encontrado.setNombre(infoDepartamento.getNombre());
            encontrado.setDescripcion(infoDepartamento.getDescripcion());
            return this.miRepositorioDepartamento.save(encontrado);
        }else{
            return null;
        }
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Departamento encontrado=this.miRepositorioDepartamento
                                        .findById(id)
                                        .orElse(null);
        if (encontrado!=null){
            this.miRepositorioDepartamento.delete(encontrado);
        }
    }

}
